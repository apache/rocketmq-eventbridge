package org.apache.rocketmq.eventbridge.adapter.runtime.manager.k8s.api;

import com.google.gson.Gson;
import io.kubernetes.client.openapi.ApiClient;
import io.kubernetes.client.openapi.Configuration;
import io.kubernetes.client.openapi.apis.AppsV1Api;
import io.kubernetes.client.openapi.models.V1Deployment;
import org.apache.rocketmq.eventbridge.adapter.runtime.manager.k8s.common.WorkerStatusEnum;
import org.apache.rocketmq.eventbridge.exception.EventBridgeException;
import org.apache.rocketmq.eventbridge.exception.code.DefaultErrorCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class K8SDeploymentService {

    private static final Logger log = LoggerFactory.getLogger(K8SDeploymentService.class);

    @Autowired
    ApiClient apiClient;

    @Autowired
    K8SNameSpaceService k8SNameSpaceService;

    @Autowired
    KubectlService kubectlService;

    public boolean updateDeployment(String regionId, String csClusterId, String name, Object deployYaml) {
        try {
            AppsV1Api api = new AppsV1Api(apiClient);
            if (csClusterId != null) {
                ApiClient genApiClient = kubectlService.generateKubeApiClient(regionId, csClusterId);
                api = new AppsV1Api(genApiClient);
            }
            V1Deployment body = Configuration.getDefaultApiClient()
                .getJSON()
                .deserialize(new Gson().toJson(deployYaml), V1Deployment.class);
            api.replaceNamespacedDeployment(name, k8SNameSpaceService.getNameSpace(), body, "true", null, null);
        } catch (Throwable e) {
            if ("Not Found".equals(e.getMessage())) {
                this.createDeployment(regionId, csClusterId, deployYaml);
            } else {
                log.error(DefaultErrorCode.InternalError.getMsg(), e);
                throw new EventBridgeException(DefaultErrorCode.InternalError,e, new Gson().toJson(deployYaml));
            }
        }
        return Boolean.TRUE;
    }

    public WorkerStatusEnum getDeploymentStatus(String regionId, String csClusterId, String name) {
        V1Deployment v1Deployment = null;
        try {
            AppsV1Api api = new AppsV1Api(apiClient);
            if (csClusterId != null) {
                ApiClient genApiClient = kubectlService.generateKubeApiClient(regionId, csClusterId);
                api = new AppsV1Api(genApiClient);
            }
            v1Deployment = api.readNamespacedDeployment(name, k8SNameSpaceService.getNameSpace(), "true", true, false);
        } catch (Throwable e) {
            log.error(DefaultErrorCode.InternalError.getMsg(), e);
            throw new EventBridgeException(DefaultErrorCode.InternalError, e, "name=" + name);
        }
        if (v1Deployment == null || v1Deployment.getStatus() == null || v1Deployment.getStatus().getReadyReplicas() == null) {
            return WorkerStatusEnum.STARTING;
        }
        if (v1Deployment.getStatus().getReadyReplicas() == 1) {
            return WorkerStatusEnum.RUN;
        }
        return WorkerStatusEnum.DEFAULT;
    }

    public boolean deleteDeployment(String regionId, String csClusterId, String name) {
        try {
            AppsV1Api api = new AppsV1Api(apiClient);
            if (csClusterId != null) {
                ApiClient genApiClient = kubectlService.generateKubeApiClient(regionId, csClusterId);
                api = new AppsV1Api(genApiClient);
            }
            api.deleteNamespacedDeployment(name, k8SNameSpaceService.getNameSpace(), "true", null, null, null, null,
                null);
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

    public boolean createDeployment(String regionId, String csClusterId, Object deployYaml) {
        try {
            AppsV1Api api = new AppsV1Api(apiClient);
            if (csClusterId != null) {
                ApiClient genApiClient = kubectlService.generateKubeApiClient(regionId, csClusterId);
                api = new AppsV1Api(genApiClient);
            }
            V1Deployment body = Configuration.getDefaultApiClient()
                .getJSON()
                .deserialize(new Gson().toJson(deployYaml), V1Deployment.class);
            api.createNamespacedDeployment(k8SNameSpaceService.getNameSpace(), body, "true", null, null);
        } catch (Throwable e) {
            if ("Conflict".equals(e.getMessage())) {
                return Boolean.TRUE;
            } else {
                log.error(DefaultErrorCode.InternalError.getMsg(), e);
                throw new EventBridgeException(DefaultErrorCode.InternalError,e, new Gson().toJson(deployYaml));
            }
        }
        return Boolean.TRUE;
    }

}
