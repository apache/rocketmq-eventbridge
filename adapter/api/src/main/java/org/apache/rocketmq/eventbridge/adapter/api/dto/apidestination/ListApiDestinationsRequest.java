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

    @Min(value = 0, message = "The limit size of page is invalid, which must greater than 0 and less than [{0}].")
    @SerializedName("MaxResults")
    private int maxResults;

    @NotBlank(message = "The next token of page is invalid. which should be {[0]}.")
    @SerializedName("NextToken")
    private String nextToken;

}
