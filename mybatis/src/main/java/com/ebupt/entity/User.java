package com.ebupt.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author: yushibo
 * @Date: 2019/5/1 0001 14:32
 * @Description:
 */
public class User implements Serializable{

    private String id;
    private String name;
    private String phone;
    private String pwd;
    private String email;

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getPwd() {
        return pwd;
    }

    public String getEmail() {
        return email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
