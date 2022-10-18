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

 package org.apache.rocketmq.eventbridge.adapter.api.converter;

 import com.google.common.net.MediaType;
 import com.google.common.reflect.TypeToken;
 import com.google.gson.Gson;
 import io.cloudevents.CloudEvent;
 import io.cloudevents.core.v1.CloudEventBuilder;
 import java.lang.reflect.Type;
 import java.net.URI;
 import java.nio.charset.StandardCharsets;
 import java.time.OffsetDateTime;
 import java.time.ZonedDateTime;
 import java.util.Collections;
 import java.util.HashMap;
 import java.util.HashSet;
 import java.util.List;
 import java.util.Map;
 import java.util.Set;
 import java.util.UUID;
 import org.apache.commons.lang3.StringUtils;
 import org.apache.commons.net.util.SubnetUtils;
 import org.apache.rocketmq.eventbridge.adapter.api.dto.data.HttpEventData;
 import org.apache.rocketmq.eventbridge.config.AppConfig;
 import org.apache.rocketmq.eventbridge.domain.model.source.EventSource;
 import org.apache.rocketmq.eventbridge.domain.model.source.HTTPEventSourceService;
 import org.apache.rocketmq.eventbridge.domain.rpc.HttpEventAPI;
 import org.apache.rocketmq.eventbridge.exception.EventBridgeException;
 import org.apache.rocketmq.eventbridge.tools.NetUtil;
 import org.apache.rocketmq.eventbridge.tools.transform.Data;
 import org.apache.rocketmq.eventbridge.tools.transform.StringData;
 import org.apache.rocketmq.eventbridge.tools.transform.Transform;
 import org.apache.rocketmq.eventbridge.tools.transform.TransformBuilder;
 import org.slf4j.Logger;
 import org.slf4j.LoggerFactory;
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.http.HttpHeaders;
 import org.springframework.http.HttpMethod;
 import org.springframework.http.server.reactive.ServerHttpRequest;
 import org.springframework.stereotype.Service;
 import org.springframework.util.CollectionUtils;

 import static org.apache.rocketmq.eventbridge.domain.common.exception.EventBridgeErrorCode.JSON_ATTRIBUTE_INVALID;
 import static org.apache.rocketmq.eventbridge.domain.common.exception.EventBridgeErrorCode.PutEventsRequestSecurityCheckFailed;
 import static org.apache.rocketmq.eventbridge.domain.model.source.HTTPEventSourceService.SECURITY_CONFIG_IP;
 import static org.apache.rocketmq.eventbridge.domain.model.source.HTTPEventSourceService.SECURITY_CONFIG_NONE;
 import static org.apache.rocketmq.eventbridge.domain.model.source.HTTPEventSourceService.SECURITY_CONFIG_REFERER;

 /**
  * @Author changfeng
  * @Date 2022/4/25 11:28 上午
  */
 @Service
 public class HttpEventConverter {
     private static final Logger logger = LoggerFactory.getLogger(HttpEventConverter.class);

     @Autowired
     HttpEventAPI httpEventAPI;
     @Autowired
     HTTPEventSourceService httpEventSourceService;

     private static final String HEADER_X_REAL_IP = "x-real-ip";
     private static final String TYPE = "eventbridge:Events:HTTPEvent";
     private static final String DATA_CONTENT_TYPE = "application/json";

     private static final String SECURITY_CONFIG = "SecurityConfig";
     private static final String IP_CONFIG = "Ip";
     private static final String METHOD_CONFIG = "Method";
     private static final String REFERER_CONFIG = "Referer";

     private static final Set<String> DISCARD_FIELDS = new HashSet<>();

     static {
         DISCARD_FIELDS.add("authorization");
         DISCARD_FIELDS.add("cookie");
         DISCARD_FIELDS.add("proxy-authorization");
     }

     public List<CloudEvent> toEventBridgeEvent(ServerHttpRequest request, byte[] body,
         Map<String, String> headers, String accountId, String token) {
         this.checkConfig(request, headers, accountId, token);

         CloudEvent cloudEvent = parseRequest(request, body, headers, accountId, token, null, null);

         return Collections.singletonList(cloudEvent);
     }

     private CloudEvent parseRequest(ServerHttpRequest request, byte[] body,
         Map<String, String> headers, String accountId, String token, String extractJson,
         String template) {
         EventSource eventSource = httpEventSourceService.getEventSourceByToken(accountId, token);
         HttpEventData httpEventData = getHttpEventData(request, body, headers, accountId, token);
         Map<String, Object> schema = parseSchema(httpEventData, extractJson, template);
         CloudEventBuilder builder = new CloudEventBuilder();
         String regionId = AppConfig.getLocalConfig().getRegion();
         CloudEventBuilder builderWithAttributes = addAttributes(regionId, accountId, eventSource.getName(), eventSource.getEventBusName(), schema, builder);
         CloudEventBuilder builderWithExtensions = addExtensions(request, regionId, accountId, headers, eventSource, builderWithAttributes);
         HttpEventData data = (HttpEventData) schema.get("data");
         CloudEventBuilder builderWithData = builderWithExtensions.withData(new Gson().toJson(data).getBytes(StandardCharsets.UTF_8));
         return builderWithData.build();
     }

     private CloudEventBuilder addAttributes(String regionId, String accountId, String sourceName, String busName,
         Map<String, Object> schema, CloudEventBuilder cloudEventBuilder) {
         CloudEventBuilder newBuilder = cloudEventBuilder.newBuilder();
         newBuilder.withId(UUID.randomUUID().toString())
             .withSource(URI.create(sourceName))
             .withDataContentType(DATA_CONTENT_TYPE)
             .withDataSchema(null);

         String subject = (String) schema.get("subject");
         String time = (String) schema.get("time");
         String type = (String) schema.get("type");

         if (StringUtils.isNotBlank(subject)) {
             newBuilder.withSubject(subject);
         } else {
             newBuilder.withSubject(httpEventAPI.generateSubject(regionId, accountId, busName, sourceName));
         }

         if (StringUtils.isNotBlank(time)) {
             newBuilder.withTime(OffsetDateTime.from(ZonedDateTime.parse(time)));
         } else {
             newBuilder.withTime(OffsetDateTime.from(ZonedDateTime.now()));

         }
         if (StringUtils.isNotBlank(type)) {
             newBuilder.withType(type);
         } else {
             newBuilder.withType(TYPE);
         }
         return newBuilder;
     }

     private CloudEventBuilder addExtensions(ServerHttpRequest request,
         String regionId,
         String accountId,
         Map<String, String> headers,
         EventSource eventSource, CloudEventBuilder cloudEventBuilder) {
         return httpEventAPI.addExtensions(request, regionId, accountId, headers, eventSource, cloudEventBuilder);
     }

     private void checkConfig(ServerHttpRequest request, Map<String, String> headers, String accountId, String token) {
         HttpMethod requestMethod = request.getMethod();
         String requestIp = request.getRemoteAddress().getAddress().getHostAddress();
         if (headers.containsKey(HEADER_X_REAL_IP)) {
             requestIp = headers.get(HEADER_X_REAL_IP);
         }
         String requestReferer = null;
         if (headers.containsKey(HttpHeaders.REFERER)) {
             requestReferer = headers.get(HttpHeaders.REFERER);
         }

         EventSource eventSource = httpEventSourceService.getEventSourceByToken(accountId, token);
         String securityConfig = (String) eventSource.getConfig().get(SECURITY_CONFIG);
         List<String> methods = (List<String>) eventSource.getConfig().get(METHOD_CONFIG);
         List<String> ips = (List<String>) eventSource.getConfig().get(IP_CONFIG);
         List<String> referers = (List<String>) eventSource.getConfig().get(REFERER_CONFIG);

         // request method check
         if (!CollectionUtils.isEmpty(methods) && !new HashSet<>(methods).contains(requestMethod.name())) {
             throw new EventBridgeException(PutEventsRequestSecurityCheckFailed, "request methods", methods, requestMethod);
         }

         if (SECURITY_CONFIG_NONE.equals(eventSource.getConfig().get(SECURITY_CONFIG))) {
             return;
         }

         // ip check
         if (SECURITY_CONFIG_IP.equals(securityConfig) && !CollectionUtils.isEmpty(ips)) {
             boolean matched = false;
             for (String ip : ips) {
                 if (StringUtils.equals(ip, requestIp) ||
                     (NetUtil.isNetSegment(ip) && new SubnetUtils(ip).getInfo().isInRange(requestIp))) {
                     matched = true;
                     break;
                 }
             }
             if (!matched) {
                 throw new EventBridgeException(PutEventsRequestSecurityCheckFailed, "sourceIP", ips, requestIp);
             }
         }

         // referer check
         if (SECURITY_CONFIG_REFERER.equals(securityConfig) && !CollectionUtils.isEmpty(referers)) {
             if (!new HashSet<>(referers).contains(requestReferer)) {
                 throw new EventBridgeException(PutEventsRequestSecurityCheckFailed, "secure domain", referers, requestReferer);
             }
         }
     }

     private HttpEventData getHttpEventData(ServerHttpRequest request, byte[] body, Map<String, String> headers,
         String accountId, String token) {
         HttpEventData httpEventData = new HttpEventData();
         HashMap<String, String> dataHeaders = new HashMap<>();
         headers.forEach((k, v) -> {
             if (!DISCARD_FIELDS.contains(k)) {
                 dataHeaders.put(k, v);
             }
         });

         Object bodyContent = new String(body);
         HashMap<String, String> temp = new HashMap<>();
         dataHeaders.forEach((k, v) -> {
             temp.put(k.toLowerCase(), v);
         });
         try {
             String contentType = temp.get("content-type");
             if (StringUtils.isNotBlank(contentType)) {
                 MediaType type = MediaType.parse(contentType);
                 if (type.toString().contains("application/json")) {
                     bodyContent = new Gson().fromJson((String) bodyContent, new TypeToken<Map<String, ?>>() {
                     }.getType());
                 }
             }
         } catch (Exception e) {
             logger.warn("GenerateEBHttpEventData failed. Http content is not a valid json format. accountId={}, token={}, content-type={}",
                 accountId, token, temp.get("content-type"), e);
             throw new EventBridgeException(JSON_ATTRIBUTE_INVALID);
         }
         httpEventData.setBody(bodyContent);
         httpEventData.setHeaders(dataHeaders);
         httpEventData.setHttpMethod(request.getMethod().toString());
         httpEventData.setPath(request.getPath().pathWithinApplication().value());

         HashMap<String, String> queryParam = new HashMap<>();
         request.getQueryParams().forEach((k, v) -> {
             if (!StringUtils.equals("token", k)) {
                 queryParam.put(k, v.get(0));
             }
         });
         httpEventData.setQueryString(queryParam);
         return httpEventData;
     }

     private Map<String, Object> parseSchema(HttpEventData httpEventData, String extractJson, String template) {
         // If schema is not defined, default logic is executed
         if (StringUtils.isBlank(template)) {
             HashMap<String, Object> result = new HashMap<>();
             result.put("data", httpEventData);
             return result;
         }
         Transform transform = TransformBuilder.buildTemplateTransForm(extractJson, template);
         StringData stringData = new StringData(new Gson().toJson(httpEventData));
         Data output = transform.process(stringData);
         Type mapType = new TypeToken<Map<String, Object>>() {
         }.getType();
         Map<String, Object> objectMap = new Gson().fromJson(output.toString(), mapType);
         Map<String, Object> templateData = (Map<String, Object>) objectMap.get("data");
         // If data is not defined in the template, the default logic is executed
         if (templateData == null) {
             objectMap.put("data", httpEventData);
         }
         return objectMap;
     }
 }
