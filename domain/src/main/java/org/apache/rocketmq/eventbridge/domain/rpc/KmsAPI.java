package org.apache.rocketmq.eventbridge.domain.rpc;

public interface KmsAPI {

    String createSecretName(String accountId, String connectionName, String secretData) throws Exception;

    void deleteSecretName(String secretName) throws Exception;

    String getSecretName(String accountId, String connectionName);
}
