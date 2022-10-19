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
package org.apache.rocketmq.eventbridge.adapter.api.handler;

import java.util.List;
import org.apache.rocketmq.eventbridge.adapter.api.dto.data.PutEventsResponse;
import org.apache.rocketmq.eventbridge.domain.model.data.EventDataService;
import org.apache.rocketmq.eventbridge.domain.model.data.PutEventsResponseEntry;
import org.apache.rocketmq.eventbridge.event.EventBridgeEvent;
import org.apache.rocketmq.eventbridge.exception.code.DefaultErrorCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class EventDataHandler {

    @Autowired
    EventDataService eventDataService;

    public Mono<PutEventsResponse> putEvents(String accountId, List<EventBridgeEvent> eventList) {
        return Flux.fromIterable(eventList)
            .flatMap(event -> {
                Mono<PutEventsResponseEntry> result = Mono.create(monoSink -> {
                    eventDataService.putEvent(accountId, event, new ReactorPutEventCallback(monoSink));
                });
                return result;
            }).collectList().map(putEventsResponseEntries -> {
                PutEventsResponse putEventsResponse = new PutEventsResponse();
                putEventsResponse.setEntryList(putEventsResponseEntries);
                long failedEntryCount = putEventsResponseEntries.stream()
                    .filter(putEventsResponseEntry -> !DefaultErrorCode.Success.getCode()
                        .equals(putEventsResponseEntry.getErrorCode()))
                    .count();
                putEventsResponse.setFailedEntryCount(Long.valueOf(failedEntryCount)
                    .intValue());
                return putEventsResponse;
            });
    }

}
