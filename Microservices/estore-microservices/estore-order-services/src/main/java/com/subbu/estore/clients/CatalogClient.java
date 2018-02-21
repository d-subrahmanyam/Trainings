package com.subbu.estore.clients;

import com.subbu.estore.dtos.Item;
import com.subbu.estore.dtos.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.hateoas.Resources;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by subbu on 21/02/18.
 */

@FeignClient(value = "catalog", url = "http://localhost:8082", path = "/catalog")
public interface CatalogClient {

    @RequestMapping(method = RequestMethod.GET)
    public Resources<Item> findAll();

    @RequestMapping(method = RequestMethod.GET, path = "search/findByName")
    public ResponseEntity<Item> findByName(@RequestParam("name") String name);
}
