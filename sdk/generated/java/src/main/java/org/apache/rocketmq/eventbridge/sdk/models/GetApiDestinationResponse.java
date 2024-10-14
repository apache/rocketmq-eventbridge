// This file is auto-generated, don't edit it. Thanks.
package org.apache.rocketmq.eventbridge.sdk.models;

import com.aliyun.tea.*;

public class GetApiDestinationResponse extends TeaModel {
    @NameInMap("headers")
    public java.util.Map<String, String> headers;

    @NameInMap("statusCode")
    public Integer statusCode;

    @NameInMap("body")
    public GetApiDestinationResponseBody body;

    public static GetApiDestinationResponse build(java.util.Map<String, ?> map) throws Exception {
        GetApiDestinationResponse self = new GetApiDestinationResponse();
        return TeaModel.build(map, self);
    }

    public GetApiDestinationResponse setHeaders(java.util.Map<String, String> headers) {
        this.headers = headers;
        return this;
    }
    public java.util.Map<String, String> getHeaders() {
        return this.headers;
    }

    public GetApiDestinationResponse setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
        return this;
    }
    public Integer getStatusCode() {
        return this.statusCode;
    }

    public GetApiDestinationResponse setBody(GetApiDestinationResponseBody body) {
        this.body = body;
        return this;
    }
    public GetApiDestinationResponseBody getBody() {
        return this.body;
    }

}
