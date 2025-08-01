// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.providerhub.models;

import com.azure.core.annotation.Fluent;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;
import java.util.List;

/**
 * The SubscriptionStateRule model.
 */
@Fluent
public final class SubscriptionStateRule implements JsonSerializable<SubscriptionStateRule> {
    /*
     * The subscription state.
     */
    private SubscriptionState state;

    /*
     * The allowed actions.
     */
    private List<String> allowedActions;

    /**
     * Creates an instance of SubscriptionStateRule class.
     */
    public SubscriptionStateRule() {
    }

    /**
     * Get the state property: The subscription state.
     * 
     * @return the state value.
     */
    public SubscriptionState state() {
        return this.state;
    }

    /**
     * Set the state property: The subscription state.
     * 
     * @param state the state value to set.
     * @return the SubscriptionStateRule object itself.
     */
    public SubscriptionStateRule withState(SubscriptionState state) {
        this.state = state;
        return this;
    }

    /**
     * Get the allowedActions property: The allowed actions.
     * 
     * @return the allowedActions value.
     */
    public List<String> allowedActions() {
        return this.allowedActions;
    }

    /**
     * Set the allowedActions property: The allowed actions.
     * 
     * @param allowedActions the allowedActions value to set.
     * @return the SubscriptionStateRule object itself.
     */
    public SubscriptionStateRule withAllowedActions(List<String> allowedActions) {
        this.allowedActions = allowedActions;
        return this;
    }

    /**
     * Validates the instance.
     * 
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeStringField("state", this.state == null ? null : this.state.toString());
        jsonWriter.writeArrayField("allowedActions", this.allowedActions,
            (writer, element) -> writer.writeString(element));
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of SubscriptionStateRule from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of SubscriptionStateRule if the JsonReader was pointing to an instance of it, or null if it
     * was pointing to JSON null.
     * @throws IOException If an error occurs while reading the SubscriptionStateRule.
     */
    public static SubscriptionStateRule fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            SubscriptionStateRule deserializedSubscriptionStateRule = new SubscriptionStateRule();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("state".equals(fieldName)) {
                    deserializedSubscriptionStateRule.state = SubscriptionState.fromString(reader.getString());
                } else if ("allowedActions".equals(fieldName)) {
                    List<String> allowedActions = reader.readArray(reader1 -> reader1.getString());
                    deserializedSubscriptionStateRule.allowedActions = allowedActions;
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedSubscriptionStateRule;
        });
    }
}
