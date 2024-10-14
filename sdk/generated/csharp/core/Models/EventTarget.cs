// This file is auto-generated, don't edit it. Thanks.

using System;
using System.Collections.Generic;
using System.IO;

using Tea;

namespace RocketMQ.Eventbridge.SDK.Models
{
    /// <term><b>Description:</b></term>
    /// <description>
    /// <para>EventTarget Controller apis:
    /// createEventTargets *
    /// updateEventTargets *
    /// deleteEventTargets *
    /// listEventTargets   *</para>
    /// </description>
    public class EventTarget : TeaModel {
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
        public EventTargetRunOptions RunOptions { get; set; }
        public class EventTargetRunOptions : TeaModel {
            [NameInMap("errorsTolerance")]
            [Validation(Required=false)]
            public string ErrorsTolerance { get; set; }

            [NameInMap("retryStrategy")]
            [Validation(Required=false)]
            public EventTargetRunOptionsRetryStrategy RetryStrategy { get; set; }
            public class EventTargetRunOptionsRetryStrategy : TeaModel {
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
            public EventTargetRunOptionsDeadLetterQueue DeadLetterQueue { get; set; }
            public class EventTargetRunOptionsDeadLetterQueue : TeaModel {
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
