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
import org.apache.rocketmq.eventbridge.domain.model.source.EventSource;
import org.apache.rocketmq.eventbridge.domain.rpc.HttpEventAPI;
import org.springframework.http.HttpHeaders;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @Author changfeng
 * @Date 2022/4/27 5:21 下午
 */
@Service
public class HttpEventAPIImpl implements HttpEventAPI {
    private static final String HEADER_X_REAL_IP = "x-real-ip";
    public static final String HEADER_EVENTBRIDGE_DATE = "x-eventbridge-date";

    public static final String EXTENSION_REGIONID = "regionid";
    public static final String EXTENSION_ACCOUNTID = "accountid";
    public static final String EXTENSION_PUBLISHADDR = "publishaddr";
    public static final String EXTENSION_PUBLISHTIME = "publishtime";
    public static final String EXTENSION_EVENTBUS = "eventbusname";

    public static final String EVENTSOURCE_PATTERN = "eventbridge:%s:%s:eventbus/%s/eventsource/%s";



    @Override
    public CloudEventBuilder addExtensions(ServerHttpRequest request,
                                           String regionId,
                                           String accountId,
                                           Map<String, String> headers,
                                           EventSource eventSource, CloudEventBuilder cloudEventBuilder) {
        CloudEventBuilder newBuilder = cloudEventBuilder.newBuilder();
        String date = null;
        if (headers.containsKey(HEADER_EVENTBRIDGE_DATE)) {
            date = headers.get(HEADER_EVENTBRIDGE_DATE);
        } else if (headers.containsKey(HttpHeaders.DATE)) {
            date = headers.get(HttpHeaders.DATE);
        }
        String sourceAddr = request.getRemoteAddress().getAddress().toString();
        if (headers.containsKey(HEADER_X_REAL_IP)) {
            sourceAddr = headers.get(HEADER_X_REAL_IP);
        }
        newBuilder.withExtension(EXTENSION_REGIONID, regionId);
        newBuilder.withExtension(EXTENSION_ACCOUNTID, accountId);
        newBuilder.withExtension(EXTENSION_EVENTBUS, eventSource.getEventBusName());
        newBuilder.withExtension(EXTENSION_PUBLISHADDR, sourceAddr);
        newBuilder.withExtension(EXTENSION_PUBLISHTIME, date);
        return newBuilder;
    }

    @Override
    public String generateSubject(String region, String accountId, String eventBusName, String eventSourceFullName) {
        return String.format(EVENTSOURCE_PATTERN, region, accountId, eventBusName,
                eventSourceFullName);
    }
}
