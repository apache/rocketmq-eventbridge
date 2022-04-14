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

import java.util.Map;

import com.google.common.collect.Lists;
import com.google.gson.Gson;
import lombok.SneakyThrows;
import org.apache.rocketmq.eventbridge.adapter.rpc.impl.connect.context.RocketMQConnectSourceRunnerContext;
import org.apache.rocketmq.eventbridge.adapter.rpc.impl.connect.context.RocketMQConnectTargetRunnerContext;
import org.apache.rocketmq.eventbridge.adapter.rpc.impl.connect.dto.ActionStatusResponseEnum;
import org.apache.rocketmq.eventbridge.adapter.rpc.impl.connect.dto.TransformRequest;
import org.apache.rocketmq.eventbridge.domain.common.enums.EventTargetStatusEnum;
import org.apache.rocketmq.eventbridge.domain.model.Component;
import org.apache.rocketmq.eventbridge.domain.model.run.RunOptions;
import org.apache.rocketmq.eventbridge.domain.repository.EventDataRepository;
import org.apache.rocketmq.eventbridge.domain.rpc.TargetRunnerAPI;
import org.apache.rocketmq.eventbridge.tools.transform.TransformParam;

@org.springframework.stereotype.Component
public class RocketMQConnectTargetRunnerAPIImpl extends RocketMQConverter implements TargetRunnerAPI {

    private final RocketMQConnectClient rocketMQConnectClient;

    public RocketMQConnectTargetRunnerAPIImpl(EventDataRepository eventDataRepository,
        RocketMQConnectClient rocketMQConnectClient) {
        super(eventDataRepository);
        this.rocketMQConnectClient = rocketMQConnectClient;
    }

    @SneakyThrows
    @Override
    public String createAndStartEventTargetRunner(String accountId, String name, Component source, Component target,
        String filterPattern, Map<String, TransformParam> targetTransform, RunOptions runOptions) {
        String topicName = this.parseTopicName(source);
        String sinkConnectorClass = this.parseConnectorClass(target);
        Map<String, Object> sinkConnectorConfig = this.parseConnectorConfig(target);
        TransformRequest filterTransform = this.buildEventBridgeFilterTransform(filterPattern);
        TransformRequest eventBridgeTransform = this.buildEventBridgeTransform(targetTransform);
        String connectorName = rocketMQConnectClient.createSinkConnector(name, topicName, sinkConnectorClass,
            sinkConnectorConfig, Lists.newArrayList(filterTransform, eventBridgeTransform));
        RocketMQConnectTargetRunnerContext context = new RocketMQConnectTargetRunnerContext(connectorName);
        return new Gson().toJson(context);

    }

    @Override
    public String updateEventTargetRunner(String accountId, String name, Component source, Component target,
        String filterPattern, Map<String, TransformParam> targetTransform, RunOptions runOptions, String runContext) {
        String topicName = this.parseTopicName(source);
        String sinkConnectorClass = this.parseConnectorClass(target);
        Map<String, Object> sinkConnectorConfig = this.parseConnectorConfig(target);
        TransformRequest filterTransform = this.buildEventBridgeFilterTransform(filterPattern);
        TransformRequest eventBridgeTransform = this.buildEventBridgeTransform(targetTransform);
        //stop
        this.delete(runContext);
        //create
        String connectorName = rocketMQConnectClient.createSinkConnector(name, topicName, sinkConnectorClass,
            sinkConnectorConfig, Lists.newArrayList(filterTransform, eventBridgeTransform));
        RocketMQConnectTargetRunnerContext context = new RocketMQConnectTargetRunnerContext(connectorName);
        return new Gson().toJson(context);
    }

    @Override
    public EventTargetStatusEnum getEventTargetRunnerStatus(String runContext) {
        RocketMQConnectSourceRunnerContext context = new Gson().fromJson(runContext,
            RocketMQConnectSourceRunnerContext.class);
        String status = rocketMQConnectClient.getConnectorStatus(context.getConnectorName());
        return ActionStatusResponseEnum.parseEventTargetStatusEnum(status);
    }

    @Override
    public boolean delete(String runContext) {
        RocketMQConnectSourceRunnerContext context = new Gson().fromJson(runContext,
            RocketMQConnectSourceRunnerContext.class);
        return rocketMQConnectClient.stop(context.getConnectorName());
    }

    @Override
    public boolean pause(String runContext) {
        RocketMQConnectSourceRunnerContext context = new Gson().fromJson(runContext,
            RocketMQConnectSourceRunnerContext.class);
        return rocketMQConnectClient.stop(context.getConnectorName());
    }

    @Override
    public boolean start(String runContext) {
        RocketMQConnectSourceRunnerContext context = new Gson().fromJson(runContext,
            RocketMQConnectSourceRunnerContext.class);
        return rocketMQConnectClient.start(context.getConnectorName());
    }
}
