package com.tej.ex.subscriber.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;

@Configuration
public class SubscriberConfig {

    @Value("${spring.rabbitmq.emailQueue}")
    private String emailQueue;

    @Value("${spring.rabbitmq.mobileQueue}")
    private String mobileQueue;

    @Value("${spring.rabbitmq.exchange}")
    private String exchange;

    @Value("${spring.rabbitmq.emailRoutingKey}")
    private String emailRoutingKey;

    @Value("${spring.rabbitmq.mobileRoutingKey}")
    private String mobileRoutingKey;

    @Value("${spring.rabbitmq.username}")
    private String username;

    @Value("${spring.rabbitmq.password}")
    private String password;

    @Value("${spring.rabbitmq.host}")
    private String host;

    @Bean
    public Queue emailQueue() {
        return new Queue(this.emailQueue, true);
    }

    @Bean
    public Queue mobileQueue() {
        return new Queue(this.mobileQueue, true);
    }

    @Bean
    public DirectExchange directExchange() {
        return ExchangeBuilder.directExchange(exchange).durable(true).build(); // new DirectExchange(this.exchange);
    }

    /*@Bean
    Exchange myExchange() {DirectExchange
        return ExchangeBuilder.directExchange(exchange).durable(true).build();
    }*/

    @Bean
    public Binding bindingEmail() {
        return BindingBuilder.bind(emailQueue()).to(directExchange()).with(this.emailRoutingKey);
    }

    @Bean
    public Binding bindingMobile(DirectExchange directExchange, Queue mobileQueue) {
        return BindingBuilder.bind(mobileQueue).to(directExchange).with(this.mobileRoutingKey);
    }

   /* @Bean
    Binding binding() {
        return BindingBuilder
                .bind(queue())
                .to(myExchange())
                .with(routingKey)
                .noargs();
    }*/

    @Bean
    public ConnectionFactory connectionFactory() {
        CachingConnectionFactory cachingConnectionFactory = new CachingConnectionFactory(host);
        cachingConnectionFactory.setUsername(username);
        cachingConnectionFactory.setPassword(password);
        return cachingConnectionFactory;
    }

    @Bean
    public MessageConverter jsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
        final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(jsonMessageConverter());
        return rabbitTemplate;
    }
}
