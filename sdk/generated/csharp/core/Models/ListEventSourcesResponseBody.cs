// This file is auto-generated, don't edit it. Thanks.

using System;
using System.Collections.Generic;
using System.IO;

using Tea;

namespace RocketMQ.Eventbridge.SDK.Models
{
    public class ListEventSourcesResponseBody : TeaModel {
        [NameInMap("eventSources")]
        [Validation(Required=false)]
        public List<ListEventSourcesResponseBodyEventSources> EventSources { get; set; }
        public class ListEventSourcesResponseBodyEventSources : TeaModel {
            /// <summary>
            /// <para>The name of the event bus.
            /// This parameter is required.</para>
            /// 
            /// <b>Example:</b>
            /// <para>demo</para>
            /// </summary>
            [NameInMap("eventBusName")]
            [Validation(Required=false)]
            public string EventBusName { get; set; }

            /// <summary>
            /// <para>EventSource is required for querying default bus events.</para>
            /// 
            /// <b>Example:</b>
            /// <para>testEventSourceName</para>
            /// </summary>
            [NameInMap("eventSourceName")]
            [Validation(Required=false)]
            public string EventSourceName { get; set; }

            /// <summary>
            /// <para>The description of the event type.</para>
            /// 
            /// <b>Example:</b>
            /// <para>The description of the event type.</para>
            /// </summary>
            [NameInMap("description")]
            [Validation(Required=false)]
            public string Description { get; set; }

            [NameInMap("className")]
            [Validation(Required=false)]
            public string ClassName { get; set; }

            [NameInMap("config")]
            [Validation(Required=false)]
            public Dictionary<string, object> Config { get; set; }

            [NameInMap("gmtCreate")]
            [Validation(Required=false)]
            public string GmtCreate { get; set; }

            [NameInMap("gmtModify")]
            [Validation(Required=false)]
            public string GmtModify { get; set; }

        }

        /// <summary>
        /// <para>The total number of entries.</para>
        /// 
        /// <b>Example:</b>
        /// <para>2</para>
        /// </summary>
        [NameInMap("total")]
        [Validation(Required=false)]
        public int? Total { get; set; }

        /// <summary>
        /// <para>The number of entries returned per page.</para>
        /// 
        /// <b>Example:</b>
        /// <para>10</para>
        /// </summary>
        [NameInMap("maxResults")]
        [Validation(Required=false)]
        public int? MaxResults { get; set; }

        /// <summary>
        /// <para>If excess return values exist, this parameter is returned.</para>
        /// 
        /// <b>Example:</b>
        /// <para>0</para>
        /// </summary>
        [NameInMap("nextToken")]
        [Validation(Required=false)]
        public string NextToken { get; set; }

    }

}
