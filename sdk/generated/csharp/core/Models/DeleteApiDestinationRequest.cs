// This file is auto-generated, don't edit it. Thanks.

using System;
using System.Collections.Generic;
using System.IO;

using Tea;

namespace RocketMQ.Eventbridge.SDK.Models
{
    public class DeleteApiDestinationRequest : TeaModel {
        /// <summary>
        /// <para>The name of the API destination. This parameter is required.</para>
        /// 
        /// <b>Example:</b>
        /// <para>ApiDestinationName</para>
        /// </summary>
        [NameInMap("apiDestinationName")]
        [Validation(Required=false)]
        public string ApiDestinationName { get; set; }

    }

}
