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

import com.google.common.collect.Lists;
import java.util.List;
import org.apache.rocketmq.eventbridge.domain.model.bus.EventBus;
import org.apache.rocketmq.eventbridge.domain.model.bus.EventBusService;
import org.apache.rocketmq.eventbridge.domain.repository.EventBusRepository;
import org.apache.rocketmq.eventbridge.exception.EventBridgeException;
import org.junit.Assert;
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
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class EventBusServiceTest {

    @InjectMocks
    private EventBusService eventBusService;

    @Mock
    private EventBusRepository eventBusRepository;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void testCreateEventBus_exception1() {
        when(eventBusRepository.createEventBus(any(), any(), any())).thenThrow(new DuplicateKeyException(""));
        thrown.expect(EventBridgeException.class);
        thrown.expectMessage("The event bus [demo] already existed!");
        eventBusService.createEventBus("123456", "demo", "description");
    }

    @Test
    public void testCreateEventBus_exception2() {
        thrown.expect(EventBridgeException.class);
        thrown.expectMessage("The event bus name [default] is invalid!");
        eventBusService.createEventBus("123456", "default", "description");
    }

    @Test
    public void testGetEventBus_exception1() {
        when(eventBusRepository.getEventBus(any(), any())).thenReturn(null);
        thrown.expect(EventBridgeException.class);
        thrown.expectMessage("The event bus [demo] not existed!");
        eventBusService.getEventBus("123456", "demo");
    }

    @Test
    public void testDeleteEventBus_exception1() {
        when(eventBusRepository.getEventBus(any(), any())).thenReturn(null);
        thrown.expect(EventBridgeException.class);
        thrown.expectMessage("The event bus [demo] not existed!");
        eventBusService.deleteEventBus("123456", "demo");
    }

    @Test
    public void testListEventBuses() {
        EventBus eventBus = new EventBus();
        eventBus.setName("demo");
        List<EventBus> eventBuses = Lists.newArrayList(eventBus);
        when(eventBusRepository.getEventBusesCount(any())).thenReturn(1);
        when(eventBusRepository.listEventBuses(any(), any(), anyInt())).thenReturn(eventBuses);
        PaginationResult<List<EventBus>> paginationResult = eventBusService.listEventBuses("123456", "0", 10);
        Assert.assertEquals(1, paginationResult.getTotal());
        Assert.assertEquals(null, paginationResult.getNextToken());
        Assert.assertEquals(1, paginationResult.getData()
            .size());
        Assert.assertEquals("demo", paginationResult.getData()
            .get(0)
            .getName());
    }

}
