// This file is auto-generated, don't edit it. Thanks.
package org.apache.rocketmq.eventbridge.sdk.models;

import com.aliyun.tea.*;

public class DeleteEventTargetsResponseBody extends TeaModel {
    /**
     * <p>The returned response code. Valid values:</p>
     * <pre><code>*   Success: The request is successful.
     * 
     * *   Other codes: The request failed. For more information about error codes, see Error codes.
     * </code></pre>
     * 
     * <strong>example:</strong>
     * <p>Success</p>
     */
    @NameInMap("code")
    public String code;

    /**
     * <p>The returned error message.</p>
     * 
     * <strong>example:</strong>
     * <p>Remote error. requestId: [A8EFABD2-95B9-1C46-9E01-xxxx], error code: [CreateRelatedResourceFailed], message: [Create related resource failed, EntityNotExist.Role : The role not exists: xxxx. \r\nRequestId : xxxx-168C-54ED-8FEB-BF11CB70AEB7]</p>
     */
    @NameInMap("message")
    public String message;

    /**
     * <p>The request ID.</p>
     * 
     * <strong>example:</strong>
     * <p>2922208e-e1c6-43ee-bfd1-aca50263bc8a</p>
     */
    @NameInMap("requestId")
    public String requestId;

    public static DeleteEventTargetsResponseBody build(java.util.Map<String, ?> map) throws Exception {
        DeleteEventTargetsResponseBody self = new DeleteEventTargetsResponseBody();
        return TeaModel.build(map, self);
    }

    public DeleteEventTargetsResponseBody setCode(String code) {
        this.code = code;
        return this;
    }
    public String getCode() {
        return this.code;
    }

    public DeleteEventTargetsResponseBody setMessage(String message) {
        this.message = message;
        return this;
    }
    public String getMessage() {
        return this.message;
    }

    public DeleteEventTargetsResponseBody setRequestId(String requestId) {
        this.requestId = requestId;
        return this;
    }
    public String getRequestId() {
        return this.requestId;
    }

}
