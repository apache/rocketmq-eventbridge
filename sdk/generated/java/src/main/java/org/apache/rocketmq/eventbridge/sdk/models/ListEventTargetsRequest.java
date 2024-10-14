// This file is auto-generated, don't edit it. Thanks.
package org.apache.rocketmq.eventbridge.sdk.models;

import com.aliyun.tea.*;

public class ListEventTargetsRequest extends TeaModel {
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

    public static ListEventTargetsRequest build(java.util.Map<String, ?> map) throws Exception {
        ListEventTargetsRequest self = new ListEventTargetsRequest();
        return TeaModel.build(map, self);
    }

    public ListEventTargetsRequest setEventBusName(String eventBusName) {
        this.eventBusName = eventBusName;
        return this;
    }
    public String getEventBusName() {
        return this.eventBusName;
    }

    public ListEventTargetsRequest setEventRuleName(String eventRuleName) {
        this.eventRuleName = eventRuleName;
        return this;
    }
    public String getEventRuleName() {
        return this.eventRuleName;
    }

}
