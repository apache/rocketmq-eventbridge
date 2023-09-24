package org.apache.rocketmq.eventbridge.adapter.runtime.manager.k8s.common;

public enum WorkerStatusEnum {
    /**
     * 集群状态
     */
    DEFAULT(-1, "未知状态"),
    WAIT_DEPLOY(0, "待部署"),
    STARTING(3, "启动中"),
    RUN(5, "服务中"),
    STOP(10, "停止"),
    RELEASING(11, "释放中");

    private int value;
    private String desc;

    WorkerStatusEnum(int value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    public static WorkerStatusEnum valueOf(int value) {
        for (WorkerStatusEnum temp : WorkerStatusEnum.values()) {
            if (temp.getValue() == value) {
                return temp;
            }
        }
        return DEFAULT;
    }

    public static WorkerStatusEnum nameOf(String name) {
        for (WorkerStatusEnum temp : WorkerStatusEnum.values()) {
            if (temp.name().equals(name)) {
                return temp;
            }
        }
        return DEFAULT;
    }

    public String getDesc() {
        return desc;
    }

    public int getValue() {
        return value;
    }
}
