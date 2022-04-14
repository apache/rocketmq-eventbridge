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
package org.apache.rocketmq.eventbridge.adapter.rpc.impl.connect;

import java.util.Map;

import com.google.common.collect.Maps;
import com.google.gson.Gson;
import org.apache.rocketmq.eventbridge.adapter.persistence.data.mybatis.dataobject.EventTopicDO;
import org.apache.rocketmq.eventbridge.adapter.rpc.impl.connect.dto.TransformRequest;
import org.apache.rocketmq.eventbridge.domain.model.Component;
import org.apache.rocketmq.eventbridge.domain.repository.EventDataRepository;
import org.apache.rocketmq.eventbridge.tools.transform.TransformParam;

import static org.apache.rocketmq.eventbridge.config.EventBridgeConstants.ACCOUNT_ID_KEY;
import static org.apache.rocketmq.eventbridge.config.EventBridgeConstants.EVENT_BUS_NAME_KEY;

public class RocketMQConverter {

    //CloudEvent transform
    public static final String CLOUD_EVENT_TRANSFORM_NAME = "cloudEvent";

    //Filter transform
    public static final String FILTER_TRANSFORM_NAME = "filter";
    public static final String FILTER_TRANSFORM_NAME_KEY = "filterPattern";
    public static final String FILTER_TRANSFORM_CLASS
        = "org.apache.rocketmq.connect.transform.eventbridge.EventBridgeFilterTransform";

    //EventBridge transform
    public static final String EB_TRANSFORM_NAME = "transform";
    public static final String EB_TRANSFORM_CLASS
        = "org.apache.rocketmq.connect.transform.eventbridge.EventBridgeTransform";

    public static final String EB_CLOUD_EVENTTRANSFORM_CLASS
        = "org.apache.rocketmq.connect.transform.eventbridge.CloudEventTransform";

    public static final String KEY_CLASS = "class";

    private final EventDataRepository eventDataRepository;

    public RocketMQConverter(EventDataRepository eventDataRepository) {
        this.eventDataRepository = eventDataRepository;
    }

    protected TransformRequest buildEventBridgeTransform(Map<String, TransformParam> targetTransform) {
        Map<String, Object> config = Maps.newHashMap();
        targetTransform.entrySet()
            .forEach(entry -> {
                config.put(entry.getKey(), new Gson().toJson(entry.getValue()));
            });
        config.put(KEY_CLASS, EB_TRANSFORM_CLASS);
        return new TransformRequest(EB_TRANSFORM_NAME, config);
    }

    protected TransformRequest buildEventBridgeFilterTransform(String filterPattern) {
        Map<String, Object> config = Maps.newHashMap();
        config.put(FILTER_TRANSFORM_NAME_KEY, filterPattern);
        config.put(KEY_CLASS, FILTER_TRANSFORM_CLASS);
        return new TransformRequest(FILTER_TRANSFORM_NAME, config);
    }

    protected TransformRequest buildCloudEventTransform(Map<String, Object> transformPattern) {
        transformPattern.put(KEY_CLASS, EB_CLOUD_EVENTTRANSFORM_CLASS);
        return new TransformRequest(CLOUD_EVENT_TRANSFORM_NAME, transformPattern);
    }

    protected Map<String, Object> parseConnectorConfig(Component component) {
        return component.getConfig();
    }

    protected String parseConnectorClass(Component component) {
        return (String)component.getConfig()
            .get(KEY_CLASS);
    }

    protected String parseTopicName(Component source) {
        String eventBusName = (String)(source.getConfig()
            .get(EVENT_BUS_NAME_KEY));
        String accountId = (String)(source.getConfig()
            .get(ACCOUNT_ID_KEY));
        String persistentContext = eventDataRepository.getEventBusPersistentContext(accountId, eventBusName);
        EventTopicDO eventTopicDO = new Gson().fromJson(persistentContext, EventTopicDO.class);
        return eventTopicDO.getName();
    }

}
