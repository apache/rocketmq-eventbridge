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
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package org.apache.rocketmq.connect.sink;

import com.google.gson.Gson;
import io.openmessaging.KeyValue;
import io.openmessaging.connector.api.component.task.sink.SinkTask;
import io.openmessaging.connector.api.data.ConnectRecord;
import io.openmessaging.connector.api.errors.ConnectException;
import java.util.List;

public class StandardSinkTask extends SinkTask {

    private String prefix;

    @Override public void put(List<ConnectRecord> sinkRecords) throws ConnectException {
        if (sinkRecords == null || sinkRecords.isEmpty()) {
            return;
        }
        sinkRecords.forEach(sinkRecord -> System.out.println(prefix + ":" + new Gson().toJson(sinkRecord.getData())));
    }

    @Override public void pause() {

    }

    @Override public void resume() {

    }

    @Override public void validate(KeyValue config) {

    }

    @Override public void init(KeyValue config) {
        prefix = config.getString(StandardConstant.STANDARD_PREFIX);
    }

    @Override public void stop() {

    }
}