// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) TypeSpec Code Generator.

package com.azure.resourcemanager.mongodbatlas.fluent;

import com.azure.core.annotation.ReturnType;
import com.azure.core.annotation.ServiceMethod;
import com.azure.core.http.rest.PagedIterable;
import com.azure.core.http.rest.Response;
import com.azure.core.management.polling.PollResult;
import com.azure.core.util.Context;
import com.azure.core.util.polling.SyncPoller;
import com.azure.resourcemanager.mongodbatlas.fluent.models.OrganizationResourceInner;
import com.azure.resourcemanager.mongodbatlas.models.OrganizationResourceUpdate;

/**
 * An instance of this class provides access to all the operations defined in OrganizationsClient.
 */
public interface OrganizationsClient {
    /**
     * Get a OrganizationResource.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param organizationName Name of the Organization resource.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return a OrganizationResource along with {@link Response}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Response<OrganizationResourceInner> getByResourceGroupWithResponse(String resourceGroupName,
        String organizationName, Context context);

    /**
     * Get a OrganizationResource.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param organizationName Name of the Organization resource.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return a OrganizationResource.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    OrganizationResourceInner getByResourceGroup(String resourceGroupName, String organizationName);

    /**
     * Create a OrganizationResource.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param organizationName Name of the Organization resource.
     * @param resource Resource create parameters.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the {@link SyncPoller} for polling of the resource model definition for an Azure Organization.
     */
    @ServiceMethod(returns = ReturnType.LONG_RUNNING_OPERATION)
    SyncPoller<PollResult<OrganizationResourceInner>, OrganizationResourceInner>
        beginCreateOrUpdate(String resourceGroupName, String organizationName, OrganizationResourceInner resource);

    /**
     * Create a OrganizationResource.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param organizationName Name of the Organization resource.
     * @param resource Resource create parameters.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the {@link SyncPoller} for polling of the resource model definition for an Azure Organization.
     */
    @ServiceMethod(returns = ReturnType.LONG_RUNNING_OPERATION)
    SyncPoller<PollResult<OrganizationResourceInner>, OrganizationResourceInner> beginCreateOrUpdate(
        String resourceGroupName, String organizationName, OrganizationResourceInner resource, Context context);

    /**
     * Create a OrganizationResource.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param organizationName Name of the Organization resource.
     * @param resource Resource create parameters.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the resource model definition for an Azure Organization.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    OrganizationResourceInner createOrUpdate(String resourceGroupName, String organizationName,
        OrganizationResourceInner resource);

    /**
     * Create a OrganizationResource.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param organizationName Name of the Organization resource.
     * @param resource Resource create parameters.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the resource model definition for an Azure Organization.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    OrganizationResourceInner createOrUpdate(String resourceGroupName, String organizationName,
        OrganizationResourceInner resource, Context context);

    /**
     * Update a OrganizationResource.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param organizationName Name of the Organization resource.
     * @param properties The resource properties to be updated.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the {@link SyncPoller} for polling of the resource model definition for an Azure Organization.
     */
    @ServiceMethod(returns = ReturnType.LONG_RUNNING_OPERATION)
    SyncPoller<PollResult<OrganizationResourceInner>, OrganizationResourceInner> beginUpdate(String resourceGroupName,
        String organizationName, OrganizationResourceUpdate properties);

    /**
     * Update a OrganizationResource.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param organizationName Name of the Organization resource.
     * @param properties The resource properties to be updated.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the {@link SyncPoller} for polling of the resource model definition for an Azure Organization.
     */
    @ServiceMethod(returns = ReturnType.LONG_RUNNING_OPERATION)
    SyncPoller<PollResult<OrganizationResourceInner>, OrganizationResourceInner> beginUpdate(String resourceGroupName,
        String organizationName, OrganizationResourceUpdate properties, Context context);

    /**
     * Update a OrganizationResource.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param organizationName Name of the Organization resource.
     * @param properties The resource properties to be updated.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the resource model definition for an Azure Organization.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    OrganizationResourceInner update(String resourceGroupName, String organizationName,
        OrganizationResourceUpdate properties);

    /**
     * Update a OrganizationResource.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param organizationName Name of the Organization resource.
     * @param properties The resource properties to be updated.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the resource model definition for an Azure Organization.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    OrganizationResourceInner update(String resourceGroupName, String organizationName,
        OrganizationResourceUpdate properties, Context context);

    /**
     * Delete a OrganizationResource.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param organizationName Name of the Organization resource.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the {@link SyncPoller} for polling of long-running operation.
     */
    @ServiceMethod(returns = ReturnType.LONG_RUNNING_OPERATION)
    SyncPoller<PollResult<Void>, Void> beginDelete(String resourceGroupName, String organizationName);

    /**
     * Delete a OrganizationResource.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param organizationName Name of the Organization resource.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the {@link SyncPoller} for polling of long-running operation.
     */
    @ServiceMethod(returns = ReturnType.LONG_RUNNING_OPERATION)
    SyncPoller<PollResult<Void>, Void> beginDelete(String resourceGroupName, String organizationName, Context context);

    /**
     * Delete a OrganizationResource.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param organizationName Name of the Organization resource.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    void delete(String resourceGroupName, String organizationName);

    /**
     * Delete a OrganizationResource.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param organizationName Name of the Organization resource.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    void delete(String resourceGroupName, String organizationName, Context context);

    /**
     * List OrganizationResource resources by resource group.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the response of a OrganizationResource list operation as paginated response with {@link PagedIterable}.
     */
    @ServiceMethod(returns = ReturnType.COLLECTION)
    PagedIterable<OrganizationResourceInner> listByResourceGroup(String resourceGroupName);

    /**
     * List OrganizationResource resources by resource group.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the response of a OrganizationResource list operation as paginated response with {@link PagedIterable}.
     */
    @ServiceMethod(returns = ReturnType.COLLECTION)
    PagedIterable<OrganizationResourceInner> listByResourceGroup(String resourceGroupName, Context context);

    /**
     * List OrganizationResource resources by subscription ID.
     * 
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the response of a OrganizationResource list operation as paginated response with {@link PagedIterable}.
     */
    @ServiceMethod(returns = ReturnType.COLLECTION)
    PagedIterable<OrganizationResourceInner> list();

    /**
     * List OrganizationResource resources by subscription ID.
     * 
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the response of a OrganizationResource list operation as paginated response with {@link PagedIterable}.
     */
    @ServiceMethod(returns = ReturnType.COLLECTION)
    PagedIterable<OrganizationResourceInner> list(Context context);
}
