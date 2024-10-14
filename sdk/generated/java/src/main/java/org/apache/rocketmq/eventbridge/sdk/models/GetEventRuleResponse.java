// This file is auto-generated, don't edit it. Thanks.
package org.apache.rocketmq.eventbridge.sdk.models;

import com.aliyun.tea.*;

public class GetEventRuleResponse extends TeaModel {
    @NameInMap("headers")
    public java.util.Map<String, String> headers;

    @NameInMap("statusCode")
    public Integer statusCode;

    @NameInMap("body")
    public GetEventRuleResponseBody body;

    public static GetEventRuleResponse build(java.util.Map<String, ?> map) throws Exception {
        GetEventRuleResponse self = new GetEventRuleResponse();
        return TeaModel.build(map, self);
    }

    public GetEventRuleResponse setHeaders(java.util.Map<String, String> headers) {
        this.headers = headers;
        return this;
    }
    public java.util.Map<String, String> getHeaders() {
        return this.headers;
    }

    public GetEventRuleResponse setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
        return this;
    }
    public Integer getStatusCode() {
        return this.statusCode;
    }

    public GetEventRuleResponse setBody(GetEventRuleResponseBody body) {
        this.body = body;
        return this;
    }
    public GetEventRuleResponseBody getBody() {
        return this.body;
    }

}
