package com.klm.canal.plugin.common.template.iface;


/**
 * @author quinn
 * @date 2019-05-31 14:16
 */
public interface ITemplate<P, C, R> extends IMigrationHandler<P, C, R> {

    /**
     * 统一前置过滤
     *
     * @param param 请求参数
     * @return 过滤结果
     * @date 2019-06-04
     * @author quinn
     */
    boolean preFilter(final P param);

    /**
     * 统一后置处理
     *
     * @param result  返回值
     * @param param   请求参数
     * @param context 上下文
     * @date 2019-06-04
     * @author quinn
     */
    void postFilter(R result, final P param, final C context);

    /**
     * @param responseCode 返回状态码
     * @param responseCode 返回信息
     * @return 返回结果
     * @date 2019-06-04
     * @author quinn
     */
    R buildResult(Integer responseCode, String msg);
}
