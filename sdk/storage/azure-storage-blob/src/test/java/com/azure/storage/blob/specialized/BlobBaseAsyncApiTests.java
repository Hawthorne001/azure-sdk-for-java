// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.storage.blob.specialized;

import com.azure.core.test.utils.TestUtils;
import com.azure.core.util.FluxUtil;
import com.azure.storage.blob.BlobAsyncClient;
import com.azure.storage.blob.BlobServiceVersion;
import com.azure.storage.blob.BlobTestBase;
import com.azure.storage.blob.models.BlobProperties;
import com.azure.storage.blob.models.BlobQueryArrowField;
import com.azure.storage.blob.models.BlobQueryArrowFieldType;
import com.azure.storage.blob.models.BlobQueryArrowSerialization;
import com.azure.storage.blob.models.BlobQueryAsyncResponse;
import com.azure.storage.blob.models.BlobQueryDelimitedSerialization;
import com.azure.storage.blob.models.BlobQueryError;
import com.azure.storage.blob.models.BlobQueryJsonSerialization;
import com.azure.storage.blob.models.BlobQueryParquetSerialization;
import com.azure.storage.blob.models.BlobQueryProgress;
import com.azure.storage.blob.models.BlobQuerySerialization;
import com.azure.storage.blob.models.BlobRequestConditions;
import com.azure.storage.blob.models.BlobStorageException;
import com.azure.storage.blob.models.BlockBlobItem;
import com.azure.storage.blob.options.BlobQueryOptions;
import com.azure.storage.common.test.shared.extensions.LiveOnly;
import com.azure.storage.common.test.shared.extensions.RequiredServiceVersion;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;
import reactor.util.function.Tuple2;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.nio.ByteBuffer;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BlobBaseAsyncApiTests extends BlobTestBase {

    private BlobAsyncClient bc;

    @BeforeEach
    public void setup() {
        String blobName = generateBlobName();
        bc = ccAsync.getBlobAsyncClient(blobName);
        bc.upload(Flux.just(ByteBuffer.wrap(new byte[0])), null).block();
    }

    /* Quick Query Tests. */

    // Generates and uploads a CSV file
    private Mono<BlockBlobItem> uploadCsv(BlobQueryDelimitedSerialization s, int numCopies) {
        String header = String.join(String.valueOf(s.getColumnSeparator()), "rn1", "rn2", "rn3", "rn4")
            .concat(String.valueOf(s.getRecordSeparator()));
        byte[] headers = header.getBytes();

        String csv = String.join(String.valueOf(s.getColumnSeparator()), "100", "200", "300", "400")
            .concat(String.valueOf(s.getRecordSeparator()))
            .concat(String.join(String.valueOf(s.getColumnSeparator()), "300", "400", "500", "600")
                .concat(String.valueOf(s.getRecordSeparator())));

        byte[] csvData = csv.getBytes();
        int headerLength = s.isHeadersPresent() ? headers.length : 0;
        byte[] data = new byte[headerLength + csvData.length * numCopies];
        if (s.isHeadersPresent()) {
            System.arraycopy(headers, 0, data, 0, headers.length);
        }

        for (int i = 0; i < numCopies; i++) {
            int o = i * csvData.length + headerLength;
            System.arraycopy(csvData, 0, data, o, csvData.length);
        }

        Flux<ByteBuffer> uploadStream = Flux.just(ByteBuffer.wrap(data));
        return bc.upload(uploadStream, null, true);
    }

    private Mono<BlockBlobItem> uploadSmallJson(int numCopies) {
        StringBuilder b = new StringBuilder();
        b.append("{\n");
        for (int i = 0; i < numCopies; i++) {
            String toAppend = "\t\"name%d\": \"owner%d\",\n";
            b.append(String.format(toAppend, i, i));
        }
        b.append('}');

        Flux<ByteBuffer> uploadStream = Flux.just(ByteBuffer.wrap(b.toString().getBytes()));
        return bc.upload(uploadStream, null, true);
    }

    @RequiredServiceVersion(clazz = BlobServiceVersion.class, min = "2019-12-12")
    @ParameterizedTest
    @ValueSource(
        ints = {
            1, // 32 bytes
            32,  // 1 KB
            256, // 8 KB
            400, // 12 ish KB
            4000,  // 125 KB
        })
    public void queryMin(int numCopies) {
        BlobQueryDelimitedSerialization ser = new BlobQueryDelimitedSerialization().setRecordSeparator('\n')
            .setColumnSeparator(',')
            .setEscapeChar('\0')
            .setFieldQuote('\0')
            .setHeadersPresent(false);

        liveTestScenarioWithRetry(() -> {
            String expression = "SELECT * from BlobStorage";

            Mono<Tuple2<byte[], byte[]>> response
                = uploadCsv(ser, numCopies).then(Mono.zip(FluxUtil.collectBytesInByteBufferStream(bc.downloadStream()),
                    FluxUtil.collectBytesInByteBufferStream(bc.query(expression))));

            StepVerifier.create(response)
                .assertNext(r -> TestUtils.assertArraysEqual(r.getT1(), r.getT2()))
                .verifyComplete();
        });
    }

    @RequiredServiceVersion(clazz = BlobServiceVersion.class, min = "2019-12-12")
    @ParameterizedTest
    @MethodSource("queryCsvSerializationSeparatorSupplier")
    public void queryCsvSerializationSeparator(char recordSeparator, char columnSeparator, boolean headersPresentIn,
        boolean headersPresentOut) {
        BlobQueryDelimitedSerialization serIn
            = new BlobQueryDelimitedSerialization().setRecordSeparator(recordSeparator)
                .setColumnSeparator(columnSeparator)
                .setEscapeChar('\0')
                .setFieldQuote('\0')
                .setHeadersPresent(headersPresentIn);
        BlobQueryDelimitedSerialization serOut
            = new BlobQueryDelimitedSerialization().setRecordSeparator(recordSeparator)
                .setColumnSeparator(columnSeparator)
                .setEscapeChar('\0')
                .setFieldQuote('\0')
                .setHeadersPresent(headersPresentOut);
        String expression = "SELECT * from BlobStorage";

        liveTestScenarioWithRetry(() -> {
            Mono<Tuple2<byte[], byte[]>> response
                = uploadCsv(serIn, 32).then(Mono.zip(FluxUtil.collectBytesInByteBufferStream(bc.downloadStream()),
                    bc.queryWithResponse(
                        new BlobQueryOptions(expression).setInputSerialization(serIn).setOutputSerialization(serOut))
                        .flatMap(piece -> FluxUtil.collectBytesInByteBufferStream(piece.getValue()))));

            /* Output Stream. */
            StepVerifier.create(response).assertNext(r -> {
                if (headersPresentIn && !headersPresentOut) {
                    assertEquals(r.getT1().length - 16, r.getT2().length);

                    /* Account for 16 bytes of header. */
                    TestUtils.assertArraysEqual(r.getT1(), 16, r.getT2(), 0, r.getT1().length - 16);
                } else {
                    TestUtils.assertArraysEqual(r.getT1(), r.getT2());
                }
            }).verifyComplete();
        });
    }

    private static Stream<Arguments> queryCsvSerializationSeparatorSupplier() {
        return Stream.of(Arguments.of('\n', ',', false, false), /* Default. */
            Arguments.of('\n', ',', true, true), /* Headers. */
            Arguments.of('\n', ',', true, false), /* Headers. */
            Arguments.of('\t', ',', false, false), /* Record separator. */
            Arguments.of('\r', ',', false, false), Arguments.of('<', ',', false, false),
            Arguments.of('>', ',', false, false), Arguments.of('&', ',', false, false),
            Arguments.of('\\', ',', false, false), Arguments.of(',', '.', false, false), /* Column separator. */
            //            Arguments.of(',', '\n', false, false), /* Keep getting a qq error: Field delimiter and record delimiter must be different characters. */
            Arguments.of(',', ';', false, false), Arguments.of('\n', '\t', false, false), /* Record separator. */
            //            Arguments.of('\n', '\r', false, false), /* Keep getting a qq error: Field delimiter and record delimiter must be different characters. */
            Arguments.of('\n', '<', false, false), Arguments.of('\n', '>', false, false),
            Arguments.of('\n', '&', false, false), Arguments.of('\n', '\\', false, false));
    }

    @RequiredServiceVersion(clazz = BlobServiceVersion.class, min = "2019-12-12")
    @Test
    public void queryCsvSerializationEscapeAndFieldQuote() {
        BlobQueryDelimitedSerialization ser = new BlobQueryDelimitedSerialization().setRecordSeparator('\n')
            .setColumnSeparator(',')
            .setEscapeChar('\\') /* Escape set here. */
            .setFieldQuote('"') /* Field quote set here*/
            .setHeadersPresent(false);
        String expression = "SELECT * from BlobStorage";

        liveTestScenarioWithRetry(() -> {
            Mono<Tuple2<byte[], byte[]>> response
                = uploadCsv(ser, 32).then(Mono.zip(FluxUtil.collectBytesInByteBufferStream(bc.downloadStream()),
                    bc.queryWithResponse(
                        new BlobQueryOptions(expression).setInputSerialization(ser).setOutputSerialization(ser))
                        .flatMap(piece -> FluxUtil.collectBytesInByteBufferStream(piece.getValue()))));

            StepVerifier.create(response)
                .assertNext(r -> TestUtils.assertArraysEqual(r.getT1(), r.getT2()))
                .verifyComplete();
        });
    }

    /* Note: Input delimited tested everywhere */
    @RequiredServiceVersion(clazz = BlobServiceVersion.class, min = "2019-12-12")
    @ParameterizedTest
    @ValueSource(ints = { 1, 10, 100, 1000 })
    public void queryInputJson(int numCopies) {
        BlobQueryJsonSerialization ser = new BlobQueryJsonSerialization().setRecordSeparator('\n');
        String expression = "SELECT * from BlobStorage";

        liveTestScenarioWithRetry(() -> {
            ByteArrayOutputStream downloadData = new ByteArrayOutputStream();
            BlobQueryOptions options
                = new BlobQueryOptions(expression).setInputSerialization(ser).setOutputSerialization(ser);

            Mono<byte[]> response
                = uploadSmallJson(numCopies).then(FluxUtil.writeToOutputStream(bc.downloadStream(), downloadData))
                    .then(bc.queryWithResponse(options))
                    .flatMap(piece -> FluxUtil.collectBytesInByteBufferStream(piece.getValue()));

            StepVerifier.create(response).assertNext(r -> {
                downloadData.write(10);
                byte[] downloadedData = downloadData.toByteArray();
                TestUtils.assertArraysEqual(downloadedData, r);
            }).verifyComplete();
        });
    }

    @RequiredServiceVersion(clazz = BlobServiceVersion.class, min = "2020-10-02")
    @Test
    public void queryInputParquet() {
        String fileName = "parquet.parquet";
        ClassLoader classLoader = getClass().getClassLoader();
        File f = new File(Objects.requireNonNull(classLoader.getResource(fileName)).getFile());
        BlobQueryParquetSerialization ser = new BlobQueryParquetSerialization();
        byte[] expectedData = "0,mdifjt55.ea3,mdifjt55.ea3\n".getBytes();

        String expression = "select * from blobstorage where id < 1;";

        BlobQueryOptions optionsOs = new BlobQueryOptions(expression).setInputSerialization(ser);

        liveTestScenarioWithRetry(() -> StepVerifier
            .create(bc.uploadFromFile(f.getAbsolutePath(), true)
                .then(bc.queryWithResponse(optionsOs)
                    .flatMap(piece -> FluxUtil.collectBytesInByteBufferStream(piece.getValue()))))
            .assertNext(r -> TestUtils.assertArraysEqual(expectedData, r))
            .verifyComplete());
    }

    @RequiredServiceVersion(clazz = BlobServiceVersion.class, min = "2019-12-12")
    @Test
    public void queryInputCsvOutputJson() {
        BlobQueryDelimitedSerialization inSer = new BlobQueryDelimitedSerialization().setRecordSeparator('\n')
            .setColumnSeparator(',')
            .setEscapeChar('\0')
            .setFieldQuote('\0')
            .setHeadersPresent(false);
        BlobQueryJsonSerialization outSer = new BlobQueryJsonSerialization().setRecordSeparator('\n');
        String expression = "SELECT * from BlobStorage";
        byte[] expectedData = "{\"_1\":\"100\",\"_2\":\"200\",\"_3\":\"300\",\"_4\":\"400\"}".getBytes();
        BlobQueryOptions options
            = new BlobQueryOptions(expression).setInputSerialization(inSer).setOutputSerialization(outSer);

        liveTestScenarioWithRetry(() -> StepVerifier
            .create(uploadCsv(inSer, 1).then(bc.queryWithResponse(options)
                .flatMap(piece -> FluxUtil.collectBytesInByteBufferStream(piece.getValue()))))
            .assertNext(r -> TestUtils.assertArraysEqual(expectedData, 0, r, 0, expectedData.length))
            .verifyComplete());
    }

    @RequiredServiceVersion(clazz = BlobServiceVersion.class, min = "2019-12-12")
    @Test
    public void queryInputJsonOutputCsv() {
        BlobQueryJsonSerialization inSer = new BlobQueryJsonSerialization().setRecordSeparator('\n');
        BlobQueryDelimitedSerialization outSer = new BlobQueryDelimitedSerialization().setRecordSeparator('\n')
            .setColumnSeparator(',')
            .setEscapeChar('\0')
            .setFieldQuote('\0')
            .setHeadersPresent(false);
        String expression = "SELECT * from BlobStorage";
        byte[] expectedData = "owner0,owner1\n".getBytes();
        BlobQueryOptions options
            = new BlobQueryOptions(expression).setInputSerialization(inSer).setOutputSerialization(outSer);

        liveTestScenarioWithRetry(() -> StepVerifier
            .create(uploadSmallJson(2).then(bc.queryWithResponse(options))
                .flatMap(piece -> FluxUtil.collectBytesInByteBufferStream(piece.getValue())))
            .assertNext(r -> TestUtils.assertArraysEqual(expectedData, 0, r, 0, expectedData.length))
            .verifyComplete());
    }

    @RequiredServiceVersion(clazz = BlobServiceVersion.class, min = "2019-12-12")
    @Test
    public void queryInputCsvOutputArrow() {
        BlobQueryDelimitedSerialization inSer = new BlobQueryDelimitedSerialization().setRecordSeparator('\n')
            .setColumnSeparator(',')
            .setEscapeChar('\0')
            .setFieldQuote('\0')
            .setHeadersPresent(false);

        liveTestScenarioWithRetry(() -> {
            List<BlobQueryArrowField> schema = new ArrayList<>();
            schema.add(
                new BlobQueryArrowField(BlobQueryArrowFieldType.DECIMAL).setName("Name").setPrecision(4).setScale(2));
            BlobQueryArrowSerialization outSer = new BlobQueryArrowSerialization().setSchema(schema);
            String expression = "SELECT _2 from BlobStorage WHERE _1 > 250;";
            BlobQueryOptions options = new BlobQueryOptions(expression).setOutputSerialization(outSer);

            StepVerifier.create(uploadCsv(inSer, 32).then(bc.queryWithResponse(options)))
                .expectNextCount(1)
                .verifyComplete();
        });
    }

    @RequiredServiceVersion(clazz = BlobServiceVersion.class, min = "2019-12-12")
    @Test
    public void queryNonFatalError() {
        BlobQueryDelimitedSerialization base = new BlobQueryDelimitedSerialization().setRecordSeparator('\n')
            .setEscapeChar('\0')
            .setFieldQuote('\0')
            .setHeadersPresent(false);
        String expression = "SELECT _1 from BlobStorage WHERE _2 > 250";

        liveTestScenarioWithRetry(() -> {
            MockErrorConsumer receiver2 = new MockErrorConsumer("InvalidColumnOrdinal");
            BlobQueryOptions options2
                = new BlobQueryOptions(expression).setInputSerialization(base.setColumnSeparator(','))
                    .setOutputSerialization(base.setColumnSeparator(','))
                    .setErrorConsumer(receiver2);

            StepVerifier.create(uploadCsv(base.setColumnSeparator('.'), 32).then(bc.queryWithResponse(options2)))
                .expectNextCount(1)
                .verifyComplete();

            assertDoesNotThrow(() -> receiver2.numErrors > 0);
        });
    }

    @RequiredServiceVersion(clazz = BlobServiceVersion.class, min = "2019-12-12")
    @Test
    public void queryFatalError() {
        BlobQueryDelimitedSerialization base = new BlobQueryDelimitedSerialization().setRecordSeparator('\n')
            .setEscapeChar('\0')
            .setFieldQuote('\0')
            .setHeadersPresent(true);
        String expression = "SELECT * from BlobStorage";
        BlobQueryOptions options
            = new BlobQueryOptions(expression).setInputSerialization(new BlobQueryJsonSerialization());

        liveTestScenarioWithRetry(() -> StepVerifier
            .create(uploadCsv(base.setColumnSeparator('.'), 32).then(
                bc.queryWithResponse(options).flatMap(r -> FluxUtil.collectBytesInByteBufferStream(r.getValue()))))
            .verifyError(Throwable.class));
    }

    @RequiredServiceVersion(clazz = BlobServiceVersion.class, min = "2019-12-12")
    @Test
    public void queryProgressReceiver() {
        BlobQueryDelimitedSerialization base = new BlobQueryDelimitedSerialization().setRecordSeparator('\n')
            .setEscapeChar('\0')
            .setFieldQuote('\0')
            .setHeadersPresent(false);

        String expression = "SELECT * from BlobStorage";

        liveTestScenarioWithRetry(() -> {
            MockProgressConsumer mockReceiver2 = new MockProgressConsumer();
            BlobQueryOptions options2 = new BlobQueryOptions(expression).setProgressConsumer(mockReceiver2);

            Mono<Tuple2<BlobProperties, byte[]>> response = uploadCsv(base.setColumnSeparator('.'), 32).then(Mono.zip(
                bc.getProperties(),
                bc.queryWithResponse(options2).flatMap(r -> FluxUtil.collectBytesInByteBufferStream(r.getValue()))));

            StepVerifier.create(response)
                .assertNext(r -> assertTrue(mockReceiver2.progressList.contains(r.getT1().getBlobSize())))
                .verifyComplete();
        });
    }

    @RequiredServiceVersion(clazz = BlobServiceVersion.class, min = "2019-12-12")
    @LiveOnly // Large amounts of data
    @Test
    public void queryMultipleRecordsWithProgressReceiver() {
        BlobQueryDelimitedSerialization ser = new BlobQueryDelimitedSerialization().setRecordSeparator('\n')
            .setColumnSeparator(',')
            .setEscapeChar('\0')
            .setFieldQuote('\0')
            .setHeadersPresent(false);

        String expression = "SELECT * from BlobStorage";

        liveTestScenarioWithRetry(() -> {
            MockProgressConsumer mockReceiver2 = new MockProgressConsumer();
            long temp = 0;
            BlobQueryOptions options2 = new BlobQueryOptions(expression).setProgressConsumer(mockReceiver2);

            StepVerifier.create(uploadCsv(ser, 512000).then(bc.queryWithResponse(options2)))
                .expectNextCount(1)
                .verifyComplete();

            // Make sure theyre all increasingly bigger
            for (long progress : mockReceiver2.progressList) {
                assertTrue(progress >= temp);
                temp = progress;
            }
        });
    }

    @SuppressWarnings("deprecation")
    @RequiredServiceVersion(clazz = BlobServiceVersion.class, min = "2019-12-12")
    @Test
    public void querySnapshot() {
        BlobQueryDelimitedSerialization ser = new BlobQueryDelimitedSerialization().setRecordSeparator('\n')
            .setColumnSeparator(',')
            .setEscapeChar('\0')
            .setFieldQuote('\0')
            .setHeadersPresent(false);
        String expression = "SELECT * from BlobStorage";

        Mono<Tuple2<byte[], byte[]>> response = uploadCsv(ser, 32).then(bc.createSnapshot())
            .flatMap(r -> bc.upload(Flux.just(ByteBuffer.wrap(new byte[0])), null, true)
                .then(Mono.zip(FluxUtil.collectBytesInByteBufferStream(r.download()),
                    FluxUtil.collectBytesInByteBufferStream(r.query(expression)))));

        liveTestScenarioWithRetry(() -> StepVerifier.create(response)
            .assertNext(r -> TestUtils.assertArraysEqual(r.getT1(), r.getT2()))
            .verifyComplete());
    }

    @RequiredServiceVersion(clazz = BlobServiceVersion.class, min = "2019-12-12")
    @ParameterizedTest
    @CsvSource({ "true, false", "false, true" })
    public void queryInputOutputIA(boolean input, boolean output) {
        /* Mock random impl of QQ Serialization*/
        BlobQuerySerialization ser = new RandomOtherSerialization();
        BlobQuerySerialization inSer = input ? ser : null;
        BlobQuerySerialization outSer = output ? ser : null;
        String expression = "SELECT * from BlobStorage";
        BlobQueryOptions options
            = new BlobQueryOptions(expression).setInputSerialization(inSer).setOutputSerialization(outSer);

        liveTestScenarioWithRetry(
            () -> StepVerifier.create(bc.queryWithResponse(options)).verifyError(IllegalArgumentException.class));
    }

    private static class RandomOtherSerialization implements BlobQuerySerialization {

    }

    @RequiredServiceVersion(clazz = BlobServiceVersion.class, min = "2019-12-12")
    @Test
    public void queryArrowInputIA() {
        BlobQueryArrowSerialization inSer = new BlobQueryArrowSerialization();
        String expression = "SELECT * from BlobStorage";

        liveTestScenarioWithRetry(() -> {
            BlobQueryOptions options2 = new BlobQueryOptions(expression).setInputSerialization(inSer);
            StepVerifier.create(bc.queryWithResponse(options2)).verifyError(IllegalArgumentException.class);
        });
    }

    @RequiredServiceVersion(clazz = BlobServiceVersion.class, min = "2020-10-02")
    @Test
    public void queryParquetOutputIA() {
        BlobQueryParquetSerialization outSer = new BlobQueryParquetSerialization();
        String expression = "SELECT * from BlobStorage";

        liveTestScenarioWithRetry(() -> {
            BlobQueryOptions options2 = new BlobQueryOptions(expression).setOutputSerialization(outSer);
            StepVerifier.create(bc.queryWithResponse(options2)).verifyError(IllegalArgumentException.class);
        });
    }

    @RequiredServiceVersion(clazz = BlobServiceVersion.class, min = "2019-12-12")
    @Test
    public void queryError() {
        liveTestScenarioWithRetry(() -> {
            bc = ccAsync.getBlobAsyncClient(generateBlobName());

            StepVerifier.create(bc.query("SELECT * from BlobStorage")).verifyError(BlobStorageException.class);
        });
    }

    @RequiredServiceVersion(clazz = BlobServiceVersion.class, min = "2019-12-12")
    @ParameterizedTest
    @MethodSource("queryACSupplier")
    public void queryAC(OffsetDateTime modified, OffsetDateTime unmodified, String match, String noneMatch,
        String leaseID, String tags) {
        Map<String, String> t = new HashMap<>();
        t.put("foo", "bar");

        Mono<BlobQueryAsyncResponse> response = bc.setTags(t)
            .then(Mono.zip(setupBlobLeaseCondition(bc, leaseID), setupBlobMatchCondition(bc, match),
                BlobTestBase::convertNulls))
            .flatMap(conditions -> {
                BlobRequestConditions bac = new BlobRequestConditions().setLeaseId(conditions.get(0))
                    .setIfMatch(conditions.get(1))
                    .setIfNoneMatch(noneMatch)
                    .setIfModifiedSince(modified)
                    .setIfUnmodifiedSince(unmodified)
                    .setTagsConditions(tags);

                String expression = "SELECT * from BlobStorage";
                BlobQueryOptions optionsOs = new BlobQueryOptions(expression).setRequestConditions(bac);
                return bc.queryWithResponse(optionsOs);
            });

        liveTestScenarioWithRetry(() -> StepVerifier.create(response).expectNextCount(1).verifyComplete());
    }

    private static Stream<Arguments> queryACSupplier() {
        return Stream.of(Arguments.of(null, null, null, null, null, null),
            Arguments.of(OLD_DATE, null, null, null, null, null), Arguments.of(null, NEW_DATE, null, null, null, null),
            Arguments.of(null, null, RECEIVED_ETAG, null, null, null),
            Arguments.of(null, null, null, null, RECEIVED_LEASE_ID, null),
            Arguments.of(null, null, null, null, null, "\"foo\" = 'bar'"));
    }

    @RequiredServiceVersion(clazz = BlobServiceVersion.class, min = "2019-12-12")
    @ParameterizedTest
    @MethodSource("com.azure.storage.blob.BlobTestBase#allConditionsFailSupplier")
    public void queryACFail(OffsetDateTime modified, OffsetDateTime unmodified, String match, String noneMatch,
        String leaseID, String tags) {
        Mono<BlobQueryAsyncResponse> response
            = Mono
                .zip(setupBlobLeaseCondition(bc, leaseID), setupBlobMatchCondition(bc, noneMatch),
                    BlobTestBase::convertNulls)
                .flatMap(conditions -> {
                    BlobRequestConditions bac = new BlobRequestConditions().setLeaseId(leaseID)
                        .setIfMatch(match)
                        .setIfNoneMatch(conditions.get(1))
                        .setIfModifiedSince(modified)
                        .setIfUnmodifiedSince(unmodified)
                        .setTagsConditions(tags);

                    String expression = "SELECT * from BlobStorage";
                    BlobQueryOptions optionsOs = new BlobQueryOptions(expression).setRequestConditions(bac);

                    return bc.queryWithResponse(optionsOs);
                });

        StepVerifier.create(response).verifyError(BlobStorageException.class);
    }

    @RequiredServiceVersion(clazz = BlobServiceVersion.class, min = "2024-08-04")
    @Test
    public void copyFromURLSourceErrorAndStatusCode() {
        BlockBlobAsyncClient destBlob = ccAsync.getBlobAsyncClient(generateBlobName()).getBlockBlobAsyncClient();

        StepVerifier.create(destBlob.copyFromUrl(bc.getBlobUrl())).verifyErrorSatisfies(r -> {
            BlobStorageException e = assertInstanceOf(BlobStorageException.class, r);
            assertTrue(e.getStatusCode() == 401);
            assertTrue(e.getServiceMessage().contains("NoAuthenticationInformation"));
            assertTrue(e.getServiceMessage()
                .contains(
                    "Server failed to authenticate the request. Please refer to the information in the www-authenticate header."));

        });
    }

    static class MockProgressConsumer implements Consumer<BlobQueryProgress> {

        List<Long> progressList;

        MockProgressConsumer() {
            this.progressList = new ArrayList<>();
        }

        @Override
        public void accept(BlobQueryProgress progress) {
            progressList.add(progress.getBytesScanned());
        }
    }

    static class MockErrorConsumer implements Consumer<BlobQueryError> {

        String expectedType;
        int numErrors;

        MockErrorConsumer(String expectedType) {
            this.expectedType = expectedType;
            this.numErrors = 0;
        }

        @Override
        public void accept(BlobQueryError nonFatalError) {
            assertFalse(nonFatalError.isFatal());
            assertEquals(nonFatalError.getName(), expectedType);
            numErrors++;
        }
    }

}
