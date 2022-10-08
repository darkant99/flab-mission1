package com.flab.mission1.member.application;

import com.flab.mission1.error.exception.DuplicatedMemberNameException;
import com.flab.mission1.error.exception.MemberNotFoundException;
import com.flab.mission1.member.domain.Member;
import com.flab.mission1.member.domain.repository.MemberRepository;
import com.flab.mission1.member.application.dto.request.MemberRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
@RequiredArgsConstructor
public class MemberCommandService {
    private final MemberRepository memberRepository;

    public Integer create(MemberRequest request) {
        if (memberRepository.existsByName(request.getName())) {
            throw new DuplicatedMemberNameException();
        }
        Member member = memberRepository.save(
            createMember(request)
        );
        return member.getId();
    }

    private Member createMember(MemberRequest request) {
        return new Member(request.getName(), request.getAge());
    }

    public void delete(Integer memberId) {
        memberRepository.deleteById(memberId);
    }

    public void update(Integer memberId, MemberRequest request) {
        Member member = memberRepository.findById(memberId)
            .orElseThrow(MemberNotFoundException::new);
        member.update(request.getName(), request.getAge());
    }
}
