<?php

// This file is auto-generated, don't edit it. Thanks.
namespace RocketMQ\Eventbridge\SDK\Models;

use AlibabaCloud\Tea\Model;

class DisableEventRuleResponseBody extends Model {
    protected $_name = [
        'code' => 'code',
        'message' => 'message',
        'requestId' => 'requestId',
    ];
    public function validate() {}
    public function toMap() {
        $res = [];
        if (null !== $this->code) {
            $res['code'] = $this->code;
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
     * @return DisableEventRuleResponseBody
     */
    public static function fromMap($map = []) {
        $model = new self();
        if(isset($map['code'])){
            $model->code = $map['code'];
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
