package com.subbu.estore.scripts;

import com.subbu.estore.entities.Item;
import com.subbu.estore.entities.LineItem;
import com.subbu.estore.entities.Order;
import com.subbu.estore.entities.User;
import com.subbu.estore.services.ItemService;
import com.subbu.estore.services.OrderService;
import com.subbu.estore.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by subbu on 19/02/18.
 */
@Component
public class SeedDataComponent implements CommandLineRunner{

    @Autowired
    private UserService userService;

    @Autowired
    private ItemService itemService;

    @Autowired
    private OrderService orderService;

    @Override
    public void run(String... strings) throws Exception {
        userService.add(user());
        System.out.println(userService.all());
        itemService.addItems(items());
        System.out.println(itemService.getByMeasure("Dozen"));
        Order order = order();
        System.out.println(order);
        orderService.add(order);
        System.out.println(orderService.all());
    }

    private List<Item> items() {
        List<Item> items = new ArrayList<>();
        Item banana = new Item("banana", "/banana.png", 12.00, "These are special bananas", "Dozen");
        items.add(banana);
        Item apple = new Item("apple", "/apple.png", 12.00, "These are special apples","Dozen");
        items.add(apple);
        Item orange = new Item("orange", "/orange.png", 12.00, "These are special oranges", "Dozen");
        items.add(orange);
        Item pear = new Item("pear", "/pear.png", 12.00, "These are special pears", "Kilo");
        items.add(pear);
        Item grape = new Item("grape", "/grape.png", 12.00, "These are special grapes", "Kilo");
        items.add(grape);
        Item milk = new Item("milk", "/milk.png", 65.00, "Farm fresh cow milk", "Liter");
        items.add(milk);
        return items;
    }

    private User user() {
        User user = new User("subbu", "test123", "Subrahmanyam", "Devarakonda","Flat-205, Block-A, SHT", "Miyapur", "Hyderbad","TS","500049","India");
        return user;
    }

    private Order order() {
        Order order = new Order();
        order.setAmount(50.00);
        order.setTax(5);

        LineItem lineItem1 = new LineItem();
        lineItem1.setItem(itemService.getByName("apple"));
        lineItem1.setQuantity(20);
        order.addLineItem(lineItem1);

        LineItem lineItem2 = new LineItem();
        lineItem2.setItem(itemService.getByName("banana"));
        lineItem2.setQuantity(20);
        order.addLineItem(lineItem2);

        User user = userService.getByUsername("subbu");
        order.setUser(user);

        return order;
    }
}
