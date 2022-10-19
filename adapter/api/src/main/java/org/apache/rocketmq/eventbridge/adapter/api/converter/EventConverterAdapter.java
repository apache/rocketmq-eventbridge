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
package org.apache.rocketmq.eventbridge.adapter.api.converter;

import com.google.common.collect.Lists;
import com.google.gson.Gson;
import io.cloudevents.CloudEvent;
import io.netty.handler.codec.http.HttpHeaders;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import org.apache.rocketmq.eventbridge.exception.EventBridgeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static org.apache.rocketmq.eventbridge.exception.code.EventErrorCode.EventHTTPProtocolBindingInvalid;

@Service
public class EventConverterAdapter {

    @Autowired
    private CloudEventBatchedConverter cloudEventBatchedConverter;
    @Autowired
    private CloudEventBinaryConverter cloudEventBinaryConverter;
    @Autowired
    private CloudEventStructuredConverter cloudEventStructuredConverter;

    private List<EventConverter> eventConverterList = Lists.newArrayListWithCapacity(3);

    @PostConstruct
    public void init() {
        eventConverterList.add(cloudEventBatchedConverter);
        eventConverterList.add(cloudEventBinaryConverter);
        eventConverterList.add(cloudEventStructuredConverter);
    }

    /**
     * The entry function:extract the event form body and {@link HttpHeaders}
     *
     * @param headers
     * @param body
     * @return
     * @throws Throwable
     */

    public List<CloudEvent> toEventsRequest(Map<String, String> headers, byte[] body) {
        return getEventConverter(headers).toEventBridgeEvent(headers, body);
    }

    /**
     * Find the {@link EventConverter} to handler request, the default strategy is "First fit"
     *
     * @param headers
     * @return
     */
    private EventConverter getEventConverter(Map<String, String> headers) {
        EventConverter eventConverter = eventConverterList.stream()
            .filter(adapter -> adapter.hit(headers))
            .findFirst()
            .get();
        if (eventConverter == null) {
            throw new EventBridgeException(EventHTTPProtocolBindingInvalid, new Gson().toJson(headers));
        }
        return eventConverter;
    }

    public List<EventConverter> getEventConverterList() {
        return eventConverterList;
    }
}
