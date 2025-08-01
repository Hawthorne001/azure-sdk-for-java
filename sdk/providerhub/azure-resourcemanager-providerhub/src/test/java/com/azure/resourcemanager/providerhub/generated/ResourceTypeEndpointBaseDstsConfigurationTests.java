// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.providerhub.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.providerhub.models.ResourceTypeEndpointBaseDstsConfiguration;
import org.junit.jupiter.api.Assertions;

public final class ResourceTypeEndpointBaseDstsConfigurationTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        ResourceTypeEndpointBaseDstsConfiguration model
            = BinaryData.fromString("{\"serviceName\":\"zbfvxovqkxiu\",\"serviceDnsName\":\"ggvqrnhyhlwcjs\"}")
                .toObject(ResourceTypeEndpointBaseDstsConfiguration.class);
        Assertions.assertEquals("zbfvxovqkxiu", model.serviceName());
        Assertions.assertEquals("ggvqrnhyhlwcjs", model.serviceDnsName());
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        ResourceTypeEndpointBaseDstsConfiguration model
            = new ResourceTypeEndpointBaseDstsConfiguration().withServiceName("zbfvxovqkxiu")
                .withServiceDnsName("ggvqrnhyhlwcjs");
        model = BinaryData.fromObject(model).toObject(ResourceTypeEndpointBaseDstsConfiguration.class);
        Assertions.assertEquals("zbfvxovqkxiu", model.serviceName());
        Assertions.assertEquals("ggvqrnhyhlwcjs", model.serviceDnsName());
    }
}
