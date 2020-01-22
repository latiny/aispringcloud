package com.latiny.controller;

import com.latiny.domain.UserDomain;
import com.latiny.entity.SysUser;
import com.latiny.feign.AccountFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author Latiny
 * @version 1.0
 * @description: AccountController
 * @date 2019/12/9 21:44
 */
@Controller
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountFeign accountFeign;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping("/findAll")
    @ResponseBody
    public List<UserDomain> findAll() {
        return accountFeign.findAll();
    }

    @GetMapping("/redirect/{location}")
    public String redirect(@PathVariable("location") String location) {
        return location;
    }
}
