package com.subbu.estore.clients;

import com.subbu.estore.dtos.User;
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

@FeignClient(value = "users", url = "http://localhost:8081", path = "/users")
public interface UserClient {

    @RequestMapping(method = RequestMethod.GET)
    public Resources<User> findAll();

    @RequestMapping(method = RequestMethod.GET, path = "search/findByUsername")
    public ResponseEntity<User> findByUsername(@RequestParam("username") String username);
}
