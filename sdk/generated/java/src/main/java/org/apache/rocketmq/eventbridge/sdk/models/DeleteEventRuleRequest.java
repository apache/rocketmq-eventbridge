// This file is auto-generated, don't edit it. Thanks.
package org.apache.rocketmq.eventbridge.sdk.models;

import com.aliyun.tea.*;

public class DeleteEventRuleRequest extends TeaModel {
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
     * <p>The name of the event rule.
     * This parameter is required.</p>
     * 
     * <strong>example:</strong>
     * <p>myrabbitmq.sourc</p>
     */
    @NameInMap("eventRuleName")
    public String eventRuleName;

    public static DeleteEventRuleRequest build(java.util.Map<String, ?> map) throws Exception {
        DeleteEventRuleRequest self = new DeleteEventRuleRequest();
        return TeaModel.build(map, self);
    }

    public DeleteEventRuleRequest setEventBusName(String eventBusName) {
        this.eventBusName = eventBusName;
        return this;
    }
    public String getEventBusName() {
        return this.eventBusName;
    }

    public DeleteEventRuleRequest setEventRuleName(String eventRuleName) {
        this.eventRuleName = eventRuleName;
        return this;
    }
    public String getEventRuleName() {
        return this.eventRuleName;
    }

}
