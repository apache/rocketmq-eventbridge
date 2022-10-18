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
package org.apache.rocketmq.eventbridge.domain.model.rule;

import java.util.List;
import org.apache.rocketmq.eventbridge.domain.common.enums.EventRuleStatusEnum;
import org.apache.rocketmq.eventbridge.domain.common.exception.EventBridgeErrorCode;
import org.apache.rocketmq.eventbridge.domain.model.AbstractResourceService;
import org.apache.rocketmq.eventbridge.domain.model.PaginationResult;
import org.apache.rocketmq.eventbridge.domain.model.bus.EventBusService;
import org.apache.rocketmq.eventbridge.domain.repository.EventRuleRepository;
import org.apache.rocketmq.eventbridge.exception.EventBridgeException;
import org.apache.rocketmq.eventbridge.tools.pattern.PatternEvaluatorBuilder;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static org.apache.rocketmq.eventbridge.domain.common.EventBridgeConstants.EVENT_RULE_COUNT_LIMIT;
import static org.apache.rocketmq.eventbridge.domain.common.EventBridgeConstants.EVENT_RULE_NAME_MAX_LENGTH;
import static org.apache.rocketmq.eventbridge.domain.common.EventBridgeConstants.EVENT_RULE_NAME_MIN_LENGTH;
import static org.apache.rocketmq.eventbridge.domain.common.EventBridgeConstants.RESERVED_EVENT_RULE_PREFIX;
import static org.apache.rocketmq.eventbridge.domain.common.EventBridgeConstants.RESOURCE_NAME_PATTERN;
import static org.apache.rocketmq.eventbridge.domain.common.exception.EventBridgeErrorCode.EventRuleAlreadyExist;
import static org.apache.rocketmq.eventbridge.domain.common.exception.EventBridgeErrorCode.EventRuleCountExceedLimit;
import static org.apache.rocketmq.eventbridge.domain.common.exception.EventBridgeErrorCode.EventRuleNameInvalid;
import static org.apache.rocketmq.eventbridge.domain.common.exception.EventBridgeErrorCode.EventRuleNotExist;

@Service
public class EventRuleService extends AbstractResourceService {

    protected final EventBusService eventBusService;
    protected final EventRuleRepository eventRuleRepository;

    public EventRuleService(EventBusService eventBusService, EventRuleRepository eventRuleRepository) {
        this.eventBusService = eventBusService;
        this.eventRuleRepository = eventRuleRepository;
    }

    @Transactional
    public boolean createEventRule(String accountId, String eventBusName, String eventRuleName, String description,
        String filterPattern) {
        this.eventBusService.checkExist(accountId, eventBusName);
        PatternEvaluatorBuilder.build(filterPattern);
        super.checkNameValidate(eventRuleName, RESOURCE_NAME_PATTERN, EVENT_RULE_NAME_MIN_LENGTH,
            EVENT_RULE_NAME_MAX_LENGTH, null, RESERVED_EVENT_RULE_PREFIX, EventRuleNameInvalid);
        super.checkQuota(this.getEventRulesCount(accountId, eventBusName), EVENT_RULE_COUNT_LIMIT,
            EventRuleCountExceedLimit);

        try {
            return eventRuleRepository.createEventRule(accountId, eventBusName, eventRuleName, description,
                filterPattern, EventRuleStatusEnum.ENABLE);
        } catch (DuplicateKeyException e) {
            throw new EventBridgeException(EventRuleAlreadyExist, eventRuleName, eventBusName);
        }
    }

    @Transactional
    public boolean deleteEventRule(String accountId, String eventBusName, String eventRuleName) {
        this.checkExist(accountId, eventBusName, eventRuleName);
        return eventRuleRepository.deleteEventRule(accountId, eventBusName, eventRuleName);
    }

    public EventRule getEventRule(String accountId, String eventBusName, String eventRuleName) {
        this.checkExist(accountId, eventBusName, eventRuleName);
        EventRule eventRule = eventRuleRepository.getEventRule(accountId, eventBusName, eventRuleName);
        if (eventRule == null) {
            throw new EventBridgeException(EventBridgeErrorCode.EventRuleNotExist, eventRuleName, eventBusName);
        }
        return eventRule;
    }

    @Transactional
    public boolean updateEventRule(String accountId, String eventBusName, String eventRuleName, String description,
        String filterPattern) {
        this.checkExist(accountId, eventBusName, eventRuleName);
        PatternEvaluatorBuilder.build(filterPattern);
        return eventRuleRepository.updateEventRule(accountId, eventBusName, eventRuleName, description, filterPattern);
    }

    public int getEventRulesCount(String accountId, String eventBusName) {
        return eventRuleRepository.getEventRulesCount(accountId, eventBusName);
    }

    public PaginationResult<List<EventRule>> listEventRules(String accountId, String eventBusName, String nextToken,
        int maxResults) {
        eventBusService.checkExist(accountId, eventBusName);
        List<EventRule> eventRules = eventRuleRepository.listEventRules(accountId, eventBusName, nextToken,
            maxResults);
        PaginationResult<List<EventRule>> result = new PaginationResult();
        result.setData(eventRules);
        result.setTotal(this.getEventRulesCount(accountId, eventBusName));
        result.setNextToken(String.valueOf(Integer.parseInt(nextToken) + maxResults));
        return result;
    }

    @Transactional
    public boolean disableEventRule(String accountId, String eventBusName, String eventRuleName) {
        eventBusService.checkExist(accountId, eventBusName);
        return eventRuleRepository.updateEventRuleStatus(accountId, eventBusName, eventRuleName,
            EventRuleStatusEnum.DISABLE);
    }

    @Transactional
    public boolean enableEventRule(String accountId, String eventBusName, String eventRuleName) {
        eventBusService.checkExist(accountId, eventBusName);
        return eventRuleRepository.updateEventRuleStatus(accountId, eventBusName, eventRuleName,
            EventRuleStatusEnum.ENABLE);
    }

    public void checkExist(String accountId, String eventBusName, String eventRuleName) {
        this.eventBusService.checkExist(accountId, eventBusName);
        if (eventRuleRepository.getEventRule(accountId, eventBusName, eventRuleName) == null) {
            throw new EventBridgeException(EventRuleNotExist, eventRuleName, eventBusName);
        }
    }

}