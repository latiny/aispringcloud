package com.latiny.feign;

import com.latiny.domain.OrderDomain;
import com.latiny.domain.OrderMenuDomain;
import com.latiny.vo.OrderVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * @author Latiny
 * @version 1.0
 * @description: OrderFeign
 * @date 2019/12/18 14:15
 */
@FeignClient(value = "order", configuration = FeignConfig.class)
public interface OrderFeign {

    @PostMapping(value = "/order/save", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void save(@RequestBody OrderVO orderVO);

    @RequestMapping(value = "/order/findAll")
    public List<OrderMenuDomain> findAll(@RequestParam("index") int index, @RequestParam("limit") int limit);

    @GetMapping(value = "/order/count")
    public Integer count();

    @RequestMapping(value = "/order/findOrderByState")
    public List<OrderMenuDomain> findOrderByState(@RequestParam("state") int state, @RequestParam("index") int index, @RequestParam("limit") int limit);

    @PutMapping(value = "/order/updateByOrderId", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateByOrderId(@RequestBody OrderDomain orderDomain);
}
