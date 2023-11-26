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

package org.apache.rocketmq.eventbridge.adapter.runtime.manager.scale;

import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.apache.rocketmq.common.ThreadFactoryImpl;
import org.apache.rocketmq.eventbridge.adapter.runtime.manager.cluster.Cluster;
import org.apache.rocketmq.eventbridge.adapter.runtime.manager.cluster.ClusterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClusterWorkerScale {
    @Autowired
    ClusterService clusterService;

    private int DEFAULT_SCALE_UP_TRIGGER_LOAD = 80;

    private int DEFAULT_SCALE_DOWN_TRIGGER_LOAD = 20;

    private final ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor(
        new ThreadFactoryImpl(ClusterWorkerScale.class.getSimpleName()));

    public void start() {
        this.scheduledExecutorService.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                List<Cluster> clusters = clusterService.listCluster();
                clusters.forEach(cluster -> {
                    int load = clusterService.calLoad(cluster);
                    if (load > DEFAULT_SCALE_UP_TRIGGER_LOAD) {
                        clusterService.scaleCluster(cluster.getName(), cluster.getReplica() + 1);
                    } else if (load < DEFAULT_SCALE_DOWN_TRIGGER_LOAD) {
                        clusterService.scaleCluster(cluster.getName(), cluster.getReplica() > 1 ? cluster.getReplica() - 1 : cluster.getReplica());
                    }
                });
            }
        }, 3, 60, TimeUnit.SECONDS);
    }

}