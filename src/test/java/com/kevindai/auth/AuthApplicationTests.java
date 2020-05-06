package com.kevindai.auth;

import com.kevindai.auth.domain.UserInfo;
import com.kevindai.auth.service.UserInfoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

@SpringBootTest
class AuthApplicationTests {

    @Autowired
    private UserInfoService userInfoService;

    @Test
    void contextLoads() {
        UserInfo kevindai = userInfoService.findByName("kevin");
        Assert.notNull(kevindai,"this cannot be empty");
    }

}
