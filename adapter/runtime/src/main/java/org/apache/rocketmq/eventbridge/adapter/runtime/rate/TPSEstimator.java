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

import org.springframework.stereotype.Component;

@Component
public class TPSEstimator extends AbsRateEstimator {

    @Override
    public RunnerMetrics compute(EstimateMetrics estimateMetrics) {
        // 发送窗口
        int cwnd = 0;
        // 接收窗
        int rwnd = 0;
        // 慢启动阈值
        int ssthresh = estimateMetrics.getSsthresh();

        int remainingCapacity = estimateMetrics.getWorkerQueueRemainingCapacity();

        // 批次数
        int batchSize = estimateMetrics.getBatchSize();
        // 批次耗费时间
        long costTime = estimateMetrics.getEndTimestamp() - estimateMetrics.getStartTimestamp();

        switch (estimateMetrics.getCommonType()) {
            case TRANS:
                // 本身的转换速度及为推送窗口，此推送窗口被listener用于作为批次数
                cwnd = (int) ((batchSize * 1000) / costTime);
                // pusher的推送窗口为transform 的接收窗口
                rwnd = estimateMetrics.getRwnd();
                break;
            case PUSHER:
                // transform的推送窗口乘以转换器的个数（0=1）为pusher的推送窗口
                cwnd = estimateMetrics.getCwnd();
                // target的TPS为接收窗口 batchSize/per second
                rwnd = (int) ((batchSize * 1000) / costTime);
                break;
        }

        // 是否超时，true超时，false未超时。超时阈值1s
        boolean timeOut = (costTime / 1000) > 1;
        if (estimateMetrics.isError() || (remainingCapacity > 0 && remainingCapacity < 10)) {// 错误或者超时
            cwnd = 1;
            ssthresh = Math.max(2, Math.min(estimateMetrics.getCwnd() / 2, rwnd));
        } else if (cwnd <= ssthresh) {// 慢启动
            cwnd = cwnd * 2;
        } else { //避免拥塞
            cwnd++;
        }

        //
        RunnerMetrics runnerMetrics = new RunnerMetrics();
        runnerMetrics.setRunnerName(estimateMetrics.getRunnerName());
        runnerMetrics.setCwnd(cwnd);
        runnerMetrics.setRwnd(rwnd);
        runnerMetrics.setSsthresh(ssthresh);

        return runnerMetrics;
    }
}
