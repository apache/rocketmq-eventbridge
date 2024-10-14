// This file is auto-generated, don't edit it. Thanks.
package org.apache.rocketmq.eventbridge.sdk.models;

import com.aliyun.tea.*;

public class DeleteEventRuleResponse extends TeaModel {
    @NameInMap("headers")
    public java.util.Map<String, String> headers;

    @NameInMap("statusCode")
    public Integer statusCode;

    @NameInMap("body")
    public DeleteEventRuleResponseBody body;

    public static DeleteEventRuleResponse build(java.util.Map<String, ?> map) throws Exception {
        DeleteEventRuleResponse self = new DeleteEventRuleResponse();
        return TeaModel.build(map, self);
    }

    public DeleteEventRuleResponse setHeaders(java.util.Map<String, String> headers) {
        this.headers = headers;
        return this;
    }
    public java.util.Map<String, String> getHeaders() {
        return this.headers;
    }

    public DeleteEventRuleResponse setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
        return this;
    }
    public Integer getStatusCode() {
        return this.statusCode;
    }

    public DeleteEventRuleResponse setBody(DeleteEventRuleResponseBody body) {
        this.body = body;
        return this;
    }
    public DeleteEventRuleResponseBody getBody() {
        return this.body;
    }

}
