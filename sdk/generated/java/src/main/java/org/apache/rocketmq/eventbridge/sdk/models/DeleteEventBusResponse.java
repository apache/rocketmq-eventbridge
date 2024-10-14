// This file is auto-generated, don't edit it. Thanks.
package org.apache.rocketmq.eventbridge.sdk.models;

import com.aliyun.tea.*;

public class DeleteEventBusResponse extends TeaModel {
    @NameInMap("headers")
    public java.util.Map<String, String> headers;

    @NameInMap("statusCode")
    public Integer statusCode;

    @NameInMap("body")
    public DeleteEventBusResponseBody body;

    public static DeleteEventBusResponse build(java.util.Map<String, ?> map) throws Exception {
        DeleteEventBusResponse self = new DeleteEventBusResponse();
        return TeaModel.build(map, self);
    }

    public DeleteEventBusResponse setHeaders(java.util.Map<String, String> headers) {
        this.headers = headers;
        return this;
    }
    public java.util.Map<String, String> getHeaders() {
        return this.headers;
    }

    public DeleteEventBusResponse setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
        return this;
    }
    public Integer getStatusCode() {
        return this.statusCode;
    }

    public DeleteEventBusResponse setBody(DeleteEventBusResponseBody body) {
        this.body = body;
        return this;
    }
    public DeleteEventBusResponseBody getBody() {
        return this.body;
    }

}
