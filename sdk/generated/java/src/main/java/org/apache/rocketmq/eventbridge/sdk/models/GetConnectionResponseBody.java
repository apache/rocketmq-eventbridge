// This file is auto-generated, don't edit it. Thanks.
package org.apache.rocketmq.eventbridge.sdk.models;

import com.aliyun.tea.*;

public class GetConnectionResponseBody extends TeaModel {
    /**
     * <p>The returned response code. The value Success indicates that the request is successful.</p>
     * 
     * <strong>example:</strong>
     * <p>Success</p>
     */
    @NameInMap("code")
    public String code;

    /**
     * <p>The value of the key in the request path.</p>
     */
    @NameInMap("connections")
    public java.util.List<GetConnectionResponseBodyConnections> connections;

    /**
     * <p>The returned message.</p>
     * 
     * <strong>example:</strong>
     * <p>success</p>
     */
    @NameInMap("message")
    public String message;

    /**
     * <p>The returned request ID.</p>
     * 
     * <strong>example:</strong>
     * <p>34AD682D-5B91-5773-8132-AA38C130****</p>
     */
    @NameInMap("requestId")
    public String requestId;

    public static GetConnectionResponseBody build(java.util.Map<String, ?> map) throws Exception {
        GetConnectionResponseBody self = new GetConnectionResponseBody();
        return TeaModel.build(map, self);
    }

    public GetConnectionResponseBody setCode(String code) {
        this.code = code;
        return this;
    }
    public String getCode() {
        return this.code;
    }

    public GetConnectionResponseBody setConnections(java.util.List<GetConnectionResponseBodyConnections> connections) {
        this.connections = connections;
        return this;
    }
    public java.util.List<GetConnectionResponseBodyConnections> getConnections() {
        return this.connections;
    }

    public GetConnectionResponseBody setMessage(String message) {
        this.message = message;
        return this;
    }
    public String getMessage() {
        return this.message;
    }

    public GetConnectionResponseBody setRequestId(String requestId) {
        this.requestId = requestId;
        return this;
    }
    public String getRequestId() {
        return this.requestId;
    }

    public static class GetConnectionResponseBodyConnectionsAuthParametersApiKeyAuthParameters extends TeaModel {
        /**
         * <p>The API key.</p>
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
         * <p>asdkjnqkwejooa</p>
         */
        @NameInMap("apiKeyValue")
        public String apiKeyValue;

        public static GetConnectionResponseBodyConnectionsAuthParametersApiKeyAuthParameters build(java.util.Map<String, ?> map) throws Exception {
            GetConnectionResponseBodyConnectionsAuthParametersApiKeyAuthParameters self = new GetConnectionResponseBodyConnectionsAuthParametersApiKeyAuthParameters();
            return TeaModel.build(map, self);
        }

        public GetConnectionResponseBodyConnectionsAuthParametersApiKeyAuthParameters setApiKeyName(String apiKeyName) {
            this.apiKeyName = apiKeyName;
            return this;
        }
        public String getApiKeyName() {
            return this.apiKeyName;
        }

        public GetConnectionResponseBodyConnectionsAuthParametersApiKeyAuthParameters setApiKeyValue(String apiKeyValue) {
            this.apiKeyValue = apiKeyValue;
            return this;
        }
        public String getApiKeyValue() {
            return this.apiKeyValue;
        }

    }

    public static class GetConnectionResponseBodyConnectionsAuthParametersBasicAuthParameters extends TeaModel {
        /**
         * <p>The password for basic authentication.</p>
         * 
         * <strong>example:</strong>
         * <p>admin</p>
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

        public static GetConnectionResponseBodyConnectionsAuthParametersBasicAuthParameters build(java.util.Map<String, ?> map) throws Exception {
            GetConnectionResponseBodyConnectionsAuthParametersBasicAuthParameters self = new GetConnectionResponseBodyConnectionsAuthParametersBasicAuthParameters();
            return TeaModel.build(map, self);
        }

        public GetConnectionResponseBodyConnectionsAuthParametersBasicAuthParameters setPassword(String password) {
            this.password = password;
            return this;
        }
        public String getPassword() {
            return this.password;
        }

        public GetConnectionResponseBodyConnectionsAuthParametersBasicAuthParameters setUsername(String username) {
            this.username = username;
            return this;
        }
        public String getUsername() {
            return this.username;
        }

    }

    public static class GetConnectionResponseBodyConnectionsAuthParametersOauthParametersClientParameters extends TeaModel {
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

        public static GetConnectionResponseBodyConnectionsAuthParametersOauthParametersClientParameters build(java.util.Map<String, ?> map) throws Exception {
            GetConnectionResponseBodyConnectionsAuthParametersOauthParametersClientParameters self = new GetConnectionResponseBodyConnectionsAuthParametersOauthParametersClientParameters();
            return TeaModel.build(map, self);
        }

        public GetConnectionResponseBodyConnectionsAuthParametersOauthParametersClientParameters setClientID(String clientID) {
            this.clientID = clientID;
            return this;
        }
        public String getClientID() {
            return this.clientID;
        }

        public GetConnectionResponseBodyConnectionsAuthParametersOauthParametersClientParameters setClientSecret(String clientSecret) {
            this.clientSecret = clientSecret;
            return this;
        }
        public String getClientSecret() {
            return this.clientSecret;
        }

    }

    public static class GetConnectionResponseBodyConnectionsAuthParametersOauthParametersOauthHttpParametersBodyParameters extends TeaModel {
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

        public static GetConnectionResponseBodyConnectionsAuthParametersOauthParametersOauthHttpParametersBodyParameters build(java.util.Map<String, ?> map) throws Exception {
            GetConnectionResponseBodyConnectionsAuthParametersOauthParametersOauthHttpParametersBodyParameters self = new GetConnectionResponseBodyConnectionsAuthParametersOauthParametersOauthHttpParametersBodyParameters();
            return TeaModel.build(map, self);
        }

        public GetConnectionResponseBodyConnectionsAuthParametersOauthParametersOauthHttpParametersBodyParameters setIsValueSecret(String isValueSecret) {
            this.isValueSecret = isValueSecret;
            return this;
        }
        public String getIsValueSecret() {
            return this.isValueSecret;
        }

        public GetConnectionResponseBodyConnectionsAuthParametersOauthParametersOauthHttpParametersBodyParameters setKey(String key) {
            this.key = key;
            return this;
        }
        public String getKey() {
            return this.key;
        }

        public GetConnectionResponseBodyConnectionsAuthParametersOauthParametersOauthHttpParametersBodyParameters setValue(String value) {
            this.value = value;
            return this;
        }
        public String getValue() {
            return this.value;
        }

    }

    public static class GetConnectionResponseBodyConnectionsAuthParametersOauthParametersOauthHttpParametersHeaderParameters extends TeaModel {
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

        public static GetConnectionResponseBodyConnectionsAuthParametersOauthParametersOauthHttpParametersHeaderParameters build(java.util.Map<String, ?> map) throws Exception {
            GetConnectionResponseBodyConnectionsAuthParametersOauthParametersOauthHttpParametersHeaderParameters self = new GetConnectionResponseBodyConnectionsAuthParametersOauthParametersOauthHttpParametersHeaderParameters();
            return TeaModel.build(map, self);
        }

        public GetConnectionResponseBodyConnectionsAuthParametersOauthParametersOauthHttpParametersHeaderParameters setIsValueSecret(String isValueSecret) {
            this.isValueSecret = isValueSecret;
            return this;
        }
        public String getIsValueSecret() {
            return this.isValueSecret;
        }

        public GetConnectionResponseBodyConnectionsAuthParametersOauthParametersOauthHttpParametersHeaderParameters setKey(String key) {
            this.key = key;
            return this;
        }
        public String getKey() {
            return this.key;
        }

        public GetConnectionResponseBodyConnectionsAuthParametersOauthParametersOauthHttpParametersHeaderParameters setValue(String value) {
            this.value = value;
            return this;
        }
        public String getValue() {
            return this.value;
        }

    }

    public static class GetConnectionResponseBodyConnectionsAuthParametersOauthParametersOauthHttpParametersQueryStringParameters extends TeaModel {
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

        public static GetConnectionResponseBodyConnectionsAuthParametersOauthParametersOauthHttpParametersQueryStringParameters build(java.util.Map<String, ?> map) throws Exception {
            GetConnectionResponseBodyConnectionsAuthParametersOauthParametersOauthHttpParametersQueryStringParameters self = new GetConnectionResponseBodyConnectionsAuthParametersOauthParametersOauthHttpParametersQueryStringParameters();
            return TeaModel.build(map, self);
        }

        public GetConnectionResponseBodyConnectionsAuthParametersOauthParametersOauthHttpParametersQueryStringParameters setIsValueSecret(String isValueSecret) {
            this.isValueSecret = isValueSecret;
            return this;
        }
        public String getIsValueSecret() {
            return this.isValueSecret;
        }

        public GetConnectionResponseBodyConnectionsAuthParametersOauthParametersOauthHttpParametersQueryStringParameters setKey(String key) {
            this.key = key;
            return this;
        }
        public String getKey() {
            return this.key;
        }

        public GetConnectionResponseBodyConnectionsAuthParametersOauthParametersOauthHttpParametersQueryStringParameters setValue(String value) {
            this.value = value;
            return this;
        }
        public String getValue() {
            return this.value;
        }

    }

    public static class GetConnectionResponseBodyConnectionsAuthParametersOauthParametersOauthHttpParameters extends TeaModel {
        /**
         * <p>The parameters that are configured for the request.</p>
         */
        @NameInMap("bodyParameters")
        public java.util.List<GetConnectionResponseBodyConnectionsAuthParametersOauthParametersOauthHttpParametersBodyParameters> bodyParameters;

        /**
         * <p>The parameters that are configured for the request header.</p>
         */
        @NameInMap("headerParameters")
        public java.util.List<GetConnectionResponseBodyConnectionsAuthParametersOauthParametersOauthHttpParametersHeaderParameters> headerParameters;

        /**
         * <p>The parameters that are configured for the request path.</p>
         */
        @NameInMap("queryStringParameters")
        public java.util.List<GetConnectionResponseBodyConnectionsAuthParametersOauthParametersOauthHttpParametersQueryStringParameters> queryStringParameters;

        public static GetConnectionResponseBodyConnectionsAuthParametersOauthParametersOauthHttpParameters build(java.util.Map<String, ?> map) throws Exception {
            GetConnectionResponseBodyConnectionsAuthParametersOauthParametersOauthHttpParameters self = new GetConnectionResponseBodyConnectionsAuthParametersOauthParametersOauthHttpParameters();
            return TeaModel.build(map, self);
        }

        public GetConnectionResponseBodyConnectionsAuthParametersOauthParametersOauthHttpParameters setBodyParameters(java.util.List<GetConnectionResponseBodyConnectionsAuthParametersOauthParametersOauthHttpParametersBodyParameters> bodyParameters) {
            this.bodyParameters = bodyParameters;
            return this;
        }
        public java.util.List<GetConnectionResponseBodyConnectionsAuthParametersOauthParametersOauthHttpParametersBodyParameters> getBodyParameters() {
            return this.bodyParameters;
        }

        public GetConnectionResponseBodyConnectionsAuthParametersOauthParametersOauthHttpParameters setHeaderParameters(java.util.List<GetConnectionResponseBodyConnectionsAuthParametersOauthParametersOauthHttpParametersHeaderParameters> headerParameters) {
            this.headerParameters = headerParameters;
            return this;
        }
        public java.util.List<GetConnectionResponseBodyConnectionsAuthParametersOauthParametersOauthHttpParametersHeaderParameters> getHeaderParameters() {
            return this.headerParameters;
        }

        public GetConnectionResponseBodyConnectionsAuthParametersOauthParametersOauthHttpParameters setQueryStringParameters(java.util.List<GetConnectionResponseBodyConnectionsAuthParametersOauthParametersOauthHttpParametersQueryStringParameters> queryStringParameters) {
            this.queryStringParameters = queryStringParameters;
            return this;
        }
        public java.util.List<GetConnectionResponseBodyConnectionsAuthParametersOauthParametersOauthHttpParametersQueryStringParameters> getQueryStringParameters() {
            return this.queryStringParameters;
        }

    }

    public static class GetConnectionResponseBodyConnectionsAuthParametersOauthParameters extends TeaModel {
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
        public GetConnectionResponseBodyConnectionsAuthParametersOauthParametersClientParameters clientParameters;

        /**
         * <p>The HTTP request method. Valid values:</p>
         * <pre><code>        - GET
         * 
         *         - POST
         * 
         *         - HEAD
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
        public GetConnectionResponseBodyConnectionsAuthParametersOauthParametersOauthHttpParameters oauthHttpParameters;

        public static GetConnectionResponseBodyConnectionsAuthParametersOauthParameters build(java.util.Map<String, ?> map) throws Exception {
            GetConnectionResponseBodyConnectionsAuthParametersOauthParameters self = new GetConnectionResponseBodyConnectionsAuthParametersOauthParameters();
            return TeaModel.build(map, self);
        }

        public GetConnectionResponseBodyConnectionsAuthParametersOauthParameters setAuthorizationEndpoint(String authorizationEndpoint) {
            this.authorizationEndpoint = authorizationEndpoint;
            return this;
        }
        public String getAuthorizationEndpoint() {
            return this.authorizationEndpoint;
        }

        public GetConnectionResponseBodyConnectionsAuthParametersOauthParameters setClientParameters(GetConnectionResponseBodyConnectionsAuthParametersOauthParametersClientParameters clientParameters) {
            this.clientParameters = clientParameters;
            return this;
        }
        public GetConnectionResponseBodyConnectionsAuthParametersOauthParametersClientParameters getClientParameters() {
            return this.clientParameters;
        }

        public GetConnectionResponseBodyConnectionsAuthParametersOauthParameters setHttpMethod(String httpMethod) {
            this.httpMethod = httpMethod;
            return this;
        }
        public String getHttpMethod() {
            return this.httpMethod;
        }

        public GetConnectionResponseBodyConnectionsAuthParametersOauthParameters setOauthHttpParameters(GetConnectionResponseBodyConnectionsAuthParametersOauthParametersOauthHttpParameters oauthHttpParameters) {
            this.oauthHttpParameters = oauthHttpParameters;
            return this;
        }
        public GetConnectionResponseBodyConnectionsAuthParametersOauthParametersOauthHttpParameters getOauthHttpParameters() {
            return this.oauthHttpParameters;
        }

    }

    public static class GetConnectionResponseBodyConnectionsAuthParameters extends TeaModel {
        /**
         * <p>The parameters that are configured for API key authentication.</p>
         */
        @NameInMap("apiKeyAuthParameters")
        public GetConnectionResponseBodyConnectionsAuthParametersApiKeyAuthParameters apiKeyAuthParameters;

        /**
         * <p>The authentication type. Valid values:</p>
         * <pre><code>      - BASIC_AUTH: basic authentication.
         * 
         * 
         *       - API_KEY_AUTH: API key authentication.
         * 
         * 
         *       - OAUTH_AUTH: OAuth authentication.
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
        public GetConnectionResponseBodyConnectionsAuthParametersBasicAuthParameters basicAuthParameters;

        /**
         * <p>The parameters that are configured for OAuth authentication.</p>
         */
        @NameInMap("oauthParameters")
        public GetConnectionResponseBodyConnectionsAuthParametersOauthParameters oauthParameters;

        public static GetConnectionResponseBodyConnectionsAuthParameters build(java.util.Map<String, ?> map) throws Exception {
            GetConnectionResponseBodyConnectionsAuthParameters self = new GetConnectionResponseBodyConnectionsAuthParameters();
            return TeaModel.build(map, self);
        }

        public GetConnectionResponseBodyConnectionsAuthParameters setApiKeyAuthParameters(GetConnectionResponseBodyConnectionsAuthParametersApiKeyAuthParameters apiKeyAuthParameters) {
            this.apiKeyAuthParameters = apiKeyAuthParameters;
            return this;
        }
        public GetConnectionResponseBodyConnectionsAuthParametersApiKeyAuthParameters getApiKeyAuthParameters() {
            return this.apiKeyAuthParameters;
        }

        public GetConnectionResponseBodyConnectionsAuthParameters setAuthorizationType(String authorizationType) {
            this.authorizationType = authorizationType;
            return this;
        }
        public String getAuthorizationType() {
            return this.authorizationType;
        }

        public GetConnectionResponseBodyConnectionsAuthParameters setBasicAuthParameters(GetConnectionResponseBodyConnectionsAuthParametersBasicAuthParameters basicAuthParameters) {
            this.basicAuthParameters = basicAuthParameters;
            return this;
        }
        public GetConnectionResponseBodyConnectionsAuthParametersBasicAuthParameters getBasicAuthParameters() {
            return this.basicAuthParameters;
        }

        public GetConnectionResponseBodyConnectionsAuthParameters setOauthParameters(GetConnectionResponseBodyConnectionsAuthParametersOauthParameters oauthParameters) {
            this.oauthParameters = oauthParameters;
            return this;
        }
        public GetConnectionResponseBodyConnectionsAuthParametersOauthParameters getOauthParameters() {
            return this.oauthParameters;
        }

    }

    public static class GetConnectionResponseBodyConnectionsNetworkParameters extends TeaModel {
        /**
         * <p>The network type. Valid values:PublicNetwork and PrivateNetwork.</p>
         * 
         * <strong>example:</strong>
         * <p>PublicNetwork</p>
         */
        @NameInMap("networkType")
        public String networkType;

        /**
         * <p>The security group ID.</p>
         * 
         * <strong>example:</strong>
         * <p>eb-167adad548759-security_grop/sg-bp1addad26peuh9qh9rtyb</p>
         */
        @NameInMap("securityGroupId")
        public String securityGroupId;

        /**
         * <p>The virtual private cloud (VPC) ID.</p>
         * 
         * <strong>example:</strong>
         * <p>eb-test/vpc-bp1symadadwnwgmqud</p>
         */
        @NameInMap("vpcId")
        public String vpcId;

        /**
         * <p>The vSwitch ID.</p>
         * 
         * <strong>example:</strong>
         * <p>vsw-bp1iu4x7aeradadown1og8,vsw-bp193sqmadadlaszpeqbt2c</p>
         */
        @NameInMap("vswitcheId")
        public String vswitcheId;

        public static GetConnectionResponseBodyConnectionsNetworkParameters build(java.util.Map<String, ?> map) throws Exception {
            GetConnectionResponseBodyConnectionsNetworkParameters self = new GetConnectionResponseBodyConnectionsNetworkParameters();
            return TeaModel.build(map, self);
        }

        public GetConnectionResponseBodyConnectionsNetworkParameters setNetworkType(String networkType) {
            this.networkType = networkType;
            return this;
        }
        public String getNetworkType() {
            return this.networkType;
        }

        public GetConnectionResponseBodyConnectionsNetworkParameters setSecurityGroupId(String securityGroupId) {
            this.securityGroupId = securityGroupId;
            return this;
        }
        public String getSecurityGroupId() {
            return this.securityGroupId;
        }

        public GetConnectionResponseBodyConnectionsNetworkParameters setVpcId(String vpcId) {
            this.vpcId = vpcId;
            return this;
        }
        public String getVpcId() {
            return this.vpcId;
        }

        public GetConnectionResponseBodyConnectionsNetworkParameters setVswitcheId(String vswitcheId) {
            this.vswitcheId = vswitcheId;
            return this;
        }
        public String getVswitcheId() {
            return this.vswitcheId;
        }

    }

    public static class GetConnectionResponseBodyConnections extends TeaModel {
        /**
         * <p>The parameters that are configured for authentication.</p>
         */
        @NameInMap("authParameters")
        public GetConnectionResponseBodyConnectionsAuthParameters authParameters;

        /**
         * <p>The connection name.</p>
         * 
         * <strong>example:</strong>
         * <p>connection-name</p>
         */
        @NameInMap("connectionName")
        public String connectionName;

        /**
         * <p>The connection description.</p>
         * 
         * <strong>example:</strong>
         * <p>The description of the connection.</p>
         */
        @NameInMap("description")
        public String description;

        /**
         * <p>The time when the connection was created.</p>
         * 
         * <strong>example:</strong>
         * <p>1592838994234</p>
         */
        @NameInMap("gmtCreate")
        public Long gmtCreate;

        /**
         * <p>The connection ID.</p>
         * 
         * <strong>example:</strong>
         * <p>1141093</p>
         */
        @NameInMap("id")
        public Integer id;

        @NameInMap("networkParameters")
        public GetConnectionResponseBodyConnectionsNetworkParameters networkParameters;

        public static GetConnectionResponseBodyConnections build(java.util.Map<String, ?> map) throws Exception {
            GetConnectionResponseBodyConnections self = new GetConnectionResponseBodyConnections();
            return TeaModel.build(map, self);
        }

        public GetConnectionResponseBodyConnections setAuthParameters(GetConnectionResponseBodyConnectionsAuthParameters authParameters) {
            this.authParameters = authParameters;
            return this;
        }
        public GetConnectionResponseBodyConnectionsAuthParameters getAuthParameters() {
            return this.authParameters;
        }

        public GetConnectionResponseBodyConnections setConnectionName(String connectionName) {
            this.connectionName = connectionName;
            return this;
        }
        public String getConnectionName() {
            return this.connectionName;
        }

        public GetConnectionResponseBodyConnections setDescription(String description) {
            this.description = description;
            return this;
        }
        public String getDescription() {
            return this.description;
        }

        public GetConnectionResponseBodyConnections setGmtCreate(Long gmtCreate) {
            this.gmtCreate = gmtCreate;
            return this;
        }
        public Long getGmtCreate() {
            return this.gmtCreate;
        }

        public GetConnectionResponseBodyConnections setId(Integer id) {
            this.id = id;
            return this;
        }
        public Integer getId() {
            return this.id;
        }

        public GetConnectionResponseBodyConnections setNetworkParameters(GetConnectionResponseBodyConnectionsNetworkParameters networkParameters) {
            this.networkParameters = networkParameters;
            return this;
        }
        public GetConnectionResponseBodyConnectionsNetworkParameters getNetworkParameters() {
            return this.networkParameters;
        }

    }

}
