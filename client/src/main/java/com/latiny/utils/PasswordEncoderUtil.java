package com.latiny.utils;

import org.apache.tomcat.util.security.MD5Encoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author Latiny
 * @version 1.0
 * @description: PasswordEncoderUtil
 * @date 2020/1/13 11:56
 */
public class PasswordEncoderUtil {

    private static BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    //加密,密码
    public static String encodePassword(String password){
        return bCryptPasswordEncoder.encode(password);
    }

    public static boolean matches(String target, String source) {
        return bCryptPasswordEncoder.matches(target, source);
    }

    public static void main(String[] args) {
        String str = "123456";
        String password = encodePassword(str);
        System.out.println(password);
        //进行密码对比第一个参数为未加密密码,第二个参数为加密后数据库中的密码
        boolean b = matches("123456", "$2a$10$lbnYDv.6YCp9lCZrfSQ6oui65c/9Fnj3qi2AxMEG3NhHdFX6S9LFy");
        System.out.println(b);
    }
}
