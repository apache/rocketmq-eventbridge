<?php

// This file is auto-generated, don't edit it. Thanks.
namespace RocketMQ\Eventbridge\SDK\Models;

use AlibabaCloud\Tea\Model;

class ListEventRulesRequest extends Model {
    protected $_name = [
        'eventBusName' => 'eventBusName',
        'maxResults' => 'maxResults',
        'nextToken' => 'nextToken',
    ];
    public function validate() {}
    public function toMap() {
        $res = [];
        if (null !== $this->eventBusName) {
            $res['eventBusName'] = $this->eventBusName;
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
     * @return ListEventRulesRequest
     */
    public static function fromMap($map = []) {
        $model = new self();
        if(isset($map['eventBusName'])){
            $model->eventBusName = $map['eventBusName'];
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
     * @var string
     */
    public $eventBusName;

    /**
     * @description The number of entries returned per page.
     * @example 10
     * @var int
     */
    public $maxResults;

    /**
     * @description If excess return values exist, this parameter is returned.
     * @example 0
     * @var string
     */
    public $nextToken;

}
