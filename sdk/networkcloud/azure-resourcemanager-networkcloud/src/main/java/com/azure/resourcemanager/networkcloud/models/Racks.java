// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.networkcloud.models;

import com.azure.core.http.rest.PagedIterable;
import com.azure.core.http.rest.Response;
import com.azure.core.util.Context;

/**
 * Resource collection API of Racks.
 */
public interface Racks {
    /**
     * List racks in the subscription.
     * 
     * Get a list of racks in the provided subscription.
     * 
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return a list of racks in the provided subscription as paginated response with {@link PagedIterable}.
     */
    PagedIterable<Rack> list();

    /**
     * List racks in the subscription.
     * 
     * Get a list of racks in the provided subscription.
     * 
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return a list of racks in the provided subscription as paginated response with {@link PagedIterable}.
     */
    PagedIterable<Rack> list(Context context);

    /**
     * List racks in the resource group.
     * 
     * Get a list of racks in the provided resource group.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return a list of racks in the provided resource group as paginated response with {@link PagedIterable}.
     */
    PagedIterable<Rack> listByResourceGroup(String resourceGroupName);

    /**
     * List racks in the resource group.
     * 
     * Get a list of racks in the provided resource group.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return a list of racks in the provided resource group as paginated response with {@link PagedIterable}.
     */
    PagedIterable<Rack> listByResourceGroup(String resourceGroupName, Context context);

    /**
     * Retrieve the rack.
     * 
     * Get properties of the provided rack.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param rackName The name of the rack.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return properties of the provided rack along with {@link Response}.
     */
    Response<Rack> getByResourceGroupWithResponse(String resourceGroupName, String rackName, Context context);

    /**
     * Retrieve the rack.
     * 
     * Get properties of the provided rack.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param rackName The name of the rack.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return properties of the provided rack.
     */
    Rack getByResourceGroup(String resourceGroupName, String rackName);

    /**
     * Delete the rack.
     * 
     * Delete the provided rack.
     * All customer initiated requests will be rejected as the life cycle of this resource is managed by the system.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param rackName The name of the rack.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the current status of an async operation.
     */
    OperationStatusResult deleteByResourceGroup(String resourceGroupName, String rackName);

    /**
     * Delete the rack.
     * 
     * Delete the provided rack.
     * All customer initiated requests will be rejected as the life cycle of this resource is managed by the system.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param rackName The name of the rack.
     * @param ifMatch The ETag of the transformation. Omit this value to always overwrite the current resource. Specify
     * the last-seen ETag value to prevent accidentally overwriting concurrent changes.
     * @param ifNoneMatch Set to '*' to allow a new record set to be created, but to prevent updating an existing
     * resource. Other values will result in error from server as they are not supported.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the current status of an async operation.
     */
    OperationStatusResult delete(String resourceGroupName, String rackName, String ifMatch, String ifNoneMatch,
        Context context);

    /**
     * Retrieve the rack.
     * 
     * Get properties of the provided rack.
     * 
     * @param id the resource ID.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return properties of the provided rack along with {@link Response}.
     */
    Rack getById(String id);

    /**
     * Retrieve the rack.
     * 
     * Get properties of the provided rack.
     * 
     * @param id the resource ID.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return properties of the provided rack along with {@link Response}.
     */
    Response<Rack> getByIdWithResponse(String id, Context context);

    /**
     * Delete the rack.
     * 
     * Delete the provided rack.
     * All customer initiated requests will be rejected as the life cycle of this resource is managed by the system.
     * 
     * @param id the resource ID.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the current status of an async operation.
     */
    OperationStatusResult deleteById(String id);

    /**
     * Delete the rack.
     * 
     * Delete the provided rack.
     * All customer initiated requests will be rejected as the life cycle of this resource is managed by the system.
     * 
     * @param id the resource ID.
     * @param ifMatch The ETag of the transformation. Omit this value to always overwrite the current resource. Specify
     * the last-seen ETag value to prevent accidentally overwriting concurrent changes.
     * @param ifNoneMatch Set to '*' to allow a new record set to be created, but to prevent updating an existing
     * resource. Other values will result in error from server as they are not supported.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the current status of an async operation.
     */
    OperationStatusResult deleteByIdWithResponse(String id, String ifMatch, String ifNoneMatch, Context context);

    /**
     * Begins definition for a new Rack resource.
     * 
     * @param name resource name.
     * @return the first stage of the new Rack definition.
     */
    Rack.DefinitionStages.Blank define(String name);
}
