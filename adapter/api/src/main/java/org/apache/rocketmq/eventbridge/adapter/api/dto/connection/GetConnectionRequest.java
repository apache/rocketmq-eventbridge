package org.apache.rocketmq.eventbridge.adapter.api.dto.connection;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.rocketmq.eventbridge.adapter.api.dto.BaseRequest;

import javax.validation.constraints.NotBlank;

@Setter
@Getter
@ToString
public class GetConnectionRequest extends BaseRequest {

    @NotBlank(message = "ConnectionName is blank")
    @SerializedName("ConnectionName")
    private String connectionName;
}