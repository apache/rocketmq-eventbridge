package org.apache.rocketmq.eventbridge.domain.common.enums;

import lombok.Getter;

@Getter
public enum NetworkTypeEnum {

    PUBLIC_NETWORK("PublicNetwork"),
    PRIVATE_NETWORK("PrivateNetwork");

    private final String networkType;
    NetworkTypeEnum(String networkType) {
        this.networkType = networkType;
    }
}
