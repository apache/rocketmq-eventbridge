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
public class GetApiDestinationRequest extends BaseResponse {

    @SerializedName("ApiDestinationName")
    private String apiDestinationName;

}
