package com.tej.publisher.exception;

public class TopicException extends Exception{

    private String errorMessage;
    private String errorCode;
    private Integer lead_id;

    public TopicException(String errorMessage, Integer lead_id,String errorCode) {
        super(errorMessage);
        this.errorMessage = errorMessage;
        this.errorCode = errorCode;
        this.lead_id =lead_id;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public Integer getLead_id() {
        return lead_id;
    }
}
