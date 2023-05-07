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

import com.google.common.collect.Lists;
import com.google.gson.Gson;
import java.util.Map;
import org.apache.rocketmq.eventbridge.adapter.rpc.impl.connect.context.RocketMQConnectTargetRunnerContext;
import org.apache.rocketmq.eventbridge.adapter.rpc.impl.connect.dto.TransformRequest;
import org.apache.rocketmq.eventbridge.domain.common.enums.EventSourceStatusEnum;
import org.apache.rocketmq.eventbridge.domain.model.Component;
import org.apache.rocketmq.eventbridge.domain.model.run.RunOptions;
import org.apache.rocketmq.eventbridge.domain.storage.EventDataRepository;
import org.apache.rocketmq.eventbridge.domain.rpc.SourceRunnerAPI;
import org.springframework.stereotype.Service;

@Service
public class RocketMQConnectSourceRunnerAPIImpl extends RocketMQConverter implements SourceRunnerAPI {

    private final RocketMQConnectClient rocketMQConnectClient;

    public RocketMQConnectSourceRunnerAPIImpl(EventDataRepository eventDataRepository,
        RocketMQConnectClient rocketMQConnectClient) {
        super(eventDataRepository);
        this.rocketMQConnectClient = rocketMQConnectClient;
    }

    @Override
    public String createAndStartEventSourceRunner(String accountId, String name, Component source,
        Map<String, Object> transformPattern, Component target, RunOptions runOptions) {
        String topicName = parseTopicName(target);
        String sourceClass = super.parseConnectorClass(source);
        Map<String, Object> sourceConfig = super.parseConnectorConfig(source);
        TransformRequest cloudEventTransform = this.buildCloudEventTransform(transformPattern);
        String connectorName = rocketMQConnectClient.createSourceConnector(name, topicName, sourceClass, sourceConfig,
            Lists.newArrayList(cloudEventTransform));
        RocketMQConnectTargetRunnerContext context = new RocketMQConnectTargetRunnerContext(connectorName);
        return new Gson().toJson(context);
    }

    @Override
    public EventSourceStatusEnum getEventSourceRunnerStatus(String accountId, String runContext) {
        RocketMQConnectTargetRunnerContext context = new Gson().fromJson(runContext,
            RocketMQConnectTargetRunnerContext.class);
        String status = rocketMQConnectClient.getConnectorStatus(context.getConnectorName());
        return EventSourceStatusEnum.valueOf(status);
    }

    @Override
    public boolean delete(String accountId, String runContext) {
        RocketMQConnectTargetRunnerContext context = new Gson().fromJson(runContext,
            RocketMQConnectTargetRunnerContext.class);
        return rocketMQConnectClient.stop(context.getConnectorName());
    }

    @Override
    public boolean pause(String accountId, String runContext) {
        RocketMQConnectTargetRunnerContext context = new Gson().fromJson(runContext,
            RocketMQConnectTargetRunnerContext.class);
        return rocketMQConnectClient.stop(context.getConnectorName());
    }

    @Override
    public boolean start(String accountId, String runContext) {
        RocketMQConnectTargetRunnerContext context = new Gson().fromJson(runContext,
            RocketMQConnectTargetRunnerContext.class);
        return rocketMQConnectClient.start(context.getConnectorName());
    }

    @Override
    public String updateEventSourceRunner(String accountId, Component source, Map<String, Object> transformPattern,
        Component target, RunOptions runOptions, String runContext) {
        return null;
    }

}
