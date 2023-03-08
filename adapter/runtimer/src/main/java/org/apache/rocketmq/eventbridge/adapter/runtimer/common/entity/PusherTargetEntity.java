package org.apache.rocketmq.eventbridge.adapter.runtimer.common.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * pusher target key config
 */
@Data
public class PusherTargetEntity implements Serializable {

    private String connectName;

    private List<TargetKeyValue> targetKeyValues;

    @Override
    public boolean equals(Object object){
        if (object != null && object.getClass() == this.getClass()) {
            PusherTargetEntity targetEntity = (PusherTargetEntity) object;
            return this.connectName.equals(targetEntity.getConnectName())
                    && this.targetKeyValues.size() == targetEntity.getTargetKeyValues().size()
                    && this.targetKeyValues.containsAll(targetEntity.getTargetKeyValues());
        }
        return false;
    }

    @Override
    public int hashCode(){
        return this.connectName.hashCode() + this.targetKeyValues.hashCode();
    }
}
