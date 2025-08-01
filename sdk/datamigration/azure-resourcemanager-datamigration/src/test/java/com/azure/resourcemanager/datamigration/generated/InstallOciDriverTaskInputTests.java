// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.datamigration.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.datamigration.models.InstallOciDriverTaskInput;
import org.junit.jupiter.api.Assertions;

public final class InstallOciDriverTaskInputTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        InstallOciDriverTaskInput model
            = BinaryData.fromString("{\"driverPackageName\":\"xpno\"}").toObject(InstallOciDriverTaskInput.class);
        Assertions.assertEquals("xpno", model.driverPackageName());
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        InstallOciDriverTaskInput model = new InstallOciDriverTaskInput().withDriverPackageName("xpno");
        model = BinaryData.fromObject(model).toObject(InstallOciDriverTaskInput.class);
        Assertions.assertEquals("xpno", model.driverPackageName());
    }
}
