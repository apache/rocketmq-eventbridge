package org.apache.rocketmq.eventbridge.domain.model.connection.parameter;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class InvocationHttpParameters {

    @SerializedName("BodyParameters")
    private List<BodyParameter> bodyParameters;

    @SerializedName("HeaderParameters")
    private List<HeaderParameter> headerParameters;

    @SerializedName("QueryStringParameters")
    private List<QueryStringParameter> queryStringParameters;

}
