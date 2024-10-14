// This file is auto-generated, don't edit it. Thanks.

using System;
using System.Collections.Generic;
using System.IO;

using Tea;

namespace RocketMQ.Eventbridge.SDK.Models
{
    public class ListApiDestinationsResponseBody : TeaModel {
        /// <summary>
        /// <para>The returned response code. The value Success indicates that the request is successful.</para>
        /// 
        /// <b>Example:</b>
        /// <para>Success</para>
        /// </summary>
        [NameInMap("code")]
        [Validation(Required=false)]
        public string Code { get; set; }

        /// <summary>
        /// <para>The API destinations.</para>
        /// </summary>
        [NameInMap("apiDestinations")]
        [Validation(Required=false)]
        public List<ListApiDestinationsResponseBodyApiDestinations> ApiDestinations { get; set; }
        public class ListApiDestinationsResponseBodyApiDestinations : TeaModel {
            /// <summary>
            /// <para>The name of the API destination.</para>
            /// 
            /// <b>Example:</b>
            /// <para>api-destination-2</para>
            /// </summary>
            [NameInMap("apiDestinationName")]
            [Validation(Required=false)]
            public string ApiDestinationName { get; set; }

            /// <summary>
            /// <para>The connection name.</para>
            /// 
            /// <b>Example:</b>
            /// <para>connection-name</para>
            /// </summary>
            [NameInMap("connectionName")]
            [Validation(Required=false)]
            public string ConnectionName { get; set; }

            /// <summary>
            /// <para>The description of the connection.</para>
            /// 
            /// <b>Example:</b>
            /// <para>demo</para>
            /// </summary>
            [NameInMap("description")]
            [Validation(Required=false)]
            public string Description { get; set; }

            /// <summary>
            /// <para>The time when the API destination was created.</para>
            /// 
            /// <b>Example:</b>
            /// <para>1665223213000</para>
            /// </summary>
            [NameInMap("gmtCreate")]
            [Validation(Required=false)]
            public long? GmtCreate { get; set; }

            /// <summary>
            /// <para>The request parameters that are configured for the API destination.</para>
            /// </summary>
            [NameInMap("httpApiParameters")]
            [Validation(Required=false)]
            public ListApiDestinationsResponseBodyApiDestinationsHttpApiParameters HttpApiParameters { get; set; }
            public class ListApiDestinationsResponseBodyApiDestinationsHttpApiParameters : TeaModel {
                /// <summary>
                /// <para>The endpoint of the API destination.</para>
                /// 
                /// <b>Example:</b>
                /// <para><a href="http://127.0.0.1:8001/api">http://127.0.0.1:8001/api</a></para>
                /// </summary>
                [NameInMap("endpoint")]
                [Validation(Required=false)]
                public string Endpoint { get; set; }

                /// <summary>
                /// <para>The HTTP request method. Valid values:</para>
                /// <pre><c>      - POST
                /// 
                ///       - GET
                /// 
                ///       - DELETE
                /// 
                ///       - PUT
                /// 
                ///       - HEAD
                /// 
                ///       - TRACE
                /// 
                ///       - PATCH
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
                public List<ListApiDestinationsResponseBodyApiDestinationsHttpApiParametersApiParameters> ApiParameters { get; set; }
                public class ListApiDestinationsResponseBodyApiDestinationsHttpApiParametersApiParameters : TeaModel {
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

        /// <summary>
        /// <para>The maximum number of entries returned per page.</para>
        /// 
        /// <b>Example:</b>
        /// <para>10</para>
        /// </summary>
        [NameInMap("maxResults")]
        [Validation(Required=false)]
        public int? MaxResults { get; set; }

        /// <summary>
        /// <para>If excess return values exist, this parameter is returned.</para>
        /// 
        /// <b>Example:</b>
        /// <para>1</para>
        /// </summary>
        [NameInMap("nextToken")]
        [Validation(Required=false)]
        public string NextToken { get; set; }

        /// <summary>
        /// <para>The total number of entries returned.</para>
        /// 
        /// <b>Example:</b>
        /// <para>2</para>
        /// </summary>
        [NameInMap("total")]
        [Validation(Required=false)]
        public int? Total { get; set; }

        /// <summary>
        /// <para>The returned message. If the request is successful, success is returned. If the request failed, an error code is returned.</para>
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
        /// <para>96D7C0AB-DCE5-5E82-96B8-4725E1706BB1</para>
        /// </summary>
        [NameInMap("requestId")]
        [Validation(Required=false)]
        public string RequestId { get; set; }

    }

}
