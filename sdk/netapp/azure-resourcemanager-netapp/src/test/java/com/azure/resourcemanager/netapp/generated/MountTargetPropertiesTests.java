// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.netapp.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.netapp.fluent.models.MountTargetProperties;
import org.junit.jupiter.api.Assertions;

public final class MountTargetPropertiesTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        MountTargetProperties model = BinaryData.fromString(
            "{\"mountTargetId\":\"blmpewww\",\"fileSystemId\":\"bkrvrnsvshqj\",\"ipAddress\":\"xc\",\"smbServerFqdn\":\"bfovasrruvwbhsq\"}")
            .toObject(MountTargetProperties.class);
        Assertions.assertEquals("bkrvrnsvshqj", model.fileSystemId());
        Assertions.assertEquals("bfovasrruvwbhsq", model.smbServerFqdn());
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        MountTargetProperties model
            = new MountTargetProperties().withFileSystemId("bkrvrnsvshqj").withSmbServerFqdn("bfovasrruvwbhsq");
        model = BinaryData.fromObject(model).toObject(MountTargetProperties.class);
        Assertions.assertEquals("bkrvrnsvshqj", model.fileSystemId());
        Assertions.assertEquals("bfovasrruvwbhsq", model.smbServerFqdn());
    }
}
