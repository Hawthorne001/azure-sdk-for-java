// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) TypeSpec Code Generator.

package com.azure.resourcemanager.purestorageblock.generated;

/**
 * Samples for StoragePools DisableAvsConnection.
 */
public final class StoragePoolsDisableAvsConnectionSamples {
    /*
     * x-ms-original-file: 2024-11-01/StoragePools_DisableAvsConnection_MaximumSet_Gen.json
     */
    /**
     * Sample code: StoragePools_DisableAvsConnection.
     * 
     * @param manager Entry point to PureStorageBlockManager.
     */
    public static void
        storagePoolsDisableAvsConnection(com.azure.resourcemanager.purestorageblock.PureStorageBlockManager manager) {
        manager.storagePools()
            .disableAvsConnection("rgpurestorage", "storagePoolname", com.azure.core.util.Context.NONE);
    }
}
