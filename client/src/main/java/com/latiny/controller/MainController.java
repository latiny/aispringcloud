package com.latiny.controller;

import com.latiny.security.context.LoginContext;
import com.netflix.ribbon.proxy.annotation.Http;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * @author Latiny
 * @version 1.0
 * @description: MainController
 * @date 2019/12/13 16:01
 */
@Controller
public class MainController {

    @Autowired
    private LoginContext loginContext;

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping("/manage")
    public String mange(HttpSession session) {
        session.setAttribute("user", loginContext.getUser());
        return "manage/manage";
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
