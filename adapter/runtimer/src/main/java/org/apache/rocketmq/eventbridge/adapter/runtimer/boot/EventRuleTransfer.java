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

package org.apache.rocketmq.eventbridge.adapter.runtimer.boot;

import com.alibaba.fastjson.JSON;
import io.openmessaging.connector.api.data.ConnectRecord;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.apache.rocketmq.eventbridge.adapter.runtimer.boot.listener.ListenerFactory;
import org.apache.rocketmq.eventbridge.adapter.runtimer.boot.listener.TargetRunnerListener;
import org.apache.rocketmq.eventbridge.adapter.runtimer.boot.transfer.TransformEngine;
import org.apache.rocketmq.eventbridge.adapter.runtimer.common.ServiceThread;
import org.apache.rocketmq.eventbridge.adapter.runtimer.common.entity.TargetKeyValue;
import org.apache.rocketmq.eventbridge.adapter.runtimer.common.entity.TargetRunnerConfig;
import org.apache.rocketmq.eventbridge.adapter.runtimer.common.plugin.Plugin;
import org.apache.rocketmq.eventbridge.adapter.runtimer.service.TargetRunnerConfigObserver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * receive event and transfer the rule to pusher
 */
public class EventRuleTransfer extends ServiceThread implements TargetRunnerListener {

    private static final Logger logger = LoggerFactory.getLogger(EventRuleTransfer.class);

    private ListenerFactory listenerFactory;

    private TargetRunnerConfigObserver targetRunnerConfigObserver;

    private Plugin plugin;

    Map<TargetKeyValue/*taskConfig*/, TransformEngine<ConnectRecord>/*taskTransform*/> taskTransformMap = new ConcurrentHashMap<>(20);

    private ExecutorService executorService = new ThreadPoolExecutor(20, 60, 1000, TimeUnit.MICROSECONDS, new LinkedBlockingDeque<>(100));

    public EventRuleTransfer(Plugin plugin, ListenerFactory listenerFactory,
        TargetRunnerConfigObserver targetRunnerConfigObserver) {
        this.plugin = plugin;
        this.listenerFactory = listenerFactory;
        this.targetRunnerConfigObserver = targetRunnerConfigObserver;
        this.targetRunnerConfigObserver.registerListener(this);
    }

    public void initOrUpdateTaskTransform(Map<String, List<TargetKeyValue>> taskConfig) {
        this.taskTransformMap.putAll(initSinkTaskTransformInfo(taskConfig));
    }

    @Override
    public String getServiceName() {
        return this.getClass().getSimpleName();
    }

    @Override
    public void run() {
        while (!stopped) {
            ConnectRecord eventRecord = listenerFactory.takeEventRecord();
            if (Objects.isNull(eventRecord)) {
                logger.info("listen eventRecord is empty, continue by curTime - {}", System.currentTimeMillis());
                this.waitForRunning(1000);
                continue;
            }
            executorService.submit(() -> {
                // extension add sub
                // rule - target
                for (TargetKeyValue targetKeyValue : taskTransformMap.keySet()) {
                    // add threadPool for cup task
                    // attention coreSize
                    TransformEngine<ConnectRecord> transformEngine = taskTransformMap.get(targetKeyValue);
                    ConnectRecord transformRecord = transformEngine.doTransforms(eventRecord);
                    if (Objects.isNull(transformRecord)) {
                        continue;
                    }
                    // a bean for maintain
                    Map<TargetKeyValue, ConnectRecord> targetMap = new HashMap<>();
                    targetMap.put(targetKeyValue, transformRecord);
                    listenerFactory.offerTargetTaskQueue(targetMap);

                    logger.debug("offer target task queue succeed, targetMap - {}", JSON.toJSONString(targetMap));
                    // metrics
                    // logger
                    // key->connectKeyValue to simple name
                    // connectRecord add system properties for taskClass info
                }
            });
        }
    }

    /**
     * Init sink task transform map key: task config value: transformEngine
     *
     * @param taskConfig
     * @return
     */
    private Map<TargetKeyValue, TransformEngine<ConnectRecord>> initSinkTaskTransformInfo(
        Map<String, List<TargetKeyValue>> taskConfig) {
        Map<TargetKeyValue, TransformEngine<ConnectRecord>> curTaskTransformMap = new HashMap<>();
        Set<TargetKeyValue> allTaskKeySet = new HashSet<>();
        for (String connectName : taskConfig.keySet()) {
            List<TargetKeyValue> taskKeyList = taskConfig.get(connectName);
            allTaskKeySet.addAll(new HashSet<>(taskKeyList));
        }
        for (TargetKeyValue keyValue : allTaskKeySet) {
            TransformEngine<ConnectRecord> transformChain = new TransformEngine<>(keyValue, plugin);
            curTaskTransformMap.put(keyValue, transformChain);
        }
        logger.info("init sink task transform info succeed, transform map - {}", JSON.toJSONString(curTaskTransformMap));
        return curTaskTransformMap;
    }

    /**
     * transform update listener
     */
    @Override
    public void onAddTargetRunner(TargetRunnerConfig targetRunnerConfig) {
        logger.info("transform update by new target config changed, target info -{}", JSON.toJSONString(targetRunnerConfig));
        Map<String, List<TargetKeyValue>> lastTargetMap = new HashMap<>();
        lastTargetMap.put(targetRunnerConfig.getConnectName(), targetRunnerConfig.getTargetKeyValues());
        initOrUpdateTaskTransform(lastTargetMap);
    }

    @Override
    public void onUpdateTargetRunner(TargetRunnerConfig targetRunnerConfig) {
    }

    @Override
    public void onDeleteTargetRunner(TargetRunnerConfig targetRunnerConfig) {

    }
}
