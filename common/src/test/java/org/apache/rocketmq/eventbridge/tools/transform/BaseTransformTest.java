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

public class BaseTransformTest {

    public static final String JSON_EVENT = "{\n" + "    \"specversion\":\"1.0\",\n"
        + "    \"id\":\"51efe8e2-841f-4900-8ff5-3c6dfae1060e\",\n" + "    \"source\":\"acs.oss\",\n"
        + "    \"type\":\"oss:ObjectCreated:PostObject\",\n" + "    \"dataschema\":\"http://taobao.com/test.json\",\n"
        + "    \"subject\":\"acs:oss:cn-hangzhou:1234567:xls-papk/game_apk/123.jpg\",\n"
        + "    \"aliyuneventbusname\":\"demo-bus\",\n" + "    \"data\":{\n" + "        \"null\":null,\n"
        + "        \"text\":\"100\",\n" + "        \"number\":100,\n" + "        \"boolean\":false,\n"
        + "\"cn\":\"中国\",\n" + "        \"array\":[\n" + "            {\n"
        + "                \"level2-1\":\"level2-1\"\n" + "            },\n" + "            {\n"
        + "                \"level2-2\":\"level2-2\"\n" + "            }\n" + "        ]\n" + "    }\n" + "}";

    public static final String JSON_EVENT_DATA = "{\"null\":null,\"text\":\"100\",\"number\":100,\"boolean\":false,"
        + "\"cn\":\"中国\",\"array\":[{\"level2-1\":\"level2-1\"},{\"level2-2\":\"level2-2\"}]}";

}
