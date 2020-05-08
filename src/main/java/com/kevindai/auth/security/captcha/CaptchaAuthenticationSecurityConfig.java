package com.kevindai.auth.security.captcha;

import com.kevindai.auth.security.filter.JwtAuthenticationTokenFilter;
import com.kevindai.auth.security.utils.JwtTokenUtil;
import com.kevindai.auth.service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.stereotype.Component;

/**
 * springsecurity 验证码拦截配置
 *
 * @Author: xm20200119
 * @Date: 07/05/2020 22:10
 */
@Component
public class CaptchaAuthenticationSecurityConfig extends SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity> {
    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Override
    public void configure(HttpSecurity http) {
        CaptchaAuthenticationProvider captchaAuthenticationProvider = new CaptchaAuthenticationProvider();
        captchaAuthenticationProvider.setUserDetailsService(userDetailsService);
        http.authenticationProvider(captchaAuthenticationProvider);
    }
}
