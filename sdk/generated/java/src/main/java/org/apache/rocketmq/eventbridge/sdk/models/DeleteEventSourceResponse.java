// This file is auto-generated, don't edit it. Thanks.
package org.apache.rocketmq.eventbridge.sdk.models;

import com.aliyun.tea.*;

public class DeleteEventSourceResponse extends TeaModel {
    @NameInMap("headers")
    public java.util.Map<String, String> headers;

    @NameInMap("statusCode")
    public Integer statusCode;

    @NameInMap("body")
    public DeleteEventSourceResponseBody body;

    public static DeleteEventSourceResponse build(java.util.Map<String, ?> map) throws Exception {
        DeleteEventSourceResponse self = new DeleteEventSourceResponse();
        return TeaModel.build(map, self);
    }

    public DeleteEventSourceResponse setHeaders(java.util.Map<String, String> headers) {
        this.headers = headers;
        return this;
    }
    public java.util.Map<String, String> getHeaders() {
        return this.headers;
    }

    public DeleteEventSourceResponse setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
        return this;
    }
    public Integer getStatusCode() {
        return this.statusCode;
    }

    public DeleteEventSourceResponse setBody(DeleteEventSourceResponseBody body) {
        this.body = body;
        return this;
    }
    public DeleteEventSourceResponseBody getBody() {
        return this.body;
    }

}
