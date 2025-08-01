// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) TypeSpec Code Generator.

package com.azure.resourcemanager.storagediscovery.implementation.models;

import com.azure.core.annotation.Immutable;
import com.azure.core.util.logging.ClientLogger;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import com.azure.resourcemanager.storagediscovery.fluent.models.OperationInner;
import java.io.IOException;
import java.util.List;

/**
 * A list of REST API operations supported by an Azure Resource Provider. It contains an URL link to get the next set of
 * results.
 */
@Immutable
public final class OperationListResult implements JsonSerializable<OperationListResult> {
    /*
     * The Operation items on this page
     */
    private List<OperationInner> value;

    /*
     * The link to the next page of items
     */
    private String nextLink;

    /**
     * Creates an instance of OperationListResult class.
     */
    private OperationListResult() {
    }

    /**
     * Get the value property: The Operation items on this page.
     * 
     * @return the value value.
     */
    public List<OperationInner> value() {
        return this.value;
    }

    /**
     * Get the nextLink property: The link to the next page of items.
     * 
     * @return the nextLink value.
     */
    public String nextLink() {
        return this.nextLink;
    }

    /**
     * Validates the instance.
     * 
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (value() == null) {
            throw LOGGER.atError()
                .log(new IllegalArgumentException("Missing required property value in model OperationListResult"));
        } else {
            value().forEach(e -> e.validate());
        }
    }

    private static final ClientLogger LOGGER = new ClientLogger(OperationListResult.class);

    /**
     * {@inheritDoc}
     */
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeArrayField("value", this.value, (writer, element) -> writer.writeJson(element));
        jsonWriter.writeStringField("nextLink", this.nextLink);
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of OperationListResult from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of OperationListResult if the JsonReader was pointing to an instance of it, or null if it was
     * pointing to JSON null.
     * @throws IllegalStateException If the deserialized JSON object was missing any required properties.
     * @throws IOException If an error occurs while reading the OperationListResult.
     */
    public static OperationListResult fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            OperationListResult deserializedOperationListResult = new OperationListResult();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("value".equals(fieldName)) {
                    List<OperationInner> value = reader.readArray(reader1 -> OperationInner.fromJson(reader1));
                    deserializedOperationListResult.value = value;
                } else if ("nextLink".equals(fieldName)) {
                    deserializedOperationListResult.nextLink = reader.getString();
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedOperationListResult;
        });
    }
}
