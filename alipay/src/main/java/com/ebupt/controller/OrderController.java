package com.ebupt.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: yushibo
 * @Date: 2019/5/23 18:12
 * @Description:
 */

@RestController
@RequestMapping("order")
public class OrderController {

    @RequestMapping(value = "/transfer")
    public String transferAmount(String userId, String messageId, int amount) {

        try {

        } catch (Exception e) {

        }

        return null;
    }

    @RequestMapping(value = "/callback")
    public String callback(String param) {

        return null;

    }
}