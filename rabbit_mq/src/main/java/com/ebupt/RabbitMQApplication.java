package com.ebupt;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.ebupt.dao")
public class RabbitMQApplication {

	public static void main(String[] args) {
		SpringApplication.run(RabbitMQApplication.class, args);
	}

}
