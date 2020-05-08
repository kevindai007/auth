package com.kevindai.auth.dto;

import lombok.Data;

/**
 * @Author: xm20200119
 * @Date: 21/04/2020 23:58
 */
@Data
public class UserNormalLoginRequest {

    private String username;

    private String password;

    private Integer rememberMe;

}
