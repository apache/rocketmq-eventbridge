// This file is auto-generated, don't edit it. Thanks.
package org.apache.rocketmq.eventbridge.sdk.models;

import com.aliyun.tea.*;

/**
 * <b>description</b> :
 * <p>EventRule Controller apis:
 * createEventRule  *
 * getEventRule     *
 * deleteEventRule  *
 * updateEventRule  *
 * listEventRules   *
 * enableEventRule  *
 * disableEventRule *</p>
 */
public class CreateEventRuleRequest extends TeaModel {
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

    public static CreateEventRuleRequest build(java.util.Map<String, ?> map) throws Exception {
        CreateEventRuleRequest self = new CreateEventRuleRequest();
        return TeaModel.build(map, self);
    }

    public CreateEventRuleRequest setEventBusName(String eventBusName) {
        this.eventBusName = eventBusName;
        return this;
    }
    public String getEventBusName() {
        return this.eventBusName;
    }

    public CreateEventRuleRequest setEventRuleName(String eventRuleName) {
        this.eventRuleName = eventRuleName;
        return this;
    }
    public String getEventRuleName() {
        return this.eventRuleName;
    }

    public CreateEventRuleRequest setDescription(String description) {
        this.description = description;
        return this;
    }
    public String getDescription() {
        return this.description;
    }

    public CreateEventRuleRequest setFilterPattern(String filterPattern) {
        this.filterPattern = filterPattern;
        return this;
    }
    public String getFilterPattern() {
        return this.filterPattern;
    }

}
