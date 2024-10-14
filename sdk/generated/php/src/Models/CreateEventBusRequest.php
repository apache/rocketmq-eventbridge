<?php

// This file is auto-generated, don't edit it. Thanks.
namespace RocketMQ\Eventbridge\SDK\Models;

use AlibabaCloud\Tea\Model;

/**
 * EventBus Controller apis:
 *     * createEventBus *
 *     * getEventBus    *
 *     * deleteEventBus *
 *     * listEventBuses *
 */
class CreateEventBusRequest extends Model {
    protected $_name = [
        'description' => 'description',
        'eventBusName' => 'eventBusName',
    ];
    public function validate() {}
    public function toMap() {
        $res = [];
        if (null !== $this->description) {
            $res['description'] = $this->description;
        }
        if (null !== $this->eventBusName) {
            $res['eventBusName'] = $this->eventBusName;
        }
        return $res;
    }
    /**
     * @param array $map
     * @return CreateEventBusRequest
     */
    public static function fromMap($map = []) {
        $model = new self();
        if(isset($map['description'])){
            $model->description = $map['description'];
        }
        if(isset($map['eventBusName'])){
            $model->eventBusName = $map['eventBusName'];
        }
        return $model;
    }
    /**
     * @description The description of the event bus.
     * @example demo
     * @var string
     */
    public $description;

    /**
     * @description The name of the event bus. This parameter is required.
     * @example MyEventBus
     * @var string
     */
    public $eventBusName;

}
