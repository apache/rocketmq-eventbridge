package org.apache.rocketmq.eventbridge.domain.common.enums;

import lombok.Getter;

@Getter
public enum AuthorizationTypeEnum {

    API_KEY_AUTH("API_KEY_AUTH"),
    BASIC_AUTH("BASIC_AUTH"),
    OAUTH_AUTH("OAUTH_AUTH");
    private final String type;

    AuthorizationTypeEnum(String type) {
        this.type = type;
    }
}
