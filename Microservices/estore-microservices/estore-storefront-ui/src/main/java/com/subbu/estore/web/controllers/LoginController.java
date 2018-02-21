package com.subbu.estore.web.controllers;

import com.subbu.estore.dtos.ShoppingCart;
import com.subbu.estore.dtos.User;
import com.subbu.estore.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by subbu on 20/02/18.
 */

@Controller
public class LoginController {

    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private UserService userService;

    @Autowired
    private ShoppingCart shoppingCart;

    @GetMapping("/login")
    public String showLogin(ModelMap model) {
        model.put("shoppingCart", shoppingCart);
        String view = "login";
        if(shoppingCart.getUser()!=null) {
            view = "welcome";
        }
        return view;
    }

    @GetMapping("/logout")
    public String logout(ModelMap model) {
        shoppingCart.reset();
        model.put("shoppingCart", shoppingCart);
        return "redirect:/";
    }

    @PostMapping("/authenticate")
    public String authenticate(ModelMap model, @RequestParam("username") String username, @RequestParam("password") String password) {
        String view = "redirect:/";
        User user = userService.authenticate(username, password);
        model.put("shoppingCart", shoppingCart);
        if(user == null) {
            view = "login";
            model.put("loginMessage", "InvalidUser");
        } else {
            logger.info("User {}", user);
            shoppingCart.setUser(user);
        }
        return view;
    }

    @PostMapping("/register")
    public String register(ModelMap model, @RequestParam("username") String username, @RequestParam("password") String password) {
        String view = "login";
        User _user = new User(username, password);
        if(userService.add(_user)==null){
            model.put("errorMessage", "1");
        } else {
            model.put("errorMessage", "2");
        }
        return view;
    }
}
