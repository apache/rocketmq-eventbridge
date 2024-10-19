// This file is auto-generated, don't edit it. Thanks.

using System;
using System.Collections.Generic;
using System.IO;

using Tea;

namespace RocketMQ.Eventbridge.SDK.Models
{
    public class ListConnectionsRequest : TeaModel {
        /// <summary>
        /// <para>The key word that you specify to query connections. Connections can be queried by prefixes.</para>
        /// 
        /// <b>Example:</b>
        /// <para>connection-name</para>
        /// </summary>
        [NameInMap("connectionNamePrefix")]
        [Validation(Required=false)]
        public string ConnectionNamePrefix { get; set; }

        /// <summary>
        /// <para>The maximum number of entries to be returned in a single call. You can use this parameter and the NextToken parameter to implement paging.</para>
        /// <pre><c>*   Default value: 10.
        /// </c></pre>
        /// 
        /// <b>Example:</b>
        /// <para>10</para>
        /// </summary>
        [NameInMap("maxResults")]
        [Validation(Required=false)]
        public int? MaxResults { get; set; }

        /// <summary>
        /// <para>If you set the Limit parameter and excess return values exist, this parameter is returned.</para>
        /// <pre><c>*   Default value: 0.
        /// </c></pre>
        /// 
        /// <b>Example:</b>
        /// <para>0</para>
        /// </summary>
        [NameInMap("nextToken")]
        [Validation(Required=false)]
        public string NextToken { get; set; }

    }

}
