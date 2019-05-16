package com.ebupt.utils;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author: yushibo
 * @Date: 2019/5/16 11:13
 * @Description:
 */
public class TokenUtils {

        private static Map<String, Object> tokenMap = new ConcurrentHashMap<String, Object>();

        // 获取token
        public static synchronized String getToken() {
        // 1.生成令牌
        String token = "token-" + System.currentTimeMillis();
        // 2.存入tokenMap
        tokenMap.put(token, token);
        return token;
        }

        // 验证token,并且删除对应的token
        public static Boolean exisToken(String token) {
        // 1.从集合中获取token
        Object result = tokenMap.get(token);
        if (result == null) {
        return false;
        }
        // 2.删除对应的token
        tokenMap.remove(token);
        return true;
        }
        }

