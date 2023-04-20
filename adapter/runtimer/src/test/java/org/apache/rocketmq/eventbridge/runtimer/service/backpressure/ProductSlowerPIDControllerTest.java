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

/**
 * @Description 消费速度比生产速度快时，驻留容量的变化以及生产速度的变化
 */
public class ProductSlowerPIDControllerTest {

    public static void main(String[] args) {
        PIDContextTest pidContextTest = new PIDContextTest();

        //Kp=1,Ki=0.2,kD=0 此处是参考Spark 默认参数
        PIDController pid = new PIDController(5, 0, 0);
        pid.setResidentCapacity(1000);
        pid.setMaxSpeed(20);

        RateEstimatorTest rateEstimatorEventQueue =new RateEstimatorTest(pidContextTest, pid,"eventQueue");
        rateEstimatorEventQueue.start();

        RateEstimatorTest rateEstimatorTargetQueue = new RateEstimatorTest(pidContextTest, pid,"targetQueue");
        rateEstimatorTargetQueue.start();

        new MockEventBusListenerTest(pidContextTest,rateEstimatorEventQueue).start();

        new TransformTest(pidContextTest,rateEstimatorTargetQueue).start();

        new PusherTest(pidContextTest).start();
    }
}
