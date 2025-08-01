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
import com.azure.resourcemanager.policyinsights.models.CheckManagementGroupRestrictionsRequest;
import com.azure.resourcemanager.policyinsights.models.CheckRestrictionsResourceDetails;
import com.azure.resourcemanager.policyinsights.models.CheckRestrictionsResult;
import com.azure.resourcemanager.policyinsights.models.PendingField;
import java.nio.charset.StandardCharsets;
import java.time.OffsetDateTime;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;

public final class PolicyRestrictionsCheckAtManagementGroupScopeWithResponseMockTests {
    @Test
    public void testCheckAtManagementGroupScopeWithResponse() throws Exception {
        String responseStr
            = "{\"fieldRestrictions\":[{\"field\":\"wtewf\",\"restrictions\":[{\"result\":\"Required\",\"defaultValue\":\"b\",\"values\":[\"zl\",\"ynjpchamkaepl\",\"ajubo\",\"uywevtjrieikmwl\"],\"policy\":{},\"policyEffect\":\"lfnisyxg\",\"reason\":\"bmtredscnns\"},{\"result\":\"Audit\",\"defaultValue\":\"yuvtz\",\"values\":[\"hcle\",\"wwtzqzcloy\",\"yup\"],\"policy\":{},\"policyEffect\":\"hzgyresgzsd\",\"reason\":\"wbyorjplbchych\"},{\"result\":\"Deny\",\"defaultValue\":\"rfbqvumkxqjsiuep\",\"values\":[\"fnzlpqmp\",\"t\"],\"policy\":{},\"policyEffect\":\"vulb\",\"reason\":\"rtux\"},{\"result\":\"Audit\",\"defaultValue\":\"fcaeooifqdyw\",\"values\":[\"obhahqmomf\",\"corkfrocgbmxl\"],\"policy\":{},\"policyEffect\":\"zezbjes\",\"reason\":\"slurbqfygpny\"}]}],\"contentEvaluationResult\":{\"policyEvaluations\":[{\"policyInfo\":{\"policyDefinitionId\":\"sc\",\"policySetDefinitionId\":\"qyvoupr\",\"policyDefinitionReferenceId\":\"tqzsslhmgwfnivr\",\"policyAssignmentId\":\"fduiolhgyqvpb\"},\"evaluationResult\":\"poqzucfz\",\"evaluationDetails\":{\"evaluatedExpressions\":[{},{}],\"ifNotExistsDetails\":{},\"reason\":\"uurbor\"},\"effectDetails\":{\"policyEffect\":\"vzielb\"}}]}}";

        HttpClient httpClient
            = response -> Mono.just(new MockHttpResponse(response, 200, responseStr.getBytes(StandardCharsets.UTF_8)));
        PolicyInsightsManager manager = PolicyInsightsManager.configure()
            .withHttpClient(httpClient)
            .authenticate(tokenRequestContext -> Mono.just(new AccessToken("this_is_a_token", OffsetDateTime.MAX)),
                new AzureProfile("", "", AzureCloud.AZURE_PUBLIC_CLOUD));

        CheckRestrictionsResult response = manager.policyRestrictions()
            .checkAtManagementGroupScopeWithResponse("akmhz", new CheckManagementGroupRestrictionsRequest()
                .withResourceDetails(new CheckRestrictionsResourceDetails().withResourceContent("datawahfbwihbn")
                    .withApiVersion("em")
                    .withScope("nuqqkotauratnicp"))
                .withPendingFields(
                    Arrays.asList(new PendingField().withField("scle").withValues(Arrays.asList("letnd", "lmfdg", "n")),
                        new PendingField().withField("buypwovvv").withValues(Arrays.asList("eevnoqayreh")),
                        new PendingField().withField("uqwvapxrlzhpzih")
                            .withValues(Arrays.asList("nqqz", "xnq", "ubfonfdbgmkf")))),
                com.azure.core.util.Context.NONE)
            .getValue();

    }
}
