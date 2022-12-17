package com.tej.publisher.controller;


import com.tej.publisher.DTO.LeadDTO;
import com.tej.publisher.DTO.LeadResponse;
import com.tej.publisher.exception.TopicException;
import com.tej.publisher.service.LeadService;
import com.tej.publisher.exception.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class LeadController {

    @Autowired
    private LeadService leadService;

    @PostMapping(value = "/lead/publish", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<LeadResponse> createLead(@RequestHeader("Authorization")String bearerToken,
                                                   @RequestHeader("CorrelationId")String correlationId,
                                                   //@Valid with domain object
                                                   @RequestBody LeadDTO leadDTO) throws BadRequestException, TopicException {

        return ResponseEntity.ok(leadService.publishLead(bearerToken,leadDTO,correlationId));
    }
}
