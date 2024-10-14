// This file is auto-generated, don't edit it. Thanks.

using System;
using System.Collections.Generic;
using System.IO;

using Tea;

namespace RocketMQ.Eventbridge.SDK.Models
{
    public class ListEventTargetsResponseBody : TeaModel {
        /// <summary>
        /// <para>The name of the event bus with which the event target is associated.
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

        [NameInMap("eventTargets")]
        [Validation(Required=false)]
        public List<ListEventTargetsResponseBodyEventTargets> EventTargets { get; set; }
        public class ListEventTargetsResponseBodyEventTargets : TeaModel {
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
            public ListEventTargetsResponseBodyEventTargetsRunOptions RunOptions { get; set; }
            public class ListEventTargetsResponseBodyEventTargetsRunOptions : TeaModel {
                [NameInMap("errorsTolerance")]
                [Validation(Required=false)]
                public string ErrorsTolerance { get; set; }

                [NameInMap("retryStrategy")]
                [Validation(Required=false)]
                public ListEventTargetsResponseBodyEventTargetsRunOptionsRetryStrategy RetryStrategy { get; set; }
                public class ListEventTargetsResponseBodyEventTargetsRunOptionsRetryStrategy : TeaModel {
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
                public ListEventTargetsResponseBodyEventTargetsRunOptionsDeadLetterQueue DeadLetterQueue { get; set; }
                public class ListEventTargetsResponseBodyEventTargetsRunOptionsDeadLetterQueue : TeaModel {
                    [NameInMap("type")]
                    [Validation(Required=false)]
                    public string Type { get; set; }

                    [NameInMap("config")]
                    [Validation(Required=false)]
                    public Dictionary<string, object> Config { get; set; }

                }

            }

        }

    }

}
