// This file is auto-generated, don't edit it. Thanks.
package org.apache.rocketmq.eventbridge.sdk.models;

import com.aliyun.tea.*;

public class ListEventSourcesResponseBody extends TeaModel {
    @NameInMap("eventSources")
    public java.util.List<ListEventSourcesResponseBodyEventSources> eventSources;

    /**
     * <p>The total number of entries.</p>
     * 
     * <strong>example:</strong>
     * <p>2</p>
     */
    @NameInMap("total")
    public Integer total;

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

    public static ListEventSourcesResponseBody build(java.util.Map<String, ?> map) throws Exception {
        ListEventSourcesResponseBody self = new ListEventSourcesResponseBody();
        return TeaModel.build(map, self);
    }

    public ListEventSourcesResponseBody setEventSources(java.util.List<ListEventSourcesResponseBodyEventSources> eventSources) {
        this.eventSources = eventSources;
        return this;
    }
    public java.util.List<ListEventSourcesResponseBodyEventSources> getEventSources() {
        return this.eventSources;
    }

    public ListEventSourcesResponseBody setTotal(Integer total) {
        this.total = total;
        return this;
    }
    public Integer getTotal() {
        return this.total;
    }

    public ListEventSourcesResponseBody setMaxResults(Integer maxResults) {
        this.maxResults = maxResults;
        return this;
    }
    public Integer getMaxResults() {
        return this.maxResults;
    }

    public ListEventSourcesResponseBody setNextToken(String nextToken) {
        this.nextToken = nextToken;
        return this;
    }
    public String getNextToken() {
        return this.nextToken;
    }

    public static class ListEventSourcesResponseBodyEventSources extends TeaModel {
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
         * <p>The description of the event type.</p>
         * 
         * <strong>example:</strong>
         * <p>The description of the event type.</p>
         */
        @NameInMap("description")
        public String description;

        @NameInMap("className")
        public String className;

        @NameInMap("config")
        public java.util.Map<String, ?> config;

        @NameInMap("gmtCreate")
        public String gmtCreate;

        @NameInMap("gmtModify")
        public String gmtModify;

        public static ListEventSourcesResponseBodyEventSources build(java.util.Map<String, ?> map) throws Exception {
            ListEventSourcesResponseBodyEventSources self = new ListEventSourcesResponseBodyEventSources();
            return TeaModel.build(map, self);
        }

        public ListEventSourcesResponseBodyEventSources setEventBusName(String eventBusName) {
            this.eventBusName = eventBusName;
            return this;
        }
        public String getEventBusName() {
            return this.eventBusName;
        }

        public ListEventSourcesResponseBodyEventSources setEventSourceName(String eventSourceName) {
            this.eventSourceName = eventSourceName;
            return this;
        }
        public String getEventSourceName() {
            return this.eventSourceName;
        }

        public ListEventSourcesResponseBodyEventSources setDescription(String description) {
            this.description = description;
            return this;
        }
        public String getDescription() {
            return this.description;
        }

        public ListEventSourcesResponseBodyEventSources setClassName(String className) {
            this.className = className;
            return this;
        }
        public String getClassName() {
            return this.className;
        }

        public ListEventSourcesResponseBodyEventSources setConfig(java.util.Map<String, ?> config) {
            this.config = config;
            return this;
        }
        public java.util.Map<String, ?> getConfig() {
            return this.config;
        }

        public ListEventSourcesResponseBodyEventSources setGmtCreate(String gmtCreate) {
            this.gmtCreate = gmtCreate;
            return this;
        }
        public String getGmtCreate() {
            return this.gmtCreate;
        }

        public ListEventSourcesResponseBodyEventSources setGmtModify(String gmtModify) {
            this.gmtModify = gmtModify;
            return this;
        }
        public String getGmtModify() {
            return this.gmtModify;
        }

    }

}
