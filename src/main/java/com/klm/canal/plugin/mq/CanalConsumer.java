package com.klm.canal.plugin.mq;

import com.alibaba.fastjson.JSON;
import com.klm.canal.plugin.common.template.impl.DemoTemplate;
import com.klm.canal.plugin.model.MigrationParam;
import com.klm.canal.plugin.model.MsgModel;
import com.klm.canal.plugin.model.constant.BusinessConstants;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.listener.MessageListener;

import javax.annotation.Resource;


/**
 * kafka mq demo
 *
 * @author quinn
 * @date 2020-07-08
 */
@Slf4j
public class CanalConsumer implements MessageListener<Integer, String>, BusinessConstants {

    /**
     * demoTemplate
     */
    @Resource
    DemoTemplate demoTemplate;

    @Override
    public void onMessage(ConsumerRecord<Integer, String> arg) {
        try {
            log.info("kafka consumer:{}", arg.value());
            // 消息体
            MsgModel msgPo = JSON.parseObject(arg.value(), MsgModel.class);

            if ("prism".equals(msgPo.getDbName())) {
                MigrationParam param = new MigrationParam();
                param.setMqMsg(arg.value());
                demoTemplate.executeQuietly(param, DEMO_MONITOR_KEY);
            } else {
                log.info("conMessage 未消费 ,msg:{}", arg.value());
            }
        } catch (
                Exception e) {
            log.error("消费kafka消息异常,消息内容:{},异常内容,", arg, e);
        }
    }
}
