// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.analytics.synapse.artifacts.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.annotation.Generated;
import com.azure.core.util.CoreUtils;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;

/**
 * The LinkConnectionDetailedStatus model.
 */
@Fluent
public final class LinkConnectionDetailedStatus implements JsonSerializable<LinkConnectionDetailedStatus> {
    /*
     * Link connection id
     */
    @Generated
    private String id;

    /*
     * Link connection name
     */
    @Generated
    private String name;

    /*
     * Is link connection applying changes
     */
    @Generated
    private Boolean isApplyingChanges;

    /*
     * Is link connection partially failed
     */
    @Generated
    private Boolean isPartiallyFailed;

    /*
     * Link connection start time
     */
    @Generated
    private Object startTime;

    /*
     * Link connection stop time
     */
    @Generated
    private Object stopTime;

    /*
     * Link connection status, please refer to this
     * [articles](https://learn.microsoft.com/azure/synapse-analytics/synapse-link/sql-database-synapse-link#monitoring)
     * for details.
     */
    @Generated
    private String status;

    /*
     * Link connection's corresponding continuous run id
     */
    @Generated
    private String continuousRunId;

    /*
     * Link connection error
     */
    @Generated
    private Object error;

    /*
     * Link connection refresh status
     */
    @Generated
    private LinkConnectionRefreshStatus refreshStatus;

    /*
     * Link connection landing zone credential expire time
     */
    @Generated
    private OffsetDateTime landingZoneCredentialExpireTime;

    /**
     * Creates an instance of LinkConnectionDetailedStatus class.
     */
    @Generated
    public LinkConnectionDetailedStatus() {
    }

    /**
     * Get the id property: Link connection id.
     * 
     * @return the id value.
     */
    @Generated
    public String getId() {
        return this.id;
    }

    /**
     * Set the id property: Link connection id.
     * 
     * @param id the id value to set.
     * @return the LinkConnectionDetailedStatus object itself.
     */
    @Generated
    public LinkConnectionDetailedStatus setId(String id) {
        this.id = id;
        return this;
    }

    /**
     * Get the name property: Link connection name.
     * 
     * @return the name value.
     */
    @Generated
    public String getName() {
        return this.name;
    }

    /**
     * Set the name property: Link connection name.
     * 
     * @param name the name value to set.
     * @return the LinkConnectionDetailedStatus object itself.
     */
    @Generated
    public LinkConnectionDetailedStatus setName(String name) {
        this.name = name;
        return this;
    }

    /**
     * Get the isApplyingChanges property: Is link connection applying changes.
     * 
     * @return the isApplyingChanges value.
     */
    @Generated
    public Boolean isApplyingChanges() {
        return this.isApplyingChanges;
    }

    /**
     * Set the isApplyingChanges property: Is link connection applying changes.
     * 
     * @param isApplyingChanges the isApplyingChanges value to set.
     * @return the LinkConnectionDetailedStatus object itself.
     */
    @Generated
    public LinkConnectionDetailedStatus setIsApplyingChanges(Boolean isApplyingChanges) {
        this.isApplyingChanges = isApplyingChanges;
        return this;
    }

    /**
     * Get the isPartiallyFailed property: Is link connection partially failed.
     * 
     * @return the isPartiallyFailed value.
     */
    @Generated
    public Boolean isPartiallyFailed() {
        return this.isPartiallyFailed;
    }

    /**
     * Set the isPartiallyFailed property: Is link connection partially failed.
     * 
     * @param isPartiallyFailed the isPartiallyFailed value to set.
     * @return the LinkConnectionDetailedStatus object itself.
     */
    @Generated
    public LinkConnectionDetailedStatus setIsPartiallyFailed(Boolean isPartiallyFailed) {
        this.isPartiallyFailed = isPartiallyFailed;
        return this;
    }

    /**
     * Get the startTime property: Link connection start time.
     * 
     * @return the startTime value.
     */
    @Generated
    public Object getStartTime() {
        return this.startTime;
    }

    /**
     * Set the startTime property: Link connection start time.
     * 
     * @param startTime the startTime value to set.
     * @return the LinkConnectionDetailedStatus object itself.
     */
    @Generated
    public LinkConnectionDetailedStatus setStartTime(Object startTime) {
        this.startTime = startTime;
        return this;
    }

    /**
     * Get the stopTime property: Link connection stop time.
     * 
     * @return the stopTime value.
     */
    @Generated
    public Object getStopTime() {
        return this.stopTime;
    }

    /**
     * Set the stopTime property: Link connection stop time.
     * 
     * @param stopTime the stopTime value to set.
     * @return the LinkConnectionDetailedStatus object itself.
     */
    @Generated
    public LinkConnectionDetailedStatus setStopTime(Object stopTime) {
        this.stopTime = stopTime;
        return this;
    }

    /**
     * Get the status property: Link connection status, please refer to this
     * [articles](https://learn.microsoft.com/azure/synapse-analytics/synapse-link/sql-database-synapse-link#monitoring)
     * for details.
     * 
     * @return the status value.
     */
    @Generated
    public String getStatus() {
        return this.status;
    }

    /**
     * Set the status property: Link connection status, please refer to this
     * [articles](https://learn.microsoft.com/azure/synapse-analytics/synapse-link/sql-database-synapse-link#monitoring)
     * for details.
     * 
     * @param status the status value to set.
     * @return the LinkConnectionDetailedStatus object itself.
     */
    @Generated
    public LinkConnectionDetailedStatus setStatus(String status) {
        this.status = status;
        return this;
    }

    /**
     * Get the continuousRunId property: Link connection's corresponding continuous run id.
     * 
     * @return the continuousRunId value.
     */
    @Generated
    public String getContinuousRunId() {
        return this.continuousRunId;
    }

    /**
     * Set the continuousRunId property: Link connection's corresponding continuous run id.
     * 
     * @param continuousRunId the continuousRunId value to set.
     * @return the LinkConnectionDetailedStatus object itself.
     */
    @Generated
    public LinkConnectionDetailedStatus setContinuousRunId(String continuousRunId) {
        this.continuousRunId = continuousRunId;
        return this;
    }

    /**
     * Get the error property: Link connection error.
     * 
     * @return the error value.
     */
    @Generated
    public Object getError() {
        return this.error;
    }

    /**
     * Set the error property: Link connection error.
     * 
     * @param error the error value to set.
     * @return the LinkConnectionDetailedStatus object itself.
     */
    @Generated
    public LinkConnectionDetailedStatus setError(Object error) {
        this.error = error;
        return this;
    }

    /**
     * Get the refreshStatus property: Link connection refresh status.
     * 
     * @return the refreshStatus value.
     */
    @Generated
    public LinkConnectionRefreshStatus getRefreshStatus() {
        return this.refreshStatus;
    }

    /**
     * Set the refreshStatus property: Link connection refresh status.
     * 
     * @param refreshStatus the refreshStatus value to set.
     * @return the LinkConnectionDetailedStatus object itself.
     */
    @Generated
    public LinkConnectionDetailedStatus setRefreshStatus(LinkConnectionRefreshStatus refreshStatus) {
        this.refreshStatus = refreshStatus;
        return this;
    }

    /**
     * Get the landingZoneCredentialExpireTime property: Link connection landing zone credential expire time.
     * 
     * @return the landingZoneCredentialExpireTime value.
     */
    @Generated
    public OffsetDateTime getLandingZoneCredentialExpireTime() {
        return this.landingZoneCredentialExpireTime;
    }

    /**
     * Set the landingZoneCredentialExpireTime property: Link connection landing zone credential expire time.
     * 
     * @param landingZoneCredentialExpireTime the landingZoneCredentialExpireTime value to set.
     * @return the LinkConnectionDetailedStatus object itself.
     */
    @Generated
    public LinkConnectionDetailedStatus
        setLandingZoneCredentialExpireTime(OffsetDateTime landingZoneCredentialExpireTime) {
        this.landingZoneCredentialExpireTime = landingZoneCredentialExpireTime;
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Generated
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeStringField("id", this.id);
        jsonWriter.writeStringField("name", this.name);
        jsonWriter.writeBooleanField("isApplyingChanges", this.isApplyingChanges);
        jsonWriter.writeBooleanField("isPartiallyFailed", this.isPartiallyFailed);
        if (this.startTime != null) {
            jsonWriter.writeUntypedField("startTime", this.startTime);
        }
        if (this.stopTime != null) {
            jsonWriter.writeUntypedField("stopTime", this.stopTime);
        }
        jsonWriter.writeStringField("status", this.status);
        jsonWriter.writeStringField("continuousRunId", this.continuousRunId);
        if (this.error != null) {
            jsonWriter.writeUntypedField("error", this.error);
        }
        jsonWriter.writeJsonField("refreshStatus", this.refreshStatus);
        jsonWriter.writeStringField("landingZoneCredentialExpireTime",
            this.landingZoneCredentialExpireTime == null
                ? null
                : DateTimeFormatter.ISO_OFFSET_DATE_TIME.format(this.landingZoneCredentialExpireTime));
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of LinkConnectionDetailedStatus from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of LinkConnectionDetailedStatus if the JsonReader was pointing to an instance of it, or null
     * if it was pointing to JSON null.
     * @throws IOException If an error occurs while reading the LinkConnectionDetailedStatus.
     */
    @Generated
    public static LinkConnectionDetailedStatus fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            LinkConnectionDetailedStatus deserializedLinkConnectionDetailedStatus = new LinkConnectionDetailedStatus();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("id".equals(fieldName)) {
                    deserializedLinkConnectionDetailedStatus.id = reader.getString();
                } else if ("name".equals(fieldName)) {
                    deserializedLinkConnectionDetailedStatus.name = reader.getString();
                } else if ("isApplyingChanges".equals(fieldName)) {
                    deserializedLinkConnectionDetailedStatus.isApplyingChanges
                        = reader.getNullable(JsonReader::getBoolean);
                } else if ("isPartiallyFailed".equals(fieldName)) {
                    deserializedLinkConnectionDetailedStatus.isPartiallyFailed
                        = reader.getNullable(JsonReader::getBoolean);
                } else if ("startTime".equals(fieldName)) {
                    deserializedLinkConnectionDetailedStatus.startTime = reader.readUntyped();
                } else if ("stopTime".equals(fieldName)) {
                    deserializedLinkConnectionDetailedStatus.stopTime = reader.readUntyped();
                } else if ("status".equals(fieldName)) {
                    deserializedLinkConnectionDetailedStatus.status = reader.getString();
                } else if ("continuousRunId".equals(fieldName)) {
                    deserializedLinkConnectionDetailedStatus.continuousRunId = reader.getString();
                } else if ("error".equals(fieldName)) {
                    deserializedLinkConnectionDetailedStatus.error = reader.readUntyped();
                } else if ("refreshStatus".equals(fieldName)) {
                    deserializedLinkConnectionDetailedStatus.refreshStatus
                        = LinkConnectionRefreshStatus.fromJson(reader);
                } else if ("landingZoneCredentialExpireTime".equals(fieldName)) {
                    deserializedLinkConnectionDetailedStatus.landingZoneCredentialExpireTime = reader
                        .getNullable(nonNullReader -> CoreUtils.parseBestOffsetDateTime(nonNullReader.getString()));
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedLinkConnectionDetailedStatus;
        });
    }
}
