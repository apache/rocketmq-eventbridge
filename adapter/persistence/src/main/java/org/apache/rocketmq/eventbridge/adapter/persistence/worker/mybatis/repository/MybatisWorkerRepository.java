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

package org.apache.rocketmq.eventbridge.adapter.persistence.worker.mybatis.repository;

import java.util.List;
import org.apache.rocketmq.eventbridge.adapter.persistence.worker.mybatis.mapper.EventWorkerMapper;
import org.apache.rocketmq.eventbridge.adapter.runtime.manager.repository.WorkerRepository;
import org.apache.rocketmq.eventbridge.adapter.runtime.manager.worker.Worker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository public class MybatisWorkerRepository implements WorkerRepository {

    @Autowired EventWorkerMapper eventWorkerMapper;

    @Override public List<Worker> listWorkersByCluster(int clusterId) {
        return eventWorkerMapper.listWorkersByCluster(clusterId);
    }

    @Override public List<Worker> listWorkers() {
        return eventWorkerMapper.listWorkers();
    }

    @Override public boolean createWorker(Worker worker) {
        return eventWorkerMapper.createWorker(worker.getId(), worker.getClusterId(), worker.getName(), worker.getImage(), worker.getResources(), worker.getConfig(), worker.getStatus(), worker.getMd5()) == 1;
    }

    @Override public boolean updateWorker(Worker worker) {
        return false;
    }

    @Override public boolean deleteWorker(int workerId) {
        return false;
    }

    @Override public boolean deleteWorkers(int clusterId) {
        return false;
    }
}