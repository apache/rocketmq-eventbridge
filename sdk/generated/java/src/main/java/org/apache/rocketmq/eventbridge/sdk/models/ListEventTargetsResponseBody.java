// This file is auto-generated, don't edit it. Thanks.
package org.apache.rocketmq.eventbridge.sdk.models;

import com.aliyun.tea.*;

public class ListEventTargetsResponseBody extends TeaModel {
    /**
     * <p>The name of the event bus with which the event target is associated.
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

    @NameInMap("eventTargets")
    public java.util.List<ListEventTargetsResponseBodyEventTargets> eventTargets;

    public static ListEventTargetsResponseBody build(java.util.Map<String, ?> map) throws Exception {
        ListEventTargetsResponseBody self = new ListEventTargetsResponseBody();
        return TeaModel.build(map, self);
    }

    public ListEventTargetsResponseBody setEventBusName(String eventBusName) {
        this.eventBusName = eventBusName;
        return this;
    }
    public String getEventBusName() {
        return this.eventBusName;
    }

    public ListEventTargetsResponseBody setEventRuleName(String eventRuleName) {
        this.eventRuleName = eventRuleName;
        return this;
    }
    public String getEventRuleName() {
        return this.eventRuleName;
    }

    public ListEventTargetsResponseBody setEventTargets(java.util.List<ListEventTargetsResponseBodyEventTargets> eventTargets) {
        this.eventTargets = eventTargets;
        return this;
    }
    public java.util.List<ListEventTargetsResponseBodyEventTargets> getEventTargets() {
        return this.eventTargets;
    }

    public static class ListEventTargetsResponseBodyEventTargetsRunOptionsRetryStrategy extends TeaModel {
        @NameInMap("pushRetryStrategy")
        public String pushRetryStrategy;

        @NameInMap("maximumEventAgeInSeconds")
        public Integer maximumEventAgeInSeconds;

        @NameInMap("maximumRetryAttempts")
        public Integer maximumRetryAttempts;

        public static ListEventTargetsResponseBodyEventTargetsRunOptionsRetryStrategy build(java.util.Map<String, ?> map) throws Exception {
            ListEventTargetsResponseBodyEventTargetsRunOptionsRetryStrategy self = new ListEventTargetsResponseBodyEventTargetsRunOptionsRetryStrategy();
            return TeaModel.build(map, self);
        }

        public ListEventTargetsResponseBodyEventTargetsRunOptionsRetryStrategy setPushRetryStrategy(String pushRetryStrategy) {
            this.pushRetryStrategy = pushRetryStrategy;
            return this;
        }
        public String getPushRetryStrategy() {
            return this.pushRetryStrategy;
        }

        public ListEventTargetsResponseBodyEventTargetsRunOptionsRetryStrategy setMaximumEventAgeInSeconds(Integer maximumEventAgeInSeconds) {
            this.maximumEventAgeInSeconds = maximumEventAgeInSeconds;
            return this;
        }
        public Integer getMaximumEventAgeInSeconds() {
            return this.maximumEventAgeInSeconds;
        }

        public ListEventTargetsResponseBodyEventTargetsRunOptionsRetryStrategy setMaximumRetryAttempts(Integer maximumRetryAttempts) {
            this.maximumRetryAttempts = maximumRetryAttempts;
            return this;
        }
        public Integer getMaximumRetryAttempts() {
            return this.maximumRetryAttempts;
        }

    }

    public static class ListEventTargetsResponseBodyEventTargetsRunOptionsDeadLetterQueue extends TeaModel {
        @NameInMap("type")
        public String type;

        @NameInMap("config")
        public java.util.Map<String, ?> config;

        public static ListEventTargetsResponseBodyEventTargetsRunOptionsDeadLetterQueue build(java.util.Map<String, ?> map) throws Exception {
            ListEventTargetsResponseBodyEventTargetsRunOptionsDeadLetterQueue self = new ListEventTargetsResponseBodyEventTargetsRunOptionsDeadLetterQueue();
            return TeaModel.build(map, self);
        }

        public ListEventTargetsResponseBodyEventTargetsRunOptionsDeadLetterQueue setType(String type) {
            this.type = type;
            return this;
        }
        public String getType() {
            return this.type;
        }

        public ListEventTargetsResponseBodyEventTargetsRunOptionsDeadLetterQueue setConfig(java.util.Map<String, ?> config) {
            this.config = config;
            return this;
        }
        public java.util.Map<String, ?> getConfig() {
            return this.config;
        }

    }

    public static class ListEventTargetsResponseBodyEventTargetsRunOptions extends TeaModel {
        @NameInMap("errorsTolerance")
        public String errorsTolerance;

        @NameInMap("retryStrategy")
        public ListEventTargetsResponseBodyEventTargetsRunOptionsRetryStrategy retryStrategy;

        @NameInMap("deadLetterQueue")
        public ListEventTargetsResponseBodyEventTargetsRunOptionsDeadLetterQueue deadLetterQueue;

        public static ListEventTargetsResponseBodyEventTargetsRunOptions build(java.util.Map<String, ?> map) throws Exception {
            ListEventTargetsResponseBodyEventTargetsRunOptions self = new ListEventTargetsResponseBodyEventTargetsRunOptions();
            return TeaModel.build(map, self);
        }

        public ListEventTargetsResponseBodyEventTargetsRunOptions setErrorsTolerance(String errorsTolerance) {
            this.errorsTolerance = errorsTolerance;
            return this;
        }
        public String getErrorsTolerance() {
            return this.errorsTolerance;
        }

        public ListEventTargetsResponseBodyEventTargetsRunOptions setRetryStrategy(ListEventTargetsResponseBodyEventTargetsRunOptionsRetryStrategy retryStrategy) {
            this.retryStrategy = retryStrategy;
            return this;
        }
        public ListEventTargetsResponseBodyEventTargetsRunOptionsRetryStrategy getRetryStrategy() {
            return this.retryStrategy;
        }

        public ListEventTargetsResponseBodyEventTargetsRunOptions setDeadLetterQueue(ListEventTargetsResponseBodyEventTargetsRunOptionsDeadLetterQueue deadLetterQueue) {
            this.deadLetterQueue = deadLetterQueue;
            return this;
        }
        public ListEventTargetsResponseBodyEventTargetsRunOptionsDeadLetterQueue getDeadLetterQueue() {
            return this.deadLetterQueue;
        }

    }

    public static class ListEventTargetsResponseBodyEventTargets extends TeaModel {
        @NameInMap("eventTargetName")
        public String eventTargetName;

        @NameInMap("className")
        public String className;

        @NameInMap("config")
        public java.util.Map<String, ?> config;

        @NameInMap("runOptions")
        public ListEventTargetsResponseBodyEventTargetsRunOptions runOptions;

        public static ListEventTargetsResponseBodyEventTargets build(java.util.Map<String, ?> map) throws Exception {
            ListEventTargetsResponseBodyEventTargets self = new ListEventTargetsResponseBodyEventTargets();
            return TeaModel.build(map, self);
        }

        public ListEventTargetsResponseBodyEventTargets setEventTargetName(String eventTargetName) {
            this.eventTargetName = eventTargetName;
            return this;
        }
        public String getEventTargetName() {
            return this.eventTargetName;
        }

        public ListEventTargetsResponseBodyEventTargets setClassName(String className) {
            this.className = className;
            return this;
        }
        public String getClassName() {
            return this.className;
        }

        public ListEventTargetsResponseBodyEventTargets setConfig(java.util.Map<String, ?> config) {
            this.config = config;
            return this;
        }
        public java.util.Map<String, ?> getConfig() {
            return this.config;
        }

        public ListEventTargetsResponseBodyEventTargets setRunOptions(ListEventTargetsResponseBodyEventTargetsRunOptions runOptions) {
            this.runOptions = runOptions;
            return this;
        }
        public ListEventTargetsResponseBodyEventTargetsRunOptions getRunOptions() {
            return this.runOptions;
        }

    }

}
