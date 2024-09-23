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

import com.google.common.base.Strings;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;
import javax.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.common.ThreadFactoryImpl;
import org.apache.rocketmq.eventbridge.adapter.runtime.manager.cluster.Cluster;
import org.apache.rocketmq.eventbridge.adapter.runtime.manager.cluster.ClusterService;
import org.apache.rocketmq.eventbridge.adapter.runtime.manager.worker.Worker;
import org.apache.rocketmq.eventbridge.adapter.runtime.manager.worker.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
public class WatchCluster {

    @Autowired
    ClusterService clusterService;

    @Autowired
    WorkerService workerService;

    private final ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor(
        new ThreadFactoryImpl(WatchCluster.class.getSimpleName()));

    public WatchCluster(ClusterService clusterService) {
        this.clusterService = clusterService;
    }

    @PostConstruct
    public void start() {
        this.scheduledExecutorService.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                try {
                    List<Cluster> clusters = clusterService.listCluster();
                    clusters.forEach(cluster -> {
                        String md5 = clusterService.calMD5(cluster);
                        if (!Strings.isNullOrEmpty(md5) && !md5.equals(cluster.getMd5())) {
                            watchTheClusterReplica(cluster);
                            watchTheClusterImageId(cluster);
                            watchTheClusterResources(cluster);
                            clusterService.refreshMD5(cluster.getId(), md5);
                        }

                    });
                } catch (Throwable e) {
                    log.error("WatchCluster failed.", e);
                }
            }
        }, 3, 5, TimeUnit.SECONDS);
    }

    @Transactional
    private void watchTheClusterReplica(Cluster cluster) {
        List<Worker> workers = workerService.listWorkersByCluster(cluster.getId());
        if (workers != null && cluster.getReplica() > workers.size()) {
            IntStream.range(workers.size(), cluster.getReplica()).forEach(value -> {
                workerService.createWorker(cluster.getId(), "worker-" + value, cluster.getImage(), cluster.getResources(), null, null);
            });
        }
    }

    @Transactional
    private void watchTheClusterImageId(Cluster cluster) {

    }

    @Transactional
    private void watchTheClusterResources(Cluster cluster) {

    }

}