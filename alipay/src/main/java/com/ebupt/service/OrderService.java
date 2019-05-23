package com.ebupt.service;

import com.fasterxml.jackson.databind.annotation.JsonAppend;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sun.plugin2.message.Message;

import javax.jms.JMSException;
import javax.jms.Session;

/**
 * @Author: yushibo
 * @Date: 2019/5/23 18:17
 * @Description:
 */

@Service("activemq")
public class OrderService {

    private Logger logger = LoggerFactory.getLogger(OrderService.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;
    private int count;

    @Autowired
    private JmsTemplate jmsTemplate;

    @Transactional(rollbackFor = Exception.class)
    public void updateAmount(int amount, String userId ,String messageId){

        String sql ="update account set amount = amount - ?,update_time =now() where user_id=?";

        int count = jdbcTemplate.update(sql, new Object[]{amount, userId});
        if (count==1) {
            //2.往message表里面插入数据
            sql = "INSERT INTO  MESSAGE(user_id,message_id,amount,status) VALUES (?,?,?,?)";

            int row = jdbcTemplate.update(sql, new Object[]{userId, messageId, amount, "unconfirm"});
            if (row==1) {
                //3.往消息中间件插入消息
                jmsTemplate.send("zg.jack.queue", new MessageCreator() {
                    @Override
                    public javax.jms.Message createMessage(Session session) throws JMSException {
                        com.ebupt.bean.Message message = new com.ebupt.bean.Message();
                        message.setUserId(userId);
                        message.setMessageId(messageId);
                        message.setAmount(amount);
                        message.setStatus("unconfirm");
                        return session.createObjectMessage(message);
                    }
                });
            }
        }
    }

    public  void updateMessage(String param){

    }
}
