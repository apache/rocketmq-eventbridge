<?php

// This file is auto-generated, don't edit it. Thanks.
namespace RocketMQ\Eventbridge\SDK\Models\EventTarget;

use AlibabaCloud\Tea\Model;

use RocketMQ\Eventbridge\SDK\Models\EventTarget\runOptions\retryStrategy;
use RocketMQ\Eventbridge\SDK\Models\EventTarget\runOptions\deadLetterQueue;

class runOptions extends Model {
    protected $_name = [
        'errorsTolerance' => 'errorsTolerance',
        'retryStrategy' => 'retryStrategy',
        'deadLetterQueue' => 'deadLetterQueue',
    ];
    public function validate() {}
    public function toMap() {
        $res = [];
        if (null !== $this->errorsTolerance) {
            $res['errorsTolerance'] = $this->errorsTolerance;
        }
        if (null !== $this->retryStrategy) {
            $res['retryStrategy'] = null !== $this->retryStrategy ? $this->retryStrategy->toMap() : null;
        }
        if (null !== $this->deadLetterQueue) {
            $res['deadLetterQueue'] = null !== $this->deadLetterQueue ? $this->deadLetterQueue->toMap() : null;
        }
        return $res;
    }
    /**
     * @param array $map
     * @return runOptions
     */
    public static function fromMap($map = []) {
        $model = new self();
        if(isset($map['errorsTolerance'])){
            $model->errorsTolerance = $map['errorsTolerance'];
        }
        if(isset($map['retryStrategy'])){
            $model->retryStrategy = retryStrategy::fromMap($map['retryStrategy']);
        }
        if(isset($map['deadLetterQueue'])){
            $model->deadLetterQueue = deadLetterQueue::fromMap($map['deadLetterQueue']);
        }
        return $model;
    }
    /**
     * @var string
     */
    public $errorsTolerance;

    /**
     * @var retryStrategy
     */
    public $retryStrategy;

    /**
     * @var deadLetterQueue
     */
    public $deadLetterQueue;

}
