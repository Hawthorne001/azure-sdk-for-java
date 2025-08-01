// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.netapp.generated;

import com.azure.resourcemanager.netapp.models.AuthorizeRequest;

/**
 * Samples for Volumes AuthorizeReplication.
 */
public final class VolumesAuthorizeReplicationSamples {
    /*
     * x-ms-original-file:
     * specification/netapp/resource-manager/Microsoft.NetApp/stable/2025-03-01/examples/Volumes_AuthorizeReplication.
     * json
     */
    /**
     * Sample code: Volumes_AuthorizeReplication.
     * 
     * @param manager Entry point to NetAppFilesManager.
     */
    public static void volumesAuthorizeReplication(com.azure.resourcemanager.netapp.NetAppFilesManager manager) {
        manager.volumes()
            .authorizeReplication("myRG", "account1", "pool1", "volume1",
                new AuthorizeRequest().withRemoteVolumeResourceId(
                    "/subscriptions/00000000-0000-0000-0000-000000000000/resourceGroups/myRemoteRG/providers/Microsoft.NetApp/netAppAccounts/remoteAccount1/capacityPools/remotePool1/volumes/remoteVolume1"),
                com.azure.core.util.Context.NONE);
    }
}
