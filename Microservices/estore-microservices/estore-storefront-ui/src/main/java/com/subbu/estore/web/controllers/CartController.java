package com.subbu.estore.web.controllers;

import com.subbu.estore.dtos.Item;
import com.subbu.estore.dtos.LineItem;
import com.subbu.estore.dtos.Order;
import com.subbu.estore.dtos.ShoppingCart;
import com.subbu.estore.services.ItemService;
import com.subbu.estore.services.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

/**
 * Created by subbu on 20/02/18.
 */

@Controller
public class CartController {

    private static final Logger logger = LoggerFactory.getLogger(CartController.class);

    @Autowired
    private ItemService itemService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private ShoppingCart shoppingCart;

    @GetMapping("/addToCart")
    public String addToCart(ModelMap model, @RequestParam("itemName") String itemName) {
        Item item = itemService.findByName(itemName);
        if(shoppingCart.isPreviousOrder()) shoppingCart.clear();
        shoppingCart.addItem(item.getGuid(), 1);
        logger.info("Shopping Cart - {}", shoppingCart);
        model.put("shoppingCart", shoppingCart);
        Collection<Item> items = itemService.findByMeasure("Dozen");
        model.put("catalog", items);
        return "welcome";
    }

    @GetMapping("/cart")
    public String loadCart(ModelMap model) {
        List<LineItem> lineItems = shoppingCart.getItems();
        model.put("shoppingCart", shoppingCart);
        return "cart";
    }

    @GetMapping("/checkout")
    public String checkout(ModelMap model) {
        if(shoppingCart.getUser()==null) return "redirect:/login";
        Order order = new Order();
        order.setUserId(shoppingCart.getUser().getGuid());
        order.setLineItems(shoppingCart.getItems());
        order.calculateTotal();
        String guid = orderService.add(order);
        model.put("orderConfirmationId", guid);
        model.put("shoppingCart", shoppingCart);
        shoppingCart.clear();
        return "cart";
    }

    @GetMapping("/order")
    public String showOrder(ModelMap model, @RequestParam("orderId") String orderId) {
        Order order = orderService.findByGuid(orderId);
        logger.info("Order deails - {}", order);
        List<LineItem> lineItems = order.getLineItems();
        for(LineItem lineItem: lineItems) {
            Item item = itemService.findByGuid(lineItem.getItemId());
            lineItem.setItem(item);
        }
        shoppingCart.setItems(lineItems);
        shoppingCart.setPreviousOrder(true);
        model.put("shoppingCart", shoppingCart);
        return "cart";
    }

    @GetMapping("/orders")
    public String showOrders(ModelMap model) {
        Collection<Order> orders = orderService.findByUserId(shoppingCart.getUser().getGuid());
        model.put("orders", orders);
        model.put("shoppingCart", shoppingCart);
        return "orders";
    }
}
