package org.apache.rocketmq.eventbridge.adapter.api.dto.apidestination;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.rocketmq.eventbridge.adapter.api.dto.BaseResponse;
import org.apache.rocketmq.eventbridge.adapter.api.dto.connection.ListConnectionResponse;
import org.apache.rocketmq.eventbridge.domain.common.exception.EventBridgeErrorCode;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class CreateApiDestinationResponse extends BaseResponse {

    private String apiDestinationName;

    public CreateApiDestinationResponse success() {
        setCode(EventBridgeErrorCode.Success.getCode());
        setMessage(EventBridgeErrorCode.Success.getMsg());
        return this;
    }

    public CreateApiDestinationResponse parameterCheckFailRes(String errorMsg) {
        setCode(Integer.toString(409));
        setMessage(errorMsg);
        return this;
    }
}
