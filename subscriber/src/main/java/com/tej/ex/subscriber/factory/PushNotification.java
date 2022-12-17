package com.tej.ex.subscriber.factory;

import com.tej.ex.subscriber.domain.Lead;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PushNotification implements Notification {

    private static final Logger logger = LoggerFactory.getLogger(PushNotification.class);

    @Override
    public void notifyUser(Lead lead) {
        // Subscriber 2: [Channel: Mobile] [LeadID: 98080] [Message: Push Notification Sent]
        logger.info("Subscriber 2: [Channel: Mobile] [LeadID: "+lead.getLead_id()+
                "] [Message: Push Notification Sent]");
    }
}
