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

    @RabbitListener(queues = "${spring.rabbitmq.mobileQueue}")
    public void receivedMobileMessage(Lead lead) {
        logger.info("entering into receivedMobileMessage");
        try {
            Notification notification = NotificationFactory.createInstance(lead.getPreferred_mobile_communication_mode());
            notification.notifyUser(lead);

        }catch (IllegalArgumentException ex){
            logger.error("error occurred in receivedMobileMessage {}",ex.getMessage());
        }
    }

    @RabbitListener(queues = "${spring.rabbitmq.emailQueue}")
    public void receiveEmailMessage(Lead lead) {
        logger.info("entering into receiveEmailMessage");
        //Subscriber 1: [Channel: Email] [LeadID: 12345] [Message: Email Sent]
        logger.info("Subscriber 1: [Channel: Email] [LeadID: "+lead.getLead_id()+" ] [Message: Email Sent]");
    }

    @Override
    public void configureRabbitListeners(RabbitListenerEndpointRegistrar rabbitListenerEndpointRegistrar) {
        logger.info("entering into configureRabbitListeners");
    }
}
