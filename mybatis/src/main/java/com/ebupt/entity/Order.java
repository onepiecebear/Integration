package com.ebupt.entity;

import java.io.Serializable;

public class Order implements Serializable {
    private String orderName;

    private String orderDes;

    private static final long serialVersionUID = 1L;

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName == null ? null : orderName.trim();
    }

    public String getOrderDes() {
        return orderDes;
    }

    public void setOrderDes(String orderDes) {
        this.orderDes = orderDes == null ? null : orderDes.trim();
    }
}