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

package org.apache.rocketmq.eventbridge.adapter.persistence.target.mybatis.converter;

import com.google.common.collect.Lists;
import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;
import org.apache.rocketmq.eventbridge.adapter.persistence.target.mybatis.dataobject.EventTargetDO;
import org.apache.rocketmq.eventbridge.domain.model.run.RunOptions;
import org.apache.rocketmq.eventbridge.domain.model.target.EventTarget;

public class EventTargetConverter {

    public static List<EventTarget> convert(List<EventTargetDO> eventTargetDOS) {
        List<EventTarget> eventTargets = Lists.newArrayListWithCapacity(eventTargetDOS.size());
        for (EventTargetDO eventTargetDO : eventTargetDOS) {
            eventTargets.add(convert(eventTargetDO));
        }
        return eventTargets;
    }

    public static EventTarget convert(EventTargetDO eventTargetRunnerDO) {
        Type mapType = new TypeToken<Map<String, Object>>() {
        }.getType();
        Map<String, Object> config = new Gson().fromJson(eventTargetRunnerDO.getConfig(), mapType);
        RunOptions runOptions = new Gson().fromJson(eventTargetRunnerDO.getRunOptions(), RunOptions.class);
        return EventTarget.builder()
            .accountId(eventTargetRunnerDO.getAccountId())
            .eventBusName(eventTargetRunnerDO.getEventBusName())
            .eventRuleName(eventTargetRunnerDO.getEventRuleName())
            .name(eventTargetRunnerDO.getEventTargetName())
            .className(eventTargetRunnerDO.getClassName())
            .config(config)
            .runOptions(runOptions)
            .runContext(eventTargetRunnerDO.getRunContext())
            .gmtCreate(eventTargetRunnerDO.getGmtCreate())
            .gmtModify(eventTargetRunnerDO.getGmtModify())
            .build();
    }
}
