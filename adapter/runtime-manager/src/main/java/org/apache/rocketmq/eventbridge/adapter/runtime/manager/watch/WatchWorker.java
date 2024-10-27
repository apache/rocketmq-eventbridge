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

package org.apache.rocketmq.eventbridge.adapter.runtime.manager.watch;

import com.google.common.collect.Maps;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.annotation.PostConstruct;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.common.ThreadFactoryImpl;
import org.apache.rocketmq.eventbridge.adapter.runtime.manager.repository.WorkerInstanceRepository;
import org.apache.rocketmq.eventbridge.adapter.runtime.manager.worker.Worker;
import org.apache.rocketmq.eventbridge.adapter.runtime.manager.worker.WorkerResource;
import org.apache.rocketmq.eventbridge.adapter.runtime.manager.worker.WorkerService;
import org.apache.rocketmq.eventbridge.adapter.runtime.manager.worker.WorkerStatusEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class WatchWorker {

    @Autowired
    WorkerService workerService;
    @Autowired
    WorkerInstanceRepository workerInstanceRepository;

    private final ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor(
            new ThreadFactoryImpl(WatchWorker.class.getSimpleName()));

    @PostConstruct
    public void start() {
        this.scheduledExecutorService.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                try {
                    List<Worker> workers = workerService.listWorkers();
                    workers.forEach(worker -> {
                        if (!workerService.isDeployed(worker)) {
                            Map<String, Object> environments = new Gson().fromJson(worker.getConfig(), new TypeToken<Map<String, Object>>() {
                            }.getType());
                            if (environments == null) {
                                environments = Maps.newHashMap();
                            }
                            List<Map<String, String>> env = new ArrayList<>();
                            env.add(new HashMap<String, String>(){{
                                put("name", "workerName");
                                put("value", worker.getName());
                            }});
                            environments.put("env", env);
                            log.info("applyWorkerInstance, workerName: {}, workerImageTag: {}, workerResource: {}, environments: {}", worker.getName(), worker.getImage(), worker.getResources(), new Gson().toJson(environments));
                            boolean isApplied = workerInstanceRepository.applyWorkerInstance(worker.getName(), worker.getImage(), new Gson().fromJson(worker.getResources(), WorkerResource.class), environments);
                            if (isApplied) {
                                worker.setStatus(WorkerStatusEnum.DEPLOYED.getDesc());
                            }
                            workerService.refreshMD5(worker);
                        }

                    });
                } catch (Throwable e) {
                    log.error("WatchWorker failed.", e);
                }
            }
        }, 3, 5, TimeUnit.SECONDS);
    }
}