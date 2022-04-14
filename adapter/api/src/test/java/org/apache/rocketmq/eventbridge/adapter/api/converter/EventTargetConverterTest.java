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
package org.apache.rocketmq.eventbridge.adapter.api.converter;

import java.util.Map;

import com.google.common.collect.Maps;
import org.apache.rocketmq.eventbridge.adapter.api.dto.target.DeadLetterQueueDTO;
import org.apache.rocketmq.eventbridge.adapter.api.dto.target.EventTargetDTO;
import org.apache.rocketmq.eventbridge.adapter.api.dto.target.RetryStrategyDTO;
import org.apache.rocketmq.eventbridge.adapter.api.dto.target.RunOptionsDTO;
import org.apache.rocketmq.eventbridge.domain.common.enums.ErrorToleranceEnum;
import org.apache.rocketmq.eventbridge.domain.common.enums.PushRetryStrategyEnum;
import org.apache.rocketmq.eventbridge.domain.model.run.DeadLetterQueue;
import org.apache.rocketmq.eventbridge.domain.model.run.RetryStrategy;
import org.apache.rocketmq.eventbridge.domain.model.target.EventTarget;
import org.junit.Assert;
import org.junit.Test;

public class EventTargetConverterTest {

    @Test
    public void convertEventTargetRunners() {

    }

    @Test
    public void convertEventTargetRunner() {
        EventTargetDTO eventTargetDTO = new EventTargetDTO();
        eventTargetDTO.setEventTargetName("targetName");
        Map<String, Object> config = Maps.newHashMap();
        config.put("url", "http://127.0.0.1:7001/cloudevents");
        eventTargetDTO.setConfig(config);
        eventTargetDTO.setClassName("http");

        RunOptionsDTO runOptionsDTO = new RunOptionsDTO();
        runOptionsDTO.setErrorsTolerance("NONE");
        runOptionsDTO.setDeadLetterQueue(this.buildDeadLetterQueueDTO());
        runOptionsDTO.setRetryStrategy(this.buildRetryStrategyDTO());
        eventTargetDTO.setRunOptions(runOptionsDTO);

        EventTarget eventTarget = EventTargetConverter.convertEventTarget("123456", "bus", "rule", eventTargetDTO);

        Assert.assertEquals(eventTarget.getAccountId(), "123456");
        Assert.assertEquals(eventTarget.getEventBusName(), "bus");
        Assert.assertEquals(eventTarget.getEventRuleName(), "rule");
        Assert.assertEquals(eventTarget.getName(), eventTargetDTO.getEventTargetName());
        Assert.assertEquals(eventTarget.getClassName(), eventTargetDTO.getClassName());
        Assert.assertEquals(eventTarget.getConfig(), eventTargetDTO.getConfig());
    }

    @Test
    public void convertRetryStrategy() {
        RetryStrategyDTO retryStrategyDTO = buildRetryStrategyDTO();
        RetryStrategy retryStrategy = EventTargetConverter.convertRetryStrategy(retryStrategyDTO);

        Assert.assertEquals(PushRetryStrategyEnum.BACKOFF_RETRY, retryStrategy.getPushRetryStrategy());
        Assert.assertEquals(retryStrategyDTO.getMaximumRetryAttempts(), retryStrategy.getMaximumRetryAttempts());
        Assert.assertEquals(retryStrategyDTO.getMaximumEventAgeInSeconds(),
            retryStrategy.getMaximumEventAgeInSeconds());
    }

    @Test
    public void convertErrorTolerance() {
        ErrorToleranceEnum errorToleranceEnum = EventTargetConverter.convertErrorTolerance("NONE");
        Assert.assertEquals(ErrorToleranceEnum.NONE, errorToleranceEnum);
    }

    @Test
    public void convertDeadLetterQueue() {
        DeadLetterQueueDTO deadLetterQueueDTO = this.buildDeadLetterQueueDTO();
        DeadLetterQueue deadLetterQueue = EventTargetConverter.convertDeadLetterQueue(deadLetterQueueDTO);
        Assert.assertEquals(deadLetterQueue.getType(), deadLetterQueueDTO.getType());
        Assert.assertEquals(deadLetterQueue.getConfig(), deadLetterQueueDTO.getConfig());
    }

    private RetryStrategyDTO buildRetryStrategyDTO() {
        RetryStrategyDTO retryStrategyDTO = new RetryStrategyDTO();
        retryStrategyDTO.setPushRetryStrategy("BACKOFF_RETRY");
        retryStrategyDTO.setMaximumRetryAttempts(3);
        retryStrategyDTO.setMaximumEventAgeInSeconds(4);
        return retryStrategyDTO;
    }

    private DeadLetterQueueDTO buildDeadLetterQueueDTO() {
        DeadLetterQueueDTO deadLetterQueueDTO = new DeadLetterQueueDTO();
        deadLetterQueueDTO.setType("rocketmq");
        Map<String, Object> config = Maps.newHashMap();
        config.put("topic", "demo");
        config.put("nameSrv", "127.0.01:9876");
        deadLetterQueueDTO.setConfig(config);
        return deadLetterQueueDTO;
    }
}