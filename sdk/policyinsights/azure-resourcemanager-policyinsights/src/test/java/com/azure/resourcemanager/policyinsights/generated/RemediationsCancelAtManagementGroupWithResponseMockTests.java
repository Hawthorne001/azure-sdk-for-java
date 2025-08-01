// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.policyinsights.generated;

import com.azure.core.credential.AccessToken;
import com.azure.core.http.HttpClient;
import com.azure.core.management.profile.AzureProfile;
import com.azure.core.models.AzureCloud;
import com.azure.core.test.http.MockHttpResponse;
import com.azure.resourcemanager.policyinsights.PolicyInsightsManager;
import com.azure.resourcemanager.policyinsights.models.Remediation;
import com.azure.resourcemanager.policyinsights.models.ResourceDiscoveryMode;
import java.nio.charset.StandardCharsets;
import java.time.OffsetDateTime;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;

public final class RemediationsCancelAtManagementGroupWithResponseMockTests {
    @Test
    public void testCancelAtManagementGroupWithResponse() throws Exception {
        String responseStr
            = "{\"properties\":{\"policyAssignmentId\":\"rexdndsbd\",\"policyDefinitionReferenceId\":\"aderzmw\",\"resourceDiscoveryMode\":\"ReEvaluateCompliance\",\"provisioningState\":\"agttm\",\"createdOn\":\"2021-03-24T23:25Z\",\"lastUpdatedOn\":\"2021-08-21T23:53:46Z\",\"filters\":{\"locations\":[\"ylkjztjiuazjcg\",\"xitp\",\"inzcpdltkrlgj\"],\"resourceIds\":[\"drvcqguef\"]},\"deploymentStatus\":{\"totalDeployments\":1947892052,\"successfulDeployments\":2030832343,\"failedDeployments\":1763207717},\"statusMessage\":\"urelyujlfyoump\",\"correlationId\":\"yec\",\"resourceCount\":980739817,\"parallelDeployments\":1201293721,\"failureThreshold\":{\"percentage\":63.14531}},\"id\":\"brzmqxucycijoclx\",\"name\":\"utgjcyz\",\"type\":\"zjd\"}";

        HttpClient httpClient
            = response -> Mono.just(new MockHttpResponse(response, 200, responseStr.getBytes(StandardCharsets.UTF_8)));
        PolicyInsightsManager manager = PolicyInsightsManager.configure()
            .withHttpClient(httpClient)
            .authenticate(tokenRequestContext -> Mono.just(new AccessToken("this_is_a_token", OffsetDateTime.MAX)),
                new AzureProfile("", "", AzureCloud.AZURE_PUBLIC_CLOUD));

        Remediation response = manager.remediations()
            .cancelAtManagementGroupWithResponse("vhcs", "hzlwxaea", com.azure.core.util.Context.NONE)
            .getValue();

        Assertions.assertEquals("rexdndsbd", response.policyAssignmentId());
        Assertions.assertEquals("aderzmw", response.policyDefinitionReferenceId());
        Assertions.assertEquals(ResourceDiscoveryMode.RE_EVALUATE_COMPLIANCE, response.resourceDiscoveryMode());
        Assertions.assertEquals("ylkjztjiuazjcg", response.filters().locations().get(0));
        Assertions.assertEquals("drvcqguef", response.filters().resourceIds().get(0));
        Assertions.assertEquals(980739817, response.resourceCount());
        Assertions.assertEquals(1201293721, response.parallelDeployments());
        Assertions.assertEquals(63.14531F, response.failureThreshold().percentage());
    }
}
