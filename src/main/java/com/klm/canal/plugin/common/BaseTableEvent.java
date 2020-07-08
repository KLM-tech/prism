package com.klm.canal.plugin.common;

import com.klm.canal.plugin.model.constant.EventConstants;
import lombok.Data;

/**
 * base封装事件
 *
 * @author sunqiuxiang
 * @date 2019-10-24
 */
@Data
public abstract class BaseTableEvent implements Event, EventConstants {

    String setting = OTHER;

    @Override
    public String setting() {
        return setting;
    }

}
