package com.subbu.estore.repos;

import com.subbu.estore.entities.User;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

/**
 * Created by subbu on 21/02/18.
 */
@RepositoryRestResource(collectionResourceRel = "users", path = "users")
public interface UserRepo extends PagingAndSortingRepository<User, Long> {

    public User findByUsername(@Param("username") String username);

    public List<User> findByFirstname(@Param("firstname") String firstname);

    public List<User> findByLastname(@Param("lastname") String lastname);

    public User findByGuid(@Param("guid") String guid);
}
