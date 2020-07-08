package com.klm.canal.plugin.model;

import com.google.common.collect.Maps;
import com.klm.canal.plugin.common.sourcetable.DemoTableEvent;
import com.klm.canal.plugin.entity.source.UserDemo;
import lombok.Data;

import java.util.Map;

/**
 * @author quinn
 * @date 2019-06-01 16:32
 */
@Data
public abstract class BaseParam {
    public Map<String, Class> convertMap = Maps.newConcurrentMap();

    {
        convertMap.put("user_demo", UserDemo.class);
    }

    public Map<String, Class> convertProcessMap = Maps.newConcurrentMap();

    {
        convertProcessMap.put("user_demo", DemoTableEvent.class);
    }
}
