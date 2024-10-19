// This file is auto-generated, don't edit it. Thanks.
package org.apache.rocketmq.eventbridge.sdk.models;

import com.aliyun.tea.*;

public class GetEventSourceResponseBody extends TeaModel {
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
     * <p>The name of the event source.
     * This parameter is required.</p>
     * 
     * <strong>example:</strong>
     * <p>myrabbitmq.sourc</p>
     */
    @NameInMap("eventSourceName")
    public String eventSourceName;

    /**
     * <p>The description of the event source.</p>
     */
    @NameInMap("description")
    public String description;

    @NameInMap("className")
    public String className;

    @NameInMap("config")
    public java.util.Map<String, ?> config;

    public static GetEventSourceResponseBody build(java.util.Map<String, ?> map) throws Exception {
        GetEventSourceResponseBody self = new GetEventSourceResponseBody();
        return TeaModel.build(map, self);
    }

    public GetEventSourceResponseBody setEventBusName(String eventBusName) {
        this.eventBusName = eventBusName;
        return this;
    }
    public String getEventBusName() {
        return this.eventBusName;
    }

    public GetEventSourceResponseBody setEventSourceName(String eventSourceName) {
        this.eventSourceName = eventSourceName;
        return this;
    }
    public String getEventSourceName() {
        return this.eventSourceName;
    }

    public GetEventSourceResponseBody setDescription(String description) {
        this.description = description;
        return this;
    }
    public String getDescription() {
        return this.description;
    }

    public GetEventSourceResponseBody setClassName(String className) {
        this.className = className;
        return this;
    }
    public String getClassName() {
        return this.className;
    }

    public GetEventSourceResponseBody setConfig(java.util.Map<String, ?> config) {
        this.config = config;
        return this;
    }
    public java.util.Map<String, ?> getConfig() {
        return this.config;
    }

}
