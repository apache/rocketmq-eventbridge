package org.apache.rocketmq.eventbridge.adapter.api.dto.connection;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.rocketmq.eventbridge.domain.common.enums.AuthorizationTypeEnum;
import org.apache.rocketmq.eventbridge.domain.common.enums.NetworkTypeEnum;

import java.util.List;

@Getter
@Setter
@ToString
public class ListEnumsResponse {

    private List<AuthorizationTypeEnum> authorizationTypeEnums;

    private List<NetworkTypeEnum> networkTypeEnums;

}
