package com.flab.mission1.error.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

public abstract class BusinessException extends RuntimeException {
    @Getter
    private final HttpStatus httpStatus;

    public BusinessException(HttpStatus status, String message) {
        super(message);
        httpStatus = status;
    }
}
