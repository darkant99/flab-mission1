package com.flab.mission1.member.service.dto.response;

import com.flab.mission1.member.domain.Member;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MemberResponse {
    private String name;
    private int age;

    public static MemberResponse from(Member member) {
        return new MemberResponse(member.getName(), member.getAge());
    }
}
