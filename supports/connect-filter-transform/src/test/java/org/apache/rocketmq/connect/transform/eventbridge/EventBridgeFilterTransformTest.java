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

package org.apache.rocketmq.connect.transform.eventbridge;

import io.openmessaging.KeyValue;
import io.openmessaging.connector.api.data.ConnectRecord;
import io.openmessaging.internal.DefaultKeyValue;
import org.junit.Assert;
import org.junit.Test;

public class EventBridgeFilterTransformTest {

    @Test
    public void doTransform() {
        EventBridgeFilterTransform transform = new EventBridgeFilterTransform();
        KeyValue keyValue = new DefaultKeyValue();
        keyValue.put("filterPattern", "{\"source\":[\"acs.mns\"]}");
        transform.init(keyValue);

        ConnectRecord record = new ConnectRecord(null, null, System.currentTimeMillis());
        record.addExtension("source", "acs.demo");
        Assert.assertNull(transform.doTransform(record));

        record.addExtension("source", "acs.mns");
        Assert.assertNotNull(transform.doTransform(record));
    }
}