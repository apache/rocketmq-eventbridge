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

package org.apache.rocketmq.eventbridge.adapter.runtime.manager.k8s.config;

import org.apache.rocketmq.eventbridge.adapter.runtime.manager.k8s.api.K8SDeploymentService;
import org.apache.rocketmq.eventbridge.adapter.runtime.manager.k8s.repository.WorkerInstanceRepositoryOnK8S;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class K8SRuntimeConfiguration {

    @Bean(name = "workerInstanceRepositoryOnK8S")
    public WorkerInstanceRepositoryOnK8S workerInstanceRepositoryOnK8S(@Qualifier("k8SDeploymentService") K8SDeploymentService k8SDeploymentService, @Qualifier("deploySpecTemplateSpec") DeploySpecTemplateSpec deploySpecTemplateSpec, @Qualifier("k8SNameSpaceService") org.apache.rocketmq.eventbridge.adapter.runtime.manager.k8s.api.K8SNameSpaceService k8SNameSpaceService) {
        return new WorkerInstanceRepositoryOnK8S(k8SDeploymentService, deploySpecTemplateSpec, k8SNameSpaceService);
    }

}