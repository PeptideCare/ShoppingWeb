package com.jpaproject.jpaproject.controller;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter @Setter
public class MemberForm {

    @NotEmpty(message = "회원ID는 필수 입니다.")
    private String Id;
    private String pw;
    private String name;
    private String city;
    private String street;
    private String zipcode;
}
