package com.klm.canal.plugin.common.sourcetable;

import com.klm.canal.plugin.common.BaseTableEvent;
import com.klm.canal.plugin.model.MigrationContext;
import com.klm.canal.plugin.model.MigrationResult;
import lombok.extern.slf4j.Slf4j;

/**
 * 订单增量更新
 *
 * @author liusibo
 */
@Slf4j
public class DemoTableEvent extends BaseTableEvent {

    @Override
    public MigrationResult insert(MigrationContext context) {
        log.error("DemoTableEvent insert param:{}", context);
        MigrationResult result = new MigrationResult();
        return result;
    }

    @Override
    public MigrationResult update(MigrationContext context) {
        log.error("DemoTableEvent update param:{}", context);
        MigrationResult result = new MigrationResult();
        return result;
    }

    @Override
    public MigrationResult delete(MigrationContext context) {
        log.error("DemoTableEvent delete param:{}", context);
        MigrationResult result = new MigrationResult();
        return result;
    }

}
