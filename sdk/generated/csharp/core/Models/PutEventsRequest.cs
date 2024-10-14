// This file is auto-generated, don't edit it. Thanks.

using System;
using System.Collections.Generic;
using System.IO;

using Tea;

namespace RocketMQ.Eventbridge.SDK.Models
{
    /// <term><b>Description:</b></term>
    /// <description>
    /// <para>EventData Controller apis:
    /// putEvents</para>
    /// </description>
    public class PutEventsRequest : TeaModel {
        /// <summary>
        /// <para>The name of the event bus.
        /// This parameter is required.</para>
        /// 
        /// <b>Example:</b>
        /// <para>demo</para>
        /// </summary>
        [NameInMap("eventBusName")]
        [Validation(Required=false)]
        public string EventBusName { get; set; }

        /// <summary>
        /// <para>The content of the event.</para>
        /// 
        /// <b>Example:</b>
        /// <para>The description of the event.</para>
        /// </summary>
        [NameInMap("event")]
        [Validation(Required=false)]
        public string Event { get; set; }

    }

}
