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

package org.apache.rocketmq.eventbridge.adapter.runtime.manager.worker;

import java.util.List;
import java.util.UUID;
import org.apache.rocketmq.eventbridge.adapter.runtime.manager.repository.WorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service public class WorkerService {

    @Autowired private WorkerRepository workerRepository;

    public boolean createWorker(int clusterId, String workerName, String image, String resources, String config,
        String status) {
        Worker worker = Worker.builder().id(UUID.randomUUID().toString()).clusterId(clusterId).name(workerName).image(image).resources(resources).config(config).status(status).build();
        return workerRepository.createWorker(worker);
    }

    private boolean applyTasksToWorker() {
        return true;
    }

    public List<Worker> listWorkersByCluster(int clusterId) {
        return workerRepository.listWorkersByCluster(clusterId);
    }

    public List<Worker> listWorkers() {
        return workerRepository.listWorkers();
    }

    public boolean isFinalState(Worker worker) {
        return false;
    }

    public void refreshMD5(Worker worker) {
    }
}