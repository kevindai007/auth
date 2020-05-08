package com.kevindai.auth.security.utils;

import java.util.Random;

/**
 * @Author: xm20200119
 * @Date: 08/05/2020 22:50
 */
public class CaptchaUtil {
    private static char mapTable[] = {
            '0', '1', '2', '3', '4', '5',
            '6', '7', '8', '9', '0', '1',
            '2', '3', '4', '5', '6', '7',
            '8', '9', 'a', 'b', 'c', 'd',
            'e', 'f', 'g', 'h', 'i', 'j',
            'k', 'l', 'm', 'n', 'o', 'p',
            'q', 'r' ,'s', 't', 'u', 'v',
            'w', 'x', 'y', 'z'};
    public static String getCaptcha() {
        //取随机产生的码
        StringBuilder strEnsure = new StringBuilder();
        //4代表4位验证码,如果要生成更多位的认证码,则加大数值
        for (int i = 0; i < 4; ++i) {
            strEnsure.append(mapTable[new Random().nextInt(mapTable.length)]);
        }
        return strEnsure.toString();
    }
}
