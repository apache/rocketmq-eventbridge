package org.apache.rocketmq.eventbridge.adapter.api.dto.connection;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.rocketmq.eventbridge.adapter.api.dto.BaseRequest;

@Setter
@Getter
@ToString
public class ListConnectionRequest extends BaseRequest {

    @SerializedName("ConnectionNamePrefix")
    private String connectionNamePrefix;

    @SerializedName("MaxResults")
    private int maxResults;

    @SerializedName("NextToken")
    private String nextToken;
}
