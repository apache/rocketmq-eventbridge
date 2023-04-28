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
package org.apache.rocketmq.eventbridge.adapter.runtimer.rate;

import lombok.SneakyThrows;
import org.apache.rocketmq.eventbridge.adapter.runtimer.boot.listener.CirculatorContext;

import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;

public class PIDRateEstimator extends AbsRateEstimator {
    private CirculatorContext circulatorContext;

    private volatile long newSpeed;

    private Map<String, BlockingQueue<String>> speedLimiter = new ConcurrentHashMap<>();

    private int residentCapacity;

    public PIDRateEstimator(CirculatorContext circulatorContext, int residentCapacity) {
        this.circulatorContext = circulatorContext;
        this.residentCapacity = residentCapacity;
    }

    @Override
    public String getServiceName() {
        return PIDRateEstimator.class.getSimpleName();
    }

    @Override
    public void run() {
        while (!stopped) {
            long input;
            if ("eventQueue".equals(queueName)) {
                input = circulatorContext.getEventQueue().size();
            } else {
                input = circulatorContext.getTargetQueue().size();
            }

            // double output = pid.compute(input, 10000);
            newSpeed = pid.mappeSpeed(input, 50000, queueName);
            create(newSpeed);
            this.waitForRunning(500);
        }
    }

    public long getNewSpeed() {
        return newSpeed;
    }

    @SneakyThrows
    private void create(String runnerName, long newSpeed) {
        if (newSpeed > 0) {
            speedLimiter.get(runnerName).clear();
        }
        for (int i = 0; i < newSpeed; i++) {
            speedLimiter.get(runnerName).put(i + "");
        }
    }

    @SneakyThrows
    public String acquire(String runnerName) {
        return speedLimiter.get(runnerName).take();
    }
}
