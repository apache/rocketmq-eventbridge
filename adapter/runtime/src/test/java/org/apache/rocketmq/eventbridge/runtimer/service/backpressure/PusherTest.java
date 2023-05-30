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
package org.apache.rocketmq.eventbridge.runtimer.service.backpressure;

import org.apache.rocketmq.eventbridge.adapter.runtime.common.ServiceThread;

import java.text.SimpleDateFormat;
import java.util.Objects;
import java.util.Random;

public class PusherTest extends ServiceThread {
    private PIDContextTest pidContextTest;

    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public PusherTest(PIDContextTest pidContextTest) {
        this.pidContextTest = pidContextTest;
    }

    @Override
    public String getServiceName() {
        return PusherTest.class.getSimpleName();
    }

    Random random = new Random();

    @Override
    public void run() {
        while (!stopped) {
            try {
                if (!pidContextTest.canExecute()) {
                    this.waitForRunning(1000);
                }
                String a = pidContextTest.getTargetQueue().take();
                // System.out.printf("处理信息：a=>%s,\t当前队列数据容量：input=>%s,\t\tcurrentTime=>%s \n", a, pidContextTest.getTargetQueue().size(), simpleDateFormat.format(new Date()));
                if (Objects.isNull(a)) {
                    this.waitForRunning(random.nextInt(1000));
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            pidContextTest.getThreadPoolExecutor().execute(() -> {
                // 当下游消费速度在一定范围波动时
                 this.waitForRunning(random.nextInt(100) + 100);
            });
        }
    }
}