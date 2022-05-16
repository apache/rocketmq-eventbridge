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

package org.apache.rocketmq.eventbridge.adapter.rpc.impl;

import java.util.Set;

import com.google.common.collect.Sets;
import org.apache.rocketmq.eventbridge.config.AppConfig;
import org.apache.rocketmq.eventbridge.config.GlobalConfig;
import org.apache.rocketmq.eventbridge.config.LocalConfig;
import org.springframework.stereotype.Component;

@Component
public class AppConfigAPIImpl {

    public AppConfigAPIImpl() {
        GlobalConfig globalConfig = new GlobalConfig();
        globalConfig.setGetEventBusExtensionKey("aliyuneventbusname");

        Set<String> extensionKeys = Sets.newHashSet();
        extensionKeys.add("aliyuneventbusname");
        globalConfig.setEventExtensionKeys(extensionKeys);

        LocalConfig localConfig = new LocalConfig();
        localConfig.setRegion("cn-hangzhou");
        localConfig.setPublicHttpWebhookSchema("http://%s.eventbridge.%s.com/webhook/putEvents?token=%s");
        localConfig.setPublicHttpsWebhookSchema("https://%s.eventbridge.%s.com/webhook/putEvents?token=%s");
        localConfig.setVpcHttpWebhookSchema("http://%s.eventbridge-vpc.%s.com/webhook/putEvents?token=%s");
        localConfig.setVpcHttpsWebhookSchema("https://%s.eventbridge-vpc.%s.com/webhook/putEvents?token=%s");

        AppConfig.refreshGlobalConfig(globalConfig);
        AppConfig.refreshLocalConfig(localConfig);
    }
}
