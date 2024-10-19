<?php

// This file is auto-generated, don't edit it. Thanks.
namespace RocketMQ\Eventbridge\SDK\Models;

use AlibabaCloud\Tea\Model;

class GetEventBusRequest extends Model {
    protected $_name = [
        'eventBusName' => 'eventBusName',
    ];
    public function validate() {}
    public function toMap() {
        $res = [];
        if (null !== $this->eventBusName) {
            $res['eventBusName'] = $this->eventBusName;
        }
        return $res;
    }
    /**
     * @param array $map
     * @return GetEventBusRequest
     */
    public static function fromMap($map = []) {
        $model = new self();
        if(isset($map['eventBusName'])){
            $model->eventBusName = $map['eventBusName'];
        }
        return $model;
    }
    /**
     * @description The name of the event bus. This parameter is required.
     * @example MyEventBus
     * @var string
     */
    public $eventBusName;

}
