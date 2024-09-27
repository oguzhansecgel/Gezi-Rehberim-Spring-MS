package com.gezi_rehberim.comment_service.core.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.turkcell.tcell.exception.exceptions.details.BusinessExceptionDetails;
import org.turkcell.tcell.exception.exceptions.type.BaseBusinessException;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(BaseBusinessException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<BusinessExceptionDetails> handleBusinessException(BaseBusinessException exception) {
        BusinessExceptionDetails businessExceptionDetails = new BusinessExceptionDetails();
        businessExceptionDetails.setTitle(exception.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(businessExceptionDetails);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<String> handleValidationExceptions(MethodArgumentNotValidException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(ex.getBindingResult().getAllErrors().get(0).getDefaultMessage());
    }
}
