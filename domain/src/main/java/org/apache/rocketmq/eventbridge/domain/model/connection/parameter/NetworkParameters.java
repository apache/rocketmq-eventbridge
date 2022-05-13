package org.apache.rocketmq.eventbridge.domain.model.connection.parameter;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@ToString
public class NetworkParameters {

    @NotBlank(message = "NetworkType is blank")
    @SerializedName("NetworkType")
    private String networkType;

    @SerializedName("VpcId")
    private String vpcId;

    @SerializedName("VswitcheId")
    private String vswitcheId;

    @SerializedName("SecurityGroupId")
    private String securityGroupId;
}
