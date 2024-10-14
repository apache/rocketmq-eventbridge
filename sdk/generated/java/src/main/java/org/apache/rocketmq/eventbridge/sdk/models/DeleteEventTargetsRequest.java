// This file is auto-generated, don't edit it. Thanks.
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
