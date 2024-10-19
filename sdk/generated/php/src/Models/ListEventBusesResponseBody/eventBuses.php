<?php

// This file is auto-generated, don't edit it. Thanks.
namespace RocketMQ\Eventbridge\SDK\Models\ListEventBusesResponseBody;

use AlibabaCloud\Tea\Model;

class eventBuses extends Model {
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
     * @return eventBuses
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
     * @description The description of the queried event bus.
     * @example bus_description
     * @var string
     */
    public $description;

    /**
     * @description The name of the queried event bus.
     * @example default
     * @var string
     */
    public $eventBusName;

}
