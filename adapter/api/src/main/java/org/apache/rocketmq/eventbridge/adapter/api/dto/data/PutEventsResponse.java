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

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import org.apache.rocketmq.eventbridge.adapter.api.dto.BaseResponse;
import org.apache.rocketmq.eventbridge.domain.model.data.PutEventsResponseEntry;

public class PutEventsResponse extends BaseResponse {

    @SerializedName("FailedEntryCount")
    private int failedEntryCount;

    @SerializedName("EntryList")
    private List<PutEventsResponseEntry> entryList = new ArrayList<>();

    public int getFailedEntryCount() {
        return failedEntryCount;
    }

    public void setFailedEntryCount(int failedEntryCount) {
        this.failedEntryCount = failedEntryCount;
    }

    public List<PutEventsResponseEntry> getEntryList() {
        return entryList;
    }

    public void setEntryList(List<PutEventsResponseEntry> entryList) {
        this.entryList = entryList;
    }
}
