// This file is auto-generated, don't edit it. Thanks.
package org.apache.rocketmq.eventbridge.sdk.models;

import com.aliyun.tea.*;

/**
 * <b>description</b> :
 * <p>EventBus Controller apis:
 * createEventBus *
 * getEventBus    *
 * deleteEventBus *
 * listEventBuses *</p>
 */
public class CreateEventBusRequest extends TeaModel {
    /**
     * <p>The description of the event bus.</p>
     * 
     * <strong>example:</strong>
     * <p>demo</p>
     */
    @NameInMap("description")
    public String description;

    /**
     * <p>The name of the event bus. This parameter is required.</p>
     * 
     * <strong>example:</strong>
     * <p>MyEventBus</p>
     */
    @NameInMap("eventBusName")
    public String eventBusName;

    public static CreateEventBusRequest build(java.util.Map<String, ?> map) throws Exception {
        CreateEventBusRequest self = new CreateEventBusRequest();
        return TeaModel.build(map, self);
    }

    public CreateEventBusRequest setDescription(String description) {
        this.description = description;
        return this;
    }
    public String getDescription() {
        return this.description;
    }

    public CreateEventBusRequest setEventBusName(String eventBusName) {
        this.eventBusName = eventBusName;
        return this;
    }
    public String getEventBusName() {
        return this.eventBusName;
    }

}
