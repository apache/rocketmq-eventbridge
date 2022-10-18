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

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import java.lang.reflect.Type;
import java.util.Map;
import org.apache.rocketmq.eventbridge.adapter.persistence.source.mybatis.dataobject.EventSourceRunnerDO;
import org.apache.rocketmq.eventbridge.domain.model.run.EventSourceRunner;
import org.apache.rocketmq.eventbridge.domain.model.run.RunOptions;

public class EventSourceRunnerConverter {

    public static EventSourceRunner convert(EventSourceRunnerDO eventTargetRunnerDO) {
        Type mapType = new TypeToken<Map<String, Object>>() {
        }.getType();
        Map<String, Object> config = new Gson().fromJson(eventTargetRunnerDO.getConfig(), mapType);
        RunOptions runOptions = new Gson().fromJson(eventTargetRunnerDO.getRunOptions(), RunOptions.class);
        return EventSourceRunner.builder()
            .accountId(eventTargetRunnerDO.getAccountId())
            .eventBusName(eventTargetRunnerDO.getEventBusName())
            .eventSourceName(eventTargetRunnerDO.getEventSourceName())
            .className(eventTargetRunnerDO.getClassName())
            .config(config)
            .runOptions(runOptions)
            .runContext(eventTargetRunnerDO.getRunContext())
            .gmtCreate(eventTargetRunnerDO.getGmtCreate())
            .gmtModify(eventTargetRunnerDO.getGmtModify())
            .build();
    }

}
