package com.ebupt.controller;

import com.ebupt.context.PayContextStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: yushibo
 * @Date: 2019/5/12 0012 22:49
 * @Description:
 */

@RestController
public class PayController {

    @Autowired
    public PayContextStrategy payContextStrategy;

    @RequestMapping("/pay")
    public String toPay(String payCode){
        return payContextStrategy.toPayHtml(payCode);
    }
}
