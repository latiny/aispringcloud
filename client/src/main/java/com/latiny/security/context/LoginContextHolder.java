package com.latiny.security.context;

import com.latiny.entity.SysUser;
import com.latiny.security.MyUserDetails;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * 登录上下文
 */
public abstract class LoginContextHolder {

    public static SysUser getSysUser() {
        Object param = getAuthentication();
        if (param == null) {
            return null;
        }
        if (param instanceof MyUserDetails) {
            return getUserDetails().getSysUser();
        }
        return null;
    }

    private static Object getAuthentication() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null) {
            return null;
        }
        Object param = authentication.getPrincipal();
        return param;
    }

    private static MyUserDetails getUserDetails() {
        return (MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
}
