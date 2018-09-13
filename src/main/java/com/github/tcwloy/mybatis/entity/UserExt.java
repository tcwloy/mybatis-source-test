package com.github.tcwloy.mybatis.entity;

import java.util.List;

public class UserExt extends User {
    public UserExt(Long id, String username, String password){
        super(id, username, password);
    }

    private List<Order> orders;

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}
