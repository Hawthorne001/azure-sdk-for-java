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
 * The QuotaRule model.
 */
@Fluent
public final class QuotaRule implements JsonSerializable<QuotaRule> {
    /*
     * The quota policy.
     */
    private QuotaPolicy quotaPolicy;

    /*
     * The location rules.
     */
    private List<LocationQuotaRule> locationRules;

    /*
     * The required features.
     */
    private List<String> requiredFeatures;

    /**
     * Creates an instance of QuotaRule class.
     */
    public QuotaRule() {
    }

    /**
     * Get the quotaPolicy property: The quota policy.
     * 
     * @return the quotaPolicy value.
     */
    public QuotaPolicy quotaPolicy() {
        return this.quotaPolicy;
    }

    /**
     * Set the quotaPolicy property: The quota policy.
     * 
     * @param quotaPolicy the quotaPolicy value to set.
     * @return the QuotaRule object itself.
     */
    public QuotaRule withQuotaPolicy(QuotaPolicy quotaPolicy) {
        this.quotaPolicy = quotaPolicy;
        return this;
    }

    /**
     * Get the locationRules property: The location rules.
     * 
     * @return the locationRules value.
     */
    public List<LocationQuotaRule> locationRules() {
        return this.locationRules;
    }

    /**
     * Set the locationRules property: The location rules.
     * 
     * @param locationRules the locationRules value to set.
     * @return the QuotaRule object itself.
     */
    public QuotaRule withLocationRules(List<LocationQuotaRule> locationRules) {
        this.locationRules = locationRules;
        return this;
    }

    /**
     * Get the requiredFeatures property: The required features.
     * 
     * @return the requiredFeatures value.
     */
    public List<String> requiredFeatures() {
        return this.requiredFeatures;
    }

    /**
     * Set the requiredFeatures property: The required features.
     * 
     * @param requiredFeatures the requiredFeatures value to set.
     * @return the QuotaRule object itself.
     */
    public QuotaRule withRequiredFeatures(List<String> requiredFeatures) {
        this.requiredFeatures = requiredFeatures;
        return this;
    }

    /**
     * Validates the instance.
     * 
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (locationRules() != null) {
            locationRules().forEach(e -> e.validate());
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeStringField("quotaPolicy", this.quotaPolicy == null ? null : this.quotaPolicy.toString());
        jsonWriter.writeArrayField("locationRules", this.locationRules, (writer, element) -> writer.writeJson(element));
        jsonWriter.writeArrayField("requiredFeatures", this.requiredFeatures,
            (writer, element) -> writer.writeString(element));
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of QuotaRule from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of QuotaRule if the JsonReader was pointing to an instance of it, or null if it was pointing
     * to JSON null.
     * @throws IOException If an error occurs while reading the QuotaRule.
     */
    public static QuotaRule fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            QuotaRule deserializedQuotaRule = new QuotaRule();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("quotaPolicy".equals(fieldName)) {
                    deserializedQuotaRule.quotaPolicy = QuotaPolicy.fromString(reader.getString());
                } else if ("locationRules".equals(fieldName)) {
                    List<LocationQuotaRule> locationRules
                        = reader.readArray(reader1 -> LocationQuotaRule.fromJson(reader1));
                    deserializedQuotaRule.locationRules = locationRules;
                } else if ("requiredFeatures".equals(fieldName)) {
                    List<String> requiredFeatures = reader.readArray(reader1 -> reader1.getString());
                    deserializedQuotaRule.requiredFeatures = requiredFeatures;
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedQuotaRule;
        });
    }
}
