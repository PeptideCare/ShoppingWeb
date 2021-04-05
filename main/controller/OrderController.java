package com.jpaproject.jpaproject.controller;

import com.jpaproject.jpaproject.domain.Member;
import com.jpaproject.jpaproject.domain.Order;
import com.jpaproject.jpaproject.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class OrderController {

    private final OrderRepository orderRepository;
    private final MemberController memberController;

    @GetMapping("/order/orderListUser")
    public String orderList(Model model) {
        String memberId = memberController.getMemberId();
        List<Order> orders = orderRepository.findById(memberId);
        if (!orders.isEmpty()) {
            model.addAttribute("orders", orders);
        }
        return "/order/orderListUser";
    }

}
