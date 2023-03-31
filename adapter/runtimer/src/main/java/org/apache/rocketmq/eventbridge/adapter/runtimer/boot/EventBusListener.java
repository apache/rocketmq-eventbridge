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

package org.apache.rocketmq.eventbridge.adapter.runtimer.boot;

import io.openmessaging.connector.api.data.ConnectRecord;
import org.apache.commons.collections.CollectionUtils;
import org.apache.rocketmq.eventbridge.adapter.runtimer.boot.listener.EventSubscriber;
import org.apache.rocketmq.eventbridge.adapter.runtimer.boot.listener.CirculatorContext;
import org.apache.rocketmq.eventbridge.adapter.runtimer.common.ServiceThread;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * listen the event and offer to queue
 *
 * @author artisan
 */
public class EventBusListener extends ServiceThread {

    private static final Logger logger = LoggerFactory.getLogger(EventBusListener.class);

    private CirculatorContext circulatorContext;

    private EventSubscriber eventSubscriber;

    public EventBusListener(CirculatorContext circulatorContext, EventSubscriber eventSubscriber) {
        this.circulatorContext = circulatorContext;
        this.eventSubscriber = eventSubscriber;
    }

    @Override
    public void run() {
        while (!stopped) {
            try{
                List<ConnectRecord> recordList = eventSubscriber.pull();
                if(CollectionUtils.isEmpty(recordList)){
                    this.waitForRunning(1000);
                    continue;
                }
                circulatorContext.offerEventRecords(recordList);
            }catch (Exception exception) {
                logger.error(getServiceName() + " - event bus pull record exception, stackTrace - ", exception);
            }
        }
    }

    @Override
    public String getServiceName() {
        return EventBusListener.class.getSimpleName();
    }
}
