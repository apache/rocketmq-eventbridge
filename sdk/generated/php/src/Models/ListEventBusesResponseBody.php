<?php

// This file is auto-generated, don't edit it. Thanks.
namespace RocketMQ\Eventbridge\SDK\Models;

use AlibabaCloud\Tea\Model;

use RocketMQ\Eventbridge\SDK\Models\ListEventBusesResponseBody\eventBuses;

class ListEventBusesResponseBody extends Model {
    protected $_name = [
        'code' => 'code',
        'eventBuses' => 'eventBuses',
        'message' => 'message',
        'requestId' => 'requestId',
        'nextToken' => 'nextToken',
        'total' => 'total',
        'maxResults' => 'maxResults',
    ];
    public function validate() {}
    public function toMap() {
        $res = [];
        if (null !== $this->code) {
            $res['code'] = $this->code;
        }
        if (null !== $this->eventBuses) {
            $res['eventBuses'] = [];
            if(null !== $this->eventBuses && is_array($this->eventBuses)){
                $n = 0;
                foreach($this->eventBuses as $item){
                    $res['eventBuses'][$n++] = null !== $item ? $item->toMap() : $item;
                }
            }
        }
        if (null !== $this->message) {
            $res['message'] = $this->message;
        }
        if (null !== $this->requestId) {
            $res['requestId'] = $this->requestId;
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
        return $res;
    }
    /**
     * @param array $map
     * @return ListEventBusesResponseBody
     */
    public static function fromMap($map = []) {
        $model = new self();
        if(isset($map['code'])){
            $model->code = $map['code'];
        }
        if(isset($map['eventBuses'])){
            if(!empty($map['eventBuses'])){
                $model->eventBuses = [];
                $n = 0;
                foreach($map['eventBuses'] as $item) {
                    $model->eventBuses[$n++] = null !== $item ? eventBuses::fromMap($item) : $item;
                }
            }
        }
        if(isset($map['message'])){
            $model->message = $map['message'];
        }
        if(isset($map['requestId'])){
            $model->requestId = $map['requestId'];
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
        return $model;
    }
    /**
     * @description The returned HTTP status code. The HTTP status code 200 indicates that the request is successful.
     * @example 200
     * @var string
     */
    public $code;

    /**
     * @description The timestamp that indicates when the event bus was created.
     * @var eventBuses[]
     */
    public $eventBuses;

    /**
     * @description The returned error message.
     * @example InvalidArgument
     * @var string
     */
    public $message;

    /**
     * @description The request ID.
     * @example D1DCF64A-3F2C-5323-ADCB-3F4DF30FAD2D
     * @var string
     */
    public $requestId;

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

}
