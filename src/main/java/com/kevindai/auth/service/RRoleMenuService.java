package com.kevindai.auth.service;

import com.kevindai.auth.domain.RRoleMenu;
import com.kevindai.auth.domain.RRoleMenuExample;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.kevindai.auth.mapper.RRoleMenuMapper;import java.util.List;

/**
 * @Author: xm20200119
 * @Date: 21/04/2020 23:06
 */
@Service
public class RRoleMenuService {

    @Resource
    private RRoleMenuMapper rRoleMenuMapper;

    public long countByExample(RRoleMenuExample example) {
        return rRoleMenuMapper.countByExample(example);
    }

    public int deleteByExample(RRoleMenuExample example) {
        return rRoleMenuMapper.deleteByExample(example);
    }

    public int deleteByPrimaryKey(Long id) {
        return rRoleMenuMapper.deleteByPrimaryKey(id);
    }

    public int insert(RRoleMenu record) {
        return rRoleMenuMapper.insert(record);
    }

    public int insertSelective(RRoleMenu record) {
        return rRoleMenuMapper.insertSelective(record);
    }

    public List<RRoleMenu> selectByExample(RRoleMenuExample example) {
        return rRoleMenuMapper.selectByExample(example);
    }

    public RRoleMenu selectByPrimaryKey(Long id) {
        return rRoleMenuMapper.selectByPrimaryKey(id);
    }

    public int updateByExampleSelective(RRoleMenu record, RRoleMenuExample example) {
        return rRoleMenuMapper.updateByExampleSelective(record, example);
    }

    public int updateByExample(RRoleMenu record, RRoleMenuExample example) {
        return rRoleMenuMapper.updateByExample(record, example);
    }

    public int updateByPrimaryKeySelective(RRoleMenu record) {
        return rRoleMenuMapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(RRoleMenu record) {
        return rRoleMenuMapper.updateByPrimaryKey(record);
    }
}

