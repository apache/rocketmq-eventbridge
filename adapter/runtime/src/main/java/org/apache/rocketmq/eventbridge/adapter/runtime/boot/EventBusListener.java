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
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package org.apache.rocketmq.eventbridge.adapter.runtime.boot;

import com.google.common.collect.Lists;
import io.openmessaging.connector.api.data.ConnectRecord;
import java.util.List;
import org.apache.commons.collections.CollectionUtils;
import org.apache.rocketmq.eventbridge.adapter.runtime.boot.common.CirculatorContext;
import org.apache.rocketmq.eventbridge.adapter.runtime.boot.listener.EventSubscriber;
import org.apache.rocketmq.eventbridge.adapter.runtime.common.ServiceThread;
import org.apache.rocketmq.eventbridge.adapter.runtime.error.ErrorHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * listen the event and offer to queue
 */
public class EventBusListener extends ServiceThread {

    private static final Logger LOGGER = LoggerFactory.getLogger(EventBusListener.class);

    private final CirculatorContext circulatorContext;
    private final EventSubscriber eventSubscriber;
    private final ErrorHandler errorHandler;

    public EventBusListener(CirculatorContext circulatorContext, EventSubscriber eventSubscriber,
        ErrorHandler errorHandler) {
        this.circulatorContext = circulatorContext;
        this.eventSubscriber = eventSubscriber;
        this.errorHandler = errorHandler;
    }

    @Override
    public void run() {
        while (!stopped) {
            List<ConnectRecord> pullRecordList = Lists.newArrayList();
            try {
                pullRecordList = eventSubscriber.pull();
                if (CollectionUtils.isEmpty(pullRecordList)) {
                    this.waitForRunning(1000);
                    continue;
                }
                circulatorContext.offerEventRecords(pullRecordList);
            } catch (Exception exception) {
                LOGGER.error(getServiceName() + " - event bus pull record exception, stackTrace - ", exception);
                pullRecordList.forEach(pullRecord -> errorHandler.handle(pullRecord, exception));
            }
        }
    }

    @Override
    public String getServiceName() {
        return EventBusListener.class.getSimpleName();
    }

    @Override
    public void shutdown() {
        eventSubscriber.close();
    }
}
