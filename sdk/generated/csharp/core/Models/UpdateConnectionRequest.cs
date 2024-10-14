// This file is auto-generated, don't edit it. Thanks.

using System;
using System.Collections.Generic;
using System.IO;

using Tea;

namespace RocketMQ.Eventbridge.SDK.Models
{
    public class UpdateConnectionRequest : TeaModel {
        /// <summary>
        /// <para>The parameters that are configured for authentication.</para>
        /// </summary>
        [NameInMap("authParameters")]
        [Validation(Required=false)]
        public UpdateConnectionRequestAuthParameters AuthParameters { get; set; }
        public class UpdateConnectionRequestAuthParameters : TeaModel {
            /// <summary>
            /// <para>The parameters that are configured for API key authentication.</para>
            /// </summary>
            [NameInMap("apiKeyAuthParameters")]
            [Validation(Required=false)]
            public UpdateConnectionRequestAuthParametersApiKeyAuthParameters ApiKeyAuthParameters { get; set; }
            public class UpdateConnectionRequestAuthParametersApiKeyAuthParameters : TeaModel {
                /// <summary>
                /// <para>The key of the API key.</para>
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
                /// <para>adkjnakddh****</para>
                /// </summary>
                [NameInMap("apiKeyValue")]
                [Validation(Required=false)]
                public string ApiKeyValue { get; set; }

            }

            /// <summary>
            /// <para>The authentication type. Valid values:</para>
            /// <pre><c>  BASIC_AUTH: basic authentication.
            /// 
            ///   Introduction: Basic authentication is a simple authentication scheme built into the HTTP protocol. When you use the HTTP protocol for communications, the authentication method that the HTTP server uses to authenticate user identities on the client is defined in the protocol. The request header is in the Authorization: Basic Base64-encoded string (Username:Password) format.
            /// 
            ///   1.  Username and Password are required
            /// 
            ///   API_KEY_AUTH: API key authentication.
            /// 
            ///   Introduction: The request header is in the Token: Token value format.
            /// 
            ///   *   ApiKeyName and ApiKeyValue are required.
            /// 
            ///   OAUTH_AUTH: OAuth authentication.
            /// 
            ///   Introduction: OAuth2.0 is an authentication mechanism. In normal cases, a system that does not use OAuth2.0 can access the resources of the server from the client. To ensure access security, access tokens are used to authenticate users in OAuth 2.0. The client must use an access token to access protected resources. This way, OAuth 2.0 protects resources from being accessed from malicious clients and improves system security.
            /// 
            ///   *   AuthorizationEndpoint, OAuthHttpParameters, and HttpMethod are required.
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
            public UpdateConnectionRequestAuthParametersBasicAuthParameters BasicAuthParameters { get; set; }
            public class UpdateConnectionRequestAuthParametersBasicAuthParameters : TeaModel {
                /// <summary>
                /// <para>The password for basic authentication.</para>
                /// 
                /// <b>Example:</b>
                /// <hr>
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
            public UpdateConnectionRequestAuthParametersOauthParameters OauthParameters { get; set; }
            public class UpdateConnectionRequestAuthParametersOauthParameters : TeaModel {
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
                public UpdateConnectionRequestAuthParametersOauthParametersClientParameters ClientParameters { get; set; }
                public class UpdateConnectionRequestAuthParametersOauthParametersClientParameters : TeaModel {
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
                /// <pre><c>    - GET
                /// 
                ///     - POST
                /// 
                ///     - HEAD
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
                public UpdateConnectionRequestAuthParametersOauthParametersOauthHttpParameters OauthHttpParameters { get; set; }
                public class UpdateConnectionRequestAuthParametersOauthParametersOauthHttpParameters : TeaModel {
                    /// <summary>
                    /// <para>The parameters that are configured for the request.</para>
                    /// </summary>
                    [NameInMap("bodyParameters")]
                    [Validation(Required=false)]
                    public List<UpdateConnectionRequestAuthParametersOauthParametersOauthHttpParametersBodyParameters> BodyParameters { get; set; }
                    public class UpdateConnectionRequestAuthParametersOauthParametersOauthHttpParametersBodyParameters : TeaModel {
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
                    public List<UpdateConnectionRequestAuthParametersOauthParametersOauthHttpParametersHeaderParameters> HeaderParameters { get; set; }
                    public class UpdateConnectionRequestAuthParametersOauthParametersOauthHttpParametersHeaderParameters : TeaModel {
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
                    public List<UpdateConnectionRequestAuthParametersOauthParametersOauthHttpParametersQueryStringParameters> QueryStringParameters { get; set; }
                    public class UpdateConnectionRequestAuthParametersOauthParametersOauthHttpParametersQueryStringParameters : TeaModel {
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
        /// <para>The name of the connection. The name must be 2 to 127 characters in length.</para>
        /// <pre><c>This parameter is required.
        /// </c></pre>
        /// 
        /// <b>Example:</b>
        /// <para>connection-name</para>
        /// </summary>
        [NameInMap("connectionName")]
        [Validation(Required=false)]
        public string ConnectionName { get; set; }

        /// <summary>
        /// <para>The description of the connection. The description can be up to 255 characters in length.</para>
        /// 
        /// <b>Example:</b>
        /// <para>demo</para>
        /// </summary>
        [NameInMap("description")]
        [Validation(Required=false)]
        public string Description { get; set; }

        /// <summary>
        /// <para>The parameters that are configured for the network. This parameter is required.</para>
        /// </summary>
        [NameInMap("networkParameters")]
        [Validation(Required=false)]
        public UpdateConnectionRequestNetworkParameters NetworkParameters { get; set; }
        public class UpdateConnectionRequestNetworkParameters : TeaModel {
            /// <summary>
            /// <para>The network type. Valid values:</para>
            /// <pre><c>  PublicNetwork and PrivateNetwork.
            /// 
            ///   *   Note: If you set this parameter to PrivateNetwork, you must configure VpcId, VswitcheId, and SecurityGroupId.
            /// 
            ///   This parameter is required.
            /// </c></pre>
            /// 
            /// <b>Example:</b>
            /// <para>PublicNetwork</para>
            /// </summary>
            [NameInMap("networkType")]
            [Validation(Required=false)]
            public string NetworkType { get; set; }

            /// <summary>
            /// <para>The ID of the security group.</para>
            /// 
            /// <b>Example:</b>
            /// <para>eb-167adad548759-security_grop/sg-bp1addad26peuh9qh9****</para>
            /// </summary>
            [NameInMap("securityGroupId")]
            [Validation(Required=false)]
            public string SecurityGroupId { get; set; }

            /// <summary>
            /// <para>The VPC. ID</para>
            /// 
            /// <b>Example:</b>
            /// <para>eb-test/vpc-bp1symadadwnwg****</para>
            /// </summary>
            [NameInMap("vpcId")]
            [Validation(Required=false)]
            public string VpcId { get; set; }

            /// <summary>
            /// <para>The vSwitch ID.</para>
            /// 
            /// <b>Example:</b>
            /// <para>vsw-bp1iu4x7aeradadown1og8,vsw-bp193sqmadadlaszpeq****</para>
            /// </summary>
            [NameInMap("vswitcheId")]
            [Validation(Required=false)]
            public string VswitcheId { get; set; }

        }

    }

}
