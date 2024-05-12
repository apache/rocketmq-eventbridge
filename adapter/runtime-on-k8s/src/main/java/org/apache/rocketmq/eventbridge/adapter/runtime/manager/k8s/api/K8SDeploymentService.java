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

import com.google.gson.Gson;
import io.fabric8.kubernetes.api.model.ConfigMap;
import io.fabric8.kubernetes.api.model.ConfigMapBuilder;
import io.fabric8.kubernetes.api.model.apps.Deployment;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.dsl.Resource;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.eventbridge.adapter.runtime.manager.worker.WorkerStatusEnum;
import org.apache.rocketmq.eventbridge.exception.EventBridgeException;
import org.apache.rocketmq.eventbridge.exception.code.DefaultErrorCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;


@Slf4j
@Service
public class K8SDeploymentService extends BaseK8SApiService {

    @Autowired
    private K8SNameSpaceService k8SNameSpaceService;

    public boolean updateDeployment(String clientId, String name, Deployment deployment) {
        try {
            KubernetesClient client = getKubernetesClient(clientId);
            client.apps().deployments().inNamespace(k8SNameSpaceService.getNameSpace()).resource(deployment).update();
        } catch (Throwable e) {
            if ("Not Found".equals(e.getMessage())) {
                this.createDeployment(clientId, deployment);
            } else {
                log.error(DefaultErrorCode.InternalError.getMsg(), e);
                throw new EventBridgeException(DefaultErrorCode.InternalError,e, new Gson().toJson(deployment));
            }
        }
        return Boolean.TRUE;
    }

    public WorkerStatusEnum getDeploymentStatus(String clientId, String name) {
        Deployment deployment;
        try {
            KubernetesClient client = getKubernetesClient(clientId);
            deployment = client.apps().deployments().inNamespace(k8SNameSpaceService.getNameSpace()).withName(name).get();
        } catch (Throwable e) {
            log.error(DefaultErrorCode.InternalError.getMsg(), e);
            throw new EventBridgeException(DefaultErrorCode.InternalError, e, "name=" + name);
        }
        if (deployment == null || deployment.getStatus() == null || deployment.getStatus().getReadyReplicas() == null) {
            return WorkerStatusEnum.UNKNOWN;
        }
        if (deployment.getStatus().getReadyReplicas() == 1) {
            return WorkerStatusEnum.RUN;
        }
        return WorkerStatusEnum.UNKNOWN;
    }

    public boolean deleteDeployment(String clientId, String name) {
        try {
            KubernetesClient client = getKubernetesClient(clientId);
            client.apps().deployments().inNamespace(k8SNameSpaceService.getNameSpace()).withName(name).delete();
        } catch (Throwable e) {
            if ("Not Found".equals(e.getMessage())) {
                return Boolean.FALSE;
            } else {
                log.error(DefaultErrorCode.InternalError.getMsg(), e);
                throw new EventBridgeException(DefaultErrorCode.InternalError, e, name);
            }
        }
        return Boolean.TRUE;
    }

    public boolean createDeployment(String clientId, Deployment deployment) {
        try {
            KubernetesClient client = getKubernetesClient(clientId);
            client.apps().deployments().inNamespace(k8SNameSpaceService.getNameSpace()).resource(deployment).create();
        } catch (Throwable e) {
            if ("Conflict".equals(e.getMessage())) {
                return Boolean.TRUE;
            } else {
                log.error(DefaultErrorCode.InternalError.getMsg(), e);
                throw new EventBridgeException(DefaultErrorCode.InternalError,e, new Gson().toJson(deployment));
            }
        }
        return Boolean.TRUE;
    }

    public boolean createConfigMap(String clientId, ConfigMap configMap) {
        try {
            KubernetesClient client = getKubernetesClient(clientId);
            client.resources(ConfigMap.class).resource(configMap).create();
        } catch (Throwable e) {
            if ("Conflict".equals(e.getMessage())) {
                return Boolean.TRUE;
            } else {
                log.error(DefaultErrorCode.InternalError.getMsg(), e);
                throw new EventBridgeException(DefaultErrorCode.InternalError,e, configMap);
            }
        }
        return Boolean.TRUE;
    }

    public String getConfigMap(String clientId, String name, String filePath) {
        try {
            KubernetesClient client = getKubernetesClient(clientId);
            Resource<ConfigMap> resource = client.resources(ConfigMap.class)
                    .resource(new ConfigMapBuilder().withNewMetadata().withName(name).endMetadata().build());
            if (resource != null) {
                ConfigMap configMap = resource.get();
                if (configMap != null) {
                    Map<String, String> map = configMap.getData();
                    if (map != null && map.containsKey(filePath)) {
                        return map.get(filePath);
                    }
                }
            }
        } catch (Throwable e) {
            log.error(DefaultErrorCode.InternalError.getMsg(), e);
            throw new EventBridgeException(DefaultErrorCode.InternalError,e, "name=" + name + ", filePath=" + filePath);
        }
        return null;
    }

}
