package com.jpaproject.jpaproject.controller;

import com.jpaproject.jpaproject.domain.Item.Item;
import com.jpaproject.jpaproject.domain.Item.Top;
import com.jpaproject.jpaproject.service.ItemService;
import com.jpaproject.jpaproject.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ItemController {

    private final ItemService itemService;
    private final OrderService orderService;
    private final MemberController memberController;

    @GetMapping("/item/new")
    public String createForm(Model model) {
        model.addAttribute("item", new ItemForm());
        return "item/createItem";
    }

    @PostMapping("/item/new")
    public String create(ItemForm itemForm) {
        Item item = new Top();

        item.setPrice(itemForm.getPrice());
        item.setName(itemForm.getName());
        item.setStockQuantity(itemForm.getStockQuantity());

        itemService.saveItem(item);
        return "redirect:/admin";

    }

    @GetMapping("/item/item")
    public String items(Model model) {
        List<Item> items = itemService.findItems();
        model.addAttribute("items", items);
        return "/item/item";
    }

    @GetMapping("/item/{itemId}/{itemName}/{itemPrice}/get")
    public String getItem(@PathVariable ("itemId") Long itemId,
                          @PathVariable ("itemName") String itemName,
                          @PathVariable ("itemPrice") int price) {

        String memberId = memberController.getMemberId();

        orderService.order(memberId, itemId, 1);

        return "redirect:/user";
    }
}
