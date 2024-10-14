<?php

// This file is auto-generated, don't edit it. Thanks.
namespace RocketMQ\Eventbridge\SDK\Models;

use AlibabaCloud\Tea\Model;

/**
 * EventData Controller apis:
 *     * putEvents
 */
class PutEventsRequest extends Model {
    protected $_name = [
        'eventBusName' => 'eventBusName',
        'event' => 'event',
    ];
    public function validate() {}
    public function toMap() {
        $res = [];
        if (null !== $this->eventBusName) {
            $res['eventBusName'] = $this->eventBusName;
        }
        if (null !== $this->event) {
            $res['event'] = $this->event;
        }
        return $res;
    }
    /**
     * @param array $map
     * @return PutEventsRequest
     */
    public static function fromMap($map = []) {
        $model = new self();
        if(isset($map['eventBusName'])){
            $model->eventBusName = $map['eventBusName'];
        }
        if(isset($map['event'])){
            $model->event = $map['event'];
        }
        return $model;
    }
    /**
     * @description The name of the event bus.
This parameter is required.
     * @example demo
     * @var string
     */
    public $eventBusName;

    /**
     * @description The content of the event.
     * @example The description of the event.
     * @var string
     */
    public $event;

}
