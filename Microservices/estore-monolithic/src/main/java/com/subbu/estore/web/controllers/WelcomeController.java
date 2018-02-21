package com.subbu.estore.web.controllers;

import com.subbu.estore.dtos.ShoppingCart;
import com.subbu.estore.entities.Item;
import com.subbu.estore.repos.ItemRepo;
import com.subbu.estore.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by subbu on 18/02/18.
 */

@Controller
public class WelcomeController {

    @Autowired
    private ItemService itemService;

    @Autowired
    private ShoppingCart shoppingCart;

    @RequestMapping("/")
    public String welcome(ModelMap model) {
        List<Item> items = itemService.getByMeasure("Dozen");
        model.put("catalog", items);
        model.put("shoppingCart", shoppingCart);
        return "welcome";
    }
}
