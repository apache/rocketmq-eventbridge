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

import java.util.UUID;

public class MockEventBusListenerTest extends ServiceThread {
    private PIDContextTest pidContextTest;
    private RateEstimatorTest rateEstimatorTest;

    public MockEventBusListenerTest(PIDContextTest pidContextTest, RateEstimatorTest rateEstimatorTest) {
        this.pidContextTest = pidContextTest;
        this.rateEstimatorTest = rateEstimatorTest;
    }

    @Override
    public String getServiceName() {
        return RateEstimatorTest.class.getSimpleName();
    }

    @Override
    public void run() {
        while (!stopped) {
            // 用于控制速度。例如计算得到速度为20条/s，令牌桶设置为20。需要1秒生成20个，每次拿一个，拿20次拿完即止，等待下一次采样
            if (rateEstimatorTest.getNewSpeed() == 0) {
                this.waitForRunning(300);
            }
            // 通过阻塞队列控制速度
            rateEstimatorTest.acquire();
            try {
                pidContextTest.getEventQueue().put(UUID.randomUUID().toString());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
