package com.klm.canal.plugin.common;


import com.klm.canal.plugin.model.MigrationContext;
import com.klm.canal.plugin.model.MigrationResult;

/**
 * 事件接口
 *
 * @author quinn
 * @date 2020-07-08
 */
public interface Event {

    String setting();

    MigrationResult insert(MigrationContext context);

    MigrationResult update(MigrationContext context);

    MigrationResult delete(MigrationContext context);
}
