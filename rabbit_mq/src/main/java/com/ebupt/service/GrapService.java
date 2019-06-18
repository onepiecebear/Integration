package com.ebupt.service;

import com.ebupt.entity.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Random;

/**
 * @Author: yushibo
 * @Date: 2019/5/20 0020 23:11
 * @Description: 持续出票接口
 */

public class GrapService {

    @Autowired
    private TicketService ticketService;

    //100个线程同时执行
    @Transactional
    public String grapTicket(){
        //请求过来去数据进行查询是否余票
        List<Ticket> tickets = ticketService.queryAllTicket();
        if (tickets.size() == 0) {
        //1、余票不足
            return "{\"respCode\":\"1\"}";
        }
        int ticketIndex = new Random().nextInt(tickets.size());
        //有票 通过下标索引去找到这张票
        Ticket ticket = tickets.get(ticketIndex);
        //乐观锁
        int i = ticketService.updateTicket(ticket);
        if (i==1) {
            //出票成功
            //更新票的状态
            ticketService.updateTicketState(ticket);
            return "{\"respCode\":\"2\",\"ticket\":"+ticket.toString()+"}";
        }else {
            //抢票失败，余票不确定
            return "{\"respCode\":\"3\"}";

        }
        }
}
