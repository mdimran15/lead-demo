package com.tej.ex.subscriber.factory;

public final class NotificationFactory {

    private NotificationFactory(){}

    public static Notification createInstance(final String channel){
        if (channel == null || channel.isEmpty())
            throw new IllegalArgumentException("Unknown channel "+channel);
        switch (channel) {
            case "SMS":
                return new SMSNotification();
            case "WHATSAPP":
                return new WhatsAppNotification();
            case "PUSH":
                return new PushNotification();
            default:
                throw new IllegalArgumentException("Unknown channel "+channel);
        }
    }
}
