package com.subbu.estore.clients;

import com.subbu.estore.config.FeignConfiguration;
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

//FIXME - Fix the below code the call the ESTORE-GATEWAY-SERVICE instead of the ESTORE-CATALOG-SERVICE directly
@FeignClient(name = "ESTORE-GATEWAY-SERVICE", path = "/estore-user-services", configuration = FeignConfiguration.class)
public interface UserClient {

    @RequestMapping(method = RequestMethod.GET, path = "users")
    public Resources<User> findAll();

    @RequestMapping(method = RequestMethod.GET, path = "users/search/findByUsername")
    public ResponseEntity<User> findByUsername(@RequestParam("username") String username);
}
