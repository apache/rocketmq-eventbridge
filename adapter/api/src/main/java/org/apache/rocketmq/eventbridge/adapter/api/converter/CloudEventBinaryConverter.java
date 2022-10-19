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

import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import io.cloudevents.CloudEvent;
import io.cloudevents.SpecVersion;
import io.cloudevents.http.restful.ws.impl.RestfulWSMessageFactory;
import java.util.List;
import java.util.Map;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedHashMap;
import org.springframework.stereotype.Service;

import static org.apache.http.protocol.HTTP.CONTENT_TYPE;

@Service
public class CloudEventBinaryConverter implements EventConverter {

    private static final String HTTP_BINARY_PROTOCOL_BINDING = "application/json";

    @Override
    public boolean hit(Map<String, String> headers) {
        String contentType = headers.get(CONTENT_TYPE);
        if (Strings.isNullOrEmpty(contentType) || !contentType.startsWith(HTTP_BINARY_PROTOCOL_BINDING)) {
            return false;
        }
        String specversion = headers.get("ce-specversion");
        if (Strings.isNullOrEmpty(specversion)) {
            return false;
        }
        SpecVersion specVersion = null;
        try {
            specVersion = SpecVersion.parse(specversion);
        } catch (Throwable e) {
            // do nothing;
        }
        return specVersion != null;
    }

    @Override
    public List<CloudEvent> toEventBridgeEvent(Map<String, String> headers, byte[] body) {
        MultivaluedHashMap<String, String> headerMap = new MultivaluedHashMap();
        headers.entrySet()
            .stream()
            .forEach(entry -> headerMap.add(entry.getKey(), entry.getValue()));
        String mediaType = headers.get(CONTENT_TYPE);
        CloudEvent cloudEvent = RestfulWSMessageFactory.create(MediaType.valueOf(mediaType), headerMap, body)
            .toEvent();
        return Lists.newArrayList(cloudEvent);
    }
}

