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

import io.fabric8.kubernetes.api.model.GenericKubernetesResource;
import io.fabric8.kubernetes.client.dsl.base.ResourceDefinitionContext;
import org.apache.rocketmq.eventbridge.adapter.runtime.manager.k8s.common.K8SConstants;
import org.apache.rocketmq.eventbridge.adapter.runtime.manager.k8s.model.K8SCRDConnectTaskSetModel;
import org.apache.rocketmq.eventbridge.exception.EventBridgeException;
import org.apache.rocketmq.eventbridge.exception.code.DefaultErrorCode;
import org.apache.rocketmq.eventbridge.tools.JsonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class K8SCustomResourceService extends BaseK8SApiService{

    private static final Logger log = LoggerFactory.getLogger(K8SCustomResourceService.class);

    /*@Autowired
    ApiClient apiClient;*/

    @Autowired
    private K8SNameSpaceService k8SNameSpaceService;

    private ResourceDefinitionContext resourceDefinitionContext;
    public K8SCustomResourceService () {
        resourceDefinitionContext = new ResourceDefinitionContext.Builder()
                .withGroup(K8SConstants.CONNECT_TASK_SETS_GROUP)
                .withVersion(K8SConstants.CONNECT_TASK_SETS_VERSION)
                .withPlural(K8SConstants.CONNECT_TASK_SETS_PLURAL)
                .withNamespaced(true)
                .build();
    }


    public boolean createConnectTaskSet(String taskName, String lanucherConfig, String taskConfig, int replicas) {
        /*CustomObjectsApi api2 = new CustomObjectsApi(apiClient);
        K8SCRDConnectTaskSetModel body = new K8SCRDConnectTaskSetModel(taskName, lanucherConfig, taskConfig, replicas,
            getImage());
        try {
            api2.createNamespacedCustomObject(K8SConstants.CONNECT_TASK_SETS_GROUP,
                K8SConstants.CONNECT_TASK_SETS_VERSION, k8SNameSpaceService.getNameSpace(),
                K8SConstants.CONNECT_TASK_SETS_PLURAL, body, "true", null, null);
        } catch (Throwable e) {
            log.error(DefaultErrorCode.InternalError.getMsg(), e);
            throw new EventBridgeException(DefaultErrorCode.InternalError, e, taskConfig);
        }
        String rawJsonCustomResourceObj = "{\"apiVersion\":\"jungle.example.com/v1\"," +
                "\"kind\":\"Animal\",\"metadata\": {\"name\": \"walrus\"}," +
                "\"spec\": {\"image\": \"my-awesome-walrus-image\"}}";*/

        K8SCRDConnectTaskSetModel body = new K8SCRDConnectTaskSetModel(taskName, lanucherConfig, taskConfig, replicas,
                getImage());
        try {
            getKubernetesClient().genericKubernetesResources(resourceDefinitionContext).inNamespace(k8SNameSpaceService.getNameSpace()).load(JsonUtil.toJson(body)).create();
        } catch (Throwable e) {
            log.error(DefaultErrorCode.InternalError.getMsg(), e);
            throw new EventBridgeException(DefaultErrorCode.InternalError, e, taskConfig);
        }
        return Boolean.TRUE;
    }

    public boolean deleteConnectTaskSet(String taskName) {
        /*CustomObjectsApi api2 = new CustomObjectsApi(apiClient);
        try {
            api2.deleteNamespacedCustomObject(K8SConstants.CONNECT_TASK_SETS_GROUP,
                K8SConstants.CONNECT_TASK_SETS_VERSION, k8SNameSpaceService.getNameSpace(),
                K8SConstants.CONNECT_TASK_SETS_PLURAL, taskName, null, null, null, null, null);
        } catch (Throwable e) {
            log.error("Delete Connector failed", e);
            throw new EventBridgeException(DefaultErrorCode.InternalError, e, taskName);
        }*/
        try {
            getKubernetesClient().genericKubernetesResources(resourceDefinitionContext).withName(taskName).delete();
        } catch (Throwable e) {
            log.error("Delete Connector failed", e);
            throw new EventBridgeException(DefaultErrorCode.InternalError, e, taskName);
        }
        return Boolean.TRUE;
    }

    public boolean isConnectTaskExist(String taskName) {
        /*CustomObjectsApi api2 = new CustomObjectsApi(apiClient);
        try {
            api2.getNamespacedCustomObject(K8SConstants.CONNECT_TASK_SETS_GROUP, K8SConstants.CONNECT_TASK_SETS_VERSION,
                k8SNameSpaceService.getNameSpace(), K8SConstants.CONNECT_TASK_SETS_PLURAL, taskName);
        } catch (Throwable e) {
            if (e instanceof ApiException) {
                if (404 == ((ApiException)e).getCode()) {
                    return Boolean.FALSE;
                }
            }
            log.error("Get Connector task  failed", e);
            throw new EventBridgeException(DefaultErrorCode.InternalError, e);
        }*/

        try {
            GenericKubernetesResource customResourceObject = getKubernetesClient().genericKubernetesResources(resourceDefinitionContext).withName(taskName).get();
            if (null != customResourceObject) {
                return Boolean.TRUE;
            }
            return Boolean.FALSE;
        } catch (Throwable e) {
            log.error("Delete Connector failed", e);
            throw new EventBridgeException(DefaultErrorCode.InternalError, e, taskName);
        }
    }

    private String getImage() {
        return null;
    }
}
