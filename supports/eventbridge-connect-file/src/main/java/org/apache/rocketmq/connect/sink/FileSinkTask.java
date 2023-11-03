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

import io.openmessaging.KeyValue;
import io.openmessaging.connector.api.component.task.sink.SinkTask;
import io.openmessaging.connector.api.data.ConnectRecord;
import io.openmessaging.connector.api.errors.ConnectException;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class FileSinkTask extends SinkTask {
    private String fileName = System.getProperty("user.home") + "/demo";
    private PrintStream outputStream;

    @Override public void put(List<ConnectRecord> sinkRecords) throws ConnectException {
        if (sinkRecords == null || sinkRecords.isEmpty()) {
            return;
        }
        for (ConnectRecord connectRecord : sinkRecords) {
            try {
                outputStream.println(connectRecord.getData());
            } catch (Throwable e) {
                throw new ConnectException("Write record to file failed.", e);
            }
        }
        outputStream.flush();

    }

    @Override public void pause() {

    }

    @Override public void resume() {

    }

    @Override public void validate(KeyValue config) {

    }

    @Override public void init(KeyValue config) {
        String inputFileName = config.getString(FileConstant.FILE_NAME);
        if (inputFileName != null) {
            fileName = inputFileName;
        }
        try {

            outputStream = new PrintStream(
                Files.newOutputStream(Paths.get(fileName), StandardOpenOption.CREATE, StandardOpenOption.APPEND),
                false,
                StandardCharsets.UTF_8.name());
        } catch (IOException e) {
            throw new ConnectException("Create outputStream: " + fileName + " for FileSinkTask failed", e);
        }

    }

    @Override public void stop() {
        if (outputStream != null) {
            outputStream.close();
        }
    }
}