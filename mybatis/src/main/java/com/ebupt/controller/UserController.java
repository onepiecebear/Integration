package com.ebupt.controller;

import com.ebupt.annotation.GetRedisToken;
import com.ebupt.annotation.VerifyRedisToken;
import com.ebupt.dao.OrderMapper;
import com.ebupt.entity.Order;
import com.ebupt.entity.User;
import com.ebupt.service.UserService;
import com.ebupt.utils.RedisTokenUtils;
import com.ebupt.utils.RedisUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

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
    private OrderMapper orderMapper;

    @Autowired
    private RedisUtils redisUtils;

    @Autowired
    private RedisTokenUtils redisTokenUtils;


    @RequestMapping(value = "/order")
    @GetRedisToken
    public String order(Model model){
//        String token = redisTokenUtils.getToken();
//        System.out.println(token);
//        model.addAttribute("token",token);
        return "order";
    }

    @ResponseBody
    @RequestMapping(value = "/addOrderHtml")
    @VerifyRedisToken(type = "from")
    public String addOrderHtml(Order orderEntity,String token, HttpServletRequest request) {
//        if (StringUtils.isEmpty(token)) {
//            return "参数错误!";
//        }
//        if (!redisTokenUtils.exisToken(token)) {
//            return "请勿重复提交!";
//        }
        int result = orderMapper.insert(orderEntity);
        return result > 0 ? "添加成功" : "添加失败" + "";
    }

    @RequestMapping(value = "/home")
    public String home(){
        logger.info("页面路径测试");
        return "home";
    }

    @RequestMapping(value = "/test")
    public String test(String q, Model model){
        System.out.println("q:"+q);
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
        String redisObj = redisUtils.get(id);
        if(StringUtils.isNotEmpty(redisObj)){
            return redisObj;
        }
        User user = userService.findById(id);
        redisUtils.set(id,user.toString());
        return user.toString();
    }

    @ResponseBody
    @RequestMapping(value = "insertUser")

    public int insertUser(@RequestBody User user){

        return userService.insertUser(user);
    }

}
