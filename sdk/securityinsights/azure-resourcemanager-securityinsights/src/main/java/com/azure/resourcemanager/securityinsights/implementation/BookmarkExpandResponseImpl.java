// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.securityinsights.implementation;

import com.azure.resourcemanager.securityinsights.fluent.models.BookmarkExpandResponseInner;
import com.azure.resourcemanager.securityinsights.models.BookmarkExpandResponse;
import com.azure.resourcemanager.securityinsights.models.BookmarkExpandResponseValue;
import com.azure.resourcemanager.securityinsights.models.ExpansionResultsMetadata;

public final class BookmarkExpandResponseImpl implements BookmarkExpandResponse {
    private BookmarkExpandResponseInner innerObject;

    private final com.azure.resourcemanager.securityinsights.SecurityInsightsManager serviceManager;

    BookmarkExpandResponseImpl(BookmarkExpandResponseInner innerObject,
        com.azure.resourcemanager.securityinsights.SecurityInsightsManager serviceManager) {
        this.innerObject = innerObject;
        this.serviceManager = serviceManager;
    }

    public ExpansionResultsMetadata metadata() {
        return this.innerModel().metadata();
    }

    public BookmarkExpandResponseValue value() {
        return this.innerModel().value();
    }

    public BookmarkExpandResponseInner innerModel() {
        return this.innerObject;
    }

    private com.azure.resourcemanager.securityinsights.SecurityInsightsManager manager() {
        return this.serviceManager;
    }
}
