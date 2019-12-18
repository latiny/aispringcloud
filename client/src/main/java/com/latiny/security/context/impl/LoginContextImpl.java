package com.latiny.security.context.impl;

import com.latiny.entity.SysUser;
import com.latiny.security.context.LoginContext;
import com.latiny.security.context.LoginContextHolder;
import org.springframework.stereotype.Service;

/**
 * @author Latiny
 * @version 1.0
 * @description: LoginContextImpl
 * @date 2019/12/17 16:58
 */
@Service
public class LoginContextImpl implements LoginContext {

    @Override
    public SysUser getSysUser() {
        return LoginContextHolder.getSysUser();
    }
}
