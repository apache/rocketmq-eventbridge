// This file is auto-generated, don't edit it. Thanks.
/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
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
