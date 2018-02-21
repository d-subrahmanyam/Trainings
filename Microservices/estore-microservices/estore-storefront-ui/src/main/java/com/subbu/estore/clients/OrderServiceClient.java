package com.subbu.estore.clients;

import com.subbu.estore.dtos.Order;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.hateoas.Resources;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by subbu on 21/02/18.
 */

@FeignClient(value = "orders", url = "http://localhost:8083", path = "/orders", decode404 = true)
public interface OrderServiceClient {

    @RequestMapping(method = RequestMethod.POST)
    public Order save(Order order);

    @RequestMapping(method = RequestMethod.GET, path = "search/findByGuid")
    public ResponseEntity<Order> findByGuid(@RequestParam("guid") String guid);

    @RequestMapping(method = RequestMethod.GET, path = "search/findByUserId")
    public Resources<Order> findByUserId(@RequestParam("userId") String userId);

    @RequestMapping(method = RequestMethod.GET)
    public Resources<Order> findAll();
}
