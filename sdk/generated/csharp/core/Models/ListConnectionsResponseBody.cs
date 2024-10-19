// This file is auto-generated, don't edit it. Thanks.

using System;
using System.Collections.Generic;
using System.IO;

using Tea;

namespace RocketMQ.Eventbridge.SDK.Models
{
    public class ListConnectionsResponseBody : TeaModel {
        /// <summary>
        /// <para>The HTTP status code. The value Success indicates that the request is successful.</para>
        /// 
        /// <b>Example:</b>
        /// <para>Success</para>
        /// </summary>
        [NameInMap("code")]
        [Validation(Required=false)]
        public string Code { get; set; }

        /// <summary>
        /// <para>The value of the key in the request path.</para>
        /// </summary>
        [NameInMap("connections")]
        [Validation(Required=false)]
        public List<ListConnectionsResponseBodyConnections> Connections { get; set; }
        public class ListConnectionsResponseBodyConnections : TeaModel {
            /// <summary>
            /// <para>The parameters that are configured for authentication.</para>
            /// </summary>
            [NameInMap("authParameters")]
            [Validation(Required=false)]
            public ListConnectionsResponseBodyConnectionsAuthParameters AuthParameters { get; set; }
            public class ListConnectionsResponseBodyConnectionsAuthParameters : TeaModel {
                /// <summary>
                /// <para>The parameters that are configured for API key authentication.</para>
                /// </summary>
                [NameInMap("apiKeyAuthParameters")]
                [Validation(Required=false)]
                public ListConnectionsResponseBodyConnectionsAuthParametersApiKeyAuthParameters ApiKeyAuthParameters { get; set; }
                public class ListConnectionsResponseBodyConnectionsAuthParametersApiKeyAuthParameters : TeaModel {
                    /// <summary>
                    /// <para>The API key.</para>
                    /// 
                    /// <b>Example:</b>
                    /// <para>Token</para>
                    /// </summary>
                    [NameInMap("apiKeyName")]
                    [Validation(Required=false)]
                    public string ApiKeyName { get; set; }

                    /// <summary>
                    /// <para>The value of the API key.</para>
                    /// 
                    /// <b>Example:</b>
                    /// <para>asdkjnqkwejooa</para>
                    /// </summary>
                    [NameInMap("apiKeyValue")]
                    [Validation(Required=false)]
                    public string ApiKeyValue { get; set; }

                }

                /// <summary>
                /// <para>The authentication type. Valid values:</para>
                /// <pre><c>      - BASIC_AUTH: basic authentication.
                /// 
                /// 
                ///       - API_KEY_AUTH: API key authentication.
                /// 
                /// 
                ///       - OAUTH_AUTH: OAuth authentication.
                /// </c></pre>
                /// 
                /// <b>Example:</b>
                /// <para>BASIC_AUTH</para>
                /// </summary>
                [NameInMap("authorizationType")]
                [Validation(Required=false)]
                public string AuthorizationType { get; set; }

                /// <summary>
                /// <para>The parameters that are configured for basic authentication.</para>
                /// </summary>
                [NameInMap("basicAuthParameters")]
                [Validation(Required=false)]
                public ListConnectionsResponseBodyConnectionsAuthParametersBasicAuthParameters BasicAuthParameters { get; set; }
                public class ListConnectionsResponseBodyConnectionsAuthParametersBasicAuthParameters : TeaModel {
                    /// <summary>
                    /// <para>The password for basic authentication.</para>
                    /// 
                    /// <b>Example:</b>
                    /// <para>admin</para>
                    /// </summary>
                    [NameInMap("password")]
                    [Validation(Required=false)]
                    public string Password { get; set; }

                    /// <summary>
                    /// <para>The username for basic authentication.</para>
                    /// 
                    /// <b>Example:</b>
                    /// <para>admin</para>
                    /// </summary>
                    [NameInMap("username")]
                    [Validation(Required=false)]
                    public string Username { get; set; }

                }

                /// <summary>
                /// <para>The parameters that are configured for OAuth authentication.</para>
                /// </summary>
                [NameInMap("oauthParameters")]
                [Validation(Required=false)]
                public ListConnectionsResponseBodyConnectionsAuthParametersOauthParameters OauthParameters { get; set; }
                public class ListConnectionsResponseBodyConnectionsAuthParametersOauthParameters : TeaModel {
                    /// <summary>
                    /// <para>The endpoint that is used to obtain the OAuth token.</para>
                    /// 
                    /// <b>Example:</b>
                    /// <para><a href="http://localhost:8080/oauth/token">http://localhost:8080/oauth/token</a></para>
                    /// </summary>
                    [NameInMap("authorizationEndpoint")]
                    [Validation(Required=false)]
                    public string AuthorizationEndpoint { get; set; }

                    /// <summary>
                    /// <para>The parameters that are configured for the client.</para>
                    /// </summary>
                    [NameInMap("clientParameters")]
                    [Validation(Required=false)]
                    public ListConnectionsResponseBodyConnectionsAuthParametersOauthParametersClientParameters ClientParameters { get; set; }
                    public class ListConnectionsResponseBodyConnectionsAuthParametersOauthParametersClientParameters : TeaModel {
                        /// <summary>
                        /// <para>The client ID.</para>
                        /// 
                        /// <b>Example:</b>
                        /// <para>ClientID</para>
                        /// </summary>
                        [NameInMap("clientID")]
                        [Validation(Required=false)]
                        public string ClientID { get; set; }

                        /// <summary>
                        /// <para>The client key secret of the application.</para>
                        /// 
                        /// <b>Example:</b>
                        /// <para>ClientSecret</para>
                        /// </summary>
                        [NameInMap("clientSecret")]
                        [Validation(Required=false)]
                        public string ClientSecret { get; set; }

                    }

                    /// <summary>
                    /// <para>The HTTP request method. Valid values:</para>
                    /// <pre><c>        - GET
                    /// 
                    ///         - POST
                    /// 
                    ///         - HEAD
                    /// </c></pre>
                    /// 
                    /// <b>Example:</b>
                    /// <para>POST</para>
                    /// </summary>
                    [NameInMap("httpMethod")]
                    [Validation(Required=false)]
                    public string HttpMethod { get; set; }

                    /// <summary>
                    /// <para>The request parameters for OAuth authentication.</para>
                    /// </summary>
                    [NameInMap("oauthHttpParameters")]
                    [Validation(Required=false)]
                    public ListConnectionsResponseBodyConnectionsAuthParametersOauthParametersOauthHttpParameters OauthHttpParameters { get; set; }
                    public class ListConnectionsResponseBodyConnectionsAuthParametersOauthParametersOauthHttpParameters : TeaModel {
                        /// <summary>
                        /// <para>The parameters that are configured for the request.</para>
                        /// </summary>
                        [NameInMap("bodyParameters")]
                        [Validation(Required=false)]
                        public List<ListConnectionsResponseBodyConnectionsAuthParametersOauthParametersOauthHttpParametersBodyParameters> BodyParameters { get; set; }
                        public class ListConnectionsResponseBodyConnectionsAuthParametersOauthParametersOauthHttpParametersBodyParameters : TeaModel {
                            /// <summary>
                            /// <para>Indicates whether authentication is enabled.</para>
                            /// 
                            /// <b>Example:</b>
                            /// <para>false</para>
                            /// </summary>
                            [NameInMap("isValueSecret")]
                            [Validation(Required=false)]
                            public string IsValueSecret { get; set; }

                            /// <summary>
                            /// <para>The key in the request body.</para>
                            /// 
                            /// <b>Example:</b>
                            /// <para>name</para>
                            /// </summary>
                            [NameInMap("key")]
                            [Validation(Required=false)]
                            public string Key { get; set; }

                            /// <summary>
                            /// <para>The value of the key in the request body.</para>
                            /// 
                            /// <b>Example:</b>
                            /// <para>demo</para>
                            /// </summary>
                            [NameInMap("value")]
                            [Validation(Required=false)]
                            public string Value { get; set; }

                        }

                        /// <summary>
                        /// <para>The parameters that are configured for the request header.</para>
                        /// </summary>
                        [NameInMap("headerParameters")]
                        [Validation(Required=false)]
                        public List<ListConnectionsResponseBodyConnectionsAuthParametersOauthParametersOauthHttpParametersHeaderParameters> HeaderParameters { get; set; }
                        public class ListConnectionsResponseBodyConnectionsAuthParametersOauthParametersOauthHttpParametersHeaderParameters : TeaModel {
                            /// <summary>
                            /// <para>Indicates whether authentication is enabled.</para>
                            /// 
                            /// <b>Example:</b>
                            /// <para>false</para>
                            /// </summary>
                            [NameInMap("isValueSecret")]
                            [Validation(Required=false)]
                            public string IsValueSecret { get; set; }

                            /// <summary>
                            /// <para>The key in the request header.</para>
                            /// 
                            /// <b>Example:</b>
                            /// <para>name</para>
                            /// </summary>
                            [NameInMap("key")]
                            [Validation(Required=false)]
                            public string Key { get; set; }

                            /// <summary>
                            /// <para>The value of the key in the request header.</para>
                            /// 
                            /// <b>Example:</b>
                            /// <para>demo</para>
                            /// </summary>
                            [NameInMap("value")]
                            [Validation(Required=false)]
                            public string Value { get; set; }

                        }

                        /// <summary>
                        /// <para>The parameters that are configured for the request path.</para>
                        /// </summary>
                        [NameInMap("queryStringParameters")]
                        [Validation(Required=false)]
                        public List<ListConnectionsResponseBodyConnectionsAuthParametersOauthParametersOauthHttpParametersQueryStringParameters> QueryStringParameters { get; set; }
                        public class ListConnectionsResponseBodyConnectionsAuthParametersOauthParametersOauthHttpParametersQueryStringParameters : TeaModel {
                            /// <summary>
                            /// <para>Indicates whether authentication is enabled.</para>
                            /// 
                            /// <b>Example:</b>
                            /// <para>false</para>
                            /// </summary>
                            [NameInMap("isValueSecret")]
                            [Validation(Required=false)]
                            public string IsValueSecret { get; set; }

                            /// <summary>
                            /// <para>The key in the request path.</para>
                            /// 
                            /// <b>Example:</b>
                            /// <para>name</para>
                            /// </summary>
                            [NameInMap("key")]
                            [Validation(Required=false)]
                            public string Key { get; set; }

                            /// <summary>
                            /// <para>The value of the key in the request path.</para>
                            /// 
                            /// <b>Example:</b>
                            /// <para>demo</para>
                            /// </summary>
                            [NameInMap("value")]
                            [Validation(Required=false)]
                            public string Value { get; set; }

                        }

                    }

                }

            }

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
            /// <para>The connection description.</para>
            /// 
            /// <b>Example:</b>
            /// <para>The description of the connection.</para>
            /// </summary>
            [NameInMap("description")]
            [Validation(Required=false)]
            public string Description { get; set; }

            /// <summary>
            /// <para>The time when the connection was created.</para>
            /// 
            /// <b>Example:</b>
            /// <para>1592838994234</para>
            /// </summary>
            [NameInMap("gmtCreate")]
            [Validation(Required=false)]
            public long? GmtCreate { get; set; }

            /// <summary>
            /// <para>The connection ID.</para>
            /// 
            /// <b>Example:</b>
            /// <para>1141093</para>
            /// </summary>
            [NameInMap("id")]
            [Validation(Required=false)]
            public int? Id { get; set; }

            [NameInMap("networkParameters")]
            [Validation(Required=false)]
            public ListConnectionsResponseBodyConnectionsNetworkParameters NetworkParameters { get; set; }
            public class ListConnectionsResponseBodyConnectionsNetworkParameters : TeaModel {
                /// <summary>
                /// <para>The network type. Valid values:PublicNetwork and PrivateNetwork.</para>
                /// 
                /// <b>Example:</b>
                /// <para>PublicNetwork</para>
                /// </summary>
                [NameInMap("networkType")]
                [Validation(Required=false)]
                public string NetworkType { get; set; }

                /// <summary>
                /// <para>The security group ID.</para>
                /// 
                /// <b>Example:</b>
                /// <para>eb-167adad548759-security_grop/sg-bp1addad26peuh9qh9rtyb</para>
                /// </summary>
                [NameInMap("securityGroupId")]
                [Validation(Required=false)]
                public string SecurityGroupId { get; set; }

                /// <summary>
                /// <para>The virtual private cloud (VPC) ID.</para>
                /// 
                /// <b>Example:</b>
                /// <para>eb-test/vpc-bp1symadadwnwgmqud</para>
                /// </summary>
                [NameInMap("vpcId")]
                [Validation(Required=false)]
                public string VpcId { get; set; }

                /// <summary>
                /// <para>The vSwitch ID.</para>
                /// 
                /// <b>Example:</b>
                /// <para>vsw-bp1iu4x7aeradadown1og8,vsw-bp193sqmadadlaszpeqbt2c</para>
                /// </summary>
                [NameInMap("vswitcheId")]
                [Validation(Required=false)]
                public string VswitcheId { get; set; }

            }

        }

        /// <summary>
        /// <para>The number of entries returned per page.</para>
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
        /// <para>0</para>
        /// </summary>
        [NameInMap("nextToken")]
        [Validation(Required=false)]
        public string NextToken { get; set; }

        /// <summary>
        /// <para>The total number of entries returned.</para>
        /// 
        /// <b>Example:</b>
        /// <para>1</para>
        /// </summary>
        [NameInMap("total")]
        [Validation(Required=false)]
        public int? Total { get; set; }

        /// <summary>
        /// <para>The message returned.</para>
        /// 
        /// <b>Example:</b>
        /// <para>success</para>
        /// </summary>
        [NameInMap("message")]
        [Validation(Required=false)]
        public string Message { get; set; }

        /// <summary>
        /// <para>The ID of the request. This parameter is a common parameter. Each request has a unique ID. You can use the ID to troubleshoot issues.</para>
        /// 
        /// <b>Example:</b>
        /// <para>E3619976-8714-5D88-BBA2-6983D798A8BB</para>
        /// </summary>
        [NameInMap("requestId")]
        [Validation(Required=false)]
        public string RequestId { get; set; }

    }

}
