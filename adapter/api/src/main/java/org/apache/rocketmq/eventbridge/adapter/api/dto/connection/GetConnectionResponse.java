package org.apache.rocketmq.eventbridge.adapter.api.dto.connection;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.rocketmq.eventbridge.adapter.api.dto.BaseResponse;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class GetConnectionResponse extends BaseResponse {

    private String connectionName;

}
