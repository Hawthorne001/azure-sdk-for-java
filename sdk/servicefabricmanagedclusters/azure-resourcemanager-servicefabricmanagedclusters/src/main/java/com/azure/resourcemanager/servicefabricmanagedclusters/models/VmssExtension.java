// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) TypeSpec Code Generator.

package com.azure.resourcemanager.servicefabricmanagedclusters.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.util.logging.ClientLogger;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import com.azure.resourcemanager.servicefabricmanagedclusters.fluent.models.VMSSExtensionProperties;
import java.io.IOException;
import java.util.List;

/**
 * Specifies set of extensions that should be installed onto the virtual machines.
 */
@Fluent
public final class VmssExtension implements JsonSerializable<VmssExtension> {
    /*
     * The name of the extension.
     */
    private String name;

    /*
     * Describes the properties of a Virtual Machine Scale Set Extension.
     */
    private VMSSExtensionProperties innerProperties = new VMSSExtensionProperties();

    /**
     * Creates an instance of VmssExtension class.
     */
    public VmssExtension() {
    }

    /**
     * Get the name property: The name of the extension.
     * 
     * @return the name value.
     */
    public String name() {
        return this.name;
    }

    /**
     * Set the name property: The name of the extension.
     * 
     * @param name the name value to set.
     * @return the VmssExtension object itself.
     */
    public VmssExtension withName(String name) {
        this.name = name;
        return this;
    }

    /**
     * Get the innerProperties property: Describes the properties of a Virtual Machine Scale Set Extension.
     * 
     * @return the innerProperties value.
     */
    private VMSSExtensionProperties innerProperties() {
        return this.innerProperties;
    }

    /**
     * Get the publisher property: The name of the extension handler publisher.
     * 
     * @return the publisher value.
     */
    public String publisher() {
        return this.innerProperties() == null ? null : this.innerProperties().publisher();
    }

    /**
     * Set the publisher property: The name of the extension handler publisher.
     * 
     * @param publisher the publisher value to set.
     * @return the VmssExtension object itself.
     */
    public VmssExtension withPublisher(String publisher) {
        if (this.innerProperties() == null) {
            this.innerProperties = new VMSSExtensionProperties();
        }
        this.innerProperties().withPublisher(publisher);
        return this;
    }

    /**
     * Get the type property: Specifies the type of the extension; an example is "CustomScriptExtension".
     * 
     * @return the type value.
     */
    public String type() {
        return this.innerProperties() == null ? null : this.innerProperties().type();
    }

    /**
     * Set the type property: Specifies the type of the extension; an example is "CustomScriptExtension".
     * 
     * @param type the type value to set.
     * @return the VmssExtension object itself.
     */
    public VmssExtension withType(String type) {
        if (this.innerProperties() == null) {
            this.innerProperties = new VMSSExtensionProperties();
        }
        this.innerProperties().withType(type);
        return this;
    }

    /**
     * Get the typeHandlerVersion property: Specifies the version of the script handler.
     * 
     * @return the typeHandlerVersion value.
     */
    public String typeHandlerVersion() {
        return this.innerProperties() == null ? null : this.innerProperties().typeHandlerVersion();
    }

    /**
     * Set the typeHandlerVersion property: Specifies the version of the script handler.
     * 
     * @param typeHandlerVersion the typeHandlerVersion value to set.
     * @return the VmssExtension object itself.
     */
    public VmssExtension withTypeHandlerVersion(String typeHandlerVersion) {
        if (this.innerProperties() == null) {
            this.innerProperties = new VMSSExtensionProperties();
        }
        this.innerProperties().withTypeHandlerVersion(typeHandlerVersion);
        return this;
    }

    /**
     * Get the autoUpgradeMinorVersion property: Indicates whether the extension should use a newer minor version if one
     * is available at deployment time. Once deployed, however, the extension will not upgrade minor versions unless
     * redeployed, even with this property set to true.
     * 
     * @return the autoUpgradeMinorVersion value.
     */
    public Boolean autoUpgradeMinorVersion() {
        return this.innerProperties() == null ? null : this.innerProperties().autoUpgradeMinorVersion();
    }

    /**
     * Set the autoUpgradeMinorVersion property: Indicates whether the extension should use a newer minor version if one
     * is available at deployment time. Once deployed, however, the extension will not upgrade minor versions unless
     * redeployed, even with this property set to true.
     * 
     * @param autoUpgradeMinorVersion the autoUpgradeMinorVersion value to set.
     * @return the VmssExtension object itself.
     */
    public VmssExtension withAutoUpgradeMinorVersion(Boolean autoUpgradeMinorVersion) {
        if (this.innerProperties() == null) {
            this.innerProperties = new VMSSExtensionProperties();
        }
        this.innerProperties().withAutoUpgradeMinorVersion(autoUpgradeMinorVersion);
        return this;
    }

    /**
     * Get the settings property: Json formatted public settings for the extension.
     * 
     * @return the settings value.
     */
    public Object settings() {
        return this.innerProperties() == null ? null : this.innerProperties().settings();
    }

    /**
     * Set the settings property: Json formatted public settings for the extension.
     * 
     * @param settings the settings value to set.
     * @return the VmssExtension object itself.
     */
    public VmssExtension withSettings(Object settings) {
        if (this.innerProperties() == null) {
            this.innerProperties = new VMSSExtensionProperties();
        }
        this.innerProperties().withSettings(settings);
        return this;
    }

    /**
     * Get the protectedSettings property: The extension can contain either protectedSettings or
     * protectedSettingsFromKeyVault or no protected settings at all.
     * 
     * @return the protectedSettings value.
     */
    public Object protectedSettings() {
        return this.innerProperties() == null ? null : this.innerProperties().protectedSettings();
    }

    /**
     * Set the protectedSettings property: The extension can contain either protectedSettings or
     * protectedSettingsFromKeyVault or no protected settings at all.
     * 
     * @param protectedSettings the protectedSettings value to set.
     * @return the VmssExtension object itself.
     */
    public VmssExtension withProtectedSettings(Object protectedSettings) {
        if (this.innerProperties() == null) {
            this.innerProperties = new VMSSExtensionProperties();
        }
        this.innerProperties().withProtectedSettings(protectedSettings);
        return this;
    }

    /**
     * Get the forceUpdateTag property: If a value is provided and is different from the previous value, the extension
     * handler will be forced to update even if the extension configuration has not changed.
     * 
     * @return the forceUpdateTag value.
     */
    public String forceUpdateTag() {
        return this.innerProperties() == null ? null : this.innerProperties().forceUpdateTag();
    }

    /**
     * Set the forceUpdateTag property: If a value is provided and is different from the previous value, the extension
     * handler will be forced to update even if the extension configuration has not changed.
     * 
     * @param forceUpdateTag the forceUpdateTag value to set.
     * @return the VmssExtension object itself.
     */
    public VmssExtension withForceUpdateTag(String forceUpdateTag) {
        if (this.innerProperties() == null) {
            this.innerProperties = new VMSSExtensionProperties();
        }
        this.innerProperties().withForceUpdateTag(forceUpdateTag);
        return this;
    }

    /**
     * Get the provisionAfterExtensions property: Collection of extension names after which this extension needs to be
     * provisioned.
     * 
     * @return the provisionAfterExtensions value.
     */
    public List<String> provisionAfterExtensions() {
        return this.innerProperties() == null ? null : this.innerProperties().provisionAfterExtensions();
    }

    /**
     * Set the provisionAfterExtensions property: Collection of extension names after which this extension needs to be
     * provisioned.
     * 
     * @param provisionAfterExtensions the provisionAfterExtensions value to set.
     * @return the VmssExtension object itself.
     */
    public VmssExtension withProvisionAfterExtensions(List<String> provisionAfterExtensions) {
        if (this.innerProperties() == null) {
            this.innerProperties = new VMSSExtensionProperties();
        }
        this.innerProperties().withProvisionAfterExtensions(provisionAfterExtensions);
        return this;
    }

    /**
     * Get the provisioningState property: The provisioning state, which only appears in the response.
     * 
     * @return the provisioningState value.
     */
    public String provisioningState() {
        return this.innerProperties() == null ? null : this.innerProperties().provisioningState();
    }

    /**
     * Get the enableAutomaticUpgrade property: Indicates whether the extension should be automatically upgraded by the
     * platform if there is a newer version of the extension available.
     * 
     * @return the enableAutomaticUpgrade value.
     */
    public Boolean enableAutomaticUpgrade() {
        return this.innerProperties() == null ? null : this.innerProperties().enableAutomaticUpgrade();
    }

    /**
     * Set the enableAutomaticUpgrade property: Indicates whether the extension should be automatically upgraded by the
     * platform if there is a newer version of the extension available.
     * 
     * @param enableAutomaticUpgrade the enableAutomaticUpgrade value to set.
     * @return the VmssExtension object itself.
     */
    public VmssExtension withEnableAutomaticUpgrade(Boolean enableAutomaticUpgrade) {
        if (this.innerProperties() == null) {
            this.innerProperties = new VMSSExtensionProperties();
        }
        this.innerProperties().withEnableAutomaticUpgrade(enableAutomaticUpgrade);
        return this;
    }

    /**
     * Get the setupOrder property: Indicates the setup order for the extension.
     * 
     * @return the setupOrder value.
     */
    public List<VmssExtensionSetupOrder> setupOrder() {
        return this.innerProperties() == null ? null : this.innerProperties().setupOrder();
    }

    /**
     * Set the setupOrder property: Indicates the setup order for the extension.
     * 
     * @param setupOrder the setupOrder value to set.
     * @return the VmssExtension object itself.
     */
    public VmssExtension withSetupOrder(List<VmssExtensionSetupOrder> setupOrder) {
        if (this.innerProperties() == null) {
            this.innerProperties = new VMSSExtensionProperties();
        }
        this.innerProperties().withSetupOrder(setupOrder);
        return this;
    }

    /**
     * Validates the instance.
     * 
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (name() == null) {
            throw LOGGER.atError()
                .log(new IllegalArgumentException("Missing required property name in model VmssExtension"));
        }
        if (innerProperties() == null) {
            throw LOGGER.atError()
                .log(new IllegalArgumentException("Missing required property innerProperties in model VmssExtension"));
        } else {
            innerProperties().validate();
        }
    }

    private static final ClientLogger LOGGER = new ClientLogger(VmssExtension.class);

    /**
     * {@inheritDoc}
     */
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeStringField("name", this.name);
        jsonWriter.writeJsonField("properties", this.innerProperties);
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of VmssExtension from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of VmssExtension if the JsonReader was pointing to an instance of it, or null if it was
     * pointing to JSON null.
     * @throws IllegalStateException If the deserialized JSON object was missing any required properties.
     * @throws IOException If an error occurs while reading the VmssExtension.
     */
    public static VmssExtension fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            VmssExtension deserializedVmssExtension = new VmssExtension();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("name".equals(fieldName)) {
                    deserializedVmssExtension.name = reader.getString();
                } else if ("properties".equals(fieldName)) {
                    deserializedVmssExtension.innerProperties = VMSSExtensionProperties.fromJson(reader);
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedVmssExtension;
        });
    }
}
