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

package org.apache.rocketmq.eventbridge.infrastructure.validate;

import org.springframework.http.server.reactive.ServerHttpRequest;
import reactor.util.context.Context;

import java.util.List;

import static org.apache.rocketmq.eventbridge.enums.props.Constants.HEADER_KEY_RESOURCE_OWNER_ACCOUNT_ID;

/**
 * DefaultAuthValidation
 */
public class DefaultAuthValidation implements AuthValidation {

    @Override
    public Context validate(ServerHttpRequest request, Context ctx) {
        String resourceOwnerId = "default";
        List<String> resourceOwnerIds = request.getHeaders().get(HEADER_KEY_RESOURCE_OWNER_ACCOUNT_ID);
        if (resourceOwnerIds != null && !resourceOwnerIds.isEmpty()) {
            //throw new EventBridgeException(DefaultErrorCode.LoginFailed);
            resourceOwnerId = resourceOwnerIds.get(0);
        }
        return ctx.put(HEADER_KEY_RESOURCE_OWNER_ACCOUNT_ID.getName(), resourceOwnerId);
    }

    @Override
    public String getType() {
        return "default";
    }
}
