package com.kevindai.auth.mapper;

import com.kevindai.auth.domain.UserInfo;
import com.kevindai.auth.domain.UserInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * @Author: xm20200119
 * @Date: 21/04/2020 23:15
 */
public interface UserInfoMapper {
    long countByExample(UserInfoExample example);

    int deleteByExample(UserInfoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(UserInfo record);

    int insertSelective(UserInfo record);

    List<UserInfo> selectByExample(UserInfoExample example);

    UserInfo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") UserInfo record, @Param("example") UserInfoExample example);

    int updateByExample(@Param("record") UserInfo record, @Param("example") UserInfoExample example);

    int updateByPrimaryKeySelective(UserInfo record);

    int updateByPrimaryKey(UserInfo record);
}