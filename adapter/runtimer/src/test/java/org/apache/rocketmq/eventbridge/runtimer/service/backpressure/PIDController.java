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

import java.text.SimpleDateFormat;

/**
 * @Description 　　
 * 　　(1)增大比例系数Kp一般将加快系统的响应，在有静差的情况下有利于减小静差。但过大的比例系数会使系统有较大的超调，并产生振荡，使系统的稳定性变坏；
 * 　　(2)增大积分时间TI一般有利于减小超调，减小振荡，使系统更加稳定，但系统静差的消除将随之减慢；
 * 　　(3)增大微分时间TD亦有利于加快系统的响应，减小振荡，使系统稳定性增加，但系统对干扰的抑制能力减弱，对扰动有较敏感的响应；另外，过大的微分系数也将使系统的稳定性变坏。
 */
public class PIDController {
    private double Kp;  // 比例系数
    private double Ki;  // 积分系数
    private double Kd;  // 微分系数

    private long residentCapacity;  // 目标值 队列容量
    private long integral;  // 积分累计值
    private long lastError; // 上一次误差值

    // 最小生产速度
    private long minSpeed = 1;
    // 最大生产速度
    private long maxSpeed = 300;

    // 当前速度
    private long currentSpeed = 20;

    // 振幅输出转换成生产速度的缩放因子
    private double speedScalingFactor = 1;

    private volatile static int time = 0;

    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public PIDController(double Kp, double Ki, double Kd) {
        this.Kp = Kp;
        this.Ki = Ki;
        this.Kd = Kd;
    }

    public long getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(long maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public long getResidentCapacity() {
        return residentCapacity;
    }

    public void setResidentCapacity(long residentCapacity) {
        this.residentCapacity = residentCapacity;
    }

    /**
     * PID算法实现
     *
     * @param input         当前队列容量
     * @param queueCapacity 队列最大初始化大小
     * @return
     */
    public long compute(long input, long queueCapacity) {
        long error = residentCapacity - input;

        // 计算积分值
        integral += error;

        // 防止积分值过大或过小
        if (integral > queueCapacity) {
            integral = queueCapacity;
        } else if (integral < -queueCapacity) {
            integral = -queueCapacity;
        }

        // 计算微分值
        long derivative = error - lastError;

        // 计算输出值
        long output = Math.round(Kp * error + Ki * integral + Kd * derivative);

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
    public long mappeSpeed(long input, long queueCapacity, String queueName) {
        long output = compute(input, queueCapacity);

        long speedIncrement = Math.round(output * speedScalingFactor);  // 根据实际情况调整比例系数，将输出值转换为速度增量
        long newSpeed = currentSpeed + speedIncrement;
        if (newSpeed > maxSpeed) {
            newSpeed = maxSpeed;
        } else if (newSpeed < minSpeed) {
            newSpeed = minSpeed;
        }
        if ("targetQueue".equals(queueName))
            System.out.printf("data.push([" + (time++) + "," + input + "]); \n");
        //System.out.printf("输出振幅：output=>%s,\t上一次采样生产速度：currentSpeed=>%s,\t下次生产速度：newSpeed=>%s,\t (%s)数据容量：input=>%s,\t\tcurrentTime=>%s \n", output, currentSpeed, newSpeed, queueName, input, simpleDateFormat.format(new Date()));
        currentSpeed = newSpeed;
        return newSpeed;  // 设置新的生产速度
    }
}
