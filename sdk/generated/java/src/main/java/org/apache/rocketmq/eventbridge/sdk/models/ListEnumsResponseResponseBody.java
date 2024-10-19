// This file is auto-generated, don't edit it. Thanks.
package org.apache.rocketmq.eventbridge.sdk.models;

import com.aliyun.tea.*;

public class ListEnumsResponseResponseBody extends TeaModel {
    @NameInMap("authorizationTypeEnums")
    public String authorizationTypeEnums;

    @NameInMap("networkTypeEnums")
    public String networkTypeEnums;

    /**
     * <p>The returned response code.</p>
     * 
     * <strong>example:</strong>
     * <p>Success</p>
     */
    @NameInMap("code")
    public String code;

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
     * <p>8346BE8F-40F3-533D-A0B8-1359C31BD5BA</p>
     */
    @NameInMap("requestId")
    public String requestId;

    public static ListEnumsResponseResponseBody build(java.util.Map<String, ?> map) throws Exception {
        ListEnumsResponseResponseBody self = new ListEnumsResponseResponseBody();
        return TeaModel.build(map, self);
    }

    public ListEnumsResponseResponseBody setAuthorizationTypeEnums(String authorizationTypeEnums) {
        this.authorizationTypeEnums = authorizationTypeEnums;
        return this;
    }
    public String getAuthorizationTypeEnums() {
        return this.authorizationTypeEnums;
    }

    public ListEnumsResponseResponseBody setNetworkTypeEnums(String networkTypeEnums) {
        this.networkTypeEnums = networkTypeEnums;
        return this;
    }
    public String getNetworkTypeEnums() {
        return this.networkTypeEnums;
    }

    public ListEnumsResponseResponseBody setCode(String code) {
        this.code = code;
        return this;
    }
    public String getCode() {
        return this.code;
    }

    public ListEnumsResponseResponseBody setMessage(String message) {
        this.message = message;
        return this;
    }
    public String getMessage() {
        return this.message;
    }

    public ListEnumsResponseResponseBody setRequestId(String requestId) {
        this.requestId = requestId;
        return this;
    }
    public String getRequestId() {
        return this.requestId;
    }

}
