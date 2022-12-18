package com.tej.publisher.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public final class PublisherConfig {

    @Value("${spring.rabbitmq.exchange}")
    private String exchange;
    @Value("${spring.rabbitmq.emailRoutingKey}")
    private String emailRoutingKey;

    @Value("${spring.rabbitmq.mobileRoutingKey}")
    private String mobileRoutingKey;

    @Value("${spring.rabbitmq.host}")
    private String host;

    @Value("${spring.rabbitmq.port}")
    private String port;

    @Value("${spring.rabbitmq.username}")
    private String username;

    @Value("${spring.rabbitmq.password}")
    private String password;

    public PublisherConfig(){
    }

    public String getExchange() {
        return exchange;
    }

    public String getHost() {
        return host;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmailRoutingKey() {
        return emailRoutingKey;
    }

    public String getMobileRoutingKey() {
        return mobileRoutingKey;
    }

    public String getPort() {
        return port;
    }
}
