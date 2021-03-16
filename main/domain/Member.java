package com.jpaproject.jpaproject.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity // 회원 엔터티
@Getter @Setter
public class Member {

    @Id
    @Column(name = "member_id")
    private String id; // 회원 Id를 기본키로 둠

    private String name;

    private String password;

    @Embedded
    private Address address;

    @OneToMany(mappedBy = "member")
    private List<Order> order = new ArrayList<>();
}
