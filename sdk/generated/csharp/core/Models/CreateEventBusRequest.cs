// This file is auto-generated, don't edit it. Thanks.

using System;
using System.Collections.Generic;
using System.IO;

using Tea;

namespace RocketMQ.Eventbridge.SDK.Models
{
    /// <term><b>Description:</b></term>
    /// <description>
    /// <para>EventBus Controller apis:
    /// createEventBus *
    /// getEventBus    *
    /// deleteEventBus *
    /// listEventBuses *</para>
    /// </description>
    public class CreateEventBusRequest : TeaModel {
        /// <summary>
        /// <para>The description of the event bus.</para>
        /// 
        /// <b>Example:</b>
        /// <para>demo</para>
        /// </summary>
        [NameInMap("description")]
        [Validation(Required=false)]
        public string Description { get; set; }

        /// <summary>
        /// <para>The name of the event bus. This parameter is required.</para>
        /// 
        /// <b>Example:</b>
        /// <para>MyEventBus</para>
        /// </summary>
        [NameInMap("eventBusName")]
        [Validation(Required=false)]
        public string EventBusName { get; set; }

    }

}
