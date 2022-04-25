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

import org.apache.commons.lang3.StringUtils;
import org.apache.rocketmq.eventbridge.domain.model.bus.EventBus;
import org.apache.rocketmq.eventbridge.domain.model.source.EventSource;
import org.apache.rocketmq.eventbridge.domain.repository.EventBusRepository;
import org.apache.rocketmq.eventbridge.domain.repository.EventSourceRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

import static org.apache.rocketmq.eventbridge.domain.cache.CacheName.EVENT_SOURCE;

/**
 * @Author changfeng
 * @Date 2022/4/25 11:15 上午
 */
@Component
@CacheConfig(cacheNames = EVENT_SOURCE, cacheManager = "cacheManager")
public class EventSourceCacheService {
    private static final Logger logger = LoggerFactory.getLogger(EventSourceCacheService.class);
    private static final String TOKEN_CONFIG = "Token";

    private final EventBusRepository eventBusRepository;
    private final EventSourceRepository eventSourceRepository;

    public EventSourceCacheService(EventBusRepository eventBusRepository, EventSourceRepository eventSourceRepository) {
        this.eventBusRepository = eventBusRepository;
        this.eventSourceRepository = eventSourceRepository;
    }

    @PostConstruct
    public void init() {
        this.sourceCache = this.cacheManager.getCache(EVENT_SOURCE);
    }

    @Autowired
    private CacheManager cacheManager;
    private Cache sourceCache;

    @Cacheable(cacheNames = EVENT_SOURCE, keyGenerator = "generalKeyGenerator", unless = "#result == null")
    public EventSource getEventSourceByToken(String accountId, String token) {
        try {
            int busCount = eventBusRepository.getEventBusesCount(accountId);
            List<EventBus> eventBuses = eventBusRepository.listEventBuses(accountId, "0", busCount);
            for (EventBus eventBus: eventBuses) {
                int sourceCount = eventSourceRepository.getEventSourceCount(accountId, eventBus.getName());
                List<EventSource> eventSources = eventSourceRepository.listEventSources(accountId, eventBus.getName(), "0", sourceCount);
                for (EventSource eventSource: eventSources) {
                    String sourceToken = (String) eventSource.getConfig().get(TOKEN_CONFIG);
                    if (StringUtils.isNotBlank(sourceToken) && StringUtils.equals(sourceToken, token)) {
                        return eventSource;
                    }
                }
            }
        } catch (Throwable t) {
            logger.error("EventSourceCacheService getEventSourceByToken error.", t);
        }
        return null;
    }

    public void evict(String accountId, String eventBusName, String eventSourceName) {
        EventSource eventSource = eventSourceRepository.getEventSource(accountId, eventBusName, eventSourceName);
        if (eventSource != null) {
            String token = (String) eventSource.getConfig().get(TOKEN_CONFIG);
            if (StringUtils.isNotBlank(token)) {
                this.sourceCache.evict(GeneralKeyGenerator.generateKey(accountId, token));
            }
        }
    }
}
