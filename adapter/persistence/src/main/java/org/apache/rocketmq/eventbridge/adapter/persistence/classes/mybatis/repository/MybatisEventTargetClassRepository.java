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
package org.apache.rocketmq.eventbridge.adapter.persistence.classes.mybatis.repository;

import org.apache.rocketmq.eventbridge.adapter.persistence.classes.mybatis.converter.EventTargetClassConverter;
import org.apache.rocketmq.eventbridge.adapter.persistence.classes.mybatis.dataobject.EventTargetClassDO;
import org.apache.rocketmq.eventbridge.adapter.persistence.classes.mybatis.mapper.EventTargetClassMapper;
import org.apache.rocketmq.eventbridge.domain.model.classes.EventTargetClass;
import org.apache.rocketmq.eventbridge.domain.repository.EventTargetClassRepository;
import org.springframework.stereotype.Repository;

@Repository
public class MybatisEventTargetClassRepository implements EventTargetClassRepository {

    private final EventTargetClassMapper eventTargetClassMapper;

    public MybatisEventTargetClassRepository(EventTargetClassMapper eventTargetClassMapper) {
        this.eventTargetClassMapper = eventTargetClassMapper;
    }

    @Override
    public EventTargetClass getEventTargetClass(String name) {
        EventTargetClassDO eventTargetClassDO = eventTargetClassMapper.getEventTargetClass(name);
        return EventTargetClassConverter.convert(eventTargetClassDO);
    }
}