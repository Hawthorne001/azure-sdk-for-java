// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.cognitiveservices.generated;

import com.azure.resourcemanager.cognitiveservices.models.ContentLevel;
import com.azure.resourcemanager.cognitiveservices.models.RaiPolicyContentFilter;
import com.azure.resourcemanager.cognitiveservices.models.RaiPolicyContentSource;
import com.azure.resourcemanager.cognitiveservices.models.RaiPolicyMode;
import com.azure.resourcemanager.cognitiveservices.models.RaiPolicyProperties;
import java.util.Arrays;

/**
 * Samples for RaiPolicies CreateOrUpdate.
 */
public final class RaiPoliciesCreateOrUpdateSamples {
    /*
     * x-ms-original-file:
     * specification/cognitiveservices/resource-manager/Microsoft.CognitiveServices/stable/2025-06-01/examples/
     * PutRaiPolicy.json
     */
    /**
     * Sample code: PutRaiPolicy.
     * 
     * @param manager Entry point to CognitiveServicesManager.
     */
    public static void putRaiPolicy(com.azure.resourcemanager.cognitiveservices.CognitiveServicesManager manager) {
        manager.raiPolicies()
            .define("raiPolicyName")
            .withExistingAccount("resourceGroupName", "accountName")
            .withProperties(new RaiPolicyProperties().withMode(RaiPolicyMode.ASYNCHRONOUS_FILTER)
                .withBasePolicyName("Microsoft.Default")
                .withContentFilters(Arrays.asList(
                    new RaiPolicyContentFilter().withName("Hate")
                        .withEnabled(false)
                        .withSeverityThreshold(ContentLevel.HIGH)
                        .withBlocking(false)
                        .withSource(RaiPolicyContentSource.PROMPT),
                    new RaiPolicyContentFilter().withName("Hate")
                        .withEnabled(true)
                        .withSeverityThreshold(ContentLevel.MEDIUM)
                        .withBlocking(true)
                        .withSource(RaiPolicyContentSource.COMPLETION),
                    new RaiPolicyContentFilter().withName("Sexual")
                        .withEnabled(true)
                        .withSeverityThreshold(ContentLevel.HIGH)
                        .withBlocking(true)
                        .withSource(RaiPolicyContentSource.PROMPT),
                    new RaiPolicyContentFilter().withName("Sexual")
                        .withEnabled(true)
                        .withSeverityThreshold(ContentLevel.MEDIUM)
                        .withBlocking(true)
                        .withSource(RaiPolicyContentSource.COMPLETION),
                    new RaiPolicyContentFilter().withName("Selfharm")
                        .withEnabled(true)
                        .withSeverityThreshold(ContentLevel.HIGH)
                        .withBlocking(true)
                        .withSource(RaiPolicyContentSource.PROMPT),
                    new RaiPolicyContentFilter().withName("Selfharm")
                        .withEnabled(true)
                        .withSeverityThreshold(ContentLevel.MEDIUM)
                        .withBlocking(true)
                        .withSource(RaiPolicyContentSource.COMPLETION),
                    new RaiPolicyContentFilter().withName("Violence")
                        .withEnabled(true)
                        .withSeverityThreshold(ContentLevel.MEDIUM)
                        .withBlocking(true)
                        .withSource(RaiPolicyContentSource.PROMPT),
                    new RaiPolicyContentFilter().withName("Violence")
                        .withEnabled(true)
                        .withSeverityThreshold(ContentLevel.MEDIUM)
                        .withBlocking(true)
                        .withSource(RaiPolicyContentSource.COMPLETION),
                    new RaiPolicyContentFilter().withName("Jailbreak")
                        .withEnabled(true)
                        .withBlocking(true)
                        .withSource(RaiPolicyContentSource.PROMPT),
                    new RaiPolicyContentFilter().withName("Protected Material Text")
                        .withEnabled(true)
                        .withBlocking(true)
                        .withSource(RaiPolicyContentSource.COMPLETION),
                    new RaiPolicyContentFilter().withName("Protected Material Code")
                        .withEnabled(true)
                        .withBlocking(true)
                        .withSource(RaiPolicyContentSource.COMPLETION),
                    new RaiPolicyContentFilter().withName("Profanity")
                        .withEnabled(true)
                        .withBlocking(true)
                        .withSource(RaiPolicyContentSource.PROMPT))))
            .create();
    }
}
