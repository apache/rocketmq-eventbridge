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

import com.google.common.collect.Lists;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import org.apache.rocketmq.eventbridge.exception.EventBridgeException;

import static org.apache.rocketmq.eventbridge.tools.transform.Transform.DEFAULT_VALUE_NAME;

/**
 * ALL:[{"name":"SYS_DEFAULT","valueFromJsonPath":"$"}] JSON_PATH:[{"name":"SYS_DEFAULT","valueFromJsonPath":"$.data.template"}]
 * CONSTANT:[{"name":"SYS_DEFAULT","value":"I am a constant value!"}] TEMPLATE:[ {"name":"k1","valueFromJsonPath":"$.data.v1"},
 * {"name":"k2","valueFromJsonPath":"$.data.v2"} ]
 */
public class JsonPathExtract implements Extract {

    protected List<JsonPathElement> extractList = null;

    public List<JsonPathElement> getExtractList() {
        return extractList;
    }

    public JsonPathExtract(String extractJson) throws EventBridgeException {
        List<JsonPathElement> jsonPathElementList = Lists.newArrayList();
        JsonObject jsonObject = JsonUtil.parseStrict(extractJson);
        Set<Entry<String, JsonElement>> elementSet = jsonObject.entrySet();
        for (Entry<String, JsonElement> entry : elementSet) {
            String name = entry.getKey();
            JsonElement value = entry.getValue();
            if (!value.isJsonPrimitive()) {
                throw new EventBridgeException(TransformErrorCode.InvalidConfig, extractJson);
            }
            jsonPathElementList.add(new JsonPathElement(value.getAsString(), name));
        }

        this.extractList = jsonPathElementList;
    }

    @Override
    public List<Variable> parse(Data data) throws EventBridgeException {
        List<Variable> variableList = null;
        if ((data instanceof StringData) && StringType.JSON.equals(((StringData) data).getType())) {
            variableList = parseJsonString((StringData) data);
        }
        return variableList;
    }

    /**
     * parse variable list  from Json String data
     *
     * @param stringData
     * @return
     */
    public List<Variable> parseJsonString(StringData stringData) throws EventBridgeException {
        if (extractList == null || extractList.isEmpty()) {
            return Lists.newArrayListWithCapacity(0);
        }
        List<Variable> variableList = Lists.newArrayListWithCapacity(extractList.size());
        for (JsonPathElement element : extractList) {
            if (JsonPathUtil.isValidAndDefinite(element.getJsonPath())) {
                variableList.add(new Variable(element.getVariableName(),
                    JsonPathUtil.readJsonPathValue(stringData.getData(), element.getJsonPath())));
            } else {
                variableList.add(new Variable(element.getVariableName(), element.getJsonPath()));
            }

        }
        return variableList;
    }

    public class JsonPathElement {
        private String jsonPath;

        private String variableName;

        public JsonPathElement(String jsonPath) {
            this.jsonPath = jsonPath;
            this.variableName = DEFAULT_VALUE_NAME;
        }

        public JsonPathElement(String jsonPath, String variableName) {
            this.jsonPath = jsonPath;
            this.variableName = variableName;
        }

        public String getJsonPath() {
            return jsonPath;
        }

        public String getVariableName() {
            return variableName;
        }
    }
}
