// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.providerhub.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.util.CoreUtils;
import com.azure.json.JsonReader;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

/**
 * The subscription lifecycle notification specifications.
 */
@Fluent
public final class ResourceTypeRegistrationPropertiesSubscriptionLifecycleNotificationSpecifications
    extends SubscriptionLifecycleNotificationSpecifications {
    /**
     * Creates an instance of ResourceTypeRegistrationPropertiesSubscriptionLifecycleNotificationSpecifications class.
     */
    public ResourceTypeRegistrationPropertiesSubscriptionLifecycleNotificationSpecifications() {
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ResourceTypeRegistrationPropertiesSubscriptionLifecycleNotificationSpecifications
        withSubscriptionStateOverrideActions(List<SubscriptionStateOverrideAction> subscriptionStateOverrideActions) {
        super.withSubscriptionStateOverrideActions(subscriptionStateOverrideActions);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ResourceTypeRegistrationPropertiesSubscriptionLifecycleNotificationSpecifications
        withSoftDeleteTtl(Duration softDeleteTtl) {
        super.withSoftDeleteTtl(softDeleteTtl);
        return this;
    }

    /**
     * Validates the instance.
     * 
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    @Override
    public void validate() {
        if (subscriptionStateOverrideActions() != null) {
            subscriptionStateOverrideActions().forEach(e -> e.validate());
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeArrayField("subscriptionStateOverrideActions", subscriptionStateOverrideActions(),
            (writer, element) -> writer.writeJson(element));
        jsonWriter.writeStringField("softDeleteTTL", CoreUtils.durationToStringWithDays(softDeleteTtl()));
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of ResourceTypeRegistrationPropertiesSubscriptionLifecycleNotificationSpecifications from the
     * JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of ResourceTypeRegistrationPropertiesSubscriptionLifecycleNotificationSpecifications if the
     * JsonReader was pointing to an instance of it, or null if it was pointing to JSON null.
     * @throws IOException If an error occurs while reading the
     * ResourceTypeRegistrationPropertiesSubscriptionLifecycleNotificationSpecifications.
     */
    public static ResourceTypeRegistrationPropertiesSubscriptionLifecycleNotificationSpecifications
        fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            ResourceTypeRegistrationPropertiesSubscriptionLifecycleNotificationSpecifications deserializedResourceTypeRegistrationPropertiesSubscriptionLifecycleNotificationSpecifications
                = new ResourceTypeRegistrationPropertiesSubscriptionLifecycleNotificationSpecifications();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("subscriptionStateOverrideActions".equals(fieldName)) {
                    List<SubscriptionStateOverrideAction> subscriptionStateOverrideActions
                        = reader.readArray(reader1 -> SubscriptionStateOverrideAction.fromJson(reader1));
                    deserializedResourceTypeRegistrationPropertiesSubscriptionLifecycleNotificationSpecifications
                        .withSubscriptionStateOverrideActions(subscriptionStateOverrideActions);
                } else if ("softDeleteTTL".equals(fieldName)) {
                    deserializedResourceTypeRegistrationPropertiesSubscriptionLifecycleNotificationSpecifications
                        .withSoftDeleteTtl(
                            reader.getNullable(nonNullReader -> Duration.parse(nonNullReader.getString())));
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedResourceTypeRegistrationPropertiesSubscriptionLifecycleNotificationSpecifications;
        });
    }
}
