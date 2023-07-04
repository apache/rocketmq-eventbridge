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
package org.apache.rocketmq.eventbridge.adapter.benchmark;

import org.apache.commons.lang3.concurrent.BasicThreadFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.TimerTask;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 整条链路
 */
public class EventAllCommon extends AbstractEventCommon {

    private static final Logger logger = LoggerFactory.getLogger(EventAllCommon.class);

    private String listenerFileName = System.getProperty("user.home") + "/listenerAll.log";

    public EventAllCommon() {
        init();
        start();
    }

    private void init() {
        executorService = new ScheduledThreadPoolExecutor(1,
                new BasicThreadFactory.Builder().namingPattern("BenchmarkTimerThread-all-%d").build());

        try {
            printStream = new PrintStream(
                    Files.newOutputStream(Paths.get(listenerFileName), StandardOpenOption.CREATE, StandardOpenOption.APPEND),
                    false,
                    StandardCharsets.UTF_8.name());
        } catch (IOException e) {
            throw new RuntimeException("Create outputStream: " + listenerFileName + " for FileSinkTask failed", e);
        }
    }

    private void start() {

        executorService.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                try {
                    printStats();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, 1000, 1000, TimeUnit.MILLISECONDS);
    }
}