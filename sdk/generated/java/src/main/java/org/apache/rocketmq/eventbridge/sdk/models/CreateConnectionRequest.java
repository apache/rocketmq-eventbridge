// This file is auto-generated, don't edit it. Thanks.
package org.apache.rocketmq.eventbridge.sdk.models;

import com.aliyun.tea.*;

/**
 * <b>description</b> :
 * <p>Connection Controller apis:
 * createConnection    *
 * deleteConnection    *
 * updateConnection    *
 * getConnection       *
 * selectOneConnection *
 * listConnections     *
 * listEnumsResponse   *</p>
 */
public class CreateConnectionRequest extends TeaModel {
    /**
     * <p>The parameters that are configured for authentication.</p>
     */
    @NameInMap("authParameters")
    public CreateConnectionRequestAuthParameters authParameters;

    /**
     * <p>The name of the connection. The name must be 2 to 127 characters in length.</p>
     * <pre><code>This parameter is required.
     * </code></pre>
     * 
     * <strong>example:</strong>
     * <p>connection-name</p>
     */
    @NameInMap("connectionName")
    public String connectionName;

    /**
     * <p>The description of the connection. The description can be up to 255 characters in length.</p>
     * 
     * <strong>example:</strong>
     * <p>demo</p>
     */
    @NameInMap("description")
    public String description;

    /**
     * <p>The parameters that are configured for the network. This parameter is required.</p>
     */
    @NameInMap("networkParameters")
    public CreateConnectionRequestNetworkParameters networkParameters;

    public static CreateConnectionRequest build(java.util.Map<String, ?> map) throws Exception {
        CreateConnectionRequest self = new CreateConnectionRequest();
        return TeaModel.build(map, self);
    }

    public CreateConnectionRequest setAuthParameters(CreateConnectionRequestAuthParameters authParameters) {
        this.authParameters = authParameters;
        return this;
    }
    public CreateConnectionRequestAuthParameters getAuthParameters() {
        return this.authParameters;
    }

    public CreateConnectionRequest setConnectionName(String connectionName) {
        this.connectionName = connectionName;
        return this;
    }
    public String getConnectionName() {
        return this.connectionName;
    }

    public CreateConnectionRequest setDescription(String description) {
        this.description = description;
        return this;
    }
    public String getDescription() {
        return this.description;
    }

    public CreateConnectionRequest setNetworkParameters(CreateConnectionRequestNetworkParameters networkParameters) {
        this.networkParameters = networkParameters;
        return this;
    }
    public CreateConnectionRequestNetworkParameters getNetworkParameters() {
        return this.networkParameters;
    }

    public static class CreateConnectionRequestAuthParametersApiKeyAuthParameters extends TeaModel {
        /**
         * <p>The key of the API key.</p>
         * 
         * <strong>example:</strong>
         * <p>Token</p>
         */
        @NameInMap("apiKeyName")
        public String apiKeyName;

        /**
         * <p>The value of the API key.</p>
         * 
         * <strong>example:</strong>
         * <p>adkjnakddh****</p>
         */
        @NameInMap("apiKeyValue")
        public String apiKeyValue;

        public static CreateConnectionRequestAuthParametersApiKeyAuthParameters build(java.util.Map<String, ?> map) throws Exception {
            CreateConnectionRequestAuthParametersApiKeyAuthParameters self = new CreateConnectionRequestAuthParametersApiKeyAuthParameters();
            return TeaModel.build(map, self);
        }

        public CreateConnectionRequestAuthParametersApiKeyAuthParameters setApiKeyName(String apiKeyName) {
            this.apiKeyName = apiKeyName;
            return this;
        }
        public String getApiKeyName() {
            return this.apiKeyName;
        }

        public CreateConnectionRequestAuthParametersApiKeyAuthParameters setApiKeyValue(String apiKeyValue) {
            this.apiKeyValue = apiKeyValue;
            return this;
        }
        public String getApiKeyValue() {
            return this.apiKeyValue;
        }

    }

    public static class CreateConnectionRequestAuthParametersBasicAuthParameters extends TeaModel {
        /**
         * <p>The password for basic authentication.</p>
         * 
         * <strong>example:</strong>
         * <hr>
         */
        @NameInMap("password")
        public String password;

        /**
         * <p>The username for basic authentication.</p>
         * 
         * <strong>example:</strong>
         * <p>admin</p>
         */
        @NameInMap("username")
        public String username;

        public static CreateConnectionRequestAuthParametersBasicAuthParameters build(java.util.Map<String, ?> map) throws Exception {
            CreateConnectionRequestAuthParametersBasicAuthParameters self = new CreateConnectionRequestAuthParametersBasicAuthParameters();
            return TeaModel.build(map, self);
        }

        public CreateConnectionRequestAuthParametersBasicAuthParameters setPassword(String password) {
            this.password = password;
            return this;
        }
        public String getPassword() {
            return this.password;
        }

        public CreateConnectionRequestAuthParametersBasicAuthParameters setUsername(String username) {
            this.username = username;
            return this;
        }
        public String getUsername() {
            return this.username;
        }

    }

    public static class CreateConnectionRequestAuthParametersOauthParametersClientParameters extends TeaModel {
        /**
         * <p>The client ID.</p>
         * 
         * <strong>example:</strong>
         * <p>ClientID</p>
         */
        @NameInMap("clientID")
        public String clientID;

        /**
         * <p>The client key secret of the application.</p>
         * 
         * <strong>example:</strong>
         * <p>ClientSecret</p>
         */
        @NameInMap("clientSecret")
        public String clientSecret;

        public static CreateConnectionRequestAuthParametersOauthParametersClientParameters build(java.util.Map<String, ?> map) throws Exception {
            CreateConnectionRequestAuthParametersOauthParametersClientParameters self = new CreateConnectionRequestAuthParametersOauthParametersClientParameters();
            return TeaModel.build(map, self);
        }

        public CreateConnectionRequestAuthParametersOauthParametersClientParameters setClientID(String clientID) {
            this.clientID = clientID;
            return this;
        }
        public String getClientID() {
            return this.clientID;
        }

        public CreateConnectionRequestAuthParametersOauthParametersClientParameters setClientSecret(String clientSecret) {
            this.clientSecret = clientSecret;
            return this;
        }
        public String getClientSecret() {
            return this.clientSecret;
        }

    }

    public static class CreateConnectionRequestAuthParametersOauthParametersOauthHttpParametersBodyParameters extends TeaModel {
        /**
         * <p>Indicates whether authentication is enabled.</p>
         * 
         * <strong>example:</strong>
         * <p>false</p>
         */
        @NameInMap("isValueSecret")
        public String isValueSecret;

        /**
         * <p>The key in the request body.</p>
         * 
         * <strong>example:</strong>
         * <p>name</p>
         */
        @NameInMap("key")
        public String key;

        /**
         * <p>The value of the key in the request body.</p>
         * 
         * <strong>example:</strong>
         * <p>demo</p>
         */
        @NameInMap("value")
        public String value;

        public static CreateConnectionRequestAuthParametersOauthParametersOauthHttpParametersBodyParameters build(java.util.Map<String, ?> map) throws Exception {
            CreateConnectionRequestAuthParametersOauthParametersOauthHttpParametersBodyParameters self = new CreateConnectionRequestAuthParametersOauthParametersOauthHttpParametersBodyParameters();
            return TeaModel.build(map, self);
        }

        public CreateConnectionRequestAuthParametersOauthParametersOauthHttpParametersBodyParameters setIsValueSecret(String isValueSecret) {
            this.isValueSecret = isValueSecret;
            return this;
        }
        public String getIsValueSecret() {
            return this.isValueSecret;
        }

        public CreateConnectionRequestAuthParametersOauthParametersOauthHttpParametersBodyParameters setKey(String key) {
            this.key = key;
            return this;
        }
        public String getKey() {
            return this.key;
        }

        public CreateConnectionRequestAuthParametersOauthParametersOauthHttpParametersBodyParameters setValue(String value) {
            this.value = value;
            return this;
        }
        public String getValue() {
            return this.value;
        }

    }

    public static class CreateConnectionRequestAuthParametersOauthParametersOauthHttpParametersHeaderParameters extends TeaModel {
        /**
         * <p>Indicates whether authentication is enabled.</p>
         * 
         * <strong>example:</strong>
         * <p>false</p>
         */
        @NameInMap("isValueSecret")
        public String isValueSecret;

        /**
         * <p>The key in the request header.</p>
         * 
         * <strong>example:</strong>
         * <p>name</p>
         */
        @NameInMap("key")
        public String key;

        /**
         * <p>The value of the key in the request header.</p>
         * 
         * <strong>example:</strong>
         * <p>demo</p>
         */
        @NameInMap("value")
        public String value;

        public static CreateConnectionRequestAuthParametersOauthParametersOauthHttpParametersHeaderParameters build(java.util.Map<String, ?> map) throws Exception {
            CreateConnectionRequestAuthParametersOauthParametersOauthHttpParametersHeaderParameters self = new CreateConnectionRequestAuthParametersOauthParametersOauthHttpParametersHeaderParameters();
            return TeaModel.build(map, self);
        }

        public CreateConnectionRequestAuthParametersOauthParametersOauthHttpParametersHeaderParameters setIsValueSecret(String isValueSecret) {
            this.isValueSecret = isValueSecret;
            return this;
        }
        public String getIsValueSecret() {
            return this.isValueSecret;
        }

        public CreateConnectionRequestAuthParametersOauthParametersOauthHttpParametersHeaderParameters setKey(String key) {
            this.key = key;
            return this;
        }
        public String getKey() {
            return this.key;
        }

        public CreateConnectionRequestAuthParametersOauthParametersOauthHttpParametersHeaderParameters setValue(String value) {
            this.value = value;
            return this;
        }
        public String getValue() {
            return this.value;
        }

    }

    public static class CreateConnectionRequestAuthParametersOauthParametersOauthHttpParametersQueryStringParameters extends TeaModel {
        /**
         * <p>Indicates whether authentication is enabled.</p>
         * 
         * <strong>example:</strong>
         * <p>false</p>
         */
        @NameInMap("isValueSecret")
        public String isValueSecret;

        /**
         * <p>The key in the request path.</p>
         * 
         * <strong>example:</strong>
         * <p>name</p>
         */
        @NameInMap("key")
        public String key;

        /**
         * <p>The value of the key in the request path.</p>
         * 
         * <strong>example:</strong>
         * <p>demo</p>
         */
        @NameInMap("value")
        public String value;

        public static CreateConnectionRequestAuthParametersOauthParametersOauthHttpParametersQueryStringParameters build(java.util.Map<String, ?> map) throws Exception {
            CreateConnectionRequestAuthParametersOauthParametersOauthHttpParametersQueryStringParameters self = new CreateConnectionRequestAuthParametersOauthParametersOauthHttpParametersQueryStringParameters();
            return TeaModel.build(map, self);
        }

        public CreateConnectionRequestAuthParametersOauthParametersOauthHttpParametersQueryStringParameters setIsValueSecret(String isValueSecret) {
            this.isValueSecret = isValueSecret;
            return this;
        }
        public String getIsValueSecret() {
            return this.isValueSecret;
        }

        public CreateConnectionRequestAuthParametersOauthParametersOauthHttpParametersQueryStringParameters setKey(String key) {
            this.key = key;
            return this;
        }
        public String getKey() {
            return this.key;
        }

        public CreateConnectionRequestAuthParametersOauthParametersOauthHttpParametersQueryStringParameters setValue(String value) {
            this.value = value;
            return this;
        }
        public String getValue() {
            return this.value;
        }

    }

    public static class CreateConnectionRequestAuthParametersOauthParametersOauthHttpParameters extends TeaModel {
        /**
         * <p>The parameters that are configured for the request.</p>
         */
        @NameInMap("bodyParameters")
        public java.util.List<CreateConnectionRequestAuthParametersOauthParametersOauthHttpParametersBodyParameters> bodyParameters;

        /**
         * <p>The parameters that are configured for the request header.</p>
         */
        @NameInMap("headerParameters")
        public java.util.List<CreateConnectionRequestAuthParametersOauthParametersOauthHttpParametersHeaderParameters> headerParameters;

        /**
         * <p>The parameters that are configured for the request path.</p>
         */
        @NameInMap("queryStringParameters")
        public java.util.List<CreateConnectionRequestAuthParametersOauthParametersOauthHttpParametersQueryStringParameters> queryStringParameters;

        public static CreateConnectionRequestAuthParametersOauthParametersOauthHttpParameters build(java.util.Map<String, ?> map) throws Exception {
            CreateConnectionRequestAuthParametersOauthParametersOauthHttpParameters self = new CreateConnectionRequestAuthParametersOauthParametersOauthHttpParameters();
            return TeaModel.build(map, self);
        }

        public CreateConnectionRequestAuthParametersOauthParametersOauthHttpParameters setBodyParameters(java.util.List<CreateConnectionRequestAuthParametersOauthParametersOauthHttpParametersBodyParameters> bodyParameters) {
            this.bodyParameters = bodyParameters;
            return this;
        }
        public java.util.List<CreateConnectionRequestAuthParametersOauthParametersOauthHttpParametersBodyParameters> getBodyParameters() {
            return this.bodyParameters;
        }

        public CreateConnectionRequestAuthParametersOauthParametersOauthHttpParameters setHeaderParameters(java.util.List<CreateConnectionRequestAuthParametersOauthParametersOauthHttpParametersHeaderParameters> headerParameters) {
            this.headerParameters = headerParameters;
            return this;
        }
        public java.util.List<CreateConnectionRequestAuthParametersOauthParametersOauthHttpParametersHeaderParameters> getHeaderParameters() {
            return this.headerParameters;
        }

        public CreateConnectionRequestAuthParametersOauthParametersOauthHttpParameters setQueryStringParameters(java.util.List<CreateConnectionRequestAuthParametersOauthParametersOauthHttpParametersQueryStringParameters> queryStringParameters) {
            this.queryStringParameters = queryStringParameters;
            return this;
        }
        public java.util.List<CreateConnectionRequestAuthParametersOauthParametersOauthHttpParametersQueryStringParameters> getQueryStringParameters() {
            return this.queryStringParameters;
        }

    }

    public static class CreateConnectionRequestAuthParametersOauthParameters extends TeaModel {
        /**
         * <p>The endpoint that is used to obtain the OAuth token.</p>
         * 
         * <strong>example:</strong>
         * <p><a href="http://localhost:8080/oauth/token">http://localhost:8080/oauth/token</a></p>
         */
        @NameInMap("authorizationEndpoint")
        public String authorizationEndpoint;

        /**
         * <p>The parameters that are configured for the client.</p>
         */
        @NameInMap("clientParameters")
        public CreateConnectionRequestAuthParametersOauthParametersClientParameters clientParameters;

        /**
         * <p>The HTTP request method. Valid values:</p>
         * <pre><code>    - GET
         * 
         *     - POST
         * 
         *     - HEAD
         * </code></pre>
         * 
         * <strong>example:</strong>
         * <p>POST</p>
         */
        @NameInMap("httpMethod")
        public String httpMethod;

        /**
         * <p>The request parameters for OAuth authentication.</p>
         */
        @NameInMap("oauthHttpParameters")
        public CreateConnectionRequestAuthParametersOauthParametersOauthHttpParameters oauthHttpParameters;

        public static CreateConnectionRequestAuthParametersOauthParameters build(java.util.Map<String, ?> map) throws Exception {
            CreateConnectionRequestAuthParametersOauthParameters self = new CreateConnectionRequestAuthParametersOauthParameters();
            return TeaModel.build(map, self);
        }

        public CreateConnectionRequestAuthParametersOauthParameters setAuthorizationEndpoint(String authorizationEndpoint) {
            this.authorizationEndpoint = authorizationEndpoint;
            return this;
        }
        public String getAuthorizationEndpoint() {
            return this.authorizationEndpoint;
        }

        public CreateConnectionRequestAuthParametersOauthParameters setClientParameters(CreateConnectionRequestAuthParametersOauthParametersClientParameters clientParameters) {
            this.clientParameters = clientParameters;
            return this;
        }
        public CreateConnectionRequestAuthParametersOauthParametersClientParameters getClientParameters() {
            return this.clientParameters;
        }

        public CreateConnectionRequestAuthParametersOauthParameters setHttpMethod(String httpMethod) {
            this.httpMethod = httpMethod;
            return this;
        }
        public String getHttpMethod() {
            return this.httpMethod;
        }

        public CreateConnectionRequestAuthParametersOauthParameters setOauthHttpParameters(CreateConnectionRequestAuthParametersOauthParametersOauthHttpParameters oauthHttpParameters) {
            this.oauthHttpParameters = oauthHttpParameters;
            return this;
        }
        public CreateConnectionRequestAuthParametersOauthParametersOauthHttpParameters getOauthHttpParameters() {
            return this.oauthHttpParameters;
        }

    }

    public static class CreateConnectionRequestAuthParameters extends TeaModel {
        /**
         * <p>The parameters that are configured for API key authentication.</p>
         */
        @NameInMap("apiKeyAuthParameters")
        public CreateConnectionRequestAuthParametersApiKeyAuthParameters apiKeyAuthParameters;

        /**
         * <p>The authentication type. Valid values:</p>
         * <pre><code>  BASIC_AUTH: basic authentication.
         * 
         *   Introduction: Basic authentication is a simple authentication scheme built into the HTTP protocol. When you use the HTTP protocol for communications, the authentication method that the HTTP server uses to authenticate user identities on the client is defined in the protocol. The request header is in the Authorization: Basic Base64-encoded string (Username:Password) format.
         * 
         *   1.  Username and Password are required
         * 
         *   API_KEY_AUTH: API key authentication.
         * 
         *   Introduction: The request header is in the Token: Token value format.
         * 
         *   *   ApiKeyName and ApiKeyValue are required.
         * 
         *   OAUTH_AUTH: OAuth authentication.
         * 
         *   Introduction: OAuth2.0 is an authentication mechanism. In normal cases, a system that does not use OAuth2.0 can access the resources of the server from the client. To ensure access security, access tokens are used to authenticate users in OAuth 2.0. The client must use an access token to access protected resources. This way, OAuth 2.0 protects resources from being accessed from malicious clients and improves system security.
         * 
         *   *   AuthorizationEndpoint, OAuthHttpParameters, and HttpMethod are required.
         * </code></pre>
         * 
         * <strong>example:</strong>
         * <p>BASIC_AUTH</p>
         */
        @NameInMap("authorizationType")
        public String authorizationType;

        /**
         * <p>The parameters that are configured for basic authentication.</p>
         */
        @NameInMap("basicAuthParameters")
        public CreateConnectionRequestAuthParametersBasicAuthParameters basicAuthParameters;

        /**
         * <p>The parameters that are configured for OAuth authentication.</p>
         */
        @NameInMap("oauthParameters")
        public CreateConnectionRequestAuthParametersOauthParameters oauthParameters;

        public static CreateConnectionRequestAuthParameters build(java.util.Map<String, ?> map) throws Exception {
            CreateConnectionRequestAuthParameters self = new CreateConnectionRequestAuthParameters();
            return TeaModel.build(map, self);
        }

        public CreateConnectionRequestAuthParameters setApiKeyAuthParameters(CreateConnectionRequestAuthParametersApiKeyAuthParameters apiKeyAuthParameters) {
            this.apiKeyAuthParameters = apiKeyAuthParameters;
            return this;
        }
        public CreateConnectionRequestAuthParametersApiKeyAuthParameters getApiKeyAuthParameters() {
            return this.apiKeyAuthParameters;
        }

        public CreateConnectionRequestAuthParameters setAuthorizationType(String authorizationType) {
            this.authorizationType = authorizationType;
            return this;
        }
        public String getAuthorizationType() {
            return this.authorizationType;
        }

        public CreateConnectionRequestAuthParameters setBasicAuthParameters(CreateConnectionRequestAuthParametersBasicAuthParameters basicAuthParameters) {
            this.basicAuthParameters = basicAuthParameters;
            return this;
        }
        public CreateConnectionRequestAuthParametersBasicAuthParameters getBasicAuthParameters() {
            return this.basicAuthParameters;
        }

        public CreateConnectionRequestAuthParameters setOauthParameters(CreateConnectionRequestAuthParametersOauthParameters oauthParameters) {
            this.oauthParameters = oauthParameters;
            return this;
        }
        public CreateConnectionRequestAuthParametersOauthParameters getOauthParameters() {
            return this.oauthParameters;
        }

    }

    public static class CreateConnectionRequestNetworkParameters extends TeaModel {
        /**
         * <p>The network type. Valid values:</p>
         * <pre><code>  PublicNetwork and PrivateNetwork.
         * 
         *   *   Note: If you set this parameter to PrivateNetwork, you must configure VpcId, VswitcheId, and SecurityGroupId.
         * 
         *   This parameter is required.
         * </code></pre>
         * 
         * <strong>example:</strong>
         * <p>PublicNetwork</p>
         */
        @NameInMap("networkType")
        public String networkType;

        /**
         * <p>The ID of the security group.</p>
         * 
         * <strong>example:</strong>
         * <p>eb-167adad548759-security_grop/sg-bp1addad26peuh9qh9****</p>
         */
        @NameInMap("securityGroupId")
        public String securityGroupId;

        /**
         * <p>The VPC. ID</p>
         * 
         * <strong>example:</strong>
         * <p>eb-test/vpc-bp1symadadwnwg****</p>
         */
        @NameInMap("vpcId")
        public String vpcId;

        /**
         * <p>The vSwitch ID.</p>
         * 
         * <strong>example:</strong>
         * <p>vsw-bp1iu4x7aeradadown1og8,vsw-bp193sqmadadlaszpeq****</p>
         */
        @NameInMap("vswitcheId")
        public String vswitcheId;

        public static CreateConnectionRequestNetworkParameters build(java.util.Map<String, ?> map) throws Exception {
            CreateConnectionRequestNetworkParameters self = new CreateConnectionRequestNetworkParameters();
            return TeaModel.build(map, self);
        }

        public CreateConnectionRequestNetworkParameters setNetworkType(String networkType) {
            this.networkType = networkType;
            return this;
        }
        public String getNetworkType() {
            return this.networkType;
        }

        public CreateConnectionRequestNetworkParameters setSecurityGroupId(String securityGroupId) {
            this.securityGroupId = securityGroupId;
            return this;
        }
        public String getSecurityGroupId() {
            return this.securityGroupId;
        }

        public CreateConnectionRequestNetworkParameters setVpcId(String vpcId) {
            this.vpcId = vpcId;
            return this;
        }
        public String getVpcId() {
            return this.vpcId;
        }

        public CreateConnectionRequestNetworkParameters setVswitcheId(String vswitcheId) {
            this.vswitcheId = vswitcheId;
            return this;
        }
        public String getVswitcheId() {
            return this.vswitcheId;
        }

    }

}
