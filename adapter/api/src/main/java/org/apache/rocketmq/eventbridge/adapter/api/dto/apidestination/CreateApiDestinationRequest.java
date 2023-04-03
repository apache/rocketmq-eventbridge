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

package org.apache.rocketmq.eventbridge.adapter.api.dto.apidestination;

import com.google.gson.annotations.SerializedName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.rocketmq.eventbridge.adapter.api.dto.BaseResponse;
import org.apache.rocketmq.eventbridge.domain.model.apidestination.parameter.HttpApiParameters;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
@ToString
public class CreateApiDestinationRequest extends BaseResponse {

    @Pattern(regexp = "^[A-Za-z|0-9][A-Za-z|0-9|_|-]+$", message = "The ApiDestination name is invalid! Only letters a~z or A~Z, numbers 0~9, underscore (_) and dash (-) are supported.")
    @Length(min = 1, max = 127, message = "The ApiDestination name length cannot exceed 127.")
    @NotBlank(message = "ApiDestinationName is blank")
    @SerializedName("ApiDestinationName")
    private String apiDestinationName;

    @SerializedName("ConnectionName")
    @Pattern(regexp = "^[A-Za-z|0-9][A-Za-z|0-9|_|-]+$", message = "The Connection name is invalid! Only letters a~z or A~Z, numbers 0~9, underscore (_) and dash (-) are supported.")
    @Length(min = 1, max = 127, message = "The connection name length cannot exceed 127.")
    @NotBlank(message = "ConnectionName is blank.")
    private String connectionName;

    @SerializedName("Description")
    @Length(max = 255, message = "The ApiDestination description length cannot exceed 255.")
    private String description;

    @SerializedName("HttpApiParameters")
    private HttpApiParameters httpApiParameters;

    @SerializedName("InvocationRateLimitPerSecond")
    private Integer invocationRateLimitPerSecond;
}
