// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.eventgrid.generated;

/**
 * Samples for ClientGroups Get.
 */
public final class ClientGroupsGetSamples {
    /*
     * x-ms-original-file:
     * specification/eventgrid/resource-manager/Microsoft.EventGrid/preview/2025-04-01-preview/examples/ClientGroups_Get
     * .json
     */
    /**
     * Sample code: ClientGroups_Get.
     * 
     * @param manager Entry point to EventGridManager.
     */
    public static void clientGroupsGet(com.azure.resourcemanager.eventgrid.EventGridManager manager) {
        manager.clientGroups()
            .getWithResponse("examplerg", "exampleNamespaceName1", "exampleClientGroupName1",
                com.azure.core.util.Context.NONE);
    }
}
