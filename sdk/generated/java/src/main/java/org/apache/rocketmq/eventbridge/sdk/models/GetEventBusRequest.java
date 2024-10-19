// This file is auto-generated, don't edit it. Thanks.
package org.apache.rocketmq.eventbridge.sdk.models;

import com.aliyun.tea.*;

public class GetEventBusRequest extends TeaModel {
    /**
     * <p>The name of the event bus. This parameter is required.</p>
     * 
     * <strong>example:</strong>
     * <p>MyEventBus</p>
     */
    @NameInMap("eventBusName")
    public String eventBusName;

    public static GetEventBusRequest build(java.util.Map<String, ?> map) throws Exception {
        GetEventBusRequest self = new GetEventBusRequest();
        return TeaModel.build(map, self);
    }

    public GetEventBusRequest setEventBusName(String eventBusName) {
        this.eventBusName = eventBusName;
        return this;
    }
    public String getEventBusName() {
        return this.eventBusName;
    }

}
