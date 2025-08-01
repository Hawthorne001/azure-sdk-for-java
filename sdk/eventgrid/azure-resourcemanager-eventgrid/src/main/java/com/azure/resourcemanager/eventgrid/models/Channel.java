// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.eventgrid.models;

import com.azure.core.http.rest.Response;
import com.azure.core.management.SystemData;
import com.azure.core.util.Context;
import com.azure.resourcemanager.eventgrid.fluent.models.ChannelInner;
import java.time.OffsetDateTime;

/**
 * An immutable client-side representation of Channel.
 */
public interface Channel {
    /**
     * Gets the id property: Fully qualified resource Id for the resource.
     * 
     * @return the id value.
     */
    String id();

    /**
     * Gets the name property: The name of the resource.
     * 
     * @return the name value.
     */
    String name();

    /**
     * Gets the type property: The type of the resource.
     * 
     * @return the type value.
     */
    String type();

    /**
     * Gets the systemData property: The system metadata relating to the Event Grid resource.
     * 
     * @return the systemData value.
     */
    SystemData systemData();

    /**
     * Gets the channelType property: The type of the event channel which represents the direction flow of events.
     * 
     * @return the channelType value.
     */
    ChannelType channelType();

    /**
     * Gets the partnerTopicInfo property: This property should be populated when channelType is PartnerTopic and
     * represents information about the partner topic resource corresponding to the channel.
     * 
     * @return the partnerTopicInfo value.
     */
    PartnerTopicInfo partnerTopicInfo();

    /**
     * Gets the partnerDestinationInfo property: This property should be populated when channelType is
     * PartnerDestination and represents information about the partner destination resource corresponding to the
     * channel.
     * 
     * @return the partnerDestinationInfo value.
     */
    PartnerDestinationInfo partnerDestinationInfo();

    /**
     * Gets the messageForActivation property: Context or helpful message that can be used during the approval process
     * by the subscriber.
     * 
     * @return the messageForActivation value.
     */
    String messageForActivation();

    /**
     * Gets the provisioningState property: Provisioning state of the channel.
     * 
     * @return the provisioningState value.
     */
    ChannelProvisioningState provisioningState();

    /**
     * Gets the readinessState property: The readiness state of the corresponding partner topic.
     * 
     * @return the readinessState value.
     */
    ReadinessState readinessState();

    /**
     * Gets the expirationTimeIfNotActivatedUtc property: Expiration time of the channel. If this timer expires while
     * the corresponding partner topic is never activated,
     * the channel and corresponding partner topic are deleted.
     * 
     * @return the expirationTimeIfNotActivatedUtc value.
     */
    OffsetDateTime expirationTimeIfNotActivatedUtc();

    /**
     * Gets the name of the resource group.
     * 
     * @return the name of the resource group.
     */
    String resourceGroupName();

    /**
     * Gets the inner com.azure.resourcemanager.eventgrid.fluent.models.ChannelInner object.
     * 
     * @return the inner object.
     */
    ChannelInner innerModel();

    /**
     * The entirety of the Channel definition.
     */
    interface Definition
        extends DefinitionStages.Blank, DefinitionStages.WithParentResource, DefinitionStages.WithCreate {
    }

    /**
     * The Channel definition stages.
     */
    interface DefinitionStages {
        /**
         * The first stage of the Channel definition.
         */
        interface Blank extends WithParentResource {
        }

        /**
         * The stage of the Channel definition allowing to specify parent resource.
         */
        interface WithParentResource {
            /**
             * Specifies resourceGroupName, partnerNamespaceName.
             * 
             * @param resourceGroupName The name of the resource group within the partners subscription.
             * @param partnerNamespaceName Name of the partner namespace.
             * @return the next definition stage.
             */
            WithCreate withExistingPartnerNamespace(String resourceGroupName, String partnerNamespaceName);
        }

        /**
         * The stage of the Channel definition which contains all the minimum required properties for the resource to be
         * created, but also allows for any other optional properties to be specified.
         */
        interface WithCreate extends DefinitionStages.WithChannelType, DefinitionStages.WithPartnerTopicInfo,
            DefinitionStages.WithPartnerDestinationInfo, DefinitionStages.WithMessageForActivation,
            DefinitionStages.WithProvisioningState, DefinitionStages.WithReadinessState,
            DefinitionStages.WithExpirationTimeIfNotActivatedUtc {
            /**
             * Executes the create request.
             * 
             * @return the created resource.
             */
            Channel create();

            /**
             * Executes the create request.
             * 
             * @param context The context to associate with this operation.
             * @return the created resource.
             */
            Channel create(Context context);
        }

        /**
         * The stage of the Channel definition allowing to specify channelType.
         */
        interface WithChannelType {
            /**
             * Specifies the channelType property: The type of the event channel which represents the direction flow of
             * events..
             * 
             * @param channelType The type of the event channel which represents the direction flow of events.
             * @return the next definition stage.
             */
            WithCreate withChannelType(ChannelType channelType);
        }

        /**
         * The stage of the Channel definition allowing to specify partnerTopicInfo.
         */
        interface WithPartnerTopicInfo {
            /**
             * Specifies the partnerTopicInfo property: This property should be populated when channelType is
             * PartnerTopic and represents information about the partner topic resource corresponding to the channel..
             * 
             * @param partnerTopicInfo This property should be populated when channelType is PartnerTopic and represents
             * information about the partner topic resource corresponding to the channel.
             * @return the next definition stage.
             */
            WithCreate withPartnerTopicInfo(PartnerTopicInfo partnerTopicInfo);
        }

        /**
         * The stage of the Channel definition allowing to specify partnerDestinationInfo.
         */
        interface WithPartnerDestinationInfo {
            /**
             * Specifies the partnerDestinationInfo property: This property should be populated when channelType is
             * PartnerDestination and represents information about the partner destination resource corresponding to the
             * channel..
             * 
             * @param partnerDestinationInfo This property should be populated when channelType is PartnerDestination
             * and represents information about the partner destination resource corresponding to the channel.
             * @return the next definition stage.
             */
            WithCreate withPartnerDestinationInfo(PartnerDestinationInfo partnerDestinationInfo);
        }

        /**
         * The stage of the Channel definition allowing to specify messageForActivation.
         */
        interface WithMessageForActivation {
            /**
             * Specifies the messageForActivation property: Context or helpful message that can be used during the
             * approval process by the subscriber..
             * 
             * @param messageForActivation Context or helpful message that can be used during the approval process by
             * the subscriber.
             * @return the next definition stage.
             */
            WithCreate withMessageForActivation(String messageForActivation);
        }

        /**
         * The stage of the Channel definition allowing to specify provisioningState.
         */
        interface WithProvisioningState {
            /**
             * Specifies the provisioningState property: Provisioning state of the channel..
             * 
             * @param provisioningState Provisioning state of the channel.
             * @return the next definition stage.
             */
            WithCreate withProvisioningState(ChannelProvisioningState provisioningState);
        }

        /**
         * The stage of the Channel definition allowing to specify readinessState.
         */
        interface WithReadinessState {
            /**
             * Specifies the readinessState property: The readiness state of the corresponding partner topic..
             * 
             * @param readinessState The readiness state of the corresponding partner topic.
             * @return the next definition stage.
             */
            WithCreate withReadinessState(ReadinessState readinessState);
        }

        /**
         * The stage of the Channel definition allowing to specify expirationTimeIfNotActivatedUtc.
         */
        interface WithExpirationTimeIfNotActivatedUtc {
            /**
             * Specifies the expirationTimeIfNotActivatedUtc property: Expiration time of the channel. If this timer
             * expires while the corresponding partner topic is never activated,
             * the channel and corresponding partner topic are deleted..
             * 
             * @param expirationTimeIfNotActivatedUtc Expiration time of the channel. If this timer expires while the
             * corresponding partner topic is never activated,
             * the channel and corresponding partner topic are deleted.
             * @return the next definition stage.
             */
            WithCreate withExpirationTimeIfNotActivatedUtc(OffsetDateTime expirationTimeIfNotActivatedUtc);
        }
    }

    /**
     * Begins update for the Channel resource.
     * 
     * @return the stage of resource update.
     */
    Channel.Update update();

    /**
     * The template for Channel update.
     */
    interface Update extends UpdateStages.WithChannelType, UpdateStages.WithPartnerTopicInfo,
        UpdateStages.WithPartnerDestinationInfo, UpdateStages.WithMessageForActivation,
        UpdateStages.WithProvisioningState, UpdateStages.WithReadinessState,
        UpdateStages.WithExpirationTimeIfNotActivatedUtc {
        /**
         * Executes the update request.
         * 
         * @return the updated resource.
         */
        Channel apply();

        /**
         * Executes the update request.
         * 
         * @param context The context to associate with this operation.
         * @return the updated resource.
         */
        Channel apply(Context context);
    }

    /**
     * The Channel update stages.
     */
    interface UpdateStages {
        /**
         * The stage of the Channel update allowing to specify channelType.
         */
        interface WithChannelType {
            /**
             * Specifies the channelType property: The type of the event channel which represents the direction flow of
             * events..
             * 
             * @param channelType The type of the event channel which represents the direction flow of events.
             * @return the next definition stage.
             */
            Update withChannelType(ChannelType channelType);
        }

        /**
         * The stage of the Channel update allowing to specify partnerTopicInfo.
         */
        interface WithPartnerTopicInfo {
            /**
             * Specifies the partnerTopicInfo property: This property should be populated when channelType is
             * PartnerTopic and represents information about the partner topic resource corresponding to the channel..
             * 
             * @param partnerTopicInfo This property should be populated when channelType is PartnerTopic and represents
             * information about the partner topic resource corresponding to the channel.
             * @return the next definition stage.
             */
            Update withPartnerTopicInfo(PartnerTopicInfo partnerTopicInfo);
        }

        /**
         * The stage of the Channel update allowing to specify partnerDestinationInfo.
         */
        interface WithPartnerDestinationInfo {
            /**
             * Specifies the partnerDestinationInfo property: This property should be populated when channelType is
             * PartnerDestination and represents information about the partner destination resource corresponding to the
             * channel..
             * 
             * @param partnerDestinationInfo This property should be populated when channelType is PartnerDestination
             * and represents information about the partner destination resource corresponding to the channel.
             * @return the next definition stage.
             */
            Update withPartnerDestinationInfo(PartnerDestinationInfo partnerDestinationInfo);
        }

        /**
         * The stage of the Channel update allowing to specify messageForActivation.
         */
        interface WithMessageForActivation {
            /**
             * Specifies the messageForActivation property: Context or helpful message that can be used during the
             * approval process by the subscriber..
             * 
             * @param messageForActivation Context or helpful message that can be used during the approval process by
             * the subscriber.
             * @return the next definition stage.
             */
            Update withMessageForActivation(String messageForActivation);
        }

        /**
         * The stage of the Channel update allowing to specify provisioningState.
         */
        interface WithProvisioningState {
            /**
             * Specifies the provisioningState property: Provisioning state of the channel..
             * 
             * @param provisioningState Provisioning state of the channel.
             * @return the next definition stage.
             */
            Update withProvisioningState(ChannelProvisioningState provisioningState);
        }

        /**
         * The stage of the Channel update allowing to specify readinessState.
         */
        interface WithReadinessState {
            /**
             * Specifies the readinessState property: The readiness state of the corresponding partner topic..
             * 
             * @param readinessState The readiness state of the corresponding partner topic.
             * @return the next definition stage.
             */
            Update withReadinessState(ReadinessState readinessState);
        }

        /**
         * The stage of the Channel update allowing to specify expirationTimeIfNotActivatedUtc.
         */
        interface WithExpirationTimeIfNotActivatedUtc {
            /**
             * Specifies the expirationTimeIfNotActivatedUtc property: Expiration time of the channel. If this timer
             * expires while the corresponding partner topic is never activated,
             * the channel and corresponding partner topic are deleted..
             * 
             * @param expirationTimeIfNotActivatedUtc Expiration time of the channel. If this timer expires while the
             * corresponding partner topic is never activated,
             * the channel and corresponding partner topic are deleted.
             * @return the next definition stage.
             */
            Update withExpirationTimeIfNotActivatedUtc(OffsetDateTime expirationTimeIfNotActivatedUtc);
        }
    }

    /**
     * Refreshes the resource to sync with Azure.
     * 
     * @return the refreshed resource.
     */
    Channel refresh();

    /**
     * Refreshes the resource to sync with Azure.
     * 
     * @param context The context to associate with this operation.
     * @return the refreshed resource.
     */
    Channel refresh(Context context);

    /**
     * Get full URL of partner destination channel.
     * 
     * Get the full endpoint URL of a partner destination channel.
     * 
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the full endpoint URL of a partner destination channel along with {@link Response}.
     */
    Response<EventSubscriptionFullUrl> getFullUrlWithResponse(Context context);

    /**
     * Get full URL of partner destination channel.
     * 
     * Get the full endpoint URL of a partner destination channel.
     * 
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the full endpoint URL of a partner destination channel.
     */
    EventSubscriptionFullUrl getFullUrl();
}
