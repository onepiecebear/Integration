package com.ebupt.controller;

import com.ebupt.entity.User;
import com.ebupt.service.UserService;

import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: yushibo
 * @Date: 2019/5/1 0001 14:46
 * @Description:
 */

@Controller
public class UserController {

    private final static Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;


    @RequestMapping(value = "/home")
    public String home(){
        logger.info("页面路径测试");
        return "home";
    }

    @RequestMapping(value = "/test")
    public String test(){
        logger.info("页面路径测试");
        return "test";
    }


    @RequestMapping(value = "findAll")
    public PageInfo<User> findAll(){
        logger.info("你用的是哪个日志啊？");
        return userService.findAll("1","1");
    }

    @RequestMapping(value = "insertUser")
    public int insertUser(@RequestBody User user){

        return userService.insertUser(user);
    }

}
