package com.kevindai.auth.security.filter;

import com.kevindai.auth.security.entity.LoginSecurityUser;
import com.kevindai.auth.security.utils.JwtTokenUtil;
import com.kevindai.auth.service.UserDetailsServiceImpl;
import com.kevindai.auth.service.UserInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;
import java.util.Set;

/**
 * @Author: xm20200119
 * @Date: 26/04/2020 18:09
 */
@Slf4j
//@Component
public class JwtAuthenticationTokenFilter extends BasicAuthenticationFilter {

//    @Autowired
    private JwtTokenUtil jwtTokenUtil;


    public JwtAuthenticationTokenFilter(AuthenticationManager authenticationManager,JwtTokenUtil jwtTokenUtil) {
        super(authenticationManager);
        this.jwtTokenUtil = jwtTokenUtil;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        LoginSecurityUser securityUser = jwtTokenUtil.getUserFromToken(request);
        if (securityUser != null) {
            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(securityUser, null, securityUser.getAuthorities());
            authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
            SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        }
        filterChain.doFilter(request, response);
    }
}
