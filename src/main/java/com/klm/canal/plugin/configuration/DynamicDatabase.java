package com.klm.canal.plugin.configuration;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * 绑定动态数据源
 *
 * @author quinn
 * @date 2020-07-08
 */
public class DynamicDatabase extends AbstractRoutingDataSource {

    // 监听
    @Override
    protected Object determineCurrentLookupKey() {
        return DatabaseHolder.getDatabaseSource();
    }

}
