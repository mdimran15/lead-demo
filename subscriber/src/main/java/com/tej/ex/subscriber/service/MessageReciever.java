package com.tej.ex.subscriber.service;

import com.tej.ex.subscriber.domain.Lead;
import com.tej.ex.subscriber.factory.Notification;
import com.tej.ex.subscriber.factory.NotificationFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.annotation.RabbitListenerConfigurer;
import org.springframework.amqp.rabbit.listener.RabbitListenerEndpointRegistrar;
import org.springframework.stereotype.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component
public class MessageReciever implements RabbitListenerConfigurer{

    private static final Logger logger = LoggerFactory.getLogger(MessageReciever.class);

    @RabbitListener(queues = "${spring.rabbitmq.queue}")
    public void receivedMessage(Lead user) {
        Notification notification = NotificationFactory.createInstance(user.getPreferred_mobile_communication_mode());
        notification.notifyUser(user);
        logger.info("User Details Received is.. {}" , user);
    }

    @Override
    public void configureRabbitListeners(RabbitListenerEndpointRegistrar rabbitListenerEndpointRegistrar) {
        logger.info("entring into configureRabbitListeners");
    }
}
