// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.analytics.synapse.artifacts.models;

import com.azure.core.annotation.Generated;
import com.azure.core.annotation.Immutable;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;

/**
 * Referenced dependency.
 */
@Immutable
public class DependencyReference implements JsonSerializable<DependencyReference> {
    /*
     * The type of dependency reference.
     */
    @Generated
    private String type = "DependencyReference";

    /**
     * Creates an instance of DependencyReference class.
     */
    @Generated
    public DependencyReference() {
    }

    /**
     * Get the type property: The type of dependency reference.
     * 
     * @return the type value.
     */
    @Generated
    public String getType() {
        return this.type;
    }

    /**
     * {@inheritDoc}
     */
    @Generated
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeStringField("type", this.type);
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of DependencyReference from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of DependencyReference if the JsonReader was pointing to an instance of it, or null if it was
     * pointing to JSON null.
     * @throws IOException If an error occurs while reading the DependencyReference.
     */
    @Generated
    public static DependencyReference fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            String discriminatorValue = null;
            try (JsonReader readerToUse = reader.bufferObject()) {
                readerToUse.nextToken(); // Prepare for reading
                while (readerToUse.nextToken() != JsonToken.END_OBJECT) {
                    String fieldName = readerToUse.getFieldName();
                    readerToUse.nextToken();
                    if ("type".equals(fieldName)) {
                        discriminatorValue = readerToUse.getString();
                        break;
                    } else {
                        readerToUse.skipChildren();
                    }
                }
                // Use the discriminator value to determine which subtype should be deserialized.
                if ("TriggerDependencyReference".equals(discriminatorValue)) {
                    return TriggerDependencyReference.fromJsonKnownDiscriminator(readerToUse.reset());
                } else if ("TumblingWindowTriggerDependencyReference".equals(discriminatorValue)) {
                    return TumblingWindowTriggerDependencyReference.fromJson(readerToUse.reset());
                } else if ("SelfDependencyTumblingWindowTriggerReference".equals(discriminatorValue)) {
                    return SelfDependencyTumblingWindowTriggerReference.fromJson(readerToUse.reset());
                } else {
                    return fromJsonKnownDiscriminator(readerToUse.reset());
                }
            }
        });
    }

    @Generated
    static DependencyReference fromJsonKnownDiscriminator(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            DependencyReference deserializedDependencyReference = new DependencyReference();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("type".equals(fieldName)) {
                    deserializedDependencyReference.type = reader.getString();
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedDependencyReference;
        });
    }
}
