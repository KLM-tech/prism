package com.klm.canal.plugin.common.template.abs;

import com.klm.canal.plugin.common.template.iface.ITemplate;
import com.klm.canal.plugin.model.enums.ResponseCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;



/**
 * 抽象模版
 *
 * @author sunqiuxiang
 * @date 2019-10-24
 */
@Slf4j
@Service
public abstract class AbstractTemplate<P, C, R> implements ITemplate<P, C, R> {


    /**
     * 平滑执行,逻辑失败返回null（可以自定义返回),异常返回null
     */
    public R executeQuietly(final P param, final String monitorKey) {
        long start = System.currentTimeMillis();
        // 记录请求日志
        log.info("reqStartTime={}. receive request,monitorKey:{},param={}", start, monitorKey, param != null ? param.toString() : null);
        // 前校验
        try {
            boolean requestFiltered = preFilter(param);
            if (requestFiltered) {
                log.error("reqStartTime={}. requestFiltered,monitorKey:{},param={}", start, monitorKey, param);
                return buildResult(ResponseCode.FAILURE.getCode(), "requestFiltered");
            }
        } catch (RuntimeException e) {
            log.error(
                    "reqStartTime={}. request param error,monitorKey:{},param={}", start, monitorKey, param, e);
            return buildResult(ResponseCode.FAILURE.getCode(), "param error:" + e.getMessage());
        }
        // 构建上下文
        C context;
        try {
            context = buildContext(param);
            if (context == null) {
                return buildResult(ResponseCode.FAILURE.getCode(), "context is null");
            }
        } catch (RuntimeException e) {
            log.error("reqStartTime={}. buildLoginContext error,monitorKey:{},param={}", start, monitorKey, param, e);
            return buildResult(ResponseCode.FAILURE.getCode(), "param error:" + e.getMessage());
        }
        // 构建返回结果
        R result = null;
        try {
            result = process(param, context);
            // 后过滤
            postFilter(result, param, context);
            if (result != null) {
                return result;
            } else {
                return buildResult(ResponseCode.FAILURE.getCode(), "获取的数据为空");
            }
        } catch (Exception e) {
            log.error("reqStartTime={}.logic error!,monitorKey:{},param={},error:", start, monitorKey, param, e);
            return buildResult(ResponseCode.FAILURE.getCode(), e.getMessage());
        } finally {
            context = null;
            long end = System.currentTimeMillis();
            long cost = end - start;
            log.info("reqStartTime={}.request process end,monitorKey:{},cost:{}, result={}", start, monitorKey, cost,
                    result != null ? result.toString() : null);
        }
    }

    /**
     * @param param 请求参数
     */
    @Override
    public boolean preFilter(P param) {
        return false;
    }

    @Override
    public void postFilter(R result, P param, C context) {
        if (result == null) {
            log.error("consumer postFilter NULL param:{},context:{}", param, context);
        }
    }

}
