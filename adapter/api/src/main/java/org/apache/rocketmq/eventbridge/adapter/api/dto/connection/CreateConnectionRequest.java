package org.apache.rocketmq.eventbridge.adapter.api.dto.connection;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.rocketmq.eventbridge.adapter.api.dto.BaseRequest;

@Setter
@Getter
@ToString
public class CreateConnectionRequest extends BaseRequest {

    private String name;

    private String description;

    private NetworkParameters networkParameters;

}
