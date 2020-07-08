package com.klm.canal.plugin.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 统一处理结果
 *
 * @author quinn
 * @date 2019-10-24
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MigrationResult {
    /**
     * baseuser处理结果
     */
    private Integer baseResult;

    /**
     * convenitentuser处理结果
     */
    private Integer convenientResult;

    /**
     * credit处理结果
     */
    private Integer creditResult;

    /**
     * order处理结果
     */
    private Integer orderResult;

    /**
     * 旧表主键
     */
    private String sourceKey;

    /**
     * 新表主键
     */
    private String targetKey;
}
