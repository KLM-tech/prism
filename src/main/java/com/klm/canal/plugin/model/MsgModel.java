package com.klm.canal.plugin.model;

import lombok.Data;

/**
 * 消息格式(example)
 * 以各自canal-client加工出的格式为主
 *
 * @author quinn
 * @date 2020-07-08
 */
@Data
public class MsgModel {

    /**
     * 操作方式
     * insert/update/delete
     */
    private String op;

    /**
     * 数据库名
     */
    private String dbName;

    /**
     * 当前数据json
     */
    private Object data;

    /**
     * 表名
     */
    private String tableName;

    /**
     * 修改前数据
     */
    private Object beforeChange;

    /**
     * 执行时间
     */
    private String executeTime;
}
