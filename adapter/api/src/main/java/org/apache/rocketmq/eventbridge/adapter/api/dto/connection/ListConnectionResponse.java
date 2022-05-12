package org.apache.rocketmq.eventbridge.adapter.api.dto.connection;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.rocketmq.eventbridge.adapter.api.dto.BaseResponse;
import org.apache.rocketmq.eventbridge.domain.common.exception.EventBridgeErrorCode;

import java.util.List;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class ListConnectionResponse extends BaseResponse {

    @SerializedName("Connections")
    private List<ConnectionVO> connections;

    @SerializedName("NextToken")
    private String nextToken;

    @SerializedName("Total")
    private Integer total;

    @SerializedName("MaxResults")
    private int maxResults;

    public ListConnectionResponse success() {
        setCode(Integer.toString(EventBridgeErrorCode.Success.getHttpCode()));
        setMessage(EventBridgeErrorCode.Success.getMsg());
        return this;
    }

    public ListConnectionResponse parameterCheckFailRes(String errorMsg) {
        setCode(Integer.toString(409));
        setMessage(errorMsg);
        return this;
    }
}
