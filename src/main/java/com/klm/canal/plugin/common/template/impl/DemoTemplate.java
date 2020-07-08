package com.klm.canal.plugin.common.template.impl;

import com.alibaba.fastjson.JSON;
import com.klm.canal.plugin.common.BaseTableEvent;
import com.klm.canal.plugin.common.Processer;
import com.klm.canal.plugin.common.mapperinject.CommonServices;
import com.klm.canal.plugin.common.template.abs.AbstractDemoTemplate;
import com.klm.canal.plugin.model.MigrationContext;
import com.klm.canal.plugin.model.MigrationParam;
import com.klm.canal.plugin.model.MigrationResult;
import com.klm.canal.plugin.model.MsgModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @author quinn
 * @date 2019-05-31 14:30
 */
@Slf4j
@Service
public class DemoTemplate extends AbstractDemoTemplate {

    @Resource
    Processer processer;

    @Resource
    CommonServices commonServices;

    @Override
    public MigrationContext buildContext(MigrationParam param) {
        // 构建封装event载入上下文
        // 从param中取出op，转成对应event
        // 把msg转成data
        String mqMsg = param.getMqMsg();
        // 消息json转model
        MsgModel msgPo = JSON.parseObject(mqMsg, MsgModel.class);
        if (msgPo == null) {
            return null;
        }

        // 取出数据类型
        Class dataClass = param.convertMap.get(msgPo.getTableName());
        if (dataClass == null) {
            log.info("buildContext getParam is empty");
            return null;
        }
        Object tableData = JSON.parseObject(JSON.toJSONString(msgPo.getData()), dataClass);
        Object beforeData = JSON.parseObject(JSON.toJSONString(msgPo.getBeforeChange()), dataClass);
        // 取出处理数据的event
        Class eventClass = param.convertProcessMap.get(msgPo.getTableName());
        BaseTableEvent msgEvent;
        try {
            msgEvent = (BaseTableEvent) eventClass.newInstance();
        } catch (InstantiationException e) {
            log.error("buildContext instantiationException error param:{}", param, e);
            return null;
        } catch (IllegalAccessException e) {
            log.error("buildContext illegalAccessException error param:{}", param, e);
            return null;
        }
        // 设置数据操作类型
        msgEvent.setSetting(msgPo.getOp().toLowerCase());
        MigrationContext userMigrationContext = new MigrationContext();
        userMigrationContext.setEvent(msgEvent);
        userMigrationContext.setTableData(tableData);
        userMigrationContext.setBeforeData(beforeData);
        userMigrationContext.setExecuteTime(Long.parseLong(msgPo.getExecuteTime()));
        userMigrationContext.setCommonServices(commonServices);
        return userMigrationContext;
    }

    @Override
    public MigrationResult process(MigrationParam param, MigrationContext context) {
        // 执行event的操作方法
        BaseTableEvent event = context.getEvent();
        MigrationResult execute = processer.execute(event, context);
        log.info("UserHandler.process event:{},result:{}", event.toString(), execute.toString());
        return execute;
    }
}
