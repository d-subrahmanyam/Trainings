package com.subbu.estore.repos;

import com.subbu.estore.entities.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by subbu on 19/02/18.
 */
@Repository
public interface ItemRepo extends JpaRepository<Item, Long> {

    public Item findByName(String name);

    public List<Item> findByMeasure(String measure);
}
