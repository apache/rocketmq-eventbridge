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

import com.google.common.collect.Maps;
import com.google.gson.Gson;
import io.openmessaging.KeyValue;
import io.openmessaging.connector.api.component.ComponentContext;
import io.openmessaging.connector.api.data.ConnectRecord;
import io.openmessaging.connector.api.data.SchemaBuilder;
import org.apache.rocketmq.eventbridge.tools.transform.*;

import java.util.Map;

public class EventBridgeTransform implements io.openmessaging.connector.api.component.Transform {

    private Map<String, Transform> paramTransform = Maps.newHashMap();

    private static final String DEFAULT_DATA_KEY = "data";

    @Override
    public ConnectRecord doTransform(ConnectRecord record) {
        paramTransform.entrySet()
            .forEach(entry -> {
                Data data = entry.getValue()
                    .process(new ObjectData(record, ConnectRecord.class));
                if (DEFAULT_DATA_KEY.equals(entry.getKey())) {
                    record.setData(((StringData) data).getData());
                    record.setSchema(SchemaBuilder.string()
                        .build());
                } else {
                    record.addExtension(entry.getKey(), ((StringData) data).getData());
                }
            });
        return record;
    }

    @Override
    public void validate(KeyValue config) {

    }

    @Override
    public void init(KeyValue config) {
        config.keySet()
                .forEach(key -> {
                    TransformParam transformParam = new Gson().fromJson(config.getString(key), TransformParam.class);
                    paramTransform.put(key, EventBridgeTransformBuilder.buildTransform(transformParam));
                });
    }

    @Override
    public void start(ComponentContext componentContext) {

    }

    @Override
    public void stop() {

    }
}
