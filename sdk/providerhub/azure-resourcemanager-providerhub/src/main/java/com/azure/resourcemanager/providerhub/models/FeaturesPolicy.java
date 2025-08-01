// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.providerhub.models;

import com.azure.core.util.ExpandableStringEnum;
import java.util.Collection;

/**
 * The required feature policy.
 */
public final class FeaturesPolicy extends ExpandableStringEnum<FeaturesPolicy> {
    /**
     * Static value Any for FeaturesPolicy.
     */
    public static final FeaturesPolicy ANY = fromString("Any");

    /**
     * Static value All for FeaturesPolicy.
     */
    public static final FeaturesPolicy ALL = fromString("All");

    /**
     * Creates a new instance of FeaturesPolicy value.
     * 
     * @deprecated Use the {@link #fromString(String)} factory method.
     */
    @Deprecated
    public FeaturesPolicy() {
    }

    /**
     * Creates or finds a FeaturesPolicy from its string representation.
     * 
     * @param name a name to look for.
     * @return the corresponding FeaturesPolicy.
     */
    public static FeaturesPolicy fromString(String name) {
        return fromString(name, FeaturesPolicy.class);
    }

    /**
     * Gets known FeaturesPolicy values.
     * 
     * @return known FeaturesPolicy values.
     */
    public static Collection<FeaturesPolicy> values() {
        return values(FeaturesPolicy.class);
    }
}
