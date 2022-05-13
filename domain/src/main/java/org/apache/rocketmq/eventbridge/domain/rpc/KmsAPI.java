package org.apache.rocketmq.eventbridge.domain.rpc;

public interface KmsAPI {

    String createSecretName(String accountId, String connectionName, String secretData) throws Exception;

    void deleteSecretName(String secretName);
}
