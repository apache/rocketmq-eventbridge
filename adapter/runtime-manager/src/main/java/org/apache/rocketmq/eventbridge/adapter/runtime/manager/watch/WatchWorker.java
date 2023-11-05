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

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.apache.rocketmq.common.ThreadFactoryImpl;
import org.apache.rocketmq.eventbridge.adapter.runtime.manager.repository.WorkerInstanceRepository;
import org.apache.rocketmq.eventbridge.adapter.runtime.manager.worker.Worker;
import org.apache.rocketmq.eventbridge.adapter.runtime.manager.worker.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;

public class WatchWorker {

    @Autowired
    WorkerService workerService;
    @Autowired
    WorkerInstanceRepository workerInstanceRepository;

    private final ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor(
        new ThreadFactoryImpl(WatchWorker.class.getSimpleName()));

    public void start() {
        this.scheduledExecutorService.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                List<Worker> workers = workerService.listWorkers();
                workers.forEach(worker -> {
                    if (!workerService.isFinalState(worker)) {
                        Map<String, Object> environments = new Gson().fromJson(worker.getConfig(), new TypeToken<Map<String, Object>>() {
                        }.getType());
                        workerInstanceRepository.applyWorkerInstance(worker.getName(), worker.getImageTag(), worker.getResources(), environments);
                        workerService.refreshMD5(worker);
                    }

                });
            }
        }, 3, 60, TimeUnit.SECONDS);
    }
}