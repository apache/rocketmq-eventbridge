<?php

// This file is auto-generated, don't edit it. Thanks.
namespace RocketMQ\Eventbridge\SDK\Models;

use AlibabaCloud\Tea\Model;

class DeleteEventTargetsRequest extends Model {
    protected $_name = [
        'eventBusName' => 'eventBusName',
        'eventRuleName' => 'eventRuleName',
        'eventTargetNames' => 'eventTargetNames',
    ];
    public function validate() {
        Model::validateRequired('eventBusName', $this->eventBusName, true);
        Model::validateRequired('eventRuleName', $this->eventRuleName, true);
    }
    public function toMap() {
        $res = [];
        if (null !== $this->eventBusName) {
            $res['eventBusName'] = $this->eventBusName;
        }
        if (null !== $this->eventRuleName) {
            $res['eventRuleName'] = $this->eventRuleName;
        }
        if (null !== $this->eventTargetNames) {
            $res['eventTargetNames'] = $this->eventTargetNames;
        }
        return $res;
    }
    /**
     * @param array $map
     * @return DeleteEventTargetsRequest
     */
    public static function fromMap($map = []) {
        $model = new self();
        if(isset($map['eventBusName'])){
            $model->eventBusName = $map['eventBusName'];
        }
        if(isset($map['eventRuleName'])){
            $model->eventRuleName = $map['eventRuleName'];
        }
        if(isset($map['eventTargetNames'])){
            if(!empty($map['eventTargetNames'])){
                $model->eventTargetNames = $map['eventTargetNames'];
            }
        }
        return $model;
    }
    /**
     * @description The name of the event bus.
     * @example MyEventBus
     * @var string
     */
    public $eventBusName;

    /**
     * @description The name of the event rule.
     * @example ramrolechange-mns
     * @var string
     */
    public $eventRuleName;

    /**
     * @description The names of the event targets that you want to delete.
     * @var string[]
     */
    public $eventTargetNames;

}
