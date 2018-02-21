package com.subbu.estore.services.impl;

import com.subbu.estore.clients.OrderServiceClient;
import com.subbu.estore.dtos.Order;
import com.subbu.estore.dtos.User;
import com.subbu.estore.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * Created by subbu on 19/02/18.
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderServiceClient orderServiceClient;

    @Override
    public String add(Order order) {
        Order _order = orderServiceClient.save(order);
        return _order.getGuid();
    }

    @Override
    public void update(Order order) {
        orderServiceClient.save(order);
    }

    @Override
    public void remove(long id) {
        //orderServiceClient.delete(id);
    }

    @Override
    public Order get(long id) {
        return null; //orderServiceClient.getOne(id);
    }

    @Override
    public Collection<Order> all() {
        return orderServiceClient.findAll().getContent();
    }

    @Override
    public Order findByGuid(String guid) {
        return orderServiceClient.findByGuid(guid).getBody();
    }

    @Override
    public Collection<Order> findByUserId(String userId) {
        return orderServiceClient.findByUserId(userId).getContent();
    }
}
