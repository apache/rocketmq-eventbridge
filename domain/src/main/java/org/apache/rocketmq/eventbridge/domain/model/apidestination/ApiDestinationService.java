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

import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.eventbridge.domain.common.EventBridgeConstants;
import org.apache.rocketmq.eventbridge.domain.common.exception.EventBridgeErrorCode;
import org.apache.rocketmq.eventbridge.domain.model.AbstractResourceService;
import org.apache.rocketmq.eventbridge.domain.model.PaginationResult;
import org.apache.rocketmq.eventbridge.domain.repository.ApiDestinationRepository;
import org.apache.rocketmq.eventbridge.exception.EventBridgeException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import static org.apache.rocketmq.eventbridge.domain.common.exception.EventBridgeErrorCode.ApiDestinationCountExceedLimit;

@Slf4j
@Service
public class ApiDestinationService extends AbstractResourceService {

    private final ApiDestinationRepository apiDestinationRepository;

    public ApiDestinationService(ApiDestinationRepository apiDestinationRepository) {
        this.apiDestinationRepository = apiDestinationRepository;
    }

    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
    public String createApiDestination(ApiDestinationDTO eventApiDestinationDTO) {
        try {
            if (checkApiDestination(eventApiDestinationDTO.getAccountId(), eventApiDestinationDTO.getName()) != null) {
                throw new EventBridgeException(EventBridgeErrorCode.ApiDestinationAlreadyExist, eventApiDestinationDTO.getName());
            }
            super.checkQuota(this.getApiDestinationCount(eventApiDestinationDTO.getAccountId()), EventBridgeConstants.API_DESTINATION_COUNT_LIMIT,
                ApiDestinationCountExceedLimit);
            final Boolean apiDestination = apiDestinationRepository.createApiDestination(eventApiDestinationDTO);
            if (apiDestination) {
                return eventApiDestinationDTO.getName();
            }
            return null;
        } catch (Exception e) {
            log.error("ApiDestinationService | createApiDestination | error", e);
            throw new EventBridgeException(e);
        }
    }

    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
    public Boolean updateApiDestination(ApiDestinationDTO apiDestinationDTO) {
        try {
            if (checkApiDestination(apiDestinationDTO.getAccountId(), apiDestinationDTO.getName()) == null) {
                throw new EventBridgeException(EventBridgeErrorCode.ApiDestinationNotExist, apiDestinationDTO.getName());
            }
            return apiDestinationRepository.updateApiDestination(apiDestinationDTO);
        } catch (Exception e) {
            log.error("ApiDestinationService | updateApiDestination | error", e);
            throw new EventBridgeException(e);
        }
    }

    public ApiDestinationDTO getApiDestination(String accountId, String apiDestinationName) {
        try {
            if (checkApiDestination(accountId, apiDestinationName) == null) {
                throw new EventBridgeException(EventBridgeErrorCode.ApiDestinationNotExist, apiDestinationName);
            }
            return apiDestinationRepository.getApiDestination(accountId, apiDestinationName);
        } catch (Exception e) {
            log.error("ApiDestinationService | getApiDestination | error", e);
            throw new EventBridgeException(e);
        }
    }

    public ApiDestinationDTO checkApiDestination(String accountId, String apiDestinationName) {
        return apiDestinationRepository.getApiDestination(accountId, apiDestinationName);
    }

    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
    public Boolean deleteApiDestination(String accountId, String apiDestinationName) {
        try {
            if (checkApiDestination(accountId, apiDestinationName) == null) {
                throw new EventBridgeException(EventBridgeErrorCode.ApiDestinationNotExist, apiDestinationName);
            }
            return apiDestinationRepository.deleteApiDestination(accountId, apiDestinationName);
        } catch (Exception e) {
            log.error("ApiDestinationService | deleteApiDestination | error", e);
            throw new EventBridgeException(e);
        }
    }

    public PaginationResult<List<ApiDestinationDTO>> listApiDestinations(String accountId, String apiDestinationName,
        String nextToken,
        int maxResults) {
        try {
            final List<ApiDestinationDTO> apiDestinationDTOS = apiDestinationRepository.listApiDestinations(accountId, apiDestinationName, nextToken, maxResults);
            PaginationResult<List<ApiDestinationDTO>> result = new PaginationResult();
            result.setData(apiDestinationDTOS);
            result.setTotal(this.getApiDestinationCount(accountId));
            result.setNextToken(String.valueOf(Integer.parseInt(nextToken) + maxResults));
            return result;
        } catch (Exception e) {
            log.error("ApiDestinationService | listApiDestinations | error", e);
            throw new EventBridgeException(e);
        }
    }

    private int getApiDestinationCount(String accountId) {
        return apiDestinationRepository.getApiDestinationCount(accountId);
    }
}
