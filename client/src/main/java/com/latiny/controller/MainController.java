package com.latiny.controller;

import com.latiny.entity.SysUser;
import com.latiny.security.context.LoginContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * @author Latiny
 * @version 1.0
 * @description: TODO
 * @date 2019/12/13 16:01
 */
@Controller
@RequestMapping("/main")
public class MainController {

    @Autowired
    private LoginContext loginContext;

    @RequestMapping("/index")
    public String index() {
        return "product/index";
    }

    @RequestMapping("/login")
    public String login(HttpSession session) {
        return "login";
    }

    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "login";
    }

    @RequestMapping("/403")
    public String error403() {
        return "error_403";
    }
}
