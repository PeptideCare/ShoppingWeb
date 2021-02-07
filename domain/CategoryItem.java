package com.jpaproject.jpaproject.domain;

import com.jpaproject.jpaproject.domain.Item.Item;
import lombok.Getter;

import javax.persistence.*;

@Entity  // 카테고리 아이템 엔터티
@Getter
public class CategoryItem {

    @Id @GeneratedValue
    @Column(name = "categoryitem_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id")
    private Item item;
}
