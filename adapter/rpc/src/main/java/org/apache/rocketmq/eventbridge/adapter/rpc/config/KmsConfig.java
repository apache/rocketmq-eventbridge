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

package org.apache.rocketmq.eventbridge.adapter.rpc.config;

import com.aliyun.kms20160120.Client;
import com.aliyun.teaopenapi.models.Config;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KmsConfig {

    @Value("${kms.accessKeyId}")
    private String kmsAccessKeyId;
    @Value("${kms.accessKeySecret}")
    private String kmsAccessKeySecret;
    @Value("${kms.endpoint}")
    private String kmsEndpoint;

    @Bean
    public Client client() throws Exception {
        Config config = new Config();
        config.setAccessKeyId(kmsAccessKeyId);
        config.setAccessKeySecret(kmsAccessKeySecret);
        config.setEndpoint(kmsEndpoint);
        return new Client(config);
    }

}
