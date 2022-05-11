package org.apache.rocketmq.eventbridge.adapter.api.dto.connection;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class NetworkParameters {

    @SerializedName("NetworkType")
    private String networkType;

    @SerializedName("VPCId")
    private String vPCId;

    @SerializedName("VSwitcheId")
    private String vSwitcheId;

    @SerializedName("SecurityGroupId")
    private String securityGroupId;
}
