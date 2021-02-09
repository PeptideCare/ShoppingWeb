package com.jpaproject.jpaproject.domain.Item;

import com.jpaproject.jpaproject.domain.CategoryItem;
import lombok.Getter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity // 상품 엔터티
@Getter
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS) // 상속 엔터티를 하나의 엔터티로 둠
@DiscriminatorColumn(name = "dtype")
public abstract class Item {

    @Id @GeneratedValue
    @Column(name = "item_id")
    private Long id;

    private String name;

    @OneToMany(mappedBy = "item")
    private List<CategoryItem> categories = new ArrayList<>();

    private int stockQuantity;  // 재고수량
    private int price;  // 가격
}
