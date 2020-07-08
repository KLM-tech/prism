package com.klm.canal.plugin.model;

import com.klm.canal.plugin.common.BaseTableEvent;
import com.klm.canal.plugin.common.mapperinject.CommonServices;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 处理上下文
 *
 * @author quinn
 * @date 2020-07-08
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MigrationContext {

    private Long logId;

    private BaseTableEvent event;

    private Object tableData;

    private Object beforeData;

    private Long executeTime;

    private CommonServices commonServices;

    private long primaryKey;
}
