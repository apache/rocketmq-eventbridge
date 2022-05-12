package org.apache.rocketmq.eventbridge.adapter.api.dto.connection;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.rocketmq.eventbridge.adapter.api.dto.BaseRequest;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Setter
@Getter
@ToString
public class ListConnectionRequest extends BaseRequest {

    @SerializedName("ConnectionNamePrefix")
    private String connectionNamePrefix;

    @Min(value = 0, message = "maxResults <= 0")
    @SerializedName("MaxResults")
    private int maxResults;

    @NotBlank(message = "nextToken is blank")
    @SerializedName("NextToken")
    private String nextToken;
}
