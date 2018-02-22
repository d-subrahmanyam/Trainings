package com.subbu.estore.scripts;

import com.subbu.estore.clients.CatalogClient;
import com.subbu.estore.clients.UserClient;
import com.subbu.estore.dtos.Item;
import com.subbu.estore.dtos.User;
import com.subbu.estore.entities.LineItem;
import com.subbu.estore.entities.Order;
import com.subbu.estore.repos.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by subbu on 21/02/18.
 */

@Component
public class SeedDataComponent implements CommandLineRunner {

    @Autowired
    private OrderRepo orderRepo;

    @Autowired
    private UserClient userClient;

    @Autowired
    private CatalogClient catalogClient;

    @Override
    public void run(String... strings) throws Exception {
        List<Order> orders = order();
        orderRepo.save(orders);
        //This statement has been commented to make sure the master build does'nt fail
        //System.out.println(userClient.getUsers().getContent());
    }

    private List<Order> order() {
        List<Order> orders = new ArrayList<>();
        Order order1= new Order();
        order1.setAmount(50.00);
        order1.setTax(5);

        LineItem lineItem1 = new LineItem();
        Item apple = catalogClient.findByName("apple").getBody();
        lineItem1.setItemId(apple.getGuid());
        lineItem1.setQuantity(20);
        order1.addLineItem(lineItem1);

        LineItem lineItem2 = new LineItem();
        Item banana = catalogClient.findByName("banana").getBody();
        lineItem2.setItemId(banana.getGuid());
        lineItem2.setQuantity(20);
        order1.addLineItem(lineItem2);

        User subbu = userClient.findByUsername("subbu").getBody();

        order1.setUserId(subbu.getGuid());

        orders.add(order1);

        Order order2= new Order();
        order2.setAmount(50.00);
        order2.setTax(5);

        LineItem lineItem3 = new LineItem();
        Item milk = catalogClient.findByName("milk").getBody();
        lineItem3.setItemId(milk.getGuid());
        lineItem3.setQuantity(20);
        order2.addLineItem(lineItem3);

        LineItem lineItem4= new LineItem();
        Item orange = catalogClient.findByName("orange").getBody();
        lineItem4.setItemId(orange.getGuid());
        lineItem4.setQuantity(20);
        order2.addLineItem(lineItem4);

        User subbud = userClient.findByUsername("subbud").getBody();

        order2.setUserId(subbud.getGuid());

        orders.add(order2);
        return orders;
    }
}
