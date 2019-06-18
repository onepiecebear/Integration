package com.ebupt.sender;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: yushibo
 * @Date: 2019/5/25 0025 23:06
 * @Description:
 */

@Configuration
public class SenderConfig {

    @Bean(value = "message")
    public Queue queueMessage(){
        return new Queue("response");
    }

    @Bean
    public TopicExchange exchange(){

        return new  TopicExchange("exchange-response");
    }

    @Bean
    public Binding bindingExchangeMessage(@Qualifier(value = "message")Queue messageQueue, TopicExchange exchange){
        return BindingBuilder.bind(messageQueue).to(exchange).with("12306");
    }
}
