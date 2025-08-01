// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.appservice.generated;

/**
 * Samples for AppServiceEnvironments TestUpgradeAvailableNotification.
 */
public final class AppServiceEnvironmentsTestUpgradeAvailableNotificationSamples {
    /*
     * x-ms-original-file: specification/web/resource-manager/Microsoft.Web/stable/2024-11-01/examples/
     * AppServiceEnvironments_TestUpgradeAvailableNotification.json
     */
    /**
     * Sample code: Send a test notification that an upgrade is available for this App Service Environment.
     * 
     * @param azure The entry point for accessing resource management APIs in Azure.
     */
    public static void sendATestNotificationThatAnUpgradeIsAvailableForThisAppServiceEnvironment(
        com.azure.resourcemanager.AzureResourceManager azure) {
        azure.webApps()
            .manager()
            .serviceClient()
            .getAppServiceEnvironments()
            .testUpgradeAvailableNotificationWithResponse("rg", "SampleHostingEnvironment",
                com.azure.core.util.Context.NONE);
    }
}
