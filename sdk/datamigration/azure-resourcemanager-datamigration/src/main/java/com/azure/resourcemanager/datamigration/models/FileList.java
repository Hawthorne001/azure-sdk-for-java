// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.datamigration.models;

import com.azure.core.annotation.Fluent;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import com.azure.resourcemanager.datamigration.fluent.models.ProjectFileInner;
import java.io.IOException;
import java.util.List;

/**
 * OData page of files.
 */
@Fluent
public final class FileList implements JsonSerializable<FileList> {
    /*
     * List of files
     */
    private List<ProjectFileInner> value;

    /*
     * URL to load the next page of files
     */
    private String nextLink;

    /**
     * Creates an instance of FileList class.
     */
    public FileList() {
    }

    /**
     * Get the value property: List of files.
     * 
     * @return the value value.
     */
    public List<ProjectFileInner> value() {
        return this.value;
    }

    /**
     * Set the value property: List of files.
     * 
     * @param value the value value to set.
     * @return the FileList object itself.
     */
    public FileList withValue(List<ProjectFileInner> value) {
        this.value = value;
        return this;
    }

    /**
     * Get the nextLink property: URL to load the next page of files.
     * 
     * @return the nextLink value.
     */
    public String nextLink() {
        return this.nextLink;
    }

    /**
     * Set the nextLink property: URL to load the next page of files.
     * 
     * @param nextLink the nextLink value to set.
     * @return the FileList object itself.
     */
    public FileList withNextLink(String nextLink) {
        this.nextLink = nextLink;
        return this;
    }

    /**
     * Validates the instance.
     * 
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (value() != null) {
            value().forEach(e -> e.validate());
        }
    }

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
     * Reads an instance of FileList from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of FileList if the JsonReader was pointing to an instance of it, or null if it was pointing
     * to JSON null.
     * @throws IOException If an error occurs while reading the FileList.
     */
    public static FileList fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            FileList deserializedFileList = new FileList();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("value".equals(fieldName)) {
                    List<ProjectFileInner> value = reader.readArray(reader1 -> ProjectFileInner.fromJson(reader1));
                    deserializedFileList.value = value;
                } else if ("nextLink".equals(fieldName)) {
                    deserializedFileList.nextLink = reader.getString();
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedFileList;
        });
    }
}
