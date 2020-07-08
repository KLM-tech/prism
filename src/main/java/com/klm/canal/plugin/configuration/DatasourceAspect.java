package com.klm.canal.plugin.configuration;

import com.klm.canal.plugin.annotation.DataSource;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class DatasourceAspect {

    /**
     * mysql数据库切换
     */
    @Pointcut("@annotation(com.klm.canal.plugin.annotation.DataSource)")
    public void annotationMySqlPointCut() {
    }

    @Before(value = "annotationMySqlPointCut()&&@annotation(datasource)")
    public void beforeSwitchDS(JoinPoint point, DataSource datasource) {
        DatabaseHolder.setDatabaseSource(datasource.value());
    }

    @After(value = "annotationMySqlPointCut()")
    public void afterSwitchDS(JoinPoint point) {
        DatabaseHolder.clearDatabaseSource();
    }
}
