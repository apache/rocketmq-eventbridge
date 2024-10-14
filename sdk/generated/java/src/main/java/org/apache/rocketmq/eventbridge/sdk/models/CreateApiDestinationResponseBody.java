// This file is auto-generated, don't edit it. Thanks.
package org.apache.rocketmq.eventbridge.sdk.models;

import com.aliyun.tea.*;

public class CreateApiDestinationResponseBody extends TeaModel {
    /**
     * <p>The returned response code. The value Success indicates that the request is successful.</p>
     * 
     * <strong>example:</strong>
     * <p>Success</p>
     */
    @NameInMap("code")
    public String code;

    /**
     * <p>The name of the API destination.</p>
     * 
     * <strong>example:</strong>
     * <p>ApiDestinationName</p>
     */
    @NameInMap("apiDestinationName")
    public String apiDestinationName;

    /**
     * <p>The returned message.</p>
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
     * <p>5DAF96FB-A4B6-548C-B999-0BFDCB2261B9</p>
     */
    @NameInMap("requestId")
    public String requestId;

    public static CreateApiDestinationResponseBody build(java.util.Map<String, ?> map) throws Exception {
        CreateApiDestinationResponseBody self = new CreateApiDestinationResponseBody();
        return TeaModel.build(map, self);
    }

    public CreateApiDestinationResponseBody setCode(String code) {
        this.code = code;
        return this;
    }
    public String getCode() {
        return this.code;
    }

    public CreateApiDestinationResponseBody setApiDestinationName(String apiDestinationName) {
        this.apiDestinationName = apiDestinationName;
        return this;
    }
    public String getApiDestinationName() {
        return this.apiDestinationName;
    }

    public CreateApiDestinationResponseBody setMessage(String message) {
        this.message = message;
        return this;
    }
    public String getMessage() {
        return this.message;
    }

    public CreateApiDestinationResponseBody setRequestId(String requestId) {
        this.requestId = requestId;
        return this;
    }
    public String getRequestId() {
        return this.requestId;
    }

}
