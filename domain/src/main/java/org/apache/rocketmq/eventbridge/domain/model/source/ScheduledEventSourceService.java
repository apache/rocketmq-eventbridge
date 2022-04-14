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

import org.apache.rocketmq.eventbridge.domain.common.enums.EventSourceTypeEnum;
import org.apache.rocketmq.eventbridge.domain.model.bus.EventBusService;
import org.apache.rocketmq.eventbridge.domain.repository.EventSourceRepository;
import org.springframework.stereotype.Service;

@Service
public class ScheduledEventSourceService extends EventSourceService {

    private static final String CLASS_NAME = "ScheduledEvent";

    public ScheduledEventSourceService(EventBusService eventBusService, EventSourceRepository eventSourceRepository) {
        super(eventBusService, eventSourceRepository);
    }

    @Override
    public boolean match(EventSourceTypeEnum type, String className) {
        if (EventSourceTypeEnum.USER_DEFINED.equals(type) && CLASS_NAME.equals(className)) {
            return Boolean.TRUE;
        } else {
            return Boolean.FALSE;
        }
    }

}
