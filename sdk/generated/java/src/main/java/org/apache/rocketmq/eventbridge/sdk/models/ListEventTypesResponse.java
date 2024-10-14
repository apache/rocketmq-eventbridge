// This file is auto-generated, don't edit it. Thanks.
package org.apache.rocketmq.eventbridge.sdk.models;

import com.aliyun.tea.*;

public class ListEventTypesResponse extends TeaModel {
    @NameInMap("headers")
    public java.util.Map<String, String> headers;

    @NameInMap("statusCode")
    public Integer statusCode;

    @NameInMap("body")
    public ListEventTypesResponseBody body;

    public static ListEventTypesResponse build(java.util.Map<String, ?> map) throws Exception {
        ListEventTypesResponse self = new ListEventTypesResponse();
        return TeaModel.build(map, self);
    }

    public ListEventTypesResponse setHeaders(java.util.Map<String, String> headers) {
        this.headers = headers;
        return this;
    }
    public java.util.Map<String, String> getHeaders() {
        return this.headers;
    }

    public ListEventTypesResponse setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
        return this;
    }
    public Integer getStatusCode() {
        return this.statusCode;
    }

    public ListEventTypesResponse setBody(ListEventTypesResponseBody body) {
        this.body = body;
        return this;
    }
    public ListEventTypesResponseBody getBody() {
        return this.body;
    }

}
