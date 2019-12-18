package com.latiny.controller;


import com.latiny.entity.Menu;
import com.latiny.entity.SysUser;
import com.latiny.feign.MenuFeign;
import com.latiny.security.context.LoginContext;
import com.latiny.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

/**
 * @author Latiny
 * @version 1.0
 * @description: ClientHandler
 * @date 2019/12/3 15:13
 */
@Controller
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    private MenuFeign menuFeign;
    @Autowired
    private LoginContext loginContext;

    @GetMapping("/menu_manage")
    public String menuManage(HttpSession session) {
        SysUser user = loginContext.getSysUser();
        session.setAttribute("user", user);
        return "menu/menu_manage";
    }

    @GetMapping("/findAll")
    @ResponseBody
    public ResultVO findAll(@RequestParam("page") int page, @RequestParam("limit") int limit) {
        int index = (page - 1) * limit;
        return menuFeign.findAll(index, limit);
    }

    @GetMapping("/deleteById/{id}")
    public String deleteById(@PathVariable("id") long id) {
        menuFeign.deleteById(id);
        return "menu/menu_manage";
    }

    @GetMapping("/findTypes")
    public ModelAndView findTypes() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/menu/menu_add");
        modelAndView.addObject("list", menuFeign.findTypes());
        return modelAndView;
    }

    @PostMapping("/save")
    public String save(Menu menu) {
        menuFeign.save(menu);
        return "menu/menu_manage";
    }

    @GetMapping("/findById/{id}")
    public ModelAndView findById(@PathVariable("id") long id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/menu/menu_edit");
        modelAndView.addObject("menu", menuFeign.findById(id));
        modelAndView.addObject("list", menuFeign.findTypes());
        return modelAndView;
    }

    @PostMapping("/update")
    public String update(Menu menu) {
        menuFeign.update(menu);
        return "menu/menu_manage";
    }
}
