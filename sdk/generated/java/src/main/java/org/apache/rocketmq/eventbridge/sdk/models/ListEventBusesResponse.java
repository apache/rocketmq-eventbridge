// This file is auto-generated, don't edit it. Thanks.
package org.apache.rocketmq.eventbridge.sdk.models;

import com.aliyun.tea.*;

public class ListEventBusesResponse extends TeaModel {
    @NameInMap("headers")
    public java.util.Map<String, String> headers;

    @NameInMap("statusCode")
    public Integer statusCode;

    @NameInMap("body")
    public ListEventBusesResponseBody body;

    public static ListEventBusesResponse build(java.util.Map<String, ?> map) throws Exception {
        ListEventBusesResponse self = new ListEventBusesResponse();
        return TeaModel.build(map, self);
    }

    public ListEventBusesResponse setHeaders(java.util.Map<String, String> headers) {
        this.headers = headers;
        return this;
    }
    public java.util.Map<String, String> getHeaders() {
        return this.headers;
    }

    public ListEventBusesResponse setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
        return this;
    }
    public Integer getStatusCode() {
        return this.statusCode;
    }

    public ListEventBusesResponse setBody(ListEventBusesResponseBody body) {
        this.body = body;
        return this;
    }
    public ListEventBusesResponseBody getBody() {
        return this.body;
    }

}
