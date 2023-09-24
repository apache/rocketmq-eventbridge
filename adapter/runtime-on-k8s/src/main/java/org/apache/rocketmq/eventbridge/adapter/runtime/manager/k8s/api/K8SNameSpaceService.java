package org.apache.rocketmq.eventbridge.adapter.runtime.manager.k8s.api;

import org.springframework.stereotype.Service;

@Service
public class K8SNameSpaceService {

    /**
     * Get the namespace from properties.
     *
     * @return
     */
    public String getNameSpace() {
        return "default";
    }

}
