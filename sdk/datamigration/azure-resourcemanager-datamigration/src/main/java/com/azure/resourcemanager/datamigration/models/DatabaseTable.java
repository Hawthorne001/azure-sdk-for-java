// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.datamigration.models;

import com.azure.core.annotation.Immutable;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;

/**
 * Table properties.
 */
@Immutable
public final class DatabaseTable implements JsonSerializable<DatabaseTable> {
    /*
     * Indicates whether table is empty or not
     */
    private Boolean hasRows;

    /*
     * Schema-qualified name of the table
     */
    private String name;

    /**
     * Creates an instance of DatabaseTable class.
     */
    public DatabaseTable() {
    }

    /**
     * Get the hasRows property: Indicates whether table is empty or not.
     * 
     * @return the hasRows value.
     */
    public Boolean hasRows() {
        return this.hasRows;
    }

    /**
     * Get the name property: Schema-qualified name of the table.
     * 
     * @return the name value.
     */
    public String name() {
        return this.name;
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
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of DatabaseTable from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of DatabaseTable if the JsonReader was pointing to an instance of it, or null if it was
     * pointing to JSON null.
     * @throws IOException If an error occurs while reading the DatabaseTable.
     */
    public static DatabaseTable fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            DatabaseTable deserializedDatabaseTable = new DatabaseTable();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("hasRows".equals(fieldName)) {
                    deserializedDatabaseTable.hasRows = reader.getNullable(JsonReader::getBoolean);
                } else if ("name".equals(fieldName)) {
                    deserializedDatabaseTable.name = reader.getString();
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedDatabaseTable;
        });
    }
}
