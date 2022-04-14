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

package org.apache.rocketmq.eventbridge.adapter.api.dto.rule;

import java.util.Date;
import java.util.List;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;
import org.apache.rocketmq.eventbridge.adapter.api.dto.BaseResponse;
import org.apache.rocketmq.eventbridge.adapter.api.dto.target.EventTargetDTO;

@Builder
public @Data
class GetRuleResponse extends BaseResponse {
    @SerializedName("EventBusName")
    private String eventBusName;

    @SerializedName("EventRuleName")
    private String eventRuleName;

    @SerializedName("Description")
    private String description;

    @SerializedName("FilterPattern")
    private String filterPattern;

    @SerializedName("Status")
    private String status;

    @SerializedName("GmtCreate")
    private Date gmtCreate;

    @SerializedName("GmtModify")
    private Date gmtModify;

    @SerializedName("EventTargets")
    private List<EventTargetDTO> eventTargets;
}
