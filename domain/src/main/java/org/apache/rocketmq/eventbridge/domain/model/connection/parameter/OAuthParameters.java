package org.apache.rocketmq.eventbridge.domain.model.connection.parameter;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class OAuthParameters {
    @SerializedName("AuthorizationEndpoint")
    private String authorizationEndpoint;
    @SerializedName("ClientParameters")
    private ClientParameters clientParameters;
    @SerializedName("HttpMethod")
    private String httpMethod;
    @SerializedName("OAuthHttpParameters")
    private OAuthHttpParameters oauthHttpParameters;
}
