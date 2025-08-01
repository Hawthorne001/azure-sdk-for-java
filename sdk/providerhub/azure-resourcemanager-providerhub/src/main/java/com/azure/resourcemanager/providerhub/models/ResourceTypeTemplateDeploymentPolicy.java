// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.providerhub.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.util.logging.ClientLogger;
import com.azure.json.JsonReader;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;

/**
 * The template deployment policy.
 */
@Fluent
public final class ResourceTypeTemplateDeploymentPolicy extends TemplateDeploymentPolicy {
    /**
     * Creates an instance of ResourceTypeTemplateDeploymentPolicy class.
     */
    public ResourceTypeTemplateDeploymentPolicy() {
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ResourceTypeTemplateDeploymentPolicy withCapabilities(TemplateDeploymentCapabilities capabilities) {
        super.withCapabilities(capabilities);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ResourceTypeTemplateDeploymentPolicy
        withPreflightOptions(TemplateDeploymentPreflightOptions preflightOptions) {
        super.withPreflightOptions(preflightOptions);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ResourceTypeTemplateDeploymentPolicy
        withPreflightNotifications(TemplateDeploymentPreflightNotifications preflightNotifications) {
        super.withPreflightNotifications(preflightNotifications);
        return this;
    }

    /**
     * Validates the instance.
     * 
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    @Override
    public void validate() {
        if (capabilities() == null) {
            throw LOGGER.atError()
                .log(new IllegalArgumentException(
                    "Missing required property capabilities in model ResourceTypeTemplateDeploymentPolicy"));
        }
        if (preflightOptions() == null) {
            throw LOGGER.atError()
                .log(new IllegalArgumentException(
                    "Missing required property preflightOptions in model ResourceTypeTemplateDeploymentPolicy"));
        }
    }

    private static final ClientLogger LOGGER = new ClientLogger(ResourceTypeTemplateDeploymentPolicy.class);

    /**
     * {@inheritDoc}
     */
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeStringField("capabilities", capabilities() == null ? null : capabilities().toString());
        jsonWriter.writeStringField("preflightOptions",
            preflightOptions() == null ? null : preflightOptions().toString());
        jsonWriter.writeStringField("preflightNotifications",
            preflightNotifications() == null ? null : preflightNotifications().toString());
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of ResourceTypeTemplateDeploymentPolicy from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of ResourceTypeTemplateDeploymentPolicy if the JsonReader was pointing to an instance of it,
     * or null if it was pointing to JSON null.
     * @throws IllegalStateException If the deserialized JSON object was missing any required properties.
     * @throws IOException If an error occurs while reading the ResourceTypeTemplateDeploymentPolicy.
     */
    public static ResourceTypeTemplateDeploymentPolicy fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            ResourceTypeTemplateDeploymentPolicy deserializedResourceTypeTemplateDeploymentPolicy
                = new ResourceTypeTemplateDeploymentPolicy();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("capabilities".equals(fieldName)) {
                    deserializedResourceTypeTemplateDeploymentPolicy
                        .withCapabilities(TemplateDeploymentCapabilities.fromString(reader.getString()));
                } else if ("preflightOptions".equals(fieldName)) {
                    deserializedResourceTypeTemplateDeploymentPolicy
                        .withPreflightOptions(TemplateDeploymentPreflightOptions.fromString(reader.getString()));
                } else if ("preflightNotifications".equals(fieldName)) {
                    deserializedResourceTypeTemplateDeploymentPolicy.withPreflightNotifications(
                        TemplateDeploymentPreflightNotifications.fromString(reader.getString()));
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedResourceTypeTemplateDeploymentPolicy;
        });
    }
}
