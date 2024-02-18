/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.rocketmq.eventbridge.adapter.persistence;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

/**
 * DatasourceConfig
 */
@Configuration
@MapperScan(basePackages = "org.apache.rocketmq.eventbridge.adapter.persistence.*.mybatis.*")
public class DatasourceConfig {
    private static final String MAPPER_LOCATION = "classpath:mybatis/*.xml";

    @Value("${spring.datasource.hikari.jdbc-url:jdbc:h2:./rocketmq_eventbridge;MODE=MySQL}")
    private String baseUrl;
    @Value("${spring.datasource.hikari.driver-class-name:org.h2.Driver}")
    private String baseDriverClassName;
    @Value("${spring.datasource.hikari.username:sa}")
    private String baseUserName;
    @Value("${spring.datasource.hikari.password:sa}")
    private String basePassword;

    @Value("${spring.datasource.hikari.minimum-idle:5}")
    private Integer minIdle;

    @Value("${spring.datasource.hikari.idle-timeout:180000}")
    private Long idleTimeoutMs;

    @Value("${spring.datasource.hikari.maximum-pool-size: 10}")
    private Integer maxPoolSize;

    @Value("${spring.datasource.hikari.auto-commit: true}")
    private Boolean autoCommit;

    @Value("${spring.datasource.hikari.pool-name: hikaricp}")
    private String poolName;

    @Value("${spring.datasource.hikari.max-lifetime: 180000}")
    private Long maxLifeTime;

    @Value("${spring.datasource.hikari.connection-timeout: 30000}")
    private Long connectionTimeoutMs;

    @Value("${spring.datasource.hikari.connection-test-query: select 1}")
    private String connectionTestQuery;

    @Value("${spring.datasource.hikari.validation-timeout: 500}")
    private Long validationTimeoutMs;

    @Bean("dataSource")
    public DataSource getMasterDataSource() {
        HikariConfig hikariConfig = new HikariConfig();
        hikariConfig.setJdbcUrl(baseUrl);
        hikariConfig.setDriverClassName(baseDriverClassName);
        hikariConfig.setUsername(baseUserName);
        hikariConfig.setPassword(basePassword);
        hikariConfig.setMinimumIdle(minIdle);
        hikariConfig.setIdleTimeout(idleTimeoutMs);
        hikariConfig.setMaximumPoolSize(maxPoolSize);
        hikariConfig.setAutoCommit(autoCommit);
        hikariConfig.setPoolName(poolName);
        hikariConfig.setMaxLifetime(maxLifeTime);
        hikariConfig.setConnectionTimeout(connectionTimeoutMs);
        hikariConfig.setConnectionTestQuery(connectionTestQuery);
        hikariConfig.setValidationTimeout(validationTimeoutMs);
        return new HikariDataSource(hikariConfig);
    }

    @Bean("sqlSessionFactory")
    public SqlSessionFactory masterSqlSessionFactory(@Qualifier("dataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(MAPPER_LOCATION));
        return bean.getObject();
    }

    @Bean("sqlSessionTemplate")
    public SqlSessionTemplate masterSqlSessionTemplate(
        @Qualifier("sqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

}

