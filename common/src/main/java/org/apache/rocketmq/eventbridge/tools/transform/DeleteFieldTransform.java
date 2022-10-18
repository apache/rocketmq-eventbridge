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
import com.google.gson.reflect.TypeToken;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import net.minidev.json.JSONObject;
import org.apache.rocketmq.eventbridge.exception.EventBridgeException;

public class DeleteFieldTransform implements Transform {

    List<String> fieldList = new ArrayList<>();

    public DeleteFieldTransform(String extractJsonList) throws EventBridgeException {
        JsonElement jsonElement = JsonUtil.parseJsonElement(extractJsonList);
        for (JsonElement element : jsonElement.getAsJsonArray()) {
            fieldList.add(element.getAsJsonObject().getAsJsonPrimitive(TransformFieldEnum.FIELD).getAsString());
        }
    }

    @Override
    public Data process(Data inputData) throws EventBridgeException {
        Map<String, Object> dataMap = new Gson().fromJson(inputData.toString(),
            new TypeToken<Map<String, Object>>() {
            }.getType());
        for (String field : fieldList) {
            String[] dataList = field.split("\\.");
            Map<String, Object> tempMap = dataMap;
            for (int i = 1; i < dataList.length - 1; i++) {
                Object temp = tempMap.get(dataList[i]);
                if (!(temp instanceof Map)) {
                    throw new EventBridgeException(TransformErrorCode.InvalidConfig);
                }
                tempMap = (Map<String, Object>) temp;
            }
            tempMap.remove(dataList[dataList.length - 1]);
        }
        String jsonString = JSONObject.toJSONString(dataMap);
        return new StringData(jsonString);
    }

}
