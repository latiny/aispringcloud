package com.latiny.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Latiny
 * @version 1.0
 * @description: ProductController
 * @date 2019/12/13 16:02
 */
@Controller
@RequestMapping("product")
public class ProductController {

    @RequestMapping("/add")
    public String add() {
        return "product/add";
    }

    @RequestMapping("/updatea")
    public String updatea() {
        return "product/updatea";
    }

    @RequestMapping("/index")
    public String index() {
        return "product/index";
    }
}
