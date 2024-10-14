<?php

// This file is auto-generated, don't edit it. Thanks.
namespace RocketMQ\Eventbridge\SDK\Models;

use AlibabaCloud\Tea\Model;

class CreateEventBusResponseBody extends Model {
    protected $_name = [
        'code' => 'code',
        'eventBusName' => 'eventBusName',
        'message' => 'message',
        'requestId' => 'requestId',
        'success' => 'success',
    ];
    public function validate() {}
    public function toMap() {
        $res = [];
        if (null !== $this->code) {
            $res['code'] = $this->code;
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
        if (null !== $this->success) {
            $res['success'] = $this->success;
        }
        return $res;
    }
    /**
     * @param array $map
     * @return CreateEventBusResponseBody
     */
    public static function fromMap($map = []) {
        $model = new self();
        if(isset($map['code'])){
            $model->code = $map['code'];
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
        if(isset($map['success'])){
            $model->success = $map['success'];
        }
        return $model;
    }
    /**
     * @description The returned response code. The value Success indicates that the request is successful. Other values indicate that the request failed. For more information about error codes, see Error codes.
     * @example Success
     * @var string
     */
    public $code;

    /**
     * @description The name of the event bus. This parameter is required.
     * @example MyEventBus
     * @var string
     */
    public $eventBusName;

    /**
     * @description The returned error message.
     * @example The event bus [xxxx] not existed!
     * @var string
     */
    public $message;

    /**
     * @description The request ID.
     * @example A995F07C-E503-5881-9962-9CECA8566876
     * @var string
     */
    public $requestId;

    /**
     * @description Indicates whether the request is successful. The value true indicates that the request is successful.
     * @example true
     * @var bool
     */
    public $success;

}
