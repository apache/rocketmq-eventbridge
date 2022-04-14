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
import org.junit.Test;

public class TemplateTransformFromJsonStringTest extends BaseTransformTest {

    @Test
    public void testTransformTemplate_Json() throws EventBridgeException {
        String extractJson = "{\"text\":\"$.data.text\",\"number\":\"$.data.number\"}";
        String template = "{\n" + "  \"text\":\"${text}\",\n" + "  \"number\":${number},\n  \"data\":\"666\"\n}";
        System.out.println(extractJson);
        System.out.println(template);
        Transform transform = TransformBuilder.buildTemplateTransForm(extractJson, template);
        Data output = transform.process(new StringData(JSON_EVENT));
        System.out.println(output.toString());
        Assert.assertEquals("{\n  \"text\":\"100\",\n  \"number\":100,\n  \"data\":\"666\"\n}", output.toString());
    }

    @Test
    public void testTransformTemplate_Text() throws EventBridgeException {
        String extractJson = "{\"text\":\"$.data.text\",\"number\":\"$.data.number\"}";
        String template = "The ${text} = ${number}!";
        Transform transform = TransformBuilder.buildTemplateTransForm(extractJson, template);
        Data output = transform.process(new StringData(JSON_EVENT));
        Assert.assertEquals("The 100 = 100!", output.toString());
    }

    @Test
    public void testTransformTemplate_Empty() throws EventBridgeException {
        String extractJson = "{}";
        String template = "The ${text} = ${number}!";
        Transform transform = TransformBuilder.buildTemplateTransForm(extractJson, template);
        Data output = transform.process(new StringData(JSON_EVENT));
        Assert.assertEquals("The ${text} = ${number}!", output.toString());
    }

    @Test
    public void testTransformTemplate_EmptyJson() throws EventBridgeException {
        String extractJson = "{\"text\":\"$.data.empty\",\"number\":\"$.data.empty\"}";
        String template = "The ${text} = ${number}!";
        Transform transform = TransformBuilder.buildTemplateTransForm(extractJson, template);
        Data output = transform.process(new StringData(JSON_EVENT));
        Assert.assertEquals("The ${text} = ${number}!", output.toString());
    }

    @Test
    public void testTransformTemplate_NullJson() throws EventBridgeException {
        String extractJson = "{\"text\":\"$.data.null\",\"number\":\"$.data.null\"}";
        String template = "The ${text} = ${number}!";
        Transform transform = TransformBuilder.buildTemplateTransForm(extractJson, template);
        Data output = transform.process(new StringData(JSON_EVENT));
        Assert.assertEquals("The null = null!", output.toString());
    }

    @Test
    public void testTransformTemplate_InvalidJsonPath() throws EventBridgeException {
        String extractJson = "{\"name\":\"$.data.text\",\"constant\":\"Please deal with it timely.\"" + "}";
        String template = "The instance is broken，which name is ${name} , ${constant}";
        Transform transform = TransformBuilder.buildTemplateTransForm(extractJson, template);
        Data output = transform.process(new StringData(JSON_EVENT));
        Assert.assertEquals("The instance is broken，which name is 100 , Please deal with it timely.",
            output.toString());
    }
    @Test
    public void testTransformTemplate_Constant() throws EventBridgeException {
        String extractJson = "{\"name\":\"$.data.text\",\"table\":\"tableName\"" + "}";
        String template = "The instance is broken，which name is ${name} , ${table}";
        Transform transform = TransformBuilder.buildTemplateTransForm(extractJson, template);
        Data output = transform.process(new StringData(JSON_EVENT));
        Assert.assertEquals("The instance is broken，which name is 100 , tableName",
            output.toString());
    }

}
