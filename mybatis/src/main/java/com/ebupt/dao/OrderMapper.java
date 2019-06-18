package com.ebupt.dao;

import com.ebupt.entity.Order;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderMapper {
    int insert(Order record);

    int insertSelective(Order record);
}