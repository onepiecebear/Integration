package com.ebupt.dao;

import com.ebupt.entity.Order;
import io.lettuce.core.dynamic.annotation.Param;

public interface OrderMapper {
    int insert(Order record);

    int insertSelective(Order record);

    Order queryOrderById(@Param("orderId") String orderId);

    int updateOrder(Order record);

    int  updateOrderByVersion(Order record);

}