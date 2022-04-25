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

package org.apache.rocketmq.eventbridge.domain.model.source;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.apache.rocketmq.eventbridge.domain.common.enums.EventSourceTypeEnum;
import org.apache.rocketmq.eventbridge.domain.model.PaginationResult;
import org.apache.rocketmq.eventbridge.domain.model.bus.EventBusService;
import org.apache.rocketmq.eventbridge.domain.repository.EventSourceRepository;
import org.apache.rocketmq.eventbridge.exception.EventBridgeException;
import org.apache.rocketmq.eventbridge.tools.NetUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.DigestUtils;

import static org.apache.rocketmq.eventbridge.domain.common.exception.EventBridgeErrorCode.ExceedHttpSourceParametersCount;
import static org.apache.rocketmq.eventbridge.domain.common.exception.EventBridgeErrorCode.GenerateTokenError;
import static org.apache.rocketmq.eventbridge.domain.common.exception.EventBridgeErrorCode.HttpSourceParametersEmpty;
import static org.apache.rocketmq.eventbridge.domain.common.exception.EventBridgeErrorCode.HttpSourceParametersInvalid;

@Service
public class HTTPEventSourceService extends EventSourceService {

    private static final String CLASS_NAME = "HttpEvent";

    private static final Integer GET_TOKEN_TIMES = 100;
    public static final String PUBLIC_HTTP_WEBHOOK_SCHEMA = "http://%s.eventbridge.%s.aliyuncs.com/webhook/putEvents?token=%s";
    public static final String PUBLIC_HTTPS_WEBHOOK_SCHEMA = "https://%s.eventbridge.%s.aliyuncs.com/webhook/putEvents?token=%s";
    public static final String VPC_HTTP_WEBHOOK_SCHEMA = "http://%s.eventbridge.%s-vpc.aliyuncs.com/webhook/putEvents?token=%s";
    public static final String VPC_HTTPS_WEBHOOK_SCHEMA = "https://%s.eventbridge.%s-vpc.aliyuncs.com/webhook/putEvents?token=%s";

    private static final Set<String> SOURCE_PARAM_METHODS = new HashSet<>(Arrays.asList("GET", "POST", "PUT", "PATCH", "DELETE", "HEAD", "OPTIONS", "TRACE", "CONNECT"));
    private static final Set<String> SOURCE_PARAM_TYPES = new HashSet<>(Arrays.asList("HTTP", "HTTPS", "HTTP&HTTPS"));

    public static final String SECURITY_CONFIG_NONE = "none";
    public static final String SECURITY_CONFIG_IP = "ip";
    public static final String SECURITY_CONFIG_REFERER = "referer";
    private static final Set<String> SOURCE_PARAM_SECURITY_CONFIG = new HashSet<>(Arrays.asList(SECURITY_CONFIG_NONE, SECURITY_CONFIG_IP, SECURITY_CONFIG_REFERER));

    private static final Integer SECURITY_CONFIG_LENGTH = 5;
    private static final Integer REFERER_LENGTH_LIMIT = 256;

    public HTTPEventSourceService(EventBusService eventBusService, EventSourceRepository eventSourceRepository) {
        super(eventBusService, eventSourceRepository);
    }

    @Override
    public boolean match(EventSourceTypeEnum type, String className) {
        if (EventSourceTypeEnum.USER_DEFINED.equals(type) && CLASS_NAME.equals(className)) {
            return Boolean.TRUE;
        } else {
            return Boolean.FALSE;
        }
    }

    @Transactional
    @Override
    public boolean createEventSource(String accountId, String eventBusName, String eventSourceName, String description,
                                     String className, Map<String, Object> inputConfig) {
        // 校验
        checkConfig(inputConfig);
        // 渲染
        Map<String, Object> renderConfig = renderConfig(accountId, eventBusName, eventSourceName, inputConfig);
        return super.createEventSource(accountId, eventBusName, eventSourceName, description, className, renderConfig);
    }

    private void checkConfig(Map<String, Object> inputConfig) {
        HashMap<String, Object> sourceConfig = new HashMap<>(inputConfig.size());
        inputConfig.forEach((k ,v) -> {
            sourceConfig.put(k.toLowerCase(), v);
        });
        // check type
        checkType((String) sourceConfig.get("type"));

        // check method
        checkMethod((List<String>) sourceConfig.get("method"));

        // check security config
        String securityConfig = (String) sourceConfig.get("securityconfig");
        checkSecurityConfig(securityConfig);

        // check ip
        checkIp(securityConfig, (List<String>) sourceConfig.get("ip"));

        // check referer
        checkReferer(securityConfig, (List<String>) sourceConfig.get("referer"));
    }

    private Map<String, Object> renderConfig(String accountId, String eventBusName, String eventSourceName, Map<String, Object> inputConfig) {
        HashMap<String, Object> result = new HashMap<>(inputConfig);

        // The ip and referer parameters from the sdk are empty when securityConfig is none
        result.putIfAbsent("Ip", new ArrayList<>());
        result.putIfAbsent("Referer", new ArrayList<>());

        EventSource eventSource = super.getEventSource(accountId, eventBusName, eventSourceName);
        if (eventSource == null || StringUtils.isBlank((String) eventSource.getConfig().get("Token"))) {
            // TODO
            String regionId = "";
            String type = (String) inputConfig.get("Type");
            String token = generateToken(accountId, eventBusName);
            result.put("Token", token);
            result.put("PublicWebHookUrl", generateWebHookUrl(regionId, accountId, type, token, false));
            result.put("VpcWebHookUrl", generateWebHookUrl(regionId, accountId, type, token, true));
        }
        return result;
    }

    public String generateToken(String accountId, String eventBusName) throws EventBridgeException {
        int count = GET_TOKEN_TIMES;
        String token = DigestUtils.md5DigestAsHex(
                (accountId + eventBusName + UUID.randomUUID()).getBytes(StandardCharsets.UTF_8));
        int sourceCount = super.getEventSourceCount(accountId, eventBusName);
        PaginationResult<List<EventSource>> paginationResult = super.listEventSources(accountId, eventBusName, "0", sourceCount);
        Set<String> tokenSet = paginationResult.getData()
                .stream()
                .filter(eventSource -> this.match(eventSource.getType(), eventSource.getClassName()))
                .map(eventSource -> (String) eventSource.getConfig().get("Token")).collect(Collectors.toSet());

        if (count > 0 && tokenSet.contains(token)) {
            token = DigestUtils.md5DigestAsHex(
                    (accountId + eventBusName + UUID.randomUUID()).getBytes(StandardCharsets.UTF_8));
            count--;
        }
        if (count == 0) {
            throw new EventBridgeException(GenerateTokenError, "Get token failed with " + GET_TOKEN_TIMES + " retry times");
        }
        return token;
    }

    public List<String> generateWebHookUrl(String regionId, String accountId, String type, String token, boolean isVpc) {
        List<String> webHookUrl = new ArrayList<>();
        String httpWebHookSchema = isVpc ? VPC_HTTP_WEBHOOK_SCHEMA : PUBLIC_HTTP_WEBHOOK_SCHEMA;
        String httpsWebHookSchema = isVpc ? VPC_HTTPS_WEBHOOK_SCHEMA : PUBLIC_HTTPS_WEBHOOK_SCHEMA;
        if ("HTTP".equalsIgnoreCase(type)) {
            webHookUrl.add(String.format(httpWebHookSchema, accountId, regionId, token));
        } else if ("HTTPS".equalsIgnoreCase(type)) {
            webHookUrl.add(String.format(httpsWebHookSchema, accountId, regionId, token));
        } else {
            webHookUrl.add(String.format(httpWebHookSchema, accountId, regionId, token));
            webHookUrl.add(String.format(httpsWebHookSchema, accountId, regionId, token));
        }
        return webHookUrl;
    }

    private void checkType(String type) throws EventBridgeException {
        if (StringUtils.isBlank(type)) {
            throw new EventBridgeException(HttpSourceParametersEmpty, "Type");
        }
        if (!SOURCE_PARAM_TYPES.contains(type)) {
            throw new EventBridgeException(HttpSourceParametersInvalid, "Parameter name is Type and value is " + type);
        }
    }

    private void checkMethod(List<String> methods) throws EventBridgeException {
        if (CollectionUtils.isEmpty(methods)) {
            throw new EventBridgeException(HttpSourceParametersEmpty, "Method");
        }
        for (String method : methods) {
            if (StringUtils.isBlank(method)) {
                throw new EventBridgeException(HttpSourceParametersEmpty, "Method");
            }
            if (!SOURCE_PARAM_METHODS.contains(method)) {
                throw new EventBridgeException(HttpSourceParametersInvalid, "Parameter name is Method and value is " + method);
            }
        }
    }

    private void checkSecurityConfig(String securityConfig) throws EventBridgeException {
        if (StringUtils.isBlank(securityConfig)) {
            throw new EventBridgeException(HttpSourceParametersEmpty, "SecurityConfig");
        }
        if (!SOURCE_PARAM_SECURITY_CONFIG.contains(securityConfig)) {
            throw new EventBridgeException(HttpSourceParametersInvalid, "Parameter name is SecurityConfig and value is " + securityConfig);
        }
    }

    private void checkIp(String securityConfig, List<String> subnets) throws EventBridgeException {
        if (!SECURITY_CONFIG_IP.equals(securityConfig) && !CollectionUtils.isEmpty(subnets)) {
            throw new EventBridgeException(HttpSourceParametersInvalid, "Parameter Ip should be empty when SecurityConfig is " + securityConfig);
        }
        if (SECURITY_CONFIG_IP.equals(securityConfig)) {
            if (CollectionUtils.isEmpty(subnets)) {
                throw new EventBridgeException(HttpSourceParametersInvalid, "Parameter Ip should not be empty when SecurityConfig is " + securityConfig);
            }
            if (subnets.size() > SECURITY_CONFIG_LENGTH) {
                throw new EventBridgeException(ExceedHttpSourceParametersCount, SECURITY_CONFIG_LENGTH, "Ip", subnets.size());
            }
            for (String subnet : subnets) {
                if (!NetUtil.isIpv4(subnet) && !NetUtil.isNetSegment(subnet)) {
                    throw new EventBridgeException(HttpSourceParametersInvalid, "Illegal IP or network segment: " + subnet);
                }
            }
        }
    }

    private void checkReferer(String securityConfig, List<String> referers) throws EventBridgeException {
        if (!SECURITY_CONFIG_REFERER.equals(securityConfig) && !CollectionUtils.isEmpty(referers)) {
            throw new EventBridgeException(HttpSourceParametersInvalid, "Parameter Referer should be empty when SecurityConfig is " + securityConfig);
        }
        if (SECURITY_CONFIG_REFERER.equals(securityConfig)) {
            if (CollectionUtils.isEmpty(referers)) {
                throw new EventBridgeException(HttpSourceParametersInvalid, "Parameter Referer should not be empty when SecurityConfig is " + securityConfig);
            }
            if (referers.size() > SECURITY_CONFIG_LENGTH) {
                throw new EventBridgeException(ExceedHttpSourceParametersCount, SECURITY_CONFIG_LENGTH, "Referer", referers.size());
            }
            for (String referer : referers) {
                if (StringUtils.isBlank(referer)) {
                    throw new EventBridgeException(HttpSourceParametersEmpty, "Referer");
                }
                if (referer.length() > REFERER_LENGTH_LIMIT) {
                    throw new EventBridgeException(HttpSourceParametersInvalid, "Parameter Referer too long. referer=" + referer);
                }
            }
        }
    }
}
