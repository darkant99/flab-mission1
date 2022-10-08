package com.flab.mission1.member.presentation;

import com.flab.mission1.member.service.dto.response.MemberResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RequiredArgsConstructor
@RestControllerAdvice
public class MemberController {
    @PostMapping
    public ResponseEntity<MemberResponse> create() {
        return null;
    }

    @GetMapping
    public ResponseEntity<MemberResponse> read() {
        return null;
    }

    @PutMapping
    public ResponseEntity<Void> update() {
        return null;
    }

    @DeleteMapping
    public ResponseEntity<Void> delete() {
        return null;
    }
}
