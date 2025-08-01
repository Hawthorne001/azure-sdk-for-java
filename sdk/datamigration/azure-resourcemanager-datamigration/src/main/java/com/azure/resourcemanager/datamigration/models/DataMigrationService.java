// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.datamigration.models;

import com.azure.core.http.rest.Response;
import com.azure.core.management.Region;
import com.azure.core.util.Context;
import com.azure.resourcemanager.datamigration.fluent.models.DataMigrationServiceInner;
import java.util.Map;

/**
 * An immutable client-side representation of DataMigrationService.
 */
public interface DataMigrationService {
    /**
     * Gets the id property: Fully qualified resource Id for the resource.
     * 
     * @return the id value.
     */
    String id();

    /**
     * Gets the name property: The name of the resource.
     * 
     * @return the name value.
     */
    String name();

    /**
     * Gets the type property: The type of the resource.
     * 
     * @return the type value.
     */
    String type();

    /**
     * Gets the location property: The geo-location where the resource lives.
     * 
     * @return the location value.
     */
    String location();

    /**
     * Gets the tags property: Resource tags.
     * 
     * @return the tags value.
     */
    Map<String, String> tags();

    /**
     * Gets the etag property: HTTP strong entity tag value. Ignored if submitted.
     * 
     * @return the etag value.
     */
    String etag();

    /**
     * Gets the kind property: The resource kind. Only 'vm' (the default) is supported.
     * 
     * @return the kind value.
     */
    String kind();

    /**
     * Gets the sku property: Service SKU.
     * 
     * @return the sku value.
     */
    ServiceSku sku();

    /**
     * Gets the systemData property: The systemData property.
     * 
     * @return the systemData value.
     */
    SystemDataAutoGenerated systemData();

    /**
     * Gets the provisioningState property: The resource's provisioning state.
     * 
     * @return the provisioningState value.
     */
    ServiceProvisioningState provisioningState();

    /**
     * Gets the publicKey property: The public key of the service, used to encrypt secrets sent to the service.
     * 
     * @return the publicKey value.
     */
    String publicKey();

    /**
     * Gets the virtualSubnetId property: The ID of the Microsoft.Network/virtualNetworks/subnets resource to which the
     * service should be joined.
     * 
     * @return the virtualSubnetId value.
     */
    String virtualSubnetId();

    /**
     * Gets the virtualNicId property: The ID of the Microsoft.Network/networkInterfaces resource which the service
     * have.
     * 
     * @return the virtualNicId value.
     */
    String virtualNicId();

    /**
     * Gets the autoStopDelay property: The time delay before the service is auto-stopped when idle.
     * 
     * @return the autoStopDelay value.
     */
    String autoStopDelay();

    /**
     * Gets the deleteResourcesOnStop property: Whether service resources should be deleted when stopped. (Turned on by
     * default).
     * 
     * @return the deleteResourcesOnStop value.
     */
    Boolean deleteResourcesOnStop();

    /**
     * Gets the region of the resource.
     * 
     * @return the region of the resource.
     */
    Region region();

    /**
     * Gets the name of the resource region.
     * 
     * @return the name of the resource region.
     */
    String regionName();

    /**
     * Gets the name of the resource group.
     * 
     * @return the name of the resource group.
     */
    String resourceGroupName();

    /**
     * Gets the inner com.azure.resourcemanager.datamigration.fluent.models.DataMigrationServiceInner object.
     * 
     * @return the inner object.
     */
    DataMigrationServiceInner innerModel();

    /**
     * The entirety of the DataMigrationService definition.
     */
    interface Definition extends DefinitionStages.Blank, DefinitionStages.WithLocation,
        DefinitionStages.WithResourceGroup, DefinitionStages.WithCreate {
    }

    /**
     * The DataMigrationService definition stages.
     */
    interface DefinitionStages {
        /**
         * The first stage of the DataMigrationService definition.
         */
        interface Blank extends WithLocation {
        }

        /**
         * The stage of the DataMigrationService definition allowing to specify location.
         */
        interface WithLocation {
            /**
             * Specifies the region for the resource.
             * 
             * @param location The geo-location where the resource lives.
             * @return the next definition stage.
             */
            WithResourceGroup withRegion(Region location);

            /**
             * Specifies the region for the resource.
             * 
             * @param location The geo-location where the resource lives.
             * @return the next definition stage.
             */
            WithResourceGroup withRegion(String location);
        }

        /**
         * The stage of the DataMigrationService definition allowing to specify parent resource.
         */
        interface WithResourceGroup {
            /**
             * Specifies groupName.
             * 
             * @param groupName Name of the resource group.
             * @return the next definition stage.
             */
            WithCreate withExistingResourceGroup(String groupName);
        }

        /**
         * The stage of the DataMigrationService definition which contains all the minimum required properties for the
         * resource to be created, but also allows for any other optional properties to be specified.
         */
        interface WithCreate extends DefinitionStages.WithTags, DefinitionStages.WithEtag, DefinitionStages.WithKind,
            DefinitionStages.WithSku, DefinitionStages.WithPublicKey, DefinitionStages.WithVirtualSubnetId,
            DefinitionStages.WithVirtualNicId, DefinitionStages.WithAutoStopDelay,
            DefinitionStages.WithDeleteResourcesOnStop {
            /**
             * Executes the create request.
             * 
             * @return the created resource.
             */
            DataMigrationService create();

            /**
             * Executes the create request.
             * 
             * @param context The context to associate with this operation.
             * @return the created resource.
             */
            DataMigrationService create(Context context);
        }

        /**
         * The stage of the DataMigrationService definition allowing to specify tags.
         */
        interface WithTags {
            /**
             * Specifies the tags property: Resource tags..
             * 
             * @param tags Resource tags.
             * @return the next definition stage.
             */
            WithCreate withTags(Map<String, String> tags);
        }

        /**
         * The stage of the DataMigrationService definition allowing to specify etag.
         */
        interface WithEtag {
            /**
             * Specifies the etag property: HTTP strong entity tag value. Ignored if submitted.
             * 
             * @param etag HTTP strong entity tag value. Ignored if submitted.
             * @return the next definition stage.
             */
            WithCreate withEtag(String etag);
        }

        /**
         * The stage of the DataMigrationService definition allowing to specify kind.
         */
        interface WithKind {
            /**
             * Specifies the kind property: The resource kind. Only 'vm' (the default) is supported..
             * 
             * @param kind The resource kind. Only 'vm' (the default) is supported.
             * @return the next definition stage.
             */
            WithCreate withKind(String kind);
        }

        /**
         * The stage of the DataMigrationService definition allowing to specify sku.
         */
        interface WithSku {
            /**
             * Specifies the sku property: Service SKU.
             * 
             * @param sku Service SKU.
             * @return the next definition stage.
             */
            WithCreate withSku(ServiceSku sku);
        }

        /**
         * The stage of the DataMigrationService definition allowing to specify publicKey.
         */
        interface WithPublicKey {
            /**
             * Specifies the publicKey property: The public key of the service, used to encrypt secrets sent to the
             * service.
             * 
             * @param publicKey The public key of the service, used to encrypt secrets sent to the service.
             * @return the next definition stage.
             */
            WithCreate withPublicKey(String publicKey);
        }

        /**
         * The stage of the DataMigrationService definition allowing to specify virtualSubnetId.
         */
        interface WithVirtualSubnetId {
            /**
             * Specifies the virtualSubnetId property: The ID of the Microsoft.Network/virtualNetworks/subnets resource
             * to which the service should be joined.
             * 
             * @param virtualSubnetId The ID of the Microsoft.Network/virtualNetworks/subnets resource to which the
             * service should be joined.
             * @return the next definition stage.
             */
            WithCreate withVirtualSubnetId(String virtualSubnetId);
        }

        /**
         * The stage of the DataMigrationService definition allowing to specify virtualNicId.
         */
        interface WithVirtualNicId {
            /**
             * Specifies the virtualNicId property: The ID of the Microsoft.Network/networkInterfaces resource which the
             * service have.
             * 
             * @param virtualNicId The ID of the Microsoft.Network/networkInterfaces resource which the service have.
             * @return the next definition stage.
             */
            WithCreate withVirtualNicId(String virtualNicId);
        }

        /**
         * The stage of the DataMigrationService definition allowing to specify autoStopDelay.
         */
        interface WithAutoStopDelay {
            /**
             * Specifies the autoStopDelay property: The time delay before the service is auto-stopped when idle..
             * 
             * @param autoStopDelay The time delay before the service is auto-stopped when idle.
             * @return the next definition stage.
             */
            WithCreate withAutoStopDelay(String autoStopDelay);
        }

        /**
         * The stage of the DataMigrationService definition allowing to specify deleteResourcesOnStop.
         */
        interface WithDeleteResourcesOnStop {
            /**
             * Specifies the deleteResourcesOnStop property: Whether service resources should be deleted when stopped.
             * (Turned on by default).
             * 
             * @param deleteResourcesOnStop Whether service resources should be deleted when stopped. (Turned on by
             * default).
             * @return the next definition stage.
             */
            WithCreate withDeleteResourcesOnStop(Boolean deleteResourcesOnStop);
        }
    }

    /**
     * Begins update for the DataMigrationService resource.
     * 
     * @return the stage of resource update.
     */
    DataMigrationService.Update update();

    /**
     * The template for DataMigrationService update.
     */
    interface Update extends UpdateStages.WithTags, UpdateStages.WithEtag, UpdateStages.WithKind, UpdateStages.WithSku,
        UpdateStages.WithPublicKey, UpdateStages.WithVirtualSubnetId, UpdateStages.WithVirtualNicId,
        UpdateStages.WithAutoStopDelay, UpdateStages.WithDeleteResourcesOnStop {
        /**
         * Executes the update request.
         * 
         * @return the updated resource.
         */
        DataMigrationService apply();

        /**
         * Executes the update request.
         * 
         * @param context The context to associate with this operation.
         * @return the updated resource.
         */
        DataMigrationService apply(Context context);
    }

    /**
     * The DataMigrationService update stages.
     */
    interface UpdateStages {
        /**
         * The stage of the DataMigrationService update allowing to specify tags.
         */
        interface WithTags {
            /**
             * Specifies the tags property: Resource tags..
             * 
             * @param tags Resource tags.
             * @return the next definition stage.
             */
            Update withTags(Map<String, String> tags);
        }

        /**
         * The stage of the DataMigrationService update allowing to specify etag.
         */
        interface WithEtag {
            /**
             * Specifies the etag property: HTTP strong entity tag value. Ignored if submitted.
             * 
             * @param etag HTTP strong entity tag value. Ignored if submitted.
             * @return the next definition stage.
             */
            Update withEtag(String etag);
        }

        /**
         * The stage of the DataMigrationService update allowing to specify kind.
         */
        interface WithKind {
            /**
             * Specifies the kind property: The resource kind. Only 'vm' (the default) is supported..
             * 
             * @param kind The resource kind. Only 'vm' (the default) is supported.
             * @return the next definition stage.
             */
            Update withKind(String kind);
        }

        /**
         * The stage of the DataMigrationService update allowing to specify sku.
         */
        interface WithSku {
            /**
             * Specifies the sku property: Service SKU.
             * 
             * @param sku Service SKU.
             * @return the next definition stage.
             */
            Update withSku(ServiceSku sku);
        }

        /**
         * The stage of the DataMigrationService update allowing to specify publicKey.
         */
        interface WithPublicKey {
            /**
             * Specifies the publicKey property: The public key of the service, used to encrypt secrets sent to the
             * service.
             * 
             * @param publicKey The public key of the service, used to encrypt secrets sent to the service.
             * @return the next definition stage.
             */
            Update withPublicKey(String publicKey);
        }

        /**
         * The stage of the DataMigrationService update allowing to specify virtualSubnetId.
         */
        interface WithVirtualSubnetId {
            /**
             * Specifies the virtualSubnetId property: The ID of the Microsoft.Network/virtualNetworks/subnets resource
             * to which the service should be joined.
             * 
             * @param virtualSubnetId The ID of the Microsoft.Network/virtualNetworks/subnets resource to which the
             * service should be joined.
             * @return the next definition stage.
             */
            Update withVirtualSubnetId(String virtualSubnetId);
        }

        /**
         * The stage of the DataMigrationService update allowing to specify virtualNicId.
         */
        interface WithVirtualNicId {
            /**
             * Specifies the virtualNicId property: The ID of the Microsoft.Network/networkInterfaces resource which the
             * service have.
             * 
             * @param virtualNicId The ID of the Microsoft.Network/networkInterfaces resource which the service have.
             * @return the next definition stage.
             */
            Update withVirtualNicId(String virtualNicId);
        }

        /**
         * The stage of the DataMigrationService update allowing to specify autoStopDelay.
         */
        interface WithAutoStopDelay {
            /**
             * Specifies the autoStopDelay property: The time delay before the service is auto-stopped when idle..
             * 
             * @param autoStopDelay The time delay before the service is auto-stopped when idle.
             * @return the next definition stage.
             */
            Update withAutoStopDelay(String autoStopDelay);
        }

        /**
         * The stage of the DataMigrationService update allowing to specify deleteResourcesOnStop.
         */
        interface WithDeleteResourcesOnStop {
            /**
             * Specifies the deleteResourcesOnStop property: Whether service resources should be deleted when stopped.
             * (Turned on by default).
             * 
             * @param deleteResourcesOnStop Whether service resources should be deleted when stopped. (Turned on by
             * default).
             * @return the next definition stage.
             */
            Update withDeleteResourcesOnStop(Boolean deleteResourcesOnStop);
        }
    }

    /**
     * Refreshes the resource to sync with Azure.
     * 
     * @return the refreshed resource.
     */
    DataMigrationService refresh();

    /**
     * Refreshes the resource to sync with Azure.
     * 
     * @param context The context to associate with this operation.
     * @return the refreshed resource.
     */
    DataMigrationService refresh(Context context);

    /**
     * Check service health status
     * 
     * The services resource is the top-level resource that represents the Azure Database Migration Service (classic).
     * This action performs a health check and returns the status of the service and virtual machine size.
     * 
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return service health status along with {@link Response}.
     */
    Response<DataMigrationServiceStatusResponse> checkStatusWithResponse(Context context);

    /**
     * Check service health status
     * 
     * The services resource is the top-level resource that represents the Azure Database Migration Service (classic).
     * This action performs a health check and returns the status of the service and virtual machine size.
     * 
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return service health status.
     */
    DataMigrationServiceStatusResponse checkStatus();

    /**
     * Start service
     * 
     * The services resource is the top-level resource that represents the Azure Database Migration Service (classic).
     * This action starts the service and the service can be used for data migration.
     * 
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     */
    void start();

    /**
     * Start service
     * 
     * The services resource is the top-level resource that represents the Azure Database Migration Service (classic).
     * This action starts the service and the service can be used for data migration.
     * 
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     */
    void start(Context context);

    /**
     * Stop service
     * 
     * The services resource is the top-level resource that represents the Azure Database Migration Service (classic).
     * This action stops the service and the service cannot be used for data migration. The service owner won't be
     * billed when the service is stopped.
     * 
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     */
    void stop();

    /**
     * Stop service
     * 
     * The services resource is the top-level resource that represents the Azure Database Migration Service (classic).
     * This action stops the service and the service cannot be used for data migration. The service owner won't be
     * billed when the service is stopped.
     * 
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     */
    void stop(Context context);

    /**
     * Check nested resource name validity and availability
     * 
     * This method checks whether a proposed nested resource name is valid and available.
     * 
     * @param parameters Requested name to validate.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return indicates whether a proposed resource name is available along with {@link Response}.
     */
    Response<NameAvailabilityResponse> checkChildrenNameAvailabilityWithResponse(NameAvailabilityRequest parameters,
        Context context);

    /**
     * Check nested resource name validity and availability
     * 
     * This method checks whether a proposed nested resource name is valid and available.
     * 
     * @param parameters Requested name to validate.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return indicates whether a proposed resource name is available.
     */
    NameAvailabilityResponse checkChildrenNameAvailability(NameAvailabilityRequest parameters);
}
