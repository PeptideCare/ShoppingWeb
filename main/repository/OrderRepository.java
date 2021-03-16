package com.jpaproject.jpaproject.repository;

import com.jpaproject.jpaproject.domain.Order;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
@Getter
public class OrderRepository {

    private final EntityManager em;

    // 저장
    public void save(Order order) {
        em.persist(order);
    }

    // 아이디로 조회
    public List<Order> findById(String id) {
        return em.createQuery("select o from Order o join o.member m where m.id = :id")
                .getResultList();
    }

    // 모든 조회
    public List<Order> findAll() {
        return em.createQuery("select o from Order o", Order.class)
                .getResultList();
    }

    public Order findOne(Long id) {
        return em.find(Order.class, id);
    }
}
