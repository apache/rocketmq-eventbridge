// This file is auto-generated, don't edit it. Thanks.
package org.apache.rocketmq.eventbridge.sdk.models;

import com.aliyun.tea.*;

public class CreateApiDestinationResponse extends TeaModel {
    @NameInMap("headers")
    public java.util.Map<String, String> headers;

    @NameInMap("statusCode")
    public Integer statusCode;

    @NameInMap("body")
    public CreateApiDestinationResponseBody body;

    public static CreateApiDestinationResponse build(java.util.Map<String, ?> map) throws Exception {
        CreateApiDestinationResponse self = new CreateApiDestinationResponse();
        return TeaModel.build(map, self);
    }

    public CreateApiDestinationResponse setHeaders(java.util.Map<String, String> headers) {
        this.headers = headers;
        return this;
    }
    public java.util.Map<String, String> getHeaders() {
        return this.headers;
    }

    public CreateApiDestinationResponse setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
        return this;
    }
    public Integer getStatusCode() {
        return this.statusCode;
    }

    public CreateApiDestinationResponse setBody(CreateApiDestinationResponseBody body) {
        this.body = body;
        return this;
    }
    public CreateApiDestinationResponseBody getBody() {
        return this.body;
    }

}
