package com.kevindai.auth.mapper;

import com.kevindai.auth.domain.RRoleMenu;
import com.kevindai.auth.domain.RRoleMenuExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * @Author: xm20200119
 * @Date: 21/04/2020 23:15
 */
public interface RRoleMenuMapper {
    long countByExample(RRoleMenuExample example);

    int deleteByExample(RRoleMenuExample example);

    int deleteByPrimaryKey(Long id);

    int insert(RRoleMenu record);

    int insertSelective(RRoleMenu record);

    List<RRoleMenu> selectByExample(RRoleMenuExample example);

    RRoleMenu selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") RRoleMenu record, @Param("example") RRoleMenuExample example);

    int updateByExample(@Param("record") RRoleMenu record, @Param("example") RRoleMenuExample example);

    int updateByPrimaryKeySelective(RRoleMenu record);

    int updateByPrimaryKey(RRoleMenu record);
}