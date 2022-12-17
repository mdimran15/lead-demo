package com.tej.ex.subscriber.factory;

import com.tej.ex.subscriber.domain.Lead;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WhatsAppNotification implements Notification {

    private static final Logger logger = LoggerFactory.getLogger(WhatsAppNotification.class);

    @Override
    public void notifyUser(Lead lead) {
        //Subscriber 2: [Channel: Mobile] [LeadID: 79790] [Message:WhatsApp Message Sent]
        logger.info("Subscriber 2: [Channel: Mobile] [LeadID:"+lead.getLead_id()
        +"] [Message:WhatsApp Message Sent]");
    }
}
