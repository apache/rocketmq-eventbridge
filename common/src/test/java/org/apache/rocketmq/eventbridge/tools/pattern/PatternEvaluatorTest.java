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

package org.apache.rocketmq.eventbridge.tools.pattern;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.google.common.collect.Sets;
import org.apache.rocketmq.eventbridge.config.AppConfig;
import org.apache.rocketmq.eventbridge.config.GlobalConfig;
import org.apache.rocketmq.eventbridge.tools.JsonUtil;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.failBecauseExceptionWasNotThrown;

public class PatternEvaluatorTest {

    @Before
    public void before() {
        GlobalConfig globalConfig = new GlobalConfig();
        Set<String> eventExtensionKeys = Sets.newHashSet("aliyunregionid");
        globalConfig.setEventExtensionKeys(eventExtensionKeys);
        AppConfig.refreshGlobalConfig(globalConfig);
    }

    @Test
    public void evaluateWithEmptyPattern() {
        String pattern = "{}";
        PatternEvaluator evaluator = PatternEvaluatorBuilder.build(pattern);

        Map<String, String> specMap = new HashMap<>();
        specMap.put("source", "acs.aliyuncvc");
        assertThat(evaluator.evaluateSpecAttr(JsonUtil.convertToJsonElement(specMap))).isTrue();
        specMap.put("aliyuneventbusname", "demo-bus");
        assertThat(evaluator.evaluateExtensionAttr(JsonUtil.convertToJsonElement(specMap))).isTrue();
        assertThat(evaluator.evaluateData("{\"anyKey\":\"anyValue\"}")).isTrue();
    }

    @Test
    public void evaluateWithStringPattern() {
        String pattern = "{\"source\":[\"acs.aliyuncvc\"]}";

        PatternEvaluator evaluator = PatternEvaluatorBuilder.build(pattern);

        Map<String, String> specMap = new HashMap<>();
        specMap.put("source", "acs.aliyuncvc");
        assertThat(evaluator.evaluateSpecAttr(JsonUtil.convertToJsonElement(specMap))).isTrue();

        specMap.put("source", "acs.ecs");

        assertThat(evaluator.evaluateSpecAttr(JsonUtil.convertToJsonElement(specMap))).isFalse();

        // This matches on events where the value for
        // the "source" field is either "acs.aliyuncvc" or "acs.ecs".
        String patternWithTwoValues = "{\"source\":[\"acs.aliyuncvc\", \"acs.ecs\"]}";
        evaluator = PatternEvaluatorBuilder.build(patternWithTwoValues);
        assertThat(evaluator.evaluateSpecAttr(JsonUtil.convertToJsonElement(specMap))).isTrue();
    }

    @Test
    public void evaluateWithAliyunAttr() {
        String pattern = "{\"aliyunregionid\":[\"cn-hangzhou\"]}";

        PatternEvaluator evaluator = PatternEvaluatorBuilder.build(pattern);

        Map<String, String> specMap = new HashMap<>();
        specMap.put("aliyunregionid", "cn-hangzhou");
        assertThat(evaluator.evaluateExtensionAttr(JsonUtil.convertToJsonElement(specMap))).isTrue();

        specMap.put("aliyunregionid", "cn-beijing");
        assertThat(evaluator.evaluateExtensionAttr(JsonUtil.convertToJsonElement(specMap))).isFalse();
    }

    @Test
    public void evaluateWithNumberPattern() {
        String pattern = "{\n" + "    \"source\": [\"acs.ecs\"],\n" + "    \"data\": {\n"
            + "      \"risk-score\": [80, 20.5],\n" + "      \"trigger\": {\n" + "        \"risk\": [9.2, 8]\n"
            + "      }\n" + "    }\n" + "}";

        PatternEvaluator evaluator = PatternEvaluatorBuilder.build(pattern);

        String jsonData = "{\n" + "    \"risk-score\": 80,\n" + "    \"trigger\": {\n" + "        \"risk\": 8\n"
            + "    }\n" + "}";

        assertThat(evaluator.evaluateData(jsonData)).isTrue();

        jsonData = "{\n" + "    \"risk-score\": 80,\n" + "    \"trigger\": {\n" + "        \"risk\": 8.2\n" + "    }\n"
            + "}";
        assertThat(evaluator.evaluateData(jsonData)).isFalse();
    }

    @Test
    public void evaluateWithNotExistsField() {
        String pattern = "{\n" + "    \"source\": [\"acs.ecs\"],\n" + "    \"subject\": [\"sub-value\"],\n"
            + "    \"type\": [\"type-value\"]\n" + "}";
        PatternEvaluator evaluator = PatternEvaluatorBuilder.build(pattern);

        Map<String, String> specMap = new HashMap<>();
        specMap.put("source", "acs.ecs");
        assertThat(evaluator.evaluateSpecAttr(JsonUtil.convertToJsonElement(specMap))).isFalse();

        specMap.put("subject", "sub-value");

        assertThat(evaluator.evaluateSpecAttr(JsonUtil.convertToJsonElement(specMap))).isFalse();

        specMap.put("type", "type-value");
        assertThat(evaluator.evaluateSpecAttr(JsonUtil.convertToJsonElement(specMap))).isTrue();
    }

    @Test
    public void evaluateWithDiffNestingStructure() {
        String pattern = "{\n" + "    \"source\": [\"acs.ecs\"],\n" + "    \"data\": {\n"
            + "      \"risk-score\": [80],\n" + "      \"trigger\": {\n" + "        \"risk\": [8]\n" + "      }\n"
            + "    }\n" + "}";

        PatternEvaluator evaluator = PatternEvaluatorBuilder.build(pattern);

        String jsonData = "{\n" + "    \"risk-score\": 80,\n" + "    \"risk\": 8" + "}";

        assertThat(evaluator.evaluateData(jsonData)).isFalse();
    }

    @Test
    public void evaluateWithScientificNumber() {
        String pattern = "{\n" + "    \"source\": [\"acs.ecs\"],\n" + "    \"data\": {\n"
            + "      \"risk-score\": [3.0e2]\n" + "    }\n" + "}";
        PatternEvaluator evaluator = PatternEvaluatorBuilder.build(pattern);

        String jsonData = "{\n" + "    \"risk-score\": 300\n" + "}";
        assertThat(evaluator.evaluateData(jsonData)).isFalse();
    }

    @Test
    public void evaluateWithComplexPattern() {
        String pattern = "{\n" + "    \"time\": [{\"prefix\": \"2020-08-15\"}],\n"
            + "    \"source\": [\"acs.ecs\", \"acs.fc\"],\n" + "    \"data\": {\n"
            + "        \"state\": [ { \"anything-but\": \"initializing\" } ],\n"
            + "        \"c-count\": [ { \"numeric\": [ \">\", 0, \"<=\", 5 ] } ],\n"
            + "        \"d-count\": [ { \"numeric\": [ \"<\", 10 ] } ],\n"
            + "        \"x-limit\": [ { \"anything-but\": [ 100, 200, 300 ] } ],\n"
            + "        \"prod-type\": [\"rmq\", \"kafka\", \"mqtt\"]\n" + "    }\n" + "}";

        final PatternEvaluator evaluator = PatternEvaluatorBuilder.build(pattern);

        Map<String, String> specMap = new HashMap<>();
        specMap.put("source", "acs.ecs");
        assertThat(evaluator.evaluateSpecAttr(JsonUtil.convertToJsonElement(specMap))).isFalse();

        String jsonData = "{\n" + "    \"state\": \"terminated\",\n" + "    \"c-count\": 3.12,\n"
            + "    \"d-count\": 5,\n" + "    \"x-limit\": 120,\n" + "    \"prod-type\": [\"kafka\", \"eventbridge\"],\n"
            + "    \"other-fields\": {\n" + "        \"second-level\": {\n"
            + "            \"thrid-array\": [\"a\", \"b\", \"c\", \"d\"]\n" + "        }\n" + "    }\n" + "}";

        assertThat(evaluator.evaluateData(jsonData)).isTrue();
    }

    @Test
    public void evaluateWithEmptyString() {
        String pattern = "{\"subject\":[\"\"]}";

        PatternEvaluator evaluator = PatternEvaluatorBuilder.build(pattern);

        Map<String, String> specMap = new HashMap<>();
        specMap.put("subject", "");
        assertThat(evaluator.evaluateSpecAttr(JsonUtil.convertToJsonElement(specMap))).isTrue();
    }

    @Test
    public void evaluateWithNullValue() {
        String pattern = "{\n" + "    \"source\": [\"acs.ecs\"],\n" + "    \"data\": {\n"
            + "      \"risk-score\": [null]\n" + "    }\n" + "}";
        PatternEvaluator evaluator = PatternEvaluatorBuilder.build(pattern);

        String jsonData = "{\n" + "    \"risk-score\": null\n" + "}";
        assertThat(evaluator.evaluateData(jsonData)).isTrue();

        jsonData = "{\n" + "    \"risk-score\": \"null\"\n" + "}";
        assertThat(evaluator.evaluateData(jsonData)).isFalse();
    }

    @Test
    public void evaluateWithArray() {
        // If the value in the event is an array,
        // then the pattern matches if the intersection of the pattern array and the event array is non-empty.
        String pattern = "{\n" + "    \"source\": [\"acs.ecs\"],\n" + "    \"data\": {\n"
            + "      \"instance-list\": [\"instance1\", \"instance2\",\"instance3\"]\n" + "    }\n" + "}";
        PatternEvaluator evaluator = PatternEvaluatorBuilder.build(pattern);

        String jsonData = "{\n" + "    \"instance-list\": [\"instance4\", \"instance3\"]\n" + "}";

        assertThat(evaluator.evaluateData(jsonData)).isTrue();

        jsonData = "{\n" + "    \"instance-list\": [\"instance4\", \"instance5\"]\n" + "}";

        assertThat(evaluator.evaluateData(jsonData)).isFalse();
    }

    @Test
    public void evaluateWithPrefixCondition() {
        String pattern = "{\"time\":[{\"prefix\": \"2020-08-17\"}]}";

        PatternEvaluator evaluator = PatternEvaluatorBuilder.build(pattern);

        Map<String, String> specMap = new HashMap<>();
        specMap.put("time", "2020-08-17T18:23:00");
        assertThat(evaluator.evaluateSpecAttr(JsonUtil.convertToJsonElement(specMap))).isTrue();

        specMap.put("time", "2020-08-18T18:23:00");
        assertThat(evaluator.evaluateSpecAttr(JsonUtil.convertToJsonElement(specMap))).isFalse();
    }

    @Test
    public void evaluateWithSuffixCondition() {
        String pattern = "{\"time\":[{\"suffix\": \"23:00\"}]}";

        PatternEvaluator evaluator = PatternEvaluatorBuilder.build(pattern);

        Map<String, String> specMap = new HashMap<>();
        specMap.put("time", "2020-08-17T18:23:00");
        assertThat(evaluator.evaluateSpecAttr(JsonUtil.convertToJsonElement(specMap))).isTrue();

        specMap.put("time", "2020-08-17T18:23:06");
        assertThat(evaluator.evaluateSpecAttr(JsonUtil.convertToJsonElement(specMap))).isFalse();
    }

    @Test
    public void evaluateWithAnythingButCondition() {
        String pattern = "{\n" + "    \"source\": [\"acs.ecs\"],\n" + "    \"data\": {\n"
            + "      \"state\": [{\"anything-but\": \"stopped\"}]\n" + "    }\n" + "}";

        PatternEvaluator evaluator = PatternEvaluatorBuilder.build(pattern);

        String jsonData = "{\n" + "    \"state\": \"started\"\n" + "}";

        assertThat(evaluator.evaluateData(jsonData)).isTrue();

        jsonData = "{\n" + "    \"state\": \"stopped\"\n" + "}";

        assertThat(evaluator.evaluateData(jsonData)).isFalse();

        // Anything-but array
        pattern = "{\n" + "    \"source\": [\"acs.ecs\"],\n" + "    \"data\": {\n"
            + "      \"state\": [{\"anything-but\": [\"stopped\", \"started\"]}]\n" + "    }\n" + "}";
        evaluator = PatternEvaluatorBuilder.build(pattern);

        jsonData = "{\n" + "    \"state\": \"started\"\n" + "}";

        assertThat(evaluator.evaluateData(jsonData)).isFalse();

        jsonData = "{\n" + "    \"state\": \"stopped\"\n" + "}";

        assertThat(evaluator.evaluateData(jsonData)).isFalse();

        jsonData = "{\n" + "    \"state\": \"initializing\"\n" + "}";

        assertThat(evaluator.evaluateData(jsonData)).isTrue();

        // Anything-but with prefix
        pattern = "{\n" + "    \"source\": [\"acs.ecs\"],\n" + "    \"data\": {\n"
            + "      \"state\": [{\"anything-but\": {\"prefix\": \"ini\"}}]\n" + "    }\n" + "}";
        evaluator = PatternEvaluatorBuilder.build(pattern);

        jsonData = "{\n" + "    \"state\": \"started\"\n" + "}";

        assertThat(evaluator.evaluateData(jsonData)).isTrue();

        jsonData = "{\n" + "    \"state\": \"initializing\"\n" + "}";

        assertThat(evaluator.evaluateData(jsonData)).isFalse();

        // Anything-but with value array

    }

    @Test
    public void evaluateWithCIDRCondition() {
        String pattern = "{\n" + "    \"source\": [\"acs.ecs\"],\n" + "    \"data\": {\n"
            + "      \"ipv4\": [{\"cidr\": \"10.0.0.0/24\"}]\n" + "    }\n" + "}";

        PatternEvaluator evaluator = PatternEvaluatorBuilder.build(pattern);

        String jsonData = "{\n" + "    \"ipv4\": \"10.0.0.251\"\n" + "}";

        assertThat(evaluator.evaluateData(jsonData)).isTrue();

        jsonData = "{\n" + "    \"ipv4\": \"10.0.2.251\"\n" + "}";

        assertThat(evaluator.evaluateData(jsonData)).isFalse();

        // Illegal IPv4
        jsonData = "{\n" + "    \"ipv4\": \"10.0.0.1234\"\n" + "}";

        // Invalid IP address will return false
        assertThat(evaluator.evaluateData(jsonData)).isFalse();

        // Exact IP address

        pattern = "{\n" + "    \"source\": [\"acs.ecs\"],\n" + "    \"data\": {\n"
            + "      \"ipv4\": [{\"cidr\": \"10.0.0.1\"}]\n" + "    }\n" + "}";

        evaluator = PatternEvaluatorBuilder.build(pattern);

        jsonData = "{\n" + "    \"ipv4\": \"10.0.0.251\"\n" + "}";

        assertThat(evaluator.evaluateData(jsonData)).isFalse();

        jsonData = "{\n" + "    \"ipv4\": \"10.0.0.1\"\n" + "}";

        assertThat(evaluator.evaluateData(jsonData)).isTrue();
    }

    @Test
    public void evaluateWithExistsCondition() {
        String pattern = "{\n" + "    \"data\": {\n" + "      \"state\": [{\"exists\": true}]\n" + "    }\n" + "}";

        PatternEvaluator evaluator = PatternEvaluatorBuilder.build(pattern);

        String jsonData = "{\n" + "    \"state\": \"started\"\n" + "}";

        assertThat(evaluator.evaluateData(jsonData)).isTrue();

        jsonData = "{\n" + "    \"other-state\": \"stopped\"\n" + "}";

        assertThat(evaluator.evaluateData(jsonData)).isFalse();
    }

    @Test
    public void evaluateWithExistsFalseCondition() {
        String pattern = "{\n" + "    \"data\": {\n" + "      \"state\": [{\"exists\": false}]\n" + "    }\n" + "}";

        PatternEvaluator evaluator = PatternEvaluatorBuilder.build(pattern);

        String jsonData = "{\n" + "    \"state\": \"started\"\n" + "}";

        assertThat(evaluator.evaluateData(jsonData)).isFalse();

        jsonData = "{\n" + "    \"other-state\": \"stopped\"\n" + "}";

        assertThat(evaluator.evaluateData(jsonData)).isTrue();
    }

    @Test
    public void evaluateWithInValidNumericCondition() {
        String pattern = "{\n" + "    \"source\": [\"acs.ecs\"],\n" + "    \"data\": {\n"
            + "      \"c-count\": [{\"numeric\": [\">\", 1.0e10]}]\n" + "    }\n" + "}";

        try {
            PatternEvaluator evaluator = PatternEvaluatorBuilder.build(pattern);
            failBecauseExceptionWasNotThrown(InvalidEventPatternException.class);
        } catch (InvalidEventPatternException e) {
            assertThat(e.getMessage()).contains("between -1.0E9 and 1.0E9");
        }

        pattern = "{\n" + "    \"source\": [\"acs.ecs\"],\n" + "    \"data\": {\n"
            + "      \"c-count\": [{\"numeric\": [\">\", -1.0e10]}]\n" + "    }\n" + "}";

        try {
            PatternEvaluator evaluator = PatternEvaluatorBuilder.build(pattern);
            failBecauseExceptionWasNotThrown(InvalidEventPatternException.class);
        } catch (InvalidEventPatternException e) {
            assertThat(e.getMessage()).contains("between -1.0E9 and 1.0E9");
        }
    }

    @Test
    public void evaluateWithNumericCondition() {
        // Case 1: Greater
        String pattern = "{\n" + "    \"source\": [\"acs.ecs\"],\n" + "    \"data\": {\n"
            + "      \"c-count\": [{\"numeric\": [\">\", 120]}]\n" + "    }\n" + "}";

        PatternEvaluator evaluator = PatternEvaluatorBuilder.build(pattern);

        String jsonData = "{\n" + "    \"c-count\": 122\n" + "}";

        assertThat(evaluator.evaluateData(jsonData)).isTrue();

        jsonData = "{\n" + "    \"c-count\": 110\n" + "}";

        assertThat(evaluator.evaluateData(jsonData)).isFalse();

        // Case 2: Greater than
        pattern = "{\n" + "    \"source\": [\"acs.ecs\"],\n" + "    \"data\": {\n"
            + "      \"c-count\": [{\"numeric\": [\">=\", 120]}]\n" + "    }\n" + "}";

        evaluator = PatternEvaluatorBuilder.build(pattern);

        jsonData = "{\n" + "    \"c-count\": 120\n" + "}";

        assertThat(evaluator.evaluateData(jsonData)).isTrue();

        // Case 3: less

        pattern = "{\n" + "    \"source\": [\"acs.ecs\"],\n" + "    \"data\": {\n"
            + "      \"c-count\": [{\"numeric\": [\"<\", 120]}]\n" + "    }\n" + "}";

        evaluator = PatternEvaluatorBuilder.build(pattern);

        jsonData = "{\n" + "    \"c-count\": 119\n" + "}";

        assertThat(evaluator.evaluateData(jsonData)).isTrue();

        jsonData = "{\n" + "    \"c-count\": 120\n" + "}";

        assertThat(evaluator.evaluateData(jsonData)).isFalse();

        // Case 4: less than
        pattern = "{\n" + "    \"source\": [\"acs.ecs\"],\n" + "    \"data\": {\n"
            + "      \"c-count\": [{\"numeric\": [\"<=\", 120]}]\n" + "    }\n" + "}";

        evaluator = PatternEvaluatorBuilder.build(pattern);

        jsonData = "{\n" + "    \"c-count\": 120\n" + "}";

        assertThat(evaluator.evaluateData(jsonData)).isTrue();

        // Case 5: Equal
        pattern = "{\n" + "    \"source\": [\"acs.ecs\"],\n" + "    \"data\": {\n"
            + "      \"c-count\": [{\"numeric\": [\"=\", 1.1234567]}]\n" + "    }\n" + "}";

        evaluator = PatternEvaluatorBuilder.build(pattern);

        jsonData = "{\n" + "    \"c-count\": 1.12345678\n" + "}";

        assertThat(evaluator.evaluateData(jsonData)).isTrue();

        // Case 6: Not Equal
        pattern = "{\n" + "    \"source\": [\"acs.ecs\"],\n" + "    \"data\": {\n"
            + "      \"c-count\": [{\"numeric\": [\"!=\", 1.123455]}]\n" + "    }\n" + "}";

        evaluator = PatternEvaluatorBuilder.build(pattern);

        jsonData = "{\n" + "    \"c-count\": 1.123456\n" + "}";

        assertThat(evaluator.evaluateData(jsonData)).isTrue();
    }
}
