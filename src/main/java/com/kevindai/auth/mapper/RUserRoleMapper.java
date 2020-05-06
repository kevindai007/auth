package com.kevindai.auth.mapper;

import com.kevindai.auth.domain.RUserRole;
import com.kevindai.auth.domain.RUserRoleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * @Author: xm20200119
 * @Date: 21/04/2020 23:15
 */
public interface RUserRoleMapper {
    long countByExample(RUserRoleExample example);

    int deleteByExample(RUserRoleExample example);

    int deleteByPrimaryKey(Long id);

    int insert(RUserRole record);

    int insertSelective(RUserRole record);

    List<RUserRole> selectByExample(RUserRoleExample example);

    RUserRole selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") RUserRole record, @Param("example") RUserRoleExample example);

    int updateByExample(@Param("record") RUserRole record, @Param("example") RUserRoleExample example);

    int updateByPrimaryKeySelective(RUserRole record);

    int updateByPrimaryKey(RUserRole record);
}