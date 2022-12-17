package com.tej.ex.subscriber.factory;

import com.tej.ex.subscriber.domain.Lead;

public interface Notification {
    void notifyUser(Lead lead);
}
