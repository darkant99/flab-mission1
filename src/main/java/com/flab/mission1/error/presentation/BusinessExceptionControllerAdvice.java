package com.flab.mission1.error.presentation;

import com.flab.mission1.error.exception.BusinessException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class BusinessExceptionControllerAdvice {
    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<String> handle(BusinessException e) {
        return new ResponseEntity<>(e.getMessage(), e.getHttpStatus());
    }
}
