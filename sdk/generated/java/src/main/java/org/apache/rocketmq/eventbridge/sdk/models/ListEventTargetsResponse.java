// This file is auto-generated, don't edit it. Thanks.
package org.apache.rocketmq.eventbridge.sdk.models;

import com.aliyun.tea.*;

public class ListEventTargetsResponse extends TeaModel {
    @NameInMap("headers")
    public java.util.Map<String, String> headers;

    @NameInMap("statusCode")
    public Integer statusCode;

    @NameInMap("body")
    public ListEventTargetsResponseBody body;

    public static ListEventTargetsResponse build(java.util.Map<String, ?> map) throws Exception {
        ListEventTargetsResponse self = new ListEventTargetsResponse();
        return TeaModel.build(map, self);
    }

    public ListEventTargetsResponse setHeaders(java.util.Map<String, String> headers) {
        this.headers = headers;
        return this;
    }
    public java.util.Map<String, String> getHeaders() {
        return this.headers;
    }

    public ListEventTargetsResponse setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
        return this;
    }
    public Integer getStatusCode() {
        return this.statusCode;
    }

    public ListEventTargetsResponse setBody(ListEventTargetsResponseBody body) {
        this.body = body;
        return this;
    }
    public ListEventTargetsResponseBody getBody() {
        return this.body;
    }

}
