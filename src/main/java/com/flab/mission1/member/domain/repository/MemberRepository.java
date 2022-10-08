package com.flab.mission1.member.domain.repository;

import com.flab.mission1.member.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member, Integer> {
    Boolean existsByName(String name);
}
