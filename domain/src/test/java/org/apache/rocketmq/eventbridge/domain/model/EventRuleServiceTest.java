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
import org.apache.rocketmq.eventbridge.domain.model.bus.EventBusService;
import org.apache.rocketmq.eventbridge.domain.model.rule.EventRule;
import org.apache.rocketmq.eventbridge.domain.model.rule.EventRuleService;
import org.apache.rocketmq.eventbridge.domain.repository.EventRuleRepository;
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
public class EventRuleServiceTest {

    @InjectMocks
    private EventRuleService eventRuleService;

    @Mock
    private EventRuleRepository eventRuleRepository;

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
    public void testCreateEventRule_exception1() {
        when(eventRuleRepository.createEventRule(any(), any(), any(), any(), any(), any())).thenThrow(
            new DuplicateKeyException(""));
        thrown.expect(EventBridgeException.class);
        thrown.expectMessage("The event rule [demo-rule] of event bus [demo] already existed!");
        eventRuleService.createEventRule("123456", "demo", "demo-rule", "description", "{}");
    }

    @Test
    public void testCreateEventRule_exception2() {
        thrown.expect(EventBridgeException.class);
        thrown.expectMessage("The event rule name [$demo-rule] is invalid!");
        eventRuleService.createEventRule("123456", "demo", "$demo-rule", "description", "{}");
    }

    @Test
    public void testGetEventRule_exception1() {
        when(eventRuleRepository.getEventRule(any(), any(), any())).thenReturn(null);
        thrown.expect(EventBridgeException.class);
        thrown.expectMessage("The event rule [demo-rule] of event bus [demo] not existed!");
        eventRuleService.getEventRule("123456", "demo", "demo-rule");
    }

    @Test
    public void testDeleteEventRule_exception1() {
        when(eventRuleRepository.getEventRule(any(), any(), any())).thenReturn(null);
        thrown.expect(EventBridgeException.class);
        thrown.expectMessage("The event rule [demo-source] of event bus [demo] not existed!");
        eventRuleService.deleteEventRule("123456", "demo", "demo-source");
    }

    @Test
    public void testListEventRules() {
        EventRule eventRule = EventRule.builder()
            .accountId("123456")
            .eventBusName("demo")
            .name("demo-rule")
            .build();
        List<EventRule> eventRules = Lists.newArrayList(eventRule);
        when(eventRuleRepository.getEventRulesCount(any(), any())).thenReturn(1);
        when(eventRuleRepository.listEventRules(any(), any(), any(), anyInt())).thenReturn(eventRules);
        PaginationResult<List<EventRule>> paginationResult = eventRuleService.listEventRules("123456", "demo", "0", 10);
        Assert.assertEquals(1, paginationResult.getTotal());
        Assert.assertEquals(null, paginationResult.getNextToken());
        Assert.assertEquals(1, paginationResult.getData()
            .size());
        Assert.assertEquals("demo-rule", paginationResult.getData()
            .get(0)
            .getName());
    }

}
