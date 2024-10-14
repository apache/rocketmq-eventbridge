// This file is auto-generated, don't edit it. Thanks.
package org.apache.rocketmq.eventbridge.sdk.models;

import com.aliyun.tea.*;

public class CreateEventTargetsResponse extends TeaModel {
    @NameInMap("headers")
    public java.util.Map<String, String> headers;

    @NameInMap("statusCode")
    public Integer statusCode;

    @NameInMap("body")
    public CreateEventTargetsResponseBody body;

    public static CreateEventTargetsResponse build(java.util.Map<String, ?> map) throws Exception {
        CreateEventTargetsResponse self = new CreateEventTargetsResponse();
        return TeaModel.build(map, self);
    }

    public CreateEventTargetsResponse setHeaders(java.util.Map<String, String> headers) {
        this.headers = headers;
        return this;
    }
    public java.util.Map<String, String> getHeaders() {
        return this.headers;
    }

    public CreateEventTargetsResponse setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
        return this;
    }
    public Integer getStatusCode() {
        return this.statusCode;
    }

    public CreateEventTargetsResponse setBody(CreateEventTargetsResponseBody body) {
        this.body = body;
        return this;
    }
    public CreateEventTargetsResponseBody getBody() {
        return this.body;
    }

}
