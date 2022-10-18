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

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import java.util.Deque;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.LinkedBlockingDeque;
import org.apache.rocketmq.eventbridge.config.AppConfig;
import org.apache.rocketmq.eventbridge.event.EventBridgeEvent;
import org.apache.rocketmq.eventbridge.tools.JsonUtil;

public class PatternEvaluatorBuilder {
    private static JsonParser jsonParser = new JsonParser();
    static final String CLOUDEVENTS_DATA_KEY = "data";

    /**
     * The handler to build {@link PatternEvaluator} from a json event pattern string
     *
     * @param eventPattern the json event pattern string
     * @return the instance of RuleEvalutor
     * @throws InvalidEventPatternException if any error occurs
     */
    public static PatternEvaluator build(String eventPattern) {
        PatternEvaluator patternEvaluator = new PatternEvaluator();
        if (JsonUtil.isEmptyJsonObject(eventPattern)) {
            return patternEvaluator;
        }
        final JsonElement rootElement;
        try {
            rootElement = jsonParser.parse(eventPattern);
        } catch (JsonSyntaxException e) {
            throw new InvalidEventPatternException(PatternErrorMessages.INVALID_JSON_STRING, e);
        }

        if (!rootElement.isJsonObject()) {
            throw new InvalidEventPatternException(PatternErrorMessages.NON_SUPPORTED_JSON);
        }

        JsonObject rootObj = rootElement.getAsJsonObject();
        JsonElement dataElement = null;

        for (final Map.Entry<String, JsonElement> elementEntry : rootObj.entrySet()) {
            String key = elementEntry.getKey();
            final JsonElement jsonElement = elementEntry.getValue();
            if (CLOUDEVENTS_DATA_KEY.equals(key)) {
                dataElement = jsonElement;
                continue;
            }

            if (!jsonElement.isJsonArray()) {
                throw new InvalidEventPatternException(
                    PatternErrorMessages.INVALID_PATTERN_VALUE + jsonElement.getAsString());
            }

            PatternEntry patternEntry = parsePatternEntry(key, "$." + key, jsonElement.getAsJsonArray());

            if (EventBridgeEvent.getAttributeKeys()
                .contains(key)) {
                // Add to spec attr rule entry list
                patternEvaluator.addSpecAttrPatternEntry(patternEntry);
                continue;
            }

            if (AppConfig.getGlobalConfig()
                .getEventExtensionKeys()
                .contains(key)) {
                patternEvaluator.addExtensionsAttrPatternEntry(patternEntry);
                continue;
            }

            // Unrecognized rule key
            throw new InvalidEventPatternException(PatternErrorMessages.UNRECOGNIZED_PATTERN_KEY + key);
        }

        if (dataElement != null) {
            if (!dataElement.isJsonObject()) {
                throw new InvalidEventPatternException(PatternErrorMessages.NO_DATA_PATTERN_KEY);
            }

            Deque<JsonObject> patternStack = new LinkedBlockingDeque<>();
            Deque<String> jsonPathStack = new LinkedBlockingDeque<>();

            patternStack.addFirst(dataElement.getAsJsonObject());
            jsonPathStack.push("$.");

            while (!patternStack.isEmpty()) {
                final JsonObject jsonObj = patternStack.pop();
                final String jsonPathPrefix = jsonPathStack.pop();
                final Set<Map.Entry<String, JsonElement>> entries = jsonObj.entrySet();
                for (final Map.Entry<String, JsonElement> elementEntry : entries) {
                    String key = elementEntry.getKey();
                    JsonElement element = elementEntry.getValue();

                    String jsonPath = jsonPathPrefix + key;

                    if (element.isJsonArray()) {
                        patternEvaluator.addDataPatternEntry(
                            parsePatternEntry(key, jsonPathPrefix + key, element.getAsJsonArray()));
                        continue;
                    }

                    if (element.isJsonObject()) {
                        patternStack.push(element.getAsJsonObject());
                        jsonPathStack.push(jsonPath + '.');
                        continue;
                    }

                    // Shouldn't be json null and json primitive
                    throw new InvalidEventPatternException(
                        PatternErrorMessages.INVALID_PATTERN_VALUE + element.getAsString());
                }

                if (entries.size() == 0) {
                    throw new InvalidEventPatternException(PatternErrorMessages.NO_DATA_PATTERN_KEY);
                }
            }
        }
        return patternEvaluator;
    }

    /**
     * Get target element of filter pattern.
     *
     * @param filterPattern
     * @param elements
     * @return
     */
    public static String getTargetElementOfFilterPattern(String filterPattern, String... elements) {
        if (JsonUtil.isEmptyJsonObject(filterPattern)) {
            return filterPattern;
        }
        final JsonElement rootElement;
        try {
            rootElement = jsonParser.parse(filterPattern);
        } catch (JsonSyntaxException e) {
            throw new InvalidEventPatternException(PatternErrorMessages.INVALID_JSON_STRING, e);
        }

        if (!rootElement.isJsonObject()) {
            throw new InvalidEventPatternException(PatternErrorMessages.NON_SUPPORTED_JSON);
        }

        JsonObject sourceJsonObject = rootElement.getAsJsonObject();
        JsonObject targetJsonObject = new JsonObject();
        for (String element : elements) {
            JsonElement targetElement = sourceJsonObject.get(element);
            if (targetElement != null) {
                targetJsonObject.add(element, targetElement);
            }
        }
        return targetJsonObject.toString();
    }

    private static PatternEntry parsePatternEntry(String ruleName, String rulePath, JsonArray jsonElements) {
        if (jsonElements.size() == 0) {
            // Empty array
            throw new InvalidEventPatternException(
                PatternErrorMessages.INVALID_PATTERN_VALUE + jsonElements.toString());
        }

        PatternEntry patternEntry = new PatternEntry(ruleName, rulePath);

        for (final JsonElement element : jsonElements) {
            if (element.isJsonNull() || element.isJsonPrimitive()) {
                // Equal condition
                EqualCondition equalCondition = new EqualCondition(element);
                patternEntry.addRuleCondition(equalCondition);
                continue;
            }

            if (element.isJsonObject()) {
                // May throw RuleParseException when building RuleCondition
                patternEntry.addRuleCondition(parseCondition(element.getAsJsonObject()));
                continue;
            }
            // JsonArray isn't acceptable
            throw new InvalidEventPatternException(PatternErrorMessages.NESTED_PATTERN_VALUE + ruleName);
        }

        return patternEntry;
    }

    static PatternCondition parseCondition(JsonObject jsonObject) {
        // Complex condition
        final Set<Map.Entry<String, JsonElement>> entries = jsonObject.entrySet();

        if (entries.size() != 1) {
            throw new InvalidEventPatternException(PatternErrorMessages.INVALID_PATTERN_CONDITION);
        }

        final Map.Entry<String, JsonElement> elementEntry = entries.iterator()
            .next();
        String key = elementEntry.getKey();

        PatternConditionBuilder builder = ComplexConditionBuilders.getConditionBuilderByName(key);
        if (builder == null) {
            throw new InvalidEventPatternException(PatternErrorMessages.UNRECOGNIZED_PATTERN_CONDITION + key);
        }

        return builder.build(elementEntry.getValue());
    }
}
