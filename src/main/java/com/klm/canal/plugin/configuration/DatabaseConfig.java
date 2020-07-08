package com.klm.canal.plugin.configuration;

import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;


/**
 * 数据源配置
 *
 * @author quinn
 * @date 2020-07-08
 */
@Configuration
public class DatabaseConfig {

    @Bean(name = "source")
    @ConfigurationProperties(prefix = "spring.dataSource.prism")
    public DataSource sourceDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "target")
    @ConfigurationProperties(prefix = "spring.dataSource.prism-target")
    public DataSource targetDataSource() {
        return DataSourceBuilder.create().build();
    }

    /**
     * 动态数据源: 通过AOP在不同数据源之间动态切换
     */
    @SuppressWarnings({"rawtypes", "unchecked"})
    @Primary
    @Bean(name = "dynamicDataSource")
    public DataSource dynamicDataSource() {
        DynamicDatabase dynamicDataSource = new DynamicDatabase();
        // 默认数据源
        dynamicDataSource.setDefaultTargetDataSource(sourceDataSource());
        // 配置多数据源（初始化数据源集合）
        Map<Object, Object> dsMap = new HashMap();
        dsMap.put("source", sourceDataSource());
        dsMap.put("target", targetDataSource());
        dynamicDataSource.setTargetDataSources(dsMap);
        return dynamicDataSource;
    }

    @Bean
    public PlatformTransactionManager transactionManager() {
        return new DataSourceTransactionManager(dynamicDataSource());
    }
}
