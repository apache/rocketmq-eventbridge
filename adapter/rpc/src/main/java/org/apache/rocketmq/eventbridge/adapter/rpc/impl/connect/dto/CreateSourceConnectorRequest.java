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

package org.apache.rocketmq.eventbridge.adapter.rpc.impl.connect.dto;

import java.net.URI;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.google.common.collect.Maps;
import com.google.gson.Gson;
import lombok.Getter;
import lombok.Setter;
import lombok.SneakyThrows;

@Setter
@Getter
public class CreateSourceConnectorRequest extends BaseConnectorRequest {

    private String path = "/connectors/%s";

    private String name;

    private String topicName;

    private String connectorClass;

    private List<TransformRequest> transforms;

    private Map<String, Object> connectorConfig;

    public CreateSourceConnectorRequest(String endpoint) {
        super(endpoint);
    }

    @SneakyThrows
    public URI getURI() {
        return new URI(String.format(endpoint + path, name));
    }

    public Map<String, Object> getRequestObject() {
        Map<String, Object> config = Maps.newHashMap();
        config.put("connector-class", connectorClass);
        config.put("connect-topicname", topicName);
        config.put("transforms", String.join(",", transforms.stream()
            .map(TransformRequest::getName)
            .collect(Collectors.toList())));
        transforms.forEach(transform -> {
            transform.getConfig()
                .entrySet()
                .forEach(entry -> {
                    config.put("transforms" + "-" + transform.getName() + "-" + entry.getKey(), entry.getValue());
                });
        });
        config.putAll(connectorConfig);
        return config;
    }

}
