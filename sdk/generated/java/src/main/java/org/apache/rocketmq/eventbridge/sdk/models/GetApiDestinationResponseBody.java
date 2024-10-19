// This file is auto-generated, don't edit it. Thanks.
package org.apache.rocketmq.eventbridge.sdk.models;

import com.aliyun.tea.*;

public class GetApiDestinationResponseBody extends TeaModel {
    /**
     * <p>The returned response code. The value Success indicates that the request is successful.</p>
     * 
     * <strong>example:</strong>
     * <p>Success</p>
     */
    @NameInMap("code")
    public String code;

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
    public GetApiDestinationResponseBodyHttpApiParameters httpApiParameters;

    /**
     * <p>TODO</p>
     */
    @NameInMap("invocationRateLimitPerSecond")
    public Integer invocationRateLimitPerSecond;

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
     * <p>B896B484-F16D-59DE-9E23-DD0E5C361108</p>
     */
    @NameInMap("requestId")
    public String requestId;

    public static GetApiDestinationResponseBody build(java.util.Map<String, ?> map) throws Exception {
        GetApiDestinationResponseBody self = new GetApiDestinationResponseBody();
        return TeaModel.build(map, self);
    }

    public GetApiDestinationResponseBody setCode(String code) {
        this.code = code;
        return this;
    }
    public String getCode() {
        return this.code;
    }

    public GetApiDestinationResponseBody setApiDestinationName(String apiDestinationName) {
        this.apiDestinationName = apiDestinationName;
        return this;
    }
    public String getApiDestinationName() {
        return this.apiDestinationName;
    }

    public GetApiDestinationResponseBody setConnectionName(String connectionName) {
        this.connectionName = connectionName;
        return this;
    }
    public String getConnectionName() {
        return this.connectionName;
    }

    public GetApiDestinationResponseBody setDescription(String description) {
        this.description = description;
        return this;
    }
    public String getDescription() {
        return this.description;
    }

    public GetApiDestinationResponseBody setGmtCreate(Long gmtCreate) {
        this.gmtCreate = gmtCreate;
        return this;
    }
    public Long getGmtCreate() {
        return this.gmtCreate;
    }

    public GetApiDestinationResponseBody setHttpApiParameters(GetApiDestinationResponseBodyHttpApiParameters httpApiParameters) {
        this.httpApiParameters = httpApiParameters;
        return this;
    }
    public GetApiDestinationResponseBodyHttpApiParameters getHttpApiParameters() {
        return this.httpApiParameters;
    }

    public GetApiDestinationResponseBody setInvocationRateLimitPerSecond(Integer invocationRateLimitPerSecond) {
        this.invocationRateLimitPerSecond = invocationRateLimitPerSecond;
        return this;
    }
    public Integer getInvocationRateLimitPerSecond() {
        return this.invocationRateLimitPerSecond;
    }

    public GetApiDestinationResponseBody setMessage(String message) {
        this.message = message;
        return this;
    }
    public String getMessage() {
        return this.message;
    }

    public GetApiDestinationResponseBody setRequestId(String requestId) {
        this.requestId = requestId;
        return this;
    }
    public String getRequestId() {
        return this.requestId;
    }

    public static class GetApiDestinationResponseBodyHttpApiParametersApiParameters extends TeaModel {
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

        public static GetApiDestinationResponseBodyHttpApiParametersApiParameters build(java.util.Map<String, ?> map) throws Exception {
            GetApiDestinationResponseBodyHttpApiParametersApiParameters self = new GetApiDestinationResponseBodyHttpApiParametersApiParameters();
            return TeaModel.build(map, self);
        }

        public GetApiDestinationResponseBodyHttpApiParametersApiParameters setName(String name) {
            this.name = name;
            return this;
        }
        public String getName() {
            return this.name;
        }

        public GetApiDestinationResponseBodyHttpApiParametersApiParameters setDescription(String description) {
            this.description = description;
            return this;
        }
        public String getDescription() {
            return this.description;
        }

        public GetApiDestinationResponseBodyHttpApiParametersApiParameters setType(String type) {
            this.type = type;
            return this;
        }
        public String getType() {
            return this.type;
        }

        public GetApiDestinationResponseBodyHttpApiParametersApiParameters setDefaultValue(String defaultValue) {
            this.defaultValue = defaultValue;
            return this;
        }
        public String getDefaultValue() {
            return this.defaultValue;
        }

        public GetApiDestinationResponseBodyHttpApiParametersApiParameters setIn(String in) {
            this.in = in;
            return this;
        }
        public String getIn() {
            return this.in;
        }

    }

    public static class GetApiDestinationResponseBodyHttpApiParameters extends TeaModel {
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
         * <pre><code>  - POST
         * 
         *   - GET
         * 
         *   - DELETE
         * 
         *   - PUT
         * 
         *   - HEAD
         * 
         *   - TRACE
         * 
         *   - PATCH
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
        public java.util.List<GetApiDestinationResponseBodyHttpApiParametersApiParameters> apiParameters;

        public static GetApiDestinationResponseBodyHttpApiParameters build(java.util.Map<String, ?> map) throws Exception {
            GetApiDestinationResponseBodyHttpApiParameters self = new GetApiDestinationResponseBodyHttpApiParameters();
            return TeaModel.build(map, self);
        }

        public GetApiDestinationResponseBodyHttpApiParameters setEndpoint(String endpoint) {
            this.endpoint = endpoint;
            return this;
        }
        public String getEndpoint() {
            return this.endpoint;
        }

        public GetApiDestinationResponseBodyHttpApiParameters setMethod(String method) {
            this.method = method;
            return this;
        }
        public String getMethod() {
            return this.method;
        }

        public GetApiDestinationResponseBodyHttpApiParameters setApiParameters(java.util.List<GetApiDestinationResponseBodyHttpApiParametersApiParameters> apiParameters) {
            this.apiParameters = apiParameters;
            return this;
        }
        public java.util.List<GetApiDestinationResponseBodyHttpApiParametersApiParameters> getApiParameters() {
            return this.apiParameters;
        }

    }

}
