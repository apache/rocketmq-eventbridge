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
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package org.apache.rocketmq.eventbridge.demo;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.eventbridge.domain.common.exception.EventBridgeErrorCode;
import org.apache.rocketmq.eventbridge.domain.model.bus.EventBusService;
import org.apache.rocketmq.eventbridge.domain.model.rule.EventRuleService;
import org.apache.rocketmq.eventbridge.domain.model.target.EventTarget;
import org.apache.rocketmq.eventbridge.domain.model.target.EventTargetService;
import org.apache.rocketmq.eventbridge.exception.EventBridgeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@DependsOn("flyway")
public class DefaultDemo {

    @Autowired
    EventBusService eventBusService;

    @Autowired
    EventRuleService eventRuleService;

    @Autowired
    EventTargetService eventTargetService;

    private static final String DEFAULT_ACCOUNT_ID = "default";

    private static final String DEFAULT_EVENT_TOPIC_NAME = "demo-bus";

    private static final String DEFAULT_EVENT_RULE_NAME = "demo-rule";

    private static final String DEFAULT_EVENT_TARGET_NAME = "demo-target";

    private static final String DEFAULT_EVENT_TARGET_CLASS = "file";

    @PostConstruct
    public void initDemo() {
        log.info("init demo");
        initEventBus();
        initEventRule();
        intEventTarget();

    }

    private void initEventBus() {
        try {
            eventBusService.getEventBus(DEFAULT_ACCOUNT_ID, DEFAULT_EVENT_TOPIC_NAME);
        } catch (EventBridgeException e) {
            if (EventBridgeErrorCode.EventBusNotExist.getCode().equals(e.getCode())) {
                eventBusService.createEventBus(DEFAULT_ACCOUNT_ID, DEFAULT_EVENT_TOPIC_NAME, "A demo bus.");
                log.info("Create demo eventbus:{}", DEFAULT_EVENT_TOPIC_NAME);
            }
        }

    }

    private void initEventRule() {
        try {
            eventRuleService.getEventRule(DEFAULT_ACCOUNT_ID, DEFAULT_EVENT_TOPIC_NAME, DEFAULT_EVENT_RULE_NAME);
        } catch (EventBridgeException e) {
            if (EventBridgeErrorCode.EventRuleNotExist.getCode().equals(e.getCode())) {
                eventRuleService.createEventRule(DEFAULT_ACCOUNT_ID, DEFAULT_EVENT_TOPIC_NAME, DEFAULT_EVENT_RULE_NAME, "A demo rule.", "{}");
                log.info("Create demo event rule:{}", DEFAULT_EVENT_RULE_NAME);
            }
        }
    }

    private void intEventTarget() {
        List<EventTarget> eventTargets = eventTargetService.listTargets(DEFAULT_ACCOUNT_ID, DEFAULT_EVENT_TOPIC_NAME, DEFAULT_EVENT_RULE_NAME);
        if (eventTargets == null || eventTargets.isEmpty()) {
            List<EventTarget> eventTargetList = Lists.newArrayList();
            Map<String, Object> config = Maps.newHashMap();
            config.put("fileName", System.getProperty("user.home") + "/demo");
            config.put("line", "{\"form\":\"JSONPATH\",\"value\":\"$.data\"}");
            EventTarget eventTarget = EventTarget.builder().name(DEFAULT_EVENT_TARGET_NAME).className(DEFAULT_EVENT_TARGET_CLASS).config(config).build();
            eventTargetList.add(eventTarget);
            eventTargetService.createTargets(DEFAULT_ACCOUNT_ID, DEFAULT_EVENT_TOPIC_NAME, DEFAULT_EVENT_RULE_NAME, eventTargetList);
        }
    }

}