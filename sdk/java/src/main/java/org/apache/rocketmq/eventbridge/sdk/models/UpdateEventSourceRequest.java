// This file is auto-generated, don't edit it. Thanks.
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
package org.apache.rocketmq.eventbridge.sdk.models;

import com.aliyun.tea.*;

public class UpdateEventSourceRequest extends TeaModel {
    /**
     * <p>The name of the event bus with which the event source is associated.
     * This parameter is required.</p>
     * 
     * <strong>example:</strong>
     * <p>my-event-bus</p>
     */
    @NameInMap("eventBusName")
    public String eventBusName;

    /**
     * <p>The name of the event source.
     * This parameter is required.</p>
     * 
     * <strong>example:</strong>
     * <p>myrabbitmq.sourc</p>
     */
    @NameInMap("eventSourceName")
    public String eventSourceName;

    /**
     * <p>The description of the event source.</p>
     */
    @NameInMap("description")
    public String description;

    @NameInMap("className")
    public String className;

    @NameInMap("status")
    public Integer status;

    @NameInMap("config")
    public java.util.Map<String, ?> config;

    public static UpdateEventSourceRequest build(java.util.Map<String, ?> map) throws Exception {
        UpdateEventSourceRequest self = new UpdateEventSourceRequest();
        return TeaModel.build(map, self);
    }

    public UpdateEventSourceRequest setEventBusName(String eventBusName) {
        this.eventBusName = eventBusName;
        return this;
    }
    public String getEventBusName() {
        return this.eventBusName;
    }

    public UpdateEventSourceRequest setEventSourceName(String eventSourceName) {
        this.eventSourceName = eventSourceName;
        return this;
    }
    public String getEventSourceName() {
        return this.eventSourceName;
    }

    public UpdateEventSourceRequest setDescription(String description) {
        this.description = description;
        return this;
    }
    public String getDescription() {
        return this.description;
    }

    public UpdateEventSourceRequest setClassName(String className) {
        this.className = className;
        return this;
    }
    public String getClassName() {
        return this.className;
    }

    public UpdateEventSourceRequest setStatus(Integer status) {
        this.status = status;
        return this;
    }
    public Integer getStatus() {
        return this.status;
    }

    public UpdateEventSourceRequest setConfig(java.util.Map<String, ?> config) {
        this.config = config;
        return this;
    }
    public java.util.Map<String, ?> getConfig() {
        return this.config;
    }

}