package com.klm.canal.plugin.common.template.abs;

import com.klm.canal.plugin.model.MigrationContext;
import com.klm.canal.plugin.model.MigrationParam;
import com.klm.canal.plugin.model.MigrationResult;
import lombok.extern.slf4j.Slf4j;

/**
 * 业务模版
 * 可以重写特殊逻辑
 *
 * @author quinn
 * @date 2020-07-08
 */
@Slf4j
public abstract class AbstractDemoTemplate extends AbstractTemplate<MigrationParam, MigrationContext, MigrationResult> {

    /**
     * 统一结果处理
     *
     * @param responseCode 结果码值
     * @param msg 结果信息
     */
    @Override
    public MigrationResult buildResult(Integer responseCode, String msg) {
        return null;
    }
}
