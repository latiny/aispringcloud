package com.latiny.controller;


import com.latiny.entity.User;
import com.latiny.feign.UserFeign;
import com.latiny.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;

/**
 * @author Latiny
 * @version 1.0
 * @description: ClientHandler
 * @date 2019/12/3 15:13
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserFeign userFeign;

    @GetMapping("/user_manage")
    public String userManage() {
        return "users/user_manage";
    }

    @GetMapping("/user_add")
    public String userAdd() {
        return "users/user_add";
    }

    @GetMapping("/findAll")
    @ResponseBody
    public ResultVO findAll(@RequestParam("page") int page, @RequestParam("limit") int limit) {
        int index = (page - 1) * limit;
        return userFeign.findAll(index, limit);
    }

    @GetMapping("/deleteById/{id}")
    public String deleteById(@PathVariable("id") long id) {
        userFeign.deleteById(id);
        return "users/user_manage";
    }

    @PostMapping("/save")
    public String save(User user) {
        user.setRegisterDate(user.getRegisterDate()==null ? new Date() : user.getRegisterDate());
        userFeign.save(user);
        return "users/user_manage";
    }

    @GetMapping("/findById/{id}")
    public ModelAndView findById(@PathVariable("id") long id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("users/user_edit");
        modelAndView.addObject("users", userFeign.findById(id));
        return modelAndView;
    }

    @PostMapping("/update")
    public String update(User user) {
        userFeign.update(user);
        return "users/user_manage";
    }
}
