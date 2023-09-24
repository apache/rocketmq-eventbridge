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

import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.apache.rocketmq.common.ThreadFactoryImpl;
import org.apache.rocketmq.eventbridge.adapter.runtime.manager.cluster.Cluster;
import org.apache.rocketmq.eventbridge.adapter.runtime.manager.cluster.ClusterService;
import org.apache.rocketmq.eventbridge.adapter.runtime.manager.worker.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

public class WatchCluster {

    @Autowired
    ClusterService clusterService;

    private final ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor(
        new ThreadFactoryImpl(WatchCluster.class.getSimpleName()));

    public void start() {
        this.scheduledExecutorService.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                List<Cluster> clusters = clusterService.listCluster();
                clusters.forEach(cluster -> {
                    if (!clusterService.isFinalState(cluster)) {
                        watchTheClusterReplica(cluster);
                        watchTheClusterImageId(cluster);
                        watchTheClusterResources(cluster);
                        clusterService.refreshMD5(cluster);
                    }

                });
            }
        }, 3, 60, TimeUnit.SECONDS);
    }

    @Transactional
    private void watchTheClusterReplica(Cluster cluster) {

    }

    @Transactional
    private void watchTheClusterImageId(Cluster cluster) {

    }

    @Transactional
    private void watchTheClusterResources(Cluster cluster) {

    }

}