package com.ebupt.controller;

import com.ebupt.entity.User;
import com.ebupt.service.UserService;
import com.ebupt.utils.RedisUtil;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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

    @Autowired
    private RedisUtil redisUtil;

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

    @ResponseBody
    @Cacheable(value = "yushibo",key = "methodName")
    @RequestMapping(value = "findAll")
    public Object findAll(){

        return userService.findAll("2","2");
    }

    @ResponseBody
    @RequestMapping(value = "findById/{id}")
    public String findById(@PathVariable("id") String id){
        String redisObj = redisUtil.get(id);
        if(StringUtils.isNotEmpty(redisObj)){
            return redisObj;
        }
        User user = userService.findById(id);
        redisUtil.set(id,user.toString());
        return user.toString();
    }

    @ResponseBody
    @RequestMapping(value = "insertUser")

    public int insertUser(@RequestBody User user){

        return userService.insertUser(user);
    }

}
