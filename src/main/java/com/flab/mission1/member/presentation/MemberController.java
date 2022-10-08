package com.flab.mission1.member.presentation;

import com.flab.mission1.member.application.MemberCommandService;
import com.flab.mission1.member.application.MemberQueryService;
import com.flab.mission1.member.application.dto.request.MemberRequest;
import com.flab.mission1.member.application.dto.response.MemberResponse;
import java.net.URI;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RequestMapping("api/v1/members")
@RequiredArgsConstructor
@RestControllerAdvice
public class MemberController {
    private final MemberCommandService commandService;
    private final MemberQueryService queryService;

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody MemberRequest request) {
        Integer id = commandService.create(request);
        return ResponseEntity
            .created(URI.create("/api/v1/members/" + id))
            .build();
    }

    @GetMapping("{id}")
    public ResponseEntity<MemberResponse> read(@PathVariable("id") Integer id) {
        MemberResponse result = queryService.get(id);
        return ResponseEntity.ok(result);
    }

    @PutMapping("{id}")
    public ResponseEntity<Void> update(@PathVariable("id") Integer id, @RequestBody MemberRequest request) {
        commandService.update(id, request);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
        commandService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
