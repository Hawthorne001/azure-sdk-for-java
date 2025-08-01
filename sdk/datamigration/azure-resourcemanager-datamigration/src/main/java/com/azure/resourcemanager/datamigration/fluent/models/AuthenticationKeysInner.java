// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.datamigration.fluent.models;

import com.azure.core.annotation.Fluent;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;

/**
 * An authentication key.
 */
@Fluent
public final class AuthenticationKeysInner implements JsonSerializable<AuthenticationKeysInner> {
    /*
     * The first authentication key.
     */
    private String authKey1;

    /*
     * The second authentication key.
     */
    private String authKey2;

    /**
     * Creates an instance of AuthenticationKeysInner class.
     */
    public AuthenticationKeysInner() {
    }

    /**
     * Get the authKey1 property: The first authentication key.
     * 
     * @return the authKey1 value.
     */
    public String authKey1() {
        return this.authKey1;
    }

    /**
     * Set the authKey1 property: The first authentication key.
     * 
     * @param authKey1 the authKey1 value to set.
     * @return the AuthenticationKeysInner object itself.
     */
    public AuthenticationKeysInner withAuthKey1(String authKey1) {
        this.authKey1 = authKey1;
        return this;
    }

    /**
     * Get the authKey2 property: The second authentication key.
     * 
     * @return the authKey2 value.
     */
    public String authKey2() {
        return this.authKey2;
    }

    /**
     * Set the authKey2 property: The second authentication key.
     * 
     * @param authKey2 the authKey2 value to set.
     * @return the AuthenticationKeysInner object itself.
     */
    public AuthenticationKeysInner withAuthKey2(String authKey2) {
        this.authKey2 = authKey2;
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
        jsonWriter.writeStringField("authKey1", this.authKey1);
        jsonWriter.writeStringField("authKey2", this.authKey2);
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of AuthenticationKeysInner from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of AuthenticationKeysInner if the JsonReader was pointing to an instance of it, or null if it
     * was pointing to JSON null.
     * @throws IOException If an error occurs while reading the AuthenticationKeysInner.
     */
    public static AuthenticationKeysInner fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            AuthenticationKeysInner deserializedAuthenticationKeysInner = new AuthenticationKeysInner();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("authKey1".equals(fieldName)) {
                    deserializedAuthenticationKeysInner.authKey1 = reader.getString();
                } else if ("authKey2".equals(fieldName)) {
                    deserializedAuthenticationKeysInner.authKey2 = reader.getString();
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedAuthenticationKeysInner;
        });
    }
}
