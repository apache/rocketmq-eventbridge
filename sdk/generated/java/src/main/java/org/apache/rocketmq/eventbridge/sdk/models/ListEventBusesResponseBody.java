// This file is auto-generated, don't edit it. Thanks.
package org.apache.rocketmq.eventbridge.sdk.models;

import com.aliyun.tea.*;

public class ListEventBusesResponseBody extends TeaModel {
    /**
     * <p>The returned HTTP status code. The HTTP status code 200 indicates that the request is successful.</p>
     * 
     * <strong>example:</strong>
     * <p>200</p>
     */
    @NameInMap("code")
    public String code;

    /**
     * <p>The timestamp that indicates when the event bus was created.</p>
     */
    @NameInMap("eventBuses")
    public java.util.List<ListEventBusesResponseBodyEventBuses> eventBuses;

    /**
     * <p>The returned error message.</p>
     * 
     * <strong>example:</strong>
     * <p>InvalidArgument</p>
     */
    @NameInMap("message")
    public String message;

    /**
     * <p>The request ID.</p>
     * 
     * <strong>example:</strong>
     * <p>D1DCF64A-3F2C-5323-ADCB-3F4DF30FAD2D</p>
     */
    @NameInMap("requestId")
    public String requestId;

    /**
     * <p>If excess return values exist, this parameter is returned.</p>
     * 
     * <strong>example:</strong>
     * <p>10</p>
     */
    @NameInMap("nextToken")
    public String nextToken;

    /**
     * <p>The total number of entries.</p>
     * 
     * <strong>example:</strong>
     * <p>2</p>
     */
    @NameInMap("total")
    public Integer total;

    /**
     * <p>If you set Limit and excess return values exist, this parameter is returned.</p>
     * 
     * <strong>example:</strong>
     * <p>10</p>
     */
    @NameInMap("maxResults")
    public Integer maxResults;

    public static ListEventBusesResponseBody build(java.util.Map<String, ?> map) throws Exception {
        ListEventBusesResponseBody self = new ListEventBusesResponseBody();
        return TeaModel.build(map, self);
    }

    public ListEventBusesResponseBody setCode(String code) {
        this.code = code;
        return this;
    }
    public String getCode() {
        return this.code;
    }

    public ListEventBusesResponseBody setEventBuses(java.util.List<ListEventBusesResponseBodyEventBuses> eventBuses) {
        this.eventBuses = eventBuses;
        return this;
    }
    public java.util.List<ListEventBusesResponseBodyEventBuses> getEventBuses() {
        return this.eventBuses;
    }

    public ListEventBusesResponseBody setMessage(String message) {
        this.message = message;
        return this;
    }
    public String getMessage() {
        return this.message;
    }

    public ListEventBusesResponseBody setRequestId(String requestId) {
        this.requestId = requestId;
        return this;
    }
    public String getRequestId() {
        return this.requestId;
    }

    public ListEventBusesResponseBody setNextToken(String nextToken) {
        this.nextToken = nextToken;
        return this;
    }
    public String getNextToken() {
        return this.nextToken;
    }

    public ListEventBusesResponseBody setTotal(Integer total) {
        this.total = total;
        return this;
    }
    public Integer getTotal() {
        return this.total;
    }

    public ListEventBusesResponseBody setMaxResults(Integer maxResults) {
        this.maxResults = maxResults;
        return this;
    }
    public Integer getMaxResults() {
        return this.maxResults;
    }

    public static class ListEventBusesResponseBodyEventBuses extends TeaModel {
        /**
         * <p>The description of the queried event bus.</p>
         * 
         * <strong>example:</strong>
         * <p>bus_description</p>
         */
        @NameInMap("description")
        public String description;

        /**
         * <p>The name of the queried event bus.</p>
         * 
         * <strong>example:</strong>
         * <p>default</p>
         */
        @NameInMap("eventBusName")
        public String eventBusName;

        public static ListEventBusesResponseBodyEventBuses build(java.util.Map<String, ?> map) throws Exception {
            ListEventBusesResponseBodyEventBuses self = new ListEventBusesResponseBodyEventBuses();
            return TeaModel.build(map, self);
        }

        public ListEventBusesResponseBodyEventBuses setDescription(String description) {
            this.description = description;
            return this;
        }
        public String getDescription() {
            return this.description;
        }

        public ListEventBusesResponseBodyEventBuses setEventBusName(String eventBusName) {
            this.eventBusName = eventBusName;
            return this;
        }
        public String getEventBusName() {
            return this.eventBusName;
        }

    }

}
