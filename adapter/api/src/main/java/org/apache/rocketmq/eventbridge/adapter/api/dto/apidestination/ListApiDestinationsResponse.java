package org.apache.rocketmq.eventbridge.adapter.api.dto.apidestination;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.rocketmq.eventbridge.adapter.api.dto.BaseResponse;

import java.util.List;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class ListApiDestinationsResponse extends BaseResponse {

    @SerializedName("ApiDestinations")
    private List<ApiDestinationsVO> apiDestinations;

    @SerializedName("NextToken")
    private String nextToken;

    @SerializedName("Total")
    private Integer total;

    @SerializedName("MaxResults")
    private int maxResults;
}