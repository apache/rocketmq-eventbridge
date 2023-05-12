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

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.util.concurrent.ThreadFactoryBuilder;
import io.openmessaging.connector.api.component.task.sink.SinkTask;
import io.openmessaging.connector.api.data.ConnectRecord;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.rocketmq.common.utils.ThreadUtils;
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
import java.util.concurrent.*;

/**
 * event circulator context for transfer and pusher
 */
@Component
public class CirculatorContext implements TargetRunnerListener {

    private final static Logger logger = LoggerFactory.getLogger(LoggerName.EventBus_Listener);

    private static Integer QUEUE_CAPACITY = 50000;

    private BlockingQueue<ConnectRecord> eventQueue = new LinkedBlockingQueue<>(50000);

    private BlockingQueue<ConnectRecord> targetQueue = new LinkedBlockingQueue<>(50000);

    private Map<String/*RunnerName*/, BlockingQueue<ConnectRecord>> eventQueueMap = new ConcurrentHashMap<>(30);

    private Map<String/*RunnerName*/, BlockingQueue<ConnectRecord>> targetQueueMap = new ConcurrentHashMap<>(30);

    private Map<String/*RunnerName*/, TransformEngine<ConnectRecord>> taskTransformMap = new ConcurrentHashMap<>(20);

    private Map<String/*RunnerName*/, SinkTask> pusherTaskMap = new ConcurrentHashMap<>(20);

    private Map<String/*PusherCLass*/, ExecutorService> pusherExecutorMap = new ConcurrentHashMap<>(10);

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
    public boolean offerEventRecords(List<ConnectRecord> connectRecords) {
        Map<String, List<ConnectRecord>> recordMap = buildWithRunnerNameKeyMap(connectRecords);
        updateRecordQueueMap(recordMap, eventQueueMap);
        return eventQueue.addAll(connectRecords);
    }

    /**
     * update record queue map
     * @param recordMap
     * @param eventQueueMap
     */
    private boolean updateRecordQueueMap(Map<String, List<ConnectRecord>> recordMap, Map<String, BlockingQueue<ConnectRecord>> eventQueueMap) {
        try{
            for(String runnerName : recordMap.keySet()){
                BlockingQueue<ConnectRecord> recordQueue = eventQueueMap.get(runnerName);
                if(CollectionUtils.isEmpty(recordQueue)){
                    recordQueue = new LinkedBlockingQueue<>(QUEUE_CAPACITY);
                }
                recordQueue.addAll(recordMap.get(runnerName));
                eventQueueMap.put(runnerName, recordQueue);
            }
            return true;
        }catch (Exception exception){
            return false;
        }
    }

    /**
     * take event records
     *
     * @return
     */
    public Map<String, List<ConnectRecord>> takeEventRecords(int batchSize) {
        if(eventQueue.isEmpty()){
            return null;
        }
        List<ConnectRecord> eventRecords = Lists.newArrayList();
        eventQueue.drainTo(eventRecords, batchSize);
        return buildWithRunnerNameKeyMap(eventRecords);
    }

    public Map<String, TransformEngine<ConnectRecord>> getTaskTransformMap() {
        return taskTransformMap;
    }

    public Map<String, SinkTask> getPusherTaskMap() {
        return pusherTaskMap;
    }

    public boolean offerTargetTaskQueue(List<ConnectRecord> connectRecords) {
        Map<String, List<ConnectRecord>> recordMap = buildWithRunnerNameKeyMap(connectRecords);
        updateRecordQueueMap(recordMap, targetQueueMap);
        return targetQueue.addAll(connectRecords);
    }

    public ConnectRecord takeTargetRecord() {
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
     * take batch target records
     * @param batchSize
     * @return
     */
    public Map<String, List<ConnectRecord>> takeTargetRecords(Integer batchSize) {
        if(targetQueue.isEmpty()){
            return null;
        }
        List<ConnectRecord> targetRecords = Lists.newArrayList();
        targetQueue.drainTo(targetRecords, batchSize);
        return buildWithRunnerNameKeyMap(targetRecords);
    }


    /**
     * user runner-name as key
     * @param eventRecords
     * @return
     */
    private Map<String, List<ConnectRecord>> buildWithRunnerNameKeyMap(List<ConnectRecord> eventRecords) {
        Map<String, List<ConnectRecord>> eventRecordMap = Maps.newHashMap();
        for (ConnectRecord connectRecord : eventRecords) {
            String runnerName = connectRecord.getExtension(RuntimerConfigDefine.RUNNER_NAME);
            List<ConnectRecord> curEventRecords = eventRecordMap.get(runnerName);
            if(CollectionUtils.isEmpty(curEventRecords)){
                curEventRecords = Lists.newArrayList();
            }
            curEventRecords.add(connectRecord);
            eventRecordMap.put(runnerName, curEventRecords);
        }
        return eventRecordMap;
    }

    /**
     * get specific thread pool by push name
     * @param runnerName
     * @return
     */
    public ExecutorService getExecutorService(String runnerName){
        return pusherExecutorMap.get(runnerName);
    }

    /**
     * refresh target runner where config changed
     * @param targetRunnerConfig
     * @param refreshTypeEnum
     */
    private void refreshRunnerMetadata(TargetRunnerConfig targetRunnerConfig, RefreshTypeEnum refreshTypeEnum) {
        String runnerName = targetRunnerConfig.getName();
        switch (refreshTypeEnum) {
            case ADD:
            case UPDATE:
                TransformEngine<ConnectRecord> transformChain = new TransformEngine<>(targetRunnerConfig.getComponents(), plugin);
                taskTransformMap.put(runnerName, transformChain);

                int endIndex = targetRunnerConfig.getComponents().size() -1;
                TargetKeyValue targetKeyValue = new TargetKeyValue(targetRunnerConfig.getComponents().get(endIndex));
                SinkTask sinkTask = initTargetSinkTask(targetKeyValue);
                pusherTaskMap.put(runnerName, sinkTask);

                if (!pusherExecutorMap.containsKey(runnerName)) {
                    pusherExecutorMap.put(runnerName, initDefaultThreadPoolExecutor(runnerName));
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
     * init default thread poll param, support auto config
     * @param threadPollName
     * @return
     */
    private ExecutorService initDefaultThreadPoolExecutor(String threadPollName) {
        return new ThreadPoolExecutor(200, 300, 1, TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(300), ThreadUtils.newThreadFactory(threadPollName, false));
    }

    /**
     * init target sink task
     * @param targetKeyValue
     * @return
     */
    private SinkTask initTargetSinkTask(TargetKeyValue targetKeyValue) {
        String taskClass = targetKeyValue.getString(RuntimerConfigDefine.RUNNER_CLASS);
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
