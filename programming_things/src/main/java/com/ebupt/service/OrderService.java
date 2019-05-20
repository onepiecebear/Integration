package com.ebupt.service;

import com.ebupt.dao.OrderMapper;
import com.ebupt.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import javax.annotation.Resource;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

/**
 * @Author: yushibo
 * @Date: 2019/5/21 0021 0:24
 * @Description:
 */
@Service
public class OrderService {

    @Resource
    private OrderMapper orderMapper;

    @Autowired
    private TransactionTemplate transactionTemplate;

    public Order queryOrderById(String orderId){
       return orderMapper.queryOrderById(orderId);
    }

    //声明式事务
    @Transactional
    public String sendOrder(String orderId){
        String status = invoke();


        Order order = new Order();
//        order.setOrderId(UUID.randomUUID().toString());
        order.setOrderId(orderId);
        order.setStatus("2");
        orderMapper.updateOrder(order);
        return status;
    }

    /**
     * 锁的方式
     * 悲观锁：比较霸道，锁表操作
     * 乐观锁：version
     * update `order` set orderStatus =1 ,version=version+1 where orderId= 5 and version =0;
     * @param orderId
     * @return
     */


    //编程式事务
    public String sendOrderByTemplate(String orderId){


        boolean isInvoke =  transactionTemplate.execute(new TransactionCallback<Boolean>() {
            @Override
            public Boolean doInTransaction(TransactionStatus transactionStatus) {
                //更改语句
                Order order = new Order();
                order.setOrderId(orderId);
                //准备发货状态
                order.setStatus("3");
                //****重点
                return 1==orderMapper.updateOrderByVersion(order);
            }
        });
        String status = "";
        if(isInvoke){
            //状态修改成功以后，接下来就调用远程接口
            status = invoke();

            //把状态变成正在处理状态，编程式事务
            String finalStatus = status;
            transactionTemplate.execute(new TransactionCallback<Object>() {
                @Override
                public Object doInTransaction(TransactionStatus transactionStatus) {
                    Order order = new Order();
                    order.setOrderId(orderId);
                    //准备发货状态
                    order.setStatus(finalStatus);
                    orderMapper.updateOrder(order);
                    return null;

                }
            });
        }else{
            System.out.println("远程接口调用失败");
        }
        return status;
    }














    //模拟远程调用第三方接口
    protected static String invoke(){
        //休眠10S
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
            return "-1";
        }
        return "1";
    }
}
