// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.subscription.models;

import com.azure.core.http.rest.Response;
import com.azure.core.util.Context;

/**
 * Resource collection API of SubscriptionOperations.
 */
public interface SubscriptionOperations {
    /**
     * The operation to cancel a subscription.
     * 
     * @param subscriptionId Subscription Id.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the ID of the canceled subscription along with {@link Response}.
     */
    Response<CanceledSubscriptionId> cancelWithResponse(String subscriptionId, Context context);

    /**
     * The operation to cancel a subscription.
     * 
     * @param subscriptionId Subscription Id.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the ID of the canceled subscription.
     */
    CanceledSubscriptionId cancel(String subscriptionId);

    /**
     * The operation to rename a subscription.
     * 
     * @param subscriptionId Subscription Id.
     * @param body Subscription Name.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the ID of the subscriptions that is being renamed along with {@link Response}.
     */
    Response<RenamedSubscriptionId> renameWithResponse(String subscriptionId, SubscriptionName body, Context context);

    /**
     * The operation to rename a subscription.
     * 
     * @param subscriptionId Subscription Id.
     * @param body Subscription Name.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the ID of the subscriptions that is being renamed.
     */
    RenamedSubscriptionId rename(String subscriptionId, SubscriptionName body);

    /**
     * The operation to enable a subscription.
     * 
     * @param subscriptionId Subscription Id.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the ID of the subscriptions that is being enabled along with {@link Response}.
     */
    Response<EnabledSubscriptionId> enableWithResponse(String subscriptionId, Context context);

    /**
     * The operation to enable a subscription.
     * 
     * @param subscriptionId Subscription Id.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the ID of the subscriptions that is being enabled.
     */
    EnabledSubscriptionId enable(String subscriptionId);
}
