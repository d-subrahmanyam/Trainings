package com.subbu.estore.services.impl;

import com.subbu.estore.entities.Item;
import com.subbu.estore.repos.ItemRepo;
import com.subbu.estore.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by subbu on 19/02/18.
 */
@Service
@Transactional
public class ItemServiceImpl implements ItemService{

    @Autowired
    ItemRepo itemRepo;

    @Override
    public void add(Item item) {
        itemRepo.save(item);
    }

    public void addItems(List<Item> items) {
        itemRepo.saveAll(items);
    }

    @Override
    public void update(Item user) {
        itemRepo.save(user);
    }

    @Override
    public void remove(long id) {
        itemRepo.deleteById(id);
    }

    @Override
    public Item get(long id) {
        return itemRepo.getOne(id);
    }

    public Item getByName(String name){
        return itemRepo.findByName(name);
    }

    public List<Item> getByMeasure(String measure) {
        return itemRepo.findByMeasure(measure);
    }

    @Override
    public List<Item> all() {
        return itemRepo.findAll();
    }
}
