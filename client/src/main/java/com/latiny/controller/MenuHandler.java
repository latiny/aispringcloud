package com.latiny.controller;


import com.latiny.feign.MenuFeign;
import com.latiny.vo.MenuVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author Latiny
 * @version 1.0
 * @description: ClientHandler
 * @date 2019/12/3 15:13
 */
@Controller
@RequestMapping("/client")
public class MenuHandler {

    @Autowired
    private MenuFeign menuFeign;

    @GetMapping("/findAll")
    @ResponseBody
    public MenuVO findAll(@RequestParam("page") int page, @RequestParam("limit") int limit) {
        int index = (page - 1) * limit;
        return menuFeign.findAll(index, limit);
    }

    @GetMapping("/redirect/{location}")
    public String redirect(@PathVariable("location") String location) {
        return location;
    }

    @GetMapping("/deleteById/{id}")
    public String deleteById(@PathVariable("id") long id) {
        menuFeign.deleteById(id);
        return "redirect:/client/redirect/index";
    }
}
