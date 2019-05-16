package com.ebupt;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository;

@SpringBootApplication
@MapperScan("com.ebupt.dao")
@EnableCaching
@ServletComponentScan
public class MybatisApplication {

	@Bean
	public FilterRegistrationBean csrfFilter() {
		FilterRegistrationBean registration = new FilterRegistrationBean();
		registration.setFilter(new CsrfFilter(new HttpSessionCsrfTokenRepository()));
		registration.addUrlPatterns("/*");
		System.out.println("zou csrfFilter");
		return registration;
	}


	public static void main(String[] args) {
		SpringApplication.run(MybatisApplication.class, args);
	}

}
