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

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.reflect.TypeToken;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import net.minidev.json.JSONObject;
import org.apache.rocketmq.eventbridge.exception.EventBridgeException;
import org.junit.Test;

public class UpdateFieldTransformTest {

    List<Variable> fieldList = new ArrayList<>();

    @Test
    public void getFieldList() {
        String jsonList = "[{\"field\":\"$.number\",\"value\":\"666666\"}, {\"field\":\"$.data.tag\",\"value\":\"ame\"}]";
        JsonElement jsonElement = JsonUtil.parseJsonElement(jsonList);
        for (JsonElement element : jsonElement.getAsJsonArray()) {
            fieldList.add(new Variable(element.getAsJsonObject().getAsJsonPrimitive(TransformFieldEnum.FIELD).getAsString(),
                element.getAsJsonObject().getAsJsonPrimitive(TransformFieldEnum.VALUE)));

        }
    }

    @Test
    public void processTest() {
        System.out.println(System.currentTimeMillis());
        getFieldList();
        String data = "{\n" + "  \"text\":\"100\",\n" + "  \"number\":100 \n,     \"data\":{\n" +
            "        \"tag\":\"123\"\n" +
            "    }}";
        Map<String, Object> dataMap = new Gson().fromJson(data, new TypeToken<Map<String, Object>>() {
        }.getType());
        for (Variable v : fieldList) {
            String[] dataList = v.getName().split("\\.");
            System.out.println("dataList is " + Arrays.stream(dataList).collect(Collectors.toList()));
            Map<String, Object> tempMap = dataMap;
            for (int i = 1; i < dataList.length - 1; i++) {
                Object temp = tempMap.get(dataList[i]);
                if (!(temp instanceof Map)) {
                    throw new EventBridgeException(TransformErrorCode.InvalidConfig);
                }
                tempMap = (Map<String, Object>) temp;
            }
            if (tempMap.get(dataList[dataList.length - 1]) == null) {
                throw new EventBridgeException(TransformErrorCode.InvalidConfig);
            }
            tempMap.put(dataList[dataList.length - 1], ((JsonPrimitive) v.getValue()).getAsString());
        }
        String jsonString = JSONObject.toJSONString(dataMap);
        System.out.println(jsonString);
        System.out.println(System.currentTimeMillis());
    }
}
