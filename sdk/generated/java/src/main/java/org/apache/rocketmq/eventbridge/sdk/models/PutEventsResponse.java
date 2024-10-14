// This file is auto-generated, don't edit it. Thanks.
package org.apache.rocketmq.eventbridge.sdk.models;

import com.aliyun.tea.*;

public class PutEventsResponse extends TeaModel {
    @NameInMap("headers")
    public java.util.Map<String, String> headers;

    @NameInMap("statusCode")
    public Integer statusCode;

    @NameInMap("body")
    public PutEventsResponseBody body;

    public static PutEventsResponse build(java.util.Map<String, ?> map) throws Exception {
        PutEventsResponse self = new PutEventsResponse();
        return TeaModel.build(map, self);
    }

    public PutEventsResponse setHeaders(java.util.Map<String, String> headers) {
        this.headers = headers;
        return this;
    }
    public java.util.Map<String, String> getHeaders() {
        return this.headers;
    }

    public PutEventsResponse setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
        return this;
    }
    public Integer getStatusCode() {
        return this.statusCode;
    }

    public PutEventsResponse setBody(PutEventsResponseBody body) {
        this.body = body;
        return this;
    }
    public PutEventsResponseBody getBody() {
        return this.body;
    }

}
