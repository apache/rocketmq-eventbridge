package org.apache.rocketmq.eventbridge.adapter.api.dto.apidestination;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class HttpApiParameters {

    @SerializedName("Endpoint")
    private String endpoint;

    @SerializedName("Method")
    private String method;

    @SerializedName("Parameters")
    private List<Parameter> parameters;
}
