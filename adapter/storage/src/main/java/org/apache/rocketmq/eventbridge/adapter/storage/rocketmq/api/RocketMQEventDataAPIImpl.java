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

package org.apache.rocketmq.eventbridge.adapter.storage.rocketmq.api;

import com.google.common.collect.Maps;
import com.google.gson.Gson;
import java.net.URI;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import org.apache.commons.lang3.StringUtils;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.eventbridge.config.AppConfig;
import org.apache.rocketmq.eventbridge.event.EventBridgeEvent;
import org.apache.rocketmq.eventbridge.exception.EventBridgeException;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import static org.apache.rocketmq.eventbridge.exception.code.EventErrorCode.EventSizeExceed;

@Component
public class RocketMQEventDataAPIImpl implements EventDataOnRocketMQConnectAPI {

    public static final String PROPERTY_ATTRIBUTE_EVENT_ID = "id";
    public static final String PROPERTY_ATTRIBUTE_EVENT_SOURCE = "source";
    public static final String PROPERTY_ATTRIBUTE_EVENT_TYPE = "type";
    public static final String PROPERTY_ATTRIBUTE_EVENT_SUBJECT = "subject";
    public static final String PROPERTY_ATTRIBUTE_EVENT_SPECVERSION = "specversion";
    public static final String PROPERTY_ATTRIBUTE_EVENT_DATACONTENTTYPE = "datacontenttype";
    public static final String PROPERTY_ATTRIBUTE_EVENT_DATASCHEMA = "dataschema";
    public static final String PROPERTY_ATTRIBUTE_EVENT_TIME = "time";
    public static final String PROPERTY_USEREXT_KEY = "USEREXT_KEY";

    @Override
    public Message converter(String accountId, String topicName, EventBridgeEvent eventBridgeEvent) {

        Message rocketMQMsg = new Message();
        rocketMQMsg.setTopic(topicName);
        rocketMQMsg.setKeys(eventBridgeEvent.getId());

        int size = fillEvent(rocketMQMsg, eventBridgeEvent);

        if (size > AppConfig.getGlobalConfig()
            .getEventSizeUpLimit()) {
            throw new EventBridgeException(EventSizeExceed, size, AppConfig.getGlobalConfig()
                .getEventSizeUpLimit());
        }
        return rocketMQMsg;
    }

    public static int fillEvent(Message rocketMQMsg, EventBridgeEvent eventBridgeEvent) {
        int size = 0;
        if (eventBridgeEvent.getData() != null) {
            rocketMQMsg.setBody(eventBridgeEvent.getData());
            size += rocketMQMsg.getBody().length;
        }
        size += fillEventAttributes(rocketMQMsg, eventBridgeEvent);
        size += fillExtension(rocketMQMsg, eventBridgeEvent.getExtensions());
        return size;
    }

    public static int fillEventAttributes(Message rocketMQMsg, EventBridgeEvent eventBridgeEvent) {
        int totalLength = 0;
        totalLength += putIfPresent(PROPERTY_ATTRIBUTE_EVENT_ID, eventBridgeEvent.getId(), rocketMQMsg);
        totalLength += putIfPresent(PROPERTY_ATTRIBUTE_EVENT_SOURCE, eventBridgeEvent.getSource(), rocketMQMsg);
        totalLength += putIfPresent(PROPERTY_ATTRIBUTE_EVENT_TYPE, eventBridgeEvent.getType(), rocketMQMsg);
        totalLength += putIfPresent(PROPERTY_ATTRIBUTE_EVENT_SUBJECT, eventBridgeEvent.getSubject(), rocketMQMsg);
        totalLength += putIfPresent(PROPERTY_ATTRIBUTE_EVENT_SPECVERSION, eventBridgeEvent.getSpecversion(),
            rocketMQMsg);
        totalLength += putIfPresent(PROPERTY_ATTRIBUTE_EVENT_DATACONTENTTYPE, eventBridgeEvent.getDatacontenttype(),
            rocketMQMsg);
        totalLength += putIfPresent(PROPERTY_ATTRIBUTE_EVENT_DATASCHEMA, eventBridgeEvent.getDataschema(), rocketMQMsg);
        totalLength += putIfPresent(PROPERTY_ATTRIBUTE_EVENT_TIME, eventBridgeEvent.getTime(), rocketMQMsg);
        return totalLength;
    }

    private static int putIfPresent(String key, Object value, Message rocketMQMsg) {
        int len = 0;
        if (value instanceof String && StringUtils.isNotEmpty((String) value)) {
            rocketMQMsg.putUserProperty(key, (String) value);
            len = key.length() + ((String) value).length() + 2;
        } else if (value instanceof Number) {
            String str = String.valueOf(value);
            rocketMQMsg.putUserProperty(key, str);
            len = key.length() + str.length() + 2;
        } else if (value instanceof URI) {
            String str = value.toString();
            rocketMQMsg.putUserProperty(key, str);
            len = key.length() + str.length() + 2;
        } else if (value instanceof ZonedDateTime) {
            String str = ((ZonedDateTime) value).format(DateTimeFormatter.ISO_OFFSET_DATE_TIME);
            rocketMQMsg.putUserProperty(key, str);
            len = key.length() + str.length() + 2;
        }
        return len;
    }

    private static int fillExtension(Message rocketMQMsg, Map<String, ?> extensions) {
        AtomicInteger totalLength = new AtomicInteger();
        if (CollectionUtils.isEmpty(extensions)) {
            return totalLength.get();
        }
        Map<String, Object> userExtension = Maps.newHashMap();
        extensions.entrySet()
            .stream()
            .forEach(entry -> {
                if (AppConfig.getGlobalConfig()
                    .getEventExtensionKeys()
                    .contains(entry.getKey())) {
                    totalLength.addAndGet(putIfPresent(entry.getKey(), entry.getValue(), rocketMQMsg));
                } else {
                    userExtension.put(entry.getKey(), entry.getValue());
                }
            });
        totalLength.addAndGet(putIfPresent(PROPERTY_USEREXT_KEY, new Gson().toJson(userExtension), rocketMQMsg));
        return totalLength.get();
    }

    /**
     * 1184866284240688%default_acs.arms_1603954493994
     *
     * @param accountId
     * @param eventBusName
     * @return
     */
    @Override
    public String buildTopicName(String accountId, String eventBusName) {
        return "eventbridge%" + accountId + "%" + eventBusName + "_" + System.currentTimeMillis();
    }
}
