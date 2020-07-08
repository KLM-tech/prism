package com.klm.canal.plugin.common.template.iface;

/**
 * 统一处理操作
 * @author quinn
 * @date 2019-05-31 14:05
 */
public interface IMigrationHandler<P, C, R> {
    /**
     * 构造上下文
     * @param param 参数
     * @return 上下文
     * @date 2019-05-31
     * @author quinn
     */
    C buildContext(final P param);

    /**
     * 处理器
     * @param param 参数
     * @param context 上下文
     * @return 处理结果
     * @date 2019-05-31
     * @author quinn
     */
    R process(final P param, final C context);
}
