package com.latiny.controller;

import org.hibernate.validator.constraints.pl.REGON;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Latiny
 * @version 1.0
 * @description: OrderController
 * @date 2019/12/17 16:02
 */
@Controller
@RequestMapping("/order")
public class OrderController {

    @RequestMapping("/index")
    public String index() {
        return "/order/order_index";
    }
}
