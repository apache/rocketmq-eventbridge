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

 import org.apache.rocketmq.eventbridge.adapter.persistence.classes.mybatis.converter.EventSourceClassConverter;
 import org.apache.rocketmq.eventbridge.adapter.persistence.classes.mybatis.dataobject.EventSourceClassDO;
 import org.apache.rocketmq.eventbridge.adapter.persistence.classes.mybatis.mapper.EventSourceClassMapper;
 import org.apache.rocketmq.eventbridge.domain.model.classes.EventSourceClass;
 import org.apache.rocketmq.eventbridge.domain.repository.EventSourceClassRepository;
 import org.springframework.stereotype.Repository;

 @Repository
 public class MybatisEventSourceClassRepository implements EventSourceClassRepository {

     private final EventSourceClassMapper eventSourceClassMapper;

     public MybatisEventSourceClassRepository(EventSourceClassMapper eventSourceClassMapper) {
         this.eventSourceClassMapper = eventSourceClassMapper;
     }

     @Override
     public EventSourceClass getEventSourceClass(String name) {
         EventSourceClassDO eventSourceClassDO = eventSourceClassMapper.getEventSourceClass(name);
         return EventSourceClassConverter.convert(eventSourceClassDO);
     }
 }