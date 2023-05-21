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
import javax.validation.constraints.Min;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.commons.lang3.StringUtils;
import org.apache.rocketmq.eventbridge.adapter.api.dto.BaseResponse;

@Getter
@Setter
@ToString
public class ListApiDestinationsRequest extends BaseResponse {

    @SerializedName("ApiDestinationNamePrefix")
    private String apiDestinationNamePrefix;

    @SerializedName("ConnectionName")
    private String connectionName;


    @Min(value = 0, message = "The limit size of page is invalid, which must greater than 0 and less than [{0}].")
    @SerializedName("MaxResults")
    private Integer maxResults;

    @SerializedName("NextToken")
    private String nextToken;

    public void checkMaxResultsAndNextToken() {
        if (StringUtils.isBlank(this.getNextToken())) {
            this.setNextToken("0");
        }
        if (this.getMaxResults() == null) {
            this.setMaxResults(10);
        }
    }
}
