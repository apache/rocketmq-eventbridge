// This file is auto-generated, don't edit it. Thanks.
package org.apache.rocketmq.eventbridge.sdk.models;

import com.aliyun.tea.*;

public class DeleteConnectionRequest extends TeaModel {
    /**
     * <p>The name of the connection that you want to delete. This parameter is required.</p>
     * 
     * <strong>example:</strong>
     * <p>connection-name</p>
     */
    @NameInMap("connectionName")
    public String connectionName;

    public static DeleteConnectionRequest build(java.util.Map<String, ?> map) throws Exception {
        DeleteConnectionRequest self = new DeleteConnectionRequest();
        return TeaModel.build(map, self);
    }

    public DeleteConnectionRequest setConnectionName(String connectionName) {
        this.connectionName = connectionName;
        return this;
    }
    public String getConnectionName() {
        return this.connectionName;
    }

}
