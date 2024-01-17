package org.apache.rocketmq.eventbridge.adapter.runtime.manager.k8s.repository;

import com.google.common.collect.Maps;
import com.google.gson.Gson;
import java.util.Map;
import org.apache.rocketmq.eventbridge.adapter.runtime.manager.worker.WorkerResource;
import org.junit.Ignore;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;


public class WorkerInstanceRepositoryOnK8STest {

    @InjectMocks
    private WorkerInstanceRepositoryOnK8S workerInstanceRepositoryOnK8S;

    @Test
    @Ignore
    void applyWorkerInstance() {
        Map<String, Object> environments = Maps.newHashMap();
        environments.put("key1", "value1");
        environments.put("key2", "value2");
        workerInstanceRepositoryOnK8S.applyWorkerInstance("worker-4", "registry.cn-beijing.cr.aliyuncs.com/eventbridge:20231115195431f55971", new Gson().fromJson("{\"cpu\":1,\"memory\":1}", WorkerResource.class), null);
    }

    @Test
    @Ignore
    void deleteWorkerInstance() {
        workerInstanceRepositoryOnK8S.deleteWorkerInstance("worker-4");
    }

    @Test
    @Ignore
    void getWorkerInstanceStatus() {
        workerInstanceRepositoryOnK8S.getWorkerInstanceStatus("worker-4");
    }

    @Test
    @Ignore
    void applyWorkerInstanceConfigFile() {
        String taskConfig = "[\n" +
            "  {\n" +
            "    \"name\":\"demo-runner\",\n" +
            "    \"components\":[\n" +
            "      {\n" +
            "        \"accountId\": \"654321\",\n" +
            "        \"eventBusName\":\"demo-bus\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"filterPattern\":\"{}\",\n" +
            "        \"class\":\"org.apache.rocketmq.connect.transform.eventbridge.EventBridgeFilterTransform\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"data\":\"{\\\"form\\\":\\\"TEMPLATE\\\",\\\"value\\\":\\\"{\\\\\\\"content\\\\\\\":\\\\\\\"$.data.body\\\\\\\"}\\\",\\\"template\\\":\\\"{\\\\\\\"text\\\\\\\":{\\\\\\\"content\\\\\\\":\\\\\\\"${content}\\\\\\\"},\\\\\\\"msgtype\\\\\\\":\\\\\\\"text\\\\\\\"}\\\"}\",\n" +
            "        \"class\": \"org.apache.rocketmq.connect.transform.eventbridge.EventBridgeTransform\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"class\":\"org.apache.rocketmq.connect.dingtalk.sink.DingTalkSinkTask\",\n" +
            "        \"webHook\":\"xxxxxxxxxxx\",\n" +
            "        \"secretKey\":\"xxxxxxxxxxx\"\n" +
            "      }\n" +
            "    ]\n" +
            "  }\n" +
            "]";
        workerInstanceRepositoryOnK8S.applyWorkerInstanceConfigFile("worker-4", "/eventbridge/task-config", taskConfig);
    }

    @Test
    @Ignore
    void getWorkerInstanceConfigFile() {
        workerInstanceRepositoryOnK8S.getWorkerInstanceConfigFile("worker-4", "/eventbridge/task-config");
    }
}