// This file is auto-generated, don't edit it. Thanks.
package org.apache.rocketmq.eventbridge.sdk.models;

import com.aliyun.tea.*;

public class DeleteApiDestinationRequest extends TeaModel {
    /**
     * <p>The name of the API destination. This parameter is required.</p>
     * 
     * <strong>example:</strong>
     * <p>ApiDestinationName</p>
     */
    @NameInMap("apiDestinationName")
    public String apiDestinationName;

    public static DeleteApiDestinationRequest build(java.util.Map<String, ?> map) throws Exception {
        DeleteApiDestinationRequest self = new DeleteApiDestinationRequest();
        return TeaModel.build(map, self);
    }

    public DeleteApiDestinationRequest setApiDestinationName(String apiDestinationName) {
        this.apiDestinationName = apiDestinationName;
        return this;
    }
    public String getApiDestinationName() {
        return this.apiDestinationName;
    }

}
