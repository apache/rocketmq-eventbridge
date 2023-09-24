package org.apache.rocketmq.eventbridge.adapter.runtime.manager.k8s.api;

import io.kubernetes.client.openapi.ApiClient;
import io.kubernetes.client.util.ClientBuilder;
import io.kubernetes.client.util.KubeConfig;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class KubectlService {

    private static final Logger log = LoggerFactory.getLogger(KubectlService.class);

    @Value("${eventbus.cs.accessKey:}")
    private String accessKey;

    @Value("${eventbus.cs.secretKey:}")
    private String secretKey;

    @Value("${conductor.run.env:online}")
    private String env;

    private Map<String, ApiClient> kubeConfigMap = new ConcurrentHashMap<>();

    public ApiClient generateKubeApiClient(String regionId, String csClusterId) throws IOException {
        if (kubeConfigMap.containsKey(csClusterId)) {
            return kubeConfigMap.get(csClusterId);
        }
        KubeConfig config = getKubeConfig(regionId, csClusterId, accessKey, secretKey);

        ApiClient client = ClientBuilder.kubeconfig(config).build();
        //client.setDebugging(true);
        kubeConfigMap.putIfAbsent(csClusterId, client);
        return client;
    }

    private KubeConfig getKubeConfig(String regionId, String csClusterId, String ak, String sk) throws IOException {
        return null;
    }
}
