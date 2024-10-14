// This file is auto-generated, don't edit it. Thanks.

using System;
using System.Collections.Generic;
using System.IO;

using Tea;

namespace RocketMQ.Eventbridge.SDK.Models
{
    public class UpdateApiDestinationRequest : TeaModel {
        /// <summary>
        /// <para>The name of the API destination. The name must be 2 to 127 characters in length. This parameter is required.</para>
        /// 
        /// <b>Example:</b>
        /// <para>api-destination-name</para>
        /// </summary>
        [NameInMap("apiDestinationName")]
        [Validation(Required=false)]
        public string ApiDestinationName { get; set; }

        /// <summary>
        /// <para>The name of the connection. The name must be 2 to 127 characters in length. Before you configure this parameter, you must call the CreateConnection operation to create a connection. Then, set this parameter to the name of the connection that you created. This parameter is required.</para>
        /// 
        /// <b>Example:</b>
        /// <para>connection-name</para>
        /// </summary>
        [NameInMap("connectionName")]
        [Validation(Required=false)]
        public string ConnectionName { get; set; }

        /// <summary>
        /// <para>The description of the API destination. The description can be up to 255 characters in length.</para>
        /// </summary>
        [NameInMap("description")]
        [Validation(Required=false)]
        public string Description { get; set; }

        /// <summary>
        /// <para>The parameters that are configured for the API destination. This parameter is required.</para>
        /// </summary>
        [NameInMap("httpApiParameters")]
        [Validation(Required=false)]
        public UpdateApiDestinationRequestHttpApiParameters HttpApiParameters { get; set; }
        public class UpdateApiDestinationRequestHttpApiParameters : TeaModel {
            /// <summary>
            /// <para>The endpoint of the API destination. The endpoint can be up to 127 characters in length. This parameter is required.</para>
            /// 
            /// <b>Example:</b>
            /// <para><a href="http://127.0.0.1:8001/api">http://127.0.0.1:8001/api</a></para>
            /// </summary>
            [NameInMap("endpoint")]
            [Validation(Required=false)]
            public string Endpoint { get; set; }

            /// <summary>
            /// <para>The HTTP request method. Valid values: </para>
            /// <pre><c>  *   GET 
            /// 
            ///   *   POST 
            /// 
            ///   *   HEAD 
            /// 
            ///   *   DELETE 
            /// 
            ///   *   PUT 
            /// 
            ///   *   PATCH 
            /// 
            /// 
            ///   This parameter is required.
            /// </c></pre>
            /// 
            /// <b>Example:</b>
            /// <para>POST</para>
            /// </summary>
            [NameInMap("method")]
            [Validation(Required=false)]
            public string Method { get; set; }

            /// <summary>
            /// <para>TODO</para>
            /// </summary>
            [NameInMap("apiParameters")]
            [Validation(Required=false)]
            public List<UpdateApiDestinationRequestHttpApiParametersApiParameters> ApiParameters { get; set; }
            public class UpdateApiDestinationRequestHttpApiParametersApiParameters : TeaModel {
                [NameInMap("name")]
                [Validation(Required=false)]
                public string Name { get; set; }

                /// <summary>
                /// <para>The description of the API destination. The description can be up to 255 characters in length.</para>
                /// </summary>
                [NameInMap("description")]
                [Validation(Required=false)]
                public string Description { get; set; }

                [NameInMap("type")]
                [Validation(Required=false)]
                public string Type { get; set; }

                [NameInMap("defaultValue")]
                [Validation(Required=false)]
                public string DefaultValue { get; set; }

                [NameInMap("in")]
                [Validation(Required=false)]
                public string In { get; set; }

            }

        }

        /// <summary>
        /// <para>TODO</para>
        /// </summary>
        [NameInMap("invocationRateLimitPerSecond")]
        [Validation(Required=false)]
        public int? InvocationRateLimitPerSecond { get; set; }

    }

}
