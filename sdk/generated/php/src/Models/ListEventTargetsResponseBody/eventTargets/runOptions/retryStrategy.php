<?php

// This file is auto-generated, don't edit it. Thanks.
namespace RocketMQ\Eventbridge\SDK\Models\ListEventTargetsResponseBody\eventTargets\runOptions;

use AlibabaCloud\Tea\Model;

class retryStrategy extends Model {
    protected $_name = [
        'pushRetryStrategy' => 'pushRetryStrategy',
        'maximumEventAgeInSeconds' => 'maximumEventAgeInSeconds',
        'maximumRetryAttempts' => 'maximumRetryAttempts',
    ];
    public function validate() {}
    public function toMap() {
        $res = [];
        if (null !== $this->pushRetryStrategy) {
            $res['pushRetryStrategy'] = $this->pushRetryStrategy;
        }
        if (null !== $this->maximumEventAgeInSeconds) {
            $res['maximumEventAgeInSeconds'] = $this->maximumEventAgeInSeconds;
        }
        if (null !== $this->maximumRetryAttempts) {
            $res['maximumRetryAttempts'] = $this->maximumRetryAttempts;
        }
        return $res;
    }
    /**
     * @param array $map
     * @return retryStrategy
     */
    public static function fromMap($map = []) {
        $model = new self();
        if(isset($map['pushRetryStrategy'])){
            $model->pushRetryStrategy = $map['pushRetryStrategy'];
        }
        if(isset($map['maximumEventAgeInSeconds'])){
            $model->maximumEventAgeInSeconds = $map['maximumEventAgeInSeconds'];
        }
        if(isset($map['maximumRetryAttempts'])){
            $model->maximumRetryAttempts = $map['maximumRetryAttempts'];
        }
        return $model;
    }
    /**
     * @var string
     */
    public $pushRetryStrategy;

    /**
     * @var int
     */
    public $maximumEventAgeInSeconds;

    /**
     * @var int
     */
    public $maximumRetryAttempts;

}
