// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.policyinsights.generated;

import com.azure.core.credential.AccessToken;
import com.azure.core.http.HttpClient;
import com.azure.core.http.rest.PagedIterable;
import com.azure.core.management.profile.AzureProfile;
import com.azure.core.models.AzureCloud;
import com.azure.core.test.http.MockHttpResponse;
import com.azure.resourcemanager.policyinsights.PolicyInsightsManager;
import com.azure.resourcemanager.policyinsights.models.PolicyEvent;
import com.azure.resourcemanager.policyinsights.models.PolicyEventsResourceType;
import java.nio.charset.StandardCharsets;
import java.time.OffsetDateTime;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;

public final class PolicyEventsListQueryResultsForPolicyDefinitionMockTests {
    @Test
    public void testListQueryResultsForPolicyDefinition() throws Exception {
        String responseStr
            = "{\"value\":[{\"@odata.id\":\"tcvbiiftk\",\"@odata.context\":\"w\",\"timestamp\":\"2021-05-18T12:56:59Z\",\"resourceId\":\"efgmwdhcebuv\",\"policyAssignmentId\":\"ldbglzout\",\"policyDefinitionId\":\"aqgzekajclyzgs\",\"effectiveParameters\":\"rbjgmn\",\"isCompliant\":false,\"subscriptionId\":\"vmrxkhlobvvjbh\",\"resourceType\":\"diqayfl\",\"resourceLocation\":\"yu\",\"resourceGroup\":\"n\",\"resourceTags\":\"dtelvhyibdrqrs\",\"policyAssignmentName\":\"buubpyrowt\",\"policyAssignmentOwner\":\"xztfwfqchvczevj\",\"policyAssignmentParameters\":\"cta\",\"policyAssignmentScope\":\"yvrtp\",\"policyDefinitionName\":\"emhzc\",\"policyDefinitionAction\":\"repdqhqyhwq\",\"policyDefinitionCategory\":\"mvxqab\",\"policySetDefinitionId\":\"mzeoxinhgre\",\"policySetDefinitionName\":\"twhlpuzjpce\",\"policySetDefinitionOwner\":\"nzangprbfaxy\",\"policySetDefinitionCategory\":\"lbciphmsexro\",\"policySetDefinitionParameters\":\"ndktxfv\",\"managementGroupIds\":\"feeqgpkrietbgnix\",\"policyDefinitionReferenceId\":\"wwzkyf\",\"complianceState\":\"wpiwxeiicrmpep\",\"tenantId\":\"dm\",\"principalOid\":\"xijvskwsdgkjgyac\",\"components\":[{\"id\":\"ekwefcvoinw\",\"type\":\"artwyxqic\",\"name\":\"dvatdavuqm\",\"timestamp\":\"2021-01-02T08:29:59Z\",\"tenantId\":\"sfobjl\",\"principalOid\":\"vjezcjumvpsim\",\"policyDefinitionAction\":\"yoi\",\"ibb\":\"datamiqwnnrac\"},{\"id\":\"pspkladydgnhautw\",\"type\":\"exzgpmnmabedd\",\"name\":\"lwgdfpfqfpcvs\",\"timestamp\":\"2021-02-05T18:41:10Z\",\"tenantId\":\"qrvwerfwxbsm\",\"principalOid\":\"ljjehhcifkwdvb\",\"policyDefinitionAction\":\"rek\",\"uwyqwdq\":\"dataqhtfpwpqbye\",\"cmrnkfmkhcq\":\"datagmghginztxlujkhn\"},{\"id\":\"mlm\",\"type\":\"nqtqea\",\"name\":\"e\",\"timestamp\":\"2021-11-25T13:43:37Z\",\"tenantId\":\"gpokddxejhhkvgu\",\"principalOid\":\"tpt\",\"policyDefinitionAction\":\"ewkq\",\"offbkkwvdxaexqok\":\"datapgb\"},{\"id\":\"rlj\",\"type\":\"lzbnobrqlpbcjt\",\"name\":\"zuyudivbxnh\",\"timestamp\":\"2021-06-07T04:03:52Z\",\"tenantId\":\"eonqelwgdhuru\",\"principalOid\":\"tzarogatmoljiy\",\"policyDefinitionAction\":\"pinm\",\"lugdybnhrxlelf\":\"datakneerzztrknsj\",\"htdm\":\"datahkeizcp\",\"c\":\"datawjekptycaydbj\"}],\"hmhsurlgwqkpm\":\"datalcfn\",\"msgvvjhvvlrloh\":\"datazpstauolawiubm\",\"ns\":\"datawjjmajnkdflqi\",\"otryegp\":\"dataaeqkzfzqxjoshoh\"}]}";

        HttpClient httpClient
            = response -> Mono.just(new MockHttpResponse(response, 200, responseStr.getBytes(StandardCharsets.UTF_8)));
        PolicyInsightsManager manager = PolicyInsightsManager.configure()
            .withHttpClient(httpClient)
            .authenticate(tokenRequestContext -> Mono.just(new AccessToken("this_is_a_token", OffsetDateTime.MAX)),
                new AzureProfile("", "", AzureCloud.AZURE_PUBLIC_CLOUD));

        PagedIterable<PolicyEvent> response = manager.policyEvents()
            .listQueryResultsForPolicyDefinition(PolicyEventsResourceType.DEFAULT, "qk", "xym", 592817362, "qvfqepdxc",
                "tuubwyvpjb", OffsetDateTime.parse("2021-01-06T03:48:44Z"),
                OffsetDateTime.parse("2020-12-28T12:33:50Z"), "pjqduqgix", "xkydfbwlja", "huerkjddvrglie",
                com.azure.core.util.Context.NONE);

        Assertions.assertEquals(OffsetDateTime.parse("2021-05-18T12:56:59Z"), response.iterator().next().timestamp());
        Assertions.assertEquals("efgmwdhcebuv", response.iterator().next().resourceId());
        Assertions.assertEquals("ldbglzout", response.iterator().next().policyAssignmentId());
        Assertions.assertEquals("aqgzekajclyzgs", response.iterator().next().policyDefinitionId());
        Assertions.assertEquals("rbjgmn", response.iterator().next().effectiveParameters());
        Assertions.assertFalse(response.iterator().next().isCompliant());
        Assertions.assertEquals("vmrxkhlobvvjbh", response.iterator().next().subscriptionId());
        Assertions.assertEquals("diqayfl", response.iterator().next().resourceType());
        Assertions.assertEquals("yu", response.iterator().next().resourceLocation());
        Assertions.assertEquals("n", response.iterator().next().resourceGroup());
        Assertions.assertEquals("dtelvhyibdrqrs", response.iterator().next().resourceTags());
        Assertions.assertEquals("buubpyrowt", response.iterator().next().policyAssignmentName());
        Assertions.assertEquals("xztfwfqchvczevj", response.iterator().next().policyAssignmentOwner());
        Assertions.assertEquals("cta", response.iterator().next().policyAssignmentParameters());
        Assertions.assertEquals("yvrtp", response.iterator().next().policyAssignmentScope());
        Assertions.assertEquals("emhzc", response.iterator().next().policyDefinitionName());
        Assertions.assertEquals("repdqhqyhwq", response.iterator().next().policyDefinitionAction());
        Assertions.assertEquals("mvxqab", response.iterator().next().policyDefinitionCategory());
        Assertions.assertEquals("mzeoxinhgre", response.iterator().next().policySetDefinitionId());
        Assertions.assertEquals("twhlpuzjpce", response.iterator().next().policySetDefinitionName());
        Assertions.assertEquals("nzangprbfaxy", response.iterator().next().policySetDefinitionOwner());
        Assertions.assertEquals("lbciphmsexro", response.iterator().next().policySetDefinitionCategory());
        Assertions.assertEquals("ndktxfv", response.iterator().next().policySetDefinitionParameters());
        Assertions.assertEquals("feeqgpkrietbgnix", response.iterator().next().managementGroupIds());
        Assertions.assertEquals("wwzkyf", response.iterator().next().policyDefinitionReferenceId());
        Assertions.assertEquals("wpiwxeiicrmpep", response.iterator().next().complianceState());
        Assertions.assertEquals("dm", response.iterator().next().tenantId());
        Assertions.assertEquals("xijvskwsdgkjgyac", response.iterator().next().principalOid());
        Assertions.assertEquals("ekwefcvoinw", response.iterator().next().components().get(0).id());
        Assertions.assertEquals("artwyxqic", response.iterator().next().components().get(0).type());
        Assertions.assertEquals("dvatdavuqm", response.iterator().next().components().get(0).name());
        Assertions.assertEquals(OffsetDateTime.parse("2021-01-02T08:29:59Z"),
            response.iterator().next().components().get(0).timestamp());
        Assertions.assertEquals("sfobjl", response.iterator().next().components().get(0).tenantId());
        Assertions.assertEquals("vjezcjumvpsim", response.iterator().next().components().get(0).principalOid());
        Assertions.assertEquals("yoi", response.iterator().next().components().get(0).policyDefinitionAction());
    }
}
