// This file is auto-generated, don't edit it. Thanks.
package org.apache.rocketmq.eventbridge.sdk.models;

import com.aliyun.tea.*;

public class GetEventSourceRequest extends TeaModel {
    @NameInMap("eventBusName")
    public String eventBusName;

    /**
     * <p>The name of the event source.
     * This parameter is required.</p>
     * 
     * <strong>example:</strong>
     * <p>myrabbitmq.source</p>
     */
    @NameInMap("eventSourceName")
    public String eventSourceName;

    public static GetEventSourceRequest build(java.util.Map<String, ?> map) throws Exception {
        GetEventSourceRequest self = new GetEventSourceRequest();
        return TeaModel.build(map, self);
    }

    public GetEventSourceRequest setEventBusName(String eventBusName) {
        this.eventBusName = eventBusName;
        return this;
    }
    public String getEventBusName() {
        return this.eventBusName;
    }

    public GetEventSourceRequest setEventSourceName(String eventSourceName) {
        this.eventSourceName = eventSourceName;
        return this;
    }
    public String getEventSourceName() {
        return this.eventSourceName;
    }

}
