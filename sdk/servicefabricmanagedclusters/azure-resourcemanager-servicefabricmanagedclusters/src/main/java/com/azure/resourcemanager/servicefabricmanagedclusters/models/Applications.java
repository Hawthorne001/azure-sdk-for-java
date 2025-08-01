// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) TypeSpec Code Generator.

package com.azure.resourcemanager.servicefabricmanagedclusters.models;

import com.azure.core.http.rest.PagedIterable;
import com.azure.core.http.rest.Response;
import com.azure.core.util.Context;

/**
 * Resource collection API of Applications.
 */
public interface Applications {
    /**
     * Get a Service Fabric managed application resource created or in the process of being created in the Service
     * Fabric cluster resource.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param clusterName The name of the cluster resource.
     * @param applicationName The name of the application resource.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return a Service Fabric managed application resource created or in the process of being created in the Service
     * Fabric cluster resource along with {@link Response}.
     */
    Response<ApplicationResource> getWithResponse(String resourceGroupName, String clusterName, String applicationName,
        Context context);

    /**
     * Get a Service Fabric managed application resource created or in the process of being created in the Service
     * Fabric cluster resource.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param clusterName The name of the cluster resource.
     * @param applicationName The name of the application resource.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return a Service Fabric managed application resource created or in the process of being created in the Service
     * Fabric cluster resource.
     */
    ApplicationResource get(String resourceGroupName, String clusterName, String applicationName);

    /**
     * Delete a Service Fabric managed application resource with the specified name.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param clusterName The name of the cluster resource.
     * @param applicationName The name of the application resource.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     */
    void delete(String resourceGroupName, String clusterName, String applicationName);

    /**
     * Delete a Service Fabric managed application resource with the specified name.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param clusterName The name of the cluster resource.
     * @param applicationName The name of the application resource.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     */
    void delete(String resourceGroupName, String clusterName, String applicationName, Context context);

    /**
     * Gets all managed application resources created or in the process of being created in the Service Fabric cluster
     * resource.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param clusterName The name of the cluster resource.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return all managed application resources created or in the process of being created in the Service Fabric
     * cluster resource as paginated response with {@link PagedIterable}.
     */
    PagedIterable<ApplicationResource> list(String resourceGroupName, String clusterName);

    /**
     * Gets all managed application resources created or in the process of being created in the Service Fabric cluster
     * resource.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param clusterName The name of the cluster resource.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return all managed application resources created or in the process of being created in the Service Fabric
     * cluster resource as paginated response with {@link PagedIterable}.
     */
    PagedIterable<ApplicationResource> list(String resourceGroupName, String clusterName, Context context);

    /**
     * Get the status of the latest application upgrade. It will query the cluster to find the status of the latest
     * application upgrade.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param clusterName The name of the cluster resource.
     * @param applicationName The name of the application resource.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     */
    void readUpgrade(String resourceGroupName, String clusterName, String applicationName);

    /**
     * Get the status of the latest application upgrade. It will query the cluster to find the status of the latest
     * application upgrade.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param clusterName The name of the cluster resource.
     * @param applicationName The name of the application resource.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     */
    void readUpgrade(String resourceGroupName, String clusterName, String applicationName, Context context);

    /**
     * Send a request to resume the current application upgrade. This will resume the application upgrade from where it
     * was paused.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param clusterName The name of the cluster resource.
     * @param applicationName The name of the application resource.
     * @param parameters The parameters for resuming an application upgrade.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     */
    void resumeUpgrade(String resourceGroupName, String clusterName, String applicationName,
        RuntimeResumeApplicationUpgradeParameters parameters);

    /**
     * Send a request to resume the current application upgrade. This will resume the application upgrade from where it
     * was paused.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param clusterName The name of the cluster resource.
     * @param applicationName The name of the application resource.
     * @param parameters The parameters for resuming an application upgrade.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     */
    void resumeUpgrade(String resourceGroupName, String clusterName, String applicationName,
        RuntimeResumeApplicationUpgradeParameters parameters, Context context);

    /**
     * Send a request to start a rollback of the current application upgrade. This will start rolling back the
     * application to the previous version.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param clusterName The name of the cluster resource.
     * @param applicationName The name of the application resource.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     */
    void startRollback(String resourceGroupName, String clusterName, String applicationName);

    /**
     * Send a request to start a rollback of the current application upgrade. This will start rolling back the
     * application to the previous version.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param clusterName The name of the cluster resource.
     * @param applicationName The name of the application resource.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     */
    void startRollback(String resourceGroupName, String clusterName, String applicationName, Context context);

    /**
     * Get a Service Fabric managed application resource created or in the process of being created in the Service
     * Fabric cluster resource.
     * 
     * @param id the resource ID.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return a Service Fabric managed application resource created or in the process of being created in the Service
     * Fabric cluster resource along with {@link Response}.
     */
    ApplicationResource getById(String id);

    /**
     * Get a Service Fabric managed application resource created or in the process of being created in the Service
     * Fabric cluster resource.
     * 
     * @param id the resource ID.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return a Service Fabric managed application resource created or in the process of being created in the Service
     * Fabric cluster resource along with {@link Response}.
     */
    Response<ApplicationResource> getByIdWithResponse(String id, Context context);

    /**
     * Delete a Service Fabric managed application resource with the specified name.
     * 
     * @param id the resource ID.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     */
    void deleteById(String id);

    /**
     * Delete a Service Fabric managed application resource with the specified name.
     * 
     * @param id the resource ID.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     */
    void deleteByIdWithResponse(String id, Context context);

    /**
     * Begins definition for a new ApplicationResource resource.
     * 
     * @param name resource name.
     * @return the first stage of the new ApplicationResource definition.
     */
    ApplicationResource.DefinitionStages.Blank define(String name);
}
