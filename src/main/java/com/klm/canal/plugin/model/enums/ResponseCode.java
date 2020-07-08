package com.klm.canal.plugin.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ResponseCode {
	
    /**
     * 成功返回码值
     */
    SUCCESS(0, "处理成功"),
    /**
     * 失败返回码值
     */
    FAILURE(9000, "处理失败"),
    /**
     * 数据为空
     */
    DATA_EMPTY(9995, "数据为空"),
    /**
     * 数据库错误
     */
    DB_ERROR(9996, "数据库错误"),
    /**
     * 参数为空
     */
    PARAM_NULL(9997, "参数为空"),
    /**
     * 参数错误
     */
    PARAM_ERROR(9998, "参数错误"),
    /**
     * 系统异常
     */
    SYSTEM_ERROR(9999, "系统异常");

    /**
     * 响应码值
     */
    private final int code;
	
	/**
     * 响应信息
     */
    private final String message;
}
