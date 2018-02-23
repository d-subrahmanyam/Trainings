package com.subbu.estore.clients;

import com.subbu.estore.config.FeignConfiguration;
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


//FIXME - Fix the below code the call the ESTORE-GATEWAY-SERVICE instead of the ESTORE-CATALOG-SERVICE directly
@FeignClient(name="ESTORE-GATEWAY-SERVICE", configuration = FeignConfiguration.class, path = "/estore-catalog-service")
public interface CatalogClient {

    @RequestMapping(method = RequestMethod.GET, path = "catalog")
    public Resources<Item> findAll();

    @RequestMapping(method = RequestMethod.GET, path = "catalog/search/findByName")
    public ResponseEntity<Item> findByName(@RequestParam("name") String name);
}
