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

import java.util.Collections;

import org.apache.rocketmq.eventbridge.adapter.api.dto.target.EventTargetDTO;
import org.apache.rocketmq.eventbridge.domain.common.enums.ErrorToleranceEnum;
import org.apache.rocketmq.eventbridge.domain.common.enums.PushRetryStrategyEnum;
import org.apache.rocketmq.eventbridge.domain.model.run.DeadLetterQueue;
import org.apache.rocketmq.eventbridge.domain.model.run.RetryStrategy;
import org.apache.rocketmq.eventbridge.domain.model.run.RunOptions;
import org.apache.rocketmq.eventbridge.domain.model.run.EventTargetRunner;
import org.apache.rocketmq.eventbridge.domain.model.target.EventTarget;
import org.junit.Assert;
import org.junit.Test;

public class EventTargetDTOConverterTest {

    @Test
    public void convert() {
        RetryStrategy retryStrategy = RetryStrategy.builder()
            .pushRetryStrategy(PushRetryStrategyEnum.BACKOFF_RETRY)
            .maximumRetryAttempts(3)
            .maximumEventAgeInSeconds(4)
            .build();
        DeadLetterQueue deadLetterQueue = DeadLetterQueue.builder()
            .type("rocketmq")
            .config(Collections.singletonMap("topic", "demo"))
            .build();
        RunOptions runOptions = RunOptions.builder()
            .errorsTolerance(ErrorToleranceEnum.ALL)
            .retryStrategy(retryStrategy)
            .deadLetterQueue(deadLetterQueue)
            .build();
        EventTarget eventTarget = EventTarget.builder()
            .eventBusName("bus")
            .eventRuleName("rule")
            .name("target")
            .config(Collections.singletonMap("url", "http://127.0.0.1:7002/cloudevent"))
            .className("http")
            .runOptions(runOptions)
            .build();

        EventTargetDTO eventTargetDTO = EventTargetDTOConverter.convert(eventTarget);
        Assert.assertEquals(eventTarget.getName(), eventTargetDTO.getEventTargetName());
        Assert.assertEquals(eventTarget.getClassName(), eventTargetDTO.getClassName());
        Assert.assertEquals(eventTarget.getConfig(), eventTargetDTO.getConfig());

        Assert.assertEquals(eventTarget.getRunOptions()
            .getErrorsTolerance()
            .toString(), eventTargetDTO.getRunOptions()
            .getErrorsTolerance());

        Assert.assertEquals(eventTarget.getRunOptions()
            .getRetryStrategy()
            .getPushRetryStrategy()
            .toString(), eventTargetDTO.getRunOptions()
            .getRetryStrategy()
            .getPushRetryStrategy());
        Assert.assertEquals(eventTarget.getRunOptions()
            .getRetryStrategy()
            .getMaximumRetryAttempts(), eventTargetDTO.getRunOptions()
            .getRetryStrategy()
            .getMaximumRetryAttempts());
        Assert.assertEquals(eventTarget.getRunOptions()
            .getRetryStrategy()
            .getMaximumEventAgeInSeconds(), eventTargetDTO.getRunOptions()
            .getRetryStrategy()
            .getMaximumEventAgeInSeconds());

        Assert.assertEquals(eventTarget.getRunOptions()
            .getDeadLetterQueue()
            .getType(), eventTargetDTO.getRunOptions()
            .getDeadLetterQueue()
            .getType());
        Assert.assertEquals(eventTarget.getRunOptions()
            .getDeadLetterQueue()
            .getConfig(), eventTargetDTO.getRunOptions()
            .getDeadLetterQueue()
            .getConfig());
    }
}