// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.datamigration.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.datamigration.models.SyncMigrationDatabaseErrorEvent;

public final class SyncMigrationDatabaseErrorEventTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        SyncMigrationDatabaseErrorEvent model = BinaryData
            .fromString("{\"timestampString\":\"czznvfbycjsxj\",\"eventTypeString\":\"i\",\"eventText\":\"vumwmxqh\"}")
            .toObject(SyncMigrationDatabaseErrorEvent.class);
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        SyncMigrationDatabaseErrorEvent model = new SyncMigrationDatabaseErrorEvent();
        model = BinaryData.fromObject(model).toObject(SyncMigrationDatabaseErrorEvent.class);
    }
}
