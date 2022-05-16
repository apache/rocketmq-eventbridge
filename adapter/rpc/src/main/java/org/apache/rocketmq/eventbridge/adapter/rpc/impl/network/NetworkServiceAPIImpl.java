package org.apache.rocketmq.eventbridge.adapter.rpc.impl.network;


import org.apache.rocketmq.eventbridge.domain.rpc.NetworkServiceAPI;
import org.springframework.stereotype.Component;

@Component
public class NetworkServiceAPIImpl implements NetworkServiceAPI {
    @Override
    public Boolean createPrivateNetwork() {
        return null;
    }

    @Override
    public Boolean deletePrivateNetwork() {
        return null;
    }
}
