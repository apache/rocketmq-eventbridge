// This file is auto-generated, don't edit it. Thanks.
package org.apache.rocketmq.eventbridge.sdk.models;

import com.aliyun.tea.*;

public class UpdateEventTargetsRequest extends TeaModel {
    /**
     * <p>The name of the event bus with which the event target is associated.
     * This parameter is required.</p>
     * 
     * <strong>example:</strong>
     * <p>my-event-bus</p>
     */
    @NameInMap("eventBusName")
    public String eventBusName;

    /**
     * <p>The name of the event rule.
     * This parameter is required.</p>
     * 
     * <strong>example:</strong>
     * <p>myrabbitmq.sourc</p>
     */
    @NameInMap("eventRuleName")
    public String eventRuleName;

    @NameInMap("eventTargets")
    public java.util.List<EventTarget> eventTargets;

    public static UpdateEventTargetsRequest build(java.util.Map<String, ?> map) throws Exception {
        UpdateEventTargetsRequest self = new UpdateEventTargetsRequest();
        return TeaModel.build(map, self);
    }

    public UpdateEventTargetsRequest setEventBusName(String eventBusName) {
        this.eventBusName = eventBusName;
        return this;
    }
    public String getEventBusName() {
        return this.eventBusName;
    }

    public UpdateEventTargetsRequest setEventRuleName(String eventRuleName) {
        this.eventRuleName = eventRuleName;
        return this;
    }
    public String getEventRuleName() {
        return this.eventRuleName;
    }

    public UpdateEventTargetsRequest setEventTargets(java.util.List<EventTarget> eventTargets) {
        this.eventTargets = eventTargets;
        return this;
    }
    public java.util.List<EventTarget> getEventTargets() {
        return this.eventTargets;
    }

}
