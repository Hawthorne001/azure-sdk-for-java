// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.eventgrid.generated;

/**
 * Samples for TopicSpaces Get.
 */
public final class TopicSpacesGetSamples {
    /*
     * x-ms-original-file:
     * specification/eventgrid/resource-manager/Microsoft.EventGrid/preview/2025-04-01-preview/examples/TopicSpaces_Get.
     * json
     */
    /**
     * Sample code: TopicSpaces_Get.
     * 
     * @param manager Entry point to EventGridManager.
     */
    public static void topicSpacesGet(com.azure.resourcemanager.eventgrid.EventGridManager manager) {
        manager.topicSpaces()
            .getWithResponse("examplerg", "exampleNamespaceName1", "exampleTopicSpaceName1",
                com.azure.core.util.Context.NONE);
    }
}
