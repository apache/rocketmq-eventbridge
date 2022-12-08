package org.apache.rocketmq.eventbridge.domain.model.data;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class NetworkEntity {

    private String socks5UserName;

    private String socks5Password;

    private String socks5Endpoint;

}
