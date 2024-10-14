// This file is auto-generated, don't edit it. Thanks.
package org.apache.rocketmq.eventbridge.sdk.models;

import com.aliyun.tea.*;

public class PutEventsResponseBody extends TeaModel {
    @NameInMap("failedEntryCount")
    public Integer failedEntryCount;

    @NameInMap("entryList")
    public java.util.List<PutEventsResponseBodyEntryList> entryList;

    /**
     * <p>The status code returned. The status code 200 indicates that the request was successful.</p>
     * 
     * <strong>example:</strong>
     * <p>200</p>
     */
    @NameInMap("code")
    public String code;

    /**
     * <p>The error message that is returned if the request failed.</p>
     * 
     * <strong>example:</strong>
     * <p>EventBusNotExist</p>
     */
    @NameInMap("message")
    public String message;

    /**
     * <p>The request ID.</p>
     * 
     * <strong>example:</strong>
     * <p>580A938B-6107-586C-8EC7-F22EEBEDA9E6</p>
     */
    @NameInMap("requestId")
    public String requestId;

    public static PutEventsResponseBody build(java.util.Map<String, ?> map) throws Exception {
        PutEventsResponseBody self = new PutEventsResponseBody();
        return TeaModel.build(map, self);
    }

    public PutEventsResponseBody setFailedEntryCount(Integer failedEntryCount) {
        this.failedEntryCount = failedEntryCount;
        return this;
    }
    public Integer getFailedEntryCount() {
        return this.failedEntryCount;
    }

    public PutEventsResponseBody setEntryList(java.util.List<PutEventsResponseBodyEntryList> entryList) {
        this.entryList = entryList;
        return this;
    }
    public java.util.List<PutEventsResponseBodyEntryList> getEntryList() {
        return this.entryList;
    }

    public PutEventsResponseBody setCode(String code) {
        this.code = code;
        return this;
    }
    public String getCode() {
        return this.code;
    }

    public PutEventsResponseBody setMessage(String message) {
        this.message = message;
        return this;
    }
    public String getMessage() {
        return this.message;
    }

    public PutEventsResponseBody setRequestId(String requestId) {
        this.requestId = requestId;
        return this;
    }
    public String getRequestId() {
        return this.requestId;
    }

    public static class PutEventsResponseBodyEntryList extends TeaModel {
        /**
         * <p>The event ID.</p>
         * 
         * <strong>example:</strong>
         * <p>a5747e4f-2af2-40b6-b262-d0140e995bf7</p>
         */
        @NameInMap("eventId")
        public String eventId;

        /**
         * <p>The returned error code.</p>
         */
        @NameInMap("errorCode")
        public String errorCode;

        /**
         * <p>The returned error message.</p>
         */
        @NameInMap("errorMessage")
        public String errorMessage;

        public static PutEventsResponseBodyEntryList build(java.util.Map<String, ?> map) throws Exception {
            PutEventsResponseBodyEntryList self = new PutEventsResponseBodyEntryList();
            return TeaModel.build(map, self);
        }

        public PutEventsResponseBodyEntryList setEventId(String eventId) {
            this.eventId = eventId;
            return this;
        }
        public String getEventId() {
            return this.eventId;
        }

        public PutEventsResponseBodyEntryList setErrorCode(String errorCode) {
            this.errorCode = errorCode;
            return this;
        }
        public String getErrorCode() {
            return this.errorCode;
        }

        public PutEventsResponseBodyEntryList setErrorMessage(String errorMessage) {
            this.errorMessage = errorMessage;
            return this;
        }
        public String getErrorMessage() {
            return this.errorMessage;
        }

    }

}
