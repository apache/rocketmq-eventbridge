// This file is auto-generated, don't edit it. Thanks.
package org.apache.rocketmq.eventbridge.sdk.models;

import com.aliyun.tea.*;

public class DeleteEventTargetsResponse extends TeaModel {
    @NameInMap("headers")
    public java.util.Map<String, String> headers;

    @NameInMap("statusCode")
    public Integer statusCode;

    @NameInMap("body")
    public DeleteEventTargetsResponseBody body;

    public static DeleteEventTargetsResponse build(java.util.Map<String, ?> map) throws Exception {
        DeleteEventTargetsResponse self = new DeleteEventTargetsResponse();
        return TeaModel.build(map, self);
    }

    public DeleteEventTargetsResponse setHeaders(java.util.Map<String, String> headers) {
        this.headers = headers;
        return this;
    }
    public java.util.Map<String, String> getHeaders() {
        return this.headers;
    }

    public DeleteEventTargetsResponse setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
        return this;
    }
    public Integer getStatusCode() {
        return this.statusCode;
    }

    public DeleteEventTargetsResponse setBody(DeleteEventTargetsResponseBody body) {
        this.body = body;
        return this;
    }
    public DeleteEventTargetsResponseBody getBody() {
        return this.body;
    }

}
