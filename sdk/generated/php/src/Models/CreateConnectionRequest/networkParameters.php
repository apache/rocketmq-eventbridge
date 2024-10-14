<?php

// This file is auto-generated, don't edit it. Thanks.
namespace RocketMQ\Eventbridge\SDK\Models\CreateConnectionRequest;

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
     * @description The network type. Valid values:

      PublicNetwork and PrivateNetwork.

      *   Note: If you set this parameter to PrivateNetwork, you must configure VpcId, VswitcheId, and SecurityGroupId.

      This parameter is required.
     * @example PublicNetwork
     * @var string
     */
    public $networkType;

    /**
     * @description The ID of the security group.
     * @example eb-167adad548759-security_grop/sg-bp1addad26peuh9qh9****
     * @var string
     */
    public $securityGroupId;

    /**
     * @description The VPC. ID
     * @example eb-test/vpc-bp1symadadwnwg****
     * @var string
     */
    public $vpcId;

    /**
     * @description The vSwitch ID.
     * @example vsw-bp1iu4x7aeradadown1og8,vsw-bp193sqmadadlaszpeq****
     * @var string
     */
    public $vswitcheId;

}
