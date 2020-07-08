package com.klm.canal.plugin.mapper.target;

import com.klm.canal.plugin.entity.target.UserTarget;
import com.klm.canal.plugin.entity.target.UserTargetExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserTargetMapper {
    long countByExample(UserTargetExample example);

    int deleteByExample(UserTargetExample example);

    int deleteByPrimaryKey(Long id);

    int insert(UserTarget record);

    int insertSelective(UserTarget record);

    List<UserTarget> selectByExample(UserTargetExample example);

    UserTarget selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") UserTarget record, @Param("example") UserTargetExample example);

    int updateByExample(@Param("record") UserTarget record, @Param("example") UserTargetExample example);

    int updateByPrimaryKeySelective(UserTarget record);

    int updateByPrimaryKey(UserTarget record);
}