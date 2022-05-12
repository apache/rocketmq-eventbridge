package org.apache.rocketmq.eventbridge.adapter.api.dto.apidestination;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.rocketmq.eventbridge.adapter.api.dto.BaseResponse;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Getter
@Setter
@ToString
public class CreateApiDestinationRequest extends BaseResponse {

    @Pattern(regexp = "^[A-Za-z|0-9][A-Za-z|0-9|_|-]+$", message = "The ApiDestination name is invalid! Which should match the pattern.")
    @Length(min = 1, max = 127, message = "The ApiDestination name Exceeded length.")
    @NotBlank(message = "ApiDestinationName is blank")
    @SerializedName("ApiDestinationName")
    private String apiDestinationName;

    @SerializedName("ConnectionName")
    private String connectionName;

    @SerializedName("Description")
    private String description;

    @SerializedName("HttpApiParameters")
    private HttpApiParameters httpApiParameters;

    @SerializedName("InvocationRateLimitPerSecond")
    private Integer invocationRateLimitPerSecond;
}
