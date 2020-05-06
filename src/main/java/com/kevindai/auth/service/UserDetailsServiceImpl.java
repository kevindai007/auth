package com.kevindai.auth.service;

import com.kevindai.auth.domain.UserInfo;
import com.kevindai.auth.security.entity.LoginSecurityUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

/**
 * @Author: xm20200119
 * @Date: 21/04/2020 23:39
 */
@Service
@Slf4j
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserInfoService userInfoService;

    @Autowired
    private MenuInfoService menuInfoService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserInfo userInfo = userInfoService.findByName(username);
        if (userInfo == null) {
            log.info("登录用户：" + username + " 不存在.");
            throw new UsernameNotFoundException("登录用户：" + username + " 不存在");
        }
        Collection<? extends GrantedAuthority> authorities = getUserAuthorities(userInfo.getId());
        return new LoginSecurityUser(userInfo.getId(), username, userInfo.getPassword(), authorities);

    }


    private Collection<? extends GrantedAuthority> getUserAuthorities(Long userId) {
        List<String> components = menuInfoService.findComponentByUserId(userId);
        return AuthorityUtils.createAuthorityList(components.toArray(new String[0]));
    }


}
