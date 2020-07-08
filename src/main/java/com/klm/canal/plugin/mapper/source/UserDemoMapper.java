package com.klm.canal.plugin.mapper.source;

import com.klm.canal.plugin.entity.source.UserDemo;
import com.klm.canal.plugin.entity.source.UserDemoExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserDemoMapper {
    long countByExample(UserDemoExample example);

    int deleteByExample(UserDemoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(UserDemo record);

    int insertSelective(UserDemo record);

    List<UserDemo> selectByExample(UserDemoExample example);

    UserDemo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") UserDemo record, @Param("example") UserDemoExample example);

    int updateByExample(@Param("record") UserDemo record, @Param("example") UserDemoExample example);

    int updateByPrimaryKeySelective(UserDemo record);

    int updateByPrimaryKey(UserDemo record);
}