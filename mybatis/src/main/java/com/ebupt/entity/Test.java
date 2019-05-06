package com.ebupt.entity;

import lombok.Data;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;

public class Test implements Serializable {

    private Integer id;

    private String name;

    private String owd;

    private String phone;

    private String email;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getOwd() {
        return owd;
    }

    public void setOwd(String owd) {
        this.owd = owd == null ? null : owd.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }
}