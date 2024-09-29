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

public class DeleteEventTargetsRequest extends TeaModel {
    /**
     * <p>The name of the event bus.</p>
     * 
     * <strong>example:</strong>
     * <p>MyEventBus</p>
     */
    @NameInMap("eventBusName")
    @Validation(required = true)
    public String eventBusName;

    /**
     * <p>The name of the event rule.</p>
     * 
     * <strong>example:</strong>
     * <p>ramrolechange-mns</p>
     */
    @NameInMap("eventRuleName")
    @Validation(required = true)
    public String eventRuleName;

    /**
     * <p>The names of the event targets that you want to delete.</p>
     */
    @NameInMap("eventTargetNames")
    public java.util.List<String> eventTargetNames;

    public static DeleteEventTargetsRequest build(java.util.Map<String, ?> map) throws Exception {
        DeleteEventTargetsRequest self = new DeleteEventTargetsRequest();
        return TeaModel.build(map, self);
    }

    public DeleteEventTargetsRequest setEventBusName(String eventBusName) {
        this.eventBusName = eventBusName;
        return this;
    }
    public String getEventBusName() {
        return this.eventBusName;
    }

    public DeleteEventTargetsRequest setEventRuleName(String eventRuleName) {
        this.eventRuleName = eventRuleName;
        return this;
    }
    public String getEventRuleName() {
        return this.eventRuleName;
    }

    public DeleteEventTargetsRequest setEventTargetNames(java.util.List<String> eventTargetNames) {
        this.eventTargetNames = eventTargetNames;
        return this;
    }
    public java.util.List<String> getEventTargetNames() {
        return this.eventTargetNames;
    }

}
