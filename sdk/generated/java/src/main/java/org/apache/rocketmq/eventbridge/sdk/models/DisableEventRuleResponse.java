// This file is auto-generated, don't edit it. Thanks.
package org.apache.rocketmq.eventbridge.sdk.models;

import com.aliyun.tea.*;

public class DisableEventRuleResponse extends TeaModel {
    @NameInMap("headers")
    public java.util.Map<String, String> headers;

    @NameInMap("statusCode")
    public Integer statusCode;

    @NameInMap("body")
    public DisableEventRuleResponseBody body;

    public static DisableEventRuleResponse build(java.util.Map<String, ?> map) throws Exception {
        DisableEventRuleResponse self = new DisableEventRuleResponse();
        return TeaModel.build(map, self);
    }

    public DisableEventRuleResponse setHeaders(java.util.Map<String, String> headers) {
        this.headers = headers;
        return this;
    }
    public java.util.Map<String, String> getHeaders() {
        return this.headers;
    }

    public DisableEventRuleResponse setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
        return this;
    }
    public Integer getStatusCode() {
        return this.statusCode;
    }

    public DisableEventRuleResponse setBody(DisableEventRuleResponseBody body) {
        this.body = body;
        return this;
    }
    public DisableEventRuleResponseBody getBody() {
        return this.body;
    }

}
