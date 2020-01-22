package com.latiny.controller;

import com.latiny.domain.OrderDomain;
import com.latiny.domain.OrderMenuDomain;
import com.latiny.feign.OrderFeign;
import com.latiny.security.context.LoginContext;
import com.latiny.vo.OrderVO;
import com.latiny.vo.ResultVO;
import org.hibernate.validator.constraints.pl.REGON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * @author Latiny
 * @version 1.0
 * @description: OrderController
 * @date 2019/12/17 16:02
 */
@Controller
@RequestMapping("/order")
public class OrderController {

    @Autowired
    OrderFeign orderFeign;
    @Autowired
    LoginContext loginContext;

    @GetMapping("/index")
    public String index() {
        return "order/order_index";
    }

    @GetMapping("/admin/orderList")
    public String orderList() {
        return "order/order_admin";
    }

    @GetMapping("/order_handler")
    public String orderHandler() {
        return "order/order_handler";
    }

    @RequestMapping("/save/{id}")
    public String save(@PathVariable("id") long meunId) {
        OrderVO orderVO = new OrderVO();
        orderVO.setUserId(loginContext.getUser().getId());
        orderVO.setMenuId(meunId);
        orderFeign.save(orderVO);
        return "order/order_index";
    }

    @GetMapping("/findAll")
    @ResponseBody
    public ResultVO findAll(@RequestParam("page") int index, @RequestParam("limit") int limit) {
        index = (index-1) * limit;
        List<OrderMenuDomain> list = orderFeign.findAll(index, limit);
        int count = orderFeign.count();
        if (CollectionUtils.isEmpty(list)) {
            return new ResultVO<OrderMenuDomain>(-1, "failed", 0, Collections.emptyList());
        }
        return new ResultVO<OrderMenuDomain>(0, "success", count, list);
    }

    @GetMapping("/findOrderByState")
    @ResponseBody
    public ResultVO findOrderByState(@RequestParam("page") int index, @RequestParam("limit") int limit) {
        index = (index-1) * limit;
        List<OrderMenuDomain> list = orderFeign.findOrderByState(0, index, limit);
        int count = orderFeign.count();
        if (CollectionUtils.isEmpty(list)) {
            list = Collections.EMPTY_LIST;
        }
        return new ResultVO(0, "success", count, list);
    }

    @GetMapping("/updateByOrderId/{id}")
    public String updateByOrderId(@PathVariable("id") long id) {
        OrderDomain orderDomain = new OrderDomain();
        orderDomain.setId(id);
        orderDomain.setUpdateTime(new Date());
        orderDomain.setState(1);
        orderDomain.setAdminId(loginContext.getUser().getId());
        orderFeign.updateByOrderId(orderDomain);
        return "order/order_handler";
    }
}
