// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.providerhub.models;

import com.azure.core.util.ExpandableStringEnum;
import java.util.Collection;

/**
 * The linked operation.
 */
public final class LinkedOperation extends ExpandableStringEnum<LinkedOperation> {
    /**
     * Static value None for LinkedOperation.
     */
    public static final LinkedOperation NONE = fromString("None");

    /**
     * Static value CrossResourceGroupResourceMove for LinkedOperation.
     */
    public static final LinkedOperation CROSS_RESOURCE_GROUP_RESOURCE_MOVE
        = fromString("CrossResourceGroupResourceMove");

    /**
     * Static value CrossSubscriptionResourceMove for LinkedOperation.
     */
    public static final LinkedOperation CROSS_SUBSCRIPTION_RESOURCE_MOVE = fromString("CrossSubscriptionResourceMove");

    /**
     * Creates a new instance of LinkedOperation value.
     * 
     * @deprecated Use the {@link #fromString(String)} factory method.
     */
    @Deprecated
    public LinkedOperation() {
    }

    /**
     * Creates or finds a LinkedOperation from its string representation.
     * 
     * @param name a name to look for.
     * @return the corresponding LinkedOperation.
     */
    public static LinkedOperation fromString(String name) {
        return fromString(name, LinkedOperation.class);
    }

    /**
     * Gets known LinkedOperation values.
     * 
     * @return known LinkedOperation values.
     */
    public static Collection<LinkedOperation> values() {
        return values(LinkedOperation.class);
    }
}
