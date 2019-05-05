package com.ebupt.annotation;

import com.ebupt.controller.UserController;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Author: yushibo
 * @Date: 2019/5/3 0003 15:03
 * @Description:
 */

@Aspect
@Component
public class PageAop {

    private final static Logger logger = LoggerFactory.getLogger(PageAop.class);


    @Pointcut("@annotation(com.ebupt.annotation.EnablePaging)")
    public void serviceAspect(){
        logger.info("serviceAspect");
    }

    @Around(value = "serviceAspect()")
    public Object doAround(ProceedingJoinPoint point) throws  Throwable{
        Object[] args = point.getArgs();
        Signature signature = point.getSignature();
        MethodSignature methodSignature = (MethodSignature) signature;
        //2.最关键的一步:通过这获取到方法的所有参数名称的字符串数组
        String[] parameterNames = methodSignature.getParameterNames();
        String pageNum = null;
        String pageSize = "10";
        int pageNumIndex = ArrayUtils.indexOf(parameterNames, "pageNum");
        if (pageNumIndex != -1) {
           pageNum = (String)args[pageNumIndex];
        }
        int pageSizeIndex = ArrayUtils.indexOf(parameterNames, "pageSize");
        if (pageSizeIndex != -1) {
            pageSize = (String)args[pageSizeIndex];
        }
        if (StringUtils.isNotBlank(pageNum) && StringUtils.isNotBlank(pageSize)) {
            try {
                PageHelper.startPage(Integer.valueOf(pageNum), Integer.valueOf(pageSize));
                Object result = point.proceed();
                return new PageInfo<>((List<?>) result);
            } finally {//保证线程变量被清除
                if (PageHelper.getLocalPage() != null)
                    PageHelper.clearPage();
            }
        }
        return point.proceed();
    }

}
