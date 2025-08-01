// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.communication.callautomation;

import com.azure.core.util.ServiceVersion;

/**
 * Versions of CallAutomation service supported by this client library.
 */
public enum CallAutomationServiceVersion implements ServiceVersion {

    /**
    * Service version {@code 2023-03-06}.
    */
    V2023_03_06("2023-03-06"),

    /**
     * Service version {@code 2023-10-15}.
     */
    V2023_10_15("2023-10-15"),

    /**
     * Service version {@code 2024-04-15}.
     */
    V2024_04_15("2024-04-15"),

    /**
     * Service version {@code 2024-09-15}.
     */
    V2024_09_15("2024-09-15"),

    /**
    * Service version {@code 2025-05-15}.
    */
    V2025_05_15("2025-05-15"),
    /**
    * Service version {@code 2025-06-15}.
    */
    V2025_06_15("2025-06-15");

    private final String version;

    CallAutomationServiceVersion(String version) {
        this.version = version;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getVersion() {
        return this.version;
    }

    /**
     * Gets the latest service version supported by this client library
     *
     * @return The latest {@link CallAutomationServiceVersion} object.
     */
    public static CallAutomationServiceVersion getLatest() {
        return V2025_06_15;
    }
}
