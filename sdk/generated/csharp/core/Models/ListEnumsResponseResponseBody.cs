// This file is auto-generated, don't edit it. Thanks.

using System;
using System.Collections.Generic;
using System.IO;

using Tea;

namespace RocketMQ.Eventbridge.SDK.Models
{
    // enum AuthorizationTypeEnums : string {
    //   API_KEY_AUTH(name="API_KEY_AUTH", value="API_KEY_AUTH"),
    //   BASIC_AUTH(name="BASIC_AUTH", value="BASIC_AUTH"),
    //   OAUTH_AUTH(name="OAUTH_AUTH", value="OAUTH_AUTH"),
    // }
    // enum NetworkTypeEnum : string {
    //   PUBLIC_NETWORK(name="PUBLIC_NETWORK", value="PublicNetwork"),
    //   PRIVATE_NETWORK(name="PRIVATE_NETWORK", value="PrivateNetwork")
    // }
    public class ListEnumsResponseResponseBody : TeaModel {
        [NameInMap("authorizationTypeEnums")]
        [Validation(Required=false)]
        public string AuthorizationTypeEnums { get; set; }

        [NameInMap("networkTypeEnums")]
        [Validation(Required=false)]
        public string NetworkTypeEnums { get; set; }

        /// <summary>
        /// <para>The returned response code.</para>
        /// 
        /// <b>Example:</b>
        /// <para>Success</para>
        /// </summary>
        [NameInMap("code")]
        [Validation(Required=false)]
        public string Code { get; set; }

        /// <summary>
        /// <para>The returned message.</para>
        /// 
        /// <b>Example:</b>
        /// <para>success</para>
        /// </summary>
        [NameInMap("message")]
        [Validation(Required=false)]
        public string Message { get; set; }

        /// <summary>
        /// <para>The request ID.</para>
        /// 
        /// <b>Example:</b>
        /// <para>8346BE8F-40F3-533D-A0B8-1359C31BD5BA</para>
        /// </summary>
        [NameInMap("requestId")]
        [Validation(Required=false)]
        public string RequestId { get; set; }

    }

}
