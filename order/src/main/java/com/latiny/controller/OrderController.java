package com.latiny.controller;

import com.latiny.domain.OrderDomain;
import com.latiny.domain.OrderMenuDomain;
import com.latiny.mapper.OrderMapper;
import com.latiny.vo.OrderVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * @author Latiny
 * @version 1.0
 * @description: OrderHandler
 * @date 2019/11/27 17:57
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderMapper orderMapper;

    @RequestMapping("/findAll")
    public List<OrderMenuDomain> findAll(@RequestParam("index") int index, @RequestParam("limit") int limit) {
        List<OrderMenuDomain> list = orderMapper.findAll(index, limit);
        if (CollectionUtils.isEmpty(list)) {
            return Collections.emptyList();
        }
        return list;
    }

    @PostMapping("/save")
    public void save(@RequestBody OrderVO orderVO) {
        Date nowTime = new Date();
        OrderDomain orderDomain = new OrderDomain();
        orderDomain.setUserId(orderVO.getUserId());
        orderDomain.setMenuId(orderVO.getMenuId());
        orderDomain.setAdminId(0L);
        orderDomain.setCreateTime(nowTime);
        orderDomain.setUpdateTime(nowTime);
        orderDomain.setState(0);
        orderDomain.setIsDeleted(0);
        orderMapper.insert(orderDomain);
    }

    @GetMapping("/count")
    public Integer count(){
        return orderMapper.count();
    }

    @RequestMapping("/findOrderByState")
    public List<OrderMenuDomain> findOrderByState(@RequestParam("state") int state, @RequestParam("index") int index, @RequestParam("limit") int limit) {
        List<OrderMenuDomain> list = orderMapper.findOrderByState(state, index, limit);
        if (CollectionUtils.isEmpty(list)) {
            return Collections.emptyList();
        }
        return list;
    }

    @PutMapping("/updateByOrderId")
    public void updateByOrderId(@RequestBody OrderDomain orderDomain) {
        orderDomain.setUpdateTime(new Date());
        orderMapper.updateByOrderId(orderDomain);
    }
}
