// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.servicefabricmanagedclusters.generated;

/**
 * Samples for Services ListByApplications.
 */
public final class ServicesListByApplicationsSamples {
    /*
     * x-ms-original-file:
     * specification/servicefabricmanagedclusters/resource-manager/Microsoft.ServiceFabric/preview/2024-06-01-preview/
     * examples/ServiceListOperation_example.json
     */
    /**
     * Sample code: Get a list of service resources.
     * 
     * @param manager Entry point to ServiceFabricManagedClustersManager.
     */
    public static void getAListOfServiceResources(
        com.azure.resourcemanager.servicefabricmanagedclusters.ServiceFabricManagedClustersManager manager) {
        manager.services().listByApplications("resRg", "myCluster", "myApp", com.azure.core.util.Context.NONE);
    }
}
