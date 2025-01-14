// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.securityinsights.generated;

import com.azure.core.credential.AccessToken;
import com.azure.core.http.HttpClient;
import com.azure.core.management.AzureEnvironment;
import com.azure.core.management.profile.AzureProfile;
import com.azure.core.test.http.MockHttpResponse;
import com.azure.resourcemanager.securityinsights.SecurityInsightsManager;
import com.azure.resourcemanager.securityinsights.models.CustomEntityQuery;
import com.azure.resourcemanager.securityinsights.models.EntityQuery;
import java.nio.charset.StandardCharsets;
import java.time.OffsetDateTime;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;

public final class EntityQueriesCreateOrUpdateWithResponseMockTests {
    @Test
    public void testCreateOrUpdateWithResponse() throws Exception {
        String responseStr
            = "{\"kind\":\"EntityQuery\",\"etag\":\"mmynbrpelpfi\",\"id\":\"ezgxmpeszam\",\"name\":\"dlerzin\",\"type\":\"ui\"}";

        HttpClient httpClient
            = response -> Mono.just(new MockHttpResponse(response, 200, responseStr.getBytes(StandardCharsets.UTF_8)));
        SecurityInsightsManager manager = SecurityInsightsManager.configure()
            .withHttpClient(httpClient)
            .authenticate(tokenRequestContext -> Mono.just(new AccessToken("this_is_a_token", OffsetDateTime.MAX)),
                new AzureProfile("", "", AzureEnvironment.AZURE));

        EntityQuery response = manager.entityQueries()
            .createOrUpdateWithResponse("yozdbc", "qnl", "jxcscnitodmrah",
                new CustomEntityQuery().withEtag("idodnvltc"), com.azure.core.util.Context.NONE)
            .getValue();

        Assertions.assertEquals("mmynbrpelpfi", response.etag());
    }
}
