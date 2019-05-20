package com.ebupt.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
//WebMvcConfigurerAdapter
//implements WebMvcConfigurer {
@Configuration
public class InterceptorConfig extends WebMvcConfigurationSupport {

	public final static Logger logger = LoggerFactory.getLogger(InterceptorConfig.class);

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		/**
		 * 拦截器按照顺序执行
		 */
		//excludePathPatterns不拦截.excludePathPatterns("/ee/**");
		registry.addInterceptor(new DemoInterceptor()).addPathPatterns("/**").excludePathPatterns("/static/**");
	}

	@Override
	protected void addResourceHandlers(ResourceHandlerRegistry registry) {
		//需要配置1：需要告知系统，这是要被当成静态文件的！
		//第一个方法设置访问路径前缀，第二个方法设置资源路径
		registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
		//其他静态资源
//		registry.addResourceHandler("/upload/**").addResourceLocations("file:"+ TaleUtils.getUplodFilePath()+"upload/");
	}
}
