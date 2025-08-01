// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.eventgrid.generated;

/**
 * Samples for DomainEventSubscriptions GetDeliveryAttributes.
 */
public final class DomainEventSubscriptionsGetDeliveryAttributesSamples {
    /*
     * x-ms-original-file:
     * specification/eventgrid/resource-manager/Microsoft.EventGrid/preview/2025-04-01-preview/examples/
     * DomainEventSubscriptions_GetDeliveryAttributes.json
     */
    /**
     * Sample code: DomainEventSubscriptions_GetDeliveryAttributes.
     * 
     * @param manager Entry point to EventGridManager.
     */
    public static void
        domainEventSubscriptionsGetDeliveryAttributes(com.azure.resourcemanager.eventgrid.EventGridManager manager) {
        manager.domainEventSubscriptions()
            .getDeliveryAttributesWithResponse("examplerg", "exampleDomain1", "examplesubscription1",
                com.azure.core.util.Context.NONE);
    }
}
