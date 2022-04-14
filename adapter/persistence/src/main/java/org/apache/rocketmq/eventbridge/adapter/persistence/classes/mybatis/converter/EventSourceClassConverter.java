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

 import java.lang.reflect.Type;
 import java.util.Map;

 import com.google.common.reflect.TypeToken;
 import com.google.gson.Gson;
 import org.apache.rocketmq.eventbridge.adapter.persistence.classes.mybatis.dataobject.EventSourceClassDO;
 import org.apache.rocketmq.eventbridge.domain.model.classes.APIAttribute;
 import org.apache.rocketmq.eventbridge.domain.model.classes.EventSourceClass;

 public class EventSourceClassConverter {

     public static EventSourceClass convert(EventSourceClassDO eventSourceClassDO) {
         if (eventSourceClassDO == null) {
             return null;
         }
         Type mapType = new TypeToken<Map<String, Object>>() {}.getType();
         Map<String, APIAttribute> apiParams = new Gson().fromJson(eventSourceClassDO.getApiParams(), mapType);
         Map<String, Object> requiredParams = new Gson().fromJson(eventSourceClassDO.getRequiredParams(), mapType);
         Map<String, Object> transformParams = new Gson().fromJson(eventSourceClassDO.getTransform(), mapType);
         return EventSourceClass.builder()
             .name(eventSourceClassDO.getName())
             .apiParams(apiParams)
             .requiredParams(requiredParams)
             .transform(transformParams)
             .visualConfig(eventSourceClassDO.getVisualConfig())
             .description(eventSourceClassDO.getDescription())
             .gmtCreate(eventSourceClassDO.getGmtCreate())
             .gmtModify(eventSourceClassDO.getGmtModify())
             .build();
     }
 }
