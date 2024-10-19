<?php

// This file is auto-generated, don't edit it. Thanks.
namespace RocketMQ\Eventbridge\SDK\Models\GetConnectionResponseBody\connections\authParameters;

use AlibabaCloud\Tea\Model;

class basicAuthParameters extends Model {
    protected $_name = [
        'password' => 'password',
        'username' => 'username',
    ];
    public function validate() {}
    public function toMap() {
        $res = [];
        if (null !== $this->password) {
            $res['password'] = $this->password;
        }
        if (null !== $this->username) {
            $res['username'] = $this->username;
        }
        return $res;
    }
    /**
     * @param array $map
     * @return basicAuthParameters
     */
    public static function fromMap($map = []) {
        $model = new self();
        if(isset($map['password'])){
            $model->password = $map['password'];
        }
        if(isset($map['username'])){
            $model->username = $map['username'];
        }
        return $model;
    }
    /**
     * @description The password for basic authentication.
     * @example admin
     * @var string
     */
    public $password;

    /**
     * @description The username for basic authentication.
     * @example admin
     * @var string
     */
    public $username;

}
