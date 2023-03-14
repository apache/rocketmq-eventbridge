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
import com.google.common.collect.Lists;
import io.netty.util.internal.ConcurrentSet;
import io.openmessaging.connector.api.component.task.sink.SinkTask;
import io.openmessaging.connector.api.data.ConnectRecord;
import org.apache.commons.collections.MapUtils;
import org.apache.rocketmq.eventbridge.adapter.runtimer.boot.listener.ListenerFactory;
import org.apache.rocketmq.eventbridge.adapter.runtimer.boot.pusher.PusherTaskContext;
import org.apache.rocketmq.eventbridge.adapter.runtimer.common.entity.PusherTargetEntity;
import org.apache.rocketmq.eventbridge.adapter.runtimer.common.entity.TargetKeyValue;
import org.apache.rocketmq.eventbridge.adapter.runtimer.common.ServiceThread;
import org.apache.rocketmq.eventbridge.adapter.runtimer.common.plugin.Plugin;
import org.apache.rocketmq.eventbridge.adapter.runtimer.common.plugin.PluginClassLoader;
import org.apache.rocketmq.eventbridge.adapter.runtimer.config.RuntimerConfigDefine;
import org.apache.rocketmq.eventbridge.adapter.runtimer.service.PusherConfigManageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * event target push to sink task
 * @author artisan
 */
public class EventTargetPusher extends ServiceThread {

    private static final Logger logger = LoggerFactory.getLogger(EventTargetPusher.class);

    private Set<Runnable> runningTasks = new ConcurrentSet<>();

    private Set<Runnable> errorTasks = new ConcurrentSet<>();

    private Set<Runnable> stoppedTasks = new ConcurrentSet<>();

    private Plugin plugin;

    private ListenerFactory listenerFactory;

    private PusherConfigManageService pusherConfigManageService;

    private List<SinkTask> pusherTasks = new CopyOnWriteArrayList<>();

    public EventTargetPusher(Plugin plugin, ListenerFactory listenerFactory, PusherConfigManageService pusherConfigManageService){
        this.plugin = plugin;
        this.listenerFactory = listenerFactory;
        this.pusherConfigManageService = pusherConfigManageService;
        this.pusherConfigManageService.registerListener(new TargetUpdateListenerImpl());
    }

    /**
     * init running tasks
     * @param taskConfig
     */
    public void initOrUpdatePusherTask(Map<String, List<TargetKeyValue>> taskConfig){
        Set<TargetKeyValue> taskProperty = new HashSet<>();
        for(String connectName : taskConfig.keySet()){
            List<TargetKeyValue> targetKeyValues = taskConfig.get(connectName);
            taskProperty.addAll(new HashSet<>(targetKeyValues));
        }
        for(TargetKeyValue targetKeyValue : taskProperty){
            try{
                String taskClass = targetKeyValue.getString(RuntimerConfigDefine.TASK_CLASS);
                ClassLoader loader = plugin.getPluginClassLoader(taskClass);
                Class taskClazz;
                boolean isolationFlag = false;
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
                pusherTasks.add(sinkTask);
                if (isolationFlag) {
                    Plugin.compareAndSwapLoaders(loader);
                }
                logger.info("init target task succeed, target key - {}", JSON.toJSONString(targetKeyValue));
            }catch (Exception exception){
                exception.printStackTrace();
            }
        }
    }

    @Override
    public void run() {
        while (!stopped){
            Map<TargetKeyValue, ConnectRecord> taskPusher = listenerFactory.takeTargetMap();
            if(MapUtils.isEmpty(taskPusher)){
                logger.info("current target pusher is empty");
                this.waitForRunning(1000);
                continue;
            }
            logger.info("start push content by pusher - {}", JSON.toJSONString(taskPusher));

            TargetKeyValue targetKeyValue = taskPusher.keySet().iterator().next();
            // task-id for unique-key at ConnectKeyValue
            // ConnectKeyValue -> new class for name
            // also add in ConnectRecord class system property
            String taskPushName = targetKeyValue.getString(RuntimerConfigDefine.TASK_CLASS);
            // add thread pool
            for(SinkTask sinkTask : pusherTasks){
                if(sinkTask.getClass().getName().equals(taskPushName)){
                    sinkTask.put(Lists.newArrayList(taskPusher.get(targetKeyValue)));
                }
            }
        }
    }

    @Override
    public String getServiceName() {
        return EventTargetPusher.class.getSimpleName();
    }

    /**
     * target update listener
     */
    class TargetUpdateListenerImpl implements PusherConfigManageService.TargetConfigUpdateListener {

        @Override
        public void onConfigUpdate(PusherTargetEntity targetEntity) {
            logger.info("transform update by new target config changed, target info -{}", JSON.toJSONString(targetEntity));
            Map<String, List<TargetKeyValue>> lastTargetMap = new HashMap<>();
            lastTargetMap.put(targetEntity.getConnectName(), targetEntity.getTargetKeyValues());
            initOrUpdatePusherTask(lastTargetMap);
        }
    }
}
