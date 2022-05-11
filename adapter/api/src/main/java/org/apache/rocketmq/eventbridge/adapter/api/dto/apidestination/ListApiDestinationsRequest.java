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
public class ListApiDestinationsRequest extends BaseResponse {

    @SerializedName("ApiDestinationNamePrefix")
    private String apiDestinationNamePrefix;

    @SerializedName("MaxResults")
    private int maxResults;

    @SerializedName("NextToken")
    private String nextToken;

}
