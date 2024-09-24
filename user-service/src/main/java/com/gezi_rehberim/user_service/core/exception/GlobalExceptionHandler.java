package com.gezi_rehberim.user_service.core.exception;

import com.gezi_rehberim.user_service.core.exception.user.WrongUserNameOrPasswordException;
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

    @ExceptionHandler(WrongUserNameOrPasswordException.class)
    public ResponseEntity<BusinessExceptionDetails> handleWrongUserNameOrPassword(WrongUserNameOrPasswordException ex) {
        BusinessExceptionDetails businessExceptionDetails = new BusinessExceptionDetails();
        businessExceptionDetails.setTitle(ex.getMessage()); // Hata mesajı burada ayarlanıyor
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(businessExceptionDetails); // 401 Unauthorized
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<String> handleValidationExceptions(MethodArgumentNotValidException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(ex.getBindingResult().getAllErrors().get(0).getDefaultMessage());
    }
}
