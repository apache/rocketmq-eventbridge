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
package org.apache.rocketmq.eventbridge.adapter.runtime.rate;

public class RunnerMetrics {

    private String runnerName;

    // 发送窗口
    private volatile int cwnd = 1;
    // 接收窗口
    private volatile int rwnd;
    // 慢启动门限
    private volatile int ssthresh = 20;

    // 速率
    private volatile int rate;

    // take 次数
    private volatile int takeTimes;

    public RunnerMetrics() {
    }

    public RunnerMetrics(String runnerName) {
        this.runnerName = runnerName;
    }

    public RunnerMetrics(String runnerName, int cwnd, int ssthresh) {
        this.runnerName = runnerName;
        this.cwnd = cwnd;
        this.ssthresh = ssthresh;
    }

    public String getRunnerName() {
        return runnerName;
    }

    public void setRunnerName(String runnerName) {
        this.runnerName = runnerName;
    }

    public int getCwnd() {
        return cwnd;
    }

    public void setCwnd(int cwnd) {
        this.cwnd = cwnd;
    }

    public int getRwnd() {
        return rwnd;
    }

    public void setRwnd(int rwnd) {
        this.rwnd = rwnd;
    }

    public int getSsthresh() {
        return ssthresh;
    }

    public void setSsthresh(int ssthresh) {
        this.ssthresh = ssthresh;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public int getTakeTimes() {
        return takeTimes;
    }

    public void setTakeTimes(int takeTimes) {
        this.takeTimes = takeTimes;
    }

}
