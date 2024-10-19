<?php

// This file is auto-generated, don't edit it. Thanks.
namespace RocketMQ\Eventbridge\SDK\Models;

use AlibabaCloud\Tea\Model;

use RocketMQ\Eventbridge\SDK\Models\GetEventRuleResponseBody\eventTargets;

class GetEventRuleResponseBody extends Model {
    protected $_name = [
        'code' => 'code',
        'eventBusName' => 'eventBusName',
        'eventRuleName' => 'eventRuleName',
        'description' => 'description',
        'filterPattern' => 'filterPattern',
        'status' => 'status',
        'gmtCreate' => 'gmtCreate',
        'gmtModify' => 'gmtModify',
        'eventTargets' => 'eventTargets',
        'message' => 'message',
        'requestId' => 'requestId',
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
        if (null !== $this->eventTargets) {
            $res['eventTargets'] = [];
            if(null !== $this->eventTargets && is_array($this->eventTargets)){
                $n = 0;
                foreach($this->eventTargets as $item){
                    $res['eventTargets'][$n++] = null !== $item ? $item->toMap() : $item;
                }
            }
        }
        if (null !== $this->message) {
            $res['message'] = $this->message;
        }
        if (null !== $this->requestId) {
            $res['requestId'] = $this->requestId;
        }
        return $res;
    }
    /**
     * @param array $map
     * @return GetEventRuleResponseBody
     */
    public static function fromMap($map = []) {
        $model = new self();
        if(isset($map['code'])){
            $model->code = $map['code'];
        }
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
        if(isset($map['eventTargets'])){
            if(!empty($map['eventTargets'])){
                $model->eventTargets = [];
                $n = 0;
                foreach($map['eventTargets'] as $item) {
                    $model->eventTargets[$n++] = null !== $item ? eventTargets::fromMap($item) : $item;
                }
            }
        }
        if(isset($map['message'])){
            $model->message = $map['message'];
        }
        if(isset($map['requestId'])){
            $model->requestId = $map['requestId'];
        }
        return $model;
    }
    /**
     * @description The returned response code. Valid values:

    *   Success: The request is successful.

    *   Other codes: The request failed. For more information about error codes, see Error codes.
     * @example Success
     * @var string
     */
    public $code;

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

    /**
     * @var eventTargets[]
     */
    public $eventTargets;

    /**
     * @description The returned error message.
     * @example Remote error. requestId: [A8EFABD2-95B9-1C46-9E01-xxxx], error code: [CreateRelatedResourceFailed], message: [Create related resource failed, EntityNotExist.Role : The role not exists: xxxx. \\r\\nRequestId : xxxx-168C-54ED-8FEB-BF11CB70AEB7]
     * @var string
     */
    public $message;

    /**
     * @description The request ID.
     * @example 2922208e-e1c6-43ee-bfd1-aca50263bc8a
     * @var string
     */
    public $requestId;

}
