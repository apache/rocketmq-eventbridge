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

import lombok.Data;

@Data
public class RunnerMetrics {
    // 用于通过水位线计算速率等方法的计算指标
    //队列容量
    private int queueCapacity;
    // 队列容量 (水位)
    private int residentCapacity;
    //Subscriber最小速率
    private int minRate;
    //Subscriber最大速率
    private int maxRate;
    // 用于通过水位线计算速率等方法的计算指标

    // 用于通过批次速率等计算方法的计算指标
    // 订阅数据耗时ms
    private long eventBusProcessingDelay;
    // 当前任务处理ConnectRecord 的数量
    private int eventBusBatchSize;

    // 转换任务耗时ms
    private long eventRuleProcessingDelay;
    // 当前任务处理ConnectRecord 的数量
    private int eventRuleBatchSize;
    // 从队列中获取数据耗时 ms
    private long takeEventRecordDelay;

    // 推送任务耗时ms
    private long eventTargetProcessingDelay;
    // 当前任务处理ConnectRecord 的数量
    private int eventTargetBatchSize;
    // 从队列中获取数据耗时ms
    private long takeTargetRecordDelay;
    // 用于通过批次速率等计算方法的计算指标

}
