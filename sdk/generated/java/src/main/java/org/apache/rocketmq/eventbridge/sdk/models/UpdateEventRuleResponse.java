// This file is auto-generated, don't edit it. Thanks.
package org.apache.rocketmq.eventbridge.sdk.models;

import com.aliyun.tea.*;

public class UpdateEventRuleResponse extends TeaModel {
    @NameInMap("headers")
    public java.util.Map<String, String> headers;

    @NameInMap("statusCode")
    public Integer statusCode;

    @NameInMap("body")
    public UpdateEventRuleResponseBody body;

    public static UpdateEventRuleResponse build(java.util.Map<String, ?> map) throws Exception {
        UpdateEventRuleResponse self = new UpdateEventRuleResponse();
        return TeaModel.build(map, self);
    }

    public UpdateEventRuleResponse setHeaders(java.util.Map<String, String> headers) {
        this.headers = headers;
        return this;
    }
    public java.util.Map<String, String> getHeaders() {
        return this.headers;
    }

    public UpdateEventRuleResponse setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
        return this;
    }
    public Integer getStatusCode() {
        return this.statusCode;
    }

    public UpdateEventRuleResponse setBody(UpdateEventRuleResponseBody body) {
        this.body = body;
        return this;
    }
    public UpdateEventRuleResponseBody getBody() {
        return this.body;
    }

}
