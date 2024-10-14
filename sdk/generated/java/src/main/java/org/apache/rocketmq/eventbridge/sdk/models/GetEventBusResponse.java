// This file is auto-generated, don't edit it. Thanks.
package org.apache.rocketmq.eventbridge.sdk.models;

import com.aliyun.tea.*;

public class GetEventBusResponse extends TeaModel {
    @NameInMap("headers")
    public java.util.Map<String, String> headers;

    @NameInMap("statusCode")
    public Integer statusCode;

    @NameInMap("body")
    public GetEventBusResponseBody body;

    public static GetEventBusResponse build(java.util.Map<String, ?> map) throws Exception {
        GetEventBusResponse self = new GetEventBusResponse();
        return TeaModel.build(map, self);
    }

    public GetEventBusResponse setHeaders(java.util.Map<String, String> headers) {
        this.headers = headers;
        return this;
    }
    public java.util.Map<String, String> getHeaders() {
        return this.headers;
    }

    public GetEventBusResponse setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
        return this;
    }
    public Integer getStatusCode() {
        return this.statusCode;
    }

    public GetEventBusResponse setBody(GetEventBusResponseBody body) {
        this.body = body;
        return this;
    }
    public GetEventBusResponseBody getBody() {
        return this.body;
    }

}
