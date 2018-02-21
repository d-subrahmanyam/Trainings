package com.subbu.estore.services;


import com.subbu.estore.dtos.User;
import com.subbu.estore.exceptions.UserNotFoundException;

import java.util.Collection;

/**
 * Created by subbu on 19/02/18.
 */
public interface UserService {

    public User add(User item);

    public void update(User item);

    public void remove(long id);

    public  User get(long id);

    public User findByUsername(String username) throws UserNotFoundException;

    public User findByGuid(String guid) throws UserNotFoundException;

    public Collection<User> findByFirstname(String firstname);

    public Collection<User> findByLastname(String lastname);

    public Collection<User> all();

    public User authenticate(String username, String password);
}
