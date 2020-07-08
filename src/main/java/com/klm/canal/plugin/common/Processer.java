package com.klm.canal.plugin.common;

import com.klm.canal.plugin.model.MigrationContext;
import com.klm.canal.plugin.model.MigrationResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.lang.reflect.Method;

/**
 * 执行器
 *
 * @author quinn
 * @date 2020-07-08
 */
@Service
@Slf4j
public class Processer {

    public MigrationResult execute(BaseTableEvent event, MigrationContext context) {
        String method = event.setting();
        Method m;
        MigrationResult result = null;
        try {
            m = event.getClass().getDeclaredMethod(method, MigrationContext.class);
            result = (MigrationResult) m.invoke(event, context);
        } catch (Exception e) {
            log.error("Process execute event:{},context{}", event, context, e);
        }
        return result;
    }
}
