// This file is auto-generated, don't edit it. Thanks.
package org.apache.rocketmq.eventbridge.sdk.models;

import com.aliyun.tea.*;

/**
 * <b>description</b> :
 * <p>EventType Controller apis:
 * listEventTypes *</p>
 */
public class ListEventTypesRequest extends TeaModel {
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
     * <p>EventSource is required for querying default bus events.</p>
     * 
     * <strong>example:</strong>
     * <p>testEventSourceName</p>
     */
    @NameInMap("eventSourceName")
    public String eventSourceName;

    /**
     * <p>The number of entries returned per page.</p>
     * 
     * <strong>example:</strong>
     * <p>10</p>
     */
    @NameInMap("maxResults")
    public Integer maxResults;

    /**
     * <p>If excess return values exist, this parameter is returned.</p>
     * 
     * <strong>example:</strong>
     * <p>0</p>
     */
    @NameInMap("nextToken")
    public String nextToken;

    public static ListEventTypesRequest build(java.util.Map<String, ?> map) throws Exception {
        ListEventTypesRequest self = new ListEventTypesRequest();
        return TeaModel.build(map, self);
    }

    public ListEventTypesRequest setEventBusName(String eventBusName) {
        this.eventBusName = eventBusName;
        return this;
    }
    public String getEventBusName() {
        return this.eventBusName;
    }

    public ListEventTypesRequest setEventSourceName(String eventSourceName) {
        this.eventSourceName = eventSourceName;
        return this;
    }
    public String getEventSourceName() {
        return this.eventSourceName;
    }

    public ListEventTypesRequest setMaxResults(Integer maxResults) {
        this.maxResults = maxResults;
        return this;
    }
    public Integer getMaxResults() {
        return this.maxResults;
    }

    public ListEventTypesRequest setNextToken(String nextToken) {
        this.nextToken = nextToken;
        return this;
    }
    public String getNextToken() {
        return this.nextToken;
    }

}
