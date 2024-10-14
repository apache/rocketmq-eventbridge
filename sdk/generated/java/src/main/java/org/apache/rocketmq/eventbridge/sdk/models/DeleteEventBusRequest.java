// This file is auto-generated, don't edit it. Thanks.
package org.apache.rocketmq.eventbridge.sdk.models;

import com.aliyun.tea.*;

public class DeleteEventBusRequest extends TeaModel {
    /**
     * <p>The name of the event bus. This parameter is required.</p>
     * 
     * <strong>example:</strong>
     * <p>MyEventBus</p>
     */
    @NameInMap("eventBusName")
    public String eventBusName;

    public static DeleteEventBusRequest build(java.util.Map<String, ?> map) throws Exception {
        DeleteEventBusRequest self = new DeleteEventBusRequest();
        return TeaModel.build(map, self);
    }

    public DeleteEventBusRequest setEventBusName(String eventBusName) {
        this.eventBusName = eventBusName;
        return this;
    }
    public String getEventBusName() {
        return this.eventBusName;
    }

}
