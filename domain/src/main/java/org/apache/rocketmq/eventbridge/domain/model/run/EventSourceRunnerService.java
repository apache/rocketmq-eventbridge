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
package org.apache.rocketmq.eventbridge.domain.model.run;

import com.google.common.collect.Maps;
import java.util.Map;
import org.apache.rocketmq.eventbridge.domain.common.enums.EventSourceStatusEnum;
import org.apache.rocketmq.eventbridge.domain.model.AbstractRunnerService;
import org.apache.rocketmq.eventbridge.domain.model.Component;
import org.apache.rocketmq.eventbridge.domain.model.classes.EventSourceClassService;
import org.apache.rocketmq.eventbridge.domain.repository.EventSourceRunnerRepository;
import org.apache.rocketmq.eventbridge.domain.rpc.SourceRunnerAPI;
import org.springframework.stereotype.Service;

import static org.apache.rocketmq.eventbridge.config.EventBridgeConstants.ACCOUNT_ID_KEY;
import static org.apache.rocketmq.eventbridge.config.EventBridgeConstants.EVENT_BUS_NAME_KEY;

@Service
public class EventSourceRunnerService extends AbstractRunnerService {

    private final SourceRunnerAPI sourceRunnerAPI;
    private final EventSourceClassService eventSourceClassService;
    private final EventSourceRunnerRepository eventSourceRunnerRepository;

    public EventSourceRunnerService(SourceRunnerAPI sourceRunnerAPI, EventSourceClassService eventSourceClassService,
        EventSourceRunnerRepository eventSourceRunnerRepository) {
        this.sourceRunnerAPI = sourceRunnerAPI;
        this.eventSourceClassService = eventSourceClassService;
        this.eventSourceRunnerRepository = eventSourceRunnerRepository;
    }

    public boolean createAndStartEventSourceRunner(String accountId, String eventBusName, String eventSourceName,
        String className, Map<String, Object> inputConfig, RunOptions runOptions) {
        Component source = eventSourceClassService.renderConfig(accountId, className, inputConfig);
        Component target = this.buildDefaultTargetComponent(accountId, eventBusName);
        String runContext = sourceRunnerAPI.createAndStartEventSourceRunner(accountId,
            this.buildRunnerName(accountId, eventBusName, eventSourceName), source,
            eventSourceClassService.renderCloudEventTransform(accountId, className, inputConfig, eventSourceName),
            target, runOptions);
        return eventSourceRunnerRepository.createEventSourceRunner(accountId, eventBusName, eventSourceName,
            runContext);
    }

    public boolean updateEventSourceRunner(String accountId, String eventBusName, String eventSourceName,
        String className, Map<String, Object> inputConfig, RunOptions runOptions) {
        EventSourceRunner eventSourceRunner = this.getEventSourceRunner(accountId, eventBusName, eventSourceName);
        Component source = eventSourceClassService.renderConfig(accountId, className, inputConfig);
        Component target = this.buildDefaultTargetComponent(accountId, eventBusName);
        String runContext = sourceRunnerAPI.updateEventSourceRunner(accountId, source,
            eventSourceClassService.renderCloudEventTransform(accountId, className, inputConfig, eventSourceName),
            target, runOptions, eventSourceRunner.getRunContext());
        return eventSourceRunnerRepository.updateEventSourceRunner(accountId, eventBusName, eventSourceName,
            runContext);
    }

    public EventSourceRunner getEventSourceRunner(String accountId, String eventBusName, String eventSourceName) {
        EventSourceRunner eventSourceRunner = eventSourceRunnerRepository.getEventSourceRunner(accountId, eventBusName,
            eventSourceName);
        EventSourceStatusEnum status = sourceRunnerAPI.getEventSourceRunnerStatus(accountId,
            eventSourceRunner.getRunContext());
        eventSourceRunner.setStatus(status);
        return eventSourceRunner;
    }

    public boolean deleteEventSourceRunner(String accountId, String eventBusName, String eventSourceName) {
        EventSourceRunner eventSourceRunner = this.getEventSourceRunner(accountId, eventBusName, eventSourceName);
        boolean isSucceed = eventSourceRunnerRepository.deleteEventSourceRunner(accountId, eventBusName,
            eventSourceName);
        return isSucceed && sourceRunnerAPI.delete(accountId, eventSourceRunner.getRunContext());
    }

    private Component buildDefaultTargetComponent(String accountId, String eventBusName) {
        Map<String, Object> config = Maps.newHashMap();
        config.put(EVENT_BUS_NAME_KEY, eventBusName);
        config.put(ACCOUNT_ID_KEY, accountId);
        return new Component(this.buildDefaultComponentName(), config);
    }

}