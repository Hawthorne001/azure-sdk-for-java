// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.containerservice.generated;

import com.azure.resourcemanager.containerservice.fluent.models.TrustedAccessRoleBindingInner;
import java.util.Arrays;

/**
 * Samples for TrustedAccessRoleBindings CreateOrUpdate.
 */
public final class TrustedAccessRoleBindingsCreateOrUpdateSamples {
    /*
     * x-ms-original-file:
     * specification/containerservice/resource-manager/Microsoft.ContainerService/aks/stable/2025-05-01/examples/
     * TrustedAccessRoleBindings_CreateOrUpdate.json
     */
    /**
     * Sample code: Create or update a trusted access role binding.
     * 
     * @param azure The entry point for accessing resource management APIs in Azure.
     */
    public static void createOrUpdateATrustedAccessRoleBinding(com.azure.resourcemanager.AzureResourceManager azure) {
        azure.kubernetesClusters()
            .manager()
            .serviceClient()
            .getTrustedAccessRoleBindings()
            .createOrUpdate("rg1", "clustername1", "binding1", new TrustedAccessRoleBindingInner().withSourceResourceId(
                "/subscriptions/00000000-0000-0000-0000-000000000000/resourceGroups/b/providers/Microsoft.MachineLearningServices/workspaces/c")
                .withRoles(Arrays.asList("Microsoft.MachineLearningServices/workspaces/reader",
                    "Microsoft.MachineLearningServices/workspaces/writer")),
                com.azure.core.util.Context.NONE);
    }
}
