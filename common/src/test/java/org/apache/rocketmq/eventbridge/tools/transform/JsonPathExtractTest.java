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

import java.text.MessageFormat;
import org.apache.rocketmq.eventbridge.exception.EventBridgeException;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class JsonPathExtractTest {

    private static final String INVALID_JSON_EMPTY_QUOTES = "{\n" + "\"title\" : $.data.title,\n"
        + " \"content\": $.data.content\n" + "}";

    private static final String WRONG_STRUCT_SINGLE_LEVEL = "jsonString";

    private static final String WRONG_STRUCT_MULTI_LEVEL = "{\n" + "    \"title\":\"$.data.title\",\n"
        + "    \"content\":\"$.data.content\",\n" + "    \"a\":{\n" + "        \"b\":\"abc\"\n" + "    }\n" + "}";

    private static final String RIGHT_STRUCT_JSON = "{\n" + "    \"title\":\"$.data.title\",\n"
        + "    \"content\":\"$.data.content\"\n" + "}";

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void testInvalidEmptyQuotes() throws EventBridgeException {
        thrown.expect(EventBridgeException.class);
        thrown.expectMessage(
            MessageFormat.format(TransformErrorCode.InvalidConfig.getMsg(), INVALID_JSON_EMPTY_QUOTES));
        new JsonPathExtract(INVALID_JSON_EMPTY_QUOTES);
    }

    @Test
    public void testWrongStructSingleLevel() throws EventBridgeException {
        thrown.expect(EventBridgeException.class);
        thrown.expectMessage(
            MessageFormat.format(TransformErrorCode.InvalidConfig.getMsg(), WRONG_STRUCT_SINGLE_LEVEL));
        new JsonPathExtract(WRONG_STRUCT_SINGLE_LEVEL);

    }

    @Test
    public void testWrongStructMultiLevel() throws EventBridgeException {
        thrown.expect(EventBridgeException.class);
        thrown.expectMessage(
            MessageFormat.format(TransformErrorCode.InvalidConfig.getMsg(), WRONG_STRUCT_MULTI_LEVEL));
        new JsonPathExtract(WRONG_STRUCT_MULTI_LEVEL);
    }

    @Test
    public void testRightStructJson() throws EventBridgeException {
        Assert.assertEquals(2, new JsonPathExtract(RIGHT_STRUCT_JSON).getExtractList()
            .size());
    }

}
