// This file is auto-generated, don't edit it. Thanks.

using System;
using System.Collections.Generic;
using System.IO;

using Tea;

namespace RocketMQ.Eventbridge.SDK.Models
{
    public class GetEventRuleResponseBody : TeaModel {
        /// <summary>
        /// <para>The returned response code. Valid values:</para>
        /// <pre><c>*   Success: The request is successful.
        /// 
        /// *   Other codes: The request failed. For more information about error codes, see Error codes.
        /// </c></pre>
        /// 
        /// <b>Example:</b>
        /// <para>Success</para>
        /// </summary>
        [NameInMap("code")]
        [Validation(Required=false)]
        public string Code { get; set; }

        /// <summary>
        /// <para>The name of the event bus with which the event source is associated.
        /// This parameter is required.</para>
        /// 
        /// <b>Example:</b>
        /// <para>my-event-bus</para>
        /// </summary>
        [NameInMap("eventBusName")]
        [Validation(Required=false)]
        public string EventBusName { get; set; }

        /// <summary>
        /// <para>The name of the event rule.
        /// This parameter is required.</para>
        /// 
        /// <b>Example:</b>
        /// <para>myrabbitmq.sourc</para>
        /// </summary>
        [NameInMap("eventRuleName")]
        [Validation(Required=false)]
        public string EventRuleName { get; set; }

        [NameInMap("description")]
        [Validation(Required=false)]
        public string Description { get; set; }

        /// <summary>
        /// <para>The event pattern, in JSON format. Valid values: stringEqual and stringExpression. You can specify up to five expressions in the map data structure in each field.</para>
        /// <pre><c>You can specify up to five expressions in the map data structure in each field.
        /// </c></pre>
        /// 
        /// <b>Example:</b>
        /// <para>{&quot;source&quot;: [{&quot;prefix&quot;: &quot;acs.&quot;}],&quot;type&quot;: [{&quot;prefix&quot;:&quot;oss:ObjectReplication&quot;}],&quot;subject&quot;:[{&quot;prefix&quot;:&quot;acs:oss:cn-hangzhou:123456789098****:my-movie-bucket/&quot;, &quot;suffix&quot;:&quot;.txt&quot;}]}</para>
        /// </summary>
        [NameInMap("filterPattern")]
        [Validation(Required=false)]
        public string FilterPattern { get; set; }

        /// <summary>
        /// <para>The status of the event rule. Valid values: ENABLE (default): The event rule is enabled. DISABLE: The event rule is disabled.</para>
        /// 
        /// <b>Example:</b>
        /// <para>ENABLE</para>
        /// </summary>
        [NameInMap("status")]
        [Validation(Required=false)]
        public string Status { get; set; }

        [NameInMap("gmtCreate")]
        [Validation(Required=false)]
        public string GmtCreate { get; set; }

        [NameInMap("gmtModify")]
        [Validation(Required=false)]
        public string GmtModify { get; set; }

        [NameInMap("eventTargets")]
        [Validation(Required=false)]
        public List<GetEventRuleResponseBodyEventTargets> EventTargets { get; set; }
        public class GetEventRuleResponseBodyEventTargets : TeaModel {
            [NameInMap("eventTargetName")]
            [Validation(Required=false)]
            public string EventTargetName { get; set; }

            [NameInMap("className")]
            [Validation(Required=false)]
            public string ClassName { get; set; }

            [NameInMap("config")]
            [Validation(Required=false)]
            public Dictionary<string, object> Config { get; set; }

            [NameInMap("runOptions")]
            [Validation(Required=false)]
            public GetEventRuleResponseBodyEventTargetsRunOptions RunOptions { get; set; }
            public class GetEventRuleResponseBodyEventTargetsRunOptions : TeaModel {
                [NameInMap("errorsTolerance")]
                [Validation(Required=false)]
                public string ErrorsTolerance { get; set; }

                [NameInMap("retryStrategy")]
                [Validation(Required=false)]
                public GetEventRuleResponseBodyEventTargetsRunOptionsRetryStrategy RetryStrategy { get; set; }
                public class GetEventRuleResponseBodyEventTargetsRunOptionsRetryStrategy : TeaModel {
                    [NameInMap("pushRetryStrategy")]
                    [Validation(Required=false)]
                    public string PushRetryStrategy { get; set; }

                    [NameInMap("maximumEventAgeInSeconds")]
                    [Validation(Required=false)]
                    public int? MaximumEventAgeInSeconds { get; set; }

                    [NameInMap("maximumRetryAttempts")]
                    [Validation(Required=false)]
                    public int? MaximumRetryAttempts { get; set; }

                }

                [NameInMap("deadLetterQueue")]
                [Validation(Required=false)]
                public GetEventRuleResponseBodyEventTargetsRunOptionsDeadLetterQueue DeadLetterQueue { get; set; }
                public class GetEventRuleResponseBodyEventTargetsRunOptionsDeadLetterQueue : TeaModel {
                    [NameInMap("type")]
                    [Validation(Required=false)]
                    public string Type { get; set; }

                    [NameInMap("config")]
                    [Validation(Required=false)]
                    public Dictionary<string, object> Config { get; set; }

                }

            }

        }

        /// <summary>
        /// <para>The returned error message.</para>
        /// 
        /// <b>Example:</b>
        /// <para>Remote error. requestId: [A8EFABD2-95B9-1C46-9E01-xxxx], error code: [CreateRelatedResourceFailed], message: [Create related resource failed, EntityNotExist.Role : The role not exists: xxxx. \r\nRequestId : xxxx-168C-54ED-8FEB-BF11CB70AEB7]</para>
        /// </summary>
        [NameInMap("message")]
        [Validation(Required=false)]
        public string Message { get; set; }

        /// <summary>
        /// <para>The request ID.</para>
        /// 
        /// <b>Example:</b>
        /// <para>2922208e-e1c6-43ee-bfd1-aca50263bc8a</para>
        /// </summary>
        [NameInMap("requestId")]
        [Validation(Required=false)]
        public string RequestId { get; set; }

    }

}
