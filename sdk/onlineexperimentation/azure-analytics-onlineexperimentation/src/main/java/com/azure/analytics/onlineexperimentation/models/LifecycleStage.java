// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) TypeSpec Code Generator.
package com.azure.analytics.onlineexperimentation.models;

import com.azure.core.annotation.Generated;
import com.azure.core.util.ExpandableStringEnum;
import java.util.Collection;

/**
 * Lifecycle stages of an experiment metric, determining whether the metric is included in experiment analysis.
 */
public final class LifecycleStage extends ExpandableStringEnum<LifecycleStage> {

    /**
     * The metric is included in experiment analysis.
     */
    @Generated
    public static final LifecycleStage ACTIVE = fromString("Active");

    /**
     * The metric is excluded from experiment analysis but remains available for future use.
     */
    @Generated
    public static final LifecycleStage INACTIVE = fromString("Inactive");

    /**
     * Creates a new instance of LifecycleStage value.
     *
     * @deprecated Use the {@link #fromString(String)} factory method.
     */
    @Generated
    @Deprecated
    public LifecycleStage() {
    }

    /**
     * Creates or finds a LifecycleStage from its string representation.
     *
     * @param name a name to look for.
     * @return the corresponding LifecycleStage.
     */
    @Generated
    public static LifecycleStage fromString(String name) {
        return fromString(name, LifecycleStage.class);
    }

    /**
     * Gets known LifecycleStage values.
     *
     * @return known LifecycleStage values.
     */
    @Generated
    public static Collection<LifecycleStage> values() {
        return values(LifecycleStage.class);
    }
}
