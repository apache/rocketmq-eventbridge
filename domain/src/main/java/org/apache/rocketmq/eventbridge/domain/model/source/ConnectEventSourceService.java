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

package org.apache.rocketmq.eventbridge.domain.model.source;

import java.util.Map;

import com.google.common.base.Strings;
import org.apache.rocketmq.eventbridge.domain.common.enums.EventSourceTypeEnum;
import org.apache.rocketmq.eventbridge.domain.model.bus.EventBusService;
import org.apache.rocketmq.eventbridge.domain.model.classes.EventSourceClassService;
import org.apache.rocketmq.eventbridge.domain.model.run.EventSourceRunner;
import org.apache.rocketmq.eventbridge.domain.model.run.EventSourceRunnerService;
import org.apache.rocketmq.eventbridge.domain.model.run.RunOptions;
import org.apache.rocketmq.eventbridge.domain.repository.EventSourceRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
public class ConnectEventSourceService extends EventSourceService {

    private EventSourceRunnerService eventSourceRunnerService;
    private EventSourceClassService eventSourceClassService;

    public ConnectEventSourceService(EventBusService eventBusService, EventSourceRepository eventSourceRepository,
        EventSourceRunnerService eventSourceRunnerService, EventSourceClassService eventSourceClassService) {
        super(eventBusService, eventSourceRepository);
        this.eventSourceRunnerService = eventSourceRunnerService;
        this.eventSourceClassService = eventSourceClassService;
    }

    @Override
    public boolean match(EventSourceTypeEnum type, String className) {
        if (EventSourceTypeEnum.USER_DEFINED.equals(type) && eventSourceClassService.isExist(className)) {
            return Boolean.TRUE;
        } else {
            return Boolean.FALSE;
        }
    }

    @Transactional
    @Override
    public boolean createEventSource(String accountId, String eventBusName, String eventSourceName, String description,
        String className, Map<String, Object> inputConfig) {
        boolean isSucceed = super.createEventSource(accountId, eventBusName, eventSourceName, description, className,
            inputConfig);
        return isSucceed && eventSourceRunnerService.createAndStartEventSourceRunner(accountId, eventBusName,
            eventSourceName, className, inputConfig, null);
    }

    @Transactional
    @Override
    public boolean deleteEventSource(String accountId, String eventBusName, String eventSourceName) {
        boolean isSucceed = super.deleteEventSource(accountId, eventBusName, eventSourceName);
        if (eventSourceRunnerService.getEventSourceRunner(accountId, eventBusName, eventSourceName) != null) {
            return isSucceed && eventSourceRunnerService.deleteEventSourceRunner(accountId, eventBusName,
                eventSourceName);
        } else {
            return isSucceed;
        }
    }

    @Transactional
    @Override
    public boolean updateEventSource(String accountId, String eventBusName, String eventSourceName, String description,
        String className, Integer status, Map<String, Object> inputConfig) {
        boolean isSucceed = super.updateEventSource(accountId, eventBusName, eventSourceName, description, className,
            status, inputConfig);
        if (!Strings.isNullOrEmpty(className)) {
            return isSucceed && eventSourceRunnerService.updateEventSourceRunner(accountId, eventBusName,
                eventSourceName, className, inputConfig, null);
        } else {
            return isSucceed;
        }
    }

    @Override
    public EventSource getEventSource(String accountId, String eventBusName, String eventSourceName) {
        EventSource eventSource = super.getEventSource(accountId, eventBusName, eventSourceName);
        EventSourceRunner eventSourceRunner = eventSourceRunnerService.getEventSourceRunner(accountId, eventBusName,
            eventSourceName);
        if (eventSourceRunner != null) {
            eventSource.setStatus(eventSourceRunner.getStatus());
        }
        return eventSource;
    }

}
