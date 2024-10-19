// This file is auto-generated, don't edit it. Thanks.
package org.apache.rocketmq.eventbridge.sdk.models;

import com.aliyun.tea.*;

public class GetEventSourceResponse extends TeaModel {
    @NameInMap("headers")
    public java.util.Map<String, String> headers;

    @NameInMap("statusCode")
    public Integer statusCode;

    @NameInMap("body")
    public GetEventSourceResponseBody body;

    public static GetEventSourceResponse build(java.util.Map<String, ?> map) throws Exception {
        GetEventSourceResponse self = new GetEventSourceResponse();
        return TeaModel.build(map, self);
    }

    public GetEventSourceResponse setHeaders(java.util.Map<String, String> headers) {
        this.headers = headers;
        return this;
    }
    public java.util.Map<String, String> getHeaders() {
        return this.headers;
    }

    public GetEventSourceResponse setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
        return this;
    }
    public Integer getStatusCode() {
        return this.statusCode;
    }

    public GetEventSourceResponse setBody(GetEventSourceResponseBody body) {
        this.body = body;
        return this;
    }
    public GetEventSourceResponseBody getBody() {
        return this.body;
    }

}
