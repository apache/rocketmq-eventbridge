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
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.rocketmq.eventbridge.adapter.rpc.impl.connect;

import com.google.gson.Gson;
import java.net.URI;
import java.util.List;
import java.util.Map;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.rocketmq.eventbridge.adapter.rpc.impl.connect.dto.ConnectStatusResponseEnum;
import org.apache.rocketmq.eventbridge.adapter.rpc.impl.connect.dto.CreateSinkConnectorRequest;
import org.apache.rocketmq.eventbridge.adapter.rpc.impl.connect.dto.CreateSourceConnectorRequest;
import org.apache.rocketmq.eventbridge.adapter.rpc.impl.connect.dto.GetConnectorStatusRequest;
import org.apache.rocketmq.eventbridge.adapter.rpc.impl.connect.dto.StartConnectorRequest;
import org.apache.rocketmq.eventbridge.adapter.rpc.impl.connect.dto.StopConnectorRequest;
import org.apache.rocketmq.eventbridge.adapter.rpc.impl.connect.dto.TransformRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@Slf4j
public class RocketMQConnectClient {

    private RestTemplate template = null;

    @Value("${rocketmq.connect.endpoint:}")
    private String rocketMQConnectEndpoint;

    public RocketMQConnectClient() {
        HttpComponentsClientHttpRequestFactory httpRequestFactory = new HttpComponentsClientHttpRequestFactory();
        httpRequestFactory.setConnectTimeout(1000);
        httpRequestFactory.setReadTimeout(2000);
        HttpClient httpClient = HttpClientBuilder.create()
            .setMaxConnTotal(100)
            .setMaxConnPerRoute(10)
            .build();
        httpRequestFactory.setHttpClient(httpClient);
        template = new RestTemplate(httpRequestFactory);
    }

    @SneakyThrows
    public String createSourceConnector(String name, String topicName, String sourceClass,
        Map<String, Object> sourceConfig, List<TransformRequest> transforms) {
        CreateSourceConnectorRequest request = new CreateSourceConnectorRequest(rocketMQConnectEndpoint);
        request.setName(name);
        request.setTopicName(topicName);
        request.setConnectorClass(sourceClass);
        request.setConnectorConfig(sourceConfig);
        request.setTransforms(transforms);
        log.info("CreateSourceConnector config:{}", new Gson().toJson(request.getRequestObject()));
        template.postForObject(request.getURI(), request.getRequestObject(), String.class);
        return name;
    }

    @SneakyThrows
    public String createSinkConnector(String name, String topicName, String sinkClass, Map<String, Object> sinkConfig,
        List<TransformRequest> transforms) {
        CreateSinkConnectorRequest request = new CreateSinkConnectorRequest(rocketMQConnectEndpoint);
        request.setName(name);
        request.setTopicName(topicName);
        request.setConnectorClass(sinkClass);
        request.setConnectorConfig(sinkConfig);
        request.setTransforms(transforms);
        log.info("CreateSinkConnector config:{}", new Gson().toJson(request.getRequestObject()));
        template.postForObject(request.getURI(), request.getRequestObject(), String.class);
        return name;
    }

    @SneakyThrows
    public String getConnectorStatus(String connectorName) {
        GetConnectorStatusRequest request = new GetConnectorStatusRequest(rocketMQConnectEndpoint);
        request.setName(connectorName);
        String status = template.getForObject(new URI(request.toString()), String.class);
        return status;
    }

    @SneakyThrows
    public boolean stop(String connectorName) {
        StopConnectorRequest request = new StopConnectorRequest(rocketMQConnectEndpoint);
        request.setName(connectorName);
        String status = template.getForObject(new URI(request.toString()), String.class);
        return ConnectStatusResponseEnum.valueOf(status)
            .isStatus();
    }

    @SneakyThrows
    public boolean start(String connectorName) {
        StartConnectorRequest request = new StartConnectorRequest(rocketMQConnectEndpoint);
        request.setName(connectorName);
        String status = template.getForObject(new URI(request.toString()), String.class);
        return ConnectStatusResponseEnum.valueOf(status)
            .isStatus();
    }
}
