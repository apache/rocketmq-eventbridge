// This file is auto-generated, don't edit it. Thanks.
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
