package com.ebupt.entity;

/**
 * @Author: yushibo
 * @Date: 2019/5/26 0026 14:36
 * @Description:
 */

public class Ticket {

    private Integer ticket_id;
    private Integer ticket_money;
    private String ticket_time;
    private Integer ticket_status;
    private Integer version;

    public Integer getTicket_id() {
        return ticket_id;
    }

    public void setTicket_id(Integer ticket_id) {
        this.ticket_id = ticket_id;
    }

    public Integer getTicket_money() {
        return ticket_money;
    }

    public void setTicket_money(Integer ticket_money) {
        this.ticket_money = ticket_money;
    }

    public String getTicket_time() {
        return ticket_time;
    }

    public void setTicket_time(String ticket_time) {
        this.ticket_time = ticket_time;
    }

    public Integer getTicket_status() {
        return ticket_status;
    }

    public void setTicket_status(Integer ticket_status) {
        this.ticket_status = ticket_status;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }
}
