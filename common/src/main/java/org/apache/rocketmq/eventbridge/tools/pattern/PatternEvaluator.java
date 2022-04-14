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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.common.base.Strings;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.PathNotFoundException;
import com.jayway.jsonpath.ReadContext;
import com.jayway.jsonpath.spi.json.GsonJsonProvider;
import org.apache.rocketmq.eventbridge.config.AppConfig;
import org.apache.rocketmq.eventbridge.event.EventBridgeEvent;

/**
 * PatternEvaluator has three {@link PatternEntry} groups:
 * <ul>
 *     <li>{@link #specAttrPatternList} contains pattern entries to filter CloudEvents spec attributes</li>
 *     <li>{@link #extensionsAttrPatternList} contains pattern entries to filter extension event attributes as
 *     extensions of
 *     CloudEvents</li>
 *     <li>{@link #dataPatternList} contains pattern entries to filter data of CloudEvents, only support json type</li>
 * </ul>
 */
public class PatternEvaluator {
    Configuration jsonPathConf = Configuration.builder()
        .jsonProvider(new GsonJsonProvider())
        .build();

    private List<PatternEntry> specAttrPatternList = new ArrayList<>();
    private List<PatternEntry> extensionsAttrPatternList = new ArrayList<>();
    private List<PatternEntry> dataPatternList = new ArrayList<>();

    /**
     * Evaluates the provided json string whether matches the event pattern
     *
     * @param jsonData the specific data in json format
     *
     * @return true if jsonData matches rule, false otherwise
     */
    public boolean evaluateData(String jsonData) {
        if (Strings.isNullOrEmpty(jsonData)) {
            return false;
        }
        final ReadContext jsonContext = JsonPath.using(jsonPathConf)
            .parse(jsonData);

        for (final PatternEntry patternEntry : dataPatternList) {
            JsonElement jsonElement = null;
            try {
                jsonElement = jsonContext.read(patternEntry.getPatternPath());
            } catch (PathNotFoundException ignored) {
            }

            if (!patternEntry.match(jsonElement)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Evaluates the provided spec attributes whether matches the event pattern
     *
     * @param specAttrs the provided spec attributes in map format
     *
     * @return true if matches the pattern, false otherwise
     */
    public boolean evaluateSpecAttr(Map<String, JsonElement> specAttrs) {
        return evaluateAttrMap(specAttrs, specAttrPatternList);
    }

    /**
     * Evaluates the provided extensions attributes whether matches the event pattern
     *
     * @param extensionsAttrs the provided extensions attributes in map format
     *
     * @return true if matches the pattern, false otherwise
     */
    public boolean evaluateExtensionAttr(Map<String, JsonElement> extensionsAttrs) {
        return evaluateAttrMap(extensionsAttrs, extensionsAttrPatternList);
    }

    /**
     * Tests whether the event pattern matches the provided event in JSON format.
     *
     * @param eventObject the provided event object
     *
     * @return true if match
     */
    public boolean testEventPattern(JsonObject eventObject) {
        Map<String, JsonElement> specAttrs = new HashMap<>();
        Map<String, JsonElement> extensionsAttrs = new HashMap<>();
        Object dataObj = null;

        for (final Map.Entry<String, JsonElement> eventEntry : eventObject.entrySet()) {
            String key = eventEntry.getKey();

            if (PatternEvaluatorBuilder.CLOUDEVENTS_DATA_KEY.equals(key)) {
                dataObj = eventEntry.getValue();
                continue;
            }

            if (EventBridgeEvent.getAttributeKeys()
                .contains(key)) {
                specAttrs.put(key, eventEntry.getValue());
                continue;
            }

            if (AppConfig.getGlobalConfig()
                .getEventExtensionKeys()
                .contains(key)) {
                extensionsAttrs.put(key, eventEntry.getValue());
                continue;
            }

            // No need to handle other fields, since we have already validate the event format
        }

        if (!evaluateSpecAttr(specAttrs)) {
            return false;
        }

        if (!evaluateExtensionAttr(extensionsAttrs)) {
            return false;
        }

        if (!hasDataPattern()) {
            // No need to filter by data
            return true;
        }

        if (dataObj == null) {
            // No data can be used to match the data rule
            return false;
        }

        return evaluateData(dataObj.toString());
    }

    /**
     * Tests whether the evaluator has data patterns
     *
     * @return true if {@link #dataPatternList} is not empty, false otherwise
     */
    public boolean hasDataPattern() {
        return !this.dataPatternList.isEmpty();
    }

    /**
     * Tests whether the evaluator has no data patter
     *
     * @return true if the patterns of evaluator is empty, false otherwise
     */
    public boolean isEmpty() {
        return this.extensionsAttrPatternList.isEmpty() && this.specAttrPatternList.isEmpty()
            && this.dataPatternList.isEmpty();
    }

    public void addSpecAttrPatternEntry(PatternEntry patternEntry) {
        this.specAttrPatternList.add(patternEntry);
    }

    public void addExtensionsAttrPatternEntry(PatternEntry patternEntry) {
        this.extensionsAttrPatternList.add(patternEntry);
    }

    public void addDataPatternEntry(PatternEntry patternEntry) {
        this.dataPatternList.add(patternEntry);
    }

    private boolean evaluateAttrMap(Map<String, JsonElement> attr, List<PatternEntry> ruleEntries) {
        for (final PatternEntry patternEntry : ruleEntries) {
            JsonElement val = attr.get(patternEntry.getPatternName());
            if (!patternEntry.match(val)) {
                return false;
            }
        }
        return true;
    }

    // Below three getters only for test

    List<PatternEntry> getSpecAttrPatternList() {
        return specAttrPatternList;
    }

    List<PatternEntry> getExtensionsAttrPatternList() {
        return extensionsAttrPatternList;
    }

    List<PatternEntry> getDataPatternList() {
        return dataPatternList;
    }
}
