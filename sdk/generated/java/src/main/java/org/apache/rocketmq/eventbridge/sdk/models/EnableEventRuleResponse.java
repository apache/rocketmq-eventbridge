// This file is auto-generated, don't edit it. Thanks.
package org.apache.rocketmq.eventbridge.sdk.models;

import com.aliyun.tea.*;

public class EnableEventRuleResponse extends TeaModel {
    @NameInMap("headers")
    public java.util.Map<String, String> headers;

    @NameInMap("statusCode")
    public Integer statusCode;

    @NameInMap("body")
    public EnableEventRuleResponseBody body;

    public static EnableEventRuleResponse build(java.util.Map<String, ?> map) throws Exception {
        EnableEventRuleResponse self = new EnableEventRuleResponse();
        return TeaModel.build(map, self);
    }

    public EnableEventRuleResponse setHeaders(java.util.Map<String, String> headers) {
        this.headers = headers;
        return this;
    }
    public java.util.Map<String, String> getHeaders() {
        return this.headers;
    }

    public EnableEventRuleResponse setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
        return this;
    }
    public Integer getStatusCode() {
        return this.statusCode;
    }

    public EnableEventRuleResponse setBody(EnableEventRuleResponseBody body) {
        this.body = body;
        return this;
    }
    public EnableEventRuleResponseBody getBody() {
        return this.body;
    }

}
