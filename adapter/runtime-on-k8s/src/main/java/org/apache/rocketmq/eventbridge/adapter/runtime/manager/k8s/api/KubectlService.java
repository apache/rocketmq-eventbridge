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

import io.fabric8.kubernetes.client.*;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Slf4j
@Service
public class KubectlService implements AutoCloseable{

    private KubernetesClient client ;

    @Value("${eventbus.cs.accessKey:}")
    private String accessKey;

    @Value("${eventbus.cs.secretKey:}")
    private String secretKey;

    @Value("${conductor.run.env:online}")
    private String env;

    @Value("${kubernates.api.server}")
    private String apiServer;

    @Value("${kubernates.api.version:apps/v1}")
    private String apiVersion;

    @Value("${kubernates.auth.token:}")
    private String oauthToken;

    private final String DEFAULT_KEY= "default";

    private Map<String, KubernetesClient> kubernetesClientMap = new ConcurrentHashMap<>();

    @PostConstruct
    public void initClient(){
        client = getKubernetesClient();
    }

    public KubernetesClient getClient(){
        return this.client;
    }

    public KubernetesClient generateKubeApiClient(String clientId) throws IOException {
        if (StringUtils.isBlank(clientId)) {
            clientId = DEFAULT_KEY;
        }
        if (kubernetesClientMap.containsKey(clientId)) {
            return kubernetesClientMap.get(clientId);
        }
        KubernetesClient client = getKubernetesClient();
        kubernetesClientMap.putIfAbsent(clientId, client);
        return client;
    }

    private KubernetesClient getKubernetesClient() {
        Config config = getKubeConfig();
        log.info("connect to api server [{}]", apiServer);
        return new KubernetesClientBuilder().withConfig(config).build();
    }

    private Config getKubeConfig() {
        Config config = new ConfigBuilder()
                .withMasterUrl(apiServer)
                .withApiVersion(apiVersion)
                .build();
        if (StringUtils.isNotBlank(accessKey) && StringUtils.isNotBlank(secretKey)) {
            config.setUsername(accessKey);
            config.setPassword(secretKey);
            log.info("use ak and sk connect to api server.");
        } else if(StringUtils.isNotBlank(oauthToken)){
            config.setTrustCerts(true);
            config.setOauthToken(oauthToken);
            log.info("use auth token connect to api server.");
        } else {
            log.warn("this is no authenticated connection to the API server.");
        }
        return config;
    }

    @Override
    public void close() throws Exception {

        if(client != null) {
            client.close();
        }

        if (!kubernetesClientMap.isEmpty()) {
            for(String clientId : kubernetesClientMap.keySet()) {
                KubernetesClient kubernetesClient = kubernetesClientMap.get(clientId);
                if(kubernetesClient != null){
                    kubernetesClient.close();
                }
            }
        }
    }
}
