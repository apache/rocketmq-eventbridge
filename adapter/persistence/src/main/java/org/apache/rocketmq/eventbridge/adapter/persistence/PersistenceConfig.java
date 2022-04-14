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

package org.apache.rocketmq.eventbridge.adapter.persistence;

import lombok.SneakyThrows;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.tools.admin.DefaultMQAdminExt;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(basePackages = "org.apache.rocketmq.eventbridge.adapter.persistence.*.mybatis.*")
public class PersistenceConfig {

    @SneakyThrows
    @Bean
    public DefaultMQProducer defaultMQProducer(@Value("${rocketmq.namesrvAddr}") String namesrvAddr) {
        DefaultMQProducer producer = new DefaultMQProducer("EventBridge");
        producer.setNamesrvAddr(namesrvAddr);
        producer.setInstanceName("EventBridge");
        producer.start();
        return producer;
    }

    @SneakyThrows
    @Bean
    public DefaultMQAdminExt defaultMQAdminExt(@Value("${rocketmq.namesrvAddr}") String namesrvAddr) {
        DefaultMQAdminExt defaultMQAdminExt = new DefaultMQAdminExt();
        defaultMQAdminExt.setNamesrvAddr(namesrvAddr);
        defaultMQAdminExt.setAdminExtGroup("EventBridge");
        defaultMQAdminExt.start();
        return defaultMQAdminExt;
    }

}
