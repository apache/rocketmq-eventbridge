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

import java.util.Map;

import com.google.common.collect.Maps;
import com.google.gson.Gson;
import org.apache.rocketmq.eventbridge.domain.model.classes.APIAttribute;
import org.apache.rocketmq.eventbridge.domain.model.classes.EventSourceClass;
import org.apache.rocketmq.eventbridge.domain.model.classes.EventSourceClassService;
import org.apache.rocketmq.eventbridge.domain.repository.EventSourceClassRepository;
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

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class EventTargetRunnerClassServiceTest {

    @InjectMocks
    EventSourceClassService eventSourceClassService;

    @Mock
    EventSourceClassRepository eventSourceClassRepository;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    private String testSourceClassName = "acs.mns";

    @Before
    public void before() {
        Map<String, APIAttribute> apiParams = Maps.newHashMap();
        apiParams.put("RegionId", new APIAttribute("", "The source region id.", false, null));
        apiParams.put("QueueName", new APIAttribute("", "The queue name.", true, null));
        apiParams.put("IsBase64Encode", new APIAttribute("", "Base64 encode body or not.", true, null));

        Map<String, Object> requiredParams = Maps.newHashMap();
        requiredParams.put("Endpoint", "${AccountId}.mns.${RegionId}.aliyuncs.com");
        requiredParams.put("RoleName", "UserDefinedRoleName");
        requiredParams.put("QueueName", "${QueueName}");
        requiredParams.put("IsBase64Encode", "${IsBase64Encode}");

        Map<String, Object> transform = Maps.newHashMap();
        transform.put("data", "{\"value\":\"$.data\",\"form\":\"JSONPATH\"}");
        transform.put("subject",
            "{\"value\":\"acs:mns:${RegionId}:${AccountId}:queues/${QueueName}\",\"form\":\"CONSTANT\"}");
        transform.put("type", "{\"value\":\"mns.sendMsg\",\"form\":\"CONSTANT\"}");

        EventSourceClass eventSourceClass = EventSourceClass.builder()
            .apiParams(apiParams)
            .requiredParams(requiredParams)
            .transform(transform)
            .build();
        when(eventSourceClassRepository.getEventSourceClass(testSourceClassName)).thenReturn(eventSourceClass);

    }

    @Test
    public void checkEventSourceAPIParams_Pass() {
        Map<String, Object> inputConfig = Maps.newHashMap();
        inputConfig.put("QueueName", "demo");
        inputConfig.put("IsBase64Encode", true);
        eventSourceClassService.checkEventSourceAPIParams(testSourceClassName, inputConfig);
    }

    @Test
    public void checkEventSourceAPIParams_EventSourceMissingAttribute() {
        Map<String, Object> inputConfig = Maps.newHashMap();
        inputConfig.put("QueueName", "demo");
        inputConfig.put("IsBase64Encode", true);
        inputConfig.put("InvalidAttribute", true);
        thrown.expect(EventBridgeException.class);
        thrown.expectMessage(
            "The attribute [InvalidAttribute] is ineffective, which effective attribute is [IsBase64Encode,RegionId,"
                + "QueueName].");
        eventSourceClassService.checkEventSourceAPIParams(testSourceClassName, inputConfig);
    }

    @Test
    public void checkEventSourceAPIParams_EventSourceIneffectiveAttribute() {
        Map<String, Object> inputConfig = Maps.newHashMap();
        inputConfig.put("IsBase64Encode", true);
        thrown.expect(EventBridgeException.class);
        thrown.expectMessage("Missing the attribute [QueueName:The queue name.] ");
        eventSourceClassService.checkEventSourceAPIParams(testSourceClassName, inputConfig);
    }

    @Test
    public void testRenderConfig() {
        Map<String, Object> inputConfig = Maps.newHashMap();
        inputConfig.put("RegionId", "cn-hangzhou");
        inputConfig.put("QueueName", "demo");
        inputConfig.put("IsBase64Encode", true);
        Component component = eventSourceClassService.renderConfig("123456", testSourceClassName, inputConfig);
        System.out.println(new Gson().toJson(component));
        Assert.assertEquals(testSourceClassName, component.getName());
        Assert.assertEquals("123456.mns.cn-hangzhou.aliyuncs.com", component.getConfig()
            .get("Endpoint"));
        Assert.assertEquals("UserDefinedRoleName", component.getConfig()
            .get("RoleName"));
        Assert.assertEquals("demo", component.getConfig()
            .get("QueueName"));
        Assert.assertEquals("true", component.getConfig()
            .get("IsBase64Encode"));
    }

    @Test
    public void renderCloudEventTransform() {
        Map<String, Object> inputConfig = Maps.newHashMap();
        inputConfig.put("RegionId", "cn-hangzhou");
        inputConfig.put("QueueName", "demo");
        inputConfig.put("IsBase64Encode", true);

        Map<String, Object> transform = eventSourceClassService.renderCloudEventTransform("123456", testSourceClassName,
            inputConfig, "eventSource");

        Assert.assertEquals("{\"value\":\"$.data\",\"form\":\"JSONPATH\"}", transform.get("data"));
        Assert.assertEquals("{\"value\":\"acs:mns:cn-hangzhou:123456:queues/demo\",\"form\":\"CONSTANT\"}",
            transform.get("subject"));
        Assert.assertEquals("{\"form\":\"CONSTANT\",\"value\":\"eventSource\"}", transform.get("source"));
        Assert.assertEquals("{\"value\":\"mns.sendMsg\",\"form\":\"CONSTANT\"}", transform.get("type"));
    }
}