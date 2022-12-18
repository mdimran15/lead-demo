package com.tej.publisher.service;

import com.tej.publisher.DTO.LeadDTO;
import com.tej.publisher.DTO.LeadResponse;
import com.tej.publisher.config.PublisherConfig;
import com.tej.publisher.exception.TopicException;
import com.tej.publisher.util.PublisherUtil;
import com.tej.publisher.exception.BadRequestException;
import com.tej.publisher.validator.LeadValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LeadServiceImpl implements LeadService{

    private static final Logger LOGGER = LoggerFactory.getLogger(LeadServiceImpl.class);

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private PublisherConfig config;
    @Override
    public LeadResponse publishLead(String auth, LeadDTO leadDTO, String correlationId) throws BadRequestException,TopicException {

        LOGGER.info("entering into publishLead");
        LeadValidator.validateLead(leadDTO);
        // convert dto to domain object
        try{
            if(leadDTO.getLead_email_id() != null){
                rabbitTemplate.convertAndSend(config.getExchange(),config.getEmailRoutingKey(), leadDTO);
            }if(leadDTO.getLead_mobile_number() != null){
                rabbitTemplate.convertAndSend(config.getExchange(),config.getMobileRoutingKey(), leadDTO);
            }

            LeadResponse leadResponse = new LeadResponse();
            leadResponse.setLead_id(leadDTO.getLead_id());
            leadResponse.setCode(PublisherUtil.PUBLISHED); // we can use enum
            leadResponse.setMessage(PublisherUtil.PUBLISHED_MESSAGE);
            return leadResponse;
        }catch (AmqpException ex){
            LOGGER.error("error occurred in send to topic message :{} , cause: {}, stacktrace: {}",ex.getMessage(),ex.getCause(),ex.getStackTrace());
            throw new TopicException(ex.getMessage(),leadDTO.getLead_id(),"500");

        }


    }
}
