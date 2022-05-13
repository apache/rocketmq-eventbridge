package org.apache.rocketmq.eventbridge.adapter.api.dto.apidestination;

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
public class GetApiDestinationResponse extends BaseResponse {

    @SerializedName("ApiDestinationName")
    private String apiDestinationName;

    @SerializedName("ConnectionName")
    private String connectionName;

    @SerializedName("Description")
    private String description;

    @SerializedName("HttpApiParameters")
    private String httpApiParameters;

    @SerializedName("InvocationRateLimitPerSecond")
    private Integer invocationRateLimitPerSecond;

    public GetApiDestinationResponse success() {
        setCode(EventBridgeErrorCode.Success.getCode());
        setMessage(EventBridgeErrorCode.Success.getMsg());
        return this;
    }

    public GetApiDestinationResponse parameterCheckFailRes(String errorMsg) {
        setCode(Integer.toString(409));
        setMessage(errorMsg);
        return this;
    }
}