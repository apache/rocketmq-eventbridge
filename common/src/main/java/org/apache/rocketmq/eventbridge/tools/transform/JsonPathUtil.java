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

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

import com.google.common.base.Strings;
import com.google.gson.JsonElement;
import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.InvalidPathException;
import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.ParseContext;
import com.jayway.jsonpath.PathNotFoundException;
import com.jayway.jsonpath.ReadContext;
import com.jayway.jsonpath.internal.path.CompiledPath;
import com.jayway.jsonpath.internal.path.PathCompiler;
import com.jayway.jsonpath.spi.json.GsonJsonProvider;
import org.apache.rocketmq.eventbridge.exception.EventBridgeException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JsonPathUtil {

    public static final String JSONPATH_SPLIT = "\\.";
    public static final String JSONPATH_PREFIX = "$";
    public static final String JSONPATH_PREFIX_WITH_POINT = "$.";
    public static final String JSONPATH_DATA = "$.data";

    private static final ParseContext PARSE_CONTEXT = JsonPath.using(Configuration.builder()
        .jsonProvider(new GsonJsonProvider())
        .build());

    private static final Logger logger = LoggerFactory.getLogger(JsonPathUtil.class);

    public static String removeDataOfJsonPath(String jsonPath) {
        if (!jsonPath.startsWith(JSONPATH_DATA)) {
            return null;
        }
        return JSONPATH_PREFIX + jsonPath.substring(JSONPATH_DATA.length(), jsonPath.length());
    }

    /**
     * return true , if the jsonpath is definite which current system support.
     *
     * @param jsonPath
     *
     * @return
     */
    public static boolean isValidAndDefinite(String jsonPath) {
        if (Strings.isNullOrEmpty(jsonPath) || !jsonPath.startsWith(JSONPATH_PREFIX)) {
            return Boolean.FALSE;
        }
        CompiledPath compiledPath = null;
        try {
            compiledPath = (CompiledPath)PathCompiler.compile(jsonPath);
        } catch (InvalidPathException e) {
            return Boolean.FALSE;
        }
        return compiledPath.isDefinite();
    }

    /**
     * read the json path value by the index
     *
     * @param
     *
     * @return
     */
    public static String readJsonPathByIndex(String jsonPath, int index) throws EventBridgeException {
        if (!JsonPathUtil.isValidAndDefinite(jsonPath)) {
            throw new EventBridgeException(TransformErrorCode.InvalidConfig, jsonPath);
        }
        String subPath = jsonPath.substring(2, jsonPath.length());
        String[] paths = subPath.split(JSONPATH_SPLIT);
        if (paths.length <= index) {
            throw new EventBridgeException(TransformErrorCode.InvalidConfig, jsonPath);
        }
        return paths[index];
    }

    /**
     * read the json path value by the start index
     *
     * @param
     *
     * @return
     */
    public static String readJsonPath(String jsonPath, int startIndex) throws EventBridgeException {
        if (!JsonPathUtil.isValidAndDefinite(jsonPath)) {
            throw new EventBridgeException(TransformErrorCode.InvalidConfig, jsonPath);
        }
        String subPath = jsonPath.substring(2, jsonPath.length());
        String[] paths = subPath.split(JSONPATH_SPLIT);
        if (paths.length <= startIndex) {
            throw new EventBridgeException(TransformErrorCode.InvalidConfig, jsonPath);
        }
        StringBuffer buffer = new StringBuffer("$");
        for (; startIndex < paths.length; startIndex++) {
            buffer.append("." + paths[startIndex]);
        }
        return buffer.toString();
    }

    /**
     * read the json path value from the json String
     *
     * @param
     *
     * @return
     */
    public static String readJsonPathValue(String jsonString, String jsonPath) throws EventBridgeException {
        if (Strings.isNullOrEmpty(jsonString) || Strings.isNullOrEmpty(jsonPath)) {
            throw new EventBridgeException(TransformErrorCode.InvalidConfig, jsonPath);
        }
        ReadContext jsonContext = PARSE_CONTEXT.parse(jsonString);
        JsonElement element = null;
        try {
            element = jsonContext.read(jsonPath);
        } catch (PathNotFoundException foundException) {
            //return "";
            return null;
        } catch (InvalidPathException invalidPathException) {
            logger.warn("Invalid json path:" + jsonPath, invalidPathException);
            return jsonPath;
        }
        if (element.isJsonPrimitive()) {
            return element.getAsString();
        } else {
            return element.toString();
        }
    }

    /**
     * return  the length of json path.
     * If it is not valid json path, return -1.
     *
     * @param
     *
     * @return
     */
    public static int jsonPathLength(String jsonPath) {
        if (!JsonPathUtil.isValidAndDefinite(jsonPath)) {
            return -1;
        }
        String subPath = jsonPath.substring(2);
        String[] paths = subPath.split(JSONPATH_SPLIT);
        AtomicInteger length = new AtomicInteger();
        Arrays.stream(paths)
            .forEach(path -> {
                if (path.endsWith("]")) {
                    length.set(length.get() + 2);
                } else {
                    length.set(length.get() + 1);
                }
            });
        return length.get();
    }
}
