package com.subbu.estore.repos;

import com.subbu.estore.entities.Order;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

/**
 * Created by subbu on 21/02/18.
 */

@RepositoryRestResource(collectionResourceRel = "orders", path = "orders")
public interface OrderRepo extends PagingAndSortingRepository<Order, Long> {

    public Order findByGuid(@Param("guid") String guid);

    public List<Order> findByUserId(@Param("userId") String userId);
}
