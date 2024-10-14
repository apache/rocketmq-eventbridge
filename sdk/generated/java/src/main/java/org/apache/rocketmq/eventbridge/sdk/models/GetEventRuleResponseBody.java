// This file is auto-generated, don't edit it. Thanks.
package org.apache.rocketmq.eventbridge.sdk.models;

import com.aliyun.tea.*;

public class GetEventRuleResponseBody extends TeaModel {
    /**
     * <p>The returned response code. Valid values:</p>
     * <pre><code>*   Success: The request is successful.
     * 
     * *   Other codes: The request failed. For more information about error codes, see Error codes.
     * </code></pre>
     * 
     * <strong>example:</strong>
     * <p>Success</p>
     */
    @NameInMap("code")
    public String code;

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
     * <pre><code>You can specify up to five expressions in the map data structure in each field.
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

    @NameInMap("eventTargets")
    public java.util.List<GetEventRuleResponseBodyEventTargets> eventTargets;

    /**
     * <p>The returned error message.</p>
     * 
     * <strong>example:</strong>
     * <p>Remote error. requestId: [A8EFABD2-95B9-1C46-9E01-xxxx], error code: [CreateRelatedResourceFailed], message: [Create related resource failed, EntityNotExist.Role : The role not exists: xxxx. \r\nRequestId : xxxx-168C-54ED-8FEB-BF11CB70AEB7]</p>
     */
    @NameInMap("message")
    public String message;

    /**
     * <p>The request ID.</p>
     * 
     * <strong>example:</strong>
     * <p>2922208e-e1c6-43ee-bfd1-aca50263bc8a</p>
     */
    @NameInMap("requestId")
    public String requestId;

    public static GetEventRuleResponseBody build(java.util.Map<String, ?> map) throws Exception {
        GetEventRuleResponseBody self = new GetEventRuleResponseBody();
        return TeaModel.build(map, self);
    }

    public GetEventRuleResponseBody setCode(String code) {
        this.code = code;
        return this;
    }
    public String getCode() {
        return this.code;
    }

    public GetEventRuleResponseBody setEventBusName(String eventBusName) {
        this.eventBusName = eventBusName;
        return this;
    }
    public String getEventBusName() {
        return this.eventBusName;
    }

    public GetEventRuleResponseBody setEventRuleName(String eventRuleName) {
        this.eventRuleName = eventRuleName;
        return this;
    }
    public String getEventRuleName() {
        return this.eventRuleName;
    }

    public GetEventRuleResponseBody setDescription(String description) {
        this.description = description;
        return this;
    }
    public String getDescription() {
        return this.description;
    }

    public GetEventRuleResponseBody setFilterPattern(String filterPattern) {
        this.filterPattern = filterPattern;
        return this;
    }
    public String getFilterPattern() {
        return this.filterPattern;
    }

    public GetEventRuleResponseBody setStatus(String status) {
        this.status = status;
        return this;
    }
    public String getStatus() {
        return this.status;
    }

    public GetEventRuleResponseBody setGmtCreate(String gmtCreate) {
        this.gmtCreate = gmtCreate;
        return this;
    }
    public String getGmtCreate() {
        return this.gmtCreate;
    }

    public GetEventRuleResponseBody setGmtModify(String gmtModify) {
        this.gmtModify = gmtModify;
        return this;
    }
    public String getGmtModify() {
        return this.gmtModify;
    }

    public GetEventRuleResponseBody setEventTargets(java.util.List<GetEventRuleResponseBodyEventTargets> eventTargets) {
        this.eventTargets = eventTargets;
        return this;
    }
    public java.util.List<GetEventRuleResponseBodyEventTargets> getEventTargets() {
        return this.eventTargets;
    }

    public GetEventRuleResponseBody setMessage(String message) {
        this.message = message;
        return this;
    }
    public String getMessage() {
        return this.message;
    }

    public GetEventRuleResponseBody setRequestId(String requestId) {
        this.requestId = requestId;
        return this;
    }
    public String getRequestId() {
        return this.requestId;
    }

    public static class GetEventRuleResponseBodyEventTargetsRunOptionsRetryStrategy extends TeaModel {
        @NameInMap("pushRetryStrategy")
        public String pushRetryStrategy;

        @NameInMap("maximumEventAgeInSeconds")
        public Integer maximumEventAgeInSeconds;

        @NameInMap("maximumRetryAttempts")
        public Integer maximumRetryAttempts;

        public static GetEventRuleResponseBodyEventTargetsRunOptionsRetryStrategy build(java.util.Map<String, ?> map) throws Exception {
            GetEventRuleResponseBodyEventTargetsRunOptionsRetryStrategy self = new GetEventRuleResponseBodyEventTargetsRunOptionsRetryStrategy();
            return TeaModel.build(map, self);
        }

        public GetEventRuleResponseBodyEventTargetsRunOptionsRetryStrategy setPushRetryStrategy(String pushRetryStrategy) {
            this.pushRetryStrategy = pushRetryStrategy;
            return this;
        }
        public String getPushRetryStrategy() {
            return this.pushRetryStrategy;
        }

        public GetEventRuleResponseBodyEventTargetsRunOptionsRetryStrategy setMaximumEventAgeInSeconds(Integer maximumEventAgeInSeconds) {
            this.maximumEventAgeInSeconds = maximumEventAgeInSeconds;
            return this;
        }
        public Integer getMaximumEventAgeInSeconds() {
            return this.maximumEventAgeInSeconds;
        }

        public GetEventRuleResponseBodyEventTargetsRunOptionsRetryStrategy setMaximumRetryAttempts(Integer maximumRetryAttempts) {
            this.maximumRetryAttempts = maximumRetryAttempts;
            return this;
        }
        public Integer getMaximumRetryAttempts() {
            return this.maximumRetryAttempts;
        }

    }

    public static class GetEventRuleResponseBodyEventTargetsRunOptionsDeadLetterQueue extends TeaModel {
        @NameInMap("type")
        public String type;

        @NameInMap("config")
        public java.util.Map<String, ?> config;

        public static GetEventRuleResponseBodyEventTargetsRunOptionsDeadLetterQueue build(java.util.Map<String, ?> map) throws Exception {
            GetEventRuleResponseBodyEventTargetsRunOptionsDeadLetterQueue self = new GetEventRuleResponseBodyEventTargetsRunOptionsDeadLetterQueue();
            return TeaModel.build(map, self);
        }

        public GetEventRuleResponseBodyEventTargetsRunOptionsDeadLetterQueue setType(String type) {
            this.type = type;
            return this;
        }
        public String getType() {
            return this.type;
        }

        public GetEventRuleResponseBodyEventTargetsRunOptionsDeadLetterQueue setConfig(java.util.Map<String, ?> config) {
            this.config = config;
            return this;
        }
        public java.util.Map<String, ?> getConfig() {
            return this.config;
        }

    }

    public static class GetEventRuleResponseBodyEventTargetsRunOptions extends TeaModel {
        @NameInMap("errorsTolerance")
        public String errorsTolerance;

        @NameInMap("retryStrategy")
        public GetEventRuleResponseBodyEventTargetsRunOptionsRetryStrategy retryStrategy;

        @NameInMap("deadLetterQueue")
        public GetEventRuleResponseBodyEventTargetsRunOptionsDeadLetterQueue deadLetterQueue;

        public static GetEventRuleResponseBodyEventTargetsRunOptions build(java.util.Map<String, ?> map) throws Exception {
            GetEventRuleResponseBodyEventTargetsRunOptions self = new GetEventRuleResponseBodyEventTargetsRunOptions();
            return TeaModel.build(map, self);
        }

        public GetEventRuleResponseBodyEventTargetsRunOptions setErrorsTolerance(String errorsTolerance) {
            this.errorsTolerance = errorsTolerance;
            return this;
        }
        public String getErrorsTolerance() {
            return this.errorsTolerance;
        }

        public GetEventRuleResponseBodyEventTargetsRunOptions setRetryStrategy(GetEventRuleResponseBodyEventTargetsRunOptionsRetryStrategy retryStrategy) {
            this.retryStrategy = retryStrategy;
            return this;
        }
        public GetEventRuleResponseBodyEventTargetsRunOptionsRetryStrategy getRetryStrategy() {
            return this.retryStrategy;
        }

        public GetEventRuleResponseBodyEventTargetsRunOptions setDeadLetterQueue(GetEventRuleResponseBodyEventTargetsRunOptionsDeadLetterQueue deadLetterQueue) {
            this.deadLetterQueue = deadLetterQueue;
            return this;
        }
        public GetEventRuleResponseBodyEventTargetsRunOptionsDeadLetterQueue getDeadLetterQueue() {
            return this.deadLetterQueue;
        }

    }

    public static class GetEventRuleResponseBodyEventTargets extends TeaModel {
        @NameInMap("eventTargetName")
        public String eventTargetName;

        @NameInMap("className")
        public String className;

        @NameInMap("config")
        public java.util.Map<String, ?> config;

        @NameInMap("runOptions")
        public GetEventRuleResponseBodyEventTargetsRunOptions runOptions;

        public static GetEventRuleResponseBodyEventTargets build(java.util.Map<String, ?> map) throws Exception {
            GetEventRuleResponseBodyEventTargets self = new GetEventRuleResponseBodyEventTargets();
            return TeaModel.build(map, self);
        }

        public GetEventRuleResponseBodyEventTargets setEventTargetName(String eventTargetName) {
            this.eventTargetName = eventTargetName;
            return this;
        }
        public String getEventTargetName() {
            return this.eventTargetName;
        }

        public GetEventRuleResponseBodyEventTargets setClassName(String className) {
            this.className = className;
            return this;
        }
        public String getClassName() {
            return this.className;
        }

        public GetEventRuleResponseBodyEventTargets setConfig(java.util.Map<String, ?> config) {
            this.config = config;
            return this;
        }
        public java.util.Map<String, ?> getConfig() {
            return this.config;
        }

        public GetEventRuleResponseBodyEventTargets setRunOptions(GetEventRuleResponseBodyEventTargetsRunOptions runOptions) {
            this.runOptions = runOptions;
            return this;
        }
        public GetEventRuleResponseBodyEventTargetsRunOptions getRunOptions() {
            return this.runOptions;
        }

    }

}
