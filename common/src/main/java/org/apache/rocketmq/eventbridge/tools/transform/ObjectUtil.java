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

package org.apache.rocketmq.eventbridge.tools.transform;

import com.google.common.base.Strings;
import java.util.function.Consumer;
import org.apache.rocketmq.eventbridge.exception.EventBridgeException;

public class ObjectUtil {
    /**
     * return the first value which not null
     *
     * @param items
     * @param <T>
     * @return
     */
    public static <T> T coalesce(T... items) {
        if (items == null || items.length == 0) {
            return null;
        }
        for (T item : items) {
            if (item != null) {
                return item;
            }
        }
        return null;
    }

    public static <T> void checkNotNullOrEmpty(EventBridgeException e, T... items) throws EventBridgeException {
        if (items == null || items.length == 0) {
            throw e;
        }
        for (T item : items) {
            if (item == null || Strings.isNullOrEmpty(item.toString())) {
                throw e;
            }
        }
    }

    /**
     * do func if  toPut is  empty
     *
     * @param toPut
     * @param func
     */
    public static void doIfEmpty(Object toPut, Consumer<Object> func) {
        if (toPut == null || Strings.isNullOrEmpty(toPut.toString())) {
            func.accept(toPut);
        }
    }
}
