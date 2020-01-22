package com.latiny.mapper;

import com.latiny.domain.OrderDomain;
import com.latiny.domain.OrderMenuDomain;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author Latiny
 * @version 1.0
 * @description: OrderMapper
 * @date 2019/12/18 10:29
 */
@Mapper
public interface OrderMapper {

    void insert(OrderDomain domain);

    List<OrderMenuDomain> findAll(int index, int limit);

    void updateByOrderId(OrderDomain domain);

    OrderDomain findByOrderId(Long id);

    Integer count();

    List<OrderMenuDomain> findOrderByState(int state, int index, int limit);
}