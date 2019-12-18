package com.latiny.controller;

import com.latiny.domain.UserDomain;
import com.latiny.feign.AccountFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping("/findAll")
    @ResponseBody
    public List<UserDomain> findAll() {
        return accountFeign.findAll();
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/redirect/{location}")
    public String redirect(@PathVariable("location") String location) {
        return location;
    }
}
