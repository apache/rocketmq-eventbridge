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

package org.apache.rocketmq.eventbridge.tools.transform;

import org.apache.rocketmq.eventbridge.exception.EventBridgeException;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

public class JsonPathTransformFromJsonStringTest extends BaseTransformTest {

    @Test
    public void testTransformJsonPath_OneKey() throws EventBridgeException {
        Transform transform = TransformBuilder.buildJsonTransform("$.id");
        Data output = transform.process(new StringData(JSON_EVENT));
        Assert.assertEquals("51efe8e2-841f-4900-8ff5-3c6dfae1060e", output.toString());
    }

    @Test
    public void testTransformJsonPath_TwoKey() throws EventBridgeException {
        Transform transform1 = TransformBuilder.buildJsonTransform("$.id");
        Data output1 = transform1.process(new StringData(JSON_EVENT));
        Assert.assertEquals("51efe8e2-841f-4900-8ff5-3c6dfae1060e", output1.toString());

        Transform transform2 = TransformBuilder.buildJsonTransform("$.type");
        Data output2 = transform2.process(new StringData(JSON_EVENT));
        Assert.assertEquals("oss:ObjectCreated:PostObject", output2.toString());
    }

    @Test
    public void testTransformJsonPath_Number() throws EventBridgeException {
        Transform transform = TransformBuilder.buildJsonTransform("$.data.number");
        Data output = transform.process(new StringData(JSON_EVENT));
        Assert.assertEquals("100", output.toString());
    }

    @Test
    public void testTransformJsonPath_Array() throws EventBridgeException {
        Transform transform = TransformBuilder.buildJsonTransform("$.data.text");
        Data output = transform.process(new StringData(JSON_EVENT));
        Assert.assertEquals("100", output.toString());
    }

    @Test
    public void testTransformJsonPath_Empty() throws EventBridgeException {
        Transform transform = TransformBuilder.buildJsonTransform("$.data.empty");
        Data output = transform.process(new StringData(JSON_EVENT));
        Assert.assertEquals(null, output.toString());
    }

    @Test
    @Ignore
    public void testTransformJsonPath_Data() throws EventBridgeException {
        // TODO JSON PATH read ignore the null value
        Transform transform = TransformBuilder.buildJsonTransform("$.data");
        Data output = transform.process(new StringData(JSON_EVENT));
        Assert.assertEquals(JSON_EVENT_DATA.trim(), output.toString());
    }
}
