package com.ebupt.sender;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author: yushibo
 * @Date: 2019/5/25 0025 22:57
 * @Description:
 */

public class RabbitmqSender {

    private Logger logger = LoggerFactory.getLogger(RabbitmqSender.class);

    @Autowired
    private AmqpTemplate template;

    public void sendMessage(String exchange,String roukeKey,String context) {
        template.convertAndSend(exchange,roukeKey,context);
    }
}
