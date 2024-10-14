// This file is auto-generated, don't edit it. Thanks.
package org.apache.rocketmq.eventbridge.sdk.models;

import com.aliyun.tea.*;

public class ListEventTypesResponseBody extends TeaModel {
    @NameInMap("eventTypes")
    public java.util.List<ListEventTypesResponseBodyEventTypes> eventTypes;

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

    /**
     * <p>The status code returned. The status code 200 indicates that the request was successful.</p>
     * 
     * <strong>example:</strong>
     * <p>200</p>
     */
    @NameInMap("code")
    public String code;

    /**
     * <p>The error message that is returned if the request failed.</p>
     * 
     * <strong>example:</strong>
     * <p>EventBusNotExist</p>
     */
    @NameInMap("message")
    public String message;

    /**
     * <p>The request ID.</p>
     * 
     * <strong>example:</strong>
     * <p>580A938B-6107-586C-8EC7-F22EEBEDA9E6</p>
     */
    @NameInMap("requestId")
    public String requestId;

    public static ListEventTypesResponseBody build(java.util.Map<String, ?> map) throws Exception {
        ListEventTypesResponseBody self = new ListEventTypesResponseBody();
        return TeaModel.build(map, self);
    }

    public ListEventTypesResponseBody setEventTypes(java.util.List<ListEventTypesResponseBodyEventTypes> eventTypes) {
        this.eventTypes = eventTypes;
        return this;
    }
    public java.util.List<ListEventTypesResponseBodyEventTypes> getEventTypes() {
        return this.eventTypes;
    }

    public ListEventTypesResponseBody setNextToken(String nextToken) {
        this.nextToken = nextToken;
        return this;
    }
    public String getNextToken() {
        return this.nextToken;
    }

    public ListEventTypesResponseBody setTotal(Integer total) {
        this.total = total;
        return this;
    }
    public Integer getTotal() {
        return this.total;
    }

    public ListEventTypesResponseBody setMaxResults(Integer maxResults) {
        this.maxResults = maxResults;
        return this;
    }
    public Integer getMaxResults() {
        return this.maxResults;
    }

    public ListEventTypesResponseBody setCode(String code) {
        this.code = code;
        return this;
    }
    public String getCode() {
        return this.code;
    }

    public ListEventTypesResponseBody setMessage(String message) {
        this.message = message;
        return this;
    }
    public String getMessage() {
        return this.message;
    }

    public ListEventTypesResponseBody setRequestId(String requestId) {
        this.requestId = requestId;
        return this;
    }
    public String getRequestId() {
        return this.requestId;
    }

    public static class ListEventTypesResponseBodyEventTypes extends TeaModel {
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
         * <p>The name of the event type.</p>
         */
        @NameInMap("eventTypeName")
        public String eventTypeName;

        /**
         * <p>The description of the event type.</p>
         * 
         * <strong>example:</strong>
         * <p>The description of the event type.</p>
         */
        @NameInMap("description")
        public String description;

        @NameInMap("gmtCreate")
        public String gmtCreate;

        @NameInMap("gmtModify")
        public String gmtModify;

        public static ListEventTypesResponseBodyEventTypes build(java.util.Map<String, ?> map) throws Exception {
            ListEventTypesResponseBodyEventTypes self = new ListEventTypesResponseBodyEventTypes();
            return TeaModel.build(map, self);
        }

        public ListEventTypesResponseBodyEventTypes setEventBusName(String eventBusName) {
            this.eventBusName = eventBusName;
            return this;
        }
        public String getEventBusName() {
            return this.eventBusName;
        }

        public ListEventTypesResponseBodyEventTypes setEventSourceName(String eventSourceName) {
            this.eventSourceName = eventSourceName;
            return this;
        }
        public String getEventSourceName() {
            return this.eventSourceName;
        }

        public ListEventTypesResponseBodyEventTypes setEventTypeName(String eventTypeName) {
            this.eventTypeName = eventTypeName;
            return this;
        }
        public String getEventTypeName() {
            return this.eventTypeName;
        }

        public ListEventTypesResponseBodyEventTypes setDescription(String description) {
            this.description = description;
            return this;
        }
        public String getDescription() {
            return this.description;
        }

        public ListEventTypesResponseBodyEventTypes setGmtCreate(String gmtCreate) {
            this.gmtCreate = gmtCreate;
            return this;
        }
        public String getGmtCreate() {
            return this.gmtCreate;
        }

        public ListEventTypesResponseBodyEventTypes setGmtModify(String gmtModify) {
            this.gmtModify = gmtModify;
            return this;
        }
        public String getGmtModify() {
            return this.gmtModify;
        }

    }

}
