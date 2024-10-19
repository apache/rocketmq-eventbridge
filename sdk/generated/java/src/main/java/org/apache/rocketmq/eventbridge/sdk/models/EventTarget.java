// This file is auto-generated, don't edit it. Thanks.
package org.apache.rocketmq.eventbridge.sdk.models;

import com.aliyun.tea.*;

/**
 * <b>description</b> :
 * <p>EventTarget Controller apis:
 * createEventTargets *
 * updateEventTargets *
 * deleteEventTargets *
 * listEventTargets   *</p>
 */
public class EventTarget extends TeaModel {
    @NameInMap("eventTargetName")
    public String eventTargetName;

    @NameInMap("className")
    public String className;

    @NameInMap("config")
    public java.util.Map<String, ?> config;

    @NameInMap("runOptions")
    public EventTargetRunOptions runOptions;

    public static EventTarget build(java.util.Map<String, ?> map) throws Exception {
        EventTarget self = new EventTarget();
        return TeaModel.build(map, self);
    }

    public EventTarget setEventTargetName(String eventTargetName) {
        this.eventTargetName = eventTargetName;
        return this;
    }
    public String getEventTargetName() {
        return this.eventTargetName;
    }

    public EventTarget setClassName(String className) {
        this.className = className;
        return this;
    }
    public String getClassName() {
        return this.className;
    }

    public EventTarget setConfig(java.util.Map<String, ?> config) {
        this.config = config;
        return this;
    }
    public java.util.Map<String, ?> getConfig() {
        return this.config;
    }

    public EventTarget setRunOptions(EventTargetRunOptions runOptions) {
        this.runOptions = runOptions;
        return this;
    }
    public EventTargetRunOptions getRunOptions() {
        return this.runOptions;
    }

    public static class EventTargetRunOptionsRetryStrategy extends TeaModel {
        @NameInMap("pushRetryStrategy")
        public String pushRetryStrategy;

        @NameInMap("maximumEventAgeInSeconds")
        public Integer maximumEventAgeInSeconds;

        @NameInMap("maximumRetryAttempts")
        public Integer maximumRetryAttempts;

        public static EventTargetRunOptionsRetryStrategy build(java.util.Map<String, ?> map) throws Exception {
            EventTargetRunOptionsRetryStrategy self = new EventTargetRunOptionsRetryStrategy();
            return TeaModel.build(map, self);
        }

        public EventTargetRunOptionsRetryStrategy setPushRetryStrategy(String pushRetryStrategy) {
            this.pushRetryStrategy = pushRetryStrategy;
            return this;
        }
        public String getPushRetryStrategy() {
            return this.pushRetryStrategy;
        }

        public EventTargetRunOptionsRetryStrategy setMaximumEventAgeInSeconds(Integer maximumEventAgeInSeconds) {
            this.maximumEventAgeInSeconds = maximumEventAgeInSeconds;
            return this;
        }
        public Integer getMaximumEventAgeInSeconds() {
            return this.maximumEventAgeInSeconds;
        }

        public EventTargetRunOptionsRetryStrategy setMaximumRetryAttempts(Integer maximumRetryAttempts) {
            this.maximumRetryAttempts = maximumRetryAttempts;
            return this;
        }
        public Integer getMaximumRetryAttempts() {
            return this.maximumRetryAttempts;
        }

    }

    public static class EventTargetRunOptionsDeadLetterQueue extends TeaModel {
        @NameInMap("type")
        public String type;

        @NameInMap("config")
        public java.util.Map<String, ?> config;

        public static EventTargetRunOptionsDeadLetterQueue build(java.util.Map<String, ?> map) throws Exception {
            EventTargetRunOptionsDeadLetterQueue self = new EventTargetRunOptionsDeadLetterQueue();
            return TeaModel.build(map, self);
        }

        public EventTargetRunOptionsDeadLetterQueue setType(String type) {
            this.type = type;
            return this;
        }
        public String getType() {
            return this.type;
        }

        public EventTargetRunOptionsDeadLetterQueue setConfig(java.util.Map<String, ?> config) {
            this.config = config;
            return this;
        }
        public java.util.Map<String, ?> getConfig() {
            return this.config;
        }

    }

    public static class EventTargetRunOptions extends TeaModel {
        @NameInMap("errorsTolerance")
        public String errorsTolerance;

        @NameInMap("retryStrategy")
        public EventTargetRunOptionsRetryStrategy retryStrategy;

        @NameInMap("deadLetterQueue")
        public EventTargetRunOptionsDeadLetterQueue deadLetterQueue;

        public static EventTargetRunOptions build(java.util.Map<String, ?> map) throws Exception {
            EventTargetRunOptions self = new EventTargetRunOptions();
            return TeaModel.build(map, self);
        }

        public EventTargetRunOptions setErrorsTolerance(String errorsTolerance) {
            this.errorsTolerance = errorsTolerance;
            return this;
        }
        public String getErrorsTolerance() {
            return this.errorsTolerance;
        }

        public EventTargetRunOptions setRetryStrategy(EventTargetRunOptionsRetryStrategy retryStrategy) {
            this.retryStrategy = retryStrategy;
            return this;
        }
        public EventTargetRunOptionsRetryStrategy getRetryStrategy() {
            return this.retryStrategy;
        }

        public EventTargetRunOptions setDeadLetterQueue(EventTargetRunOptionsDeadLetterQueue deadLetterQueue) {
            this.deadLetterQueue = deadLetterQueue;
            return this;
        }
        public EventTargetRunOptionsDeadLetterQueue getDeadLetterQueue() {
            return this.deadLetterQueue;
        }

    }

}
