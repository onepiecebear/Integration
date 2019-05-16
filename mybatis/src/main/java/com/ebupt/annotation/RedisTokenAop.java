package com.ebupt.annotation;

import com.ebupt.utils.RedisTokenUtils;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @Author: yushibo
 * @Date: 2019/5/16 15:49
 * @Description:
 */
@Aspect
@Component
public class RedisTokenAop {

    @Autowired
    private RedisTokenUtils redisTokenUtils;

    @Pointcut("execution(public * com.ebupt.controller.*.*(..))")
    public void controllerAspect() {
    }

    @Around("controllerAspect()")
    public Object doBefore(ProceedingJoinPoint  proceedingJoinPoint) throws Throwable {
        MethodSignature signature = (MethodSignature) proceedingJoinPoint.getSignature();
        EnableRedisToken enableRedisToken = signature.getMethod().getDeclaredAnnotation(EnableRedisToken.class);
        if (enableRedisToken == null) {
            // 直接执行程序
            Object proceed = proceedingJoinPoint.proceed();
            return proceed;
        }
        // 代码步骤：
        // 1.获取令牌存放在请求头中
        HttpServletRequest request = getRequest();
        String token = request.getHeader("token");
        if (StringUtils.isEmpty(token)) {
            response("参数错误!");
            return null;
        }
        // 2.判断令牌是否在缓存中有对应的令牌
        // 3.如何缓存没有该令牌的话，直接报错（请勿重复提交）
        // 4.如何缓存有该令牌的话，直接执行该业务逻辑
        // 5.执行完业务逻辑之后，直接删除该令牌。
        if (!redisTokenUtils.exisToken(token)) {
            response("请勿重复提交!");
            return null;
        }
        Object proceed = proceedingJoinPoint.proceed();
        return proceed;
    }

    public HttpServletRequest getRequest() {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        return request;
    }

    public void response(String msg) throws IOException {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletResponse response = attributes.getResponse();
        response.setHeader("Content-type", "text/html;charset=UTF-8");
        PrintWriter writer = response.getWriter();
        try {
            writer.println(msg);
        } catch (Exception e) {

        } finally {
            writer.close();
        }

    }

}
