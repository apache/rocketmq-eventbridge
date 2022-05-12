package org.apache.rocketmq.eventbridge.adapter.api.dto.apidestination;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.rocketmq.eventbridge.adapter.api.dto.BaseResponse;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@ToString
public class DeleteApiDestinationRequest extends BaseResponse {

    @NotBlank(message = "ApiDestinationName is blank")
    @SerializedName("ApiDestinationName")
    private String apiDestinationName;
}
