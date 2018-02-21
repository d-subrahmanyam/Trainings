package com.subbu.estore.services.impl;

import com.subbu.estore.clients.CatalogServiceClient;
import com.subbu.estore.dtos.Item;
import com.subbu.estore.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

/**
 * Created by subbu on 19/02/18.
 */
@Service
public class ItemServiceImpl implements ItemService{

    @Autowired
    CatalogServiceClient catalogServiceClient;

    @Override
    public void add(Item item) {
        catalogServiceClient.save(item);
    }

    public void addItems(List<Item> items) {
        catalogServiceClient.save(items);
    }

    @Override
    public void update(Item user) {
        catalogServiceClient.save(user);
    }

    @Override
    public void remove(long id) {
        //catalogServiceClient.delete(id);
    }

    @Override
    public Item get(long id) {
        return null; //catalogServiceClient.getOne(id);
    }

    public Item findByName(String name){
        return catalogServiceClient.findByName(name).getBody();
    }

    public Collection<Item> findByMeasure(String measure) {
        return catalogServiceClient.findByMeasure(measure).getContent();
    }

    public Item findByGuid(String guid) {
        return catalogServiceClient.findByGuid(guid).getBody();
    }

    @Override
    public Collection<Item> all() {
        return null; //catalogServiceClient.findAll();
    }
}
