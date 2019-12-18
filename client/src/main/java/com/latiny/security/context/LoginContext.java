package com.latiny.security.context;

import com.latiny.entity.SysUser;

/**
 * @author Latiny
 * @version 1.0
 * @description: LoginContext
 * @date 2019/12/17 16:58
 */
public interface LoginContext {

    SysUser getSysUser();
}
