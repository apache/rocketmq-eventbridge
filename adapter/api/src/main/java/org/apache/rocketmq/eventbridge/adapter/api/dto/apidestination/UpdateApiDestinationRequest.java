package org.apache.rocketmq.eventbridge.adapter.api.dto.apidestination;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.rocketmq.eventbridge.adapter.api.dto.BaseResponse;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class UpdateApiDestinationRequest extends BaseResponse {

    @SerializedName("ApiDestinationName")
    private String apiDestinationName;

    @SerializedName("ConnectionName")
    private String connectionName;

    @SerializedName("Description")
    private String description;

    @SerializedName("HttpApiParameters")
    private HttpApiParameters httpApiParameters;

    @SerializedName("InvocationRateLimitPerSecond")
    private Integer invocationRateLimitPerSecond;
}
