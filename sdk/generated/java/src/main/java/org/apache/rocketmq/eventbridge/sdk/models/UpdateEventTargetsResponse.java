// This file is auto-generated, don't edit it. Thanks.
package org.apache.rocketmq.eventbridge.sdk.models;

import com.aliyun.tea.*;

public class UpdateEventTargetsResponse extends TeaModel {
    @NameInMap("headers")
    public java.util.Map<String, String> headers;

    @NameInMap("statusCode")
    public Integer statusCode;

    @NameInMap("body")
    public UpdateEventTargetsResponseBody body;

    public static UpdateEventTargetsResponse build(java.util.Map<String, ?> map) throws Exception {
        UpdateEventTargetsResponse self = new UpdateEventTargetsResponse();
        return TeaModel.build(map, self);
    }

    public UpdateEventTargetsResponse setHeaders(java.util.Map<String, String> headers) {
        this.headers = headers;
        return this;
    }
    public java.util.Map<String, String> getHeaders() {
        return this.headers;
    }

    public UpdateEventTargetsResponse setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
        return this;
    }
    public Integer getStatusCode() {
        return this.statusCode;
    }

    public UpdateEventTargetsResponse setBody(UpdateEventTargetsResponseBody body) {
        this.body = body;
        return this;
    }
    public UpdateEventTargetsResponseBody getBody() {
        return this.body;
    }

}
