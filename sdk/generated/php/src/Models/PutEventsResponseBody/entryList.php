<?php

// This file is auto-generated, don't edit it. Thanks.
namespace RocketMQ\Eventbridge\SDK\Models\PutEventsResponseBody;

use AlibabaCloud\Tea\Model;

class entryList extends Model {
    protected $_name = [
        'eventId' => 'eventId',
        'errorCode' => 'errorCode',
        'errorMessage' => 'errorMessage',
    ];
    public function validate() {}
    public function toMap() {
        $res = [];
        if (null !== $this->eventId) {
            $res['eventId'] = $this->eventId;
        }
        if (null !== $this->errorCode) {
            $res['errorCode'] = $this->errorCode;
        }
        if (null !== $this->errorMessage) {
            $res['errorMessage'] = $this->errorMessage;
        }
        return $res;
    }
    /**
     * @param array $map
     * @return entryList
     */
    public static function fromMap($map = []) {
        $model = new self();
        if(isset($map['eventId'])){
            $model->eventId = $map['eventId'];
        }
        if(isset($map['errorCode'])){
            $model->errorCode = $map['errorCode'];
        }
        if(isset($map['errorMessage'])){
            $model->errorMessage = $map['errorMessage'];
        }
        return $model;
    }
    /**
     * @description The event ID.
     * @example a5747e4f-2af2-40b6-b262-d0140e995bf7
     * @var string
     */
    public $eventId;

    /**
     * @description The returned error code.
     * @var string
     */
    public $errorCode;

    /**
     * @description The returned error message.
     * @var string
     */
    public $errorMessage;

}
