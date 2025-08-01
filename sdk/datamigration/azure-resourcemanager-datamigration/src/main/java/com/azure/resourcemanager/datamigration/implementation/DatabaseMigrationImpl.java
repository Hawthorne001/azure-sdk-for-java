// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.datamigration.implementation;

import com.azure.core.management.SystemData;
import com.azure.resourcemanager.datamigration.fluent.models.DatabaseMigrationInner;
import com.azure.resourcemanager.datamigration.models.DatabaseMigration;
import com.azure.resourcemanager.datamigration.models.DatabaseMigrationProperties;

public final class DatabaseMigrationImpl implements DatabaseMigration {
    private DatabaseMigrationInner innerObject;

    private final com.azure.resourcemanager.datamigration.DataMigrationManager serviceManager;

    DatabaseMigrationImpl(DatabaseMigrationInner innerObject,
        com.azure.resourcemanager.datamigration.DataMigrationManager serviceManager) {
        this.innerObject = innerObject;
        this.serviceManager = serviceManager;
    }

    public String id() {
        return this.innerModel().id();
    }

    public String name() {
        return this.innerModel().name();
    }

    public String type() {
        return this.innerModel().type();
    }

    public DatabaseMigrationProperties properties() {
        return this.innerModel().properties();
    }

    public SystemData systemData() {
        return this.innerModel().systemData();
    }

    public DatabaseMigrationInner innerModel() {
        return this.innerObject;
    }

    private com.azure.resourcemanager.datamigration.DataMigrationManager manager() {
        return this.serviceManager;
    }
}
