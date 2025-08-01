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
import com.azure.resourcemanager.policyinsights.fluent.models.RemediationInner;
import com.azure.resourcemanager.policyinsights.models.Remediation;
import com.azure.resourcemanager.policyinsights.models.RemediationFilters;
import com.azure.resourcemanager.policyinsights.models.RemediationPropertiesFailureThreshold;
import com.azure.resourcemanager.policyinsights.models.ResourceDiscoveryMode;
import java.nio.charset.StandardCharsets;
import java.time.OffsetDateTime;
import java.util.Arrays;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;

public final class RemediationsCreateOrUpdateAtManagementGroupWithResponseMockTests {
    @Test
    public void testCreateOrUpdateAtManagementGroupWithResponse() throws Exception {
        String responseStr
            = "{\"properties\":{\"policyAssignmentId\":\"lfg\",\"policyDefinitionReferenceId\":\"nnnoytz\",\"resourceDiscoveryMode\":\"ReEvaluateCompliance\",\"provisioningState\":\"wxigpxv\",\"createdOn\":\"2021-08-07T19:20:08Z\",\"lastUpdatedOn\":\"2021-12-09T00:40:20Z\",\"filters\":{\"locations\":[\"pifdfaifyzyzeyu\",\"beidsz\"],\"resourceIds\":[\"toi\",\"hgygvfltgvd\",\"hoynk\"]},\"deploymentStatus\":{\"totalDeployments\":1089031393,\"successfulDeployments\":596068395,\"failedDeployments\":756482061},\"statusMessage\":\"cy\",\"correlationId\":\"cpcunnuzdqum\",\"resourceCount\":559723693,\"parallelDeployments\":1929765452,\"failureThreshold\":{\"percentage\":81.90971}},\"id\":\"nhq\",\"name\":\"skndnelqkaadlknw\",\"type\":\"oanniyopetxi\"}";

        HttpClient httpClient
            = response -> Mono.just(new MockHttpResponse(response, 200, responseStr.getBytes(StandardCharsets.UTF_8)));
        PolicyInsightsManager manager = PolicyInsightsManager.configure()
            .withHttpClient(httpClient)
            .authenticate(tokenRequestContext -> Mono.just(new AccessToken("this_is_a_token", OffsetDateTime.MAX)),
                new AzureProfile("", "", AzureCloud.AZURE_PUBLIC_CLOUD));

        Remediation response = manager.remediations()
            .createOrUpdateAtManagementGroupWithResponse("w", "yos",
                new RemediationInner().withPolicyAssignmentId("hnhjtfvpndpmi")
                    .withPolicyDefinitionReferenceId("pnwy")
                    .withResourceDiscoveryMode(ResourceDiscoveryMode.RE_EVALUATE_COMPLIANCE)
                    .withFilters(new RemediationFilters()
                        .withLocations(Arrays.asList("xiqhzlraymezxlsk", "hmx", "fdsajred", "wyyshtuwgm"))
                        .withResourceIds(Arrays.asList("afpwzyifrkgwl", "xeqipx", "zdyi")))
                    .withResourceCount(1693738620)
                    .withParallelDeployments(313227377)
                    .withFailureThreshold(new RemediationPropertiesFailureThreshold().withPercentage(69.44405F)),
                com.azure.core.util.Context.NONE)
            .getValue();

        Assertions.assertEquals("lfg", response.policyAssignmentId());
        Assertions.assertEquals("nnnoytz", response.policyDefinitionReferenceId());
        Assertions.assertEquals(ResourceDiscoveryMode.RE_EVALUATE_COMPLIANCE, response.resourceDiscoveryMode());
        Assertions.assertEquals("pifdfaifyzyzeyu", response.filters().locations().get(0));
        Assertions.assertEquals("toi", response.filters().resourceIds().get(0));
        Assertions.assertEquals(559723693, response.resourceCount());
        Assertions.assertEquals(1929765452, response.parallelDeployments());
        Assertions.assertEquals(81.90971F, response.failureThreshold().percentage());
    }
}
