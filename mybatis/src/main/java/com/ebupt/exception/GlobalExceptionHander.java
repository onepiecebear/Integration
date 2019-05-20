package com.ebupt.exception;

import com.ebupt.dto.JsonResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * @Author: yushibo
 * @Date: 2019/5/3 0003 14:59
 * @Description: 全局捕获异常
 */
@ControllerAdvice
public class GlobalExceptionHander {

    private final static Logger logger = LoggerFactory.getLogger(GlobalExceptionHander.class);
    public static final String ERROR_VIEW = "errorMessage";

    @ExceptionHandler(value = RuntimeException.class)
    public Object errorHandler(HttpServletRequest reqest,
                               HttpServletResponse response, Exception e) {
        logger.info("异常错误如下：");
        e.printStackTrace();
        //TODO 将异常信息写入数据库，用做记录和分析
        if (isAjax(reqest)) {
            return JsonResult.errorException(e.getMessage());
        } else {
            ModelAndView mav = new ModelAndView();
            mav.addObject("exception", e);
            mav.addObject("url", reqest.getRequestURL());
            mav.setViewName(ERROR_VIEW);
            return mav;
        }
    }

    /**
     * 判断是返回数据结构还是返回页面
     * @param httpRequest
     * @return
     */
    public static boolean isAjax(HttpServletRequest httpRequest){
        return  (httpRequest.getHeader("X-Requested-With") != null
                && "XMLHttpRequest"
                .equals( httpRequest.getHeader("X-Requested-With").toString()) );
    }

}
