package com.subbu.estore.services;


import com.subbu.estore.dtos.User;
import com.subbu.estore.dtos.Order;

import java.util.Collection;

/**
 * Created by subbu on 19/02/18.
 */
public interface OrderService {

    public String add(Order item);

    public void update(Order item);

    public void remove(long id);

    public  Order get(long id);

    public Collection<Order> all();

    public Collection<Order> findByUserId(String userId);

    public Order findByGuid(String guid);
}
