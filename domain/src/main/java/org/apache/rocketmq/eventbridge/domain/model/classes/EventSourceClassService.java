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

import com.google.common.collect.Maps;
import com.google.gson.Gson;
import java.util.Map;
import org.apache.commons.text.StringSubstitutor;
import org.apache.rocketmq.eventbridge.domain.model.Component;
import org.apache.rocketmq.eventbridge.domain.repository.EventSourceClassRepository;
import org.apache.rocketmq.eventbridge.exception.EventBridgeException;
import org.apache.rocketmq.eventbridge.tools.transform.TransformEnum;
import org.apache.rocketmq.eventbridge.tools.transform.TransformParam;
import org.springframework.stereotype.Service;

import static org.apache.rocketmq.eventbridge.domain.common.EventBridgeConstants.SYSTEM_ENVIRONMENT_ACCOUNT_ID;
import static org.apache.rocketmq.eventbridge.domain.common.exception.EventBridgeErrorCode.EventSourceClassNotExist;
import static org.apache.rocketmq.eventbridge.domain.common.exception.EventBridgeErrorCode.EventSourceIneffectiveAttribute;
import static org.apache.rocketmq.eventbridge.domain.common.exception.EventBridgeErrorCode.EventSourceMissingAttribute;

@Service
public class EventSourceClassService {

    private final EventSourceClassRepository eventSourceClassRepository;

    public EventSourceClassService(EventSourceClassRepository eventSourceClassRepository) {
        this.eventSourceClassRepository = eventSourceClassRepository;
    }

    public EventSourceClass getClassByName(String name) {
        EventSourceClass eventSourceClass = eventSourceClassRepository.getEventSourceClass(name);
        if (eventSourceClass == null) {
            throw new EventBridgeException(EventSourceClassNotExist, name);
        }
        return eventSourceClass;
    }

    public boolean isExist(String name) {
        EventSourceClass eventSourceClass = eventSourceClassRepository.getEventSourceClass(name);
        if (eventSourceClass == null) {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    public Map<String, Object> renderCloudEventTransform(String accountId, String name, Map<String, Object> inputConfig,
        String eventSourceName) {
        EventSourceClass eventSourceClass = this.checkEventSourceAPIParams(name, inputConfig);
        if (eventSourceClass == null) {
            throw new EventBridgeException(EventSourceClassNotExist, name);
        }
        Map<String, Object> transform = eventSourceClass.getTransform();
        Map<String, Object> environment = buildEnvironment(accountId, inputConfig, eventSourceClass.getApiParams());
        StringSubstitutor sub = new StringSubstitutor(environment);
        transform.entrySet()
            .forEach(entry -> {
                String value = sub.replace(entry.getValue());
                entry.setValue(value);
            });
        transform.put("source", new Gson().toJson(new TransformParam(TransformEnum.CONSTANT, eventSourceName)));

        return transform;
    }

    public EventSourceClass checkEventSourceAPIParams(String name, Map<String, Object> inputConfig) {
        EventSourceClass eventSourceClass = this.getClassByName(name);
        for (Map.Entry<String, APIAttribute> entry : eventSourceClass.getApiParams()
            .entrySet()) {
            if (!inputConfig.containsKey(entry.getKey()) && entry.getValue()
                .isRequired() && entry.getValue()
                .getDefaultValue() == null) {
                throw new EventBridgeException(EventSourceMissingAttribute, entry.getKey(), entry.getValue()
                    .getDescription());
            }
        }
        for (Map.Entry<String, Object> entry : inputConfig.entrySet()) {
            if (!eventSourceClass.getApiParams()
                .containsKey(entry.getKey())) {
                throw new EventBridgeException(EventSourceIneffectiveAttribute, entry.getKey(), String.join(",",
                    eventSourceClass.getApiParams()
                        .keySet()));
            }
        }
        return eventSourceClass;
    }

    public Component renderConfig(String accountId, String name, Map<String, Object> inputConfig) {
        EventSourceClass eventSourceClass = this.checkEventSourceAPIParams(name, inputConfig);
        Map<String, Object> environment = buildEnvironment(accountId, inputConfig, eventSourceClass.getApiParams());
        StringSubstitutor sub = new StringSubstitutor(environment);
        Map<String, Object> result = Maps.newHashMap();
        for (Map.Entry<String, Object> entry : eventSourceClass.getRequiredParams()
            .entrySet()) {
            String key = entry.getKey();
            Object value = sub.replace(entry.getValue());
            result.put(key, value);
        }
        return new Component(name, result);
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
