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

package org.apache.rocketmq.eventbridge.adapter.api.handler;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import lombok.SneakyThrows;
import org.apache.rocketmq.eventbridge.adapter.api.dto.data.PutEventsResponse;
import org.apache.rocketmq.eventbridge.adapter.api.handler.EventDataHandler;
import org.apache.rocketmq.eventbridge.adapter.api.handler.ReactorPutEventCallback;
import org.apache.rocketmq.eventbridge.domain.model.data.EventDataService;
import org.apache.rocketmq.eventbridge.domain.model.data.PutEventCallback;
import org.apache.rocketmq.eventbridge.domain.model.data.PutEventsResponseEntry;
import org.apache.rocketmq.eventbridge.event.EventBridgeEvent;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import reactor.core.publisher.Mono;

import static org.mockito.ArgumentMatchers.any;

@RunWith(MockitoJUnitRunner.class)
public class EventDataHandlerTest {
    @InjectMocks
    private EventDataHandler eventDataHandler;

    @Mock
    EventDataService eventDataService;

    ExecutorService executor = Executors.newFixedThreadPool(10);

    @Before
    public void before() {
        Mockito.doAnswer((invocation) -> {
            Object[] args = invocation.getArguments();
            EventBridgeEvent event = (EventBridgeEvent)args[1];
            ReactorPutEventCallback callback = (ReactorPutEventCallback)args[2];
            executor.submit(new PutEventTestThread(event, callback));
            return null;
        })
            .when(eventDataService)
            .putEvent(any(), any(), any());
    }

    @Test
    public void testPutEvents() {
        Long startTime = System.currentTimeMillis();
        List<EventBridgeEvent> eventList = IntStream.range(0, 10)
            .mapToObj(index -> {
                EventBridgeEvent event = new EventBridgeEvent();
                event.setId(UUID.randomUUID()
                    .toString());
                return event;
            })
            .collect(Collectors.toList());
        Mono<PutEventsResponse> mono = eventDataHandler.putEvents("123456", eventList);
        PutEventsResponse putEventsResponse = mono.block();
        Long costTime = System.currentTimeMillis() - startTime;
        Assert.assertEquals(10, putEventsResponse.getEntryList()
            .size());
        System.out.println("costTime:" + costTime);
        Assert.assertEquals(true, costTime < 4000);
    }

    class PutEventTestThread implements Runnable {
        EventBridgeEvent event;
        PutEventCallback putEventCallback;

        public PutEventTestThread(EventBridgeEvent event, PutEventCallback putEventCallback) {
            this.event = event;
            this.putEventCallback = putEventCallback;
        }

        @SneakyThrows
        @Override
        public void run() {
            Thread.sleep(3000L);
            PutEventsResponseEntry putEventsResponseEntry = new PutEventsResponseEntry();
            putEventsResponseEntry.setEventId(event.getId());
            if (System.currentTimeMillis() % 2 == 1) {
                putEventsResponseEntry.setErrorCode("Success");
            } else {
                putEventsResponseEntry.setErrorCode("Failed.");
            }

            putEventCallback.endProcess(putEventsResponseEntry);
        }
    }

}
