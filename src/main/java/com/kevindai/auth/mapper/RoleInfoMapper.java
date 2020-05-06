package com.kevindai.auth.mapper;

import com.kevindai.auth.domain.RoleInfo;
import com.kevindai.auth.domain.RoleInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * @Author: xm20200119
 * @Date: 21/04/2020 23:15
 */
public interface RoleInfoMapper {
    long countByExample(RoleInfoExample example);

    int deleteByExample(RoleInfoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(RoleInfo record);

    int insertSelective(RoleInfo record);

    List<RoleInfo> selectByExample(RoleInfoExample example);

    RoleInfo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") RoleInfo record, @Param("example") RoleInfoExample example);

    int updateByExample(@Param("record") RoleInfo record, @Param("example") RoleInfoExample example);

    int updateByPrimaryKeySelective(RoleInfo record);

    int updateByPrimaryKey(RoleInfo record);
}