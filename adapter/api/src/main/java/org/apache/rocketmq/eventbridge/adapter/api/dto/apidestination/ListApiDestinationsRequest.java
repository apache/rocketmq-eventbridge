package org.apache.rocketmq.eventbridge.adapter.api.dto.apidestination;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.rocketmq.eventbridge.adapter.api.dto.BaseResponse;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@ToString
public class ListApiDestinationsRequest extends BaseResponse {

    @SerializedName("ApiDestinationNamePrefix")
    private String apiDestinationNamePrefix;

    @Min(value = 0, message = "maxResults <= 0")
    @SerializedName("MaxResults")
    private int maxResults;

    @NotBlank(message = "NextToken is blank")
    @SerializedName("NextToken")
    private String nextToken;

}
