package com.kevindai.auth.security.config;

import com.kevindai.auth.security.captcha.CaptchaAuthenticationSecurityConfig;
import com.kevindai.auth.security.filter.JwtAuthenticationTokenFilter;
import com.kevindai.auth.security.utils.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsUtils;

/**
 * @Author: xm20200119
 * @Date: 21/04/2020 23:25
 */

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    @Qualifier("userDetailsServiceImpl")
    private UserDetailsService userDetailsService;

    @Autowired
    private CaptchaAuthenticationSecurityConfig captchaAuthenticationSecurityConfig;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;


    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder());
        auth.userDetailsService(userDetailsService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        http.cors().and().csrf().disable()
//                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//                .and().authorizeRequests()
//                .requestMatchers(CorsUtils::isPreFlightRequest).permitAll()
//                .antMatchers("/login/**").anonymous()
//                .antMatchers("/swagger-resources/**", "/favicon.ico", "/v2/api-docs/**").anonymous()
//                .antMatchers(HttpMethod.GET, "/*.html", "/**/*.html", "/**/*.css", "/**/*.js","/**/*.woff","/**/*.ttf")
//                .permitAll()
//                .antMatchers("/auth/**").anonymous()
//                .antMatchers("/file/**")
//                .permitAll()
//                .anyRequest().authenticated()
//                .and()
//                .headers().frameOptions().disable()
//        .and().addFilter(new JwtAuthenticationTokenFilter(authenticationManagerBean(),jwtTokenUtil));

        http.cors().and().csrf().disable()
                .apply(captchaAuthenticationSecurityConfig).and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and().authorizeRequests()
                .antMatchers("/login/**").anonymous()
                .antMatchers("/captcha/**").anonymous()
                .antMatchers("/swagger-resources/**", "/favicon.ico", "/v2/api-docs/**").anonymous()
                .antMatchers(HttpMethod.GET, "/*.html", "/**/*.html", "/**/*.css", "/**/*.js","/**/*.woff","/**/*.ttf").permitAll()
                .antMatchers("/auth/**").anonymous()
                .antMatchers("/file/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .headers().frameOptions().disable()
                .and().addFilterAfter(new JwtAuthenticationTokenFilter(authenticationManagerBean(),jwtTokenUtil), UsernamePasswordAuthenticationFilter.class);

//
//        http.exceptionHandling()
//                .authenticationEntryPoint(new JwtAuthenticationEntryPoint())
//                .accessDeniedHandler(new JwtAccessDeniedHandler());
    }
}
