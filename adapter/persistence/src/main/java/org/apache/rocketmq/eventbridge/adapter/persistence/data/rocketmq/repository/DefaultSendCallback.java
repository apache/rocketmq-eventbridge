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

package org.apache.rocketmq.eventbridge.adapter.persistence.data.rocketmq.repository;

import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.eventbridge.domain.model.data.PutEventCallback;
import org.apache.rocketmq.eventbridge.domain.model.data.PutEventsResponseEntry;
import org.apache.rocketmq.eventbridge.exception.code.DefaultErrorCode;

public class DefaultSendCallback implements SendCallback {

    PutEventCallback putEventCallback;

    PutEventsResponseEntry entry = new PutEventsResponseEntry();

    public DefaultSendCallback(PutEventCallback putEventCallback) {
        this.putEventCallback = putEventCallback;
    }

    @Override
    public void onSuccess(SendResult sendResult) {
        entry.setEventId(sendResult.getMsgId());
        entry.setErrorCode(DefaultErrorCode.Success.getCode());
        putEventCallback.endProcess(entry);
    }

    @Override
    public void onException(Throwable throwable) {
        entry.setErrorCode(DefaultErrorCode.InternalError.getCode());
        entry.setErrorMessage(throwable.getMessage());
        putEventCallback.endProcess(entry);
    }
}
