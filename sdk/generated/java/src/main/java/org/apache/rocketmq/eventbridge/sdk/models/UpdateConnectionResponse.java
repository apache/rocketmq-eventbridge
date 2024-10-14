// This file is auto-generated, don't edit it. Thanks.
package org.apache.rocketmq.eventbridge.sdk.models;

import com.aliyun.tea.*;

public class UpdateConnectionResponse extends TeaModel {
    @NameInMap("headers")
    public java.util.Map<String, String> headers;

    @NameInMap("statusCode")
    public Integer statusCode;

    @NameInMap("body")
    public UpdateConnectionResponseBody body;

    public static UpdateConnectionResponse build(java.util.Map<String, ?> map) throws Exception {
        UpdateConnectionResponse self = new UpdateConnectionResponse();
        return TeaModel.build(map, self);
    }

    public UpdateConnectionResponse setHeaders(java.util.Map<String, String> headers) {
        this.headers = headers;
        return this;
    }
    public java.util.Map<String, String> getHeaders() {
        return this.headers;
    }

    public UpdateConnectionResponse setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
        return this;
    }
    public Integer getStatusCode() {
        return this.statusCode;
    }

    public UpdateConnectionResponse setBody(UpdateConnectionResponseBody body) {
        this.body = body;
        return this;
    }
    public UpdateConnectionResponseBody getBody() {
        return this.body;
    }

}
