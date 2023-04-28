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

import org.apache.rocketmq.eventbridge.adapter.runtimer.boot.listener.CirculatorContext;

import java.text.SimpleDateFormat;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class PIDRateEstimator extends AbsRateEstimator {
    private CirculatorContext circulatorContext;

    private BlockingQueue<Integer> eventQueueSpeedLimiter;
    private BlockingQueue<Integer> targetQueueSpeedLimiter;
    private PIDController pid;

    private RunnerMetrics runnerMetrics;

    public PIDRateEstimator(CirculatorContext circulatorContext, RunnerMetrics runnerMetrics) {
        this.circulatorContext = circulatorContext;
        this.runnerMetrics = runnerMetrics;
        eventQueueSpeedLimiter = new LinkedBlockingQueue<>(runnerMetrics.getResidentCapacity());
        targetQueueSpeedLimiter = new LinkedBlockingQueue<>(runnerMetrics.getResidentCapacity());
        //Kp=1,Ki=0.2,kD=0 此处是参考Spark 默认参数
        pid = new PIDController(1, 0.008f, 0, runnerMetrics.getResidentCapacity(), runnerMetrics.getMinRate(), runnerMetrics.getMaxRate());

    }

    @Override
    public String getServiceName() {
        return PIDRateEstimator.class.getSimpleName();
    }

    @Override
    public void run() {
        while (!stopped) {
            int eventQueueInput = circulatorContext.getEventQueue().size();
            int targetQueueInput = circulatorContext.getTargetQueue().size();

            // double output = pid.compute(input, 10000);
            int eventQueueNewSpeed = pid.mappeSpeed(eventQueueInput, runnerMetrics.getQueueCapacity());
            int targetQueueNewSpeed = pid.mappeSpeed(targetQueueInput, runnerMetrics.getQueueCapacity());
            try {
                create(eventQueueNewSpeed, targetQueueNewSpeed);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.waitForRunning(500);
        }
    }

    private void create(int eventQueueNewSpeed, int targetQueueNewSpeed) throws InterruptedException {
        if (eventQueueNewSpeed > 0) {
            eventQueueSpeedLimiter.clear();
        }
        for (int i = 0; i < eventQueueNewSpeed; i++) {
            eventQueueSpeedLimiter.put(i);
        }
        if (targetQueueNewSpeed > 0) {
            targetQueueSpeedLimiter.clear();
        }
        for (int i = 0; i < targetQueueNewSpeed; i++) {
            targetQueueSpeedLimiter.put(i);
        }
    }

    public Integer acquireEventQueueLimiter() throws InterruptedException {
        return eventQueueSpeedLimiter.take();
    }

    public Integer acquireTargetQueueLimiter() throws InterruptedException {
        return targetQueueSpeedLimiter.take();
    }

    private static class PIDController {
        private float Kp;  // 比例系数
        private float Ki;  // 积分系数
        private float Kd;  // 微分系数

        private int residentCapacity;  // 目标值 队列容量
        private int integral;  // 积分累计值
        private int lastError; // 上一次误差值

        // 最小生产速度
        private int minSpeed = 0;
        // 最大生产速度
        private int maxSpeed = 300;

        // 当前速度
        private int currentSpeed = 20;

        // 振幅输出转换成生产速度的缩放因子
        private float speedScalingFactor = 1;

        private volatile static int time = 0;

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        public PIDController(float kp, float ki, float kd, int residentCapacity, int minSpeed, int maxSpeed) {
            Kp = kp;
            Ki = ki;
            Kd = kd;
            this.residentCapacity = residentCapacity;
            this.minSpeed = minSpeed;
            this.maxSpeed = maxSpeed;
        }

        /**
         * PID算法实现
         *
         * @param input         当前队列容量
         * @param queueCapacity 队列最大初始化大小
         * @return
         */
        public int compute(int input, int queueCapacity) {
            int error = residentCapacity - input;

            // 计算积分值
            integral += error;

            // 防止积分值过大或过小
            if (integral > queueCapacity) {
                integral = queueCapacity;
            } else if (integral < -queueCapacity) {
                integral = -queueCapacity;
            }

            // 计算微分值
            int derivative = error - lastError;

            // 计算输出值
            int output = Math.round(Kp * error + Ki * integral + Kd * derivative);

            // 保存上一次误差值
            lastError = error;

            return output;
        }

        /**
         * 将输出振幅映射到速度，此处speedScalingFactor默认为1 直接映射成速度
         *
         * @param input
         * @param queueCapacity
         * @return
         */
        public int mappeSpeed(int input, int queueCapacity) {
            int output = compute(input, queueCapacity);

            int speedIncrement = Math.round(output * speedScalingFactor);  // 根据实际情况调整比例系数，将输出值转换为速度增量
            int newSpeed = currentSpeed + speedIncrement;
            if (newSpeed > maxSpeed) {
                newSpeed = maxSpeed;
            } else if (newSpeed < minSpeed) {
                newSpeed = minSpeed;
            }
//            System.out.printf("data.push([" + (time++) + "," + input + "]); \n");
            //System.out.printf("输出振幅：output=>%s,\t上一次采样生产速度：currentSpeed=>%s,\t下次生产速度：newSpeed=>%s,\t (%s)数据容量：input=>%s,\t\tcurrentTime=>%s \n", output, currentSpeed, newSpeed, queueName, input, simpleDateFormat.format(new Date()));
            currentSpeed = newSpeed;
            return newSpeed;  // 设置新的生产速度
        }
    }
}
