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

package org.apache.rocketmq.eventbridge.adapter.persistence.source.mybatis.converter;

import java.util.List;

import com.google.common.collect.Lists;
import org.apache.rocketmq.eventbridge.adapter.persistence.source.mybatis.dataobject.EventSourceDO;
import org.apache.rocketmq.eventbridge.domain.common.enums.EventSourceTypeEnum;
import org.apache.rocketmq.eventbridge.domain.model.source.EventSource;

public class EventSourceConverter {

    public static EventSource convert(EventSourceDO eventSourceDO) {
        return EventSource.builder()
            .accountId(eventSourceDO.getAccountId())
            .eventBusName(eventSourceDO.getEventBusName())
            .name(eventSourceDO.getName())
            .type(EventSourceTypeEnum.parseFromCode(eventSourceDO.getType()))
            .description(eventSourceDO.getDescription())
            .gmtCreate(eventSourceDO.getGmtCreate())
            .gmtModify(eventSourceDO.getGmtModify())
            .build();
    }

    public static List<EventSource> convert(List<EventSourceDO> eventSourceDOs) {
        List<EventSource> eventSources = Lists.newArrayListWithCapacity(eventSourceDOs.size());
        for (EventSourceDO eventSourceDO : eventSourceDOs) {
            eventSources.add(convert(eventSourceDO));
        }
        return eventSources;
    }

}
