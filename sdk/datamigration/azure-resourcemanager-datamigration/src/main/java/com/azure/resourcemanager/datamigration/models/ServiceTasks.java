// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.datamigration.models;

import com.azure.core.http.rest.PagedIterable;
import com.azure.core.http.rest.Response;
import com.azure.core.util.Context;
import com.azure.resourcemanager.datamigration.fluent.models.ProjectTaskInner;

/**
 * Resource collection API of ServiceTasks.
 */
public interface ServiceTasks {
    /**
     * Get service level tasks for a service
     * 
     * The services resource is the top-level resource that represents the Azure Database Migration Service (classic).
     * This method returns a list of service level tasks owned by a service resource. Some tasks may have a status of
     * Unknown, which indicates that an error occurred while querying the status of that task.
     * 
     * @param groupName Name of the resource group.
     * @param serviceName Name of the service.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return oData page of tasks as paginated response with {@link PagedIterable}.
     */
    PagedIterable<ProjectTask> list(String groupName, String serviceName);

    /**
     * Get service level tasks for a service
     * 
     * The services resource is the top-level resource that represents the Azure Database Migration Service (classic).
     * This method returns a list of service level tasks owned by a service resource. Some tasks may have a status of
     * Unknown, which indicates that an error occurred while querying the status of that task.
     * 
     * @param groupName Name of the resource group.
     * @param serviceName Name of the service.
     * @param taskType Filter tasks by task type.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return oData page of tasks as paginated response with {@link PagedIterable}.
     */
    PagedIterable<ProjectTask> list(String groupName, String serviceName, String taskType, Context context);

    /**
     * Create or update service task
     * 
     * The service tasks resource is a nested, proxy-only resource representing work performed by a DMS (classic)
     * instance. The PUT method creates a new service task or updates an existing one, although since service tasks have
     * no mutable custom properties, there is little reason to update an existing one.
     * 
     * @param groupName Name of the resource group.
     * @param serviceName Name of the service.
     * @param taskName Name of the Task.
     * @param parameters Information about the task.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return a task resource along with {@link Response}.
     */
    Response<ProjectTask> createOrUpdateWithResponse(String groupName, String serviceName, String taskName,
        ProjectTaskInner parameters, Context context);

    /**
     * Create or update service task
     * 
     * The service tasks resource is a nested, proxy-only resource representing work performed by a DMS (classic)
     * instance. The PUT method creates a new service task or updates an existing one, although since service tasks have
     * no mutable custom properties, there is little reason to update an existing one.
     * 
     * @param groupName Name of the resource group.
     * @param serviceName Name of the service.
     * @param taskName Name of the Task.
     * @param parameters Information about the task.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return a task resource.
     */
    ProjectTask createOrUpdate(String groupName, String serviceName, String taskName, ProjectTaskInner parameters);

    /**
     * Get service task information
     * 
     * The service tasks resource is a nested, proxy-only resource representing work performed by a DMS (classic)
     * instance. The GET method retrieves information about a service task.
     * 
     * @param groupName Name of the resource group.
     * @param serviceName Name of the service.
     * @param taskName Name of the Task.
     * @param expand Expand the response.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return a task resource along with {@link Response}.
     */
    Response<ProjectTask> getWithResponse(String groupName, String serviceName, String taskName, String expand,
        Context context);

    /**
     * Get service task information
     * 
     * The service tasks resource is a nested, proxy-only resource representing work performed by a DMS (classic)
     * instance. The GET method retrieves information about a service task.
     * 
     * @param groupName Name of the resource group.
     * @param serviceName Name of the service.
     * @param taskName Name of the Task.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return a task resource.
     */
    ProjectTask get(String groupName, String serviceName, String taskName);

    /**
     * Delete service task
     * 
     * The service tasks resource is a nested, proxy-only resource representing work performed by a DMS (classic)
     * instance. The DELETE method deletes a service task, canceling it first if it's running.
     * 
     * @param groupName Name of the resource group.
     * @param serviceName Name of the service.
     * @param taskName Name of the Task.
     * @param deleteRunningTasks Delete the resource even if it contains running tasks.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the {@link Response}.
     */
    Response<Void> deleteWithResponse(String groupName, String serviceName, String taskName, Boolean deleteRunningTasks,
        Context context);

    /**
     * Delete service task
     * 
     * The service tasks resource is a nested, proxy-only resource representing work performed by a DMS (classic)
     * instance. The DELETE method deletes a service task, canceling it first if it's running.
     * 
     * @param groupName Name of the resource group.
     * @param serviceName Name of the service.
     * @param taskName Name of the Task.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     */
    void delete(String groupName, String serviceName, String taskName);

    /**
     * Create or update service task
     * 
     * The service tasks resource is a nested, proxy-only resource representing work performed by a DMS (classic)
     * instance. The PATCH method updates an existing service task, but since service tasks have no mutable custom
     * properties, there is little reason to do so.
     * 
     * @param groupName Name of the resource group.
     * @param serviceName Name of the service.
     * @param taskName Name of the Task.
     * @param parameters Information about the task.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return a task resource along with {@link Response}.
     */
    Response<ProjectTask> updateWithResponse(String groupName, String serviceName, String taskName,
        ProjectTaskInner parameters, Context context);

    /**
     * Create or update service task
     * 
     * The service tasks resource is a nested, proxy-only resource representing work performed by a DMS (classic)
     * instance. The PATCH method updates an existing service task, but since service tasks have no mutable custom
     * properties, there is little reason to do so.
     * 
     * @param groupName Name of the resource group.
     * @param serviceName Name of the service.
     * @param taskName Name of the Task.
     * @param parameters Information about the task.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return a task resource.
     */
    ProjectTask update(String groupName, String serviceName, String taskName, ProjectTaskInner parameters);

    /**
     * Cancel a service task
     * 
     * The service tasks resource is a nested, proxy-only resource representing work performed by a DMS (classic)
     * instance. This method cancels a service task if it's currently queued or running.
     * 
     * @param groupName Name of the resource group.
     * @param serviceName Name of the service.
     * @param taskName Name of the Task.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return a task resource along with {@link Response}.
     */
    Response<ProjectTask> cancelWithResponse(String groupName, String serviceName, String taskName, Context context);

    /**
     * Cancel a service task
     * 
     * The service tasks resource is a nested, proxy-only resource representing work performed by a DMS (classic)
     * instance. This method cancels a service task if it's currently queued or running.
     * 
     * @param groupName Name of the resource group.
     * @param serviceName Name of the service.
     * @param taskName Name of the Task.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return a task resource.
     */
    ProjectTask cancel(String groupName, String serviceName, String taskName);
}
