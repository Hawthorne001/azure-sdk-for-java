// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.securityinsights.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.securityinsights.models.AlertSeverity;
import com.azure.resourcemanager.securityinsights.models.FusionSourceSubTypeSetting;
import com.azure.resourcemanager.securityinsights.models.FusionSubTypeSeverityFilter;
import com.azure.resourcemanager.securityinsights.models.FusionSubTypeSeverityFiltersItem;
import java.util.Arrays;
import org.junit.jupiter.api.Assertions;

public final class FusionSourceSubTypeSettingTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        FusionSourceSubTypeSetting model = BinaryData.fromString(
            "{\"enabled\":true,\"sourceSubTypeName\":\"gjiiytssiki\",\"sourceSubTypeDisplayName\":\"cufqbvntnrgmqs\",\"severityFilters\":{\"isSupported\":true,\"filters\":[{\"severity\":\"Informational\",\"enabled\":false},{\"severity\":\"Medium\",\"enabled\":false}]}}")
            .toObject(FusionSourceSubTypeSetting.class);
        Assertions.assertEquals(true, model.enabled());
        Assertions.assertEquals("gjiiytssiki", model.sourceSubTypeName());
        Assertions.assertEquals(AlertSeverity.INFORMATIONAL, model.severityFilters().filters().get(0).severity());
        Assertions.assertEquals(false, model.severityFilters().filters().get(0).enabled());
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        FusionSourceSubTypeSetting model = new FusionSourceSubTypeSetting().withEnabled(true)
            .withSourceSubTypeName("gjiiytssiki")
            .withSeverityFilters(new FusionSubTypeSeverityFilter().withFilters(Arrays.asList(
                new FusionSubTypeSeverityFiltersItem().withSeverity(AlertSeverity.INFORMATIONAL).withEnabled(false),
                new FusionSubTypeSeverityFiltersItem().withSeverity(AlertSeverity.MEDIUM).withEnabled(false))));
        model = BinaryData.fromObject(model).toObject(FusionSourceSubTypeSetting.class);
        Assertions.assertEquals(true, model.enabled());
        Assertions.assertEquals("gjiiytssiki", model.sourceSubTypeName());
        Assertions.assertEquals(AlertSeverity.INFORMATIONAL, model.severityFilters().filters().get(0).severity());
        Assertions.assertEquals(false, model.severityFilters().filters().get(0).enabled());
    }
}
