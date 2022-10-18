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

import com.google.common.collect.Maps;
import com.google.gson.Gson;
import io.cloudevents.CloudEvent;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import static org.apache.http.protocol.HTTP.CONTENT_TYPE;

@RunWith(MockitoJUnitRunner.class)
public class EventConverterAdapterTest {
    @InjectMocks
    private EventConverterAdapter eventConverterAdapter;

    @Before
    public void before() {
        eventConverterAdapter.getEventConverterList()
            .add(new CloudEventBatchedConverter());
        eventConverterAdapter.getEventConverterList()
            .add(new CloudEventBinaryConverter());
        eventConverterAdapter.getEventConverterList()
            .add(new CloudEventStructuredConverter());
    }

    @Test
    public void toEventsRequest_Binary() {
        Map<String, String> headers = Maps.newHashMap();
        headers.put(CONTENT_TYPE, "application/json");
        headers.put("ce-id", UUID.randomUUID()
            .toString());
        headers.put("ce-source", "demo-source");
        headers.put("ce-type", URI.create("demo:type")
            .toString());
        headers.put("ce-specversion", "1.0");
        byte[] body = new String("{\n" + "\t\"a\":1,\n" + "\t\"b\":2\n" + "}").getBytes(StandardCharsets.UTF_8);
        List<CloudEvent> cloudEventList = eventConverterAdapter.toEventsRequest(headers, body);
        Assert.assertEquals(1, cloudEventList.size());
        Assert.assertEquals("demo:type", cloudEventList.get(0)
            .getType());
    }

    @Test
    public void toEventsRequest_Structured() {
        Map<String, String> headers = Maps.newHashMap();
        headers.put(CONTENT_TYPE, "application/cloudevents+json");

        Map<String, Object> cloudEvent = Maps.newHashMap();
        cloudEvent.put("id", UUID.randomUUID()
            .toString());
        cloudEvent.put("source", "demo-source");
        cloudEvent.put("type", URI.create("demo:type"));
        cloudEvent.put("specversion", "1.0");
        cloudEvent.put("data", "{\n" + "\t\"a\":1,\n" + "\t\"b\":2\n" + "}");
        List<CloudEvent> cloudEventList = eventConverterAdapter.toEventsRequest(headers, new Gson().toJson(cloudEvent)
            .getBytes(StandardCharsets.UTF_8));

        Assert.assertEquals(1, cloudEventList.size());
        Assert.assertEquals("demo:type", cloudEventList.get(0)
            .getType());
    }

    @Test
    public void toEventsRequest_Batched() {
        Map<String, String> headers = Maps.newHashMap();
        headers.put(CONTENT_TYPE, "application/cloudevents-batch+json");

        Map<String, Object> cloudEvent1 = Maps.newHashMap();
        cloudEvent1.put("id", UUID.randomUUID()
            .toString());
        cloudEvent1.put("source", "demo-source");
        cloudEvent1.put("type", URI.create("demo:type"));
        cloudEvent1.put("specversion", "1.0");
        cloudEvent1.put("data", "{\n" + "\t\"a\":1,\n" + "\t\"b\":2\n" + "}");

        Map<String, Object> cloudEvent2 = Maps.newHashMap();
        cloudEvent2.put("id", UUID.randomUUID()
            .toString());
        cloudEvent2.put("source", "demo-source");
        cloudEvent2.put("type", URI.create("demo:type"));
        cloudEvent2.put("specversion", "1.0");
        cloudEvent2.put("data", "{\n" + "\t\"a\":1,\n" + "\t\"b\":2\n" + "}");

        List<CloudEvent> cloudEventList = eventConverterAdapter.toEventsRequest(headers,
            new Gson().toJson(Arrays.asList(cloudEvent1, cloudEvent2))
                .getBytes(StandardCharsets.UTF_8));

        Assert.assertEquals(2, cloudEventList.size());
        Assert.assertEquals("demo:type", cloudEventList.get(0)
            .getType());
    }

}