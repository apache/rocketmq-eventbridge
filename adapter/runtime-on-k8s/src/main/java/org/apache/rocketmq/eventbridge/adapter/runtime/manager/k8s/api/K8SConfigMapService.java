package org.apache.rocketmq.eventbridge.adapter.runtime.manager.k8s.api;

import com.google.gson.Gson;
import io.kubernetes.client.openapi.ApiClient;
import io.kubernetes.client.openapi.Configuration;
import io.kubernetes.client.openapi.apis.CoreV1Api;
import io.kubernetes.client.openapi.models.V1ConfigMap;
import org.apache.rocketmq.eventbridge.exception.EventBridgeException;
import org.apache.rocketmq.eventbridge.exception.code.DefaultErrorCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class K8SConfigMapService {

    private static final Logger log = LoggerFactory.getLogger(K8SConfigMapService.class);

    @Autowired
    ApiClient apiClient;

    @Autowired
    K8SNameSpaceService k8SNameSpaceService;

    @Autowired
    KubectlService kubectlService;

    public boolean createConfigMap(String regionId, String csClusterId, Object configYaml) {
        try {
            CoreV1Api api = new CoreV1Api(apiClient);
            if (csClusterId != null) {
                ApiClient genApiClient = kubectlService.generateKubeApiClient(regionId, csClusterId);
                api = new CoreV1Api(genApiClient);
            }
            V1ConfigMap configMap = Configuration.getDefaultApiClient()
                .getJSON()
                .deserialize(new Gson().toJson(configYaml), V1ConfigMap.class);

            api.createNamespacedConfigMap(k8SNameSpaceService.getNameSpace(), configMap, "true", null, null);
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

    public boolean deleteConfigMap(String regionId, String csClusterId, String name) {
        try {
            CoreV1Api api = new CoreV1Api(apiClient);
            if (csClusterId != null) {
                ApiClient genApiClient = kubectlService.generateKubeApiClient(regionId, csClusterId);
                api = new CoreV1Api(genApiClient);
            }
            api.deleteNamespacedConfigMap(name, k8SNameSpaceService.getNameSpace(), "true", null, null, null, null, null);
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

    public void replaceConfigMap(String regionId, String csClusterId, String name, Object configYaml) {
        try {
            CoreV1Api api = new CoreV1Api(apiClient);
            if (csClusterId != null) {
                ApiClient genApiClient = kubectlService.generateKubeApiClient(regionId, csClusterId);
                api = new CoreV1Api(genApiClient);
            }

            V1ConfigMap configMap = Configuration.getDefaultApiClient()
                .getJSON()
                .deserialize(new Gson().toJson(configYaml), V1ConfigMap.class);

            api.replaceNamespacedConfigMap(name, k8SNameSpaceService.getNameSpace(), configMap, "true", null, null);
        } catch (Throwable e) {
            if ("Not Found".equals(e.getMessage())) {
                this.createConfigMap(regionId, csClusterId, configYaml);
            } else {
                log.error("replaceConfigMap failed.{}", e);
                throw new EventBridgeException(DefaultErrorCode.InternalError, new Gson().toJson(configYaml));
            }
        }
    }
}
