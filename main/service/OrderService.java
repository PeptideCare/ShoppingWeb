package com.jpaproject.jpaproject.service;

import com.jpaproject.jpaproject.domain.Delivery;
import com.jpaproject.jpaproject.domain.Item.Item;
import com.jpaproject.jpaproject.domain.Member;
import com.jpaproject.jpaproject.domain.Order;
import com.jpaproject.jpaproject.domain.OrderItem;
import com.jpaproject.jpaproject.repository.ItemRepository;
import com.jpaproject.jpaproject.repository.MemberRepository;
import com.jpaproject.jpaproject.repository.OrderRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Getter
@Transactional(readOnly = true)
public class OrderService {

    private final OrderRepository orderRepository;
    private final MemberRepository memberRepository;
    private final ItemRepository itemRepository;

    // 주문 저장
    @Transactional
    public Long order(String memberID, Long itemId, int count) {

        //엔터티 조회
        Member member = memberRepository.findOne(memberID);
        Item item = itemRepository.findOne(itemId);

        // 배송정보 생성
        Delivery delivery = new Delivery();
        delivery.setAddress(member.getAddress());

        // 주문 상품 생성
        OrderItem orderItem = OrderItem.createOrderItem(item, item.getPrice(), count);

        // 주문 생성
        Order order = Order.createOrder(member, delivery, orderItem);

        // 주문 저장
        orderRepository.save(order);
        return order.getId();
    }

    // 아이디로 주문 조회
    public List<Order> findById(String id) {
        return orderRepository.findById(id);
    }

    // 모든 주문 조회
    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    // 주문 취소
    @Transactional
    public void cancelOrder(Long orderId) {
        Order order = orderRepository.findOne(orderId);
        order.cancel();
    }

}
