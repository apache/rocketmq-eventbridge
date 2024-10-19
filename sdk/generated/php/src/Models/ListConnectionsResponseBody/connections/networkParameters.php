<?php

// This file is auto-generated, don't edit it. Thanks.
namespace RocketMQ\Eventbridge\SDK\Models\ListConnectionsResponseBody\connections;

use AlibabaCloud\Tea\Model;

class networkParameters extends Model {
    protected $_name = [
        'networkType' => 'networkType',
        'securityGroupId' => 'securityGroupId',
        'vpcId' => 'vpcId',
        'vswitcheId' => 'vswitcheId',
    ];
    public function validate() {}
    public function toMap() {
        $res = [];
        if (null !== $this->networkType) {
            $res['networkType'] = $this->networkType;
        }
        if (null !== $this->securityGroupId) {
            $res['securityGroupId'] = $this->securityGroupId;
        }
        if (null !== $this->vpcId) {
            $res['vpcId'] = $this->vpcId;
        }
        if (null !== $this->vswitcheId) {
            $res['vswitcheId'] = $this->vswitcheId;
        }
        return $res;
    }
    /**
     * @param array $map
     * @return networkParameters
     */
    public static function fromMap($map = []) {
        $model = new self();
        if(isset($map['networkType'])){
            $model->networkType = $map['networkType'];
        }
        if(isset($map['securityGroupId'])){
            $model->securityGroupId = $map['securityGroupId'];
        }
        if(isset($map['vpcId'])){
            $model->vpcId = $map['vpcId'];
        }
        if(isset($map['vswitcheId'])){
            $model->vswitcheId = $map['vswitcheId'];
        }
        return $model;
    }
    /**
     * @description The network type. Valid values:PublicNetwork and PrivateNetwork.
     * @example PublicNetwork
     * @var string
     */
    public $networkType;

    /**
     * @description The security group ID.
     * @example eb-167adad548759-security_grop/sg-bp1addad26peuh9qh9rtyb
     * @var string
     */
    public $securityGroupId;

    /**
     * @description The virtual private cloud (VPC) ID.
     * @example eb-test/vpc-bp1symadadwnwgmqud
     * @var string
     */
    public $vpcId;

    /**
     * @description The vSwitch ID.
     * @example vsw-bp1iu4x7aeradadown1og8,vsw-bp193sqmadadlaszpeqbt2c
     * @var string
     */
    public $vswitcheId;

}
