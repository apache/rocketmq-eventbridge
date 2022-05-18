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
import org.apache.rocketmq.eventbridge.domain.common.exception.EventBridgeErrorCode;
import org.apache.rocketmq.eventbridge.domain.model.AbstractResourceService;
import org.apache.rocketmq.eventbridge.domain.model.PaginationResult;
import org.apache.rocketmq.eventbridge.domain.repository.ApiDestinationRepository;
import org.apache.rocketmq.eventbridge.exception.EventBridgeException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.apache.rocketmq.eventbridge.domain.common.exception.EventBridgeErrorCode.ApiDestinationCountExceedLimit;

@Slf4j
@Service
public class ApiDestinationService extends AbstractResourceService {

    private final ApiDestinationRepository apiDestinationRepository;

    public ApiDestinationService(ApiDestinationRepository apiDestinationRepository) {
        this.apiDestinationRepository = apiDestinationRepository;
    }

    @Value("${api.destination.limit}")
    private String apiDestinationLimit;

    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
    public String createApiDestination(ApiDestination eventApiDestination) {
        try {
            if (checkApiDestination(eventApiDestination.getAccountId(), eventApiDestination.getName()) != null) {
                throw new EventBridgeException(EventBridgeErrorCode.ApiDestinationAlreadyExist, eventApiDestination.getName());
            }
            super.checkQuota(this.getApiDestinationCount(eventApiDestination.getAccountId(), eventApiDestination.getName()), Integer.parseInt(apiDestinationLimit),
                    ApiDestinationCountExceedLimit);
            final Boolean apiDestination = apiDestinationRepository.createApiDestination(eventApiDestination);
            if (apiDestination) {
                return eventApiDestination.getName();
            }
            return null;
        } catch (Exception e) {
            log.error("ApiDestinationService | createApiDestination | error", e);
            throw new EventBridgeException(e);
        }
    }

    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
    public Boolean updateApiDestination(ApiDestination apiDestination) {
        try {
            if (checkApiDestination(apiDestination.getAccountId(), apiDestination.getName()) == null) {
                throw new EventBridgeException(EventBridgeErrorCode.ApiDestinationNotExist, apiDestination.getName());
            }
            return apiDestinationRepository.updateApiDestination(apiDestination);
        } catch (Exception e) {
            log.error("ApiDestinationService | updateApiDestination | error", e);
            throw new EventBridgeException(e);
        }
    }

    public ApiDestination getApiDestination(String accountId, String apiDestinationName) {
        try {
            if (checkApiDestination(accountId, accountId) == null) {
                throw new EventBridgeException(EventBridgeErrorCode.ApiDestinationNotExist, accountId);
            }
            return apiDestinationRepository.getApiDestination(accountId, apiDestinationName);
        } catch (Exception e) {
            log.error("ApiDestinationService | getApiDestination | error", e);
            throw new EventBridgeException(e);
        }
    }

    public ApiDestination checkApiDestination(String accountId, String apiDestinationName) {
        return apiDestinationRepository.getApiDestination(accountId, apiDestinationName);
    }

    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
    public Boolean deleteApiDestination(String accountId, String apiDestinationName) {
        try {
            if (checkApiDestination(accountId, accountId) == null) {
                throw new EventBridgeException(EventBridgeErrorCode.ApiDestinationNotExist, accountId);
            }
            return apiDestinationRepository.deleteApiDestination(accountId, apiDestinationName);
        } catch (Exception e) {
            log.error("ApiDestinationService | deleteApiDestination | error", e);
            throw new EventBridgeException(e);
        }
    }

    public PaginationResult<List<ApiDestination>> listApiDestinations(String accountId, String apiDestinationName, String nextToken,
                                                                      int maxResults) {
        try {
            final List<ApiDestination> apiDestinations = apiDestinationRepository.listApiDestinations(accountId, apiDestinationName, nextToken, maxResults);
            PaginationResult<List<ApiDestination>> result = new PaginationResult();
            result.setData(apiDestinations);
            result.setTotal(this.getApiDestinationCount(accountId, apiDestinationName));
            result.setNextToken(String.valueOf(Integer.parseInt(nextToken) + maxResults));
            return result;
        } catch (Exception e) {
            log.error("ApiDestinationService | listApiDestinations | error", e);
            throw new EventBridgeException(e);
        }
    }

    private int getApiDestinationCount(String accountId, String apiDestinationName) {
        return apiDestinationRepository.getApiDestinationCount(accountId, apiDestinationName);
    }
}
