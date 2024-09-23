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

package org.apache.rocketmq.eventbridge.adapter.runtime.manager.k8s.api;

import io.fabric8.kubernetes.client.KubernetesClient;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;

public abstract class BaseK8SApiService {

    @Autowired
    private KubectlService kubectlService;

    protected KubernetesClient getKubernetesClient(String clientId) throws IOException {
        KubernetesClient client = kubectlService.getClient();
        if (StringUtils.isNotBlank(clientId)) {
            client = kubectlService.generateKubeApiClient(clientId);
        }
        return client;
    }

    protected KubernetesClient getKubernetesClient() {
        return kubectlService.getClient();
    }

}
