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

import java.util.List;
import java.util.stream.Collectors;

import com.google.common.base.Strings;
import org.apache.rocketmq.eventbridge.adapter.api.dto.target.DeadLetterQueueDTO;
import org.apache.rocketmq.eventbridge.adapter.api.dto.target.EventTargetDTO;
import org.apache.rocketmq.eventbridge.adapter.api.dto.target.RetryStrategyDTO;
import org.apache.rocketmq.eventbridge.domain.common.enums.ErrorToleranceEnum;
import org.apache.rocketmq.eventbridge.domain.common.enums.PushRetryStrategyEnum;
import org.apache.rocketmq.eventbridge.domain.model.run.DeadLetterQueue;
import org.apache.rocketmq.eventbridge.domain.model.run.RetryStrategy;
import org.apache.rocketmq.eventbridge.domain.model.run.RunOptions;
import org.apache.rocketmq.eventbridge.domain.model.target.EventTarget;

public class EventTargetConverter {

    /**
     * convert {@link EventTargetDTO} list to {@link EventTarget} list.
     *
     * @param accountId
     * @param eventBusName
     * @param eventRuleName
     * @param eventTargetDTOs
     *
     * @return
     */
    public static List<EventTarget> convertEventTargets(String accountId, String eventBusName,
        String eventRuleName, List<EventTargetDTO> eventTargetDTOs) {
        if (eventTargetDTOs == null) {
            return null;
        }
        return eventTargetDTOs.stream()
            .map(eventTargetDTO -> convertEventTarget(accountId, eventBusName, eventRuleName, eventTargetDTO))
            .collect(Collectors.toList());
    }

    /**
     * convert {@link EventTargetDTO} to {@link EventTarget}.
     *
     * @param accountId
     * @param eventBusName
     * @param eventRuleName
     * @param eventTargetDTO
     *
     * @return
     */
    public static EventTarget convertEventTarget(String accountId, String eventBusName,
        String eventRuleName, EventTargetDTO eventTargetDTO) {
        EventTarget eventTarget = EventTarget.builder()
            .accountId(accountId)
            .eventBusName(eventBusName)
            .eventRuleName(eventRuleName)
            .name(eventTargetDTO.getEventTargetName())
            .className(eventTargetDTO.getClassName())
            .config(eventTargetDTO.getConfig())
            .build();

        if (eventTargetDTO.getRunOptions() == null) {
            return eventTarget;
        }
        RunOptions runOptions = RunOptions.builder()
            .deadLetterQueue(convertDeadLetterQueue(eventTargetDTO.getRunOptions()
                .getDeadLetterQueue()))
            .errorsTolerance(convertErrorTolerance(eventTargetDTO.getRunOptions()
                .getErrorsTolerance()))
            .retryStrategy(convertRetryStrategy(eventTargetDTO.getRunOptions()
                .getRetryStrategy()))
            .build();
        eventTarget.setRunOptions(runOptions);

        return eventTarget;
    }

    /**
     * convert {@link RetryStrategyDTO} to {@link RetryStrategy}.
     *
     * @param retryStrategyDTO
     *
     * @return
     */
    public static RetryStrategy convertRetryStrategy(RetryStrategyDTO retryStrategyDTO) {
        RetryStrategy retryStrategy = null;
        if (retryStrategyDTO != null) {
            retryStrategy = RetryStrategy.builder()
                .pushRetryStrategy(PushRetryStrategyEnum.parse(retryStrategyDTO.getPushRetryStrategy()))
                .maximumRetryAttempts(retryStrategyDTO.getMaximumRetryAttempts())
                .maximumEventAgeInSeconds(retryStrategyDTO.getMaximumEventAgeInSeconds())
                .build();
        }
        return retryStrategy;
    }

    /**
     * convert errorsTolerance to {@link ErrorToleranceEnum}.
     *
     * @param errorsTolerance
     *
     * @return
     */
    public static ErrorToleranceEnum convertErrorTolerance(String errorsTolerance) {
        ErrorToleranceEnum errorTolerance = null;
        if (!Strings.isNullOrEmpty(errorsTolerance)) {
            errorTolerance = ErrorToleranceEnum.parse(errorsTolerance);
        }
        return errorTolerance;
    }

    /**
     * convert {@link DeadLetterQueueDTO} to {@link DeadLetterQueue}.
     *
     * @param deadLetterQueueDTO
     *
     * @return
     */
    public static DeadLetterQueue convertDeadLetterQueue(DeadLetterQueueDTO deadLetterQueueDTO) {
        DeadLetterQueue deadLetterQueue = null;
        if (deadLetterQueueDTO != null) {
            deadLetterQueue = DeadLetterQueue.builder()
                .type(deadLetterQueueDTO.getType())
                .config(deadLetterQueueDTO.getConfig())
                .build();
        }
        return deadLetterQueue;
    }

}
