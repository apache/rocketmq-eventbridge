package org.apache.rocketmq.eventbridge.adapter.api.dto.connection;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class BaseParameter {

    @SerializedName("IsValueSecret")
    private String isValueSecret;

    @SerializedName("Key")
    private String key;

    @SerializedName("Value")
    private String value;

}
