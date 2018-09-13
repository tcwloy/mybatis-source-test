package com.github.tcwloy.mybatis.mapper;


import com.github.tcwloy.mybatis.entity.Order;

import java.util.List;

public interface OrderExtMapper {
    List<Order> getOrderByUserId(Integer userId);
}
