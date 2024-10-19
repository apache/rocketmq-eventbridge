// This file is auto-generated, don't edit it. Thanks.
package org.apache.rocketmq.eventbridge.sdk.models;

import com.aliyun.tea.*;

public class UpdateConnectionRequest extends TeaModel {
    /**
     * <p>The parameters that are configured for authentication.</p>
     */
    @NameInMap("authParameters")
    public UpdateConnectionRequestAuthParameters authParameters;

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
    public UpdateConnectionRequestNetworkParameters networkParameters;

    public static UpdateConnectionRequest build(java.util.Map<String, ?> map) throws Exception {
        UpdateConnectionRequest self = new UpdateConnectionRequest();
        return TeaModel.build(map, self);
    }

    public UpdateConnectionRequest setAuthParameters(UpdateConnectionRequestAuthParameters authParameters) {
        this.authParameters = authParameters;
        return this;
    }
    public UpdateConnectionRequestAuthParameters getAuthParameters() {
        return this.authParameters;
    }

    public UpdateConnectionRequest setConnectionName(String connectionName) {
        this.connectionName = connectionName;
        return this;
    }
    public String getConnectionName() {
        return this.connectionName;
    }

    public UpdateConnectionRequest setDescription(String description) {
        this.description = description;
        return this;
    }
    public String getDescription() {
        return this.description;
    }

    public UpdateConnectionRequest setNetworkParameters(UpdateConnectionRequestNetworkParameters networkParameters) {
        this.networkParameters = networkParameters;
        return this;
    }
    public UpdateConnectionRequestNetworkParameters getNetworkParameters() {
        return this.networkParameters;
    }

    public static class UpdateConnectionRequestAuthParametersApiKeyAuthParameters extends TeaModel {
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

        public static UpdateConnectionRequestAuthParametersApiKeyAuthParameters build(java.util.Map<String, ?> map) throws Exception {
            UpdateConnectionRequestAuthParametersApiKeyAuthParameters self = new UpdateConnectionRequestAuthParametersApiKeyAuthParameters();
            return TeaModel.build(map, self);
        }

        public UpdateConnectionRequestAuthParametersApiKeyAuthParameters setApiKeyName(String apiKeyName) {
            this.apiKeyName = apiKeyName;
            return this;
        }
        public String getApiKeyName() {
            return this.apiKeyName;
        }

        public UpdateConnectionRequestAuthParametersApiKeyAuthParameters setApiKeyValue(String apiKeyValue) {
            this.apiKeyValue = apiKeyValue;
            return this;
        }
        public String getApiKeyValue() {
            return this.apiKeyValue;
        }

    }

    public static class UpdateConnectionRequestAuthParametersBasicAuthParameters extends TeaModel {
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

        public static UpdateConnectionRequestAuthParametersBasicAuthParameters build(java.util.Map<String, ?> map) throws Exception {
            UpdateConnectionRequestAuthParametersBasicAuthParameters self = new UpdateConnectionRequestAuthParametersBasicAuthParameters();
            return TeaModel.build(map, self);
        }

        public UpdateConnectionRequestAuthParametersBasicAuthParameters setPassword(String password) {
            this.password = password;
            return this;
        }
        public String getPassword() {
            return this.password;
        }

        public UpdateConnectionRequestAuthParametersBasicAuthParameters setUsername(String username) {
            this.username = username;
            return this;
        }
        public String getUsername() {
            return this.username;
        }

    }

    public static class UpdateConnectionRequestAuthParametersOauthParametersClientParameters extends TeaModel {
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

        public static UpdateConnectionRequestAuthParametersOauthParametersClientParameters build(java.util.Map<String, ?> map) throws Exception {
            UpdateConnectionRequestAuthParametersOauthParametersClientParameters self = new UpdateConnectionRequestAuthParametersOauthParametersClientParameters();
            return TeaModel.build(map, self);
        }

        public UpdateConnectionRequestAuthParametersOauthParametersClientParameters setClientID(String clientID) {
            this.clientID = clientID;
            return this;
        }
        public String getClientID() {
            return this.clientID;
        }

        public UpdateConnectionRequestAuthParametersOauthParametersClientParameters setClientSecret(String clientSecret) {
            this.clientSecret = clientSecret;
            return this;
        }
        public String getClientSecret() {
            return this.clientSecret;
        }

    }

    public static class UpdateConnectionRequestAuthParametersOauthParametersOauthHttpParametersBodyParameters extends TeaModel {
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

        public static UpdateConnectionRequestAuthParametersOauthParametersOauthHttpParametersBodyParameters build(java.util.Map<String, ?> map) throws Exception {
            UpdateConnectionRequestAuthParametersOauthParametersOauthHttpParametersBodyParameters self = new UpdateConnectionRequestAuthParametersOauthParametersOauthHttpParametersBodyParameters();
            return TeaModel.build(map, self);
        }

        public UpdateConnectionRequestAuthParametersOauthParametersOauthHttpParametersBodyParameters setIsValueSecret(String isValueSecret) {
            this.isValueSecret = isValueSecret;
            return this;
        }
        public String getIsValueSecret() {
            return this.isValueSecret;
        }

        public UpdateConnectionRequestAuthParametersOauthParametersOauthHttpParametersBodyParameters setKey(String key) {
            this.key = key;
            return this;
        }
        public String getKey() {
            return this.key;
        }

        public UpdateConnectionRequestAuthParametersOauthParametersOauthHttpParametersBodyParameters setValue(String value) {
            this.value = value;
            return this;
        }
        public String getValue() {
            return this.value;
        }

    }

    public static class UpdateConnectionRequestAuthParametersOauthParametersOauthHttpParametersHeaderParameters extends TeaModel {
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

        public static UpdateConnectionRequestAuthParametersOauthParametersOauthHttpParametersHeaderParameters build(java.util.Map<String, ?> map) throws Exception {
            UpdateConnectionRequestAuthParametersOauthParametersOauthHttpParametersHeaderParameters self = new UpdateConnectionRequestAuthParametersOauthParametersOauthHttpParametersHeaderParameters();
            return TeaModel.build(map, self);
        }

        public UpdateConnectionRequestAuthParametersOauthParametersOauthHttpParametersHeaderParameters setIsValueSecret(String isValueSecret) {
            this.isValueSecret = isValueSecret;
            return this;
        }
        public String getIsValueSecret() {
            return this.isValueSecret;
        }

        public UpdateConnectionRequestAuthParametersOauthParametersOauthHttpParametersHeaderParameters setKey(String key) {
            this.key = key;
            return this;
        }
        public String getKey() {
            return this.key;
        }

        public UpdateConnectionRequestAuthParametersOauthParametersOauthHttpParametersHeaderParameters setValue(String value) {
            this.value = value;
            return this;
        }
        public String getValue() {
            return this.value;
        }

    }

    public static class UpdateConnectionRequestAuthParametersOauthParametersOauthHttpParametersQueryStringParameters extends TeaModel {
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

        public static UpdateConnectionRequestAuthParametersOauthParametersOauthHttpParametersQueryStringParameters build(java.util.Map<String, ?> map) throws Exception {
            UpdateConnectionRequestAuthParametersOauthParametersOauthHttpParametersQueryStringParameters self = new UpdateConnectionRequestAuthParametersOauthParametersOauthHttpParametersQueryStringParameters();
            return TeaModel.build(map, self);
        }

        public UpdateConnectionRequestAuthParametersOauthParametersOauthHttpParametersQueryStringParameters setIsValueSecret(String isValueSecret) {
            this.isValueSecret = isValueSecret;
            return this;
        }
        public String getIsValueSecret() {
            return this.isValueSecret;
        }

        public UpdateConnectionRequestAuthParametersOauthParametersOauthHttpParametersQueryStringParameters setKey(String key) {
            this.key = key;
            return this;
        }
        public String getKey() {
            return this.key;
        }

        public UpdateConnectionRequestAuthParametersOauthParametersOauthHttpParametersQueryStringParameters setValue(String value) {
            this.value = value;
            return this;
        }
        public String getValue() {
            return this.value;
        }

    }

    public static class UpdateConnectionRequestAuthParametersOauthParametersOauthHttpParameters extends TeaModel {
        /**
         * <p>The parameters that are configured for the request.</p>
         */
        @NameInMap("bodyParameters")
        public java.util.List<UpdateConnectionRequestAuthParametersOauthParametersOauthHttpParametersBodyParameters> bodyParameters;

        /**
         * <p>The parameters that are configured for the request header.</p>
         */
        @NameInMap("headerParameters")
        public java.util.List<UpdateConnectionRequestAuthParametersOauthParametersOauthHttpParametersHeaderParameters> headerParameters;

        /**
         * <p>The parameters that are configured for the request path.</p>
         */
        @NameInMap("queryStringParameters")
        public java.util.List<UpdateConnectionRequestAuthParametersOauthParametersOauthHttpParametersQueryStringParameters> queryStringParameters;

        public static UpdateConnectionRequestAuthParametersOauthParametersOauthHttpParameters build(java.util.Map<String, ?> map) throws Exception {
            UpdateConnectionRequestAuthParametersOauthParametersOauthHttpParameters self = new UpdateConnectionRequestAuthParametersOauthParametersOauthHttpParameters();
            return TeaModel.build(map, self);
        }

        public UpdateConnectionRequestAuthParametersOauthParametersOauthHttpParameters setBodyParameters(java.util.List<UpdateConnectionRequestAuthParametersOauthParametersOauthHttpParametersBodyParameters> bodyParameters) {
            this.bodyParameters = bodyParameters;
            return this;
        }
        public java.util.List<UpdateConnectionRequestAuthParametersOauthParametersOauthHttpParametersBodyParameters> getBodyParameters() {
            return this.bodyParameters;
        }

        public UpdateConnectionRequestAuthParametersOauthParametersOauthHttpParameters setHeaderParameters(java.util.List<UpdateConnectionRequestAuthParametersOauthParametersOauthHttpParametersHeaderParameters> headerParameters) {
            this.headerParameters = headerParameters;
            return this;
        }
        public java.util.List<UpdateConnectionRequestAuthParametersOauthParametersOauthHttpParametersHeaderParameters> getHeaderParameters() {
            return this.headerParameters;
        }

        public UpdateConnectionRequestAuthParametersOauthParametersOauthHttpParameters setQueryStringParameters(java.util.List<UpdateConnectionRequestAuthParametersOauthParametersOauthHttpParametersQueryStringParameters> queryStringParameters) {
            this.queryStringParameters = queryStringParameters;
            return this;
        }
        public java.util.List<UpdateConnectionRequestAuthParametersOauthParametersOauthHttpParametersQueryStringParameters> getQueryStringParameters() {
            return this.queryStringParameters;
        }

    }

    public static class UpdateConnectionRequestAuthParametersOauthParameters extends TeaModel {
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
        public UpdateConnectionRequestAuthParametersOauthParametersClientParameters clientParameters;

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
        public UpdateConnectionRequestAuthParametersOauthParametersOauthHttpParameters oauthHttpParameters;

        public static UpdateConnectionRequestAuthParametersOauthParameters build(java.util.Map<String, ?> map) throws Exception {
            UpdateConnectionRequestAuthParametersOauthParameters self = new UpdateConnectionRequestAuthParametersOauthParameters();
            return TeaModel.build(map, self);
        }

        public UpdateConnectionRequestAuthParametersOauthParameters setAuthorizationEndpoint(String authorizationEndpoint) {
            this.authorizationEndpoint = authorizationEndpoint;
            return this;
        }
        public String getAuthorizationEndpoint() {
            return this.authorizationEndpoint;
        }

        public UpdateConnectionRequestAuthParametersOauthParameters setClientParameters(UpdateConnectionRequestAuthParametersOauthParametersClientParameters clientParameters) {
            this.clientParameters = clientParameters;
            return this;
        }
        public UpdateConnectionRequestAuthParametersOauthParametersClientParameters getClientParameters() {
            return this.clientParameters;
        }

        public UpdateConnectionRequestAuthParametersOauthParameters setHttpMethod(String httpMethod) {
            this.httpMethod = httpMethod;
            return this;
        }
        public String getHttpMethod() {
            return this.httpMethod;
        }

        public UpdateConnectionRequestAuthParametersOauthParameters setOauthHttpParameters(UpdateConnectionRequestAuthParametersOauthParametersOauthHttpParameters oauthHttpParameters) {
            this.oauthHttpParameters = oauthHttpParameters;
            return this;
        }
        public UpdateConnectionRequestAuthParametersOauthParametersOauthHttpParameters getOauthHttpParameters() {
            return this.oauthHttpParameters;
        }

    }

    public static class UpdateConnectionRequestAuthParameters extends TeaModel {
        /**
         * <p>The parameters that are configured for API key authentication.</p>
         */
        @NameInMap("apiKeyAuthParameters")
        public UpdateConnectionRequestAuthParametersApiKeyAuthParameters apiKeyAuthParameters;

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
        public UpdateConnectionRequestAuthParametersBasicAuthParameters basicAuthParameters;

        /**
         * <p>The parameters that are configured for OAuth authentication.</p>
         */
        @NameInMap("oauthParameters")
        public UpdateConnectionRequestAuthParametersOauthParameters oauthParameters;

        public static UpdateConnectionRequestAuthParameters build(java.util.Map<String, ?> map) throws Exception {
            UpdateConnectionRequestAuthParameters self = new UpdateConnectionRequestAuthParameters();
            return TeaModel.build(map, self);
        }

        public UpdateConnectionRequestAuthParameters setApiKeyAuthParameters(UpdateConnectionRequestAuthParametersApiKeyAuthParameters apiKeyAuthParameters) {
            this.apiKeyAuthParameters = apiKeyAuthParameters;
            return this;
        }
        public UpdateConnectionRequestAuthParametersApiKeyAuthParameters getApiKeyAuthParameters() {
            return this.apiKeyAuthParameters;
        }

        public UpdateConnectionRequestAuthParameters setAuthorizationType(String authorizationType) {
            this.authorizationType = authorizationType;
            return this;
        }
        public String getAuthorizationType() {
            return this.authorizationType;
        }

        public UpdateConnectionRequestAuthParameters setBasicAuthParameters(UpdateConnectionRequestAuthParametersBasicAuthParameters basicAuthParameters) {
            this.basicAuthParameters = basicAuthParameters;
            return this;
        }
        public UpdateConnectionRequestAuthParametersBasicAuthParameters getBasicAuthParameters() {
            return this.basicAuthParameters;
        }

        public UpdateConnectionRequestAuthParameters setOauthParameters(UpdateConnectionRequestAuthParametersOauthParameters oauthParameters) {
            this.oauthParameters = oauthParameters;
            return this;
        }
        public UpdateConnectionRequestAuthParametersOauthParameters getOauthParameters() {
            return this.oauthParameters;
        }

    }

    public static class UpdateConnectionRequestNetworkParameters extends TeaModel {
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

        public static UpdateConnectionRequestNetworkParameters build(java.util.Map<String, ?> map) throws Exception {
            UpdateConnectionRequestNetworkParameters self = new UpdateConnectionRequestNetworkParameters();
            return TeaModel.build(map, self);
        }

        public UpdateConnectionRequestNetworkParameters setNetworkType(String networkType) {
            this.networkType = networkType;
            return this;
        }
        public String getNetworkType() {
            return this.networkType;
        }

        public UpdateConnectionRequestNetworkParameters setSecurityGroupId(String securityGroupId) {
            this.securityGroupId = securityGroupId;
            return this;
        }
        public String getSecurityGroupId() {
            return this.securityGroupId;
        }

        public UpdateConnectionRequestNetworkParameters setVpcId(String vpcId) {
            this.vpcId = vpcId;
            return this;
        }
        public String getVpcId() {
            return this.vpcId;
        }

        public UpdateConnectionRequestNetworkParameters setVswitcheId(String vswitcheId) {
            this.vswitcheId = vswitcheId;
            return this;
        }
        public String getVswitcheId() {
            return this.vswitcheId;
        }

    }

}
