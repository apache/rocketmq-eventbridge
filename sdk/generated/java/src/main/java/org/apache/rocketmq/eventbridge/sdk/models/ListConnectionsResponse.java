// This file is auto-generated, don't edit it. Thanks.
package org.apache.rocketmq.eventbridge.sdk.models;

import com.aliyun.tea.*;

public class ListConnectionsResponse extends TeaModel {
    @NameInMap("headers")
    public java.util.Map<String, String> headers;

    @NameInMap("statusCode")
    public Integer statusCode;

    @NameInMap("body")
    public ListConnectionsResponseBody body;

    public static ListConnectionsResponse build(java.util.Map<String, ?> map) throws Exception {
        ListConnectionsResponse self = new ListConnectionsResponse();
        return TeaModel.build(map, self);
    }

    public ListConnectionsResponse setHeaders(java.util.Map<String, String> headers) {
        this.headers = headers;
        return this;
    }
    public java.util.Map<String, String> getHeaders() {
        return this.headers;
    }

    public ListConnectionsResponse setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
        return this;
    }
    public Integer getStatusCode() {
        return this.statusCode;
    }

    public ListConnectionsResponse setBody(ListConnectionsResponseBody body) {
        this.body = body;
        return this;
    }
    public ListConnectionsResponseBody getBody() {
        return this.body;
    }

}
