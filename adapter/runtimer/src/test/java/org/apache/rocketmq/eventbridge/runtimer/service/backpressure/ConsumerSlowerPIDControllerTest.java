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
 * @Description 模拟消费速度比生产速度慢时，驻留容量的变化以及生产速度的变化
 */
public class ConsumerSlowerPIDControllerTest {

    public static void main(String[] args) {
        PIDContextTest pidContextTest = new PIDContextTest();

        //Kp=1,Ki=0.2,kD=0 此处是参考Spark 默认参数
        PIDController pidEventQueue = new PIDController(1, 0.008, 0);
        // 队列驻留数据条数
        pidEventQueue.setResidentCapacity(300);
        // 最大生产速度
        pidEventQueue.setMaxSpeed(100);

        // TargetQueue反压计算参数
        PIDController pidTargetQueue = new PIDController(1, 0.008, 0);
        // 队列驻留数据条数
        pidTargetQueue.setResidentCapacity(300);
        pidTargetQueue.setMaxSpeed(100);

        // TargetQueue反压估算器
        RateEstimatorTest rateEstimatorEventQueue =new RateEstimatorTest(pidContextTest, pidEventQueue,"eventQueue");
        rateEstimatorEventQueue.start();

        RateEstimatorTest rateEstimatorTargetQueue = new RateEstimatorTest(pidContextTest, pidTargetQueue,"targetQueue");
        rateEstimatorTargetQueue.start();

        // 生产者，模拟从队列获取消息
        new MockEventBusListenerTest(pidContextTest,rateEstimatorEventQueue).start();

        // 转换器，模拟将eventrecord转换成pusherrecord
        new TransformTest(pidContextTest,rateEstimatorTargetQueue).start();

        // 模拟消费者
        new PusherTest(pidContextTest).start();
    }
}
