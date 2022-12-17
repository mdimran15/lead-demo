package com.tej.publisher.DTO;

public class LeadResponse {

    private Integer lead_id;
    private String code;
    private String message;

    public Integer getLead_id() {
        return lead_id;
    }

    public void setLead_id(Integer lead_id) {
        this.lead_id = lead_id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
