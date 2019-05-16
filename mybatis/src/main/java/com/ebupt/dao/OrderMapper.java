package com.ebupt.dao;

import com.ebupt.entity.Order;

public interface OrderMapper {
    int insert(Order record);

    int insertSelective(Order record);
}