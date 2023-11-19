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

package org.apache.rocketmq.eventbridge.adapter.runtime.manager.repository;

import java.util.Map;
import org.apache.rocketmq.eventbridge.adapter.runtime.manager.worker.WorkerResource;
import org.apache.rocketmq.eventbridge.adapter.runtime.manager.worker.WorkerStatusEnum;

public interface WorkerInstanceRepository {

    /**
     * Apply(Create/Update) the worker instance.
     *
     * @param name
     * @param image
     * @param resources
     * @param environments
     * @return
     */
    boolean applyWorkerInstance(String name, String image, WorkerResource resources, Map<String, Object> environments);

    /**
     * Delete the worker
     *
     * @param name
     * @return
     */
    boolean deleteWorkerInstance(String name);

    /**
     * Get the status of worker
     *
     * @param name
     * @return
     */
    WorkerStatusEnum getWorkerInstanceStatus(String name);

    /**
     * Apply(Create/Update) the config to the worker instance. It may contains more than one config in worker instance.
     *
     * @param name
     * @param filePath
     * @param config
     * @return
     */
    boolean applyWorkerInstanceConfigFile(String name, String filePath, String config);

    /**
     * Get the config to the worker instance.
     *
     * @param name
     * @param filePath
     * @return
     */
    boolean getWorkerInstanceConfigFile(String name, String filePath);
}