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


package org.apache.rocketmq.connect;

import java.util.Map;

import com.google.common.collect.Maps;
import com.google.gson.Gson;
import io.openmessaging.KeyValue;
import io.openmessaging.connector.api.data.ConnectRecord;
import io.openmessaging.internal.DefaultKeyValue;
import org.apache.rocketmq.connect.transform.eventbridge.EventBridgeTransform;
import org.junit.Assert;
import org.junit.Test;

public class EventBridgeTransformTest {

    @Test
    public void doTransform() {
        KeyValue keyValue = new DefaultKeyValue();
        keyValue.put("data",
            "{\"template\":\"{\\\"text\\\":{\\\"content\\\":\\\"${content}\\\"},\\\"msgtype\\\":\\\"text\\\"}\","
                + "\"form\":\"TEMPLATE\",\"value\":\"{\\\"content\\\":\\\"$.data.body\\\"}\"}");
        EventBridgeTransform eventBridgeTransform = new EventBridgeTransform();
        eventBridgeTransform.init(keyValue);

        ConnectRecord record = new ConnectRecord(null, null, System.currentTimeMillis());
        record.addExtension("type", "type");
        Map<String, Object> data = Maps.newHashMap();
        data.put("body", "demo");
        record.addExtension("token", "xxxxxxx");
        record.setData(data);

        ConnectRecord result = eventBridgeTransform.doTransform(record);
        Assert.assertEquals("{\"text\":{\"content\":\"demo\"},\"msgtype\":\"text\"}", result.getData());
    }
}