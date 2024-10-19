<?php

// This file is auto-generated, don't edit it. Thanks.
namespace RocketMQ\Eventbridge\SDK\Models;

use AlibabaCloud\Tea\Model;

use RocketMQ\Eventbridge\SDK\Models\ListEventTypesResponseBody\eventTypes;

class ListEventTypesResponseBody extends Model {
    protected $_name = [
        'eventTypes' => 'eventTypes',
        'nextToken' => 'nextToken',
        'total' => 'total',
        'maxResults' => 'maxResults',
        'code' => 'code',
        'message' => 'message',
        'requestId' => 'requestId',
    ];
    public function validate() {}
    public function toMap() {
        $res = [];
        if (null !== $this->eventTypes) {
            $res['eventTypes'] = [];
            if(null !== $this->eventTypes && is_array($this->eventTypes)){
                $n = 0;
                foreach($this->eventTypes as $item){
                    $res['eventTypes'][$n++] = null !== $item ? $item->toMap() : $item;
                }
            }
        }
        if (null !== $this->nextToken) {
            $res['nextToken'] = $this->nextToken;
        }
        if (null !== $this->total) {
            $res['total'] = $this->total;
        }
        if (null !== $this->maxResults) {
            $res['maxResults'] = $this->maxResults;
        }
        if (null !== $this->code) {
            $res['code'] = $this->code;
        }
        if (null !== $this->message) {
            $res['message'] = $this->message;
        }
        if (null !== $this->requestId) {
            $res['requestId'] = $this->requestId;
        }
        return $res;
    }
    /**
     * @param array $map
     * @return ListEventTypesResponseBody
     */
    public static function fromMap($map = []) {
        $model = new self();
        if(isset($map['eventTypes'])){
            if(!empty($map['eventTypes'])){
                $model->eventTypes = [];
                $n = 0;
                foreach($map['eventTypes'] as $item) {
                    $model->eventTypes[$n++] = null !== $item ? eventTypes::fromMap($item) : $item;
                }
            }
        }
        if(isset($map['nextToken'])){
            $model->nextToken = $map['nextToken'];
        }
        if(isset($map['total'])){
            $model->total = $map['total'];
        }
        if(isset($map['maxResults'])){
            $model->maxResults = $map['maxResults'];
        }
        if(isset($map['code'])){
            $model->code = $map['code'];
        }
        if(isset($map['message'])){
            $model->message = $map['message'];
        }
        if(isset($map['requestId'])){
            $model->requestId = $map['requestId'];
        }
        return $model;
    }
    /**
     * @var eventTypes[]
     */
    public $eventTypes;

    /**
     * @description If excess return values exist, this parameter is returned.
     * @example 10
     * @var string
     */
    public $nextToken;

    /**
     * @description The total number of entries.
     * @example 2
     * @var int
     */
    public $total;

    /**
     * @description If you set Limit and excess return values exist, this parameter is returned.
     * @example 10
     * @var int
     */
    public $maxResults;

    /**
     * @description The status code returned. The status code 200 indicates that the request was successful.
     * @example 200
     * @var string
     */
    public $code;

    /**
     * @description The error message that is returned if the request failed.
     * @example EventBusNotExist
     * @var string
     */
    public $message;

    /**
     * @description The request ID.
     * @example 580A938B-6107-586C-8EC7-F22EEBEDA9E6
     * @var string
     */
    public $requestId;

}
