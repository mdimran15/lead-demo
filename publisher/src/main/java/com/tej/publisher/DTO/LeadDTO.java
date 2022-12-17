package com.tej.publisher.DTO;

import java.io.Serializable;

public class LeadDTO implements Serializable { // lombok can be used

    private Integer lead_id;
    private String source;
    private String lead_name;
    private String lead_mobile_number;
    private String lead_email_id;
    private String preferred_mobile_communication_mode;
    private String lead_message;

    public LeadDTO() {
    }

    public Integer getLead_id() {
        return lead_id;
    }

    public void setLead_id(Integer lead_id) {
        this.lead_id = lead_id;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getLead_name() {
        return lead_name;
    }

    public void setLead_name(String lead_name) {
        this.lead_name = lead_name;
    }

    public String getLead_mobile_number() {
        return lead_mobile_number;
    }

    public void setLead_mobile_number(String lead_mobile_number) {
        this.lead_mobile_number = lead_mobile_number;
    }

    public String getLead_email_id() {
        return lead_email_id;
    }

    public void setLead_email_id(String lead_email_id) {
        this.lead_email_id = lead_email_id;
    }

    public String getPreferred_mobile_communication_mode() {
        return preferred_mobile_communication_mode;
    }

    public void setPreferred_mobile_communication_mode(String preferred_mobile_communication_mode) {
        this.preferred_mobile_communication_mode = preferred_mobile_communication_mode;
    }

    public String getLead_message() {
        return lead_message;
    }

    public void setLead_message(String lead_message) {
        this.lead_message = lead_message;
    }
}
