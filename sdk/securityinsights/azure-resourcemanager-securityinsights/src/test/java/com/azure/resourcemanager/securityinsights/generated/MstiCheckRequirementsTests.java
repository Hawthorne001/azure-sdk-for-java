// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.securityinsights.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.securityinsights.models.MstiCheckRequirements;
import org.junit.jupiter.api.Assertions;

public final class MstiCheckRequirementsTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        MstiCheckRequirements model = BinaryData
            .fromString("{\"kind\":\"MicrosoftThreatIntelligence\",\"properties\":{\"tenantId\":\"qxwabzrwiqrxh\"}}")
            .toObject(MstiCheckRequirements.class);
        Assertions.assertEquals("qxwabzrwiqrxh", model.tenantId());
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        MstiCheckRequirements model = new MstiCheckRequirements().withTenantId("qxwabzrwiqrxh");
        model = BinaryData.fromObject(model).toObject(MstiCheckRequirements.class);
        Assertions.assertEquals("qxwabzrwiqrxh", model.tenantId());
    }
}
