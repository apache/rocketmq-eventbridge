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

    @SerializedName("VpcId")
    private String vpcId;

    @SerializedName("VswitcheId")
    private String vswitcheId;

    @SerializedName("SecurityGroupId")
    private String securityGroupId;
}
