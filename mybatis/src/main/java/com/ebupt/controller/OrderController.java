package com.ebupt.controller;

/**
 * @Author: yushibo
 * @Date: 2019/5/16 11:03
 * @Description:
 */

import com.ebupt.dao.OrderMapper;
import com.ebupt.entity.Order;
import com.ebupt.utils.TokenUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@RestController
public class OrderController {

    @Resource
    private OrderMapper orderMapper;

    // 获取Token
    @RequestMapping("/getToken")
    public String getToken() {
        return TokenUtils.getToken();
    }

    // 验证Token
    @RequestMapping(value = "/addOrder", produces = "application/json; charset=utf-8")
    public String addOrder(@RequestBody Order orderEntity, HttpServletRequest request) {
        String token = request.getHeader("token");
        if (StringUtils.isEmpty(token)) {
            return "参数错误!";
        }
        if (!TokenUtils.exisToken(token)) {
            return "请勿重复提交!";
        }
        int result = orderMapper.insert(orderEntity);
        return result > 0 ? "添加成功" : "添加失败" + "";
    }

}

