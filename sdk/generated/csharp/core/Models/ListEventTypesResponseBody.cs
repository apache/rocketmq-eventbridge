// This file is auto-generated, don't edit it. Thanks.

using System;
using System.Collections.Generic;
using System.IO;

using Tea;

namespace RocketMQ.Eventbridge.SDK.Models
{
    public class ListEventTypesResponseBody : TeaModel {
        [NameInMap("eventTypes")]
        [Validation(Required=false)]
        public List<ListEventTypesResponseBodyEventTypes> EventTypes { get; set; }
        public class ListEventTypesResponseBodyEventTypes : TeaModel {
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
            /// <para>The name of the event type.</para>
            /// </summary>
            [NameInMap("eventTypeName")]
            [Validation(Required=false)]
            public string EventTypeName { get; set; }

            /// <summary>
            /// <para>The description of the event type.</para>
            /// 
            /// <b>Example:</b>
            /// <para>The description of the event type.</para>
            /// </summary>
            [NameInMap("description")]
            [Validation(Required=false)]
            public string Description { get; set; }

            [NameInMap("gmtCreate")]
            [Validation(Required=false)]
            public string GmtCreate { get; set; }

            [NameInMap("gmtModify")]
            [Validation(Required=false)]
            public string GmtModify { get; set; }

        }

        /// <summary>
        /// <para>If excess return values exist, this parameter is returned.</para>
        /// 
        /// <b>Example:</b>
        /// <para>10</para>
        /// </summary>
        [NameInMap("nextToken")]
        [Validation(Required=false)]
        public string NextToken { get; set; }

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
        /// <para>If you set Limit and excess return values exist, this parameter is returned.</para>
        /// 
        /// <b>Example:</b>
        /// <para>10</para>
        /// </summary>
        [NameInMap("maxResults")]
        [Validation(Required=false)]
        public int? MaxResults { get; set; }

        /// <summary>
        /// <para>The status code returned. The status code 200 indicates that the request was successful.</para>
        /// 
        /// <b>Example:</b>
        /// <para>200</para>
        /// </summary>
        [NameInMap("code")]
        [Validation(Required=false)]
        public string Code { get; set; }

        /// <summary>
        /// <para>The error message that is returned if the request failed.</para>
        /// 
        /// <b>Example:</b>
        /// <para>EventBusNotExist</para>
        /// </summary>
        [NameInMap("message")]
        [Validation(Required=false)]
        public string Message { get; set; }

        /// <summary>
        /// <para>The request ID.</para>
        /// 
        /// <b>Example:</b>
        /// <para>580A938B-6107-586C-8EC7-F22EEBEDA9E6</para>
        /// </summary>
        [NameInMap("requestId")]
        [Validation(Required=false)]
        public string RequestId { get; set; }

    }

}
