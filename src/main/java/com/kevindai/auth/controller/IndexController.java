package com.kevindai.auth.controller;

import com.kevindai.auth.dto.UserNormalLoginRequest;
import com.kevindai.auth.service.UserInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: xm20200119
 * @Date: 21/04/2020 23:59
 */
@Slf4j
@RestController
public class IndexController {
    @Autowired
    private UserInfoService userInfoService;

    @PostMapping("/login")
    public String login(@RequestBody UserNormalLoginRequest userNormalLoginRequest) {
        return userInfoService.login(userNormalLoginRequest.getUsername(), userNormalLoginRequest.getPassword(), userNormalLoginRequest.getRememberMe());
    }

}
