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

package org.apache.rocketmq.eventbridge.adapter.rpc.impl;

import io.cloudevents.core.v1.CloudEventBuilder;
import org.apache.rocketmq.eventbridge.config.AppConfig;
import org.apache.rocketmq.eventbridge.domain.model.source.EventSource;
import org.apache.rocketmq.eventbridge.domain.rpc.HttpEventAPI;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @Author changfeng
 * @Date 2022/4/27 5:21 下午
 */
@Service
public class HttpEventAPIImpl implements HttpEventAPI {

    public static final String EVENTSOURCE_PATTERN = "eventbridge:%s:%s:eventbus/%s/eventsource/%s";



    @Override
    public CloudEventBuilder addExtensions(ServerHttpRequest request,
                                           String regionId,
                                           String accountId,
                                           Map<String, String> headers,
                                           EventSource eventSource, CloudEventBuilder cloudEventBuilder) {
        CloudEventBuilder newBuilder = cloudEventBuilder.newBuilder();

        newBuilder.withExtension(AppConfig.getGlobalConfig().getGetEventBusExtensionKey(),
                eventSource.getEventBusName());

        return newBuilder;
    }

    @Override
    public String generateSubject(String region, String accountId, String eventBusName, String eventSourceFullName) {
        return String.format(EVENTSOURCE_PATTERN, region, accountId, eventBusName,
                eventSourceFullName);
    }
}
