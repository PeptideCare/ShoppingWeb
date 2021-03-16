package com.jpaproject.jpaproject.domain.Item;

import com.jpaproject.jpaproject.domain.CategoryItem;
import com.jpaproject.jpaproject.exception.NotEnoughstockException;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity // 상품 엔터티
@Getter @Setter
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

    // stock 증가
    public void addStock(int stockQuantity) {
        this.stockQuantity += stockQuantity;
    }

    // stock 감소
    public void removeStock(int stockQuantity) {
        int rest = this.stockQuantity -= stockQuantity;
        if (rest < 0) {
            throw new NotEnoughstockException("재고 부족");
        }
        this.stockQuantity = rest;
    }
}
