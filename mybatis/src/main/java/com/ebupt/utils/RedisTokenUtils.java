package com.ebupt.utils;

/**
 * @Author: yushibo
 * @Date: 2019/5/16 14:17
 * @Description:
 */

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class RedisTokenUtils {

    private long timeout = 120;

    @Autowired
    private RedisUtils redisUtils;

    // 将token存入在redis
    public String getToken() {
        String token = "token" + UUID.randomUUID();
        redisUtils.set(token, token, timeout);
        return token;
    }

    /**
     *  判断令牌是否存在
     * @param tokenKey
     * @return true token存在
     */
    public boolean exisToken(String tokenKey) {
        String token = redisUtils.get(tokenKey);
        if (StringUtils.isEmpty(token)) {
            return false;
        }
        // token 获取成功后删除对应token
        boolean flag = redisUtils.del(token);
        if(!flag){
            //高并发情况，其他请求进行了操作，此次不进行操作
            return false;
        }
        return true;
    }

}

