package com.ebupt.interceptor;

//import com.ebupt.pojo.IMoocJSONResult;
//import com.ebupt.utils.JsonUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DemoInterceptor implements HandlerInterceptor {

	public final static Logger logger = LoggerFactory.getLogger(DemoInterceptor.class);
	
	/**
	 * 在请求处理之前进行调用（Controller方法调用之前）
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object object) {
		
//		if (true) {
//			returnErrorResponse(response, IMoocJSONResult.errorMsg("被two拦截..."));
//		}
		logger.info("拦截器：preHandle");

		return true;
	}
	
	/**
	 * 请求处理之后进行调用，但是在视图被渲染之前（Controller方法调用之后）
	 */
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object object, ModelAndView mv) {
		// TODO Auto-generated method stub
		logger.info("拦截器：postHandle");
		
	}
	
	/**
	 * 在整个请求结束之后被调用，也就是在DispatcherServlet 渲染了对应的视图之后执行（主要是用于进行资源清理工作）
	 */
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object object, Exception ex) {
		// TODO Auto-generated method stub
		logger.info("拦截器：afterCompletion");
		
	}
	//ajax情况的格式化
//	public void returnErrorResponse(HttpServletResponse response, IMoocJSONResult result) throws IOException, UnsupportedEncodingException {
//		OutputStream out=null;
//		try{
//		    response.setCharacterEncoding("utf-8");
//		    response.setContentType("text/json");
//		    out = response.getOutputStream();
//		    out.write(JsonUtils.objectToJson(result).getBytes("utf-8"));
//		    out.flush();
//		} finally{
//		    if(out!=null){
//		        out.close();
//		    }
//		}
//	}
}
