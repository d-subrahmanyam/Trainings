package com.subbu.estore.repos;

import com.subbu.estore.entities.Order;
import com.subbu.estore.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by subbu on 19/02/18.
 */
@Repository
public interface OrderRepo extends JpaRepository<Order, Long> {

    public List<Order> findByUser(User user);

    public Order findByGuid(String guid);
}
