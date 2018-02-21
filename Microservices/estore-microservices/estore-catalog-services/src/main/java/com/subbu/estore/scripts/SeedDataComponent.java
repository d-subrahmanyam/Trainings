package com.subbu.estore.scripts;

import com.subbu.estore.entities.Item;
import com.subbu.estore.repos.ItemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by subbu on 21/02/18.
 */

@Component
public class SeedDataComponent implements CommandLineRunner {

    @Autowired
    private ItemRepo itemRepo;

    @Override
    public void run(String... strings) throws Exception {
        List<Item> items = items();
        itemRepo.save(items);
    }

    private List<Item> items() {
        List<Item> items = new ArrayList<>();
        Item banana = new Item("banana", "/banana.png", 12.00, "These are special bananas", "Dozen");
        items.add(banana);
        Item apple = new Item("apple", "/apple.png", 12.00, "These are special apples","Dozen");
        items.add(apple);
        Item orange = new Item("orange", "/orange.png", 12.00, "These are special oranges", "Dozen");
        items.add(orange);
        Item pear = new Item("pear", "/pear.png", 12.00, "These are special pears", "Kilo");
        items.add(pear);
        Item grape = new Item("grape", "/grape.png", 12.00, "These are special grapes", "Kilo");
        items.add(grape);
        Item milk = new Item("milk", "/milk.png", 65.00, "Farm fresh cow milk", "Liter");
        items.add(milk);
        return items;
    }
}
