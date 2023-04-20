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

import com.google.common.util.concurrent.RateLimiter;
import lombok.SneakyThrows;
import org.apache.rocketmq.eventbridge.adapter.runtimer.common.ServiceThread;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class RateEstimatorTest extends ServiceThread {
    private PIDContextTest pidContextTest;

    private PIDController pid;  // PID控制器

    private volatile long newSpeed;
    private volatile RateLimiter rateLimiter;

    private BlockingQueue<String> speedLimiter = new LinkedBlockingQueue<>(300);

    private String queueName;

    public RateEstimatorTest(PIDContextTest pidContextTest, PIDController pid, String queueName) {
        this.pidContextTest = pidContextTest;
        this.pid = pid;
        this.queueName = queueName;
        rateLimiter = RateLimiter.create(1);
    }

    @Override
    public String getServiceName() {
        return MockEventBusListenerTest.class.getSimpleName();
    }

    @Override
    public void run() {
        while (!stopped) {
            long input;
            if ("eventQueue".equals(queueName)) {
                input = pidContextTest.getEventQueue().size();
            } else {
                input = pidContextTest.getTargetQueue().size();
            }

            // double output = pid.compute(input, 10000);
            newSpeed = pid.mappeSpeed(input, 50000, queueName);
            rateLimiter = RateLimiter.create((newSpeed > 0) ? newSpeed : 1);
            create(newSpeed);
            this.waitForRunning(500);
        }
    }

    public long getNewSpeed() {
        return newSpeed;
    }

    public double acquire(int permits) {
        return rateLimiter.acquire(permits);
    }

    @SneakyThrows
    private void create(long newSpeed) {
        if (newSpeed > 0) {
            speedLimiter.clear();
        }
        for (int i = 0; i < newSpeed; i++) {
            speedLimiter.put(i + "");
        }
    }

    @SneakyThrows
    public String acquire() {
        return speedLimiter.take();
    }
}
