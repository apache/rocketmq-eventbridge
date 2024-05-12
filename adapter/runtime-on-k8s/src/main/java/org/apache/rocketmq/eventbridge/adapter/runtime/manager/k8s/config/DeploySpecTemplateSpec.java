package org.apache.rocketmq.eventbridge.adapter.runtime.manager.k8s.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.Map;

@Getter
@Setter
@ConfigurationProperties(prefix="deploy.spec.template.spec")
@EnableConfigurationProperties
@Configuration
public class DeploySpecTemplateSpec {

  private Long terminationGracePeriodSeconds;

  @Autowired
  private SpecContainer containers;

  private Map<String, String> nodeSelector;


  private List<Map<String, Object>> volumes;

  private String podManagementPolicy;
}
