<?php

// This file is auto-generated, don't edit it. Thanks.
namespace RocketMQ\Eventbridge\SDK\Models;

use AlibabaCloud\Tea\Model;

class GetEventBusResponseBody extends Model {
    protected $_name = [
        'code' => 'code',
        'createTimestamp' => 'createTimestamp',
        'description' => 'description',
        'eventBusName' => 'eventBusName',
        'message' => 'message',
        'requestId' => 'requestId',
    ];
    public function validate() {}
    public function toMap() {
        $res = [];
        if (null !== $this->code) {
            $res['code'] = $this->code;
        }
        if (null !== $this->createTimestamp) {
            $res['createTimestamp'] = $this->createTimestamp;
        }
        if (null !== $this->description) {
            $res['description'] = $this->description;
        }
        if (null !== $this->eventBusName) {
            $res['eventBusName'] = $this->eventBusName;
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
     * @return GetEventBusResponseBody
     */
    public static function fromMap($map = []) {
        $model = new self();
        if(isset($map['code'])){
            $model->code = $map['code'];
        }
        if(isset($map['createTimestamp'])){
            $model->createTimestamp = $map['createTimestamp'];
        }
        if(isset($map['description'])){
            $model->description = $map['description'];
        }
        if(isset($map['eventBusName'])){
            $model->eventBusName = $map['eventBusName'];
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
     * @description The response code. The value Success indicates that the request is successful.
     * @example Success
     * @var string
     */
    public $code;

    /**
     * @description The timestamp that indicates when the event bus was created.
     * @example 1641781825000
     * @var int
     */
    public $createTimestamp;

    /**
     * @description The description of the event bus.
     * @example demo
     * @var string
     */
    public $description;

    /**
     * @description The name of the event bus.
     * @example MyEventBus
     * @var string
     */
    public $eventBusName;

    /**
     * @description The error message that is returned if the request failed.
     * @example EventBusNotExist
     * @var string
     */
    public $message;

    /**
     * @description The request ID.
     * @example d5bfc188-4452-4ba7-b73a-a9005e522439
     * @var string
     */
    public $requestId;

}
