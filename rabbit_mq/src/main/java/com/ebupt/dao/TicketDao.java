package com.ebupt.dao;

import com.ebupt.entity.Ticket;
import com.ebupt.entity.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: yushibo
 * @Date: 2019/5/1 0001 14:35
 * @Description:
 */

@Repository
public interface TicketDao {

    @Select("select * from ticket where ticket_id = #{id} and version = 0")
    Ticket queryAllTicketById(String id);
//#{version} =1 代表已经消费
    @Update("update ticket set version = #{version} +1  where ticketId = #{ticketId}  and version = #{version}")
    int updateTicket(Ticket ticket);

    @Select("select * from ticket where ticket_status = 0  and version = 0")
    List<Ticket> queryAllTicket();

    @Update("update ticket set ticket_status = 1 where ticketId = #{ticketId} and version = 1")
    int updateTicketState(Ticket ticket);


}
