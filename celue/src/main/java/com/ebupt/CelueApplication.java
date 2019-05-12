package com.ebupt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//前台传递的参数，通过Spting上下文获得该参数对应实现接口的对象，调用方法

@SpringBootApplication
public class CelueApplication {

	public static void main(String[] args) {
		SpringApplication.run(CelueApplication.class, args);
	}

}
