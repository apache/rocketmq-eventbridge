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

package org.apache.rocketmq.eventbridge.infrastructure.validate.spi;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.apache.rocketmq.eventbridge.infrastructure.validate.AuthValidation;
import org.apache.rocketmq.eventbridge.infrastructure.validate.spi.typed.TypedSPIRegistry;

/**
 * validation service load factory.
 *
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class ValidationServiceFactory {
    static {
        ValidationServiceLoader.register(AuthValidation.class);
    }

    /**
     * Get instance of cluster persist repository.
     *
     * @param type persist repository configuration
     * @return got instance
     */
    public static AuthValidation getInstance(final String type) {
        AuthValidation result = TypedSPIRegistry.getRegisteredService(AuthValidation.class, type);
        result.init();
        return result;
    }

}
