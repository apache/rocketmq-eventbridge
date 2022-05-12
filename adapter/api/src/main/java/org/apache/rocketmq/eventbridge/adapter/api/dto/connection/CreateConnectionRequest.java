package org.apache.rocketmq.eventbridge.adapter.api.dto.connection;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.rocketmq.eventbridge.adapter.api.dto.BaseRequest;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Setter
@Getter
@ToString
public class CreateConnectionRequest extends BaseRequest {

    @Pattern(regexp = "^[A-Za-z|0-9][A-Za-z|0-9|_|-]+$", message = "The Connection name is invalid! Which should match the pattern.")
    @Length(min = 1, max = 127, message = "The Connection name Exceeded length.")
    @NotBlank(message = "ConnectionName is blank.")
    @SerializedName("ConnectionName")
    private String connectionName;

    @SerializedName("Description")
    private String description;

    @SerializedName("NetworkParameters")
    private NetworkParameters networkParameters;

    @SerializedName("AuthParameters")
    private AuthParameters authParameters;
}
