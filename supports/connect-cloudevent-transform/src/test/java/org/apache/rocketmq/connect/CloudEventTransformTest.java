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
import io.openmessaging.KeyValue;
import io.openmessaging.connector.api.data.ConnectRecord;
import io.openmessaging.internal.DefaultKeyValue;
import org.apache.rocketmq.connect.transform.eventbridge.CloudEventTransform;
import org.junit.Assert;
import org.junit.Test;

public class CloudEventTransformTest {

    @Test
    public void doTransform() {
        KeyValue keyValue = new DefaultKeyValue();
        keyValue.put("id", "{\"value\":\"$.data.id\",\"form\":\"JSONPATH\"}");
        keyValue.put("data", "{\"value\":\"$.data\",\"form\":\"JSONPATH\"}");
        keyValue.put("source", "{\"value\":\"$.data.source\",\"form\":\"JSONPATH\"}");
        keyValue.put("subject", "{\"value\":\"$.data.subject\",\"form\":\"JSONPATH\"}");
        keyValue.put("type", "{\"value\":\"$.type\",\"form\":\"JSONPATH\"}");
        CloudEventTransform cloudEventTransform = new CloudEventTransform();
        cloudEventTransform.init(keyValue);

        ConnectRecord record = new ConnectRecord(null, null, System.currentTimeMillis());
        record.addExtension("type", "type");
        Map<String, Object> data = Maps.newHashMap();
        data.put("source", "source");
        data.put("subject", "subject");
        record.setData(data);

        ConnectRecord result = cloudEventTransform.doTransform(record);

        Assert.assertEquals(result.getData(), record.getData());
        Assert.assertEquals(result.getExtension("source"), "source");
        Assert.assertEquals(result.getExtension("subject"), "subject");
        Assert.assertEquals(result.getExtension("type"), "type");
    }
}