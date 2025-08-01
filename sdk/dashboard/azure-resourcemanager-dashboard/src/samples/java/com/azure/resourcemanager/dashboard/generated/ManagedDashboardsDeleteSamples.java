// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) TypeSpec Code Generator.

package com.azure.resourcemanager.dashboard.generated;

/**
 * Samples for ManagedDashboards Delete.
 */
public final class ManagedDashboardsDeleteSamples {
    /*
     * x-ms-original-file: 2024-11-01-preview/Dashboard_Delete.json
     */
    /**
     * Sample code: Dashboard_Delete.
     * 
     * @param manager Entry point to DashboardManager.
     */
    public static void dashboardDelete(com.azure.resourcemanager.dashboard.DashboardManager manager) {
        manager.managedDashboards()
            .deleteByResourceGroupWithResponse("myResourceGroup", "myDashboard", com.azure.core.util.Context.NONE);
    }
}
