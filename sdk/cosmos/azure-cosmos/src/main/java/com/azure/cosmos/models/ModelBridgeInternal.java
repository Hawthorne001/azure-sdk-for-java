// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.cosmos.models;

import com.azure.cosmos.ConsistencyLevel;
import com.azure.cosmos.CosmosDiagnostics;
import com.azure.cosmos.CosmosItemSerializer;
import com.azure.cosmos.implementation.ClientEncryptionKey;
import com.azure.cosmos.implementation.Conflict;
import com.azure.cosmos.implementation.CosmosPagedFluxOptions;
import com.azure.cosmos.implementation.CosmosResourceType;
import com.azure.cosmos.implementation.Database;
import com.azure.cosmos.implementation.DatabaseAccount;
import com.azure.cosmos.implementation.DefaultCosmosItemSerializer;
import com.azure.cosmos.implementation.DocumentCollection;
import com.azure.cosmos.implementation.HttpConstants;
import com.azure.cosmos.implementation.Index;
import com.azure.cosmos.implementation.InternalObjectNode;
import com.azure.cosmos.implementation.JsonSerializable;
import com.azure.cosmos.implementation.Offer;
import com.azure.cosmos.implementation.Permission;
import com.azure.cosmos.implementation.QueryMetrics;
import com.azure.cosmos.implementation.RequestOptions;
import com.azure.cosmos.implementation.RequestVerb;
import com.azure.cosmos.implementation.Resource;
import com.azure.cosmos.implementation.ResourceResponse;
import com.azure.cosmos.implementation.RxDocumentServiceResponse;
import com.azure.cosmos.implementation.StoredProcedure;
import com.azure.cosmos.implementation.StoredProcedureResponse;
import com.azure.cosmos.implementation.Trigger;
import com.azure.cosmos.implementation.User;
import com.azure.cosmos.implementation.UserDefinedFunction;
import com.azure.cosmos.implementation.Utils;
import com.azure.cosmos.implementation.Warning;
import com.azure.cosmos.implementation.changefeed.common.ChangeFeedMode;
import com.azure.cosmos.implementation.changefeed.common.ChangeFeedStartFromInternal;
import com.azure.cosmos.implementation.changefeed.common.ChangeFeedState;
import com.azure.cosmos.implementation.patch.PatchOperation;
import com.azure.cosmos.implementation.query.QueryInfo;
import com.azure.cosmos.implementation.routing.PartitionKeyInternal;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.lang.reflect.InvocationTargetException;
import java.nio.ByteBuffer;
import java.time.Duration;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentMap;

import static com.azure.cosmos.implementation.Warning.INTERNAL_USE_ONLY_WARNING;
import static com.azure.cosmos.implementation.guava25.base.Preconditions.checkNotNull;

/**
 * DO NOT USE.
 * This is meant to be used only internally as a bridge access to classes in
 * com.azure.cosmos.model package
 **/
@Warning(value = INTERNAL_USE_ONLY_WARNING)
public final class ModelBridgeInternal {

    private ModelBridgeInternal() {}

    @Warning(value = INTERNAL_USE_ONLY_WARNING)
    public static CosmosConflictResponse createCosmosConflictResponse(ResourceResponse<Conflict> response) {
        return new CosmosConflictResponse(response);
    }

    @Warning(value = INTERNAL_USE_ONLY_WARNING)
    public static ConsistencyLevel getConsistencyLevel(CosmosItemRequestOptions options) {
        return options.getConsistencyLevel();
    }

    @Warning(value = INTERNAL_USE_ONLY_WARNING)
    public static CosmosContainerResponse createCosmosContainerResponse(ResourceResponse<DocumentCollection> response) {
        return new CosmosContainerResponse(response);
    }

    @Warning(value = INTERNAL_USE_ONLY_WARNING)
    public static CosmosDatabaseResponse createCosmosDatabaseResponse(ResourceResponse<Database> response) {
        return new CosmosDatabaseResponse(response);
    }

    @Warning(value = INTERNAL_USE_ONLY_WARNING)
    public static CosmosPermissionResponse createCosmosPermissionResponse(ResourceResponse<Permission> response) {
        return new CosmosPermissionResponse(response);
    }

    @Warning(value = INTERNAL_USE_ONLY_WARNING)
    public static CosmosStoredProcedureResponse createCosmosStoredProcedureResponse(ResourceResponse<StoredProcedure> response) {
        return new CosmosStoredProcedureResponse(response);
    }

    @Warning(value = INTERNAL_USE_ONLY_WARNING)
    public static CosmosStoredProcedureResponse createCosmosStoredProcedureResponse(StoredProcedureResponse response) {
        return new CosmosStoredProcedureResponse(response);
    }

    @Warning(value = INTERNAL_USE_ONLY_WARNING)
    public static CosmosStoredProcedureProperties createCosmosStoredProcedureProperties(String jsonString) {
        return new CosmosStoredProcedureProperties(Utils.parseJson(jsonString));
    }

    @Warning(value = INTERNAL_USE_ONLY_WARNING)
    public static CosmosPermissionProperties createCosmosPermissionProperties(String jsonString) {
        return new CosmosPermissionProperties(Utils.parseJson(jsonString));
    }

    @Warning(value = INTERNAL_USE_ONLY_WARNING)
    public static CosmosTriggerResponse createCosmosTriggerResponse(ResourceResponse<Trigger> response) {
        return new CosmosTriggerResponse(response);
    }

    @Warning(value = INTERNAL_USE_ONLY_WARNING)
    public static CosmosUserDefinedFunctionResponse createCosmosUserDefinedFunctionResponse(ResourceResponse<UserDefinedFunction> response) {
        return new CosmosUserDefinedFunctionResponse(response);
    }

    @Warning(value = INTERNAL_USE_ONLY_WARNING)
    public static CosmosUserResponse createCosmosUserResponse(ResourceResponse<User> response) {
        return new CosmosUserResponse(response);
    }

    @Warning(value = INTERNAL_USE_ONLY_WARNING)
    public static CosmosClientEncryptionKeyResponse createCosmosClientEncryptionKeyResponse(ResourceResponse<ClientEncryptionKey> response) {
        return new CosmosClientEncryptionKeyResponse(response);
    }

    @Warning(value = INTERNAL_USE_ONLY_WARNING)
    public static List<CosmosConflictProperties> getCosmosConflictPropertiesFromV2Results(List<Conflict> results) {
        return CosmosConflictProperties.getFromV2Results(results);
    }

    @Warning(value = INTERNAL_USE_ONLY_WARNING)
    public static DocumentCollection getV2Collection(CosmosContainerProperties containerProperties) {
        return containerProperties.getV2Collection();
    }

    @Warning(value = INTERNAL_USE_ONLY_WARNING)
    public static List<CosmosContainerProperties> getCosmosContainerPropertiesFromV2Results(List<DocumentCollection> results) {
        return CosmosContainerProperties.getFromV2Results(results);
    }

    @Warning(value = INTERNAL_USE_ONLY_WARNING)
    public static List<CosmosDatabaseProperties> getCosmosDatabasePropertiesFromV2Results(List<Database> results) {
        return CosmosDatabaseProperties.getFromV2Results(results);
    }

    @Warning(value = INTERNAL_USE_ONLY_WARNING)
    public static <T> InternalObjectNode getInternalObjectNode(CosmosItemResponse<T> cosmosItemResponse) {
        return cosmosItemResponse.getProperties();
    }

    @Warning(value = INTERNAL_USE_ONLY_WARNING)
    public static Permission getPermission(CosmosPermissionProperties permissionProperties, String databaseName) {
        return permissionProperties.getPermission(databaseName);
    }

    @Warning(value = INTERNAL_USE_ONLY_WARNING)
    public static Permission getPermission(CosmosPermissionProperties permissionProperties) {
        return permissionProperties.getPermission();
    }

    @Warning(value = INTERNAL_USE_ONLY_WARNING)
    public static List<CosmosPermissionProperties> getCosmosPermissionPropertiesFromResults(List<Permission> results) {
        return CosmosPermissionProperties.getPermissions(results);
    }

    @Warning(value = INTERNAL_USE_ONLY_WARNING)
    public static List<CosmosStoredProcedureProperties> getCosmosStoredProcedurePropertiesFromV2Results(List<StoredProcedure> results) {
        return CosmosStoredProcedureProperties.getFromV2Results(results);
    }

    @Warning(value = INTERNAL_USE_ONLY_WARNING)
    public static List<CosmosTriggerProperties> getCosmosTriggerPropertiesFromV2Results(List<Trigger> results) {
        return CosmosTriggerProperties.getFromV2Results(results);
    }

    @Warning(value = INTERNAL_USE_ONLY_WARNING)
    public static List<CosmosUserDefinedFunctionProperties> getCosmosUserDefinedFunctionPropertiesFromV2Results(List<UserDefinedFunction> results) {
        return CosmosUserDefinedFunctionProperties.getFromV2Results(results);
    }

    @Warning(value = INTERNAL_USE_ONLY_WARNING)
    public static User getV2User(CosmosUserProperties cosmosUserProperties) {
        return cosmosUserProperties.getV2User();
    }

    @Warning(value = INTERNAL_USE_ONLY_WARNING)
    public static List<CosmosUserProperties> getCosmosUserPropertiesFromV2Results(List<User> results) {
        return CosmosUserProperties.getFromV2Results(results);
    }

    @Warning(value = INTERNAL_USE_ONLY_WARNING)
    public static ClientEncryptionKey getClientEncryptionKey(CosmosClientEncryptionKeyProperties cosmosClientEncryptionKeyProperties) {
        return cosmosClientEncryptionKeyProperties.getClientEncryptionKey();
    }

    @Warning(value = INTERNAL_USE_ONLY_WARNING)
    public static List<CosmosClientEncryptionKeyProperties> getClientEncryptionKeyPropertiesList(List<ClientEncryptionKey> results) {
        return CosmosClientEncryptionKeyProperties.getClientEncryptionKeys(results);
    }

    @Warning(value = INTERNAL_USE_ONLY_WARNING)
    public static RequestOptions toRequestOptions(CosmosConflictRequestOptions cosmosConflictRequestOptions) {
        return cosmosConflictRequestOptions.toRequestOptions();
    }

    @Warning(value = INTERNAL_USE_ONLY_WARNING)
    public static RequestOptions toRequestOptions(CosmosContainerRequestOptions cosmosContainerRequestOptions) {
        return cosmosContainerRequestOptions.toRequestOptions();
    }

    @Warning(value = INTERNAL_USE_ONLY_WARNING)
    public static RequestOptions toRequestOptions(CosmosDatabaseRequestOptions cosmosDatabaseRequestOptions) {
        return cosmosDatabaseRequestOptions.toRequestOptions();
    }

    @Warning(value = INTERNAL_USE_ONLY_WARNING)
    public static CosmosDatabaseRequestOptions setThroughputProperties(
        CosmosDatabaseRequestOptions cosmosDatabaseRequestOptions,
        ThroughputProperties throughputProperties) {
        return cosmosDatabaseRequestOptions.setThroughputProperties(throughputProperties);
    }

    @Warning(value = INTERNAL_USE_ONLY_WARNING)
    public static CosmosContainerRequestOptions setThroughputProperties(
        CosmosContainerRequestOptions containerRequestOptions,
        ThroughputProperties throughputProperties) {
        return containerRequestOptions.setThroughputProperties(throughputProperties);
    }

    @Warning(value = INTERNAL_USE_ONLY_WARNING)
    public static Offer updateOfferFromProperties(Offer offer, ThroughputProperties properties) {
        return properties.updateOfferFromProperties(offer);
    }

    @Warning(value = INTERNAL_USE_ONLY_WARNING)
    public static CosmosItemRequestOptions setPartitionKey(CosmosItemRequestOptions cosmosItemRequestOptions,
                                                           PartitionKey partitionKey) {
        return cosmosItemRequestOptions.setPartitionKey(partitionKey);
    }

    @Warning(value = INTERNAL_USE_ONLY_WARNING)
    public static CosmosItemRequestOptions createCosmosItemRequestOptions(PartitionKey partitionKey) {
        return new CosmosItemRequestOptions(partitionKey);
    }

    @Warning(value = INTERNAL_USE_ONLY_WARNING)
    public static RequestOptions toRequestOptions(CosmosPermissionRequestOptions cosmosPermissionRequestOptions) {
        return cosmosPermissionRequestOptions.toRequestOptions();
    }

    @Warning(value = INTERNAL_USE_ONLY_WARNING)
    public static RequestOptions toRequestOptions(CosmosStoredProcedureRequestOptions cosmosStoredProcedureRequestOptions) {
        return cosmosStoredProcedureRequestOptions.toRequestOptions();
    }

    @Warning(value = INTERNAL_USE_ONLY_WARNING)
    public static DatabaseAccount toDatabaseAccount(RxDocumentServiceResponse response) {
        DatabaseAccount account = response.getResource(DatabaseAccount.class);

        // read the headers and set to the account
        Map<String, String> responseHeader = response.getResponseHeaders();

        account.setMaxMediaStorageUsageInMB(
            Long.parseLong(responseHeader.get(HttpConstants.HttpHeaders.MAX_MEDIA_STORAGE_USAGE_IN_MB)));
        account.setMediaStorageUsageInMB(
            Long.parseLong(responseHeader.get(HttpConstants.HttpHeaders.CURRENT_MEDIA_STORAGE_USAGE_IN_MB)));

        return account;
    }

    /**
     * Gets the partitionKeyRangeId.
     *
     * @param options the query request options
     * @return the partitionKeyRangeId.
     */
    @Warning(value = INTERNAL_USE_ONLY_WARNING)
    public static String getPartitionKeyRangeIdInternal(CosmosQueryRequestOptions options) {
        return options.getPartitionKeyRangeIdInternal();
    }

    /**
     * Sets the PartitionKeyRangeId.
     *
     * @param options the query request options
     * @param partitionKeyRangeId the partition key range id
     * @return the partitionKeyRangeId.
     */
    @Warning(value = INTERNAL_USE_ONLY_WARNING)
    public static CosmosQueryRequestOptions setPartitionKeyRangeIdInternal(CosmosQueryRequestOptions options, String partitionKeyRangeId) {
        options.setPartitionKeyRangeIdInternal(partitionKeyRangeId);
        return options;
    }

    @Warning(value = INTERNAL_USE_ONLY_WARNING)
    public static <T> FeedResponse<T> toFeedResponsePage(List<T> results, Map<String, String> headers, boolean noChanges) {
        return new FeedResponse<>(results, headers, noChanges);
    }

    @Warning(value = INTERNAL_USE_ONLY_WARNING)
    public static <T> boolean noChanges(FeedResponse<T> page) {
        return page.nochanges;
    }

    @Warning(value = INTERNAL_USE_ONLY_WARNING)
    public static <T> FeedResponse<T> createFeedResponse(List<T> results,
                                                         Map<String, String> headers) {
        return new FeedResponse<>(results, headers);
    }

    @Warning(value = INTERNAL_USE_ONLY_WARNING)
    public static <T> FeedResponse<T> createFeedResponseWithQueryMetrics(
        List<T> results,
        Map<String,
        String> headers,
        ConcurrentMap<String, QueryMetrics> queryMetricsMap,
        QueryInfo.QueryPlanDiagnosticsContext diagnosticsContext,
        boolean useEtagAsContinuation,
        boolean isNoChanges) {

        FeedResponse<T> feedResponse =  new FeedResponse<>(
            results,
            headers,
            queryMetricsMap,
            useEtagAsContinuation,
            isNoChanges);
        feedResponse.setQueryPlanDiagnosticsContext(diagnosticsContext);
        return feedResponse;
    }

    @Warning(value = INTERNAL_USE_ONLY_WARNING)
    public static <T> ConcurrentMap<String, QueryMetrics> queryMetricsMap(FeedResponse<T> feedResponse) {
        return feedResponse.queryMetricsMap();
    }

    @Warning(value = INTERNAL_USE_ONLY_WARNING)
    public static <T> ConcurrentMap<String, QueryMetrics> queryMetrics(FeedResponse<T> feedResponse) {
        return feedResponse.queryMetrics();
    }

    @Warning(value = INTERNAL_USE_ONLY_WARNING)
    public static <T> QueryInfo.QueryPlanDiagnosticsContext getQueryPlanDiagnosticsContext(FeedResponse<T> feedResponse) {
        return feedResponse.getQueryPlanDiagnosticsContext();
    }

    @Warning(value = INTERNAL_USE_ONLY_WARNING)
    public static String toLower(RequestVerb verb) {
        return verb.toLowerCase();
    }

    @Warning(value = INTERNAL_USE_ONLY_WARNING)
    public static boolean isV2(PartitionKeyDefinition pkd) {
        return pkd.getVersion() != null && PartitionKeyDefinitionVersion.V2.val == pkd.getVersion().val;
    }

    @Warning(value = INTERNAL_USE_ONLY_WARNING)
    public static PartitionKeyInternal getNonePartitionKey(PartitionKeyDefinition partitionKeyDefinition) {
        return partitionKeyDefinition.getNonePartitionKeyValue();
    }

    @Warning(value = INTERNAL_USE_ONLY_WARNING)
    public static PartitionKeyInternal getPartitionKeyInternal(PartitionKey partitionKey) {
        return partitionKey.getInternalPartitionKey();
    }

    @Warning(value = INTERNAL_USE_ONLY_WARNING)
    public static PartitionKey partitionKeyfromJsonString(String jsonString) {
        return PartitionKey.fromJsonString(jsonString);
    }

    @Warning(value = INTERNAL_USE_ONLY_WARNING)
    public static CosmosResourceType fromServiceSerializedFormat(String cosmosResourceType) {
        return CosmosResourceType.fromServiceSerializedFormat(cosmosResourceType);
    }

    @Warning(value = INTERNAL_USE_ONLY_WARNING)
    public static void setQueryRequestOptionsContinuationTokenAndMaxItemCount(CosmosQueryRequestOptions options, String continuationToken, Integer maxItemCount) {
        options.setRequestContinuation(continuationToken);
        options.setMaxItemCount(maxItemCount);
    }

    @Warning(value = INTERNAL_USE_ONLY_WARNING)
    public static void setQueryRequestOptionsContinuationToken(CosmosQueryRequestOptions cosmosQueryRequestOptions, String continuationToken) {
        cosmosQueryRequestOptions.setRequestContinuation(continuationToken);
    }

    @Warning(value = INTERNAL_USE_ONLY_WARNING)
    public static void setQueryRequestOptionsMaxItemCount(CosmosQueryRequestOptions cosmosQueryRequestOptions, Integer maxItemCount) {
        cosmosQueryRequestOptions.setMaxItemCount(maxItemCount);
    }

    @Warning(value = INTERNAL_USE_ONLY_WARNING)
    public static CosmosChangeFeedRequestOptions getEffectiveChangeFeedRequestOptions(
        CosmosChangeFeedRequestOptions cosmosChangeFeedRequestOptions,
        CosmosPagedFluxOptions pagedFlexOptions) {

        return cosmosChangeFeedRequestOptions.withCosmosPagedFluxOptions(pagedFlexOptions);
    }

    @Warning(value = INTERNAL_USE_ONLY_WARNING)
    public static ByteBuffer serializeJsonToByteBuffer(SqlQuerySpec sqlQuerySpec) {
        sqlQuerySpec.populatePropertyBag();
        return sqlQuerySpec
            .getJsonSerializable()
            .serializeJsonToByteBuffer(
                DefaultCosmosItemSerializer.INTERNAL_DEFAULT_SERIALIZER,
                null,
                false);
    }

    @Warning(value = INTERNAL_USE_ONLY_WARNING)
    public static <T> T instantiateByObjectNode(ObjectNode objectNode, Class<T> c) {
        try {
            return c.getDeclaredConstructor(ObjectNode.class).newInstance(objectNode);
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException | IllegalArgumentException e) {
            throw new IllegalArgumentException(e);
        }
    }

    @Warning(value = INTERNAL_USE_ONLY_WARNING)
    public static <T> void populatePropertyBag(T t) {
        if (t instanceof JsonSerializable) {
            ((JsonSerializable) t).populatePropertyBag();
        } else if (t instanceof CompositePath) {
            ((CompositePath) t).populatePropertyBag();
        } else if (t instanceof ConflictResolutionPolicy) {
            ((ConflictResolutionPolicy) t).populatePropertyBag();
        } else if (t instanceof ChangeFeedPolicy) {
            ((ChangeFeedPolicy) t).populatePropertyBag();
        } else if (t instanceof ExcludedPath) {
            ((ExcludedPath) t).populatePropertyBag();
        } else if (t instanceof IncludedPath) {
            ((IncludedPath) t).populatePropertyBag();
        } else if (t instanceof IndexingPolicy) {
            ((IndexingPolicy) t).populatePropertyBag();
        } else if (t instanceof PartitionKeyDefinition) {
            ((PartitionKeyDefinition) t).populatePropertyBag();
        } else if (t instanceof SpatialSpec) {
            ((SpatialSpec) t).populatePropertyBag();
        } else if (t instanceof CosmosVectorIndexSpec) {
            ((CosmosVectorIndexSpec) t).populatePropertyBag();
        } else if (t instanceof CosmosFullTextIndex) {
            ((CosmosFullTextIndex) t).populatePropertyBag();
        } else if (t instanceof SqlParameter) {
            ((SqlParameter) t).populatePropertyBag();
        } else if (t instanceof SqlQuerySpec) {
            ((SqlQuerySpec) t).populatePropertyBag();
        } else if (t instanceof UniqueKey) {
            ((UniqueKey) t).populatePropertyBag();
        } else if (t instanceof UniqueKeyPolicy) {
            ((UniqueKeyPolicy) t).populatePropertyBag();
        } else {
            throw new IllegalArgumentException("populatePropertyBag method does not exists in class " + t.getClass());
        }
    }

    @Warning(value = INTERNAL_USE_ONLY_WARNING)
    public static <T> JsonSerializable getJsonSerializable(T t) {
        if (t instanceof JsonSerializable) {
            return (JsonSerializable) t;
        } if (t instanceof CompositePath) {
            return ((CompositePath) t).getJsonSerializable();
        } else if (t instanceof ConflictResolutionPolicy) {
            return ((ConflictResolutionPolicy) t).getJsonSerializable();
        } else if (t instanceof ChangeFeedPolicy) {
            return ((ChangeFeedPolicy) t).getJsonSerializable();
        } else if (t instanceof ExcludedPath) {
            return ((ExcludedPath) t).getJsonSerializable();
        } else if (t instanceof IncludedPath) {
            return ((IncludedPath) t).getJsonSerializable();
        } else if (t instanceof IndexingPolicy) {
            return ((IndexingPolicy) t).getJsonSerializable();
        } else if (t instanceof PartitionKeyDefinition) {
            return ((PartitionKeyDefinition) t).getJsonSerializable();
        } else if (t instanceof SpatialSpec) {
            return ((SpatialSpec) t).getJsonSerializable();
        } else if (t instanceof CosmosVectorIndexSpec) {
            return ((CosmosVectorIndexSpec) t).getJsonSerializable();
        } else if (t instanceof CosmosFullTextIndex) {
            return ((CosmosFullTextIndex) t).getJsonSerializable();
        } else if (t instanceof SqlParameter) {
            return ((SqlParameter) t).getJsonSerializable();
        } else if (t instanceof SqlQuerySpec) {
            return ((SqlQuerySpec) t).getJsonSerializable();
        } else if (t instanceof UniqueKey) {
            return ((UniqueKey) t).getJsonSerializable();
        } else if (t instanceof UniqueKeyPolicy) {
            return ((UniqueKeyPolicy) t).getJsonSerializable();
        } else {
            throw new IllegalArgumentException("getJsonSerializable method does not exists in class " + t.getClass());
        }
    }

    @Warning(value = INTERNAL_USE_ONLY_WARNING)
    public static <T> Resource getResource(T t) {
        if (t == null) {
            return null;
        } else if (t instanceof Resource) {
            return (Resource) t;
        } else if (t instanceof CosmosConflictProperties) {
            return ((CosmosConflictProperties) t).getResource();
        } else if (t instanceof CosmosContainerProperties) {
            return ((CosmosContainerProperties) t).getResource();
        } else if (t instanceof CosmosDatabaseProperties) {
            return ((CosmosDatabaseProperties) t).getResource();
        } else if (t instanceof CosmosPermissionProperties) {
            return ((CosmosPermissionProperties) t).getResource();
        } else if (t instanceof CosmosStoredProcedureProperties) {
            return ((CosmosStoredProcedureProperties) t).getResource();
        } else if (t instanceof CosmosTriggerProperties) {
            return ((CosmosTriggerProperties) t).getResource();
        } else if (t instanceof CosmosUserDefinedFunctionProperties) {
            return ((CosmosUserDefinedFunctionProperties) t).getResource();
        } else if (t instanceof CosmosUserProperties) {
            return ((CosmosUserProperties) t).getResource();
        } else if (t instanceof CosmosClientEncryptionKeyProperties) {
            return ((CosmosClientEncryptionKeyProperties) t).getResource();
        } else {
            throw new IllegalArgumentException("getResource method does not exists in class " + t.getClass());
        }
    }

    @Warning(value = INTERNAL_USE_ONLY_WARNING)
    public static Offer getOfferFromThroughputProperties(ThroughputProperties properties) {
        return properties.getOffer();
    }

    @Warning(value = INTERNAL_USE_ONLY_WARNING)
    public static ThroughputResponse createThroughputRespose(ResourceResponse<Offer> offerResourceResponse) {
        return new ThroughputResponse(offerResourceResponse);
    }

    @Warning(value = INTERNAL_USE_ONLY_WARNING)
    public static void addQueryInfoToFeedResponse(FeedResponse<?> feedResponse, QueryInfo queryInfo){
        feedResponse.setQueryInfo(queryInfo);
    }

    @Warning(value = INTERNAL_USE_ONLY_WARNING)
    public static void addQueryPlanDiagnosticsContextToFeedResponse(FeedResponse<?> feedResponse, QueryInfo.QueryPlanDiagnosticsContext queryPlanDiagnosticsContext){
        feedResponse.setQueryPlanDiagnosticsContext(queryPlanDiagnosticsContext);
    }

    @Warning(value = INTERNAL_USE_ONLY_WARNING)
    public static boolean getNoChangesFromFeedResponse(FeedResponse<?> response) {
        return response.getNoChanges();
    }

    @Warning(value = INTERNAL_USE_ONLY_WARNING)
    public static Integer getMaxItemCountFromQueryRequestOptions(CosmosQueryRequestOptions options) {
        return options.getMaxItemCount();
    }

    @Warning(value = INTERNAL_USE_ONLY_WARNING)
    public static String getRequestContinuationFromQueryRequestOptions(CosmosQueryRequestOptions options) {
        return options.getRequestContinuation();
    }

    @Warning(value = INTERNAL_USE_ONLY_WARNING)
    public static Map<String, Object> getPropertiesFromChangeFeedRequestOptions(CosmosChangeFeedRequestOptions options) {
        if (options == null) {
            return null;
        }

        return options.getProperties();
    }

    @Warning(value = INTERNAL_USE_ONLY_WARNING)
    public static CosmosQueryRequestOptions setQueryRequestOptionsProperties(CosmosQueryRequestOptions options, Map<String, Object> properties) {
        options.getImpl().setProperties(properties);
        return options;
    }

    @Warning(value = INTERNAL_USE_ONLY_WARNING)
    public static IndexingPolicy createIndexingPolicy(Index[] indexes) {
        return new IndexingPolicy(indexes);
    }

    @Warning(value = INTERNAL_USE_ONLY_WARNING)
    public static CosmosItemRequestOptions clone(CosmosItemRequestOptions options) {
        return new CosmosItemRequestOptions(options);
    }

    @Warning(value = INTERNAL_USE_ONLY_WARNING)
    public static <T> int getPayloadLength(CosmosItemResponse<T> cosmosItemResponse) {
        return cosmosItemResponse.getResponsePayloadLength();
    }

    @Warning(value = INTERNAL_USE_ONLY_WARNING)
    public static CosmosChangeFeedRequestOptions createChangeFeedRequestOptionsForChangeFeedState(
        ChangeFeedState state) {

        return CosmosChangeFeedRequestOptions.createForProcessingFromContinuation(state);
    }

    @Warning(value = INTERNAL_USE_ONLY_WARNING)
    public static <T> void setFeedResponseContinuationToken(String continuationToken, FeedResponse<T> response) {
        checkNotNull(response, "Argument 'response' must not be null.");
        response.setContinuationToken(continuationToken);
    }

    @Warning(value = INTERNAL_USE_ONLY_WARNING)
    public static ChangeFeedMode getChangeFeedMode(CosmosChangeFeedRequestOptions requestOptions) {
        checkNotNull(requestOptions, "Argument 'requestOptions' must not be null.");
        return requestOptions.getMode();
    }

    @Warning(value = INTERNAL_USE_ONLY_WARNING)
    public static ChangeFeedStartFromInternal getChangeFeedStartFromSettings(
        CosmosChangeFeedRequestOptions requestOptions) {

        checkNotNull(requestOptions, "Argument 'requestOptions' must not be null.");
        return requestOptions.getStartFromSettings();
    }

    @Warning(value = INTERNAL_USE_ONLY_WARNING)
    public static boolean getChangeFeedIsSplitHandlingDisabled(
        CosmosChangeFeedRequestOptions requestOptions) {

        checkNotNull(requestOptions, "Argument 'requestOptions' must not be null.");
        return requestOptions.isSplitHandlingDisabled();
    }

    @Warning(value = INTERNAL_USE_ONLY_WARNING)
    public static CosmosChangeFeedRequestOptions disableSplitHandling(
        CosmosChangeFeedRequestOptions requestOptions) {

        checkNotNull(requestOptions, "Argument 'requestOptions' must not be null.");
        return requestOptions.disableSplitHandling();
    }

    @Warning(value = INTERNAL_USE_ONLY_WARNING)
    public static ChangeFeedState getChangeFeedContinuationState(
        CosmosChangeFeedRequestOptions requestOptions) {

        checkNotNull(requestOptions, "Argument 'requestOptions' must not be null.");
        return requestOptions.getContinuation();
    }

    @Warning(value = INTERNAL_USE_ONLY_WARNING)
    public static void setChangeFeedRequestOptionsContinuation(
        String eTag,
        CosmosChangeFeedRequestOptions options) {

        checkNotNull(options, "Argument 'options' must not be null.");
        options.setRequestContinuation(eTag);
    }

    @Warning(value = INTERNAL_USE_ONLY_WARNING)
    public static String getOperationValueForCosmosItemOperationType(CosmosItemOperationType cosmosItemOperationType) {
        return cosmosItemOperationType.getOperationValue();
    }

    @Warning(value = INTERNAL_USE_ONLY_WARNING)
    public static CosmosBatchResponse createCosmosBatchResponse(
        int responseStatusCode,
        int responseSubStatusCode,
        String errorMessage,
        Map<String, String> responseHeaders,
        CosmosDiagnostics cosmosDiagnostics) {

        return new CosmosBatchResponse(
            responseStatusCode,
            responseSubStatusCode,
            errorMessage,
            responseHeaders,
            cosmosDiagnostics);
    }

    @Warning(value = INTERNAL_USE_ONLY_WARNING)
    public static CosmosBatchOperationResult createCosmosBatchResult(
        String eTag,
        double requestCharge,
        ObjectNode resourceObject,
        int statusCode,
        Duration retryAfter,
        int subStatusCode,
        CosmosItemOperation cosmosItemOperation) {

        return new CosmosBatchOperationResult(
            eTag,
            requestCharge,
            resourceObject,
            statusCode,
            retryAfter,
            subStatusCode,
            cosmosItemOperation);
    }

    @Warning(value = INTERNAL_USE_ONLY_WARNING)
    public static void addCosmosBatchResultInResponse(
        CosmosBatchResponse cosmosBatchResponse,
        List<CosmosBatchOperationResult> cosmosBatchOperationResults) {

        cosmosBatchResponse.addAll(cosmosBatchOperationResults);
    }

    @Warning(value = INTERNAL_USE_ONLY_WARNING)
    public static RequestOptions toRequestOptions(CosmosBatchRequestOptions cosmosBatchRequestOptions) {
        return cosmosBatchRequestOptions.toRequestOptions();
    }

    @Warning(value = INTERNAL_USE_ONLY_WARNING)
    public static CosmosBulkItemResponse createCosmosBulkItemResponse(
        CosmosBatchOperationResult result,
        CosmosBatchResponse response) {

        return new CosmosBulkItemResponse(
            result.getETag(),
            result.getRequestCharge(),
            result.getResourceObject(),
            result.getStatusCode(),
            result.getRetryAfterDuration(),
            result.getSubStatusCode(),
            response.getResponseHeaders(),
            response.getDiagnostics(),
            result.getEffectiveItemSerializer());
    }

    @Warning(value = INTERNAL_USE_ONLY_WARNING)
    public static <TContext> CosmosBulkOperationResponse<TContext> createCosmosBulkOperationResponse(
        CosmosItemOperation operation,
        CosmosBulkItemResponse response,
        TContext batchContext) {

        return new CosmosBulkOperationResponse<>(
            operation,
            response,
            batchContext);
    }

    @Warning(value = INTERNAL_USE_ONLY_WARNING)
    public static <TContext> CosmosBulkOperationResponse<TContext> createCosmosBulkOperationResponse(
        CosmosItemOperation operation,
        Exception exception,
        TContext batchContext) {

        return new CosmosBulkOperationResponse<>(
            operation,
            exception,
            batchContext);
    }

    @Warning(value = INTERNAL_USE_ONLY_WARNING)
    public static List<PatchOperation> getPatchOperationsFromCosmosPatch(CosmosPatchOperations cosmosPatchOperations) {
        return cosmosPatchOperations.getPatchOperations();
    }

    @Warning(value = INTERNAL_USE_ONLY_WARNING)
    public static void  initializeAllAccessors() {
        CosmosBatch.initialize();
        CosmosBatchOperationResult.initialize();
        CosmosBatchRequestOptions.initialize();
        CosmosBatchResponse.initialize();
        CosmosBulkExecutionOptions.initialize();
        CosmosBulkExecutionThresholdsState.initialize();
        CosmosBulkItemResponse.initialize();
        CosmosChangeFeedRequestOptions.initialize();
        CosmosContainerProperties.initialize();
        CosmosItemRequestOptions.initialize();
        CosmosItemResponse.initialize();
        CosmosPatchOperations.initialize();
        CosmosReadManyRequestOptions.initialize();
        CosmosQueryRequestOptions.initialize();
        CosmosOperationDetails.initialize();
        FeedResponse.initialize();
        PartitionKey.initialize();
        CosmosClientTelemetryConfig.initialize();
        CosmosContainerIdentity.initialize();
        PriorityLevel.initialize();
    }
}
