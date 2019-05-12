package com.ebupt.strategy.impl;

import com.ebupt.strategy.PayStrategy;
import org.springframework.stereotype.Component;

/**
 * @Author: yushibo
 * @Date: 2019/5/12 0012 22:47
 * @Description:
 */
@Component
public class AliPayStrategy implements PayStrategy {
    @Override
    public String toPay() {
        return "阿里云支付";
    }
}
