// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.providerhub.models;

import com.azure.core.util.ExpandableStringEnum;
import java.util.Collection;

/**
 * The subscription reregistration result.
 */
public final class SubscriptionReregistrationResult extends ExpandableStringEnum<SubscriptionReregistrationResult> {
    /**
     * Static value NotApplicable for SubscriptionReregistrationResult.
     */
    public static final SubscriptionReregistrationResult NOT_APPLICABLE = fromString("NotApplicable");

    /**
     * Static value ConditionalUpdate for SubscriptionReregistrationResult.
     */
    public static final SubscriptionReregistrationResult CONDITIONAL_UPDATE = fromString("ConditionalUpdate");

    /**
     * Static value ForcedUpdate for SubscriptionReregistrationResult.
     */
    public static final SubscriptionReregistrationResult FORCED_UPDATE = fromString("ForcedUpdate");

    /**
     * Static value Failed for SubscriptionReregistrationResult.
     */
    public static final SubscriptionReregistrationResult FAILED = fromString("Failed");

    /**
     * Creates a new instance of SubscriptionReregistrationResult value.
     * 
     * @deprecated Use the {@link #fromString(String)} factory method.
     */
    @Deprecated
    public SubscriptionReregistrationResult() {
    }

    /**
     * Creates or finds a SubscriptionReregistrationResult from its string representation.
     * 
     * @param name a name to look for.
     * @return the corresponding SubscriptionReregistrationResult.
     */
    public static SubscriptionReregistrationResult fromString(String name) {
        return fromString(name, SubscriptionReregistrationResult.class);
    }

    /**
     * Gets known SubscriptionReregistrationResult values.
     * 
     * @return known SubscriptionReregistrationResult values.
     */
    public static Collection<SubscriptionReregistrationResult> values() {
        return values(SubscriptionReregistrationResult.class);
    }
}
