package com.latiny.security;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author Latiny
 * @version 1.0
 * @description: MyAuthenticationFailureHandler
 * @date 2019/10/8 14:49
 */
@Component
public class MyAuthenticationFailureHandler implements AuthenticationFailureHandler {

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException e) throws IOException, ServletException {
        response.setContentType("application/json;charset=utf-8");
        PrintWriter out = response.getWriter();
        StringBuffer sb = new StringBuffer();
        sb.append("{\"status\":\"error\",\"msg\":\"");
        if (e instanceof UsernameNotFoundException || e instanceof BadCredentialsException) {
            sb.append("用户名或密码输入错误，登录失败!");
        } else if (e instanceof DisabledException) {
            sb.append("账户被禁用，登录失败，请联系管理员!");
        } else {
            sb.append("登录失败");
        }
        sb.append("\"}");
        out.write(sb.toString());
        out.flush();
        out.close();
    }
}
