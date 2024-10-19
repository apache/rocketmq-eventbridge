// This file is auto-generated, don't edit it. Thanks.
package org.apache.rocketmq.eventbridge.sdk.models;

import com.aliyun.tea.*;

public class ListEventSourcesResponse extends TeaModel {
    @NameInMap("headers")
    public java.util.Map<String, String> headers;

    @NameInMap("statusCode")
    public Integer statusCode;

    @NameInMap("body")
    public ListEventSourcesResponseBody body;

    public static ListEventSourcesResponse build(java.util.Map<String, ?> map) throws Exception {
        ListEventSourcesResponse self = new ListEventSourcesResponse();
        return TeaModel.build(map, self);
    }

    public ListEventSourcesResponse setHeaders(java.util.Map<String, String> headers) {
        this.headers = headers;
        return this;
    }
    public java.util.Map<String, String> getHeaders() {
        return this.headers;
    }

    public ListEventSourcesResponse setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
        return this;
    }
    public Integer getStatusCode() {
        return this.statusCode;
    }

    public ListEventSourcesResponse setBody(ListEventSourcesResponseBody body) {
        this.body = body;
        return this;
    }
    public ListEventSourcesResponseBody getBody() {
        return this.body;
    }

}
