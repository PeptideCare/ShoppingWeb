package com.jpaproject.jpaproject.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity // 배달 엔터티
@Getter @Setter
public class Delivery {

    @Id @GeneratedValue
    @Column(name = "delivery_id")
    private Long id;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "delivery")
    private Order order;

    @Embedded
    private Address address;

    @Enumerated(EnumType.STRING)
    private DeliveryStatus deliveryStatus;
}
