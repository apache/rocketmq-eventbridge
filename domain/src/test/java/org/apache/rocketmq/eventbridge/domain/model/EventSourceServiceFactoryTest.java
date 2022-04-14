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

package org.apache.rocketmq.eventbridge.domain.model;

import java.util.List;

import com.google.common.collect.Lists;
import org.apache.rocketmq.eventbridge.domain.model.bus.EventBusService;
import org.apache.rocketmq.eventbridge.domain.model.source.EventSource;
import org.apache.rocketmq.eventbridge.domain.model.source.EventSourceService;
import org.apache.rocketmq.eventbridge.domain.repository.EventSourceRepository;
import org.apache.rocketmq.eventbridge.exception.EventBridgeException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.dao.DuplicateKeyException;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class EventSourceServiceFactoryTest {

    @InjectMocks
    private EventSourceService eventSourceService;

    @Mock
    private EventSourceRepository eventSourceRepository;

    @Mock
    private EventBusService eventBusService;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Before
    public void before() {
        doNothing().when(eventBusService)
            .checkExist(any(), any());
    }

    @Test
    public void testCreateEventSource_exception1() {
        when(eventSourceRepository.createEventSource(any(), any(), any(), any(), any(), any(), any(), any())).thenThrow(
            new DuplicateKeyException(""));
        thrown.expect(EventBridgeException.class);
        thrown.expectMessage("The event source [demo-source] of event bus [demo] already existed!");
        eventSourceService.createEventSource("123456", "demo", "demo-source", "description", null, null);
    }

    @Test
    public void testCreateEventSource_exception2() {
        thrown.expect(EventBridgeException.class);
        thrown.expectMessage("The event source name [$demo-source] is invalid!");
        eventSourceService.createEventSource("123456", "demo", "$demo-source", "description", null, null);
    }

    @Test
    public void testGetEventSource_exception1() {
        when(eventSourceRepository.getEventSource(any(), any(), any())).thenReturn(null);
        thrown.expect(EventBridgeException.class);
        thrown.expectMessage("The event source [demo-source] of event bus [demo] not existed!");
        eventSourceService.getEventSource("123456", "demo", "demo-source");
    }

    @Test
    public void testDeleteEventSource_exception1() {
        when(eventSourceRepository.getEventSource(any(), any(), any())).thenReturn(null);
        thrown.expect(EventBridgeException.class);
        thrown.expectMessage("The event source [demo-source] of event bus [demo] not existed!");
        eventSourceService.deleteEventSource("123456", "demo", "demo-source");
    }

    @Test
    public void testListEventSources() {
        EventSource eventSource = EventSource.builder()
            .accountId("123456")
            .eventBusName("demo")
            .name("demo-source")
            .build();
        List<EventSource> eventSources = Lists.newArrayList(eventSource);
        when(eventSourceRepository.getEventSourceCount(any(), any())).thenReturn(1);
        when(eventSourceRepository.listEventSources(any(), any(), any(), anyInt())).thenReturn(eventSources);
        PaginationResult<List<EventSource>> paginationResult = eventSourceService.listEventSources("123456", "demo",
            "0", 10);
        Assert.assertEquals(1, paginationResult.getTotal());
        Assert.assertEquals("10", paginationResult.getNextToken());
        Assert.assertEquals(1, paginationResult.getData()
            .size());
        Assert.assertEquals("demo-source", paginationResult.getData()
            .get(0)
            .getName());
    }

}
