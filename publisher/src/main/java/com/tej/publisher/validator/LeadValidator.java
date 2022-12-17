package com.tej.publisher.validator;

import com.tej.publisher.DTO.LeadDTO;
import com.tej.publisher.exception.BadRequestException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class LeadValidator {

    private static final Logger LOGGER = LoggerFactory.getLogger(LeadValidator.class);

    private LeadValidator() {
    }// we can use @Valid

    public static void validateLead(LeadDTO leadDTO) throws BadRequestException {
        LOGGER.info("entering into validateLead");
        if (Objects.isNull(leadDTO)) {
            throw new BadRequestException("RequestBody should not empty", "400",leadDTO.getLead_id());
        }
        if (leadDTO.getLead_id() == null || leadDTO.getLead_id() <= 0) {
            throw new BadRequestException("lead_id should be positive and not empty", "400",leadDTO.getLead_id());
        }
        if (leadDTO.getLead_email_id() == null && leadDTO.getLead_mobile_number() == null) {
            throw new BadRequestException("lead_mobile number or email id  should be not empty", "400",leadDTO.getLead_id());
        } else {
            if(leadDTO.getLead_email_id() != null)emailCheck(leadDTO.getLead_email_id(),leadDTO.getLead_id());
            if(leadDTO.getLead_mobile_number() != null)phoneCheck(leadDTO.getLead_mobile_number(),leadDTO.getLead_id());
        }
        if (!(leadDTO.getPreferred_mobile_communication_mode() != null && (
                        "SMS".equalsIgnoreCase(leadDTO.getPreferred_mobile_communication_mode()) ||
                        "WHATSAPP".equalsIgnoreCase(leadDTO.getPreferred_mobile_communication_mode())
                        || "PUSH_NOTIFICATION".equalsIgnoreCase(leadDTO.getPreferred_mobile_communication_mode())
        ))
        ) {
            throw new BadRequestException("getPreferred_mobile_communication_mode should be SMS,WHATSAPP, PUSH_NOTIFICATION", "400",leadDTO.getLead_id());

        }
        if(! (leadDTO.getLead_message() != null && leadDTO.getLead_message().length() > 10)){
            throw new BadRequestException("getLead_message should be more than 10 character", "400",leadDTO.getLead_id());
        }
    }
    private static void emailCheck(String email, Integer lead_id) throws BadRequestException{
        LOGGER.info("entering into emailCheck");
        if(email == null) throw new BadRequestException("getLead_email_id is mandatory","400",lead_id);
        String REGEX = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";

        Pattern pattern = Pattern.compile(REGEX, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(email);
        if(!matcher.matches()) throw new BadRequestException("emailCheck should be abc@abc.com","400",lead_id);;
        }

    private static  void phoneCheck(String phone, Integer lead_id) throws BadRequestException{
        LOGGER.info("entering into phoneCheck");
        if(phone == null) throw new BadRequestException("getLead_mobile_number is mandatory","400",lead_id);
        String REGEX
                = "^(\\+\\d{1,3}( )?)?((\\(\\d{3}\\))|\\d{3})[- .]?\\d{3}[- .]?\\d{4}$"
                + "|^(\\+\\d{1,3}( )?)?(\\d{3}[ ]?){2}\\d{3}$"
                + "|^(\\+\\d{1,3}( )?)?(\\d{3}[ ]?)(\\d{2}[ ]?){2}\\d{2}$";
        Pattern pattern = Pattern.compile(REGEX, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(phone);
        if(!matcher.matches()) throw new BadRequestException("phone should be international foramat +91 or (91)","400",lead_id);;

    }


}
