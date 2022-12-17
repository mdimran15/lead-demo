package com.tej.publisher.exception;

import com.tej.publisher.DTO.ErrorDTO;
import com.tej.publisher.exception.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @Autowired
    HttpServletRequest httpRequest;

    @ExceptionHandler({BadRequestException.class})
    public ResponseEntity<ErrorDTO> handleBadReq(BadRequestException ex) {
        ErrorDTO errorDTO = new ErrorDTO();
        errorDTO.setLead_id(ex.getLead_id());
        errorDTO.setErrorId("ErrorId");
        errorDTO.setErrorCode(ex.getErrorCode());
        errorDTO.setErrorMsg(ex.getErrorMesage());
        errorDTO.setCorrelationId(httpRequest.getHeader("CorrelationId"));
        return ResponseEntity.ok(errorDTO);
    }

    @ExceptionHandler({TopicException.class})
    public ResponseEntity<ErrorDTO> handleTopicReq(TopicException ex) {
        ErrorDTO errorDTO = new ErrorDTO();
        errorDTO.setErrorId("ErrorId");
        errorDTO.setLead_id(ex.getLead_id());
        errorDTO.setErrorCode(ex.getErrorCode());
        errorDTO.setErrorMsg(ex.getErrorMessage());
        errorDTO.setCorrelationId(httpRequest.getHeader("CorrelationId"));
        return ResponseEntity.ok(errorDTO);
    }
}
