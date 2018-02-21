package com.subbu.estore.services;

import com.subbu.estore.entities.Order;
import com.subbu.estore.entities.User;

import java.util.List;

/**
 * Created by subbu on 19/02/18.
 */
public interface OrderService {

    public String add(Order item);

    public void update(Order item);

    public void remove(long id);

    public  Order get(long id);

    public List<Order> all();

    public List<Order> findByUser(User user);

    public Order findByGuid(String guid);
}
