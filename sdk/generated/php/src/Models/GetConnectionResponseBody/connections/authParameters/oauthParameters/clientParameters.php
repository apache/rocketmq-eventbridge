<?php

// This file is auto-generated, don't edit it. Thanks.
namespace RocketMQ\Eventbridge\SDK\Models\GetConnectionResponseBody\connections\authParameters\oauthParameters;

use AlibabaCloud\Tea\Model;

class clientParameters extends Model {
    protected $_name = [
        'clientID' => 'clientID',
        'clientSecret' => 'clientSecret',
    ];
    public function validate() {}
    public function toMap() {
        $res = [];
        if (null !== $this->clientID) {
            $res['clientID'] = $this->clientID;
        }
        if (null !== $this->clientSecret) {
            $res['clientSecret'] = $this->clientSecret;
        }
        return $res;
    }
    /**
     * @param array $map
     * @return clientParameters
     */
    public static function fromMap($map = []) {
        $model = new self();
        if(isset($map['clientID'])){
            $model->clientID = $map['clientID'];
        }
        if(isset($map['clientSecret'])){
            $model->clientSecret = $map['clientSecret'];
        }
        return $model;
    }
    /**
     * @description The client ID.
     * @example ClientID
     * @var string
     */
    public $clientID;

    /**
     * @description The client key secret of the application.
     * @example ClientSecret
     * @var string
     */
    public $clientSecret;

}
