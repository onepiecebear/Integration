package com.ebupt.exception;

import com.ebupt.dto.JsonResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@ControllerAdvice
public class GlobalExceptionHander {

    private final static Logger logger = LoggerFactory.getLogger(GlobalExceptionHander.class);
    public static final String IMOOC_ERROR_VIEW = "error";

    @ExceptionHandler(value = RuntimeException.class)
    public Object errorHandler(HttpServletRequest reqest,
                               HttpServletResponse response, Exception e) {
        logger.info("异常错误如下：");
        e.printStackTrace();
        if (isAjax(reqest)) {
            return JsonResult.errorException(e.getMessage());
        } else {
            ModelAndView mav = new ModelAndView();
            mav.addObject("exception", e);
            mav.addObject("url", reqest.getRequestURL());
            mav.setViewName(IMOOC_ERROR_VIEW);
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
