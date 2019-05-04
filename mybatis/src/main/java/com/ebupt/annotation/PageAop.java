package com.ebupt.annotation;

import com.ebupt.controller.UserController;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
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

    @Before("serviceAspect()")
    public  void doBefore(JoinPoint joinPoint) {
        logger.info("doBefore");
    }



    @Around(value = "serviceAspect()")
    public Object doAround(ProceedingJoinPoint point) throws  Throwable{
        logger.info("doAround ");
        Object[] args = point.getArgs();
        Integer pageNum = 1;
        Integer pageSize = 10;
        if(args.length >= 2){
            pageNum = (Integer)args[args.length -2];
            pageSize = (Integer)args[args.length - 1];
        }
        PageHelper.startPage(pageNum, pageSize);
        return  point.proceed(args);
    }

    public Object pagingQuery(ProceedingJoinPoint joinPoint, PagingQuery  pagingQuery) throws Throwable {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Class<?> returnType = signature.getMethod().getReturnType();
        if (returnType == List.class) {
//            String pageNumParameterName = pagingQuery.pageNumParameterName();
//            String pageSizeParameterName = pagingQuery.pageSizeParameterName();
            String pageNumParameterName = "";
            String pageSizeParameterName = "";
            //获取request，从中获取分页参数
            ServletRequestAttributes currentRequestAttributes = (ServletRequestAttributes) RequestContextHolder
                    .currentRequestAttributes();
            HttpServletRequest request = currentRequestAttributes.getRequest();
            String pageNum = request.getParameter(pageNumParameterName);
            String pageSize = request.getParameter(pageSizeParameterName);
            if (StringUtils.isNotBlank(pageNum) && StringUtils.isNotBlank(pageSize)) {
                try {
                    PageHelper.startPage(Integer.valueOf(pageNum), Integer.valueOf(pageSize));
                    Object result = joinPoint.proceed();
                    return new PageInfo<>((List<?>) result);//建议自己实现返回类型，官方自带的返回数据太冗余了
                } finally {//保证线程变量被清除
                    if (PageHelper.getLocalPage() != null)
                        PageHelper.clearPage();
                }
            }
        }
        return joinPoint.proceed();
    }



}
