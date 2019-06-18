package com.ebupt.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Author: yushibo
 * @Date: 2019/5/25 0025 16:18
 * @Description: 模拟余额宝
 */

public class OrderService {

    private Logger logger = LoggerFactory.getLogger(OrderService.class);


    public void updateAmount(int amount, String userId ,String messageId){
    }
    public int queryMessageCountByMessageId(String messageId){
        return 0;
    }
    public int insertMessage( String userId ,String messageId,int amount){
        return 0;
    }

}
