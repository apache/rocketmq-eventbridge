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
import io.fabric8.kubernetes.client.KubernetesClient;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.eventbridge.exception.EventBridgeException;
import org.apache.rocketmq.eventbridge.exception.code.DefaultErrorCode;
import org.apache.rocketmq.eventbridge.tools.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Slf4j
@Service
public class K8SConfigMapService extends BaseK8SApiService {

    /*@Autowired
    ApiClient apiClient;*/

    @Autowired
    private K8SNameSpaceService k8SNameSpaceService;


    public boolean createConfigMap(String clientId, Object configYaml) {
        try {
            /*V1ConfigMap configMap = Configuration.getDefaultApiClient()
                .getJSON()
                .deserialize(new Gson().toJson(configYaml), V1ConfigMap.class);
            api.createNamespacedConfigMap(k8SNameSpaceService.getNameSpace(), configMap, "true", null, null);*/
            KubernetesClient client = getKubernetesClient(clientId);
            ConfigMap configMap = (ConfigMap)JsonUtil.parse(JsonUtil.toJson(configYaml), ConfigMap.class);
            client.configMaps().inNamespace(k8SNameSpaceService.getNameSpace()).resource(configMap).create();
        } catch (Throwable e) {
            if ("Conflict".equals(e.getMessage())) {
                return Boolean.TRUE;
            } else {
                log.error("createConfigMap failed.{}", e);
                throw new EventBridgeException(DefaultErrorCode.InternalError, e, new Gson().toJson(configYaml));
            }
        }
        return Boolean.TRUE;
    }

    public boolean deleteConfigMap(String clientId, String name) {
        try {
           /* CoreV1Api api = new CoreV1Api(apiClient);
            if (csClusterId != null) {
                ApiClient genApiClient = kubectlService.generateKubeApiClient(regionId, csClusterId);
                api = new CoreV1Api(genApiClient);
            }
            api.deleteNamespacedConfigMap(name, k8SNameSpaceService.getNameSpace(), "true", null, null, null, null, null);*/
            KubernetesClient client = getKubernetesClient(clientId);
            client.configMaps().inNamespace(k8SNameSpaceService.getNameSpace()).withName(name).delete();
        } catch (Throwable e) {
            if ("Not Found".equals(e.getMessage())) {
                return Boolean.FALSE;
            } else {
                log.error("deleteConfigMap failed.{}", e);
                throw new EventBridgeException(DefaultErrorCode.InternalError, e, name);
            }
        }
        return Boolean.TRUE;
    }

    public void replaceConfigMap(String clientId, Object configYaml) {
        try {
            /*CoreV1Api api = new CoreV1Api(apiClient);
            if (csClusterId != null) {
                ApiClient genApiClient = kubectlService.generateKubeApiClient(regionId, csClusterId);
                api = new CoreV1Api(genApiClient);
            }

            V1ConfigMap configMap = Configuration.getDefaultApiClient()
                .getJSON()
                .deserialize(new Gson().toJson(configYaml), V1ConfigMap.class);

            api.replaceNamespacedConfigMap(name, k8SNameSpaceService.getNameSpace(), configMap, "true", null, null);*/

            KubernetesClient client = getKubernetesClient(clientId);
            ConfigMap configMap = JsonUtil.parse(JsonUtil.toJson(configYaml), ConfigMap.class);
            client.configMaps().inNamespace(k8SNameSpaceService.getNameSpace()).resource(configMap).update();
        } catch (Throwable e) {
            if ("Not Found".equals(e.getMessage())) {
                this.createConfigMap(clientId, configYaml);
            } else {
                log.error("replaceConfigMap failed.{}", e);
                throw new EventBridgeException(DefaultErrorCode.InternalError, new Gson().toJson(configYaml));
            }
        }
    }
}
