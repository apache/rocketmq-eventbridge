<?php

// This file is auto-generated, don't edit it. Thanks.
namespace RocketMQ\Eventbridge\SDK\Models;

use AlibabaCloud\Tea\Model;

class ListConnectionsRequest extends Model {
    protected $_name = [
        'connectionNamePrefix' => 'connectionNamePrefix',
        'maxResults' => 'maxResults',
        'nextToken' => 'nextToken',
    ];
    public function validate() {}
    public function toMap() {
        $res = [];
        if (null !== $this->connectionNamePrefix) {
            $res['connectionNamePrefix'] = $this->connectionNamePrefix;
        }
        if (null !== $this->maxResults) {
            $res['maxResults'] = $this->maxResults;
        }
        if (null !== $this->nextToken) {
            $res['nextToken'] = $this->nextToken;
        }
        return $res;
    }
    /**
     * @param array $map
     * @return ListConnectionsRequest
     */
    public static function fromMap($map = []) {
        $model = new self();
        if(isset($map['connectionNamePrefix'])){
            $model->connectionNamePrefix = $map['connectionNamePrefix'];
        }
        if(isset($map['maxResults'])){
            $model->maxResults = $map['maxResults'];
        }
        if(isset($map['nextToken'])){
            $model->nextToken = $map['nextToken'];
        }
        return $model;
    }
    /**
     * @description The key word that you specify to query connections. Connections can be queried by prefixes.
     * @example connection-name
     * @var string
     */
    public $connectionNamePrefix;

    /**
     * @description The maximum number of entries to be returned in a single call. You can use this parameter and the NextToken parameter to implement paging.

    *   Default value: 10.
     * @example 10
     * @var int
     */
    public $maxResults;

    /**
     * @description If you set the Limit parameter and excess return values exist, this parameter is returned.

    *   Default value: 0.
     * @example 0
     * @var string
     */
    public $nextToken;

}
