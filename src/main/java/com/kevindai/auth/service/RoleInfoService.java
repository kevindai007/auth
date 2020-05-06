package com.kevindai.auth.service;

import com.kevindai.auth.domain.RoleInfo;
import com.kevindai.auth.domain.RoleInfoExample;
import com.kevindai.auth.mapper.RoleInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @Author: xm20200119
 * @Date: 21/04/2020 23:06
 */
@Service
public class RoleInfoService {

    @Resource
    private RoleInfoMapper roleInfoMapper;


    public long countByExample(RoleInfoExample example) {
        return roleInfoMapper.countByExample(example);
    }

    public int deleteByExample(RoleInfoExample example) {
        return roleInfoMapper.deleteByExample(example);
    }

    public int deleteByPrimaryKey(Long id) {
        return roleInfoMapper.deleteByPrimaryKey(id);
    }

    public int insert(RoleInfo record) {
        return roleInfoMapper.insert(record);
    }

    public int insertSelective(RoleInfo record) {
        return roleInfoMapper.insertSelective(record);
    }

    public List<RoleInfo> selectByExample(RoleInfoExample example) {
        return roleInfoMapper.selectByExample(example);
    }

    public RoleInfo selectByPrimaryKey(Long id) {
        return roleInfoMapper.selectByPrimaryKey(id);
    }

    public int updateByExampleSelective(RoleInfo record, RoleInfoExample example) {
        return roleInfoMapper.updateByExampleSelective(record, example);
    }

    public int updateByExample(RoleInfo record, RoleInfoExample example) {
        return roleInfoMapper.updateByExample(record, example);
    }

    public int updateByPrimaryKeySelective(RoleInfo record) {
        return roleInfoMapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(RoleInfo record) {
        return roleInfoMapper.updateByPrimaryKey(record);
    }
}

