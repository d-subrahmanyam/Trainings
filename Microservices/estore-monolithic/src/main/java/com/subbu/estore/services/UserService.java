package com.subbu.estore.services;

import com.subbu.estore.entities.User;

import java.util.List;

/**
 * Created by subbu on 19/02/18.
 */
public interface UserService {

    public User add(User item);

    public void update(User item);

    public void remove(long id);

    public  User get(long id);

    public User getByUsername(String username);

    public List<User> getByFirstname(String firstname);

    public List<User> getByLastname(String lastname);

    public List<User> all();

    public User authenticate(String username, String password);
}
