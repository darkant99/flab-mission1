package com.flab.mission1.member.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;

@Getter
@Entity
public class Member {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false)
    private Integer age;

    protected Member() {
    }

    public Member(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public void update(String name, Integer age) {
        this.name = name;
        this.age = age;
    }
}
