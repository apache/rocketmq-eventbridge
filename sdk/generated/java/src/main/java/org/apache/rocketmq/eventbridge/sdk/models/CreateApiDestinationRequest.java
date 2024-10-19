// This file is auto-generated, don't edit it. Thanks.
package org.apache.rocketmq.eventbridge.sdk.models;

import com.aliyun.tea.*;

/**
 * <b>description</b> :
 * <p>ApiDestination Controller apis:
 * createApiDestination *
 * updateApiDestination *
 * getApiDestination    *
 * deleteApiDestination *
 * listApiDestinations  *</p>
 */
public class CreateApiDestinationRequest extends TeaModel {
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
    public CreateApiDestinationRequestHttpApiParameters httpApiParameters;

    /**
     * <p>TODO</p>
     */
    @NameInMap("invocationRateLimitPerSecond")
    public Integer invocationRateLimitPerSecond;

    public static CreateApiDestinationRequest build(java.util.Map<String, ?> map) throws Exception {
        CreateApiDestinationRequest self = new CreateApiDestinationRequest();
        return TeaModel.build(map, self);
    }

    public CreateApiDestinationRequest setApiDestinationName(String apiDestinationName) {
        this.apiDestinationName = apiDestinationName;
        return this;
    }
    public String getApiDestinationName() {
        return this.apiDestinationName;
    }

    public CreateApiDestinationRequest setConnectionName(String connectionName) {
        this.connectionName = connectionName;
        return this;
    }
    public String getConnectionName() {
        return this.connectionName;
    }

    public CreateApiDestinationRequest setDescription(String description) {
        this.description = description;
        return this;
    }
    public String getDescription() {
        return this.description;
    }

    public CreateApiDestinationRequest setHttpApiParameters(CreateApiDestinationRequestHttpApiParameters httpApiParameters) {
        this.httpApiParameters = httpApiParameters;
        return this;
    }
    public CreateApiDestinationRequestHttpApiParameters getHttpApiParameters() {
        return this.httpApiParameters;
    }

    public CreateApiDestinationRequest setInvocationRateLimitPerSecond(Integer invocationRateLimitPerSecond) {
        this.invocationRateLimitPerSecond = invocationRateLimitPerSecond;
        return this;
    }
    public Integer getInvocationRateLimitPerSecond() {
        return this.invocationRateLimitPerSecond;
    }

    public static class CreateApiDestinationRequestHttpApiParametersApiParameters extends TeaModel {
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

        public static CreateApiDestinationRequestHttpApiParametersApiParameters build(java.util.Map<String, ?> map) throws Exception {
            CreateApiDestinationRequestHttpApiParametersApiParameters self = new CreateApiDestinationRequestHttpApiParametersApiParameters();
            return TeaModel.build(map, self);
        }

        public CreateApiDestinationRequestHttpApiParametersApiParameters setName(String name) {
            this.name = name;
            return this;
        }
        public String getName() {
            return this.name;
        }

        public CreateApiDestinationRequestHttpApiParametersApiParameters setDescription(String description) {
            this.description = description;
            return this;
        }
        public String getDescription() {
            return this.description;
        }

        public CreateApiDestinationRequestHttpApiParametersApiParameters setType(String type) {
            this.type = type;
            return this;
        }
        public String getType() {
            return this.type;
        }

        public CreateApiDestinationRequestHttpApiParametersApiParameters setDefaultValue(String defaultValue) {
            this.defaultValue = defaultValue;
            return this;
        }
        public String getDefaultValue() {
            return this.defaultValue;
        }

        public CreateApiDestinationRequestHttpApiParametersApiParameters setIn(String in) {
            this.in = in;
            return this;
        }
        public String getIn() {
            return this.in;
        }

    }

    public static class CreateApiDestinationRequestHttpApiParameters extends TeaModel {
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
        public java.util.List<CreateApiDestinationRequestHttpApiParametersApiParameters> apiParameters;

        public static CreateApiDestinationRequestHttpApiParameters build(java.util.Map<String, ?> map) throws Exception {
            CreateApiDestinationRequestHttpApiParameters self = new CreateApiDestinationRequestHttpApiParameters();
            return TeaModel.build(map, self);
        }

        public CreateApiDestinationRequestHttpApiParameters setEndpoint(String endpoint) {
            this.endpoint = endpoint;
            return this;
        }
        public String getEndpoint() {
            return this.endpoint;
        }

        public CreateApiDestinationRequestHttpApiParameters setMethod(String method) {
            this.method = method;
            return this;
        }
        public String getMethod() {
            return this.method;
        }

        public CreateApiDestinationRequestHttpApiParameters setApiParameters(java.util.List<CreateApiDestinationRequestHttpApiParametersApiParameters> apiParameters) {
            this.apiParameters = apiParameters;
            return this;
        }
        public java.util.List<CreateApiDestinationRequestHttpApiParametersApiParameters> getApiParameters() {
            return this.apiParameters;
        }

    }

}
