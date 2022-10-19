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

package org.apache.rocketmq.eventbridge.domain.rpc;

import java.util.Map;
import org.apache.rocketmq.eventbridge.domain.common.enums.EventSourceStatusEnum;
import org.apache.rocketmq.eventbridge.domain.model.Component;
import org.apache.rocketmq.eventbridge.domain.model.run.RunOptions;

public interface SourceRunnerAPI {

    String createAndStartEventSourceRunner(String accountId, String name, Component source,
        Map<String, Object> transformPattern, Component target,
        RunOptions runOptions);

    EventSourceStatusEnum getEventSourceRunnerStatus(String accountId, String runContext);

    String updateEventSourceRunner(String accountId, Component source, Map<String, Object> transformPattern,
        Component target, RunOptions runOptions,
        String runContext);

    boolean delete(String accountId, String runContext);

    boolean pause(String accountId, String runContext);

    boolean start(String accountId, String runContext);
}
