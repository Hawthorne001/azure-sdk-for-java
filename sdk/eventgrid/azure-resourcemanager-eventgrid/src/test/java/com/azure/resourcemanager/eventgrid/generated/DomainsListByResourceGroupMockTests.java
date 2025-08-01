// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.eventgrid.generated;

import com.azure.core.credential.AccessToken;
import com.azure.core.http.HttpClient;
import com.azure.core.http.rest.PagedIterable;
import com.azure.core.management.profile.AzureProfile;
import com.azure.core.models.AzureCloud;
import com.azure.core.test.http.MockHttpResponse;
import com.azure.resourcemanager.eventgrid.EventGridManager;
import com.azure.resourcemanager.eventgrid.models.DataResidencyBoundary;
import com.azure.resourcemanager.eventgrid.models.Domain;
import com.azure.resourcemanager.eventgrid.models.EventDefinitionKind;
import com.azure.resourcemanager.eventgrid.models.IdentityType;
import com.azure.resourcemanager.eventgrid.models.InputSchema;
import com.azure.resourcemanager.eventgrid.models.IpActionType;
import com.azure.resourcemanager.eventgrid.models.PublicNetworkAccess;
import com.azure.resourcemanager.eventgrid.models.Sku;
import com.azure.resourcemanager.eventgrid.models.TlsVersion;
import java.nio.charset.StandardCharsets;
import java.time.OffsetDateTime;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;

public final class DomainsListByResourceGroupMockTests {
    @Test
    public void testListByResourceGroup() throws Exception {
        String responseStr
            = "{\"value\":[{\"properties\":{\"privateEndpointConnections\":[{\"properties\":{\"privateEndpoint\":{},\"groupIds\":[\"zjhfvhuwzbxpc\",\"zgihotje\",\"ohmxvvlrrska\"],\"privateLinkServiceConnectionState\":{},\"provisioningState\":\"Succeeded\"},\"id\":\"iee\",\"name\":\"uyader\",\"type\":\"tfo\"},{\"properties\":{\"privateEndpoint\":{},\"groupIds\":[\"imyc\",\"grvkcxzznnuif\",\"rsejegprkj\"],\"privateLinkServiceConnectionState\":{},\"provisioningState\":\"Canceled\"},\"id\":\"jmwvvbtuqkxxi\",\"name\":\"wgxql\",\"type\":\"ekotjgxi\"},{\"properties\":{\"privateEndpoint\":{},\"groupIds\":[\"fh\",\"wvjaq\"],\"privateLinkServiceConnectionState\":{},\"provisioningState\":\"Updating\"},\"id\":\"ynvskpajbmgeume\",\"name\":\"mj\",\"type\":\"xcbccwkqmt\"}],\"provisioningState\":\"Creating\",\"minimumTlsVersionAllowed\":\"1.1\",\"endpoint\":\"scrpilgftrqrej\",\"inputSchema\":\"CloudEventSchemaV1_0\",\"eventTypeInfo\":{\"kind\":\"Inline\",\"inlineEventTypes\":{\"j\":{\"description\":\"dahlfxlmuifmuadj\",\"displayName\":\"snc\",\"documentationUrl\":\"iioshjgcz\",\"dataSchemaUrl\":\"ybnxgztlcgc\"}}},\"inputSchemaMapping\":{\"inputSchemaMappingType\":\"InputSchemaMapping\"},\"metricResourceId\":\"j\",\"publicNetworkAccess\":\"Disabled\",\"inboundIpRules\":[{\"ipMask\":\"ebecuvlbefv\",\"action\":\"Allow\"}],\"disableLocalAuth\":true,\"autoCreateTopicWithFirstSubscription\":true,\"autoDeleteTopicWithLastSubscription\":true,\"dataResidencyBoundary\":\"WithinRegion\"},\"sku\":{\"name\":\"Basic\"},\"identity\":{\"type\":\"SystemAssigned\",\"principalId\":\"yxjijeypdvrbker\",\"tenantId\":\"dkgaw\",\"userAssignedIdentities\":{\"oisfmnaybdjn\":{\"principalId\":\"ildfk\",\"clientId\":\"feygzqp\"},\"xym\":{\"principalId\":\"mentqo\",\"clientId\":\"why\"},\"jasqubf\":{\"principalId\":\"wi\",\"clientId\":\"towlhlsycoyb\"}}},\"location\":\"cywhj\",\"tags\":{\"ymjzpwdlvwtiws\":\"chqohtfxcpupuk\",\"tassaekewna\":\"osaonhqnamppu\"},\"id\":\"eajbkajlcyizyddc\",\"name\":\"xo\",\"type\":\"krvfsxxbydes\"}]}";

        HttpClient httpClient
            = response -> Mono.just(new MockHttpResponse(response, 200, responseStr.getBytes(StandardCharsets.UTF_8)));
        EventGridManager manager = EventGridManager.configure()
            .withHttpClient(httpClient)
            .authenticate(tokenRequestContext -> Mono.just(new AccessToken("this_is_a_token", OffsetDateTime.MAX)),
                new AzureProfile("", "", AzureCloud.AZURE_PUBLIC_CLOUD));

        PagedIterable<Domain> response
            = manager.domains().listByResourceGroup("l", "yjprxslw", 211488619, com.azure.core.util.Context.NONE);

        Assertions.assertEquals("cywhj", response.iterator().next().location());
        Assertions.assertEquals("chqohtfxcpupuk", response.iterator().next().tags().get("ymjzpwdlvwtiws"));
        Assertions.assertEquals(Sku.BASIC, response.iterator().next().sku().name());
        Assertions.assertEquals(IdentityType.SYSTEM_ASSIGNED, response.iterator().next().identity().type());
        Assertions.assertEquals("yxjijeypdvrbker", response.iterator().next().identity().principalId());
        Assertions.assertEquals("dkgaw", response.iterator().next().identity().tenantId());
        Assertions.assertEquals("ildfk",
            response.iterator().next().identity().userAssignedIdentities().get("oisfmnaybdjn").principalId());
        Assertions.assertEquals("feygzqp",
            response.iterator().next().identity().userAssignedIdentities().get("oisfmnaybdjn").clientId());
        Assertions.assertEquals(TlsVersion.ONE_ONE, response.iterator().next().minimumTlsVersionAllowed());
        Assertions.assertEquals(InputSchema.CLOUD_EVENT_SCHEMA_V1_0, response.iterator().next().inputSchema());
        Assertions.assertEquals(EventDefinitionKind.INLINE, response.iterator().next().eventTypeInfo().kind());
        Assertions.assertEquals("dahlfxlmuifmuadj",
            response.iterator().next().eventTypeInfo().inlineEventTypes().get("j").description());
        Assertions.assertEquals("snc",
            response.iterator().next().eventTypeInfo().inlineEventTypes().get("j").displayName());
        Assertions.assertEquals("iioshjgcz",
            response.iterator().next().eventTypeInfo().inlineEventTypes().get("j").documentationUrl());
        Assertions.assertEquals("ybnxgztlcgc",
            response.iterator().next().eventTypeInfo().inlineEventTypes().get("j").dataSchemaUrl());
        Assertions.assertEquals(PublicNetworkAccess.DISABLED, response.iterator().next().publicNetworkAccess());
        Assertions.assertEquals("ebecuvlbefv", response.iterator().next().inboundIpRules().get(0).ipMask());
        Assertions.assertEquals(IpActionType.ALLOW, response.iterator().next().inboundIpRules().get(0).action());
        Assertions.assertTrue(response.iterator().next().disableLocalAuth());
        Assertions.assertTrue(response.iterator().next().autoCreateTopicWithFirstSubscription());
        Assertions.assertTrue(response.iterator().next().autoDeleteTopicWithLastSubscription());
        Assertions.assertEquals(DataResidencyBoundary.WITHIN_REGION,
            response.iterator().next().dataResidencyBoundary());
    }
}
