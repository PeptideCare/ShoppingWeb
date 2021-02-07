package com.jpaproject.jpaproject.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;

@Embeddable // 주소 값 타입 클래스
@Getter @Setter
public class Address {

    private String city;
    private String street;
    private String zipcode;

    protected Address() {

    }

    public Address(String city, String street, String zipcode) {  // 생성자로 초기화 후 변경 불가
        this.city = city;
        this.street = street;
        this.zipcode = zipcode;
    }
}
