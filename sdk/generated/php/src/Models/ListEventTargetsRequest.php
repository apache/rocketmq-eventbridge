<?php

// This file is auto-generated, don't edit it. Thanks.
namespace RocketMQ\Eventbridge\SDK\Models;

use AlibabaCloud\Tea\Model;

class ListEventTargetsRequest extends Model {
    protected $_name = [
        'eventBusName' => 'eventBusName',
        'eventRuleName' => 'eventRuleName',
    ];
    public function validate() {}
    public function toMap() {
        $res = [];
        if (null !== $this->eventBusName) {
            $res['eventBusName'] = $this->eventBusName;
        }
        if (null !== $this->eventRuleName) {
            $res['eventRuleName'] = $this->eventRuleName;
        }
        return $res;
    }
    /**
     * @param array $map
     * @return ListEventTargetsRequest
     */
    public static function fromMap($map = []) {
        $model = new self();
        if(isset($map['eventBusName'])){
            $model->eventBusName = $map['eventBusName'];
        }
        if(isset($map['eventRuleName'])){
            $model->eventRuleName = $map['eventRuleName'];
        }
        return $model;
    }
    /**
     * @description The name of the event bus with which the event target is associated.
This parameter is required.
     * @example my-event-bus
     * @var string
     */
    public $eventBusName;

    /**
     * @description The name of the event rule.
This parameter is required.
     * @example myrabbitmq.sourc
     * @var string
     */
    public $eventRuleName;

}
