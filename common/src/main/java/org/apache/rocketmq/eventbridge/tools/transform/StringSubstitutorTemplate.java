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

import com.google.common.base.Strings;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.apache.commons.text.StringSubstitutor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StringSubstitutorTemplate implements Template {

    private static final Logger log = LoggerFactory.getLogger(StringSubstitutorTemplate.class);

    public static final String EB_SYS_EMBED_OBJECT = "EB_SYS_EMBED_OBJECT";
    public static final String EB_SYS_ROOT = "EB_SYS_ROOT";

    private String outputTemplate;
    private JsonObject jsonObject;
    private boolean isEmbedObject;

    public StringSubstitutorTemplate(String outputTemplate) {
        this.outputTemplate = outputTemplate;
        if (this.outputTemplate.contains(EB_SYS_EMBED_OBJECT)) {
            isEmbedObject = true;
            JsonElement jsonElement = JsonParser.parseString(outputTemplate);
            if (jsonElement.isJsonObject()) {
                jsonObject = jsonElement.getAsJsonObject();
            }
        }
    }

    @Override
    public Data parse(List<Variable> variableList) {
        Map<String, String> valuesMap = variableList.stream()
            .filter(variable -> variable.getValue() != null)
            .collect(Collectors.toMap(Variable::getName, Variable::defaultStringValue));
        StringSubstitutor sub = new StringSubstitutor(valuesMap);
        log.debug("template: " + outputTemplate);

        List<Map.Entry<String, JsonElement>> jsonTemplateEntryList = getAndCheckEmbedObject();
        if (jsonTemplateEntryList.size() > 0) {
            for (Map.Entry<String, JsonElement> entry : jsonTemplateEntryList) {
                String key = removeVariableMark(entry.getValue().getAsJsonObject().get(EB_SYS_EMBED_OBJECT).getAsString());
                JsonObject embedJsonObject = entry.getValue().getAsJsonObject();
                if (!valuesMap.containsKey(key) || Strings.isNullOrEmpty(valuesMap.get(key))) {
                    entry.getValue().getAsJsonObject().remove(EB_SYS_EMBED_OBJECT);
                    continue;
                }
                JsonElement jsonValues = JsonParser.parseString(valuesMap.get(key));
                if (jsonValues.isJsonObject()) {
                    for (Map.Entry<String, JsonElement> elementEntry : jsonValues.getAsJsonObject().entrySet()) {
                        embedJsonObject.add(elementEntry.getKey(), elementEntry.getValue());
                    }
                    entry.getValue().getAsJsonObject().remove(EB_SYS_EMBED_OBJECT);
                    jsonObject = entry.getValue().getAsJsonObject();
                }
            }
            return new StringData(sub.replace(jsonObject.toString()));
        }
        return new StringData(sub.replace(outputTemplate));
    }

    private List<Map.Entry<String, JsonElement>> getAndCheckEmbedObject() {
        List<Map.Entry<String, JsonElement>> jsonTemplateEntryList = new ArrayList<>();
        if (!isEmbedObject) {
            return jsonTemplateEntryList;
        }
        JsonElement jsonElement = JsonParser.parseString(outputTemplate);
        Deque<Map.Entry<String, JsonElement>> deque = new ArrayDeque<>(jsonElement.getAsJsonObject().entrySet());
        while (!deque.isEmpty()) {
            Map.Entry<String, JsonElement> elementEntry = deque.pop();
            if (elementEntry.getKey().equals(EB_SYS_EMBED_OBJECT)) {
                Map.Entry<String, JsonElement> entry = new Map.Entry<String, JsonElement>() {
                    @Override
                    public String getKey() {
                        return EB_SYS_ROOT;
                    }

                    @Override
                    public JsonElement getValue() {
                        return jsonElement;
                    }

                    @Override
                    public JsonElement setValue(JsonElement value) {
                        return value;
                    }
                };
                jsonTemplateEntryList.add(entry);
                continue;
            }
            if (elementEntry.getValue().isJsonObject()) {
                if (elementEntry.getValue().getAsJsonObject().get(EB_SYS_EMBED_OBJECT) != null) {
                    jsonTemplateEntryList.add(elementEntry);
                } else {
                    deque.addAll(elementEntry.getValue().getAsJsonObject().entrySet());
                }
            }
        }
        log.debug("EB_SYS_EMBED_OBJECT list size is " + jsonTemplateEntryList.size());
        return jsonTemplateEntryList;
    }

    public String removeVariableMark(String key) {
        return key.substring(2, key.length() - 1);
    }

    public String addVariableMark(String key) {
        return "${" + key + "}";
    }
}
