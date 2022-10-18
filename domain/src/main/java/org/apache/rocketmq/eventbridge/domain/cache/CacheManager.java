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

package org.apache.rocketmq.eventbridge.domain.cache;

import com.github.benmanes.caffeine.cache.Caffeine;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.apache.rocketmq.eventbridge.domain.common.enums.CacheEnum;
import org.springframework.cache.Cache;
import org.springframework.cache.caffeine.CaffeineCache;
import org.springframework.cache.support.AbstractCacheManager;
import org.springframework.stereotype.Component;

@Component
public class CacheManager extends AbstractCacheManager {
    private List<Cache> caches = new ArrayList<>();

    public CacheManager() {
        for (CacheEnum c : CacheEnum.values()) {
            this.dynamicAddCache(new CaffeineCache(c.name(), Caffeine.newBuilder()
                .recordStats()
                .expireAfterWrite(c.getTtl(), TimeUnit.SECONDS)
                .maximumSize(c.getMaxSize())
                .build()));
        }
    }

    @Override
    protected Collection<? extends Cache> loadCaches() {
        return caches;
    }

    public Collection<Cache> getCaches() {
        return caches;
    }

    public synchronized void dynamicAddCache(Cache cache) {
        int existIndex = -1;
        for (int i = 0; i < caches.size(); i++) {
            if (cache.getName()
                .equals(caches.get(i)
                    .getName())) {
                existIndex = i;
                break;
            }
        }
        if (existIndex >= 0) {
            this.caches.set(existIndex, cache);
        } else {
            this.caches.add(cache);
        }
        super.addCache(cache);
    }
}
