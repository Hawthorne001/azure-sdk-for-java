// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.eventgrid.generated;

/**
 * Samples for Namespaces GetByResourceGroup.
 */
public final class NamespacesGetByResourceGroupSamples {
    /*
     * x-ms-original-file:
     * specification/eventgrid/resource-manager/Microsoft.EventGrid/preview/2025-04-01-preview/examples/Namespaces_Get.
     * json
     */
    /**
     * Sample code: Namespaces_Get.
     * 
     * @param manager Entry point to EventGridManager.
     */
    public static void namespacesGet(com.azure.resourcemanager.eventgrid.EventGridManager manager) {
        manager.namespaces()
            .getByResourceGroupWithResponse("examplerg", "exampleNamespaceName1", com.azure.core.util.Context.NONE);
    }
}
