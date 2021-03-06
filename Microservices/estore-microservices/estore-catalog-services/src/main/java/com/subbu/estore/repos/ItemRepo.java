package com.subbu.estore.repos;

import com.subbu.estore.entities.Item;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

/**
 * Created by subbu on 21/02/18.
 */
@RepositoryRestResource(collectionResourceRel = "catalog", path = "catalog")
public interface ItemRepo extends PagingAndSortingRepository<Item, Long> {

    public Item findByName(@Param("name") String name);

    public List<Item> findByMeasure(@Param("measure") String measure);

    public Item findByGuid(@Param("guid") String guid);

}
