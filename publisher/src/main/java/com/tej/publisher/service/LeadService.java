package com.tej.publisher.service;

import com.tej.publisher.DTO.LeadDTO;
import com.tej.publisher.DTO.LeadResponse;
import com.tej.publisher.exception.BadRequestException;
import com.tej.publisher.exception.TopicException;

public interface LeadService {

LeadResponse publishLead(String auth, LeadDTO leadDTO, String correlationId) throws BadRequestException, TopicException;
}
