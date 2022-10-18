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

package org.apache.rocketmq.eventbridge.tools;

import com.google.common.collect.Maps;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSyntaxException;
import java.util.Map;
import org.apache.rocketmq.eventbridge.tools.pattern.InvalidEventPatternException;
import org.apache.rocketmq.eventbridge.tools.pattern.PatternErrorMessages;

public class JsonUtil {

    /**
     * Convert the value of map to json element
     *
     * @param specMap
     * @return
     */
    public static Map<String, JsonElement> convertToJsonElement(Map<String, String> specMap) {
        if (specMap == null || specMap.isEmpty()) {
            return Maps.newHashMap();
        }
        Map<String, JsonElement> result = Maps.newHashMap();
        specMap.entrySet()
            .stream()
            .forEach(entry -> {
                result.put(entry.getKey(), new JsonPrimitive(entry.getValue()));
            });
        return result;
    }

    /**
     * Return true if input is "{}", else return false
     *
     * @param jsonString
     * @return
     */
    public static boolean isEmptyJsonObject(String jsonString) {
        JsonElement element = null;
        try {
            element = new JsonParser().parse(jsonString);
        } catch (JsonSyntaxException e) {
            throw new InvalidEventPatternException(PatternErrorMessages.INVALID_JSON_STRING, e);
        }
        return "{}".equals(element.toString()) ? Boolean.TRUE : Boolean.FALSE;
    }
}
