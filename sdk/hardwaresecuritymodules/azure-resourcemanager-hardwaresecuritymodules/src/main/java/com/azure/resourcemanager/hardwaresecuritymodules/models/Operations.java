// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) TypeSpec Code Generator.

package com.azure.resourcemanager.hardwaresecuritymodules.models;

import com.azure.core.http.rest.PagedIterable;
import com.azure.core.util.Context;

/**
 * Resource collection API of Operations.
 */
public interface Operations {
    /**
     * List the operations for the provider.
     * 
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return a list of REST API operations supported by an Azure Resource Provider as paginated response with
     * {@link PagedIterable}.
     */
    PagedIterable<Operation> list();

    /**
     * List the operations for the provider.
     * 
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return a list of REST API operations supported by an Azure Resource Provider as paginated response with
     * {@link PagedIterable}.
     */
    PagedIterable<Operation> list(Context context);
}
