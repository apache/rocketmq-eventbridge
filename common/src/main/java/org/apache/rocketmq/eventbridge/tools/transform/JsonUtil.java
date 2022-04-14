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

import java.io.IOException;
import java.io.StringReader;
import java.util.Map;

import com.google.common.collect.Maps;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import org.apache.rocketmq.eventbridge.exception.EventBridgeException;
import org.apache.rocketmq.eventbridge.tools.pattern.InvalidEventPatternException;
import org.apache.rocketmq.eventbridge.tools.pattern.PatternErrorMessages;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JsonUtil {

    private static final TypeAdapter<JsonObject> STRICT_GSON_OBJECT_ADAPTER = new Gson().getAdapter(JsonObject.class);

    protected static Logger logger = LoggerFactory.getLogger(JsonUtil.class);


    /**
     * Parse json with strict way by GSON
     *
     * @param json
     *
     * @return
     */
    public static JsonObject parseStrict(String json) throws EventBridgeException {
        try {
            try (JsonReader reader = new JsonReader(new StringReader(json))) {
                JsonObject result = STRICT_GSON_OBJECT_ADAPTER.read(reader);
                reader.hasNext();
                return result;
            }
        } catch (IOException e) {
            logger.warn("Json is no valid in strict way:" + json, e.fillInStackTrace());
            throw new EventBridgeException(TransformErrorCode.InvalidConfig, e, json);
        }
    }

    /**
     * Parse string to json element
     *
     * @param jsonString
     *
     * @return
     */
    public static JsonElement parseJsonElement(String jsonString) {
        JsonElement element = null;
        try {
            element = new JsonParser().parse(jsonString);
        } catch (JsonSyntaxException e) {
            new EventBridgeException(TransformErrorCode.InvalidConfig, e, jsonString);
        }
        return element;
    }

    /**
     * return true if a json string can be decode to a json object
     *
     * @param jsonString
     *
     * @return
     */
    public static boolean isJsonObject(String jsonString) {
        JsonElement element = null;
        try {
            element = new JsonParser().parse(jsonString);
        } catch (JsonSyntaxException e) {
            return Boolean.FALSE;
        }
        if (element instanceof JsonObject) {
            return Boolean.TRUE;
        } else {
            return Boolean.FALSE;
        }
    }

    /**
     * Build a json string from a key-value pair
     *
     * @param key
     * @param value
     *
     * @return
     */
    public static String buildJsonString(String key, Object value) {
        Map<String, Object> map = Maps.newHashMap();
        map.put(key, value);
        return new Gson().toJson(map);
    }

    /**
     * Return true if input is "{}", else return false
     *
     * @param jsonString
     *
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
