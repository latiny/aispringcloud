package com.latiny.exception;

import org.springframework.security.authentication.BadCredentialsException;

/**
 * @author Latiny
 * @version 1.0
 * @description: MyBadCredentialsException
 * @date 2019/12/17 16:43
 */
public class MyBadCredentialsException extends BadCredentialsException {

    /**
     * 错误代码
     */
    private int errorCode;
    /**
     * 详细描述
     */
    private String message;

    public MyBadCredentialsException(String message) {
        super(message);
        this.message = message;
    }

    public MyBadCredentialsException(int errorCode, String message) {
        super(message);
        this.message = message;
        this.errorCode = errorCode;
    }
}
