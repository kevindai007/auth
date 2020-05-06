package com.kevindai.auth.service;

import com.kevindai.auth.domain.MenuInfo;
import com.kevindai.auth.domain.MenuInfoExample;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.kevindai.auth.mapper.MenuInfoMapper;import java.util.List;

/**
 * @Author: xm20200119
 * @Date: 21/04/2020 23:05
 */
@Service
public class MenuInfoService {

    @Resource
    private MenuInfoMapper menuInfoMapper;


    public List<String> findComponentByUserId(Long userId) {
        return menuInfoMapper.findComponentByUserId(userId);
    }



    public long countByExample(MenuInfoExample example) {
        return menuInfoMapper.countByExample(example);
    }

    public int deleteByExample(MenuInfoExample example) {
        return menuInfoMapper.deleteByExample(example);
    }

    public int deleteByPrimaryKey(Long id) {
        return menuInfoMapper.deleteByPrimaryKey(id);
    }

    public int insert(MenuInfo record) {
        return menuInfoMapper.insert(record);
    }

    public int insertSelective(MenuInfo record) {
        return menuInfoMapper.insertSelective(record);
    }

    public List<MenuInfo> selectByExample(MenuInfoExample example) {
        return menuInfoMapper.selectByExample(example);
    }

    public MenuInfo selectByPrimaryKey(Long id) {
        return menuInfoMapper.selectByPrimaryKey(id);
    }

    public int updateByExampleSelective(MenuInfo record, MenuInfoExample example) {
        return menuInfoMapper.updateByExampleSelective(record, example);
    }

    public int updateByExample(MenuInfo record, MenuInfoExample example) {
        return menuInfoMapper.updateByExample(record, example);
    }

    public int updateByPrimaryKeySelective(MenuInfo record) {
        return menuInfoMapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(MenuInfo record) {
        return menuInfoMapper.updateByPrimaryKey(record);
    }
}

