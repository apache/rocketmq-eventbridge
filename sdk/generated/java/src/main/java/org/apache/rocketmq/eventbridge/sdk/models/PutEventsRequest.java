// This file is auto-generated, don't edit it. Thanks.
package org.apache.rocketmq.eventbridge.sdk.models;

import com.aliyun.tea.*;

/**
 * <b>description</b> :
 * <p>EventData Controller apis:
 * putEvents </p>
 */
public class PutEventsRequest extends TeaModel {
    /**
     * <p>The name of the event bus.
     * This parameter is required.</p>
     * 
     * <strong>example:</strong>
     * <p>demo</p>
     */
    @NameInMap("eventBusName")
    public String eventBusName;

    /**
     * <p>The content of the event.</p>
     * 
     * <strong>example:</strong>
     * <p>The description of the event.</p>
     */
    @NameInMap("event")
    public String event;

    public static PutEventsRequest build(java.util.Map<String, ?> map) throws Exception {
        PutEventsRequest self = new PutEventsRequest();
        return TeaModel.build(map, self);
    }

    public PutEventsRequest setEventBusName(String eventBusName) {
        this.eventBusName = eventBusName;
        return this;
    }
    public String getEventBusName() {
        return this.eventBusName;
    }

    public PutEventsRequest setEvent(String event) {
        this.event = event;
        return this;
    }
    public String getEvent() {
        return this.event;
    }

}
