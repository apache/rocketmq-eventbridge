<?php

// This file is auto-generated, don't edit it. Thanks.
namespace RocketMQ\Eventbridge\SDK\Models;

use AlibabaCloud\Tea\Model;

class ListApiDestinationsRequest extends Model {
    protected $_name = [
        'apiDestinationNamePrefix' => 'apiDestinationNamePrefix',
        'connectionName' => 'connectionName',
        'maxResults' => 'maxResults',
        'nextToken' => 'nextToken',
    ];
    public function validate() {}
    public function toMap() {
        $res = [];
        if (null !== $this->apiDestinationNamePrefix) {
            $res['apiDestinationNamePrefix'] = $this->apiDestinationNamePrefix;
        }
        if (null !== $this->connectionName) {
            $res['connectionName'] = $this->connectionName;
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
     * @return ListApiDestinationsRequest
     */
    public static function fromMap($map = []) {
        $model = new self();
        if(isset($map['apiDestinationNamePrefix'])){
            $model->apiDestinationNamePrefix = $map['apiDestinationNamePrefix'];
        }
        if(isset($map['connectionName'])){
            $model->connectionName = $map['connectionName'];
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
     * @description The prefix of the API destination name.
     * @example api-demo
     * @var string
     */
    public $apiDestinationNamePrefix;

    /**
     * @description The connection name.
     * @example connection-name
     * @var string
     */
    public $connectionName;

    /**
     * @description The maximum number of entries to be returned in a call. You can use this parameter and NextToken to implement paging. 

    *   Default value: 10.
     * @example 10
     * @var int
     */
    public $maxResults;

    /**
     * @description If you set Limit and excess return values exist, this parameter is returned.

    *   Default value: 0.
     * @example 0
     * @var string
     */
    public $nextToken;

}
