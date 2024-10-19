// This file is auto-generated, don't edit it. Thanks.
package org.apache.rocketmq.eventbridge.sdk.models;

import com.aliyun.tea.*;

public class UpdateApiDestinationRequest extends TeaModel {
    /**
     * <p>The name of the API destination. The name must be 2 to 127 characters in length. This parameter is required.</p>
     * 
     * <strong>example:</strong>
     * <p>api-destination-name</p>
     */
    @NameInMap("apiDestinationName")
    public String apiDestinationName;

    /**
     * <p>The name of the connection. The name must be 2 to 127 characters in length. Before you configure this parameter, you must call the CreateConnection operation to create a connection. Then, set this parameter to the name of the connection that you created. This parameter is required.</p>
     * 
     * <strong>example:</strong>
     * <p>connection-name</p>
     */
    @NameInMap("connectionName")
    public String connectionName;

    /**
     * <p>The description of the API destination. The description can be up to 255 characters in length.</p>
     */
    @NameInMap("description")
    public String description;

    /**
     * <p>The parameters that are configured for the API destination. This parameter is required.</p>
     */
    @NameInMap("httpApiParameters")
    public UpdateApiDestinationRequestHttpApiParameters httpApiParameters;

    /**
     * <p>TODO</p>
     */
    @NameInMap("invocationRateLimitPerSecond")
    public Integer invocationRateLimitPerSecond;

    public static UpdateApiDestinationRequest build(java.util.Map<String, ?> map) throws Exception {
        UpdateApiDestinationRequest self = new UpdateApiDestinationRequest();
        return TeaModel.build(map, self);
    }

    public UpdateApiDestinationRequest setApiDestinationName(String apiDestinationName) {
        this.apiDestinationName = apiDestinationName;
        return this;
    }
    public String getApiDestinationName() {
        return this.apiDestinationName;
    }

    public UpdateApiDestinationRequest setConnectionName(String connectionName) {
        this.connectionName = connectionName;
        return this;
    }
    public String getConnectionName() {
        return this.connectionName;
    }

    public UpdateApiDestinationRequest setDescription(String description) {
        this.description = description;
        return this;
    }
    public String getDescription() {
        return this.description;
    }

    public UpdateApiDestinationRequest setHttpApiParameters(UpdateApiDestinationRequestHttpApiParameters httpApiParameters) {
        this.httpApiParameters = httpApiParameters;
        return this;
    }
    public UpdateApiDestinationRequestHttpApiParameters getHttpApiParameters() {
        return this.httpApiParameters;
    }

    public UpdateApiDestinationRequest setInvocationRateLimitPerSecond(Integer invocationRateLimitPerSecond) {
        this.invocationRateLimitPerSecond = invocationRateLimitPerSecond;
        return this;
    }
    public Integer getInvocationRateLimitPerSecond() {
        return this.invocationRateLimitPerSecond;
    }

    public static class UpdateApiDestinationRequestHttpApiParametersApiParameters extends TeaModel {
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

        public static UpdateApiDestinationRequestHttpApiParametersApiParameters build(java.util.Map<String, ?> map) throws Exception {
            UpdateApiDestinationRequestHttpApiParametersApiParameters self = new UpdateApiDestinationRequestHttpApiParametersApiParameters();
            return TeaModel.build(map, self);
        }

        public UpdateApiDestinationRequestHttpApiParametersApiParameters setName(String name) {
            this.name = name;
            return this;
        }
        public String getName() {
            return this.name;
        }

        public UpdateApiDestinationRequestHttpApiParametersApiParameters setDescription(String description) {
            this.description = description;
            return this;
        }
        public String getDescription() {
            return this.description;
        }

        public UpdateApiDestinationRequestHttpApiParametersApiParameters setType(String type) {
            this.type = type;
            return this;
        }
        public String getType() {
            return this.type;
        }

        public UpdateApiDestinationRequestHttpApiParametersApiParameters setDefaultValue(String defaultValue) {
            this.defaultValue = defaultValue;
            return this;
        }
        public String getDefaultValue() {
            return this.defaultValue;
        }

        public UpdateApiDestinationRequestHttpApiParametersApiParameters setIn(String in) {
            this.in = in;
            return this;
        }
        public String getIn() {
            return this.in;
        }

    }

    public static class UpdateApiDestinationRequestHttpApiParameters extends TeaModel {
        /**
         * <p>The endpoint of the API destination. The endpoint can be up to 127 characters in length. This parameter is required.</p>
         * 
         * <strong>example:</strong>
         * <p><a href="http://127.0.0.1:8001/api">http://127.0.0.1:8001/api</a></p>
         */
        @NameInMap("endpoint")
        public String endpoint;

        /**
         * <p>The HTTP request method. Valid values: </p>
         * <pre><code>  *   GET 
         * 
         *   *   POST 
         * 
         *   *   HEAD 
         * 
         *   *   DELETE 
         * 
         *   *   PUT 
         * 
         *   *   PATCH 
         * 
         * 
         *   This parameter is required.
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
        public java.util.List<UpdateApiDestinationRequestHttpApiParametersApiParameters> apiParameters;

        public static UpdateApiDestinationRequestHttpApiParameters build(java.util.Map<String, ?> map) throws Exception {
            UpdateApiDestinationRequestHttpApiParameters self = new UpdateApiDestinationRequestHttpApiParameters();
            return TeaModel.build(map, self);
        }

        public UpdateApiDestinationRequestHttpApiParameters setEndpoint(String endpoint) {
            this.endpoint = endpoint;
            return this;
        }
        public String getEndpoint() {
            return this.endpoint;
        }

        public UpdateApiDestinationRequestHttpApiParameters setMethod(String method) {
            this.method = method;
            return this;
        }
        public String getMethod() {
            return this.method;
        }

        public UpdateApiDestinationRequestHttpApiParameters setApiParameters(java.util.List<UpdateApiDestinationRequestHttpApiParametersApiParameters> apiParameters) {
            this.apiParameters = apiParameters;
            return this;
        }
        public java.util.List<UpdateApiDestinationRequestHttpApiParametersApiParameters> getApiParameters() {
            return this.apiParameters;
        }

    }

}
