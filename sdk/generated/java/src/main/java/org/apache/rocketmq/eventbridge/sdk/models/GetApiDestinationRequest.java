// This file is auto-generated, don't edit it. Thanks.
package org.apache.rocketmq.eventbridge.sdk.models;

import com.aliyun.tea.*;

public class GetApiDestinationRequest extends TeaModel {
    /**
     * <p>The name of the API destination. This parameter is required.</p>
     * 
     * <strong>example:</strong>
     * <p>api-destination-name</p>
     */
    @NameInMap("apiDestinationName")
    public String apiDestinationName;

    public static GetApiDestinationRequest build(java.util.Map<String, ?> map) throws Exception {
        GetApiDestinationRequest self = new GetApiDestinationRequest();
        return TeaModel.build(map, self);
    }

    public GetApiDestinationRequest setApiDestinationName(String apiDestinationName) {
        this.apiDestinationName = apiDestinationName;
        return this;
    }
    public String getApiDestinationName() {
        return this.apiDestinationName;
    }

}
