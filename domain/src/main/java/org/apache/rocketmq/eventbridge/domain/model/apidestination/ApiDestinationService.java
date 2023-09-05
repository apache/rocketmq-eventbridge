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

package org.apache.rocketmq.eventbridge.domain.model.apidestination;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.eventbridge.domain.common.enums.TotalQuotaEnum;
import org.apache.commons.lang3.StringUtils;
import org.apache.rocketmq.eventbridge.domain.common.EventBridgeConstants;
import org.apache.rocketmq.eventbridge.domain.common.exception.EventBridgeErrorCode;
import org.apache.rocketmq.eventbridge.domain.model.AbstractResourceService;
import org.apache.rocketmq.eventbridge.domain.model.PaginationResult;
import org.apache.rocketmq.eventbridge.domain.model.connection.ConnectionService;
import org.apache.rocketmq.eventbridge.domain.model.quota.QuotaService;
import org.apache.rocketmq.eventbridge.domain.model.apidestination.parameter.HttpApiParameters;
import org.apache.rocketmq.eventbridge.domain.repository.ApiDestinationRepository;
import org.apache.rocketmq.eventbridge.exception.EventBridgeException;
import org.apache.rocketmq.eventbridge.tools.NextTokenUtil;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.apache.rocketmq.eventbridge.domain.common.exception.EventBridgeErrorCode.ApiDestinationCountExceedLimit;

@Slf4j
@Service
public class ApiDestinationService extends AbstractResourceService {

    private final ApiDestinationRepository apiDestinationRepository;

    private final ConnectionService connectionService;

    private final QuotaService quotaService;

    public ApiDestinationService(ApiDestinationRepository apiDestinationRepository, QuotaService quotaService, ConnectionService connectionService) {
        this.apiDestinationRepository = apiDestinationRepository;
        this.quotaService = quotaService;
        this.connectionService = connectionService;
    }

    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
    public String createApiDestination(ApiDestinationDTO eventApiDestinationDTO) {
        if (checkApiDestination(eventApiDestinationDTO.getAccountId(), eventApiDestinationDTO.getName()) != null) {
            throw new EventBridgeException(EventBridgeErrorCode.ApiDestinationAlreadyExist, eventApiDestinationDTO.getName());
        }
        super.checkQuota(this.getApiDestinationCount(eventApiDestinationDTO.getAccountId()), quotaService.getTotalQuota(eventApiDestinationDTO.getAccountId(), TotalQuotaEnum.API_DESTINATION_COUNT),
                ApiDestinationCountExceedLimit);
        checkHttpApiParameters(eventApiDestinationDTO.getApiParams());
        checkConnection(eventApiDestinationDTO);
        try {
            final Boolean apiDestination = apiDestinationRepository.createApiDestination(eventApiDestinationDTO);
            if (apiDestination) {
                return eventApiDestinationDTO.getName();
            }
        } catch (DuplicateKeyException duplicateKeyException) {
            throw new EventBridgeException(EventBridgeErrorCode.ApiDestinationAlreadyExist, eventApiDestinationDTO.getName());
        }
        return null;
    }

    private void checkConnection(ApiDestinationDTO eventApiDestinationDTO) {
        connectionService.getConnection(eventApiDestinationDTO.getAccountId(), eventApiDestinationDTO.getConnectionName());
    }

    private void checkHttpApiParameters(HttpApiParameters httpApiParameters) {
        if (httpApiParameters == null) {
            throw new EventBridgeException(EventBridgeErrorCode.HttpApiParametersIsNull);
        }
        if (StringUtils.isBlank(httpApiParameters.getEndpoint())) {
            throw new EventBridgeException(EventBridgeErrorCode.EndpointIsBlank);
        }
        if (StringUtils.isBlank(httpApiParameters.getMethod())) {
            throw new EventBridgeException(EventBridgeErrorCode.MethodIsBlank);
        }
        int len = httpApiParameters.getEndpoint().length();
        if (len > EventBridgeConstants.EVENT_ENDPOINT_MAX_LENGTH || len < EventBridgeConstants.EVENT_ENDPOINT_MIN_LENGTH) {
            throw new EventBridgeException(EventBridgeErrorCode.EndpointLengthExceed);
        }
    }

    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
    public Boolean updateApiDestination(ApiDestinationDTO apiDestinationDTO) {
        if (checkApiDestination(apiDestinationDTO.getAccountId(), apiDestinationDTO.getName()) == null) {
            throw new EventBridgeException(EventBridgeErrorCode.ApiDestinationNotExist, apiDestinationDTO.getName());
        }
        ApiDestinationDTO oldApiDestination = getApiDestination(apiDestinationDTO.getAccountId(), apiDestinationDTO.getName());
        if (StringUtils.isBlank(apiDestinationDTO.getConnectionName())) {
            apiDestinationDTO.setConnectionName(oldApiDestination.getConnectionName());
        }
        if (apiDestinationDTO.getApiParams() == null) {
            apiDestinationDTO.setApiParams(oldApiDestination.getApiParams());
        } else {
            HttpApiParameters apiParams = apiDestinationDTO.getApiParams();
            HttpApiParameters oldApiParams = oldApiDestination.getApiParams();
            if (StringUtils.isBlank(apiParams.getEndpoint())) {
                apiParams.setEndpoint(oldApiParams.getEndpoint());
            }
            if (StringUtils.isBlank(apiParams.getMethod())) {
                apiParams.setMethod(oldApiParams.getMethod());
            }
            apiDestinationDTO.setApiParams(apiParams);
        }
        return apiDestinationRepository.updateApiDestination(apiDestinationDTO);
    }

    public ApiDestinationDTO getApiDestination(String accountId, String apiDestinationName) {
        if (checkApiDestination(accountId, apiDestinationName) == null) {
            throw new EventBridgeException(EventBridgeErrorCode.ApiDestinationNotExist, apiDestinationName);
        }
        return apiDestinationRepository.getApiDestination(accountId, apiDestinationName);
    }

    public ApiDestinationDTO checkApiDestination(String accountId, String apiDestinationName) {
        return apiDestinationRepository.getApiDestination(accountId, apiDestinationName);
    }

    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
    public Boolean deleteApiDestination(String accountId, String apiDestinationName) {
        if (checkApiDestination(accountId, apiDestinationName) == null) {
            throw new EventBridgeException(EventBridgeErrorCode.ApiDestinationNotExist, apiDestinationName);
        }
        return apiDestinationRepository.deleteApiDestination(accountId, apiDestinationName);
    }

    public PaginationResult<List<ApiDestinationDTO>> listApiDestinations(String accountId, String apiDestinationName, String connectionName, String nextToken,
                                                                         Integer maxResults) {
        final List<ApiDestinationDTO> apiDestinationDTOS = apiDestinationRepository.listApiDestinations(accountId, apiDestinationName, connectionName, nextToken, maxResults);
        PaginationResult<List<ApiDestinationDTO>> result = new PaginationResult();
        int apiDestinationCount = this.getApiDestinationCount(accountId, apiDestinationName, connectionName);
        result.setData(apiDestinationDTOS);
        result.setTotal(apiDestinationCount);
        result.setNextToken(NextTokenUtil.findNextToken(apiDestinationCount, Integer.parseInt(nextToken), maxResults));
        return result;
    }

    private int getApiDestinationCount(String accountId) {
        return apiDestinationRepository.getApiDestinationCount(accountId);
    }

    private int getApiDestinationCount(String accountId, String apiDestinationName, String connectionName) {
        return apiDestinationRepository.getApiDestinationCount(accountId, apiDestinationName, connectionName);
    }
}
