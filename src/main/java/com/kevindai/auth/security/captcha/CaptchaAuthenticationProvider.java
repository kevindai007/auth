package com.kevindai.auth.security.captcha;

import com.kevindai.auth.service.UserDetailsServiceImpl;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * @Author: xm20200119
 * @Date: 07/05/2020 21:51
 */
@Getter
@Setter
public class CaptchaAuthenticationProvider implements AuthenticationProvider {
    private UserDetailsServiceImpl userDetailsService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        CaptchaAuthenticationToken authenticationToken = (CaptchaAuthenticationToken) authentication;

        String mobile = (String) authenticationToken.getPrincipal();

        UserDetails userDetails = userDetailsService.loadUserByUsername(mobile);

        // 此时鉴权成功后，应当重新 new 一个拥有鉴权的 authenticationResult 返回
        CaptchaAuthenticationToken authenticationResult = new CaptchaAuthenticationToken(userDetails, userDetails.getAuthorities());

        authenticationResult.setDetails(authenticationToken.getDetails());

        return authenticationResult;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        // 判断 authentication 是不是 SmsCodeAuthenticationToken 的子类或子接口
        return CaptchaAuthenticationToken.class.isAssignableFrom(aClass);
    }
}
