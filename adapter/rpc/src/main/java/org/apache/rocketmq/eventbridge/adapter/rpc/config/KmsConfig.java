package org.apache.rocketmq.eventbridge.adapter.rpc.config;

import com.aliyun.kms20160120.Client;
import com.aliyun.teaopenapi.models.Config;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KmsConfig {

    @Value("${kms.accessKeyId}")
    private String kmsAccessKeyId;
    @Value("${kms.accessKeySecret}")
    private String kmsAccessKeySecret;
    @Value("${kms.endpoint}")
    private String kmsEndpoint;

    @Bean
    public Client client() throws Exception {
        Config config = new Config();
        config.setAccessKeyId(kmsAccessKeyId);
        config.setAccessKeySecret(kmsAccessKeySecret);
        config.setEndpoint(kmsEndpoint);
        return new Client(config);
    }

}
