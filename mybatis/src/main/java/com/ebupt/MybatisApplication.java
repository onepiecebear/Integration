package com.ebupt;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericToStringSerializer;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository;

@SpringBootApplication
@MapperScan("com.ebupt.dao")
@EnableCaching
//过滤器开关
@ServletComponentScan
public class MybatisApplication {

//	@Bean
//	public FilterRegistrationBean csrfFilter() {
//		FilterRegistrationBean registration = new FilterRegistrationBean();
//		registration.setFilter(new CsrfFilter(new HttpSessionCsrfTokenRepository()));
//		registration.addUrlPatterns("/*");
//		System.out.println("zou csrfFilter");
//		return registration;
//	}

	@Bean
	public RedisTemplate<Object, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
		// 1.创建 redisTemplate 模版
		RedisTemplate<Object, Object> template = new RedisTemplate<>();
		// 2.关联 redisConnectionFactory
		template.setConnectionFactory(redisConnectionFactory);
		// 3.创建 序列化类
		Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
		ObjectMapper om = new ObjectMapper();
		// 4.设置可见度
		om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
		// 5.启动默认的类型
		om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
		// 6.序列化类，对象映射设置
		jackson2JsonRedisSerializer.setObjectMapper(om);
		// 7.设置 value 的转化格式和 key 的转化格式
		template.setValueSerializer(jackson2JsonRedisSerializer);
		//使用此方法KEY只能为String
		template.setKeySerializer(new StringRedisSerializer());
		//使用此方法KEY可为对象
//		template.setKeySerializer(jackson2JsonRedisSerializer);
		template.afterPropertiesSet();
		System.out.println("走了自定义redisTemplate");
		return template;
	}


	public static void main(String[] args) {
		SpringApplication.run(MybatisApplication.class, args);
	}

}
