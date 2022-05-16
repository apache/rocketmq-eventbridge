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

package org.apache.rocketmq.eventbridge.adapter.api.dto.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Map;

/**
 * @Author changfeng
 * @Date 2022/4/25 11:27 上午
 */
@Data
public class HttpEventData {
    @JsonProperty("Body")
    private Object body;

    @JsonProperty("Headers")
    private Map<String, String> headers;

    @JsonProperty("HttpMethod")
    private String httpMethod;

    @JsonProperty("Path")
    private String path;

    @JsonProperty("QueryString")
    private Map<String, String> queryString;

}
