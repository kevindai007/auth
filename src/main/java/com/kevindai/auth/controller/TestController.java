package com.kevindai.auth.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: xm20200119
 * @Date: 21/04/2020 23:27
 */
@RestController
public class TestController {

    @PreAuthorize("hasAuthority('TEST')")
    @GetMapping(value = "/bustest")
    public Object test(){
        return "ok";
    }
}
