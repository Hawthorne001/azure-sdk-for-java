// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.cosmos.implementation.directconnectivity;

import com.azure.cosmos.BridgeInternal;
import com.azure.cosmos.CosmosException;
import com.azure.cosmos.implementation.BadRequestException;
import com.azure.cosmos.implementation.GoneException;
import com.azure.cosmos.implementation.HttpConstants;
import com.azure.cosmos.implementation.InvalidPartitionException;
import com.azure.cosmos.implementation.OperationType;
import com.azure.cosmos.implementation.PartitionIsMigratingException;
import com.azure.cosmos.implementation.PartitionKeyRangeIsSplittingException;
import com.azure.cosmos.implementation.RequestTimeoutException;
import com.azure.cosmos.implementation.ResourceType;
import com.azure.cosmos.implementation.RetryWithException;
import com.azure.cosmos.implementation.RxDocumentServiceRequest;
import com.azure.cosmos.implementation.ShouldRetryResult;
import com.azure.cosmos.implementation.guava25.base.Supplier;
import com.azure.cosmos.implementation.RetryWithException;
import org.mockito.Mockito;
import org.testng.annotations.Test;
import reactor.core.publisher.Mono;

import java.time.Duration;

import static com.azure.cosmos.implementation.TestUtils.mockDiagnosticsClientContext;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * This test file will cover various exception on GoneAndRetryWithRetryPolicy.
 *
 */
public class GoneAndRetryWithRetryPolicyTest {
    protected static final int TIMEOUT = 60000;

    /**
     * Retry with GoneException for read, retried 4 times and verified the returned
     * shouldRetryResult. ShouldRetryResult
     */
    @Test(groups = { "unit" }, timeOut = TIMEOUT)
    public void shouldRetryReadWithGoneException() {
        RxDocumentServiceRequest request = RxDocumentServiceRequest.create(
            mockDiagnosticsClientContext(),
            OperationType.Read,
            ResourceType.Document);
        GoneAndRetryWithRetryPolicy goneAndRetryWithRetryPolicy = new GoneAndRetryWithRetryPolicy(request, 30);
        Mono<ShouldRetryResult> singleShouldRetry = goneAndRetryWithRetryPolicy
                .shouldRetry(new GoneException());
        ShouldRetryResult shouldRetryResult = singleShouldRetry.block();
        assertThat(shouldRetryResult.shouldRetry).isTrue();
        assertThat(shouldRetryResult.policyArg.getValue0()).isTrue();
        assertThat(shouldRetryResult.policyArg.getValue3()).isEqualTo(1);
        assertThat(shouldRetryResult.backOffTime.getSeconds()).isEqualTo(0);

        singleShouldRetry = goneAndRetryWithRetryPolicy.shouldRetry(new GoneException());
        shouldRetryResult = singleShouldRetry.block();
        assertThat(shouldRetryResult.shouldRetry).isTrue();
        assertThat(shouldRetryResult.policyArg.getValue0()).isTrue();
        assertThat(shouldRetryResult.policyArg.getValue3()).isEqualTo(2);
        assertThat(shouldRetryResult.backOffTime.getSeconds()).isEqualTo(1);

        singleShouldRetry = goneAndRetryWithRetryPolicy.shouldRetry(new GoneException());
        shouldRetryResult = singleShouldRetry.block();
        assertThat(shouldRetryResult.shouldRetry).isTrue();
        assertThat(shouldRetryResult.policyArg.getValue0()).isTrue();
        assertThat(shouldRetryResult.policyArg.getValue3()).isEqualTo(3);
        assertThat(shouldRetryResult.backOffTime.getSeconds()).isEqualTo(2);

        singleShouldRetry = goneAndRetryWithRetryPolicy.shouldRetry(new GoneException());
        shouldRetryResult = singleShouldRetry.block();
        assertThat(shouldRetryResult.shouldRetry).isTrue();
        assertThat(shouldRetryResult.policyArg.getValue0()).isTrue();
        assertThat(shouldRetryResult.policyArg.getValue3()).isEqualTo(4);
        assertThat(shouldRetryResult.backOffTime.getSeconds()).isEqualTo(4);
    }

    /**
     * Retry with GoneException for write which is not yet sent to the wire,
     * retried 4 times and verified the returned
     * shouldRetryResult. ShouldRetryResult
     */
    @Test(groups = { "unit" }, timeOut = TIMEOUT)
    public void shouldRetryNotYetFlushedWriteWithGoneException() {
        RxDocumentServiceRequest request = RxDocumentServiceRequest.create(
            mockDiagnosticsClientContext(),
            OperationType.Create,
            ResourceType.Document);
        GoneAndRetryWithRetryPolicy goneAndRetryWithRetryPolicy = new GoneAndRetryWithRetryPolicy(request, 30);

        Supplier<GoneException> goneExceptionForNotYetFlushedRequestSupplier = () -> {
            GoneException goneExceptionForNotYetFlushedRequest = new GoneException();
            BridgeInternal.setSendingRequestStarted(goneExceptionForNotYetFlushedRequest, false);

            return goneExceptionForNotYetFlushedRequest;
        };

        Mono<ShouldRetryResult> singleShouldRetry = goneAndRetryWithRetryPolicy
            .shouldRetry(goneExceptionForNotYetFlushedRequestSupplier.get());
        ShouldRetryResult shouldRetryResult = singleShouldRetry.block();
        assertThat(shouldRetryResult.shouldRetry).isTrue();
        assertThat(shouldRetryResult.policyArg.getValue0()).isTrue();
        assertThat(shouldRetryResult.policyArg.getValue3()).isEqualTo(1);
        assertThat(shouldRetryResult.backOffTime.getSeconds()).isEqualTo(0);

        singleShouldRetry = goneAndRetryWithRetryPolicy.shouldRetry(goneExceptionForNotYetFlushedRequestSupplier.get());
        shouldRetryResult = singleShouldRetry.block();
        assertThat(shouldRetryResult.shouldRetry).isTrue();
        assertThat(shouldRetryResult.policyArg.getValue0()).isTrue();
        assertThat(shouldRetryResult.policyArg.getValue3()).isEqualTo(2);
        assertThat(shouldRetryResult.backOffTime.getSeconds()).isEqualTo(1);

        singleShouldRetry = goneAndRetryWithRetryPolicy.shouldRetry(goneExceptionForNotYetFlushedRequestSupplier.get());
        shouldRetryResult = singleShouldRetry.block();
        assertThat(shouldRetryResult.shouldRetry).isTrue();
        assertThat(shouldRetryResult.policyArg.getValue0()).isTrue();
        assertThat(shouldRetryResult.policyArg.getValue3()).isEqualTo(3);
        assertThat(shouldRetryResult.backOffTime.getSeconds()).isEqualTo(2);

        singleShouldRetry = goneAndRetryWithRetryPolicy.shouldRetry(goneExceptionForNotYetFlushedRequestSupplier.get());
        shouldRetryResult = singleShouldRetry.block();
        assertThat(shouldRetryResult.shouldRetry).isTrue();
        assertThat(shouldRetryResult.policyArg.getValue0()).isTrue();
        assertThat(shouldRetryResult.policyArg.getValue3()).isEqualTo(4);
        assertThat(shouldRetryResult.backOffTime.getSeconds()).isEqualTo(4);
    }

    /**
     * GoneException for write which is already sent to the wire, should not result in retry,
     * but an address refresh should be triggered
     * shouldRetryResult. ShouldRetryResult
     */
    @Test(groups = { "unit" }, timeOut = TIMEOUT)
    public void shouldNotRetryFlushedWriteWithGoneExceptionButForceAddressRefresh() {
        RxDocumentServiceRequest request = RxDocumentServiceRequest.create(
            mockDiagnosticsClientContext(),
            OperationType.Create,
            ResourceType.Document);

        Supplier<GoneException> goneExceptionForFlushedRequestSupplier = () -> {
            GoneException goneExceptionForFlushedRequest = new GoneException();
            BridgeInternal.setSendingRequestStarted(goneExceptionForFlushedRequest, true);

            return goneExceptionForFlushedRequest;
        };

        GoneAndRetryWithRetryPolicy goneAndRetryWithRetryPolicy = new GoneAndRetryWithRetryPolicy(request, 30);
        Mono<ShouldRetryResult> singleShouldRetry = goneAndRetryWithRetryPolicy
            .shouldRetry(goneExceptionForFlushedRequestSupplier.get());
        ShouldRetryResult shouldRetryResult = singleShouldRetry.block();

        assertThat(shouldRetryResult.shouldRetry).isFalse();
        assertThat(shouldRetryResult.policyArg).isNotNull();
        assertThat(shouldRetryResult.policyArg.getValue0()).isTrue();
        assertThat(shouldRetryResult.backOffTime).isNull();
    }

    /**
     * GoneException for write which is already sent to the wire but based on receiving
     * an actual response from the Service with 410 Status Code and SubStatusCode 0
     * should result in retry
     * shouldRetryResult. ShouldRetryResult
     */
    @Test(groups = { "unit" }, timeOut = TIMEOUT)
    public void shouldRetryFlushedWriteWithGoneExceptionFromService() {
        RxDocumentServiceRequest request = RxDocumentServiceRequest.create(
            mockDiagnosticsClientContext(),
            OperationType.Create,
            ResourceType.Document);
        GoneAndRetryWithRetryPolicy goneAndRetryWithRetryPolicy =
            new GoneAndRetryWithRetryPolicy(request, 30);

        Supplier<GoneException> goneExceptionForFlushedRequestSupplier = () -> {
            GoneException goneExceptionForFlushedRequest = new GoneException();
            BridgeInternal.setSendingRequestStarted(goneExceptionForFlushedRequest, true);
            goneExceptionForFlushedRequest.setIsBasedOn410ResponseFromService();
            return goneExceptionForFlushedRequest;
        };

        Mono<ShouldRetryResult> singleShouldRetry = goneAndRetryWithRetryPolicy
            .shouldRetry(goneExceptionForFlushedRequestSupplier.get());
        ShouldRetryResult shouldRetryResult = singleShouldRetry.block();
        assertThat(shouldRetryResult.shouldRetry).isTrue();
        assertThat(shouldRetryResult.policyArg.getValue0()).isTrue();
        assertThat(shouldRetryResult.policyArg.getValue3()).isEqualTo(1);
        assertThat(shouldRetryResult.backOffTime.getSeconds()).isEqualTo(0);

        singleShouldRetry = goneAndRetryWithRetryPolicy.shouldRetry(goneExceptionForFlushedRequestSupplier.get());
        shouldRetryResult = singleShouldRetry.block();
        assertThat(shouldRetryResult.shouldRetry).isTrue();
        assertThat(shouldRetryResult.policyArg.getValue0()).isTrue();
        assertThat(shouldRetryResult.policyArg.getValue3()).isEqualTo(2);
        assertThat(shouldRetryResult.backOffTime.getSeconds()).isEqualTo(1);

        singleShouldRetry = goneAndRetryWithRetryPolicy.shouldRetry(goneExceptionForFlushedRequestSupplier.get());
        shouldRetryResult = singleShouldRetry.block();
        assertThat(shouldRetryResult.shouldRetry).isTrue();
        assertThat(shouldRetryResult.policyArg.getValue0()).isTrue();
        assertThat(shouldRetryResult.policyArg.getValue3()).isEqualTo(3);
        assertThat(shouldRetryResult.backOffTime.getSeconds()).isEqualTo(2);

        singleShouldRetry = goneAndRetryWithRetryPolicy.shouldRetry(goneExceptionForFlushedRequestSupplier.get());
        shouldRetryResult = singleShouldRetry.block();
        assertThat(shouldRetryResult.shouldRetry).isTrue();
        assertThat(shouldRetryResult.policyArg.getValue0()).isTrue();
        assertThat(shouldRetryResult.policyArg.getValue3()).isEqualTo(4);
        assertThat(shouldRetryResult.backOffTime.getSeconds()).isEqualTo(4);
    }

    /**
     * RequestTimeoutExceptions should not be retried for read or write - no address cache refresh expected
     * shouldRetryResult. ShouldRetryResult
     */
    @Test(groups = { "unit" }, timeOut = TIMEOUT)
    public void shouldNotRetryRequestTimeoutException() {
        RxDocumentServiceRequest request = RxDocumentServiceRequest.create(
            mockDiagnosticsClientContext(),
            OperationType.Read,
            ResourceType.Document);

        GoneAndRetryWithRetryPolicy goneAndRetryWithRetryPolicy = new GoneAndRetryWithRetryPolicy(request, 30);
        Mono<ShouldRetryResult> singleShouldRetry = goneAndRetryWithRetryPolicy
            .shouldRetry(new RequestTimeoutException());
        ShouldRetryResult shouldRetryResult = singleShouldRetry.block();

        assertThat(shouldRetryResult.shouldRetry).isFalse();
        assertThat(shouldRetryResult.policyArg).isNull();
        assertThat(shouldRetryResult.backOffTime).isNull();

        request = RxDocumentServiceRequest.create(
            mockDiagnosticsClientContext(),
            OperationType.Create,
            ResourceType.Document);

        goneAndRetryWithRetryPolicy = new GoneAndRetryWithRetryPolicy(request, 30);
        singleShouldRetry = goneAndRetryWithRetryPolicy
            .shouldRetry(new RequestTimeoutException());
        shouldRetryResult = singleShouldRetry.block();

        assertThat(shouldRetryResult.shouldRetry).isFalse();
        assertThat(shouldRetryResult.policyArg).isNull();
        assertThat(shouldRetryResult.backOffTime).isNull();
    }

    /**
     * Retry with PartitionIsMigratingException
     */
    @Test(groups = { "unit" }, timeOut = TIMEOUT)
    public void shouldRetryWithPartitionIsMigratingException() {
        RxDocumentServiceRequest request = RxDocumentServiceRequest.create(
            mockDiagnosticsClientContext(),
            OperationType.Read,
            ResourceType.Document);
        GoneAndRetryWithRetryPolicy goneAndRetryWithRetryPolicy = new GoneAndRetryWithRetryPolicy(request, 30);
        Mono<ShouldRetryResult> singleShouldRetry = goneAndRetryWithRetryPolicy
                .shouldRetry(new PartitionIsMigratingException());
        ShouldRetryResult shouldRetryResult = singleShouldRetry.block();
        assertThat(shouldRetryResult.shouldRetry).isTrue();
        assertThat(request.forceCollectionRoutingMapRefresh).isTrue();
        assertThat(shouldRetryResult.policyArg.getValue0()).isTrue();
    }

    /**
     * Should not retry with InvalidPartitionException
     */
    @Test(groups = { "unit" }, timeOut = TIMEOUT)
    public void shouldNotRetryWithInvalidPartitionException() {
        RxDocumentServiceRequest request = RxDocumentServiceRequest.create(
            mockDiagnosticsClientContext(),
            OperationType.Read,
            ResourceType.Document);
        GoneAndRetryWithRetryPolicy goneAndRetryWithRetryPolicy = new GoneAndRetryWithRetryPolicy(request, 30);
        ShouldRetryResult singleShouldRetry = goneAndRetryWithRetryPolicy
                .shouldRetry(new InvalidPartitionException()).block();
        assertThat(singleShouldRetry.shouldRetry).isFalse();
    }

    /**
     * Retry with PartitionKeyRangeIsSplittingException
     */
    @Test(groups = { "unit" }, timeOut = TIMEOUT)
    public void shouldRetryWithPartitionKeyRangeIsSplittingException() {
        RxDocumentServiceRequest request = RxDocumentServiceRequest.create(
            mockDiagnosticsClientContext(),
            OperationType.Read,
            ResourceType.Document);
        GoneAndRetryWithRetryPolicy goneAndRetryWithRetryPolicy = new GoneAndRetryWithRetryPolicy(request, 30);
        Mono<ShouldRetryResult> singleShouldRetry = goneAndRetryWithRetryPolicy
                .shouldRetry(new PartitionKeyRangeIsSplittingException());
        ShouldRetryResult shouldRetryResult = singleShouldRetry.block();
        assertThat(shouldRetryResult.shouldRetry).isTrue();
        assertThat(request.forcePartitionKeyRangeRefresh).isTrue();
        assertThat(request.requestContext.resolvedPartitionKeyRange).isNull();
        assertThat(request.requestContext.quorumSelectedLSN).isEqualTo(-1);
        assertThat(shouldRetryResult.policyArg.getValue0()).isFalse();

    }

    /**
     * No retry on bad request exception
     */
    @Test(groups = { "unit" }, timeOut = TIMEOUT)
    public void shouldRetryWithGenericException() {
        RxDocumentServiceRequest request = RxDocumentServiceRequest.create(
            mockDiagnosticsClientContext(),
            OperationType.Read,
            ResourceType.Document);
        GoneAndRetryWithRetryPolicy goneAndRetryWithRetryPolicy = new GoneAndRetryWithRetryPolicy(request, 30);
        Mono<ShouldRetryResult> singleShouldRetry = goneAndRetryWithRetryPolicy
                .shouldRetry(new BadRequestException());
        ShouldRetryResult shouldRetryResult = singleShouldRetry.block();
        assertThat(shouldRetryResult.shouldRetry).isFalse();
    }

    /**
     * Test for custom retryWith values
     */
    @Test(groups = { "unit" }, timeOut = TIMEOUT)
    public void retryWithDefaultTimeouts() {
        int defaultInitialDelayInMs = 10;
        int defaultSalt = 5;
        RxDocumentServiceRequest request = RxDocumentServiceRequest.create(
            mockDiagnosticsClientContext(),
            OperationType.Create,
            ResourceType.Document);
        GoneAndRetryWithRetryPolicy goneAndRetryWithRetryPolicy = new GoneAndRetryWithRetryPolicy(request, 30);

        RetryWithException retryWithException = Mockito.mock(RetryWithException.class);

        Mono<ShouldRetryResult> singleShouldRetry = goneAndRetryWithRetryPolicy.shouldRetry(retryWithException);
        ShouldRetryResult shouldRetryResult = singleShouldRetry.block();
        assertThat(shouldRetryResult.policyArg.getValue3()).isEqualTo(1);
        validateRetryWithTimeRange(defaultInitialDelayInMs, shouldRetryResult, defaultSalt);

        singleShouldRetry = goneAndRetryWithRetryPolicy.shouldRetry(retryWithException);
        shouldRetryResult = singleShouldRetry.block();
        assertThat(shouldRetryResult.policyArg.getValue3()).isEqualTo(2);
        defaultInitialDelayInMs = defaultInitialDelayInMs * 2; //backoff multiplier
        validateRetryWithTimeRange(defaultInitialDelayInMs, shouldRetryResult, defaultSalt);

        singleShouldRetry = goneAndRetryWithRetryPolicy.shouldRetry(retryWithException);
        shouldRetryResult = singleShouldRetry.block();
        assertThat(shouldRetryResult.policyArg.getValue3()).isEqualTo(3);
        defaultInitialDelayInMs = defaultInitialDelayInMs * 2; //backoff multiplier
        validateRetryWithTimeRange(defaultInitialDelayInMs, shouldRetryResult, defaultSalt);
    }

    private static void validateRetryWithTimeRange(
        int expectedDelayInMs,
        ShouldRetryResult retryResult,
        Integer saltValueInMs) {
        assertThat(retryResult.shouldRetry).isTrue();
        assertThat(retryResult.backOffTime.toMillis() >= 0).isTrue();
        assertThat(retryResult.backOffTime.toMillis() > expectedDelayInMs - saltValueInMs).isTrue();
        assertThat(retryResult.backOffTime.toMillis() < expectedDelayInMs + saltValueInMs).isTrue();
    }

    /**
     * After waitTimeInSeconds exhausted, retryWithException will not be retried.
     */
    @Test(groups = { "unit" }, timeOut = TIMEOUT)
    public void shouldRetryWithRetryWithException() {
        RxDocumentServiceRequest request = RxDocumentServiceRequest.create(
            mockDiagnosticsClientContext(),
            OperationType.Read,
            ResourceType.Document);
        GoneAndRetryWithRetryPolicy goneAndRetryWithRetryPolicy = new GoneAndRetryWithRetryPolicy(request, 1);

        ShouldRetryResult shouldRetryResult = Mono.delay(Duration.ofSeconds(1))
            .flatMap(t -> goneAndRetryWithRetryPolicy.shouldRetry(new RetryWithException("Test", null, null)))
            .block();

        assertThat(shouldRetryResult.shouldRetry).isFalse();
        assertThat(shouldRetryResult.nonRelatedException).isFalse();
    }
}
