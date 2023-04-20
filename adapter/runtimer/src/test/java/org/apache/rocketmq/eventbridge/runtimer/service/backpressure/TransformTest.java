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

import org.apache.rocketmq.eventbridge.adapter.runtimer.common.ServiceThread;

import java.text.SimpleDateFormat;
import java.util.Objects;

public class TransformTest extends ServiceThread {
    private PIDContextTest pidContextTest;
    private RateEstimatorTest rateEstimatorTest;

    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public TransformTest(PIDContextTest pidContextTest, RateEstimatorTest rateEstimatorTest) {
        this.pidContextTest = pidContextTest;
        this.rateEstimatorTest = rateEstimatorTest;
    }

    @Override
    public String getServiceName() {
        return TransformTest.class.getSimpleName();
    }

    @Override
    public void run() {
        while (!stopped) {
            try {
                String a = pidContextTest.getEventQueue().take();
                if (Objects.isNull(a)) {
                    this.waitForRunning(1000);
                }
                // 模拟有5个转换器
                for (int i = 0; i < 5; i++) {
                    // 通过令牌桶控制速度
                    rateEstimatorTest.acquire(1);
                    // 通过阻塞队列控制速度
                    // rateEstimatorTest.acquire();
                    pidContextTest.getTargetQueue().put(a);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}