package com.ebupt.receive;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

/**
 * @Author: yushibo
 * @Date: 2019/5/26 0026 11:28
 * @Description:
 */

public class TicketBusiness {

    private Logger logger = LoggerFactory.getLogger(TicketBusiness.class);
//str : ok --->购票提交
    @RabbitListener(queues = "response")
    public void processMsg(String ticketInfo){
        if (ticketInfo.contains("出票成功")) {
            logger.info("-----"+ticketInfo);

        }else if (ticketInfo.contains("出票失败")){
            logger.info("-----"+ticketInfo);
        }



    }
}
