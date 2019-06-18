package com.ebupt;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan(basePackages = "com.ebupt.dao")
@ComponentScan(basePackages = "com.ebupt")
public class HightConcurrentApplication {

	public static void main(String[] args) {
		SpringApplication.run(HightConcurrentApplication.class, args);
	}

}
