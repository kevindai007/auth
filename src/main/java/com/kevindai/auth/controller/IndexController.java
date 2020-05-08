package com.kevindai.auth.controller;

import com.kevindai.auth.dto.UserNormalLoginRequest;
import com.kevindai.auth.security.utils.CaptchaUtil;
import com.kevindai.auth.service.UserInfoService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;

/**
 * @Author: xm20200119
 * @Date: 21/04/2020 23:59
 */
@Slf4j
@RestController
public class IndexController {
    @Autowired
    private UserInfoService userInfoService;

    private HashMap<String,String> cache = new HashMap();

    @PostMapping("/login")
    public String login(@RequestBody UserNormalLoginRequest userNormalLoginRequest) {
        return userInfoService.login(userNormalLoginRequest.getUsername(), userNormalLoginRequest.getPassword(), userNormalLoginRequest.getRememberMe());
    }


    @GetMapping(value = "/captcha")
    public String captcha(HttpServletResponse response, HttpSession httpSession) {
        String captcha = CaptchaUtil.getCaptcha();
        String id = httpSession.getId();
        cache.put(id,captcha);
        return captcha;
    }

    @GetMapping(value = "/captcha/{mobile}/{code}")
    public String smsCaptcha(@PathVariable(value = "mobile") String mobile,
                             @PathVariable(value = "code") String code,
                             HttpSession httpSession) {
        if(StringUtils.isNotBlank(cache.get(httpSession.getId()))
            && cache.get(httpSession.getId()).equalsIgnoreCase(code)){
            return userInfoService.captchLogin(mobile,1);
        }
        return "failed";

    }
}
