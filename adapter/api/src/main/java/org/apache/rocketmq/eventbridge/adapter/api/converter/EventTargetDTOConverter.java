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
import org.apache.rocketmq.eventbridge.adapter.api.dto.target.DeadLetterQueueDTO;
import org.apache.rocketmq.eventbridge.adapter.api.dto.target.EventTargetDTO;
import org.apache.rocketmq.eventbridge.adapter.api.dto.target.RetryStrategyDTO;
import org.apache.rocketmq.eventbridge.adapter.api.dto.target.RunOptionsDTO;
import org.apache.rocketmq.eventbridge.enums.ErrorToleranceEnum;
import org.apache.rocketmq.eventbridge.domain.model.run.DeadLetterQueue;
import org.apache.rocketmq.eventbridge.domain.model.run.RetryStrategy;
import org.apache.rocketmq.eventbridge.domain.model.run.RunOptions;
import org.apache.rocketmq.eventbridge.domain.model.target.EventTarget;

public class EventTargetDTOConverter {

    /**
     * convert {@link EventTarget} list to {@link EventTargetDTO} list.
     *
     * @param eventTargets
     * @return
     */
    public static List<EventTargetDTO> convert(List<EventTarget> eventTargets) {
        return eventTargets.stream()
            .map(eventTarget -> convert(eventTarget))
            .collect(Collectors.toList());
    }

    /**
     * convert {@link EventTarget} to {@link EventTargetDTO}.
     *
     * @param eventTarget
     * @return
     */
    public static EventTargetDTO convert(EventTarget eventTarget) {
        EventTargetDTO eventTargetDTO = new EventTargetDTO();
        eventTargetDTO.setEventTargetName(eventTarget.getName());
        eventTargetDTO.setClassName(eventTarget.getClassName());
        eventTargetDTO.setConfig(eventTarget.getConfig());
        eventTargetDTO.setRunOptions(convertRunOptionsDTO(eventTarget.getRunOptions()));
        return eventTargetDTO;
    }

    /**
     * convert {@link RunOptions} to {@link RunOptionsDTO}.
     *
     * @param runOptions
     * @return
     */
    private static RunOptionsDTO convertRunOptionsDTO(RunOptions runOptions) {
        RunOptionsDTO runOptionsDTO = new RunOptionsDTO();
        runOptionsDTO.setRetryStrategy(convertRetryStrategyDTO(runOptions.getRetryStrategy()));
        runOptionsDTO.setDeadLetterQueue(convertDeadLetterQueueDTO(runOptions.getDeadLetterQueue()));
        runOptionsDTO.setErrorsTolerance(convertErrorTolerance(runOptions.getErrorsTolerance()));
        return runOptionsDTO;
    }

    /**
     * convert {@link ErrorToleranceEnum} to string
     *
     * @param errorsTolerance
     * @return
     */
    private static String convertErrorTolerance(ErrorToleranceEnum errorsTolerance) {
        if (errorsTolerance == null) {
            return null;
        } else {
            return errorsTolerance.toString();
        }
    }

    /**
     * convert {@link DeadLetterQueue} to {@link DeadLetterQueueDTO}.
     *
     * @param deadLetterQueue
     * @return
     */
    private static DeadLetterQueueDTO convertDeadLetterQueueDTO(DeadLetterQueue deadLetterQueue) {
        if (deadLetterQueue == null) {
            return null;
        }
        DeadLetterQueueDTO deadLetterQueueDTO = new DeadLetterQueueDTO();
        deadLetterQueueDTO.setType(deadLetterQueue.getType());
        deadLetterQueueDTO.setConfig(deadLetterQueue.getConfig());
        return deadLetterQueueDTO;
    }

    /**
     * convert {@link RetryStrategy} to {@link RetryStrategyDTO}.
     *
     * @param retryStrategy
     * @return
     */
    private static RetryStrategyDTO convertRetryStrategyDTO(RetryStrategy retryStrategy) {
        if (retryStrategy == null) {
            return null;
        }
        RetryStrategyDTO retryStrategyDTO = new RetryStrategyDTO();
        retryStrategyDTO.setPushRetryStrategy(
            retryStrategy.getPushRetryStrategy() != null ? retryStrategy.getPushRetryStrategy()
                .toString() : null);
        retryStrategyDTO.setMaximumRetryAttempts(retryStrategy.getMaximumRetryAttempts());
        retryStrategyDTO.setMaximumEventAgeInSeconds(retryStrategy.getMaximumEventAgeInSeconds());
        return retryStrategyDTO;
    }
}
