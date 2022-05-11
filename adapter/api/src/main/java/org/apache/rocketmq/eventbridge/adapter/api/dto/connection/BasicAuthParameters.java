package org.apache.rocketmq.eventbridge.adapter.api.dto.connection;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class BasicAuthParameters {

    @SerializedName("Password")
    private String password;

    @SerializedName("Username")
    private String username;
}
