// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.servicenetworking.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.servicenetworking.models.SecurityPolicyUpdateProperties;
import com.azure.resourcemanager.servicenetworking.models.WafPolicyUpdate;
import org.junit.jupiter.api.Assertions;

public final class SecurityPolicyUpdatePropertiesTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        SecurityPolicyUpdateProperties model
            = BinaryData.fromString("{\"wafPolicy\":{\"id\":\"dmoh\"}}").toObject(SecurityPolicyUpdateProperties.class);
        Assertions.assertEquals("dmoh", model.wafPolicy().id());
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        SecurityPolicyUpdateProperties model
            = new SecurityPolicyUpdateProperties().withWafPolicy(new WafPolicyUpdate().withId("dmoh"));
        model = BinaryData.fromObject(model).toObject(SecurityPolicyUpdateProperties.class);
        Assertions.assertEquals("dmoh", model.wafPolicy().id());
    }
}
