package com.flab.mission1.error.exception;

import org.springframework.http.HttpStatus;

public class DuplicatedMemberNameException extends BusinessException {
    public DuplicatedMemberNameException() {
        super(HttpStatus.CONFLICT, "중복된 이름 입니다.");
    }
}
