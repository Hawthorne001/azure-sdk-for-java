// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.datamigration.generated;

import com.azure.core.credential.AccessToken;
import com.azure.core.http.HttpClient;
import com.azure.core.management.profile.AzureProfile;
import com.azure.core.models.AzureCloud;
import com.azure.core.test.http.MockHttpResponse;
import com.azure.resourcemanager.datamigration.DataMigrationManager;
import com.azure.resourcemanager.datamigration.models.DataMigrationServiceStatusResponse;
import java.nio.charset.StandardCharsets;
import java.time.OffsetDateTime;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;

public final class ServicesCheckStatusWithResponseMockTests {
    @Test
    public void testCheckStatusWithResponse() throws Exception {
        String responseStr
            = "{\"agentVersion\":\"zplusdekpdzzms\",\"agentConfiguration\":\"datapgvokyejidbd\",\"status\":\"squnycwztlv\",\"vmSize\":\"snmr\",\"supportedTaskTypes\":[\"jtrepwpwfkcaux\",\"va\",\"cpfpdofuckcl\",\"txluevs\"]}";

        HttpClient httpClient
            = response -> Mono.just(new MockHttpResponse(response, 200, responseStr.getBytes(StandardCharsets.UTF_8)));
        DataMigrationManager manager = DataMigrationManager.configure()
            .withHttpClient(httpClient)
            .authenticate(tokenRequestContext -> Mono.just(new AccessToken("this_is_a_token", OffsetDateTime.MAX)),
                new AzureProfile("", "", AzureCloud.AZURE_PUBLIC_CLOUD));

        DataMigrationServiceStatusResponse response = manager.services()
            .checkStatusWithResponse("to", "uwhttnzqsaqmeb", com.azure.core.util.Context.NONE)
            .getValue();

        Assertions.assertEquals("zplusdekpdzzms", response.agentVersion());
        Assertions.assertEquals("squnycwztlv", response.status());
        Assertions.assertEquals("snmr", response.vmSize());
        Assertions.assertEquals("jtrepwpwfkcaux", response.supportedTaskTypes().get(0));
    }
}
