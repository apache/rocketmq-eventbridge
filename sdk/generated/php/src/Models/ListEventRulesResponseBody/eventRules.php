<?php

// This file is auto-generated, don't edit it. Thanks.
namespace RocketMQ\Eventbridge\SDK\Models\ListEventRulesResponseBody;

use AlibabaCloud\Tea\Model;

class eventRules extends Model {
    protected $_name = [
        'eventBusName' => 'eventBusName',
        'eventRuleName' => 'eventRuleName',
        'description' => 'description',
        'filterPattern' => 'filterPattern',
        'status' => 'status',
        'gmtCreate' => 'gmtCreate',
        'gmtModify' => 'gmtModify',
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
        if (null !== $this->description) {
            $res['description'] = $this->description;
        }
        if (null !== $this->filterPattern) {
            $res['filterPattern'] = $this->filterPattern;
        }
        if (null !== $this->status) {
            $res['status'] = $this->status;
        }
        if (null !== $this->gmtCreate) {
            $res['gmtCreate'] = $this->gmtCreate;
        }
        if (null !== $this->gmtModify) {
            $res['gmtModify'] = $this->gmtModify;
        }
        return $res;
    }
    /**
     * @param array $map
     * @return eventRules
     */
    public static function fromMap($map = []) {
        $model = new self();
        if(isset($map['eventBusName'])){
            $model->eventBusName = $map['eventBusName'];
        }
        if(isset($map['eventRuleName'])){
            $model->eventRuleName = $map['eventRuleName'];
        }
        if(isset($map['description'])){
            $model->description = $map['description'];
        }
        if(isset($map['filterPattern'])){
            $model->filterPattern = $map['filterPattern'];
        }
        if(isset($map['status'])){
            $model->status = $map['status'];
        }
        if(isset($map['gmtCreate'])){
            $model->gmtCreate = $map['gmtCreate'];
        }
        if(isset($map['gmtModify'])){
            $model->gmtModify = $map['gmtModify'];
        }
        return $model;
    }
    /**
     * @description The name of the event bus with which the event source is associated.
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

    /**
     * @var string
     */
    public $description;

    /**
     * @description The event pattern, in JSON format. Valid values: stringEqual and stringExpression. You can specify up to five expressions in the map data structure in each field.

        You can specify up to five expressions in the map data structure in each field.
     * @example {\"source\": [{\"prefix\": \"acs.\"}],\"type\": [{\"prefix\":\"oss:ObjectReplication\"}],\"subject\":[{\"prefix\":\"acs:oss:cn-hangzhou:123456789098****:my-movie-bucket/\", \"suffix\":\".txt\"}]}
     * @var string
     */
    public $filterPattern;

    /**
     * @description The status of the event rule. Valid values: ENABLE (default): The event rule is enabled. DISABLE: The event rule is disabled.
     * @example ENABLE
     * @var string
     */
    public $status;

    /**
     * @var string
     */
    public $gmtCreate;

    /**
     * @var string
     */
    public $gmtModify;

}
