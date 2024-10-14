// This file is auto-generated, don't edit it. Thanks.
package org.apache.rocketmq.eventbridge.sdk.models;

import com.aliyun.tea.*;

public class ListApiDestinationsResponseBody extends TeaModel {
    /**
     * <p>The returned response code. The value Success indicates that the request is successful.</p>
     * 
     * <strong>example:</strong>
     * <p>Success</p>
     */
    @NameInMap("code")
    public String code;

    /**
     * <p>The API destinations.</p>
     */
    @NameInMap("apiDestinations")
    public java.util.List<ListApiDestinationsResponseBodyApiDestinations> apiDestinations;

    /**
     * <p>The maximum number of entries returned per page.</p>
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
     * <p>1</p>
     */
    @NameInMap("nextToken")
    public String nextToken;

    /**
     * <p>The total number of entries returned.</p>
     * 
     * <strong>example:</strong>
     * <p>2</p>
     */
    @NameInMap("total")
    public Integer total;

    /**
     * <p>The returned message. If the request is successful, success is returned. If the request failed, an error code is returned.</p>
     * 
     * <strong>example:</strong>
     * <p>success</p>
     */
    @NameInMap("message")
    public String message;

    /**
     * <p>The request ID.</p>
     * 
     * <strong>example:</strong>
     * <p>96D7C0AB-DCE5-5E82-96B8-4725E1706BB1</p>
     */
    @NameInMap("requestId")
    public String requestId;

    public static ListApiDestinationsResponseBody build(java.util.Map<String, ?> map) throws Exception {
        ListApiDestinationsResponseBody self = new ListApiDestinationsResponseBody();
        return TeaModel.build(map, self);
    }

    public ListApiDestinationsResponseBody setCode(String code) {
        this.code = code;
        return this;
    }
    public String getCode() {
        return this.code;
    }

    public ListApiDestinationsResponseBody setApiDestinations(java.util.List<ListApiDestinationsResponseBodyApiDestinations> apiDestinations) {
        this.apiDestinations = apiDestinations;
        return this;
    }
    public java.util.List<ListApiDestinationsResponseBodyApiDestinations> getApiDestinations() {
        return this.apiDestinations;
    }

    public ListApiDestinationsResponseBody setMaxResults(Integer maxResults) {
        this.maxResults = maxResults;
        return this;
    }
    public Integer getMaxResults() {
        return this.maxResults;
    }

    public ListApiDestinationsResponseBody setNextToken(String nextToken) {
        this.nextToken = nextToken;
        return this;
    }
    public String getNextToken() {
        return this.nextToken;
    }

    public ListApiDestinationsResponseBody setTotal(Integer total) {
        this.total = total;
        return this;
    }
    public Integer getTotal() {
        return this.total;
    }

    public ListApiDestinationsResponseBody setMessage(String message) {
        this.message = message;
        return this;
    }
    public String getMessage() {
        return this.message;
    }

    public ListApiDestinationsResponseBody setRequestId(String requestId) {
        this.requestId = requestId;
        return this;
    }
    public String getRequestId() {
        return this.requestId;
    }

    public static class ListApiDestinationsResponseBodyApiDestinationsHttpApiParametersApiParameters extends TeaModel {
        @NameInMap("name")
        public String name;

        /**
         * <p>The description of the API destination. The description can be up to 255 characters in length.</p>
         */
        @NameInMap("description")
        public String description;

        @NameInMap("type")
        public String type;

        @NameInMap("defaultValue")
        public String defaultValue;

        @NameInMap("in")
        public String in;

        public static ListApiDestinationsResponseBodyApiDestinationsHttpApiParametersApiParameters build(java.util.Map<String, ?> map) throws Exception {
            ListApiDestinationsResponseBodyApiDestinationsHttpApiParametersApiParameters self = new ListApiDestinationsResponseBodyApiDestinationsHttpApiParametersApiParameters();
            return TeaModel.build(map, self);
        }

        public ListApiDestinationsResponseBodyApiDestinationsHttpApiParametersApiParameters setName(String name) {
            this.name = name;
            return this;
        }
        public String getName() {
            return this.name;
        }

        public ListApiDestinationsResponseBodyApiDestinationsHttpApiParametersApiParameters setDescription(String description) {
            this.description = description;
            return this;
        }
        public String getDescription() {
            return this.description;
        }

        public ListApiDestinationsResponseBodyApiDestinationsHttpApiParametersApiParameters setType(String type) {
            this.type = type;
            return this;
        }
        public String getType() {
            return this.type;
        }

        public ListApiDestinationsResponseBodyApiDestinationsHttpApiParametersApiParameters setDefaultValue(String defaultValue) {
            this.defaultValue = defaultValue;
            return this;
        }
        public String getDefaultValue() {
            return this.defaultValue;
        }

        public ListApiDestinationsResponseBodyApiDestinationsHttpApiParametersApiParameters setIn(String in) {
            this.in = in;
            return this;
        }
        public String getIn() {
            return this.in;
        }

    }

    public static class ListApiDestinationsResponseBodyApiDestinationsHttpApiParameters extends TeaModel {
        /**
         * <p>The endpoint of the API destination.</p>
         * 
         * <strong>example:</strong>
         * <p><a href="http://127.0.0.1:8001/api">http://127.0.0.1:8001/api</a></p>
         */
        @NameInMap("endpoint")
        public String endpoint;

        /**
         * <p>The HTTP request method. Valid values:</p>
         * <pre><code>      - POST
         * 
         *       - GET
         * 
         *       - DELETE
         * 
         *       - PUT
         * 
         *       - HEAD
         * 
         *       - TRACE
         * 
         *       - PATCH
         * </code></pre>
         * 
         * <strong>example:</strong>
         * <p>POST</p>
         */
        @NameInMap("method")
        public String method;

        /**
         * <p>TODO</p>
         */
        @NameInMap("apiParameters")
        public java.util.List<ListApiDestinationsResponseBodyApiDestinationsHttpApiParametersApiParameters> apiParameters;

        public static ListApiDestinationsResponseBodyApiDestinationsHttpApiParameters build(java.util.Map<String, ?> map) throws Exception {
            ListApiDestinationsResponseBodyApiDestinationsHttpApiParameters self = new ListApiDestinationsResponseBodyApiDestinationsHttpApiParameters();
            return TeaModel.build(map, self);
        }

        public ListApiDestinationsResponseBodyApiDestinationsHttpApiParameters setEndpoint(String endpoint) {
            this.endpoint = endpoint;
            return this;
        }
        public String getEndpoint() {
            return this.endpoint;
        }

        public ListApiDestinationsResponseBodyApiDestinationsHttpApiParameters setMethod(String method) {
            this.method = method;
            return this;
        }
        public String getMethod() {
            return this.method;
        }

        public ListApiDestinationsResponseBodyApiDestinationsHttpApiParameters setApiParameters(java.util.List<ListApiDestinationsResponseBodyApiDestinationsHttpApiParametersApiParameters> apiParameters) {
            this.apiParameters = apiParameters;
            return this;
        }
        public java.util.List<ListApiDestinationsResponseBodyApiDestinationsHttpApiParametersApiParameters> getApiParameters() {
            return this.apiParameters;
        }

    }

    public static class ListApiDestinationsResponseBodyApiDestinations extends TeaModel {
        /**
         * <p>The name of the API destination.</p>
         * 
         * <strong>example:</strong>
         * <p>api-destination-2</p>
         */
        @NameInMap("apiDestinationName")
        public String apiDestinationName;

        /**
         * <p>The connection name.</p>
         * 
         * <strong>example:</strong>
         * <p>connection-name</p>
         */
        @NameInMap("connectionName")
        public String connectionName;

        /**
         * <p>The description of the connection.</p>
         * 
         * <strong>example:</strong>
         * <p>demo</p>
         */
        @NameInMap("description")
        public String description;

        /**
         * <p>The time when the API destination was created.</p>
         * 
         * <strong>example:</strong>
         * <p>1665223213000</p>
         */
        @NameInMap("gmtCreate")
        public Long gmtCreate;

        /**
         * <p>The request parameters that are configured for the API destination.</p>
         */
        @NameInMap("httpApiParameters")
        public ListApiDestinationsResponseBodyApiDestinationsHttpApiParameters httpApiParameters;

        /**
         * <p>TODO</p>
         */
        @NameInMap("invocationRateLimitPerSecond")
        public Integer invocationRateLimitPerSecond;

        public static ListApiDestinationsResponseBodyApiDestinations build(java.util.Map<String, ?> map) throws Exception {
            ListApiDestinationsResponseBodyApiDestinations self = new ListApiDestinationsResponseBodyApiDestinations();
            return TeaModel.build(map, self);
        }

        public ListApiDestinationsResponseBodyApiDestinations setApiDestinationName(String apiDestinationName) {
            this.apiDestinationName = apiDestinationName;
            return this;
        }
        public String getApiDestinationName() {
            return this.apiDestinationName;
        }

        public ListApiDestinationsResponseBodyApiDestinations setConnectionName(String connectionName) {
            this.connectionName = connectionName;
            return this;
        }
        public String getConnectionName() {
            return this.connectionName;
        }

        public ListApiDestinationsResponseBodyApiDestinations setDescription(String description) {
            this.description = description;
            return this;
        }
        public String getDescription() {
            return this.description;
        }

        public ListApiDestinationsResponseBodyApiDestinations setGmtCreate(Long gmtCreate) {
            this.gmtCreate = gmtCreate;
            return this;
        }
        public Long getGmtCreate() {
            return this.gmtCreate;
        }

        public ListApiDestinationsResponseBodyApiDestinations setHttpApiParameters(ListApiDestinationsResponseBodyApiDestinationsHttpApiParameters httpApiParameters) {
            this.httpApiParameters = httpApiParameters;
            return this;
        }
        public ListApiDestinationsResponseBodyApiDestinationsHttpApiParameters getHttpApiParameters() {
            return this.httpApiParameters;
        }

        public ListApiDestinationsResponseBodyApiDestinations setInvocationRateLimitPerSecond(Integer invocationRateLimitPerSecond) {
            this.invocationRateLimitPerSecond = invocationRateLimitPerSecond;
            return this;
        }
        public Integer getInvocationRateLimitPerSecond() {
            return this.invocationRateLimitPerSecond;
        }

    }

}
