package com.jpaproject.jpaproject.domain;

import com.jpaproject.jpaproject.domain.Item.Item;
import lombok.Getter;

import javax.persistence.*;

@Entity // 주문상품 엔터티
@Getter
public class OrderItem {

    @Id @GeneratedValue
    @Column(name = "orderItem_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id")
    private Item item;

    private int orderPrice; // 가격
    private int count; // 수량
}
