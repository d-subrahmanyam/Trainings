package com.subbu.estore.repos;

import com.subbu.estore.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by subbu on 19/02/18.
 */
@Repository
public interface UserRepo extends JpaRepository<User, Long> {

    public User findByUsername(String username);

    public List<User> findByLastname(String lastname);

    public List<User> findByFirstname(String firstname);
}
