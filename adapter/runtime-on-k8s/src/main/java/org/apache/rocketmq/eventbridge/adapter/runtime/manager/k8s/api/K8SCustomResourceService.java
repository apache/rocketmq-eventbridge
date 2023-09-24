package org.apache.rocketmq.eventbridge.adapter.runtime.manager.k8s.api;

import io.kubernetes.client.openapi.ApiClient;
import io.kubernetes.client.openapi.ApiException;
import io.kubernetes.client.openapi.apis.CustomObjectsApi;
import org.apache.rocketmq.eventbridge.adapter.runtime.manager.k8s.common.K8SConstants;
import org.apache.rocketmq.eventbridge.adapter.runtime.manager.k8s.model.K8SCRDConnectTaskSetModel;
import org.apache.rocketmq.eventbridge.exception.EventBridgeException;
import org.apache.rocketmq.eventbridge.exception.code.DefaultErrorCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class K8SCustomResourceService{

    private static final Logger log = LoggerFactory.getLogger(K8SCustomResourceService.class);

    @Autowired
    ApiClient apiClient;

    @Autowired
    K8SNameSpaceService k8SNameSpaceService;

    public boolean createConnectTaskSet(String taskName, String lanucherConfig, String taskConfig, int replicas) {
        CustomObjectsApi api2 = new CustomObjectsApi(apiClient);
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
        return Boolean.TRUE;
    }

    public boolean deleteConnectTaskSet(String taskName) {
        CustomObjectsApi api2 = new CustomObjectsApi(apiClient);
        try {
            api2.deleteNamespacedCustomObject(K8SConstants.CONNECT_TASK_SETS_GROUP,
                K8SConstants.CONNECT_TASK_SETS_VERSION, k8SNameSpaceService.getNameSpace(),
                K8SConstants.CONNECT_TASK_SETS_PLURAL, taskName, null, null, null, null, null);
        } catch (Throwable e) {
            log.error("Delete Connector failed", e);
            throw new EventBridgeException(DefaultErrorCode.InternalError, e, taskName);
        }
        return Boolean.TRUE;
    }

    public boolean isConnectTaskExist(String taskName) {
        CustomObjectsApi api2 = new CustomObjectsApi(apiClient);
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
        }
        return Boolean.TRUE;
    }

    private String getImage() {
        return null;
    }
}
