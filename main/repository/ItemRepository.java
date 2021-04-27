package com.jpaproject.jpaproject.repository;

import com.jpaproject.jpaproject.domain.Item.Item;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
@Getter
public class ItemRepository {

    private final EntityManager em;

    // 상품 저장
    public void save(Item item) {
        if (item.getId() == null) {
            em.persist(item);
        } else {
            // 아이디 값이 있을 경우에는 변경감지로 수정
            Item finditem = em.find(Item.class, item.getId());
            finditem.setStockQuantity(item.getStockQuantity());
            finditem.setPrice(item.getPrice());
        }
    }

    // 하나의 상품 조회
    public Item findOne(Long id) {
        return em.find(Item.class, id);
    }

    // 모든 상품 조회
    public List<Item> findAll() {
        return em.createQuery("select i from Item i")
                .getResultList();
    }

}
