package com.ebupt.controller;

import com.ebupt.service.OrderService;
import com.ebupt.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: yushibo
 * @Date: 2019/5/21 0021 0:59
 * @Description:
 */

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;


    @RequestMapping("/queryOrder")
    public Order queryOrder(String orderId){
       return orderService.queryOrderById(orderId);
    }

    @RequestMapping("/sendOrder")
    public String  sendOrder(String orderId){
        return orderService.sendOrder(orderId);
    }
}
