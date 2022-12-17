package com.tej.publisher.exception;

public class BadRequestException extends Exception{

    private String errorMesage;
    private String errorCode;

    private Integer lead_id;

    public BadRequestException(String message, String errorCode, Integer lead_id) {
        super(message);
        this.errorMesage = message;
        this.errorCode = errorCode;
        this.lead_id = lead_id;
    }

    public String getErrorMesage() {
        return errorMesage;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public Integer getLead_id() {
        return lead_id;
    }
}
