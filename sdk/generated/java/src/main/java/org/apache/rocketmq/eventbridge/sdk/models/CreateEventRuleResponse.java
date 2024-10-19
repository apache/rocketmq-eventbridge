// This file is auto-generated, don't edit it. Thanks.
package org.apache.rocketmq.eventbridge.sdk.models;

import com.aliyun.tea.*;

public class CreateEventRuleResponse extends TeaModel {
    @NameInMap("headers")
    public java.util.Map<String, String> headers;

    @NameInMap("statusCode")
    public Integer statusCode;

    @NameInMap("body")
    public CreateEventRuleResponseBody body;

    public static CreateEventRuleResponse build(java.util.Map<String, ?> map) throws Exception {
        CreateEventRuleResponse self = new CreateEventRuleResponse();
        return TeaModel.build(map, self);
    }

    public CreateEventRuleResponse setHeaders(java.util.Map<String, String> headers) {
        this.headers = headers;
        return this;
    }
    public java.util.Map<String, String> getHeaders() {
        return this.headers;
    }

    public CreateEventRuleResponse setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
        return this;
    }
    public Integer getStatusCode() {
        return this.statusCode;
    }

    public CreateEventRuleResponse setBody(CreateEventRuleResponseBody body) {
        this.body = body;
        return this;
    }
    public CreateEventRuleResponseBody getBody() {
        return this.body;
    }

}
