package com.klm.canal.plugin.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author sunqiuxiang
 * @date 2019-05-31 14:10
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MigrationParam extends BaseParam {
    private String mqMsg;
}
