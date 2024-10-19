// This file is auto-generated, don't edit it. Thanks.
package org.apache.rocketmq.eventbridge.sdk.models;

import com.aliyun.tea.*;

public class ListEventRulesResponse extends TeaModel {
    @NameInMap("headers")
    public java.util.Map<String, String> headers;

    @NameInMap("statusCode")
    public Integer statusCode;

    @NameInMap("body")
    public ListEventRulesResponseBody body;

    public static ListEventRulesResponse build(java.util.Map<String, ?> map) throws Exception {
        ListEventRulesResponse self = new ListEventRulesResponse();
        return TeaModel.build(map, self);
    }

    public ListEventRulesResponse setHeaders(java.util.Map<String, String> headers) {
        this.headers = headers;
        return this;
    }
    public java.util.Map<String, String> getHeaders() {
        return this.headers;
    }

    public ListEventRulesResponse setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
        return this;
    }
    public Integer getStatusCode() {
        return this.statusCode;
    }

    public ListEventRulesResponse setBody(ListEventRulesResponseBody body) {
        this.body = body;
        return this;
    }
    public ListEventRulesResponseBody getBody() {
        return this.body;
    }

}
