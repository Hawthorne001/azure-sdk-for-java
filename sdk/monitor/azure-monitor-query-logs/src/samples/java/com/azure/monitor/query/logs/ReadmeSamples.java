// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.monitor.query.logs;

import com.azure.core.http.policy.HttpLogDetailLevel;
import com.azure.core.http.policy.HttpLogOptions;
import com.azure.core.http.rest.Response;
import com.azure.core.util.BinaryData;
import com.azure.core.util.Context;
import com.azure.core.util.HttpClientOptions;
import com.azure.identity.DefaultAzureCredential;
import com.azure.identity.DefaultAzureCredentialBuilder;
import com.azure.monitor.query.logs.models.LogsBatchQuery;
import com.azure.monitor.query.logs.models.LogsBatchQueryResult;
import com.azure.monitor.query.logs.models.LogsBatchQueryResultCollection;
import com.azure.monitor.query.logs.models.LogsQueryOptions;
import com.azure.monitor.query.logs.models.LogsQueryResult;
import com.azure.monitor.query.logs.models.LogsQueryResultStatus;
import com.azure.monitor.query.logs.models.LogsQueryTimeInterval;
import com.azure.monitor.query.logs.models.LogsTableRow;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;

/**
 * Code samples for the README.md
 */
public class ReadmeSamples {
    /**
     * Sample for creating sync and async clients for querying logs.
     */
    public void createLogsClients() {
        // BEGIN: readme-sample-createLogsQueryClient
        LogsQueryClient logsQueryClient = new LogsQueryClientBuilder()
            .credential(new DefaultAzureCredentialBuilder().build())
            .buildClient();
        // END: readme-sample-createLogsQueryClient

        // BEGIN: readme-sample-createLogsQueryAsyncClient
        LogsQueryAsyncClient logsQueryAsyncClient = new LogsQueryClientBuilder()
            .credential(new DefaultAzureCredentialBuilder().build())
            .buildAsyncClient();
        // END: readme-sample-createLogsQueryAsyncClient
    }

    /**
     * Sample to query logs using a single Kusto query.
     */
    public void queryLogs() {
        // BEGIN: readme-sample-logsquery
        LogsQueryClient logsQueryClient = new LogsQueryClientBuilder()
            .credential(new DefaultAzureCredentialBuilder().build())
            .buildClient();

        LogsQueryResult queryResults = logsQueryClient.queryWorkspace("{workspace-id}", "{kusto-query}",
            new LogsQueryTimeInterval(Duration.ofDays(2)));

        for (LogsTableRow row : queryResults.getTable().getRows()) {
            System.out.println(row.getColumnValue("OperationName") + " " + row.getColumnValue("ResourceGroup"));
        }
        // END: readme-sample-logsquery
    }

    /**
     * Sample to query logs from a resource using a single Kusto query.
     */
    public void queryLogsByResourceId() {
        // BEGIN: readme-sample-logsquerybyresourceid
        LogsQueryClient logsQueryClient = new LogsQueryClientBuilder()
            .credential(new DefaultAzureCredentialBuilder().build())
            .buildClient();

        LogsQueryResult queryResults = logsQueryClient.queryResource("{resource-id}", "{kusto-query}",
            new LogsQueryTimeInterval(Duration.ofDays(2)));

        for (LogsTableRow row : queryResults.getTable().getRows()) {
            System.out.println(row.getColumnValue("OperationName") + " " + row.getColumnValue("ResourceGroup"));
        }
        // END: readme-sample-logsquerybyresourceid
    }

    /**
     * A custom model type to map logs query result to an object.
     */
    // BEGIN: readme-sample-custommodel
    public class CustomLogModel {
        private String resourceGroup;
        private String operationName;

        public String getResourceGroup() {
            return resourceGroup;
        }

        public String getOperationName() {
            return operationName;
        }
    }
    // END: readme-sample-custommodel

    /**
     * Sample to query logs and convert the response to a strongly-typed list of objects.
     */
    public void queryLogsAsModel() {
        // BEGIN: readme-sample-logsquerycustommodel
        LogsQueryClient logsQueryClient = new LogsQueryClientBuilder()
            .credential(new DefaultAzureCredentialBuilder().build())
            .buildClient();

        List<CustomLogModel> customLogModels = logsQueryClient.queryWorkspace("{workspace-id}", "{kusto-query}",
            new LogsQueryTimeInterval(Duration.ofDays(2)), CustomLogModel.class);

        for (CustomLogModel customLogModel : customLogModels) {
            System.out.println(customLogModel.getOperationName() + " " + customLogModel.getResourceGroup());
        }
        // END: readme-sample-logsquerycustommodel
    }

    /**
     * Sample to execute a batch of logs queries.
     */
    public void queryBatch() {
        // BEGIN: readme-sample-batchlogsquery
        LogsQueryClient logsQueryClient = new LogsQueryClientBuilder()
            .credential(new DefaultAzureCredentialBuilder().build())
            .buildClient();

        LogsBatchQuery logsBatchQuery = new LogsBatchQuery();
        String query1 = logsBatchQuery.addWorkspaceQuery("{workspace-id}", "{query-1}", new LogsQueryTimeInterval(Duration.ofDays(2)));
        String query2 = logsBatchQuery.addWorkspaceQuery("{workspace-id}", "{query-2}", new LogsQueryTimeInterval(Duration.ofDays(30)));
        String query3 = logsBatchQuery.addWorkspaceQuery("{workspace-id}", "{query-3}", new LogsQueryTimeInterval(Duration.ofDays(10)));

        LogsBatchQueryResultCollection batchResults = logsQueryClient
            .queryBatchWithResponse(logsBatchQuery, Context.NONE).getValue();

        LogsBatchQueryResult query1Result = batchResults.getResult(query1);
        for (LogsTableRow row : query1Result.getTable().getRows()) {
            System.out.println(row.getColumnValue("OperationName") + " " + row.getColumnValue("ResourceGroup"));
        }

        List<CustomLogModel> customLogModels = batchResults.getResult(query2, CustomLogModel.class);
        for (CustomLogModel customLogModel : customLogModels) {
            System.out.println(customLogModel.getOperationName() + " " + customLogModel.getResourceGroup());
        }

        LogsBatchQueryResult query3Result = batchResults.getResult(query3);
        if (query3Result.getQueryResultStatus() == LogsQueryResultStatus.FAILURE) {
            System.out.println(query3Result.getError().getMessage());
        }
        // END: readme-sample-batchlogsquery
    }

    /**
     * Sample to demonstrate executing an advanced Kusto query for logs that requires a long time to complete and
     * requires extending server timeout.
     */
    public void getLogsWithServerTimeout() {
        // BEGIN: readme-sample-logsquerytimeout
        LogsQueryClient logsQueryClient = new LogsQueryClientBuilder()
            .credential(new DefaultAzureCredentialBuilder().build())
            .buildClient();

        // set request options: server timeout
        LogsQueryOptions options = new LogsQueryOptions()
            .setServerTimeout(Duration.ofMinutes(10));

        Response<LogsQueryResult> response = logsQueryClient.queryWorkspaceWithResponse("{workspace-id}",
            "{kusto-query}", new LogsQueryTimeInterval(Duration.ofDays(2)), options, Context.NONE);
        // END: readme-sample-logsquerytimeout
    }

    /**
     * Sample to demonstrate querying multiple workspaces.
     */
    public void getLogsQueryFromMultipleWorkspaces() {
        // BEGIN: readme-sample-logsquerymultipleworkspaces
        LogsQueryClient logsQueryClient = new LogsQueryClientBuilder()
            .credential(new DefaultAzureCredentialBuilder().build())
            .buildClient();

        Response<LogsQueryResult> response = logsQueryClient.queryWorkspaceWithResponse("{workspace-id}", "{kusto-query}",
            new LogsQueryTimeInterval(Duration.ofDays(2)), new LogsQueryOptions()
                .setAdditionalWorkspaces(Arrays.asList("{additional-workspace-identifiers}")),
            Context.NONE);
        LogsQueryResult result = response.getValue();
        // END: readme-sample-logsquerymultipleworkspaces
    }

    /**
     * Enable HTTP request and response logging.
     */
    public void tsgEnableHttpLogging() {
        DefaultAzureCredential credential = new DefaultAzureCredentialBuilder().build();

        // BEGIN: readme-sample-enablehttplogging
        LogsQueryClient logsQueryClient = new LogsQueryClientBuilder()
            .credential(credential)
            .httpLogOptions(new HttpLogOptions().setLogLevel(HttpLogDetailLevel.BODY_AND_HEADERS))
            .buildClient();
        // END: readme-sample-enablehttplogging
    }

    /**
     * Sample to show how to set response timeout for http client.
     */
    public void tsgHttpResponseTimeout() {
        DefaultAzureCredential credential = new DefaultAzureCredentialBuilder().build();

        // BEGIN: readme-sample-responsetimeout
        LogsQueryClient client = new LogsQueryClientBuilder()
            .credential(credential)
            .clientOptions(new HttpClientOptions().setResponseTimeout(Duration.ofSeconds(120)))
            .buildClient();
        // END: readme-sample-responsetimeout
    }

    /**
     * Sample to show how to set server timeout.
     */
    public void tsgSetServerTimeout() {
        DefaultAzureCredential credential = new DefaultAzureCredentialBuilder().build();
        // BEGIN: readme-sample-servertimeout
        LogsQueryClient client = new LogsQueryClientBuilder()
            .credential(credential)
            .buildClient();

        client.queryWorkspaceWithResponse("{workspaceId}", "{kusto-query-string}", LogsQueryTimeInterval.LAST_DAY,
            new LogsQueryOptions().setServerTimeout(Duration.ofMinutes(10)), Context.NONE);
        // END: readme-sample-servertimeout
    }

    /**
     * Sample to show how to allow partial errors for logs queries.
     */
    public void tsgAllowPartialErrors() {
        DefaultAzureCredential credential = new DefaultAzureCredentialBuilder().build();

        LogsQueryClient client = new LogsQueryClientBuilder()
            .credential(credential)
            .buildClient();

        // BEGIN: readme-sample-allowpartialerrors
        client.queryWorkspaceWithResponse("{workspaceId}", "{kusto-query-string}", LogsQueryTimeInterval.LAST_DAY,
            new LogsQueryOptions().setAllowPartialErrors(true), Context.NONE);
        // END: readme-sample-allowpartialerrors
    }

    /**
     * Sample to show how to configure response timeout for OkHttp client.
     */
    public void tsgOkHttpResponseTimeout() {
        DefaultAzureCredential credential = new DefaultAzureCredentialBuilder().build();

        // BEGIN: readme-sample-okhttpresponsetimeout
        LogsQueryClient client = new LogsQueryClientBuilder()
            .credential(credential)
            .clientOptions(new HttpClientOptions().setResponseTimeout(Duration.ofSeconds(120)))
            .buildClient();
        // END: readme-sample-okhttpresponsetimeout
    }

    /**
     * Sample to show how to request for query execution statistics and consume the response.
     *
     * @throws IOException if parsing the statistics JSON fails.
     */
    public void includeStatistics() throws IOException {
        DefaultAzureCredential credential = new DefaultAzureCredentialBuilder().build();
        // BEGIN: readme-sample-includestatistics
        LogsQueryClient client = new LogsQueryClientBuilder()
            .credential(credential)
            .buildClient();

        LogsQueryOptions options = new LogsQueryOptions()
            .setIncludeStatistics(true);
        Response<LogsQueryResult> response = client.queryWorkspaceWithResponse("{workspace-id}",
            "AzureActivity | top 10 by TimeGenerated", LogsQueryTimeInterval.LAST_1_HOUR, options, Context.NONE);
        LogsQueryResult result = response.getValue();
        BinaryData statistics = result.getStatistics();

        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode statisticsJson = objectMapper.readTree(statistics.toBytes());
        JsonNode queryStatistics = statisticsJson.get("query");
        System.out.println("Query execution time = " + queryStatistics.get("executionTime").asDouble());
        // END: readme-sample-includestatistics
    }

    /**
     * Sample to show how to request for visualization data and consume the response.
     *
     * @throws IOException if parsing the visualization JSON fails.
     */
    public void includeVisualization() throws IOException {
        DefaultAzureCredential credential = new DefaultAzureCredentialBuilder().build();
        // BEGIN: readme-sample-includevisualization
        LogsQueryClient client = new LogsQueryClientBuilder()
            .credential(credential)
            .buildClient();

        String visualizationQuery = "StormEvents"
            + "| summarize event_count = count() by State"
            + "| where event_count > 10"
            + "| project State, event_count"
            + "| render columnchart";
        LogsQueryOptions options = new LogsQueryOptions()
            .setIncludeVisualization(true);
        Response<LogsQueryResult> response = client.queryWorkspaceWithResponse("{workspace-id}", visualizationQuery,
            LogsQueryTimeInterval.LAST_7_DAYS, options, Context.NONE);
        LogsQueryResult result = response.getValue();
        BinaryData visualization = result.getVisualization();

        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode visualizationJson = objectMapper.readTree(visualization.toBytes());
        System.out.println("Visualization graph type = " + visualizationJson.get("visualization").asText());
        // END: readme-sample-includevisualization
    }

    /**
     * Sample to show how to create a log query client using a sovereign cloud endpoint.
     */
    public void createLogsClientWithSovereignCloud() {
        // BEGIN: readme-sample-createLogsQueryClientWithSovereignCloud
        LogsQueryClient logsQueryClient = new LogsQueryClientBuilder()
            .credential(new DefaultAzureCredentialBuilder().build())
            .endpoint("https://api.loganalytics.azure.cn/v1")
            .buildClient();
        // END: readme-sample-createLogsQueryClientWithSovereignCloud
    }
}
