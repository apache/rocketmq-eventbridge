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

package org.apache.rocketmq.eventbridge.domain.model.classes;

import java.util.Map;

import com.google.common.collect.Maps;
import com.google.gson.Gson;
import org.apache.commons.text.StringSubstitutor;
import org.apache.rocketmq.eventbridge.domain.model.Component;
import org.apache.rocketmq.eventbridge.domain.repository.EventTargetClassRepository;
import org.apache.rocketmq.eventbridge.exception.EventBridgeException;
import org.apache.rocketmq.eventbridge.tools.transform.TransformParam;
import org.springframework.stereotype.Service;

import static org.apache.rocketmq.eventbridge.domain.common.EventBridgeConstants.SYSTEM_ENVIRONMENT_ACCOUNT_ID;
import static org.apache.rocketmq.eventbridge.domain.common.exception.EventBridgeErrorCode.EventTargetClassNotExist;
import static org.apache.rocketmq.eventbridge.domain.common.exception.EventBridgeErrorCode.EventTargetIneffectiveAttribute;
import static org.apache.rocketmq.eventbridge.domain.common.exception.EventBridgeErrorCode.EventTargetMissingAttribute;

@Service
public class EventTargetClassService {

    private final EventTargetClassRepository eventTargetClassRepository;

    public EventTargetClassService(EventTargetClassRepository eventTargetClassRepository) {
        this.eventTargetClassRepository = eventTargetClassRepository;
    }

    public EventTargetClass getClassByName(String name) {
        EventTargetClass eventTargetClass = eventTargetClassRepository.getEventTargetClass(name);
        if (eventTargetClass == null) {
            throw new EventBridgeException(EventTargetClassNotExist, name);
        }
        return eventTargetClass;
    }

    public EventTargetClass checkEventSourceAPIParams(String name, Map<String, Object> inputConfig) {
        EventTargetClass eventTargetClass = this.getClassByName(name);
        for (Map.Entry<String, APIAttribute> entry : eventTargetClass.getApiParams()
            .entrySet()) {
            if (!inputConfig.containsKey(entry.getKey()) && entry.getValue()
                .isRequired() && entry.getValue()
                .getDefaultValue() == null) {
                throw new EventBridgeException(EventTargetMissingAttribute, entry.getKey(), entry.getValue()
                    .getDescription());
            }
        }
        for (Map.Entry<String, Object> entry : inputConfig.entrySet()) {
            if (!eventTargetClass.getApiParams()
                .containsKey(entry.getKey())) {
                throw new EventBridgeException(EventTargetIneffectiveAttribute, entry.getKey(), String.join(",",
                    eventTargetClass.getApiParams()
                        .keySet()));
            }
        }
        return eventTargetClass;
    }

    public Component renderConfig(String accountId, String name, Map<String, Object> inputConfig) {
        EventTargetClass eventTargetClass = this.checkEventSourceAPIParams(name, inputConfig);
        Map<String, Object> environment = buildEnvironment(accountId, inputConfig, eventTargetClass.getApiParams());
        StringSubstitutor sub = new StringSubstitutor(environment);
        Map<String, Object> result = Maps.newHashMap();
        for (Map.Entry<String, Object> entry : eventTargetClass.getRequiredParams()
            .entrySet()) {
            String key = entry.getKey();
            String value = sub.replace(entry.getValue());
            result.put(key, value);
        }
        return new Component(name, result);
    }

    public Map<String, TransformParam> renderTargetTransform(String accountId, String className,
        Map<String, Object> inputConfig) {
        EventTargetClass eventTargetClass = this.getClassByName(className);
        Map<String, Object> environment = buildEnvironment(accountId, inputConfig, eventTargetClass.getApiParams());
        StringSubstitutor sub = new StringSubstitutor(environment);
        Map<String, TransformParam> transformParamMap = Maps.newHashMap();
        eventTargetClass.getTargetTransform()
            .entrySet()
            .forEach(entry -> {
                String value = sub.replace(entry.getValue());
                transformParamMap.put(entry.getKey(), new Gson().fromJson(value, TransformParam.class));
            });
        return transformParamMap;
    }

    private Map<String, Object> buildEnvironment(String accountId, Map<String, Object> inputConfig,
        Map<String, APIAttribute> apiParams) {
        Map<String, Object> environment = Maps.newHashMap();
        for (Map.Entry<String, APIAttribute> entry : apiParams.entrySet()) {
            String key = entry.getKey();
            Object value = inputConfig.get(key) != null ? inputConfig.get(key) : entry.getValue()
                .getDefaultValue();
            environment.put(entry.getKey(), value);
        }
        environment.put(SYSTEM_ENVIRONMENT_ACCOUNT_ID, accountId);
        return environment;
    }
}
