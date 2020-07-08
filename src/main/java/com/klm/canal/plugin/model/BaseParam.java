package com.klm.canal.plugin.model;

import com.google.common.collect.Maps;
import lombok.Data;

import java.util.Map;

/**
 * @author sunqiuxiang
 * @date 2019-06-01 16:32
 */
@Data
public abstract class BaseParam {
    public Map<String, Class> convertMap = Maps.newConcurrentMap();

    {
//        convertMap.put("user", User.class);
    }

    public Map<String, Class> convertProcessMap = Maps.newConcurrentMap();

    {
//        convertProcessMap.put("user", EasyUserTableEvent.class);
    }
}
