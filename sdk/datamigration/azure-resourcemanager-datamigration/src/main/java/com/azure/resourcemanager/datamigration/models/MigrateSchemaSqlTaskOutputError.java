// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.datamigration.models;

import com.azure.core.annotation.Immutable;
import com.azure.json.JsonReader;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;

/**
 * The MigrateSchemaSqlTaskOutputError model.
 */
@Immutable
public final class MigrateSchemaSqlTaskOutputError extends MigrateSchemaSqlServerSqlDbTaskOutput {
    /*
     * Result type
     */
    private String resultType = "ErrorOutput";

    /*
     * Migration error
     */
    private ReportableException error;

    /**
     * Creates an instance of MigrateSchemaSqlTaskOutputError class.
     */
    public MigrateSchemaSqlTaskOutputError() {
    }

    /**
     * Get the resultType property: Result type.
     * 
     * @return the resultType value.
     */
    @Override
    public String resultType() {
        return this.resultType;
    }

    /**
     * Get the error property: Migration error.
     * 
     * @return the error value.
     */
    public ReportableException error() {
        return this.error;
    }

    /**
     * Validates the instance.
     * 
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    @Override
    public void validate() {
        if (error() != null) {
            error().validate();
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeStringField("resultType", this.resultType);
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of MigrateSchemaSqlTaskOutputError from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of MigrateSchemaSqlTaskOutputError if the JsonReader was pointing to an instance of it, or
     * null if it was pointing to JSON null.
     * @throws IOException If an error occurs while reading the MigrateSchemaSqlTaskOutputError.
     */
    public static MigrateSchemaSqlTaskOutputError fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            MigrateSchemaSqlTaskOutputError deserializedMigrateSchemaSqlTaskOutputError
                = new MigrateSchemaSqlTaskOutputError();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("id".equals(fieldName)) {
                    deserializedMigrateSchemaSqlTaskOutputError.withId(reader.getString());
                } else if ("resultType".equals(fieldName)) {
                    deserializedMigrateSchemaSqlTaskOutputError.resultType = reader.getString();
                } else if ("error".equals(fieldName)) {
                    deserializedMigrateSchemaSqlTaskOutputError.error = ReportableException.fromJson(reader);
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedMigrateSchemaSqlTaskOutputError;
        });
    }
}
