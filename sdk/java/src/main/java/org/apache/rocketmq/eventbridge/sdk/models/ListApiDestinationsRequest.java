// This file is auto-generated, don't edit it. Thanks.
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
package org.apache.rocketmq.eventbridge.sdk.models;

import com.aliyun.tea.*;

public class ListApiDestinationsRequest extends TeaModel {
    /**
     * <p>The prefix of the API destination name.</p>
     * 
     * <strong>example:</strong>
     * <p>api-demo</p>
     */
    @NameInMap("apiDestinationNamePrefix")
    public String apiDestinationNamePrefix;

    /**
     * <p>The connection name.</p>
     * 
     * <strong>example:</strong>
     * <p>connection-name</p>
     */
    @NameInMap("connectionName")
    public String connectionName;

    /**
     * <p>The maximum number of entries to be returned in a call. You can use this parameter and NextToken to implement paging. </p>
     * <pre><code>*   Default value: 10.
     * </code></pre>
     * 
     * <strong>example:</strong>
     * <p>10</p>
     */
    @NameInMap("maxResults")
    public Integer maxResults;

    /**
     * <p>If you set Limit and excess return values exist, this parameter is returned.</p>
     * <pre><code>*   Default value: 0.
     * </code></pre>
     * 
     * <strong>example:</strong>
     * <p>0</p>
     */
    @NameInMap("nextToken")
    public String nextToken;

    public static ListApiDestinationsRequest build(java.util.Map<String, ?> map) throws Exception {
        ListApiDestinationsRequest self = new ListApiDestinationsRequest();
        return TeaModel.build(map, self);
    }

    public ListApiDestinationsRequest setApiDestinationNamePrefix(String apiDestinationNamePrefix) {
        this.apiDestinationNamePrefix = apiDestinationNamePrefix;
        return this;
    }
    public String getApiDestinationNamePrefix() {
        return this.apiDestinationNamePrefix;
    }

    public ListApiDestinationsRequest setConnectionName(String connectionName) {
        this.connectionName = connectionName;
        return this;
    }
    public String getConnectionName() {
        return this.connectionName;
    }

    public ListApiDestinationsRequest setMaxResults(Integer maxResults) {
        this.maxResults = maxResults;
        return this;
    }
    public Integer getMaxResults() {
        return this.maxResults;
    }

    public ListApiDestinationsRequest setNextToken(String nextToken) {
        this.nextToken = nextToken;
        return this;
    }
    public String getNextToken() {
        return this.nextToken;
    }

}
