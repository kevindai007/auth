package com.kevindai.auth.service;

import com.kevindai.auth.domain.RUserRole;
import com.kevindai.auth.domain.RUserRoleExample;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.kevindai.auth.mapper.RUserRoleMapper;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: xm20200119
 * @Date: 21/04/2020 23:06
 */
@Service
public class RUserRoleService {

    @Resource
    private RUserRoleMapper rUserRoleMapper;




    public List<Long> findRoleIdByUserId(Long userId) {
        RUserRoleExample userRoleExample = new RUserRoleExample();
        RUserRoleExample.Criteria userRoleExampleCriteria = userRoleExample.createCriteria();
        userRoleExampleCriteria.andUserIdEqualTo(userId);
        List<RUserRole> userRoles = rUserRoleMapper.selectByExample(userRoleExample);
        List<Long> roleIds = new ArrayList<>();
        if (!userRoles.isEmpty()) {
            for (RUserRole userRole : userRoles) {
                roleIds.add(userRole.getRoleId());
            }
        }
        return roleIds;
    }





    public long countByExample(RUserRoleExample example) {
        return rUserRoleMapper.countByExample(example);
    }

    public int deleteByExample(RUserRoleExample example) {
        return rUserRoleMapper.deleteByExample(example);
    }

    public int deleteByPrimaryKey(Long id) {
        return rUserRoleMapper.deleteByPrimaryKey(id);
    }

    public int insert(RUserRole record) {
        return rUserRoleMapper.insert(record);
    }

    public int insertSelective(RUserRole record) {
        return rUserRoleMapper.insertSelective(record);
    }

    public List<RUserRole> selectByExample(RUserRoleExample example) {
        return rUserRoleMapper.selectByExample(example);
    }

    public RUserRole selectByPrimaryKey(Long id) {
        return rUserRoleMapper.selectByPrimaryKey(id);
    }

    public int updateByExampleSelective(RUserRole record, RUserRoleExample example) {
        return rUserRoleMapper.updateByExampleSelective(record, example);
    }

    public int updateByExample(RUserRole record, RUserRoleExample example) {
        return rUserRoleMapper.updateByExample(record, example);
    }

    public int updateByPrimaryKeySelective(RUserRole record) {
        return rUserRoleMapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(RUserRole record) {
        return rUserRoleMapper.updateByPrimaryKey(record);
    }
}

