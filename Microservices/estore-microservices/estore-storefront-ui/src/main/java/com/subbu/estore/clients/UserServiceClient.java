package com.subbu.estore.clients;

import com.subbu.estore.dtos.User;
import com.subbu.estore.exceptions.UserNotFoundException;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.hateoas.Resources;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by subbu on 21/02/18.
 */

@FeignClient(value = "users", url = "http://localhost:8081", path = "/users", decode404 = true)
public interface UserServiceClient {

    @RequestMapping(method = RequestMethod.POST)
    public User save(User user);

    @RequestMapping(method = RequestMethod.GET, path = "search/findByUsername")
    public ResponseEntity<User> findByUsername(@RequestParam("username") String username) throws UserNotFoundException;

    @RequestMapping(method = RequestMethod.GET, path = "search/findByGuid")
    public ResponseEntity<User> findByGuid(@RequestParam("guid") String guid);

    @RequestMapping(method = RequestMethod.GET, path = "search/findByFirstname")
    public Resources<User> findByFirstname(@RequestParam("firstname") String firstname);

    @RequestMapping(method = RequestMethod.GET, path = "search/findByLastname")
    public Resources<User> findByLastname(@RequestParam("lastname") String lastname);

    @RequestMapping(method = RequestMethod.GET)
    public Resources<User> findAll();
}
