// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.datamigration.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.util.logging.ClientLogger;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;

/**
 * Input for the task that validates connection to Azure Database for MySQL and target server requirements.
 */
@Fluent
public final class ConnectToTargetAzureDbForMySqlTaskInput
    implements JsonSerializable<ConnectToTargetAzureDbForMySqlTaskInput> {
    /*
     * Connection information for source MySQL server
     */
    private MySqlConnectionInfo sourceConnectionInfo;

    /*
     * Connection information for target Azure Database for MySQL server
     */
    private MySqlConnectionInfo targetConnectionInfo;

    /*
     * Flag for whether or not the migration is offline
     */
    private Boolean isOfflineMigration;

    /**
     * Creates an instance of ConnectToTargetAzureDbForMySqlTaskInput class.
     */
    public ConnectToTargetAzureDbForMySqlTaskInput() {
    }

    /**
     * Get the sourceConnectionInfo property: Connection information for source MySQL server.
     * 
     * @return the sourceConnectionInfo value.
     */
    public MySqlConnectionInfo sourceConnectionInfo() {
        return this.sourceConnectionInfo;
    }

    /**
     * Set the sourceConnectionInfo property: Connection information for source MySQL server.
     * 
     * @param sourceConnectionInfo the sourceConnectionInfo value to set.
     * @return the ConnectToTargetAzureDbForMySqlTaskInput object itself.
     */
    public ConnectToTargetAzureDbForMySqlTaskInput withSourceConnectionInfo(MySqlConnectionInfo sourceConnectionInfo) {
        this.sourceConnectionInfo = sourceConnectionInfo;
        return this;
    }

    /**
     * Get the targetConnectionInfo property: Connection information for target Azure Database for MySQL server.
     * 
     * @return the targetConnectionInfo value.
     */
    public MySqlConnectionInfo targetConnectionInfo() {
        return this.targetConnectionInfo;
    }

    /**
     * Set the targetConnectionInfo property: Connection information for target Azure Database for MySQL server.
     * 
     * @param targetConnectionInfo the targetConnectionInfo value to set.
     * @return the ConnectToTargetAzureDbForMySqlTaskInput object itself.
     */
    public ConnectToTargetAzureDbForMySqlTaskInput withTargetConnectionInfo(MySqlConnectionInfo targetConnectionInfo) {
        this.targetConnectionInfo = targetConnectionInfo;
        return this;
    }

    /**
     * Get the isOfflineMigration property: Flag for whether or not the migration is offline.
     * 
     * @return the isOfflineMigration value.
     */
    public Boolean isOfflineMigration() {
        return this.isOfflineMigration;
    }

    /**
     * Set the isOfflineMigration property: Flag for whether or not the migration is offline.
     * 
     * @param isOfflineMigration the isOfflineMigration value to set.
     * @return the ConnectToTargetAzureDbForMySqlTaskInput object itself.
     */
    public ConnectToTargetAzureDbForMySqlTaskInput withIsOfflineMigration(Boolean isOfflineMigration) {
        this.isOfflineMigration = isOfflineMigration;
        return this;
    }

    /**
     * Validates the instance.
     * 
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (sourceConnectionInfo() == null) {
            throw LOGGER.atError()
                .log(new IllegalArgumentException(
                    "Missing required property sourceConnectionInfo in model ConnectToTargetAzureDbForMySqlTaskInput"));
        } else {
            sourceConnectionInfo().validate();
        }
        if (targetConnectionInfo() == null) {
            throw LOGGER.atError()
                .log(new IllegalArgumentException(
                    "Missing required property targetConnectionInfo in model ConnectToTargetAzureDbForMySqlTaskInput"));
        } else {
            targetConnectionInfo().validate();
        }
    }

    private static final ClientLogger LOGGER = new ClientLogger(ConnectToTargetAzureDbForMySqlTaskInput.class);

    /**
     * {@inheritDoc}
     */
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeJsonField("sourceConnectionInfo", this.sourceConnectionInfo);
        jsonWriter.writeJsonField("targetConnectionInfo", this.targetConnectionInfo);
        jsonWriter.writeBooleanField("isOfflineMigration", this.isOfflineMigration);
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of ConnectToTargetAzureDbForMySqlTaskInput from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of ConnectToTargetAzureDbForMySqlTaskInput if the JsonReader was pointing to an instance of
     * it, or null if it was pointing to JSON null.
     * @throws IllegalStateException If the deserialized JSON object was missing any required properties.
     * @throws IOException If an error occurs while reading the ConnectToTargetAzureDbForMySqlTaskInput.
     */
    public static ConnectToTargetAzureDbForMySqlTaskInput fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            ConnectToTargetAzureDbForMySqlTaskInput deserializedConnectToTargetAzureDbForMySqlTaskInput
                = new ConnectToTargetAzureDbForMySqlTaskInput();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("sourceConnectionInfo".equals(fieldName)) {
                    deserializedConnectToTargetAzureDbForMySqlTaskInput.sourceConnectionInfo
                        = MySqlConnectionInfo.fromJson(reader);
                } else if ("targetConnectionInfo".equals(fieldName)) {
                    deserializedConnectToTargetAzureDbForMySqlTaskInput.targetConnectionInfo
                        = MySqlConnectionInfo.fromJson(reader);
                } else if ("isOfflineMigration".equals(fieldName)) {
                    deserializedConnectToTargetAzureDbForMySqlTaskInput.isOfflineMigration
                        = reader.getNullable(JsonReader::getBoolean);
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedConnectToTargetAzureDbForMySqlTaskInput;
        });
    }
}
