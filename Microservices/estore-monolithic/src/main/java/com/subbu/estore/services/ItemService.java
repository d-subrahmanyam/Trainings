package com.subbu.estore.services;

import com.subbu.estore.entities.Item;

import java.util.List;

/**
 * Created by subbu on 19/02/18.
 */
public interface ItemService {

    public void add(Item item);

    public void addItems(List<Item> items);

    public void update(Item item);

    public void remove(long id);

    public Item get(long id);

    public Item getByName(String name);

    public List<Item> getByMeasure(String measure);

    public List<Item> all();
}
