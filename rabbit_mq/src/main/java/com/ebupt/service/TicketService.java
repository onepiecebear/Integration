package com.ebupt.service;


import com.ebupt.dao.TicketDao;
import com.ebupt.entity.Ticket;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: yushibo
 * @Date: 2019/5/26 0026 14:34
 * @Description:
 */

@Service
public class TicketService {

    @Autowired
    private TicketDao ticketDao;

    public List<Ticket> queryAllTicket(){
        return ticketDao.queryAllTicket();
    }

    public Ticket queryAllTicketById(String id){
        return ticketDao.queryAllTicketById(id);
    }
    public int updateTicket(Ticket ticket){
        return ticketDao.updateTicket(ticket);
    }
    public int updateTicketState(Ticket ticket){
        return ticketDao.updateTicketState(ticket);
    }
}
