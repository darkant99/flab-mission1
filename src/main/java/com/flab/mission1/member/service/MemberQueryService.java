package com.flab.mission1.member.service;

import com.flab.mission1.error.exception.MemberNotFoundException;
import com.flab.mission1.member.domain.Member;
import com.flab.mission1.member.domain.repository.MemberRepository;
import com.flab.mission1.member.service.dto.response.MemberResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
@Service
@RequiredArgsConstructor
public class MemberQueryService {
    private final MemberRepository memberRepository;

    public MemberResponse get(Integer id) {
        Member member = memberRepository.findById(id)
            .orElseThrow(MemberNotFoundException::new);
        return MemberResponse.from(member);
    }
}
