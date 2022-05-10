package org.apache.rocketmq.eventbridge.adapter.api.dto.connection;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class NetworkParameters {

    private String networkType;

    private String vPCId;

    private String vSwitcheId;

    private String securityGroupId;
}
