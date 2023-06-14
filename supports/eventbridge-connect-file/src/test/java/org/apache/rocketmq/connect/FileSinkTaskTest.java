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

package org.apache.rocketmq.connect;

import io.openmessaging.KeyValue;
import io.openmessaging.connector.api.data.ConnectRecord;
import io.openmessaging.internal.DefaultKeyValue;
import java.util.ArrayList;
import java.util.List;
import org.apache.rocketmq.connect.sink.FileSinkTask;

public class FileSinkTaskTest {
    public static void main(String[] args) {
        FileSinkTask fileSinkTask = new FileSinkTask();
        KeyValue config = new DefaultKeyValue();
        fileSinkTask.init(config);
        List<ConnectRecord> sinkRecords = new ArrayList<>();
        ConnectRecord  connectRecord= new ConnectRecord(null,null,null);
        connectRecord.setData("test");
        sinkRecords.add(connectRecord);
        fileSinkTask.put(sinkRecords);
        fileSinkTask.stop();
    }
}