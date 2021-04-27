package com.jpaproject.jpaproject.controller;

import com.jpaproject.jpaproject.domain.Order;
import com.jpaproject.jpaproject.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;
    private final MemberController memberController;

    @GetMapping("/order/orderListAdmin")
    public String orderListAdmin(Model model) {
        List<Order> orders = orderService.findAll();
        model.addAttribute("orders", orders);

        return "/order/orderListAdmin";
    }

}
