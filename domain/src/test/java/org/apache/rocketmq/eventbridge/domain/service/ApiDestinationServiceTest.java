/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.rocketmq.eventbridge.domain.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.apache.rocketmq.eventbridge.domain.model.PaginationResult;
import org.apache.rocketmq.eventbridge.domain.model.apidestination.ApiDestinationDTO;
import org.apache.rocketmq.eventbridge.domain.model.apidestination.ApiDestinationService;
import org.apache.rocketmq.eventbridge.domain.model.apidestination.parameter.HttpApiParameters;
import org.apache.rocketmq.eventbridge.domain.model.quota.QuotaService;
import org.apache.rocketmq.eventbridge.domain.repository.ApiDestinationRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;

@RunWith(MockitoJUnitRunner.class)
public class ApiDestinationServiceTest {

    @InjectMocks
    private ApiDestinationService apiDestinationService;
    @Mock
    private ApiDestinationRepository apiDestinationRepository;
    @Mock
    private QuotaService quotaService;

    @Before
    public void testBefore() {
        Mockito.when(apiDestinationRepository.createApiDestination(any())).thenReturn(Boolean.TRUE);
        Mockito.when(apiDestinationRepository.deleteApiDestination(any(), any())).thenReturn(Boolean.TRUE);
        Mockito.when(apiDestinationRepository.updateApiDestination(any())).thenReturn(Boolean.TRUE);
        ApiDestinationDTO apiDestinationDTO = new ApiDestinationDTO();
        apiDestinationDTO.setName(UUID.randomUUID().toString());
        Mockito.when(apiDestinationRepository.getApiDestinationCount(any())).thenReturn(8);
        Mockito.when(apiDestinationRepository.listApiDestinations(any(), any(), any(), any(), anyInt())).thenReturn(new ArrayList<>());
        Mockito.when(quotaService.getTotalQuota(any(), any())).thenReturn(10);
    }

    @Test
    public void testCreateApiDestination() {
        Mockito.when(apiDestinationRepository.getApiDestination(any(), any())).thenReturn(null);
        ApiDestinationDTO eventApiDestinationDTO = new ApiDestinationDTO();
        eventApiDestinationDTO.setName(UUID.randomUUID().toString());
        eventApiDestinationDTO.setAccountId(UUID.randomUUID().toString());
        HttpApiParameters httpApiParameters = new HttpApiParameters();
        httpApiParameters.setMethod("POST");
        httpApiParameters.setEndpoint("http://127.0.0.1:8001");
        eventApiDestinationDTO.setApiParams(httpApiParameters);
        final String apiDestination = apiDestinationService.createApiDestination(eventApiDestinationDTO);
        Assert.assertNotNull(apiDestination);
    }

    @Test
    public void testUpdateApiDestination() {
        Mockito.when(apiDestinationRepository.getApiDestination(any(), any())).thenReturn(new ApiDestinationDTO());
        ApiDestinationDTO apiDestinationDTO = new ApiDestinationDTO();
        apiDestinationDTO.setName(UUID.randomUUID().toString());
        apiDestinationDTO.setAccountId(UUID.randomUUID().toString());
        HttpApiParameters httpApiParameters = new HttpApiParameters();
        httpApiParameters.setMethod("POST");
        httpApiParameters.setEndpoint("http://127.0.0.1:8001");
        apiDestinationDTO.setApiParams(httpApiParameters);
        final Boolean aBoolean = apiDestinationService.updateApiDestination(apiDestinationDTO);
        Assert.assertTrue(aBoolean);
    }

    @Test
    public void testGetApiDestination() {
        Mockito.when(apiDestinationRepository.getApiDestination(any(), any())).thenReturn(new ApiDestinationDTO());
        final ApiDestinationDTO apiDestinationDTO = apiDestinationService.getApiDestination(UUID.randomUUID().toString(), UUID.randomUUID().toString());
        Assert.assertNotNull(apiDestinationDTO);
    }

    @Test
    public void testDeleteApiDestination() {
        Mockito.when(apiDestinationRepository.getApiDestination(any(), any())).thenReturn(new ApiDestinationDTO());
        final Boolean aBoolean = apiDestinationService.deleteApiDestination(UUID.randomUUID().toString(), UUID.randomUUID().toString());
        Assert.assertTrue(aBoolean);
    }

    @Test
    public void testListApiDestinations() {
        final PaginationResult<List<ApiDestinationDTO>> listPaginationResult = apiDestinationService.listApiDestinations(UUID.randomUUID().toString(), UUID.randomUUID().toString(), UUID.randomUUID().toString(), "0", 10);
        Assert.assertNotNull(listPaginationResult.getData());
    }
}
