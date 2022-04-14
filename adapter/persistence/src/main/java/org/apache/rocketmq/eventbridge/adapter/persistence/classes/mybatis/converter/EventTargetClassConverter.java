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
 package org.apache.rocketmq.eventbridge.adapter.persistence.classes.mybatis.converter;

 import java.util.Map;

 import com.google.common.reflect.TypeToken;
 import com.google.gson.Gson;
 import org.apache.rocketmq.eventbridge.adapter.persistence.classes.mybatis.dataobject.EventTargetClassDO;
 import org.apache.rocketmq.eventbridge.domain.model.classes.APIAttribute;
 import org.apache.rocketmq.eventbridge.domain.model.classes.EventTargetClass;

 public class EventTargetClassConverter {
     public static EventTargetClass convert(EventTargetClassDO eventTargetClassDO) {
         if (eventTargetClassDO == null) {
             return null;
         }
         Map<String, APIAttribute> apiParams = new Gson().fromJson(eventTargetClassDO.getApiParams(),
             new TypeToken<Map<String, APIAttribute>>() {}.getType());
         Map<String, Object> requiredParams = new Gson().fromJson(eventTargetClassDO.getRequiredParams(),
             new TypeToken<Map<String, Object>>() {}.getType());
         Map<String, String> targetTransform = new Gson().fromJson(eventTargetClassDO.getTargetTransform(),
             new TypeToken<Map<String, String>>() {}.getType());
         return EventTargetClass.builder()
             .name(eventTargetClassDO.getName())
             .apiParams(apiParams)
             .targetTransform(targetTransform)
             .requiredParams(requiredParams)
             .visualConfig(eventTargetClassDO.getVisualConfig())
             .description(eventTargetClassDO.getDescription())
             .gmtCreate(eventTargetClassDO.getGmtCreate())
             .gmtModify(eventTargetClassDO.getGmtModify())
             .build();
     }
 }
