<?php

// This file is auto-generated, don't edit it. Thanks.
namespace RocketMQ\Eventbridge\SDK\Models;

use AlibabaCloud\Tea\Model;

class DeleteEventSourceRequest extends Model {
    protected $_name = [
        'eventBusName' => 'eventBusName',
        'eventSourceName' => 'eventSourceName',
    ];
    public function validate() {}
    public function toMap() {
        $res = [];
        if (null !== $this->eventBusName) {
            $res['eventBusName'] = $this->eventBusName;
        }
        if (null !== $this->eventSourceName) {
            $res['eventSourceName'] = $this->eventSourceName;
        }
        return $res;
    }
    /**
     * @param array $map
     * @return DeleteEventSourceRequest
     */
    public static function fromMap($map = []) {
        $model = new self();
        if(isset($map['eventBusName'])){
            $model->eventBusName = $map['eventBusName'];
        }
        if(isset($map['eventSourceName'])){
            $model->eventSourceName = $map['eventSourceName'];
        }
        return $model;
    }
    /**
     * @var string
     */
    public $eventBusName;

    /**
     * @description The name of the event source.
This parameter is required.
     * @example myrabbitmq.source
     * @var string
     */
    public $eventSourceName;

}
