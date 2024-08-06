package com.subbu.estore.services.impl;

import com.subbu.estore.entities.Order;
import com.subbu.estore.entities.User;
import com.subbu.estore.repos.ItemRepo;
import com.subbu.estore.repos.OrderRepo;
import com.subbu.estore.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by subbu on 19/02/18.
 */
@Service
@Transactional
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderRepo orderRepo;

    @Override
    public String add(Order order) {
        Order _order = orderRepo.save(order);
        return _order.getGuid();
    }

    @Override
    public void update(Order order) {
        orderRepo.save(order);
    }

    @Override
    public void remove(long id) {
        orderRepo.deleteById(id);
    }

    @Override
    public Order get(long id) {
        return orderRepo.getOne(id);
    }

    @Override
    public List<Order> all() {
        return orderRepo.findAll();
    }

    @Override
    public Order findByGuid(String guid) {
        return orderRepo.findByGuid(guid);
    }

    @Override
    public List<Order> findByUser(User user) {
        return orderRepo.findByUser(user);
    }
}
