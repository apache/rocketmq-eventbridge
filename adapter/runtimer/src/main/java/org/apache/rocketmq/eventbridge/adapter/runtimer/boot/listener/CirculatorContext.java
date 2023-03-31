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

package org.apache.rocketmq.eventbridge.adapter.runtimer.boot.listener;

import io.openmessaging.connector.api.component.task.sink.SinkTask;
import io.openmessaging.connector.api.data.ConnectRecord;
import org.apache.commons.collections.CollectionUtils;
import org.apache.rocketmq.eventbridge.adapter.runtimer.boot.pusher.PusherTaskContext;
import org.apache.rocketmq.eventbridge.adapter.runtimer.boot.transfer.TransformEngine;
import org.apache.rocketmq.eventbridge.adapter.runtimer.common.LoggerName;
import org.apache.rocketmq.eventbridge.adapter.runtimer.common.entity.TargetKeyValue;
import org.apache.rocketmq.eventbridge.adapter.runtimer.common.entity.TargetRunnerConfig;
import org.apache.rocketmq.eventbridge.adapter.runtimer.common.enums.RefreshTypeEnum;
import org.apache.rocketmq.eventbridge.adapter.runtimer.common.plugin.Plugin;
import org.apache.rocketmq.eventbridge.adapter.runtimer.common.plugin.PluginClassLoader;
import org.apache.rocketmq.eventbridge.adapter.runtimer.config.RuntimerConfigDefine;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * event circulator context for transfer and pusher
 */
@Component
public class CirculatorContext implements TargetRunnerListener {

    private final static Logger logger = LoggerFactory.getLogger(LoggerName.EventBus_Listener);

    private BlockingQueue<ConnectRecord> eventRecord = new LinkedBlockingQueue<>(50000);

    private BlockingQueue<ConnectRecord> targetQueue = new LinkedBlockingQueue<>(50000);

    private Map<String/*RunnerName*/, TransformEngine<ConnectRecord>> taskTransformMap = new ConcurrentHashMap<>(20);

    private Map<String/*RunnerName*/, SinkTask> pusherTaskMap = new ConcurrentHashMap<>(20);

    private Plugin plugin;

    public CirculatorContext(Plugin plugin){
        this.plugin = plugin;
    }

    /**
     * initial targetRunnerMap, taskTransformMap, pusherTaskMap
     * @param targetRunnerConfigs
     */
    public void initListenerMetadata(Set<TargetRunnerConfig> targetRunnerConfigs) {
        if (CollectionUtils.isEmpty(targetRunnerConfigs)) {
            return;
        }
        for (TargetRunnerConfig targetRunnerConfig : targetRunnerConfigs) {
            onAddTargetRunner(targetRunnerConfig);
        }
    }

    @Override
    public void onAddTargetRunner(TargetRunnerConfig targetRunnerConfig) {
        refreshRunnerMetadata(targetRunnerConfig, RefreshTypeEnum.ADD);
    }

    @Override
    public void onUpdateTargetRunner(TargetRunnerConfig targetRunnerConfig) {
        refreshRunnerMetadata(targetRunnerConfig, RefreshTypeEnum.UPDATE);
    }

    @Override
    public void onDeleteTargetRunner(TargetRunnerConfig targetRunnerConfig) {
        refreshRunnerMetadata(targetRunnerConfig, RefreshTypeEnum.DELETE);
    }

    /**
     * offer event records
     *
     * @param connectRecords
     */
   public boolean  offerEventRecords(List<ConnectRecord> connectRecords) {
        return eventRecord.addAll(connectRecords);
    }

    /**
     * take event record
     *
     * @return
     */
    public ConnectRecord takeEventRecord() {
        if (eventRecord.isEmpty()) {
            return null;
        }
        try {
            return eventRecord.take();
        } catch (Exception exception) {
            logger.error("take event record exception - stack-> ", exception);
        }
        return null;
    }

    public Map<String, TransformEngine<ConnectRecord>> getTaskTransformMap() {
        return taskTransformMap;
    }

    public Map<String, SinkTask> getPusherTaskMap() {
        return pusherTaskMap;
    }

    public boolean offerTargetTaskQueue(ConnectRecord connectRecord) {
        return targetQueue.offer(connectRecord);
    }

    public ConnectRecord takeTargetMap() {
        if (targetQueue.isEmpty()) {
            return null;
        }
        try {
            return targetQueue.take();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return null;
    }

    /**
     * refresh target runner where config changed
     * @param targetRunnerConfig
     * @param refreshTypeEnum
     */
    private void refreshRunnerMetadata(TargetRunnerConfig targetRunnerConfig, RefreshTypeEnum refreshTypeEnum) {
        String runnerName = targetRunnerConfig.getName();
        switch (refreshTypeEnum){
            case ADD:
            case UPDATE:
                for(Map<String, String> configMap : targetRunnerConfig.getComponents()){
                    TargetKeyValue targetKeyValue = new TargetKeyValue(configMap);
                    TransformEngine<ConnectRecord> transformChain = new TransformEngine<>(targetKeyValue, plugin);
                    taskTransformMap.put(runnerName, transformChain);

                    SinkTask sinkTask = initTargetSinkTask(targetKeyValue);
                    pusherTaskMap.put(runnerName, sinkTask);
                }
                break;
            case DELETE:
                taskTransformMap.remove(runnerName);
                pusherTaskMap.remove(runnerName);
                break;
            default:
                break;
        }
    }

    /**
     * init target sink task
     * @param targetKeyValue
     * @return
     */
    private SinkTask initTargetSinkTask(TargetKeyValue targetKeyValue) {
        String taskClass = targetKeyValue.getString(RuntimerConfigDefine.TASK_CLASS);
        ClassLoader loader = plugin.getPluginClassLoader(taskClass);
        Class taskClazz;
        boolean isolationFlag = false;
        try {
            if (loader instanceof PluginClassLoader) {
                taskClazz = ((PluginClassLoader) loader).loadClass(taskClass, false);
                isolationFlag = true;
            } else {
                taskClazz = Class.forName(taskClass);
            }
            SinkTask sinkTask = (SinkTask) taskClazz.getDeclaredConstructor().newInstance();
            sinkTask.init(targetKeyValue);
            PusherTaskContext sinkTaskContext = new PusherTaskContext(targetKeyValue);
            sinkTask.start(sinkTaskContext);
            if (isolationFlag) {
                Plugin.compareAndSwapLoaders(loader);
            }
            return sinkTask;
        }catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
