package com.subbu.estore.scripts;

import com.subbu.estore.clients.UserClient;
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
        lineItem1.setItemId("7e137efd-3465-40a4-aaed-fc9dc6e73285");
        lineItem1.setQuantity(20);
        order1.addLineItem(lineItem1);

        LineItem lineItem2 = new LineItem();
        lineItem2.setItemId("277672ac-669a-4d5e-a509-d791d46f2fc9");
        lineItem2.setQuantity(20);
        order1.addLineItem(lineItem2);

        User subbu = userClient.findByUsername("subbu").getBody();

        order1.setUserId(subbu.getGuid());

        orders.add(order1);

        Order order2= new Order();
        order2.setAmount(50.00);
        order2.setTax(5);

        LineItem lineItem3 = new LineItem();
        lineItem3.setItemId("30b4f95f-ecc1-4673-a5b5-e3cda8a49f17");
        lineItem3.setQuantity(20);
        order2.addLineItem(lineItem3);

        LineItem lineItem4= new LineItem();
        lineItem4.setItemId("b0bb02a9-0b9a-4c6c-b80c-6c4f759d2a1c");
        lineItem4.setQuantity(20);
        order2.addLineItem(lineItem4);

        User subbud = userClient.findByUsername("subbud").getBody();

        order2.setUserId(subbud.getGuid());

        orders.add(order2);
        return orders;
    }
}
