package com.flab.mission1.error.exception;

import org.springframework.http.HttpStatus;

public class MemberNotFoundException extends BusinessException {
    public MemberNotFoundException() {
        super(HttpStatus.NOT_FOUND, "사용자를 찾을 수 없습니다.");
    }
}
