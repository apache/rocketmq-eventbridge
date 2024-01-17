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

package org.apache.rocketmq.eventbridge.adapter.runtime.manager.dispatch;

import javax.annotation.Resource;
import org.apache.rocketmq.eventbridge.adapter.runtime.manager.cluster.Cluster;
import org.apache.rocketmq.eventbridge.adapter.runtime.manager.cluster.ClusterSelectorService;
import org.apache.rocketmq.eventbridge.adapter.runtime.manager.task.RunnerTask;
import org.apache.rocketmq.eventbridge.adapter.runtime.manager.task.RunnerTaskService;
import org.apache.rocketmq.eventbridge.adapter.runtime.manager.worker.Worker;
import org.apache.rocketmq.eventbridge.adapter.runtime.manager.worker.WorkerSelectorService;

public class RunnerTaskDispatcher {

    @Resource
    ClusterSelectorService clusterSelectorService;

    @Resource
    WorkerSelectorService workerSelectorService;

    @Resource
    RunnerTaskService runnerTaskService;

    public boolean dispatchRunnerTask(RunnerTask runnerTask) {
        boolean dispatchToCluster = dispatchToCluster(runnerTask);
        boolean dispatchToWorker = dispatchToWorker(runnerTask);
        return dispatchToCluster && dispatchToWorker;
    }

    public boolean dispatchToCluster(RunnerTask runnerTask) {
        Cluster cluster = clusterSelectorService.selectCluster(runnerTask);
        return runnerTaskService.updateRunnerTaskCluster(runnerTask, cluster);
    }

    public boolean dispatchToWorker(RunnerTask runnerTask) {
        Worker worker = workerSelectorService.selectWorker(runnerTask);
        return runnerTaskService.updateRunnerTaskWorker(runnerTask, worker);
    }

}