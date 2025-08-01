// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.providerhub.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.providerhub.models.ResourceGraphConfiguration;
import org.junit.jupiter.api.Assertions;

public final class ResourceGraphConfigurationTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        ResourceGraphConfiguration model
            = BinaryData.fromString("{\"enabled\":false,\"apiVersion\":\"godebfqkkrbmpu\"}")
                .toObject(ResourceGraphConfiguration.class);
        Assertions.assertFalse(model.enabled());
        Assertions.assertEquals("godebfqkkrbmpu", model.apiVersion());
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        ResourceGraphConfiguration model
            = new ResourceGraphConfiguration().withEnabled(false).withApiVersion("godebfqkkrbmpu");
        model = BinaryData.fromObject(model).toObject(ResourceGraphConfiguration.class);
        Assertions.assertFalse(model.enabled());
        Assertions.assertEquals("godebfqkkrbmpu", model.apiVersion());
    }
}
