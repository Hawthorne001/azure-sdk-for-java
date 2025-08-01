// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.policyinsights.generated;

import com.azure.resourcemanager.policyinsights.models.PolicyEventsResourceType;

/**
 * Samples for PolicyEvents ListQueryResultsForResource.
 */
public final class PolicyEventsListQueryResultsForResourceSamples {
    /*
     * x-ms-original-file:
     * specification/policyinsights/resource-manager/Microsoft.PolicyInsights/stable/2024-10-01/examples/
     * PolicyEvents_QuerySubscriptionLevelResourceScope.json
     */
    /**
     * Sample code: Query at subscription level resource scope.
     * 
     * @param manager Entry point to PolicyInsightsManager.
     */
    public static void
        queryAtSubscriptionLevelResourceScope(com.azure.resourcemanager.policyinsights.PolicyInsightsManager manager) {
        manager.policyEvents()
            .listQueryResultsForResource(PolicyEventsResourceType.DEFAULT,
                "subscriptions/fff10b27-fff3-fff5-fff8-fffbe01e86a5/providers/Microsoft.SomeNamespace/someResourceType/someResourceName",
                null, null, null, null, null, null, null, null, null, com.azure.core.util.Context.NONE);
    }

    /*
     * x-ms-original-file:
     * specification/policyinsights/resource-manager/Microsoft.PolicyInsights/stable/2024-10-01/examples/
     * PolicyEvents_QueryNestedResourceScope.json
     */
    /**
     * Sample code: Query at nested resource scope.
     * 
     * @param manager Entry point to PolicyInsightsManager.
     */
    public static void
        queryAtNestedResourceScope(com.azure.resourcemanager.policyinsights.PolicyInsightsManager manager) {
        manager.policyEvents()
            .listQueryResultsForResource(PolicyEventsResourceType.DEFAULT,
                "subscriptions/fff10b27-fff3-fff5-fff8-fffbe01e86a5/resourceGroups/myResourceGroup/providers/Microsoft.ServiceFabric/clusters/myCluster/applications/myApplication",
                null, null, null, null, null, null, null, null, null, com.azure.core.util.Context.NONE);
    }

    /*
     * x-ms-original-file:
     * specification/policyinsights/resource-manager/Microsoft.PolicyInsights/stable/2024-10-01/examples/
     * PolicyEvents_QuerySubscriptionLevelNestedResourceScope.json
     */
    /**
     * Sample code: Query at subscription level nested resource scope.
     * 
     * @param manager Entry point to PolicyInsightsManager.
     */
    public static void queryAtSubscriptionLevelNestedResourceScope(
        com.azure.resourcemanager.policyinsights.PolicyInsightsManager manager) {
        manager.policyEvents()
            .listQueryResultsForResource(PolicyEventsResourceType.DEFAULT,
                "subscriptions/fff10b27-fff3-fff5-fff8-fffbe01e86a5/providers/Microsoft.SomeNamespace/someResourceType/someResource/someNestedResourceType/someNestedResource",
                null, null, null, null, null, null, null, null, null, com.azure.core.util.Context.NONE);
    }

    /*
     * x-ms-original-file:
     * specification/policyinsights/resource-manager/Microsoft.PolicyInsights/stable/2024-10-01/examples/
     * PolicyEvents_QueryResourceScope.json
     */
    /**
     * Sample code: Query at resource scope.
     * 
     * @param manager Entry point to PolicyInsightsManager.
     */
    public static void queryAtResourceScope(com.azure.resourcemanager.policyinsights.PolicyInsightsManager manager) {
        manager.policyEvents()
            .listQueryResultsForResource(PolicyEventsResourceType.DEFAULT,
                "subscriptions/fff10b27-fff3-fff5-fff8-fffbe01e86a5/resourceGroups/myResourceGroup/providers/Microsoft.ClassicCompute/domainNames/myDomainName",
                null, null, null, null, null, null, null, null, null, com.azure.core.util.Context.NONE);
    }

    /*
     * x-ms-original-file:
     * specification/policyinsights/resource-manager/Microsoft.PolicyInsights/stable/2024-10-01/examples/
     * PolicyEvents_QueryResourceScopeExpandComponents.json
     */
    /**
     * Sample code: Query components policy events for resource scope filtered by given assignment.
     * 
     * @param manager Entry point to PolicyInsightsManager.
     */
    public static void queryComponentsPolicyEventsForResourceScopeFilteredByGivenAssignment(
        com.azure.resourcemanager.policyinsights.PolicyInsightsManager manager) {
        manager.policyEvents()
            .listQueryResultsForResource(PolicyEventsResourceType.DEFAULT,
                "subscriptions/e78961ba-36fe-4739-9212-e3031b4c8db7/resourceGroups/myResourceGroup/providers/Microsoft.KeyVault/Vaults/myKVName",
                null, null, null, null, null,
                "policyAssignmentId eq '/subscriptions/e78961ba-36fe-4739-9212-e3031b4c8db7/providers/microsoft.authorization/policyassignments/560050f83dbb4a24974323f8'",
                null, "components", null, com.azure.core.util.Context.NONE);
    }

    /*
     * x-ms-original-file:
     * specification/policyinsights/resource-manager/Microsoft.PolicyInsights/stable/2024-10-01/examples/
     * PolicyEvents_QueryResourceScopeExpandComponentsGroupByWithAggregate.json
     */
    /**
     * Sample code: Query components policy events count grouped by user and action type for resource scope filtered by
     * given assignment.
     * 
     * @param manager Entry point to PolicyInsightsManager.
     */
    public static void
        queryComponentsPolicyEventsCountGroupedByUserAndActionTypeForResourceScopeFilteredByGivenAssignment(
            com.azure.resourcemanager.policyinsights.PolicyInsightsManager manager) {
        manager.policyEvents()
            .listQueryResultsForResource(PolicyEventsResourceType.DEFAULT,
                "subscriptions/e78961ba-36fe-4739-9212-e3031b4c8db7/resourceGroups/myResourceGroup/providers/Microsoft.KeyVault/Vaults/myKVName",
                null, null, null, null, null,
                "policyAssignmentId eq '/subscriptions/e78961ba-36fe-4739-9212-e3031b4c8db7/providers/microsoft.authorization/policyassignments/560050f83dbb4a24974323f8'",
                null,
                "components($apply=groupby((tenantId, principalOid, policyDefinitionAction), aggregate($count as totalActions)))",
                null, com.azure.core.util.Context.NONE);
    }

    /*
     * x-ms-original-file:
     * specification/policyinsights/resource-manager/Microsoft.PolicyInsights/stable/2024-10-01/examples/
     * PolicyEvents_QueryResourceScopeNextLink.json
     */
    /**
     * Sample code: Query at resource scope with next link.
     * 
     * @param manager Entry point to PolicyInsightsManager.
     */
    public static void
        queryAtResourceScopeWithNextLink(com.azure.resourcemanager.policyinsights.PolicyInsightsManager manager) {
        manager.policyEvents()
            .listQueryResultsForResource(PolicyEventsResourceType.DEFAULT,
                "subscriptions/fff10b27-fff3-fff5-fff8-fffbe01e86a5/resourceGroups/myResourceGroup/providers/Microsoft.ClassicCompute/domainNames/myDomainName",
                null, null, null, null, null, null, null, null, "WpmWfBSvPhkAK6QD", com.azure.core.util.Context.NONE);
    }
}
