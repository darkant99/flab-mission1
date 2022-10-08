package com.flab.mission1.member.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class MemberTest {

    @Test
    void update() {
        final String EXPERT_NAME = "김재원2";
        final Integer EXPERT_AGE = 27;

        Member member = new Member("김재원", 26);
        member.update(EXPERT_NAME, EXPERT_AGE);

        assertThat(member.getName()).isEqualTo(EXPERT_NAME);
        assertThat(member.getAge()).isEqualTo(EXPERT_AGE);
    }
}
