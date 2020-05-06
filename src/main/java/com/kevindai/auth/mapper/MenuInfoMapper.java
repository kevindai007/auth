package com.kevindai.auth.mapper;

import com.kevindai.auth.domain.MenuInfo;
import com.kevindai.auth.domain.MenuInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @Author: xm20200119
 * @Date: 21/04/2020 23:15
 */
public interface MenuInfoMapper {
    long countByExample(MenuInfoExample example);

    int deleteByExample(MenuInfoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(MenuInfo record);

    int insertSelective(MenuInfo record);

    List<MenuInfo> selectByExample(MenuInfoExample example);

    MenuInfo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") MenuInfo record, @Param("example") MenuInfoExample example);

    int updateByExample(@Param("record") MenuInfo record, @Param("example") MenuInfoExample example);

    int updateByPrimaryKeySelective(MenuInfo record);

    int updateByPrimaryKey(MenuInfo record);

    @Select("select a.component from menu_info a,role_info b,user_info c,r_user_role d,r_role_menu e WHERE " +
            "d.role_id=b.id and d.user_id=c.id and e.role_id=b.id and e.menu_id=a.id and c.id=#{user_id};")
    List<String> findComponentByUserId(Long userId);
}