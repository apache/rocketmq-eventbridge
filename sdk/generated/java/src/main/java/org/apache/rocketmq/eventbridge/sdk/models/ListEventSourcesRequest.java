// This file is auto-generated, don't edit it. Thanks.
package org.apache.rocketmq.eventbridge.sdk.models;

import com.aliyun.tea.*;

public class ListEventSourcesRequest extends TeaModel {
    @NameInMap("eventBusName")
    public String eventBusName;

    /**
     * <p>The type of the event source.
     * This parameter is required.</p>
     * 
     * <strong>example:</strong>
     * <p>USER_DEFINED</p>
     */
    @NameInMap("eventSourceType")
    public String eventSourceType;

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

    public static ListEventSourcesRequest build(java.util.Map<String, ?> map) throws Exception {
        ListEventSourcesRequest self = new ListEventSourcesRequest();
        return TeaModel.build(map, self);
    }

    public ListEventSourcesRequest setEventBusName(String eventBusName) {
        this.eventBusName = eventBusName;
        return this;
    }
    public String getEventBusName() {
        return this.eventBusName;
    }

    public ListEventSourcesRequest setEventSourceType(String eventSourceType) {
        this.eventSourceType = eventSourceType;
        return this;
    }
    public String getEventSourceType() {
        return this.eventSourceType;
    }

    public ListEventSourcesRequest setMaxResults(Integer maxResults) {
        this.maxResults = maxResults;
        return this;
    }
    public Integer getMaxResults() {
        return this.maxResults;
    }

    public ListEventSourcesRequest setNextToken(String nextToken) {
        this.nextToken = nextToken;
        return this;
    }
    public String getNextToken() {
        return this.nextToken;
    }

}
