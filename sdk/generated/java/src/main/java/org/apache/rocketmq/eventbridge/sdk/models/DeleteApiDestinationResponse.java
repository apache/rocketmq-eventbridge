// This file is auto-generated, don't edit it. Thanks.
package org.apache.rocketmq.eventbridge.sdk.models;

import com.aliyun.tea.*;

public class DeleteApiDestinationResponse extends TeaModel {
    @NameInMap("headers")
    public java.util.Map<String, String> headers;

    @NameInMap("statusCode")
    public Integer statusCode;

    @NameInMap("body")
    public DeleteApiDestinationResponseBody body;

    public static DeleteApiDestinationResponse build(java.util.Map<String, ?> map) throws Exception {
        DeleteApiDestinationResponse self = new DeleteApiDestinationResponse();
        return TeaModel.build(map, self);
    }

    public DeleteApiDestinationResponse setHeaders(java.util.Map<String, String> headers) {
        this.headers = headers;
        return this;
    }
    public java.util.Map<String, String> getHeaders() {
        return this.headers;
    }

    public DeleteApiDestinationResponse setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
        return this;
    }
    public Integer getStatusCode() {
        return this.statusCode;
    }

    public DeleteApiDestinationResponse setBody(DeleteApiDestinationResponseBody body) {
        this.body = body;
        return this;
    }
    public DeleteApiDestinationResponseBody getBody() {
        return this.body;
    }

}
