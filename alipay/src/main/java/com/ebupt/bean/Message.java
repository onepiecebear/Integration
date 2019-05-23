package com.ebupt.bean;

import com.fasterxml.jackson.databind.ser.Serializers;

import java.io.Serializable;

/**
 * @Author: yushibo
 * @Date: 2019/5/23 18:44
 * @Description:
 */
public class Message implements Serializable {
    private String userId;
    private String messageId;
    private int amount;
    private String status;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
