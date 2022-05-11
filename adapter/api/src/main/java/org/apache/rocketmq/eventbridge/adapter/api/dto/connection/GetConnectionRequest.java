package org.apache.rocketmq.eventbridge.adapter.api.dto.connection;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.rocketmq.eventbridge.adapter.api.dto.BaseRequest;

@Setter
@Getter
@ToString
public class GetConnectionRequest extends BaseRequest {

    @SerializedName("ConnectionName")
    private String connectionName;
}
