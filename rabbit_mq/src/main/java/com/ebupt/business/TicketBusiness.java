package com.ebupt.business;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ebupt.sender.RabbitmqSender;
import com.ebupt.service.GrapService;
import com.ebupt.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.concurrent.TimeUnit;

/**
 * @Author: yushibo
 * @Date: 2019/5/26 0026 11:28
 * @Description: 12306服务
 */

public class TicketBusiness {

    @Autowired
    private GrapService grapService;

    @Autowired
    private RabbitmqSender rabbitmqSender;


    private Logger logger = LoggerFactory.getLogger(TicketBusiness.class);
//str : ok --->购票提交
    @RabbitListener(queues = "ticket")
    public void process(String str){
        try {
            long t1 = System.currentTimeMillis();
            logger.info(Thread.currentThread().getName() + "---正在处理美团APP出表请求");
            String ticketInfo = grapService.grapTicket();
            JSONObject jsonObject = JSON.parseObject(ticketInfo);
            String respCode = jsonObject.getString("respCode");
            if (respCode.equals("2")) {
                String  ticketvStr = jsonObject.getString("ticket");
                //响应给美团--->MQ投递模型
                logger.info(Thread.currentThread().getName() + "---当前线程出票请求成功---"+ticketvStr);

                rabbitmqSender.sendMessage("exchange-response","12306","出票成功："+ticketvStr);

            }else if (respCode.equals("1")){
                logger.info(Thread.currentThread().getName() + "---当前线程余票不足---");
                rabbitmqSender.sendMessage("exchange-response","12306","出票失败");

            }else{
                //再次进行抢票
                while (true){
                    TimeUnit.MICROSECONDS.sleep(1000);
                    String ticketInfo2 = grapService.grapTicket();
                    JSONObject jsonObject2 = JSON.parseObject(ticketInfo2);
                    String respCode2 = jsonObject2.getString("respCode");
                    if (respCode2.equals("2")) {
                        String  ticketvStr = jsonObject.getString("ticket");
                        //响应给美团--->MQ投递模型
                        logger.info(Thread.currentThread().getName() + "---当前线程出票请求成功---"+ticketvStr);

                        rabbitmqSender.sendMessage("exchange-response","12306","出票成功："+ticketvStr);
                        break;
                    }else if (respCode2.equals("1")){
                        logger.info(Thread.currentThread().getName() + "---当前线程余票不足---");
                        rabbitmqSender.sendMessage("exchange-response","12306","出票失败");
                        break;
                    }else{
                        continue;
                    }
                }


            }

            logger.info(Thread.currentThread().getName() + "---抢票耗时---" + (System.currentTimeMillis() - t1) + "MS");

        }catch (Exception e){
            logger.info(Thread.currentThread().getName() + "---请求失败，系统异常---");
        }

    }
}
