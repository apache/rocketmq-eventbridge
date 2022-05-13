package org.apache.rocketmq.eventbridge.domain.model.connection.parameter;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ClientParameters {

    @SerializedName("ClientID")
    private String clientID;

    @SerializedName("ClientSecret")
    private String clientSecret;
}