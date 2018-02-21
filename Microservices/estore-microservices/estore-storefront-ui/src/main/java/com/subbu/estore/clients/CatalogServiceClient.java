package com.subbu.estore.clients;

import com.subbu.estore.dtos.Item;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.hateoas.Resources;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by subbu on 21/02/18.
 */

@FeignClient(value = "catalog", url = "http://localhost:8082", path = "/catalog", decode404 = true)
public interface CatalogServiceClient {

    @RequestMapping(method = RequestMethod.POST)
    public Item save(Item item);

    @RequestMapping(method = RequestMethod.POST)
    public Resources<Item> save(List<Item> items);

    @RequestMapping(method = RequestMethod.GET, path = "search/findByMeasure")
    public Resources<Item> findByMeasure(@RequestParam("measure") String measure);

    @RequestMapping(method = RequestMethod.GET, path = "search/findByName")
    public ResponseEntity<Item> findByName(@RequestParam("name") String name);

    @RequestMapping(method = RequestMethod.GET, path = "search/findByGuid")
    public ResponseEntity<Item> findByGuid(@RequestParam("guid") String guid);

}
