// This file is auto-generated, don't edit it. Thanks.
package org.apache.rocketmq.eventbridge.sdk.models;

import com.aliyun.tea.*;

public class UpdateApiDestinationResponse extends TeaModel {
    @NameInMap("headers")
    public java.util.Map<String, String> headers;

    @NameInMap("statusCode")
    public Integer statusCode;

    @NameInMap("body")
    public UpdateApiDestinationResponseBody body;

    public static UpdateApiDestinationResponse build(java.util.Map<String, ?> map) throws Exception {
        UpdateApiDestinationResponse self = new UpdateApiDestinationResponse();
        return TeaModel.build(map, self);
    }

    public UpdateApiDestinationResponse setHeaders(java.util.Map<String, String> headers) {
        this.headers = headers;
        return this;
    }
    public java.util.Map<String, String> getHeaders() {
        return this.headers;
    }

    public UpdateApiDestinationResponse setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
        return this;
    }
    public Integer getStatusCode() {
        return this.statusCode;
    }

    public UpdateApiDestinationResponse setBody(UpdateApiDestinationResponseBody body) {
        this.body = body;
        return this;
    }
    public UpdateApiDestinationResponseBody getBody() {
        return this.body;
    }

}
