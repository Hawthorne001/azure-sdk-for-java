// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.datamigration.models;

import com.azure.core.annotation.Fluent;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;
import java.util.Objects;
import java.util.UUID;

/**
 * Migration Operation Input.
 */
@Fluent
public final class MigrationOperationInput implements JsonSerializable<MigrationOperationInput> {
    /*
     * ID tracking migration operation.
     */
    private UUID migrationOperationId;

    /**
     * Creates an instance of MigrationOperationInput class.
     */
    public MigrationOperationInput() {
    }

    /**
     * Get the migrationOperationId property: ID tracking migration operation.
     * 
     * @return the migrationOperationId value.
     */
    public UUID migrationOperationId() {
        return this.migrationOperationId;
    }

    /**
     * Set the migrationOperationId property: ID tracking migration operation.
     * 
     * @param migrationOperationId the migrationOperationId value to set.
     * @return the MigrationOperationInput object itself.
     */
    public MigrationOperationInput withMigrationOperationId(UUID migrationOperationId) {
        this.migrationOperationId = migrationOperationId;
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
        jsonWriter.writeStringField("migrationOperationId", Objects.toString(this.migrationOperationId, null));
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of MigrationOperationInput from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of MigrationOperationInput if the JsonReader was pointing to an instance of it, or null if it
     * was pointing to JSON null.
     * @throws IOException If an error occurs while reading the MigrationOperationInput.
     */
    public static MigrationOperationInput fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            MigrationOperationInput deserializedMigrationOperationInput = new MigrationOperationInput();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("migrationOperationId".equals(fieldName)) {
                    deserializedMigrationOperationInput.migrationOperationId
                        = reader.getNullable(nonNullReader -> UUID.fromString(nonNullReader.getString()));
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedMigrationOperationInput;
        });
    }
}
