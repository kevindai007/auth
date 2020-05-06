package com.kevindai.auth.service;

import com.kevindai.auth.domain.UserInfo;
import com.kevindai.auth.domain.UserInfoExample;
import com.kevindai.auth.mapper.UserInfoMapper;
import com.kevindai.auth.security.entity.LoginSecurityUser;
import com.kevindai.auth.security.utils.JwtTokenUtil;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
public class UserInfoService {

    @Resource
    private UserInfoMapper userInfoMapper;
    @Autowired
    private RUserRoleService rUserRoleService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private MenuInfoService menuInfoService;

    @Value("${jwt.token.prefix}")
    private String tokenPrefix;

    public UserInfo findByName(String username) {
        UserInfoExample example = new UserInfoExample();
        UserInfoExample.Criteria criteria = example.createCriteria();
        criteria.andUsernameEqualTo(username);

        List<UserInfo> userInfos = userInfoMapper.selectByExample(example);
        if (CollectionUtils.isNotEmpty(userInfos)) {
            return userInfos.get(0);
        }
        return null;

    }


    public String login(String username, String password, Integer rememberMe) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        LoginSecurityUser userDetail = (LoginSecurityUser) authentication.getPrincipal();
        return tokenPrefix + JwtTokenUtil.generateToken(userDetail, rememberMe != 0);
    }

    public Set<String> findPermsByUserId(Long userId) {
        return menuInfoService.findComponentByUserId(userId).stream().filter(StringUtils::isNotEmpty).collect(Collectors.toSet());
    }


    public long countByExample(UserInfoExample example) {
        return userInfoMapper.countByExample(example);
    }

    public int deleteByExample(UserInfoExample example) {
        return userInfoMapper.deleteByExample(example);
    }

    public int deleteByPrimaryKey(Long id) {
        return userInfoMapper.deleteByPrimaryKey(id);
    }

    public int insert(UserInfo record) {
        return userInfoMapper.insert(record);
    }

    public int insertSelective(UserInfo record) {
        return userInfoMapper.insertSelective(record);
    }

    public List<UserInfo> selectByExample(UserInfoExample example) {
        return userInfoMapper.selectByExample(example);
    }

    public UserInfo selectByPrimaryKey(Long id) {
        return userInfoMapper.selectByPrimaryKey(id);
    }

    public int updateByExampleSelective(UserInfo record, UserInfoExample example) {
        return userInfoMapper.updateByExampleSelective(record, example);
    }

    public int updateByExample(UserInfo record, UserInfoExample example) {
        return userInfoMapper.updateByExample(record, example);
    }

    public int updateByPrimaryKeySelective(UserInfo record) {
        return userInfoMapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(UserInfo record) {
        return userInfoMapper.updateByPrimaryKey(record);
    }

    public static void main(String[] args) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String encode = bCryptPasswordEncoder.encode("12345");
        System.out.println(encode);
    }
}

