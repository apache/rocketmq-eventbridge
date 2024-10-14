// This file is auto-generated, don't edit it. Thanks.

using System;
using System.Collections.Generic;
using System.IO;

using Tea;

namespace RocketMQ.Eventbridge.SDK.Models
{
    public class EnableEventRuleRequest : TeaModel {
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

    }

}
