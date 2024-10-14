// This file is auto-generated, don't edit it. Thanks.

using System;
using System.Collections.Generic;
using System.IO;

using Tea;

namespace RocketMQ.Eventbridge.SDK.Models
{
    public class GetConnectionResponseBody : TeaModel {
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
        /// <para>The value of the key in the request path.</para>
        /// </summary>
        [NameInMap("connections")]
        [Validation(Required=false)]
        public List<GetConnectionResponseBodyConnections> Connections { get; set; }
        public class GetConnectionResponseBodyConnections : TeaModel {
            /// <summary>
            /// <para>The parameters that are configured for authentication.</para>
            /// </summary>
            [NameInMap("authParameters")]
            [Validation(Required=false)]
            public GetConnectionResponseBodyConnectionsAuthParameters AuthParameters { get; set; }
            public class GetConnectionResponseBodyConnectionsAuthParameters : TeaModel {
                /// <summary>
                /// <para>The parameters that are configured for API key authentication.</para>
                /// </summary>
                [NameInMap("apiKeyAuthParameters")]
                [Validation(Required=false)]
                public GetConnectionResponseBodyConnectionsAuthParametersApiKeyAuthParameters ApiKeyAuthParameters { get; set; }
                public class GetConnectionResponseBodyConnectionsAuthParametersApiKeyAuthParameters : TeaModel {
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
                public GetConnectionResponseBodyConnectionsAuthParametersBasicAuthParameters BasicAuthParameters { get; set; }
                public class GetConnectionResponseBodyConnectionsAuthParametersBasicAuthParameters : TeaModel {
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
                public GetConnectionResponseBodyConnectionsAuthParametersOauthParameters OauthParameters { get; set; }
                public class GetConnectionResponseBodyConnectionsAuthParametersOauthParameters : TeaModel {
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
                    public GetConnectionResponseBodyConnectionsAuthParametersOauthParametersClientParameters ClientParameters { get; set; }
                    public class GetConnectionResponseBodyConnectionsAuthParametersOauthParametersClientParameters : TeaModel {
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
                    public GetConnectionResponseBodyConnectionsAuthParametersOauthParametersOauthHttpParameters OauthHttpParameters { get; set; }
                    public class GetConnectionResponseBodyConnectionsAuthParametersOauthParametersOauthHttpParameters : TeaModel {
                        /// <summary>
                        /// <para>The parameters that are configured for the request.</para>
                        /// </summary>
                        [NameInMap("bodyParameters")]
                        [Validation(Required=false)]
                        public List<GetConnectionResponseBodyConnectionsAuthParametersOauthParametersOauthHttpParametersBodyParameters> BodyParameters { get; set; }
                        public class GetConnectionResponseBodyConnectionsAuthParametersOauthParametersOauthHttpParametersBodyParameters : TeaModel {
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
                        public List<GetConnectionResponseBodyConnectionsAuthParametersOauthParametersOauthHttpParametersHeaderParameters> HeaderParameters { get; set; }
                        public class GetConnectionResponseBodyConnectionsAuthParametersOauthParametersOauthHttpParametersHeaderParameters : TeaModel {
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
                        public List<GetConnectionResponseBodyConnectionsAuthParametersOauthParametersOauthHttpParametersQueryStringParameters> QueryStringParameters { get; set; }
                        public class GetConnectionResponseBodyConnectionsAuthParametersOauthParametersOauthHttpParametersQueryStringParameters : TeaModel {
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
            public GetConnectionResponseBodyConnectionsNetworkParameters NetworkParameters { get; set; }
            public class GetConnectionResponseBodyConnectionsNetworkParameters : TeaModel {
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
        /// <para>The returned message.</para>
        /// 
        /// <b>Example:</b>
        /// <para>success</para>
        /// </summary>
        [NameInMap("message")]
        [Validation(Required=false)]
        public string Message { get; set; }

        /// <summary>
        /// <para>The returned request ID.</para>
        /// 
        /// <b>Example:</b>
        /// <para>34AD682D-5B91-5773-8132-AA38C130****</para>
        /// </summary>
        [NameInMap("requestId")]
        [Validation(Required=false)]
        public string RequestId { get; set; }

    }

}
