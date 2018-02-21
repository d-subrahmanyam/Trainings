package com.subbu.estore.services;


import com.subbu.estore.dtos.Item;

import java.util.Collection;
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

    public Item findByName(String name);

    public Collection<Item> findByMeasure(String measure);

    public Item findByGuid(String guid);

    public Collection<Item> all();
}
