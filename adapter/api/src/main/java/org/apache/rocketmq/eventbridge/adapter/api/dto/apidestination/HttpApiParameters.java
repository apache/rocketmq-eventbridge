package org.apache.rocketmq.eventbridge.adapter.api.dto.apidestination;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Getter
@Setter
@ToString
public class HttpApiParameters {

    @NotBlank(message = "Endpoint is blank")
    @SerializedName("Endpoint")
    private String endpoint;

    @NotBlank(message = "Method is blank")
    @SerializedName("Method")
    private String method;

    @SerializedName("Parameters")
    private List<Parameter> parameters;
}
