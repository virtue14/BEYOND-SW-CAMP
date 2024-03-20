package com.ohgiraffers.userservice.vo;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ResponseOrder {
    private String orderDate;
    private String orderTime;

    private List<OrderMenuVO> orderMenus;

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(String orderTime) {
        this.orderTime = orderTime;
    }

    public List<OrderMenuVO> getOrderMenus() {
        return orderMenus;
    }

    public void setOrderMenus(List<OrderMenuVO> orderMenus) {
        this.orderMenus = orderMenus;
    }
}
