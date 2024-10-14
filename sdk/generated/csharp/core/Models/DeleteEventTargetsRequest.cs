// This file is auto-generated, don't edit it. Thanks.

using System;
using System.Collections.Generic;
using System.IO;

using Tea;

namespace RocketMQ.Eventbridge.SDK.Models
{
    public class DeleteEventTargetsRequest : TeaModel {
        /// <summary>
        /// <para>The name of the event bus.</para>
        /// 
        /// <b>Example:</b>
        /// <para>MyEventBus</para>
        /// </summary>
        [NameInMap("eventBusName")]
        [Validation(Required=true)]
        public string EventBusName { get; set; }

        /// <summary>
        /// <para>The name of the event rule.</para>
        /// 
        /// <b>Example:</b>
        /// <para>ramrolechange-mns</para>
        /// </summary>
        [NameInMap("eventRuleName")]
        [Validation(Required=true)]
        public string EventRuleName { get; set; }

        /// <summary>
        /// <para>The names of the event targets that you want to delete.</para>
        /// </summary>
        [NameInMap("eventTargetNames")]
        [Validation(Required=false)]
        public List<string> EventTargetNames { get; set; }

    }

}
