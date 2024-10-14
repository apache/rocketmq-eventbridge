// This file is auto-generated, don't edit it. Thanks.
package org.apache.rocketmq.eventbridge.sdk.models;

import com.aliyun.tea.*;

public class ListConnectionsResponseBody extends TeaModel {
    /**
     * <p>The HTTP status code. The value Success indicates that the request is successful.</p>
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
    public java.util.List<ListConnectionsResponseBodyConnections> connections;

    /**
     * <p>The number of entries returned per page.</p>
     * 
     * <strong>example:</strong>
     * <p>10</p>
     */
    @NameInMap("maxResults")
    public Integer maxResults;

    /**
     * <p>If excess return values exist, this parameter is returned.</p>
     * 
     * <strong>example:</strong>
     * <p>0</p>
     */
    @NameInMap("nextToken")
    public String nextToken;

    /**
     * <p>The total number of entries returned.</p>
     * 
     * <strong>example:</strong>
     * <p>1</p>
     */
    @NameInMap("total")
    public Integer total;

    /**
     * <p>The message returned.</p>
     * 
     * <strong>example:</strong>
     * <p>success</p>
     */
    @NameInMap("message")
    public String message;

    /**
     * <p>The ID of the request. This parameter is a common parameter. Each request has a unique ID. You can use the ID to troubleshoot issues.</p>
     * 
     * <strong>example:</strong>
     * <p>E3619976-8714-5D88-BBA2-6983D798A8BB</p>
     */
    @NameInMap("requestId")
    public String requestId;

    public static ListConnectionsResponseBody build(java.util.Map<String, ?> map) throws Exception {
        ListConnectionsResponseBody self = new ListConnectionsResponseBody();
        return TeaModel.build(map, self);
    }

    public ListConnectionsResponseBody setCode(String code) {
        this.code = code;
        return this;
    }
    public String getCode() {
        return this.code;
    }

    public ListConnectionsResponseBody setConnections(java.util.List<ListConnectionsResponseBodyConnections> connections) {
        this.connections = connections;
        return this;
    }
    public java.util.List<ListConnectionsResponseBodyConnections> getConnections() {
        return this.connections;
    }

    public ListConnectionsResponseBody setMaxResults(Integer maxResults) {
        this.maxResults = maxResults;
        return this;
    }
    public Integer getMaxResults() {
        return this.maxResults;
    }

    public ListConnectionsResponseBody setNextToken(String nextToken) {
        this.nextToken = nextToken;
        return this;
    }
    public String getNextToken() {
        return this.nextToken;
    }

    public ListConnectionsResponseBody setTotal(Integer total) {
        this.total = total;
        return this;
    }
    public Integer getTotal() {
        return this.total;
    }

    public ListConnectionsResponseBody setMessage(String message) {
        this.message = message;
        return this;
    }
    public String getMessage() {
        return this.message;
    }

    public ListConnectionsResponseBody setRequestId(String requestId) {
        this.requestId = requestId;
        return this;
    }
    public String getRequestId() {
        return this.requestId;
    }

    public static class ListConnectionsResponseBodyConnectionsAuthParametersApiKeyAuthParameters extends TeaModel {
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

        public static ListConnectionsResponseBodyConnectionsAuthParametersApiKeyAuthParameters build(java.util.Map<String, ?> map) throws Exception {
            ListConnectionsResponseBodyConnectionsAuthParametersApiKeyAuthParameters self = new ListConnectionsResponseBodyConnectionsAuthParametersApiKeyAuthParameters();
            return TeaModel.build(map, self);
        }

        public ListConnectionsResponseBodyConnectionsAuthParametersApiKeyAuthParameters setApiKeyName(String apiKeyName) {
            this.apiKeyName = apiKeyName;
            return this;
        }
        public String getApiKeyName() {
            return this.apiKeyName;
        }

        public ListConnectionsResponseBodyConnectionsAuthParametersApiKeyAuthParameters setApiKeyValue(String apiKeyValue) {
            this.apiKeyValue = apiKeyValue;
            return this;
        }
        public String getApiKeyValue() {
            return this.apiKeyValue;
        }

    }

    public static class ListConnectionsResponseBodyConnectionsAuthParametersBasicAuthParameters extends TeaModel {
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

        public static ListConnectionsResponseBodyConnectionsAuthParametersBasicAuthParameters build(java.util.Map<String, ?> map) throws Exception {
            ListConnectionsResponseBodyConnectionsAuthParametersBasicAuthParameters self = new ListConnectionsResponseBodyConnectionsAuthParametersBasicAuthParameters();
            return TeaModel.build(map, self);
        }

        public ListConnectionsResponseBodyConnectionsAuthParametersBasicAuthParameters setPassword(String password) {
            this.password = password;
            return this;
        }
        public String getPassword() {
            return this.password;
        }

        public ListConnectionsResponseBodyConnectionsAuthParametersBasicAuthParameters setUsername(String username) {
            this.username = username;
            return this;
        }
        public String getUsername() {
            return this.username;
        }

    }

    public static class ListConnectionsResponseBodyConnectionsAuthParametersOauthParametersClientParameters extends TeaModel {
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

        public static ListConnectionsResponseBodyConnectionsAuthParametersOauthParametersClientParameters build(java.util.Map<String, ?> map) throws Exception {
            ListConnectionsResponseBodyConnectionsAuthParametersOauthParametersClientParameters self = new ListConnectionsResponseBodyConnectionsAuthParametersOauthParametersClientParameters();
            return TeaModel.build(map, self);
        }

        public ListConnectionsResponseBodyConnectionsAuthParametersOauthParametersClientParameters setClientID(String clientID) {
            this.clientID = clientID;
            return this;
        }
        public String getClientID() {
            return this.clientID;
        }

        public ListConnectionsResponseBodyConnectionsAuthParametersOauthParametersClientParameters setClientSecret(String clientSecret) {
            this.clientSecret = clientSecret;
            return this;
        }
        public String getClientSecret() {
            return this.clientSecret;
        }

    }

    public static class ListConnectionsResponseBodyConnectionsAuthParametersOauthParametersOauthHttpParametersBodyParameters extends TeaModel {
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

        public static ListConnectionsResponseBodyConnectionsAuthParametersOauthParametersOauthHttpParametersBodyParameters build(java.util.Map<String, ?> map) throws Exception {
            ListConnectionsResponseBodyConnectionsAuthParametersOauthParametersOauthHttpParametersBodyParameters self = new ListConnectionsResponseBodyConnectionsAuthParametersOauthParametersOauthHttpParametersBodyParameters();
            return TeaModel.build(map, self);
        }

        public ListConnectionsResponseBodyConnectionsAuthParametersOauthParametersOauthHttpParametersBodyParameters setIsValueSecret(String isValueSecret) {
            this.isValueSecret = isValueSecret;
            return this;
        }
        public String getIsValueSecret() {
            return this.isValueSecret;
        }

        public ListConnectionsResponseBodyConnectionsAuthParametersOauthParametersOauthHttpParametersBodyParameters setKey(String key) {
            this.key = key;
            return this;
        }
        public String getKey() {
            return this.key;
        }

        public ListConnectionsResponseBodyConnectionsAuthParametersOauthParametersOauthHttpParametersBodyParameters setValue(String value) {
            this.value = value;
            return this;
        }
        public String getValue() {
            return this.value;
        }

    }

    public static class ListConnectionsResponseBodyConnectionsAuthParametersOauthParametersOauthHttpParametersHeaderParameters extends TeaModel {
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

        public static ListConnectionsResponseBodyConnectionsAuthParametersOauthParametersOauthHttpParametersHeaderParameters build(java.util.Map<String, ?> map) throws Exception {
            ListConnectionsResponseBodyConnectionsAuthParametersOauthParametersOauthHttpParametersHeaderParameters self = new ListConnectionsResponseBodyConnectionsAuthParametersOauthParametersOauthHttpParametersHeaderParameters();
            return TeaModel.build(map, self);
        }

        public ListConnectionsResponseBodyConnectionsAuthParametersOauthParametersOauthHttpParametersHeaderParameters setIsValueSecret(String isValueSecret) {
            this.isValueSecret = isValueSecret;
            return this;
        }
        public String getIsValueSecret() {
            return this.isValueSecret;
        }

        public ListConnectionsResponseBodyConnectionsAuthParametersOauthParametersOauthHttpParametersHeaderParameters setKey(String key) {
            this.key = key;
            return this;
        }
        public String getKey() {
            return this.key;
        }

        public ListConnectionsResponseBodyConnectionsAuthParametersOauthParametersOauthHttpParametersHeaderParameters setValue(String value) {
            this.value = value;
            return this;
        }
        public String getValue() {
            return this.value;
        }

    }

    public static class ListConnectionsResponseBodyConnectionsAuthParametersOauthParametersOauthHttpParametersQueryStringParameters extends TeaModel {
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

        public static ListConnectionsResponseBodyConnectionsAuthParametersOauthParametersOauthHttpParametersQueryStringParameters build(java.util.Map<String, ?> map) throws Exception {
            ListConnectionsResponseBodyConnectionsAuthParametersOauthParametersOauthHttpParametersQueryStringParameters self = new ListConnectionsResponseBodyConnectionsAuthParametersOauthParametersOauthHttpParametersQueryStringParameters();
            return TeaModel.build(map, self);
        }

        public ListConnectionsResponseBodyConnectionsAuthParametersOauthParametersOauthHttpParametersQueryStringParameters setIsValueSecret(String isValueSecret) {
            this.isValueSecret = isValueSecret;
            return this;
        }
        public String getIsValueSecret() {
            return this.isValueSecret;
        }

        public ListConnectionsResponseBodyConnectionsAuthParametersOauthParametersOauthHttpParametersQueryStringParameters setKey(String key) {
            this.key = key;
            return this;
        }
        public String getKey() {
            return this.key;
        }

        public ListConnectionsResponseBodyConnectionsAuthParametersOauthParametersOauthHttpParametersQueryStringParameters setValue(String value) {
            this.value = value;
            return this;
        }
        public String getValue() {
            return this.value;
        }

    }

    public static class ListConnectionsResponseBodyConnectionsAuthParametersOauthParametersOauthHttpParameters extends TeaModel {
        /**
         * <p>The parameters that are configured for the request.</p>
         */
        @NameInMap("bodyParameters")
        public java.util.List<ListConnectionsResponseBodyConnectionsAuthParametersOauthParametersOauthHttpParametersBodyParameters> bodyParameters;

        /**
         * <p>The parameters that are configured for the request header.</p>
         */
        @NameInMap("headerParameters")
        public java.util.List<ListConnectionsResponseBodyConnectionsAuthParametersOauthParametersOauthHttpParametersHeaderParameters> headerParameters;

        /**
         * <p>The parameters that are configured for the request path.</p>
         */
        @NameInMap("queryStringParameters")
        public java.util.List<ListConnectionsResponseBodyConnectionsAuthParametersOauthParametersOauthHttpParametersQueryStringParameters> queryStringParameters;

        public static ListConnectionsResponseBodyConnectionsAuthParametersOauthParametersOauthHttpParameters build(java.util.Map<String, ?> map) throws Exception {
            ListConnectionsResponseBodyConnectionsAuthParametersOauthParametersOauthHttpParameters self = new ListConnectionsResponseBodyConnectionsAuthParametersOauthParametersOauthHttpParameters();
            return TeaModel.build(map, self);
        }

        public ListConnectionsResponseBodyConnectionsAuthParametersOauthParametersOauthHttpParameters setBodyParameters(java.util.List<ListConnectionsResponseBodyConnectionsAuthParametersOauthParametersOauthHttpParametersBodyParameters> bodyParameters) {
            this.bodyParameters = bodyParameters;
            return this;
        }
        public java.util.List<ListConnectionsResponseBodyConnectionsAuthParametersOauthParametersOauthHttpParametersBodyParameters> getBodyParameters() {
            return this.bodyParameters;
        }

        public ListConnectionsResponseBodyConnectionsAuthParametersOauthParametersOauthHttpParameters setHeaderParameters(java.util.List<ListConnectionsResponseBodyConnectionsAuthParametersOauthParametersOauthHttpParametersHeaderParameters> headerParameters) {
            this.headerParameters = headerParameters;
            return this;
        }
        public java.util.List<ListConnectionsResponseBodyConnectionsAuthParametersOauthParametersOauthHttpParametersHeaderParameters> getHeaderParameters() {
            return this.headerParameters;
        }

        public ListConnectionsResponseBodyConnectionsAuthParametersOauthParametersOauthHttpParameters setQueryStringParameters(java.util.List<ListConnectionsResponseBodyConnectionsAuthParametersOauthParametersOauthHttpParametersQueryStringParameters> queryStringParameters) {
            this.queryStringParameters = queryStringParameters;
            return this;
        }
        public java.util.List<ListConnectionsResponseBodyConnectionsAuthParametersOauthParametersOauthHttpParametersQueryStringParameters> getQueryStringParameters() {
            return this.queryStringParameters;
        }

    }

    public static class ListConnectionsResponseBodyConnectionsAuthParametersOauthParameters extends TeaModel {
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
        public ListConnectionsResponseBodyConnectionsAuthParametersOauthParametersClientParameters clientParameters;

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
        public ListConnectionsResponseBodyConnectionsAuthParametersOauthParametersOauthHttpParameters oauthHttpParameters;

        public static ListConnectionsResponseBodyConnectionsAuthParametersOauthParameters build(java.util.Map<String, ?> map) throws Exception {
            ListConnectionsResponseBodyConnectionsAuthParametersOauthParameters self = new ListConnectionsResponseBodyConnectionsAuthParametersOauthParameters();
            return TeaModel.build(map, self);
        }

        public ListConnectionsResponseBodyConnectionsAuthParametersOauthParameters setAuthorizationEndpoint(String authorizationEndpoint) {
            this.authorizationEndpoint = authorizationEndpoint;
            return this;
        }
        public String getAuthorizationEndpoint() {
            return this.authorizationEndpoint;
        }

        public ListConnectionsResponseBodyConnectionsAuthParametersOauthParameters setClientParameters(ListConnectionsResponseBodyConnectionsAuthParametersOauthParametersClientParameters clientParameters) {
            this.clientParameters = clientParameters;
            return this;
        }
        public ListConnectionsResponseBodyConnectionsAuthParametersOauthParametersClientParameters getClientParameters() {
            return this.clientParameters;
        }

        public ListConnectionsResponseBodyConnectionsAuthParametersOauthParameters setHttpMethod(String httpMethod) {
            this.httpMethod = httpMethod;
            return this;
        }
        public String getHttpMethod() {
            return this.httpMethod;
        }

        public ListConnectionsResponseBodyConnectionsAuthParametersOauthParameters setOauthHttpParameters(ListConnectionsResponseBodyConnectionsAuthParametersOauthParametersOauthHttpParameters oauthHttpParameters) {
            this.oauthHttpParameters = oauthHttpParameters;
            return this;
        }
        public ListConnectionsResponseBodyConnectionsAuthParametersOauthParametersOauthHttpParameters getOauthHttpParameters() {
            return this.oauthHttpParameters;
        }

    }

    public static class ListConnectionsResponseBodyConnectionsAuthParameters extends TeaModel {
        /**
         * <p>The parameters that are configured for API key authentication.</p>
         */
        @NameInMap("apiKeyAuthParameters")
        public ListConnectionsResponseBodyConnectionsAuthParametersApiKeyAuthParameters apiKeyAuthParameters;

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
        public ListConnectionsResponseBodyConnectionsAuthParametersBasicAuthParameters basicAuthParameters;

        /**
         * <p>The parameters that are configured for OAuth authentication.</p>
         */
        @NameInMap("oauthParameters")
        public ListConnectionsResponseBodyConnectionsAuthParametersOauthParameters oauthParameters;

        public static ListConnectionsResponseBodyConnectionsAuthParameters build(java.util.Map<String, ?> map) throws Exception {
            ListConnectionsResponseBodyConnectionsAuthParameters self = new ListConnectionsResponseBodyConnectionsAuthParameters();
            return TeaModel.build(map, self);
        }

        public ListConnectionsResponseBodyConnectionsAuthParameters setApiKeyAuthParameters(ListConnectionsResponseBodyConnectionsAuthParametersApiKeyAuthParameters apiKeyAuthParameters) {
            this.apiKeyAuthParameters = apiKeyAuthParameters;
            return this;
        }
        public ListConnectionsResponseBodyConnectionsAuthParametersApiKeyAuthParameters getApiKeyAuthParameters() {
            return this.apiKeyAuthParameters;
        }

        public ListConnectionsResponseBodyConnectionsAuthParameters setAuthorizationType(String authorizationType) {
            this.authorizationType = authorizationType;
            return this;
        }
        public String getAuthorizationType() {
            return this.authorizationType;
        }

        public ListConnectionsResponseBodyConnectionsAuthParameters setBasicAuthParameters(ListConnectionsResponseBodyConnectionsAuthParametersBasicAuthParameters basicAuthParameters) {
            this.basicAuthParameters = basicAuthParameters;
            return this;
        }
        public ListConnectionsResponseBodyConnectionsAuthParametersBasicAuthParameters getBasicAuthParameters() {
            return this.basicAuthParameters;
        }

        public ListConnectionsResponseBodyConnectionsAuthParameters setOauthParameters(ListConnectionsResponseBodyConnectionsAuthParametersOauthParameters oauthParameters) {
            this.oauthParameters = oauthParameters;
            return this;
        }
        public ListConnectionsResponseBodyConnectionsAuthParametersOauthParameters getOauthParameters() {
            return this.oauthParameters;
        }

    }

    public static class ListConnectionsResponseBodyConnectionsNetworkParameters extends TeaModel {
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

        public static ListConnectionsResponseBodyConnectionsNetworkParameters build(java.util.Map<String, ?> map) throws Exception {
            ListConnectionsResponseBodyConnectionsNetworkParameters self = new ListConnectionsResponseBodyConnectionsNetworkParameters();
            return TeaModel.build(map, self);
        }

        public ListConnectionsResponseBodyConnectionsNetworkParameters setNetworkType(String networkType) {
            this.networkType = networkType;
            return this;
        }
        public String getNetworkType() {
            return this.networkType;
        }

        public ListConnectionsResponseBodyConnectionsNetworkParameters setSecurityGroupId(String securityGroupId) {
            this.securityGroupId = securityGroupId;
            return this;
        }
        public String getSecurityGroupId() {
            return this.securityGroupId;
        }

        public ListConnectionsResponseBodyConnectionsNetworkParameters setVpcId(String vpcId) {
            this.vpcId = vpcId;
            return this;
        }
        public String getVpcId() {
            return this.vpcId;
        }

        public ListConnectionsResponseBodyConnectionsNetworkParameters setVswitcheId(String vswitcheId) {
            this.vswitcheId = vswitcheId;
            return this;
        }
        public String getVswitcheId() {
            return this.vswitcheId;
        }

    }

    public static class ListConnectionsResponseBodyConnections extends TeaModel {
        /**
         * <p>The parameters that are configured for authentication.</p>
         */
        @NameInMap("authParameters")
        public ListConnectionsResponseBodyConnectionsAuthParameters authParameters;

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
        public ListConnectionsResponseBodyConnectionsNetworkParameters networkParameters;

        public static ListConnectionsResponseBodyConnections build(java.util.Map<String, ?> map) throws Exception {
            ListConnectionsResponseBodyConnections self = new ListConnectionsResponseBodyConnections();
            return TeaModel.build(map, self);
        }

        public ListConnectionsResponseBodyConnections setAuthParameters(ListConnectionsResponseBodyConnectionsAuthParameters authParameters) {
            this.authParameters = authParameters;
            return this;
        }
        public ListConnectionsResponseBodyConnectionsAuthParameters getAuthParameters() {
            return this.authParameters;
        }

        public ListConnectionsResponseBodyConnections setConnectionName(String connectionName) {
            this.connectionName = connectionName;
            return this;
        }
        public String getConnectionName() {
            return this.connectionName;
        }

        public ListConnectionsResponseBodyConnections setDescription(String description) {
            this.description = description;
            return this;
        }
        public String getDescription() {
            return this.description;
        }

        public ListConnectionsResponseBodyConnections setGmtCreate(Long gmtCreate) {
            this.gmtCreate = gmtCreate;
            return this;
        }
        public Long getGmtCreate() {
            return this.gmtCreate;
        }

        public ListConnectionsResponseBodyConnections setId(Integer id) {
            this.id = id;
            return this;
        }
        public Integer getId() {
            return this.id;
        }

        public ListConnectionsResponseBodyConnections setNetworkParameters(ListConnectionsResponseBodyConnectionsNetworkParameters networkParameters) {
            this.networkParameters = networkParameters;
            return this;
        }
        public ListConnectionsResponseBodyConnectionsNetworkParameters getNetworkParameters() {
            return this.networkParameters;
        }

    }

}
