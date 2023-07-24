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

import java.io.*;
import java.util.TimerTask;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/**
 * 整条链路
 */
public class EventTPSCommon extends AbstractEventCommon {

    private static final Logger logger = LoggerFactory.getLogger(EventTPSCommon.class);

    public static void main(String[] args) {
        String filePath = System.getProperty("user.home") + "/demo";
        if (args.length > 0) {
            filePath = args[0];
        }
        EventTPSCommon tpsCommon = null;
        try {
            tpsCommon = new EventTPSCommon(filePath);
            tpsCommon.start();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public EventTPSCommon(String filePath) throws FileNotFoundException {
        init(filePath);
    }

    private void init(String filePath) throws FileNotFoundException {
        file = new File(filePath);
        lineNumberReader = new LineNumberReader(new FileReader(file));
        previousRowCount = new AtomicReference<>();
        previousRowCount.set(0);
        executorService = new ScheduledThreadPoolExecutor(1,
                new BasicThreadFactory.Builder().namingPattern("BenchmarkTimerThread-all-%d").build());

    }

    @Override
    public void start() {
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