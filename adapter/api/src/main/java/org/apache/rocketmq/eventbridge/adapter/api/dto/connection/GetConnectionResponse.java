package org.apache.rocketmq.eventbridge.adapter.api.dto.connection;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.rocketmq.eventbridge.adapter.api.dto.BaseResponse;
import org.apache.rocketmq.eventbridge.domain.common.exception.EventBridgeErrorCode;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class GetConnectionResponse extends BaseResponse {

    @SerializedName("ConnectionName")
    private String connectionName;

    @SerializedName("Description")
    private String description;

    @SerializedName("NetworkParameters")
    private NetworkParameters networkParameters;

    @SerializedName("AuthParameters")
    private AuthParameters authParameters;

    public GetConnectionResponse success() {
        setCode(Integer.toString(EventBridgeErrorCode.Success.getHttpCode()));
        setMessage(EventBridgeErrorCode.Success.getMsg());
        return this;
    }
}
