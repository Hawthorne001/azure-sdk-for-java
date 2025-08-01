// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.cognitiveservices.generated;

/**
 * Samples for CommitmentPlans CreateOrUpdateAssociation.
 */
public final class CommitmentPlansCreateOrUpdateAssociationSamples {
    /*
     * x-ms-original-file:
     * specification/cognitiveservices/resource-manager/Microsoft.CognitiveServices/stable/2025-06-01/examples/
     * CreateSharedCommitmentPlanAssociation.json
     */
    /**
     * Sample code: PutCommitmentPlan.
     * 
     * @param manager Entry point to CognitiveServicesManager.
     */
    public static void putCommitmentPlan(com.azure.resourcemanager.cognitiveservices.CognitiveServicesManager manager) {
        manager.commitmentPlans()
            .defineAssociation("commitmentPlanAssociationName")
            .withExistingCommitmentPlan("resourceGroupName", "commitmentPlanName")
            .withAccountId(
                "/subscriptions/subscriptionId/resourceGroups/resourceGroupName/providers/Microsoft.CognitiveServices/accounts/accountName")
            .create();
    }
}
