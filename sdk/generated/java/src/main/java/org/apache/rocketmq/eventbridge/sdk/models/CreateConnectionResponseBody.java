// This file is auto-generated, don't edit it. Thanks.
package org.apache.rocketmq.eventbridge.sdk.models;

import com.aliyun.tea.*;

public class CreateConnectionResponseBody extends TeaModel {
    /**
     * <p>The returned response code. The value Success indicates that the request is successful.</p>
     * 
     * <strong>example:</strong>
     * <p>Success</p>
     */
    @NameInMap("code")
    public String code;

    /**
     * <p>The connection name.</p>
     * 
     * <strong>example:</strong>
     * <p>connection-demo</p>
     */
    @NameInMap("connectionName")
    public String connectionName;

    /**
     * <p>The returned message. If the request is successful, success is returned. If the request failed, an error code is returned.</p>
     * 
     * <strong>example:</strong>
     * <p>success</p>
     */
    @NameInMap("message")
    public String message;

    /**
     * <p>The request ID.</p>
     * 
     * <strong>example:</strong>
     * <p>7DA60DED-CD36-5837-B848-C01A23D2****</p>
     */
    @NameInMap("requestId")
    public String requestId;

    public static CreateConnectionResponseBody build(java.util.Map<String, ?> map) throws Exception {
        CreateConnectionResponseBody self = new CreateConnectionResponseBody();
        return TeaModel.build(map, self);
    }

    public CreateConnectionResponseBody setCode(String code) {
        this.code = code;
        return this;
    }
    public String getCode() {
        return this.code;
    }

    public CreateConnectionResponseBody setConnectionName(String connectionName) {
        this.connectionName = connectionName;
        return this;
    }
    public String getConnectionName() {
        return this.connectionName;
    }

    public CreateConnectionResponseBody setMessage(String message) {
        this.message = message;
        return this;
    }
    public String getMessage() {
        return this.message;
    }

    public CreateConnectionResponseBody setRequestId(String requestId) {
        this.requestId = requestId;
        return this;
    }
    public String getRequestId() {
        return this.requestId;
    }

}
