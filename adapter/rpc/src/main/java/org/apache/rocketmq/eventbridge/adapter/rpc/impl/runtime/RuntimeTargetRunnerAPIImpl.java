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

package org.apache.rocketmq.eventbridge.adapter.rpc.impl.runtime;

import com.google.common.collect.Lists;
import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import java.util.List;
import java.util.Map;
import org.apache.rocketmq.eventbridge.adapter.rpc.impl.connect.RocketMQConverter;
import org.apache.rocketmq.eventbridge.adapter.runtimer.common.entity.TargetRunnerConfig;
import org.apache.rocketmq.eventbridge.domain.common.enums.EventTargetStatusEnum;
import org.apache.rocketmq.eventbridge.domain.model.Component;
import org.apache.rocketmq.eventbridge.domain.model.run.RunOptions;
import org.apache.rocketmq.eventbridge.domain.rpc.TargetRunnerAPI;
import org.apache.rocketmq.eventbridge.tools.transform.TransformParam;

@org.springframework.stereotype.Component
public class RuntimeTargetRunnerAPIImpl implements TargetRunnerAPI {

    @Override
    public String createAndStartEventTargetRunner(String accountId, String name, Component source, Component target,
        String filterPattern, Map<String, TransformParam> targetTransform, RunOptions runOptions) {
        return new Gson().toJson(this.buildTargetRunnerConfig(accountId, name, source, target, filterPattern, targetTransform, runOptions));
    }

    @Override
    public String updateEventTargetRunner(String accountId, String name, Component source, Component target,
        String filterPattern, Map<String, TransformParam> targetTransform, RunOptions runOptions, String runContext) {
        return new Gson().toJson(this.buildTargetRunnerConfig(accountId, name, source, target, filterPattern, targetTransform, runOptions));
    }

    private TargetRunnerConfig buildTargetRunnerConfig(String accountId, String name, Component source,
        Component target,
        String filterPattern, Map<String, TransformParam> targetTransform, RunOptions runOptions) {
        TargetRunnerConfig targetRunnerConfig = new TargetRunnerConfig();
        targetRunnerConfig.setName(name);
        List<Map<String, String>> components = Lists.newArrayList();
        targetRunnerConfig.setComponents(components);
        Map<String, String> sourceComponent = new Gson().fromJson(new Gson().toJson(source
            .getConfig()), new TypeToken<Map<String, String>>() {
        }.getType());
        Map<String, String> filterComponent = new Gson().fromJson(new Gson().toJson(RocketMQConverter.buildEventBridgeFilterTransform(filterPattern)
            .getConfig()), new TypeToken<Map<String, String>>() {
        }.getType());

        Map<String, String> transformComponent = new Gson().fromJson(new Gson().toJson(RocketMQConverter.buildEventBridgeTransform(targetTransform)
            .getConfig()), new TypeToken<Map<String, String>>() {
        }.getType());
        Map<String, String> targetComponent = new Gson().fromJson(new Gson().toJson(target
            .getConfig()), new TypeToken<Map<String, String>>() {
        }.getType());
        components.add(sourceComponent);
        components.add(filterComponent);
        components.add(transformComponent);
        components.add(targetComponent);
        return targetRunnerConfig;
    }

    @Override public EventTargetStatusEnum getEventTargetRunnerStatus(String runContext) {
        return null;
    }

    @Override public boolean delete(String runContext) {
        //do nothing
        return true;
    }

    @Override public boolean pause(String runContext) {
        return false;
    }

    @Override public boolean start(String runContext) {
        return false;
    }

}
