package com.ebupt.listener;

import com.ebupt.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import java.io.Serializable;

/**
 * @Author: yushibo
 * @Date: 2019/5/25 0025 16:24
 * @Description:
 */

public class QueueMessageListener implements MessageListener {

    private Logger logger = LoggerFactory.getLogger(QueueMessageListener.class);


    @Autowired
    private OrderService orderService;

    /**
     * 如果有消息就会异步触发这个方法
     * @param message
     */
    @Override
    public void onMessage(Message message) {
        if (message instanceof ObjectMessage) {
            ObjectMessage message1 = (ObjectMessage) message;
            try {
                //1、从MQ里面拿到消息
                com.ebupt.bean.Message object = (com.ebupt.bean.Message)message1.getObject();
                //2、查询message表，看是否已经扣款
               int count =  orderService.queryMessageCountByMessageId(object.getMessageId());

                if (count ==0) {
                    //3、更新accout，插入message

//                    orderService.updateAmount(object.getAmount(),object.getUserId());
//                    orderService.insertMessage(object.getUserId(),object.getMessageId(),object.getAmount(),"ok");
                }else {
                    logger.info("异常转账");
                }

                //4、回调
            } catch (JMSException e) {
                e.printStackTrace();
            }
        }
    }
}
