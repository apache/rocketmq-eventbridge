// This file is auto-generated, don't edit it. Thanks.
package org.apache.rocketmq.eventbridge.sdk.models;

import com.aliyun.tea.*;

public class CreateEventSourceResponse extends TeaModel {
    @NameInMap("headers")
    public java.util.Map<String, String> headers;

    @NameInMap("statusCode")
    public Integer statusCode;

    @NameInMap("body")
    public CreateEventSourceResponseBody body;

    public static CreateEventSourceResponse build(java.util.Map<String, ?> map) throws Exception {
        CreateEventSourceResponse self = new CreateEventSourceResponse();
        return TeaModel.build(map, self);
    }

    public CreateEventSourceResponse setHeaders(java.util.Map<String, String> headers) {
        this.headers = headers;
        return this;
    }
    public java.util.Map<String, String> getHeaders() {
        return this.headers;
    }

    public CreateEventSourceResponse setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
        return this;
    }
    public Integer getStatusCode() {
        return this.statusCode;
    }

    public CreateEventSourceResponse setBody(CreateEventSourceResponseBody body) {
        this.body = body;
        return this;
    }
    public CreateEventSourceResponseBody getBody() {
        return this.body;
    }

}
