// This file is auto-generated, don't edit it. Thanks.
package org.apache.rocketmq.eventbridge.sdk.models;

import com.aliyun.tea.*;

public class ListEventRulesResponseBody extends TeaModel {
    @NameInMap("eventRules")
    public java.util.List<ListEventRulesResponseBodyEventRules> eventRules;

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

    public static ListEventRulesResponseBody build(java.util.Map<String, ?> map) throws Exception {
        ListEventRulesResponseBody self = new ListEventRulesResponseBody();
        return TeaModel.build(map, self);
    }

    public ListEventRulesResponseBody setEventRules(java.util.List<ListEventRulesResponseBodyEventRules> eventRules) {
        this.eventRules = eventRules;
        return this;
    }
    public java.util.List<ListEventRulesResponseBodyEventRules> getEventRules() {
        return this.eventRules;
    }

    public ListEventRulesResponseBody setTotal(Integer total) {
        this.total = total;
        return this;
    }
    public Integer getTotal() {
        return this.total;
    }

    public ListEventRulesResponseBody setMaxResults(Integer maxResults) {
        this.maxResults = maxResults;
        return this;
    }
    public Integer getMaxResults() {
        return this.maxResults;
    }

    public ListEventRulesResponseBody setNextToken(String nextToken) {
        this.nextToken = nextToken;
        return this;
    }
    public String getNextToken() {
        return this.nextToken;
    }

    public static class ListEventRulesResponseBodyEventRules extends TeaModel {
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
         * <p>The name of the event rule.
         * This parameter is required.</p>
         * 
         * <strong>example:</strong>
         * <p>myrabbitmq.sourc</p>
         */
        @NameInMap("eventRuleName")
        public String eventRuleName;

        @NameInMap("description")
        public String description;

        /**
         * <p>The event pattern, in JSON format. Valid values: stringEqual and stringExpression. You can specify up to five expressions in the map data structure in each field.</p>
         * <pre><code>    You can specify up to five expressions in the map data structure in each field.
         * </code></pre>
         * 
         * <strong>example:</strong>
         * <p>{&quot;source&quot;: [{&quot;prefix&quot;: &quot;acs.&quot;}],&quot;type&quot;: [{&quot;prefix&quot;:&quot;oss:ObjectReplication&quot;}],&quot;subject&quot;:[{&quot;prefix&quot;:&quot;acs:oss:cn-hangzhou:123456789098****:my-movie-bucket/&quot;, &quot;suffix&quot;:&quot;.txt&quot;}]}</p>
         */
        @NameInMap("filterPattern")
        public String filterPattern;

        /**
         * <p>The status of the event rule. Valid values: ENABLE (default): The event rule is enabled. DISABLE: The event rule is disabled.</p>
         * 
         * <strong>example:</strong>
         * <p>ENABLE</p>
         */
        @NameInMap("status")
        public String status;

        @NameInMap("gmtCreate")
        public String gmtCreate;

        @NameInMap("gmtModify")
        public String gmtModify;

        public static ListEventRulesResponseBodyEventRules build(java.util.Map<String, ?> map) throws Exception {
            ListEventRulesResponseBodyEventRules self = new ListEventRulesResponseBodyEventRules();
            return TeaModel.build(map, self);
        }

        public ListEventRulesResponseBodyEventRules setEventBusName(String eventBusName) {
            this.eventBusName = eventBusName;
            return this;
        }
        public String getEventBusName() {
            return this.eventBusName;
        }

        public ListEventRulesResponseBodyEventRules setEventRuleName(String eventRuleName) {
            this.eventRuleName = eventRuleName;
            return this;
        }
        public String getEventRuleName() {
            return this.eventRuleName;
        }

        public ListEventRulesResponseBodyEventRules setDescription(String description) {
            this.description = description;
            return this;
        }
        public String getDescription() {
            return this.description;
        }

        public ListEventRulesResponseBodyEventRules setFilterPattern(String filterPattern) {
            this.filterPattern = filterPattern;
            return this;
        }
        public String getFilterPattern() {
            return this.filterPattern;
        }

        public ListEventRulesResponseBodyEventRules setStatus(String status) {
            this.status = status;
            return this;
        }
        public String getStatus() {
            return this.status;
        }

        public ListEventRulesResponseBodyEventRules setGmtCreate(String gmtCreate) {
            this.gmtCreate = gmtCreate;
            return this;
        }
        public String getGmtCreate() {
            return this.gmtCreate;
        }

        public ListEventRulesResponseBodyEventRules setGmtModify(String gmtModify) {
            this.gmtModify = gmtModify;
            return this;
        }
        public String getGmtModify() {
            return this.gmtModify;
        }

    }

}
