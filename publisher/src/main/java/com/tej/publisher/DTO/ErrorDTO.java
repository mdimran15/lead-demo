package com.tej.publisher.DTO;
public class ErrorDTO {

    private String errorId;
    private String errorMsg;
    private String errorCode;
    private String correlationId;

    private Integer lead_id;

    public String getErrorId() {
        return errorId;
    }

    public void setErrorId(String errorId) {
        this.errorId = errorId;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getCorrelationId() {
        return correlationId;
    }

    public void setCorrelationId(String correlationId) {
        this.correlationId = correlationId;
    }

    public Integer getLead_id() {
        return lead_id;
    }

    public void setLead_id(Integer lead_id) {
        this.lead_id = lead_id;
    }
}
